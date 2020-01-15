package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.StringSetAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class UUIDSetToStringSetMarshaller
  implements ArgumentMarshaller.StringSetAttributeMarshaller
{
  private static final UUIDSetToStringSetMarshaller INSTANCE = new UUIDSetToStringSetMarshaller();
  
  public static UUIDSetToStringSetMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    Set<UUID> uuids = (Set)obj;
    
    List<String> strings = new ArrayList(uuids.size());
    for (UUID uuid : uuids) {
      strings.add(uuid.toString());
    }
    return new AttributeValue().withSS(strings);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.UUIDSetToStringSetMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */