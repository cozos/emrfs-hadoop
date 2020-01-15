package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

final class NameTransformer$2
  extends NameTransformer
{
  NameTransformer$2(String paramString) {}
  
  public String transform(String name)
  {
    return val$prefix + name;
  }
  
  public String reverse(String transformed)
  {
    if (transformed.startsWith(val$prefix)) {
      return transformed.substring(val$prefix.length());
    }
    return null;
  }
  
  public String toString()
  {
    return "[PrefixTransformer('" + val$prefix + "')]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */