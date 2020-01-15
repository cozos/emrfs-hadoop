package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.utils;

public class NameMap
  extends FluentHashMap<String, String>
{
  private static final long serialVersionUID = 1L;
  
  public NameMap with(String key, String value)
  {
    super.put(key, value);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.utils.NameMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */