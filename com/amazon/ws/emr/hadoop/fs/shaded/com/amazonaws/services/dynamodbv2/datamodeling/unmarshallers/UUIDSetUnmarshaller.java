package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UUIDSetUnmarshaller
  extends SSUnmarshaller
{
  private static final UUIDSetUnmarshaller INSTANCE = new UUIDSetUnmarshaller();
  
  public static UUIDSetUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public Set<UUID> unmarshall(AttributeValue value)
  {
    Set<UUID> result = new HashSet();
    for (String s : value.getSS()) {
      result.add(UUID.fromString(s));
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.UUIDSetUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */