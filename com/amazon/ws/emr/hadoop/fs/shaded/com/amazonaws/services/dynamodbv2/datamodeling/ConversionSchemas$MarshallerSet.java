package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

abstract interface ConversionSchemas$MarshallerSet
{
  public abstract ArgumentMarshaller getMarshaller(Method paramMethod);
  
  public abstract ArgumentMarshaller getMemberMarshaller(Type paramType);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.MarshallerSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */