package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapUnmarshaller
  extends MUnmarshaller
{
  private static final MapUnmarshaller INSTANCE = new MapUnmarshaller();
  private final ArgumentUnmarshaller memberUnmarshaller;
  
  public static MapUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  private MapUnmarshaller()
  {
    memberUnmarshaller = null;
  }
  
  public MapUnmarshaller(ArgumentUnmarshaller memberUnmarshaller)
  {
    if (memberUnmarshaller == null) {
      throw new NullPointerException("memberUnmarshaller");
    }
    this.memberUnmarshaller = memberUnmarshaller;
  }
  
  public Object unmarshall(AttributeValue value)
    throws ParseException
  {
    Map<String, AttributeValue> map = value.getM();
    Map<String, Object> result = new HashMap();
    for (Map.Entry<String, AttributeValue> entry : map.entrySet())
    {
      memberUnmarshaller.typeCheck((AttributeValue)entry.getValue(), null);
      result.put(entry.getKey(), memberUnmarshaller
        .unmarshall((AttributeValue)entry.getValue()));
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.MapUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */