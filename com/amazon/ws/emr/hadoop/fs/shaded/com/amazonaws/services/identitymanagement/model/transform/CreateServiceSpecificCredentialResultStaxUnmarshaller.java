package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateServiceSpecificCredentialResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class CreateServiceSpecificCredentialResultStaxUnmarshaller
  implements Unmarshaller<CreateServiceSpecificCredentialResult, StaxUnmarshallerContext>
{
  private static CreateServiceSpecificCredentialResultStaxUnmarshaller instance;
  
  public CreateServiceSpecificCredentialResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    CreateServiceSpecificCredentialResult createServiceSpecificCredentialResult = new CreateServiceSpecificCredentialResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return createServiceSpecificCredentialResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("ServiceSpecificCredential", targetDepth)) {
          createServiceSpecificCredentialResult.setServiceSpecificCredential(ServiceSpecificCredentialStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return createServiceSpecificCredentialResult;
      }
    }
  }
  
  public static CreateServiceSpecificCredentialResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CreateServiceSpecificCredentialResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateServiceSpecificCredentialResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */