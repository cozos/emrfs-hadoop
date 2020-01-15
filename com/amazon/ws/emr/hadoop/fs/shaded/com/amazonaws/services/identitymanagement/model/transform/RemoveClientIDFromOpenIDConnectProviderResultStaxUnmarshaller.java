package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveClientIDFromOpenIDConnectProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class RemoveClientIDFromOpenIDConnectProviderResultStaxUnmarshaller
  implements Unmarshaller<RemoveClientIDFromOpenIDConnectProviderResult, StaxUnmarshallerContext>
{
  private static RemoveClientIDFromOpenIDConnectProviderResultStaxUnmarshaller instance;
  
  public RemoveClientIDFromOpenIDConnectProviderResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    RemoveClientIDFromOpenIDConnectProviderResult removeClientIDFromOpenIDConnectProviderResult = new RemoveClientIDFromOpenIDConnectProviderResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return removeClientIDFromOpenIDConnectProviderResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return removeClientIDFromOpenIDConnectProviderResult;
        }
      }
    }
  }
  
  public static RemoveClientIDFromOpenIDConnectProviderResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new RemoveClientIDFromOpenIDConnectProviderResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.RemoveClientIDFromOpenIDConnectProviderResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */