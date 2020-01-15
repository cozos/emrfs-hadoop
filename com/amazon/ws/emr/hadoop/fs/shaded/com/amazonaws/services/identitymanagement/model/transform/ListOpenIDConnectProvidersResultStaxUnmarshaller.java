package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListOpenIDConnectProvidersResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.OpenIDConnectProviderListEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListOpenIDConnectProvidersResultStaxUnmarshaller
  implements Unmarshaller<ListOpenIDConnectProvidersResult, StaxUnmarshallerContext>
{
  private static ListOpenIDConnectProvidersResultStaxUnmarshaller instance;
  
  public ListOpenIDConnectProvidersResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListOpenIDConnectProvidersResult listOpenIDConnectProvidersResult = new ListOpenIDConnectProvidersResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listOpenIDConnectProvidersResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("OpenIDConnectProviderList", targetDepth)) {
          listOpenIDConnectProvidersResult.withOpenIDConnectProviderList(new ArrayList());
        } else if (context.testExpression("OpenIDConnectProviderList/member", targetDepth)) {
          listOpenIDConnectProvidersResult.withOpenIDConnectProviderList(new OpenIDConnectProviderListEntry[] { OpenIDConnectProviderListEntryStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listOpenIDConnectProvidersResult;
      }
    }
  }
  
  public static ListOpenIDConnectProvidersResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListOpenIDConnectProvidersResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListOpenIDConnectProvidersResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */