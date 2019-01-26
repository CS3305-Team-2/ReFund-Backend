package com.bestteam.helpers;

import java.time.Instant;

public class Error {
  private Instant timestamp;
  private String message;

  public Error(String message) {
    this.timestamp = Instant.now();
    this.message = message;
  }

  public Instant getTimestamp() {
    return timestamp;
  }
  
  public String getMessage() {
    return message;
  }  
}