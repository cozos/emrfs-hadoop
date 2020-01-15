package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.HashSet;
import java.util.Set;

public class DoubleSetUnmarshaller
  extends NSUnmarshaller
{
  private static final DoubleSetUnmarshaller INSTANCE = new DoubleSetUnmarshaller();
  
  public static DoubleSetUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public Object unmarshall(AttributeValue value)
  {
    Set<Double> result = new HashSet();
    for (String s : value.getNS()) {
      result.add(Double.valueOf(s));
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.DoubleSetUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */