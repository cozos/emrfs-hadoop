package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

public class JsonParseException
  extends RuntimeException
{
  static final long serialVersionUID = -4086729973971783390L;
  
  public JsonParseException(String msg)
  {
    super(msg);
  }
  
  public JsonParseException(String msg, Throwable cause)
  {
    super(msg, cause);
  }
  
  public JsonParseException(Throwable cause)
  {
    super(cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonParseException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */