package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ContextEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ContextEntryStaxUnmarshaller
  implements Unmarshaller<ContextEntry, StaxUnmarshallerContext>
{
  private static ContextEntryStaxUnmarshaller instance;
  
  public ContextEntry unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ContextEntry contextEntry = new ContextEntry();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return contextEntry;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("ContextKeyName", targetDepth)) {
          contextEntry.setContextKeyName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ContextKeyValues", targetDepth)) {
          contextEntry.withContextKeyValues(new ArrayList());
        } else if (context.testExpression("ContextKeyValues/member", targetDepth)) {
          contextEntry.withContextKeyValues(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("ContextKeyType", targetDepth)) {
          contextEntry.setContextKeyType(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return contextEntry;
      }
    }
  }
  
  public static ContextEntryStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ContextEntryStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ContextEntryStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */