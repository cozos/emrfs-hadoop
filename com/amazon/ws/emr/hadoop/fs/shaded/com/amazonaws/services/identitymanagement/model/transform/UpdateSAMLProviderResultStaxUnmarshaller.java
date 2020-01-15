package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSAMLProviderResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class UpdateSAMLProviderResultStaxUnmarshaller
  implements Unmarshaller<UpdateSAMLProviderResult, StaxUnmarshallerContext>
{
  private static UpdateSAMLProviderResultStaxUnmarshaller instance;
  
  public UpdateSAMLProviderResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UpdateSAMLProviderResult updateSAMLProviderResult = new UpdateSAMLProviderResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return updateSAMLProviderResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("SAMLProviderArn", targetDepth)) {
          updateSAMLProviderResult.setSAMLProviderArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return updateSAMLProviderResult;
      }
    }
  }
  
  public static UpdateSAMLProviderResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateSAMLProviderResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateSAMLProviderResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */