package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.StringSetAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StringSetToStringSetMarshaller
  implements ArgumentMarshaller.StringSetAttributeMarshaller
{
  private static final StringSetToStringSetMarshaller INSTANCE = new StringSetToStringSetMarshaller();
  
  public static StringSetToStringSetMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    Set<String> set = (Set)obj;
    
    List<String> strings = new ArrayList(set.size());
    for (String s : set) {
      strings.add(s);
    }
    return new AttributeValue().withSS(strings);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.StringSetToStringSetMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */