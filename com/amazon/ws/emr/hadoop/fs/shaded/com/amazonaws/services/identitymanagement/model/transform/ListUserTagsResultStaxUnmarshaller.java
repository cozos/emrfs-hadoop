package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUserTagsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListUserTagsResultStaxUnmarshaller
  implements Unmarshaller<ListUserTagsResult, StaxUnmarshallerContext>
{
  private static ListUserTagsResultStaxUnmarshaller instance;
  
  public ListUserTagsResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListUserTagsResult listUserTagsResult = new ListUserTagsResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listUserTagsResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Tags", targetDepth)) {
          listUserTagsResult.withTags(new ArrayList());
        } else if (context.testExpression("Tags/member", targetDepth)) {
          listUserTagsResult.withTags(new Tag[] { TagStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("IsTruncated", targetDepth)) {
          listUserTagsResult.setIsTruncated(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Marker", targetDepth)) {
          listUserTagsResult.setMarker(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listUserTagsResult;
      }
    }
  }
  
  public static ListUserTagsResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListUserTagsResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListUserTagsResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */