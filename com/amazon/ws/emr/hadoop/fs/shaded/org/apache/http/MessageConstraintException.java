package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

import java.nio.charset.CharacterCodingException;

public class MessageConstraintException
  extends CharacterCodingException
{
  private static final long serialVersionUID = 6077207720446368695L;
  private final String message;
  
  public MessageConstraintException(String message)
  {
    this.message = message;
  }
  
  public String getMessage()
  {
    return message;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.MessageConstraintException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */