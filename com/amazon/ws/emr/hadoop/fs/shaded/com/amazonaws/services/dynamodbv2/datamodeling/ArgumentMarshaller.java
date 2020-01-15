package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

public abstract interface ArgumentMarshaller
{
  public abstract AttributeValue marshall(Object paramObject);
  
  public static abstract interface MapAttributeMarshaller
    extends ArgumentMarshaller
  {}
  
  public static abstract interface ListAttributeMarshaller
    extends ArgumentMarshaller
  {}
  
  public static abstract interface BinarySetAttributeMarshaller
    extends ArgumentMarshaller
  {}
  
  public static abstract interface NumberSetAttributeMarshaller
    extends ArgumentMarshaller
  {}
  
  public static abstract interface StringSetAttributeMarshaller
    extends ArgumentMarshaller
  {}
  
  public static abstract interface BinaryAttributeMarshaller
    extends ArgumentMarshaller
  {}
  
  public static abstract interface NumberAttributeMarshaller
    extends ArgumentMarshaller
  {}
  
  public static abstract interface StringAttributeMarshaller
    extends ArgumentMarshaller
  {}
  
  public static abstract interface BooleanAttributeMarshaller
    extends ArgumentMarshaller
  {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */