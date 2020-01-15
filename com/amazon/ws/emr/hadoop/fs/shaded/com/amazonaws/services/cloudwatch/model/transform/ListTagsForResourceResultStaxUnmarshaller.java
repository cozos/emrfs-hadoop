package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListTagsForResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListTagsForResourceResultStaxUnmarshaller
  implements Unmarshaller<ListTagsForResourceResult, StaxUnmarshallerContext>
{
  private static ListTagsForResourceResultStaxUnmarshaller instance;
  
  public ListTagsForResourceResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListTagsForResourceResult listTagsForResourceResult = new ListTagsForResourceResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listTagsForResourceResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Tags", targetDepth)) {
          listTagsForResourceResult.withTags(new ArrayList());
        } else if (context.testExpression("Tags/member", targetDepth)) {
          listTagsForResourceResult.withTags(new Tag[] { TagStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listTagsForResourceResult;
      }
    }
  }
  
  public static ListTagsForResourceResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListTagsForResourceResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ListTagsForResourceResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */