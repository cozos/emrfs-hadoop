package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.MapAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapToMapMarshaller
  implements ArgumentMarshaller.MapAttributeMarshaller
{
  private static final MapToMapMarshaller INSTANCE = new MapToMapMarshaller();
  private final ArgumentMarshaller memberMarshaller;
  
  public static MapToMapMarshaller instance()
  {
    return INSTANCE;
  }
  
  private MapToMapMarshaller()
  {
    memberMarshaller = null;
  }
  
  public MapToMapMarshaller(ArgumentMarshaller memberMarshaller)
  {
    if (memberMarshaller == null) {
      throw new NullPointerException("memberMarshaller");
    }
    this.memberMarshaller = memberMarshaller;
  }
  
  public AttributeValue marshall(Object obj)
  {
    if (memberMarshaller == null) {
      throw new IllegalStateException("No member marshaller configured!");
    }
    Map<String, ?> map = (Map)obj;
    Map<String, AttributeValue> values = new HashMap();
    for (Map.Entry<String, ?> entry : map.entrySet())
    {
      AttributeValue value;
      AttributeValue value;
      if (entry.getValue() == null) {
        value = new AttributeValue().withNULL(Boolean.valueOf(true));
      } else {
        value = memberMarshaller.marshall(entry.getValue());
      }
      values.put(entry.getKey(), value);
    }
    AttributeValue result = new AttributeValue();
    result.setM(values);
    return result;
  }
  
  public ArgumentMarshaller getMemberMarshaller()
  {
    return memberMarshaller;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.MapToMapMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */