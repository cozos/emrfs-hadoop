package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

import java.io.IOException;

public class JsonProcessingException
  extends IOException
{
  static final long serialVersionUID = 123L;
  protected JsonLocation _location;
  
  protected JsonProcessingException(String msg, JsonLocation loc, Throwable rootCause)
  {
    super(msg);
    if (rootCause != null) {
      initCause(rootCause);
    }
    _location = loc;
  }
  
  protected JsonProcessingException(String msg)
  {
    super(msg);
  }
  
  protected JsonProcessingException(String msg, JsonLocation loc)
  {
    this(msg, loc, null);
  }
  
  protected JsonProcessingException(String msg, Throwable rootCause)
  {
    this(msg, null, rootCause);
  }
  
  protected JsonProcessingException(Throwable rootCause)
  {
    this(null, null, rootCause);
  }
  
  public JsonLocation getLocation()
  {
    return _location;
  }
  
  public String getOriginalMessage()
  {
    return super.getMessage();
  }
  
  protected String getMessageSuffix()
  {
    return null;
  }
  
  public String getMessage()
  {
    String msg = super.getMessage();
    if (msg == null) {
      msg = "N/A";
    }
    JsonLocation loc = getLocation();
    String suffix = getMessageSuffix();
    if ((loc != null) || (suffix != null))
    {
      StringBuilder sb = new StringBuilder(100);
      sb.append(msg);
      if (suffix != null) {
        sb.append(suffix);
      }
      if (loc != null)
      {
        sb.append('\n');
        sb.append(" at ");
        sb.append(loc.toString());
      }
      msg = sb.toString();
    }
    return msg;
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + getMessage();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */