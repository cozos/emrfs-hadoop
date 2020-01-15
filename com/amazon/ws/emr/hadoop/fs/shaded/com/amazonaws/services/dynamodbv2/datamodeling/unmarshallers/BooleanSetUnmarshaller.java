package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BooleanSetUnmarshaller
  implements ArgumentUnmarshaller
{
  private static final BooleanSetUnmarshaller INSTANCE = new BooleanSetUnmarshaller();
  
  public static BooleanSetUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public void typeCheck(AttributeValue value, Method setter)
  {
    if ((value.getNS() == null) && (value.getL() == null)) {
      throw new DynamoDBMappingException("Expected either L or NS in value " + value + " when invoking " + setter);
    }
  }
  
  public Object unmarshall(AttributeValue value)
  {
    if (value.getL() != null) {
      return unmarshallList(value.getL());
    }
    return unmarshallNS(value.getNS());
  }
  
  private Set<Boolean> unmarshallList(List<AttributeValue> values)
  {
    Set<Boolean> result = new HashSet();
    for (AttributeValue value : values)
    {
      Boolean bool;
      Boolean bool;
      if (Boolean.TRUE.equals(value.isNULL()))
      {
        bool = null;
      }
      else
      {
        bool = value.getBOOL();
        if (bool == null) {
          throw new DynamoDBMappingException(value + " is not a boolean");
        }
      }
      if (!result.add(bool)) {
        throw new DynamoDBMappingException("Duplicate value (" + bool + ") found in " + values);
      }
    }
    return result;
  }
  
  private Set<Boolean> unmarshallNS(List<String> values)
  {
    Set<Boolean> result = new HashSet();
    for (String s : values) {
      if ("1".equals(s)) {
        result.add(Boolean.TRUE);
      } else if ("0".equals(s)) {
        result.add(Boolean.FALSE);
      } else {
        throw new IllegalArgumentException("Expected '1' or '0' for boolean value, was " + s);
      }
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.BooleanSetUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */