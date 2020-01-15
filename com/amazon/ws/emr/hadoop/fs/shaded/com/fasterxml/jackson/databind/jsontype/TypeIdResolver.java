package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DatabindContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;

public abstract interface TypeIdResolver
{
  public abstract void init(JavaType paramJavaType);
  
  public abstract String idFromValue(Object paramObject);
  
  public abstract String idFromValueAndType(Object paramObject, Class<?> paramClass);
  
  public abstract String idFromBaseType();
  
  @Deprecated
  public abstract JavaType typeFromId(String paramString);
  
  public abstract JavaType typeFromId(DatabindContext paramDatabindContext, String paramString);
  
  public abstract JsonTypeInfo.Id getMechanism();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeIdResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */