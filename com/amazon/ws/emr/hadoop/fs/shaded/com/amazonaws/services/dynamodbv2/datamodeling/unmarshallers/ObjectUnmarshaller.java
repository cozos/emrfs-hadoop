package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ItemConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.text.ParseException;
import java.util.Map;

public class ObjectUnmarshaller
  extends MUnmarshaller
{
  private static final ObjectUnmarshaller INSTANCE = new ObjectUnmarshaller();
  private final ItemConverter converter;
  private final Class<?> clazz;
  
  public static ObjectUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  private ObjectUnmarshaller()
  {
    converter = null;
    clazz = null;
  }
  
  public ObjectUnmarshaller(ItemConverter converter, Class<?> clazz)
  {
    if (converter == null) {
      throw new NullPointerException("converter");
    }
    if (clazz == null) {
      throw new NullPointerException("clazz");
    }
    this.converter = converter;
    this.clazz = clazz;
  }
  
  public Object unmarshall(AttributeValue value)
    throws ParseException
  {
    Map<String, AttributeValue> map = value.getM();
    return converter.unconvert(clazz, map);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ObjectUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */