package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

public class JsonGenerationException
  extends JsonProcessingException
{
  private static final long serialVersionUID = 123L;
  
  public JsonGenerationException(Throwable rootCause)
  {
    super(rootCause);
  }
  
  public JsonGenerationException(String msg)
  {
    super(msg, (JsonLocation)null);
  }
  
  public JsonGenerationException(String msg, Throwable rootCause)
  {
    super(msg, null, rootCause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */