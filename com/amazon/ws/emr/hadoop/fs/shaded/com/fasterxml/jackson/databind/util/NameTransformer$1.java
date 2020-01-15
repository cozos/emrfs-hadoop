package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

final class NameTransformer$1
  extends NameTransformer
{
  NameTransformer$1(String paramString1, String paramString2) {}
  
  public String transform(String name)
  {
    return val$prefix + name + val$suffix;
  }
  
  public String reverse(String transformed)
  {
    if (transformed.startsWith(val$prefix))
    {
      String str = transformed.substring(val$prefix.length());
      if (str.endsWith(val$suffix)) {
        return str.substring(0, str.length() - val$suffix.length());
      }
    }
    return null;
  }
  
  public String toString()
  {
    return "[PreAndSuffixTransformer('" + val$prefix + "','" + val$suffix + "')]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */