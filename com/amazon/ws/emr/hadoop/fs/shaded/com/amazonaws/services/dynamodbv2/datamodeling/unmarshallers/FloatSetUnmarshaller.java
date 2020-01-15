package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.HashSet;
import java.util.Set;

public class FloatSetUnmarshaller
  extends NSUnmarshaller
{
  private static final FloatSetUnmarshaller INSTANCE = new FloatSetUnmarshaller();
  
  public static FloatSetUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public Object unmarshall(AttributeValue value)
  {
    Set<Float> result = new HashSet();
    for (String s : value.getNS()) {
      result.add(Float.valueOf(s));
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.FloatSetUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */