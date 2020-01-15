package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.OpenIDConnectProviderListEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class OpenIDConnectProviderListEntryStaxUnmarshaller
  implements Unmarshaller<OpenIDConnectProviderListEntry, StaxUnmarshallerContext>
{
  private static OpenIDConnectProviderListEntryStaxUnmarshaller instance;
  
  public OpenIDConnectProviderListEntry unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    OpenIDConnectProviderListEntry openIDConnectProviderListEntry = new OpenIDConnectProviderListEntry();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return openIDConnectProviderListEntry;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Arn", targetDepth)) {
          openIDConnectProviderListEntry.setArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return openIDConnectProviderListEntry;
      }
    }
  }
  
  public static OpenIDConnectProviderListEntryStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new OpenIDConnectProviderListEntryStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.OpenIDConnectProviderListEntryStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */