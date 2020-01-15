package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddClientIDToOpenIDConnectProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class AddClientIDToOpenIDConnectProviderResultStaxUnmarshaller
  implements Unmarshaller<AddClientIDToOpenIDConnectProviderResult, StaxUnmarshallerContext>
{
  private static AddClientIDToOpenIDConnectProviderResultStaxUnmarshaller instance;
  
  public AddClientIDToOpenIDConnectProviderResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AddClientIDToOpenIDConnectProviderResult addClientIDToOpenIDConnectProviderResult = new AddClientIDToOpenIDConnectProviderResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return addClientIDToOpenIDConnectProviderResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return addClientIDToOpenIDConnectProviderResult;
        }
      }
    }
  }
  
  public static AddClientIDToOpenIDConnectProviderResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AddClientIDToOpenIDConnectProviderResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AddClientIDToOpenIDConnectProviderResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */