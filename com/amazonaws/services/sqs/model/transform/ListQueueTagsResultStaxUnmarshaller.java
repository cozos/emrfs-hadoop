package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.ListQueueTagsResult;
import java.util.Map.Entry;
import javax.xml.stream.events.XMLEvent;

public class ListQueueTagsResultStaxUnmarshaller
  implements Unmarshaller<ListQueueTagsResult, StaxUnmarshallerContext>
{
  private static ListQueueTagsResultStaxUnmarshaller instance;
  
  private static class TagsMapEntryUnmarshaller
    implements Unmarshaller<Map.Entry<String, String>, StaxUnmarshallerContext>
  {
    private static TagsMapEntryUnmarshaller instance;
    
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
          if (context.testExpression("Key", targetDepth)) {
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
    
    public static TagsMapEntryUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new TagsMapEntryUnmarshaller();
      }
      return instance;
    }
  }
  
  public ListQueueTagsResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListQueueTagsResult listQueueTagsResult = new ListQueueTagsResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listQueueTagsResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Tag", targetDepth))
        {
          Map.Entry<String, String> entry = TagsMapEntryUnmarshaller.getInstance().unmarshall(context);
          listQueueTagsResult.addTagsEntry((String)entry.getKey(), (String)entry.getValue());
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listQueueTagsResult;
      }
    }
  }
  
  public static ListQueueTagsResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListQueueTagsResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.ListQueueTagsResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */