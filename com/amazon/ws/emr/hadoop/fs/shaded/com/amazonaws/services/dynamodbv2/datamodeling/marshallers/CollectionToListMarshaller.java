package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.ListAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionToListMarshaller
  implements ArgumentMarshaller.ListAttributeMarshaller
{
  private static final CollectionToListMarshaller INSTANCE = new CollectionToListMarshaller();
  private final ArgumentMarshaller memberMarshaller;
  
  public static CollectionToListMarshaller instance()
  {
    return INSTANCE;
  }
  
  private CollectionToListMarshaller()
  {
    this(null);
  }
  
  public CollectionToListMarshaller(ArgumentMarshaller memberMarshaller)
  {
    this.memberMarshaller = memberMarshaller;
  }
  
  public AttributeValue marshall(Object obj)
  {
    if (memberMarshaller == null) {
      throw new IllegalStateException("No member marshaller configured!");
    }
    Collection<?> objects = (Collection)obj;
    
    List<AttributeValue> values = new ArrayList(objects.size());
    for (Object o : objects)
    {
      AttributeValue value;
      AttributeValue value;
      if (o == null) {
        value = new AttributeValue().withNULL(Boolean.valueOf(true));
      } else {
        value = memberMarshaller.marshall(o);
      }
      values.add(value);
    }
    AttributeValue result = new AttributeValue();
    result.setL(values);
    return result;
  }
  
  public ArgumentMarshaller getMemberMarshaller()
  {
    return memberMarshaller;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.CollectionToListMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */