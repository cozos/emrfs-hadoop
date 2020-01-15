package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

final class NameTransformer$3
  extends NameTransformer
{
  NameTransformer$3(String paramString) {}
  
  public String transform(String name)
  {
    return name + val$suffix;
  }
  
  public String reverse(String transformed)
  {
    if (transformed.endsWith(val$suffix)) {
      return transformed.substring(0, transformed.length() - val$suffix.length());
    }
    return null;
  }
  
  public String toString()
  {
    return "[SuffixTransformer('" + val$suffix + "')]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */