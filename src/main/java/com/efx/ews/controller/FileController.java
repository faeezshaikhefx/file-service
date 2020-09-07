package com.efx.ews.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")

public class FileController {
  private static final Logger logger = LoggerFactory.getLogger(FileController.class);

  @Value("${app.projectId}")
  private String projectId;
  @Value("${app.bucketName}")
  private String bucketName;


  public static final String HELLO = "/api/v1/tboc/updload";
  @PostConstruct
  public void init() {

  }


	@RequestMapping(value = HELLO, method = RequestMethod.POST, consumes = {"multipart/form-data" })
	public String uploadAndEncode(@RequestParam MultipartFile file)
			throws IOException {

        logger.info("Request received..");
        // The ID of your GCS object
        String objectName = "sample-op.txt";
        
        // The path to your file to upload
        String filePath = "src/main/resources/sample.txt";
        
        uploadObject(projectId,bucketName,objectName,filePath,file);
        logger.info("Upload complete..");
  return "Upload successfull";

	}



  public static void uploadObject(
    String projectId, String bucketName, String objectName, String filePath,MultipartFile file) throws IOException {
 

  Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
  BlobId blobId = BlobId.of(bucketName, objectName);
  BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
  Path filepath = Paths.get(System.getProperty("java.io.tmpdir").toString(), file.getOriginalFilename());
  file.transferTo(filepath);
  storage.create(blobInfo, Files.readAllBytes(Paths.get(filePath)));
  logger.info("File name {}..",file.getOriginalFilename());
  logger.info("File size {}..",file.getSize());

  System.out.println(
      "File " + filePath + " uploaded to bucket " + bucketName + " as " + objectName);
}

}
