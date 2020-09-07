package com.efx.ews.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.cloud.Timestamp;

@JsonInclude(Include.NON_NULL)
public class Job {
  private String id;
  private String clientName;
  private Long alloction;
  private Long startNumber;
  private Long endNumber;
  private Timestamp allocationDate;
  private String message;


  public Job() {
  }

  public Job(String id, String clientName, Long alloction, Long startNumber, Long endNumber, Timestamp allocationDate, String message) {
    this.id = id;
    this.clientName = clientName;
    this.alloction = alloction;
    this.startNumber = startNumber;
    this.endNumber = endNumber;
    this.allocationDate = allocationDate;
    this.message = message;
  }

  public Job(String id, String clientName, Long alloction, Long startNumber, Long endNumber, Timestamp allocationDate) {
    this.id = id;
    this.clientName = clientName;
    this.alloction = alloction;
    this.startNumber = startNumber;
    this.endNumber = endNumber;
    this.allocationDate = allocationDate;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getClientName() {
    return this.clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public Long getAlloction() {
    return this.alloction;
  }

  public void setAlloction(Long alloction) {
    this.alloction = alloction;
  }

  public Long getStartNumber() {
    return this.startNumber;
  }

  public void setStartNumber(Long startNumber) {
    this.startNumber = startNumber;
  }

  public Long getEndNumber() {
    return this.endNumber;
  }

  public void setEndNumber(Long endNumber) {
    this.endNumber = endNumber;
  }

  public Timestamp getAllocationDate() {
    return this.allocationDate;
  }

  public void setAllocationDate(Timestamp allocationDate) {
    this.allocationDate = allocationDate;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Job id(String id) {
    this.id = id;
    return this;
  }

  public Job clientName(String clientName) {
    this.clientName = clientName;
    return this;
  }

  public Job alloction(Long alloction) {
    this.alloction = alloction;
    return this;
  }

  public Job startNumber(Long startNumber) {
    this.startNumber = startNumber;
    return this;
  }

  public Job endNumber(Long endNumber) {
    this.endNumber = endNumber;
    return this;
  }

  public Job allocationDate(Timestamp allocationDate) {
    this.allocationDate = allocationDate;
    return this;
  }

  public Job message(String message) {
    this.message = message;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Job)) {
            return false;
        }
        Job job = (Job) o;
        return Objects.equals(id, job.id) && Objects.equals(clientName, job.clientName) && Objects.equals(alloction, job.alloction) && Objects.equals(startNumber, job.startNumber) && Objects.equals(endNumber, job.endNumber) && Objects.equals(allocationDate, job.allocationDate) && Objects.equals(message, job.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, clientName, alloction, startNumber, endNumber, allocationDate, message);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", clientName='" + getClientName() + "'" +
      ", alloction='" + getAlloction() + "'" +
      ", startNumber='" + getStartNumber() + "'" +
      ", endNumber='" + getEndNumber() + "'" +
      ", allocationDate='" + getAllocationDate() + "'" +
      ", message='" + getMessage() + "'" +
      "}";
  }



}