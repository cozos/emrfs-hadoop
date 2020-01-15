package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ServiceSpecificCredential;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class ServiceSpecificCredentialStaxUnmarshaller
  implements Unmarshaller<ServiceSpecificCredential, StaxUnmarshallerContext>
{
  private static ServiceSpecificCredentialStaxUnmarshaller instance;
  
  public ServiceSpecificCredential unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ServiceSpecificCredential serviceSpecificCredential = new ServiceSpecificCredential();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return serviceSpecificCredential;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("CreateDate", targetDepth)) {
          serviceSpecificCredential.setCreateDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("ServiceName", targetDepth)) {
          serviceSpecificCredential.setServiceName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ServiceUserName", targetDepth)) {
          serviceSpecificCredential.setServiceUserName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ServicePassword", targetDepth)) {
          serviceSpecificCredential.setServicePassword(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ServiceSpecificCredentialId", targetDepth)) {
          serviceSpecificCredential.setServiceSpecificCredentialId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("UserName", targetDepth)) {
          serviceSpecificCredential.setUserName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Status", targetDepth)) {
          serviceSpecificCredential.setStatus(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return serviceSpecificCredential;
      }
    }
  }
  
  public static ServiceSpecificCredentialStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ServiceSpecificCredentialStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ServiceSpecificCredentialStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */