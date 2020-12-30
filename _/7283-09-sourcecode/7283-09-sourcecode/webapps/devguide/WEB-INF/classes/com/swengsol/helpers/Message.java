package com.swengsol.helpers;

public class Message {
  private static int num = 0;
  private String text;
  public void setMessage(String text) {
    this.text = text;
  }
  public String getMessage() {
    return text + " - " + Integer.toString(num++);
  }
}
