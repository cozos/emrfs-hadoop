package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateOpenIDConnectProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class CreateOpenIDConnectProviderResultStaxUnmarshaller
  implements Unmarshaller<CreateOpenIDConnectProviderResult, StaxUnmarshallerContext>
{
  private static CreateOpenIDConnectProviderResultStaxUnmarshaller instance;
  
  public CreateOpenIDConnectProviderResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    CreateOpenIDConnectProviderResult createOpenIDConnectProviderResult = new CreateOpenIDConnectProviderResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return createOpenIDConnectProviderResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("OpenIDConnectProviderArn", targetDepth)) {
          createOpenIDConnectProviderResult.setOpenIDConnectProviderArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return createOpenIDConnectProviderResult;
      }
    }
  }
  
  public static CreateOpenIDConnectProviderResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CreateOpenIDConnectProviderResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateOpenIDConnectProviderResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */