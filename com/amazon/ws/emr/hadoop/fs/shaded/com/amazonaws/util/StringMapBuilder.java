package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

public class StringMapBuilder
  extends ImmutableMapParameter.Builder<String, String>
{
  public StringMapBuilder() {}
  
  public StringMapBuilder(String key, String value)
  {
    super.put(key, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringMapBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */