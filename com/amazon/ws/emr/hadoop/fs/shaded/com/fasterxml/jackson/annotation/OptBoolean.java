package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

public enum OptBoolean
{
  TRUE,  FALSE,  DEFAULT;
  
  private OptBoolean() {}
  
  public Boolean asBoolean()
  {
    if (this == DEFAULT) {
      return null;
    }
    return this == TRUE ? Boolean.TRUE : Boolean.FALSE;
  }
  
  public boolean asPrimitive()
  {
    return this == TRUE;
  }
  
  public static OptBoolean fromBoolean(Boolean b)
  {
    if (b == null) {
      return DEFAULT;
    }
    return b.booleanValue() ? TRUE : FALSE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.OptBoolean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */