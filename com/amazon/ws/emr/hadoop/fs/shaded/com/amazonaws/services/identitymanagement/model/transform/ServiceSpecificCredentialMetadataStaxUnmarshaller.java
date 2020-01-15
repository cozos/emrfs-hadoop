package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ServiceSpecificCredentialMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class ServiceSpecificCredentialMetadataStaxUnmarshaller
  implements Unmarshaller<ServiceSpecificCredentialMetadata, StaxUnmarshallerContext>
{
  private static ServiceSpecificCredentialMetadataStaxUnmarshaller instance;
  
  public ServiceSpecificCredentialMetadata unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ServiceSpecificCredentialMetadata serviceSpecificCredentialMetadata = new ServiceSpecificCredentialMetadata();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return serviceSpecificCredentialMetadata;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("UserName", targetDepth)) {
          serviceSpecificCredentialMetadata.setUserName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Status", targetDepth)) {
          serviceSpecificCredentialMetadata.setStatus(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ServiceUserName", targetDepth)) {
          serviceSpecificCredentialMetadata.setServiceUserName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("CreateDate", targetDepth)) {
          serviceSpecificCredentialMetadata.setCreateDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("ServiceSpecificCredentialId", targetDepth)) {
          serviceSpecificCredentialMetadata.setServiceSpecificCredentialId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ServiceName", targetDepth)) {
          serviceSpecificCredentialMetadata.setServiceName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return serviceSpecificCredentialMetadata;
      }
    }
  }
  
  public static ServiceSpecificCredentialMetadataStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ServiceSpecificCredentialMetadataStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ServiceSpecificCredentialMetadataStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */