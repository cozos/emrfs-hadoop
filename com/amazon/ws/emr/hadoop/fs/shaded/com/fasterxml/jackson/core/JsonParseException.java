package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

public class JsonParseException
  extends JsonProcessingException
{
  private static final long serialVersionUID = 1L;
  
  public JsonParseException(String msg, JsonLocation loc)
  {
    super(msg, loc);
  }
  
  public JsonParseException(String msg, JsonLocation loc, Throwable root)
  {
    super(msg, loc, root);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */