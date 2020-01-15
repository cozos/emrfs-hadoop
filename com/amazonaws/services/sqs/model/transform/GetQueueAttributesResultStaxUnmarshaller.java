package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import java.util.Map.Entry;
import javax.xml.stream.events.XMLEvent;

public class GetQueueAttributesResultStaxUnmarshaller
  implements Unmarshaller<GetQueueAttributesResult, StaxUnmarshallerContext>
{
  private static GetQueueAttributesResultStaxUnmarshaller instance;
  
  private static class AttributesMapEntryUnmarshaller
    implements Unmarshaller<Map.Entry<String, String>, StaxUnmarshallerContext>
  {
    private static AttributesMapEntryUnmarshaller instance;
    
    public Map.Entry<String, String> unmarshall(StaxUnmarshallerContext context)
      throws Exception
    {
      int originalDepth = context.getCurrentDepth();
      int targetDepth = originalDepth + 1;
      
      MapEntry<String, String> entry = new MapEntry();
      for (;;)
      {
        XMLEvent xmlEvent = context.nextEvent();
        if (xmlEvent.isEndDocument()) {
          return entry;
        }
        if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
        {
          if (context.testExpression("Name", targetDepth)) {
            entry.setKey(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
          } else if (context.testExpression("Value", targetDepth)) {
            entry.setValue(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
          }
        }
        else if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return entry;
        }
      }
    }
    
    public static AttributesMapEntryUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new AttributesMapEntryUnmarshaller();
      }
      return instance;
    }
  }
  
  public GetQueueAttributesResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetQueueAttributesResult getQueueAttributesResult = new GetQueueAttributesResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getQueueAttributesResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Attribute", targetDepth))
        {
          Map.Entry<String, String> entry = AttributesMapEntryUnmarshaller.getInstance().unmarshall(context);
          getQueueAttributesResult.addAttributesEntry((String)entry.getKey(), (String)entry.getValue());
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getQueueAttributesResult;
      }
    }
  }
  
  public static GetQueueAttributesResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetQueueAttributesResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.GetQueueAttributesResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */