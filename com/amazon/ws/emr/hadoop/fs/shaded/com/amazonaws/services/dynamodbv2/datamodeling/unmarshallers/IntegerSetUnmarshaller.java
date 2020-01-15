package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.HashSet;
import java.util.Set;

public class IntegerSetUnmarshaller
  extends NSUnmarshaller
{
  private static final IntegerSetUnmarshaller INSTANCE = new IntegerSetUnmarshaller();
  
  public static IntegerSetUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public Object unmarshall(AttributeValue value)
  {
    Set<Integer> result = new HashSet();
    for (String s : value.getNS()) {
      result.add(Integer.valueOf(s));
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.IntegerSetUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */