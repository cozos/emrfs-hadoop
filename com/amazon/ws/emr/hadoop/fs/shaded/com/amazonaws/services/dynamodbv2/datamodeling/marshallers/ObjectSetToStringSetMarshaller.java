package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.StringSetAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ObjectSetToStringSetMarshaller
  implements ArgumentMarshaller.StringSetAttributeMarshaller
{
  private static final Log LOG = LogFactory.getLog(ObjectSetToStringSetMarshaller.class);
  private static final ObjectSetToStringSetMarshaller INSTANCE = new ObjectSetToStringSetMarshaller();
  
  public static ObjectSetToStringSetMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    Set<?> set = (Set)obj;
    
    LOG.warn("Marshaling a set of non-String objects to a DynamoDB StringSet. You won't be able to read these objects back out of DynamoDB unless you REALLY know what you're doing: it's probably a bug. If you DO know what you're doing feelfree to ignore this warning, but consider using a custom marshaler for this instead.");
    
    List<String> strings = new ArrayList(set.size());
    for (Object o : set) {
      strings.add(String.valueOf(o));
    }
    return new AttributeValue().withSS(strings);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ObjectSetToStringSetMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */