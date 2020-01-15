package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ObjectSetUnmarshaller
  extends LUnmarshaller
{
  private static final ObjectSetUnmarshaller INSTANCE = new ObjectSetUnmarshaller();
  private final ArgumentUnmarshaller memberUnmarshaller;
  
  public static ObjectSetUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  private ObjectSetUnmarshaller()
  {
    memberUnmarshaller = null;
  }
  
  public ObjectSetUnmarshaller(ArgumentUnmarshaller memberUnmarshaller)
  {
    if (memberUnmarshaller == null) {
      throw new NullPointerException("memberUnmarshaller");
    }
    this.memberUnmarshaller = memberUnmarshaller;
  }
  
  public Object unmarshall(AttributeValue value)
    throws ParseException
  {
    List<AttributeValue> values = value.getL();
    
    int size = Math.max(values.size() * 2, 11);
    Set<Object> objects = new LinkedHashSet(size);
    for (AttributeValue v : values)
    {
      memberUnmarshaller.typeCheck(v, null);
      Object o = memberUnmarshaller.unmarshall(v);
      if (!objects.add(o)) {
        throw new DynamoDBMappingException("Duplicate value (" + o + ") found in " + values);
      }
    }
    return objects;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ObjectSetUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */