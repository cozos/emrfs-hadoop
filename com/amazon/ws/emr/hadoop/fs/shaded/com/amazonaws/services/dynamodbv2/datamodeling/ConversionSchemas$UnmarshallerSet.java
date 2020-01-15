package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

abstract interface ConversionSchemas$UnmarshallerSet
{
  public abstract ArgumentUnmarshaller getUnmarshaller(Method paramMethod1, Method paramMethod2);
  
  public abstract ArgumentUnmarshaller getMemberUnmarshaller(Type paramType);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.UnmarshallerSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */