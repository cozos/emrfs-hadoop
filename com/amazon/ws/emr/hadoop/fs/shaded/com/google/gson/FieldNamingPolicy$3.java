package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import java.lang.reflect.Field;

 enum FieldNamingPolicy$3
{
  FieldNamingPolicy$3()
  {
    super(paramString, paramInt, null);
  }
  
  public String translateName(Field f)
  {
    return FieldNamingPolicy.access$100(FieldNamingPolicy.access$200(f.getName(), " "));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.FieldNamingPolicy.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */