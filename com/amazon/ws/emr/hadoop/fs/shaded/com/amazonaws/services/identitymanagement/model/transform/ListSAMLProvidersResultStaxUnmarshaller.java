package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSAMLProvidersResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SAMLProviderListEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListSAMLProvidersResultStaxUnmarshaller
  implements Unmarshaller<ListSAMLProvidersResult, StaxUnmarshallerContext>
{
  private static ListSAMLProvidersResultStaxUnmarshaller instance;
  
  public ListSAMLProvidersResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListSAMLProvidersResult listSAMLProvidersResult = new ListSAMLProvidersResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listSAMLProvidersResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("SAMLProviderList", targetDepth)) {
          listSAMLProvidersResult.withSAMLProviderList(new ArrayList());
        } else if (context.testExpression("SAMLProviderList/member", targetDepth)) {
          listSAMLProvidersResult.withSAMLProviderList(new SAMLProviderListEntry[] { SAMLProviderListEntryStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listSAMLProvidersResult;
      }
    }
  }
  
  public static ListSAMLProvidersResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListSAMLProvidersResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListSAMLProvidersResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */