package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.NumberSetAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NumberSetToNumberSetMarshaller
  implements ArgumentMarshaller.NumberSetAttributeMarshaller
{
  private static final NumberSetToNumberSetMarshaller INSTANCE = new NumberSetToNumberSetMarshaller();
  
  public static NumberSetToNumberSetMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    Set<? extends Number> numbers = (Set)obj;
    List<String> numberAttributes = new ArrayList(numbers.size());
    for (Number n : numbers) {
      numberAttributes.add(n.toString());
    }
    return new AttributeValue().withNS(numberAttributes);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.NumberSetToNumberSetMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */