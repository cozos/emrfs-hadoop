package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.NumberSetAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BooleanSetToNumberSetMarshaller
  implements ArgumentMarshaller.NumberSetAttributeMarshaller
{
  private static final BooleanSetToNumberSetMarshaller INSTANCE = new BooleanSetToNumberSetMarshaller();
  
  public static BooleanSetToNumberSetMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    Set<Boolean> booleans = (Set)obj;
    List<String> booleanAttributes = new ArrayList(booleans.size());
    for (Boolean b : booleans) {
      if ((b == null) || (!b.booleanValue())) {
        booleanAttributes.add("0");
      } else {
        booleanAttributes.add("1");
      }
    }
    return new AttributeValue().withNS(booleanAttributes);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.BooleanSetToNumberSetMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */