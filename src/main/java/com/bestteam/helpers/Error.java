package com.bestteam.helpers;

import java.time.Instant;

public class Error {
  private Instant timestamp;
  private String[] errors;

  public Error(String[] errors) {
    this.timestamp = Instant.now();
    this.errors = errors;
  }

  public Instant getTimestamp() {
    return timestamp;
  }
  
  public String[] getErrors() {
    return errors;
  }  
}