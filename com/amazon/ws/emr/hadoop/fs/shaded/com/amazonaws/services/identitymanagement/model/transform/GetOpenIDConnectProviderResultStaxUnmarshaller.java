package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetOpenIDConnectProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class GetOpenIDConnectProviderResultStaxUnmarshaller
  implements Unmarshaller<GetOpenIDConnectProviderResult, StaxUnmarshallerContext>
{
  private static GetOpenIDConnectProviderResultStaxUnmarshaller instance;
  
  public GetOpenIDConnectProviderResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetOpenIDConnectProviderResult getOpenIDConnectProviderResult = new GetOpenIDConnectProviderResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getOpenIDConnectProviderResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Url", targetDepth)) {
          getOpenIDConnectProviderResult.setUrl(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ClientIDList", targetDepth)) {
          getOpenIDConnectProviderResult.withClientIDList(new ArrayList());
        } else if (context.testExpression("ClientIDList/member", targetDepth)) {
          getOpenIDConnectProviderResult.withClientIDList(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("ThumbprintList", targetDepth)) {
          getOpenIDConnectProviderResult.withThumbprintList(new ArrayList());
        } else if (context.testExpression("ThumbprintList/member", targetDepth)) {
          getOpenIDConnectProviderResult.withThumbprintList(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("CreateDate", targetDepth)) {
          getOpenIDConnectProviderResult.setCreateDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getOpenIDConnectProviderResult;
      }
    }
  }
  
  public static GetOpenIDConnectProviderResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetOpenIDConnectProviderResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetOpenIDConnectProviderResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */