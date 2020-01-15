package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import java.lang.reflect.Field;

 enum FieldNamingPolicy$1
{
  FieldNamingPolicy$1()
  {
    super(paramString, paramInt, null);
  }
  
  public String translateName(Field f)
  {
    return f.getName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.FieldNamingPolicy.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */