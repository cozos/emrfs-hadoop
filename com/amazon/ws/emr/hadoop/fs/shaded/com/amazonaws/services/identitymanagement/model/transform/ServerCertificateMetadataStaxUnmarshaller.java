package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ServerCertificateMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class ServerCertificateMetadataStaxUnmarshaller
  implements Unmarshaller<ServerCertificateMetadata, StaxUnmarshallerContext>
{
  private static ServerCertificateMetadataStaxUnmarshaller instance;
  
  public ServerCertificateMetadata unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ServerCertificateMetadata serverCertificateMetadata = new ServerCertificateMetadata();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return serverCertificateMetadata;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Path", targetDepth)) {
          serverCertificateMetadata.setPath(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ServerCertificateName", targetDepth)) {
          serverCertificateMetadata.setServerCertificateName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ServerCertificateId", targetDepth)) {
          serverCertificateMetadata.setServerCertificateId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Arn", targetDepth)) {
          serverCertificateMetadata.setArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("UploadDate", targetDepth)) {
          serverCertificateMetadata.setUploadDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("Expiration", targetDepth)) {
          serverCertificateMetadata.setExpiration(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return serverCertificateMetadata;
      }
    }
  }
  
  public static ServerCertificateMetadataStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ServerCertificateMetadataStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ServerCertificateMetadataStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */