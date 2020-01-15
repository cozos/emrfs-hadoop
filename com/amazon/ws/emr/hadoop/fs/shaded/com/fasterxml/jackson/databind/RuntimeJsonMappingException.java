package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

public class RuntimeJsonMappingException
  extends RuntimeException
{
  public RuntimeJsonMappingException(JsonMappingException cause)
  {
    super(cause);
  }
  
  public RuntimeJsonMappingException(String message)
  {
    super(message);
  }
  
  public RuntimeJsonMappingException(String message, JsonMappingException cause)
  {
    super(message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.RuntimeJsonMappingException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */