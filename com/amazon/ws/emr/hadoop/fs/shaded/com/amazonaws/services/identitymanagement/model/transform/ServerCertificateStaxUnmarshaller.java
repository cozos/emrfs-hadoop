package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ServerCertificate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class ServerCertificateStaxUnmarshaller
  implements Unmarshaller<ServerCertificate, StaxUnmarshallerContext>
{
  private static ServerCertificateStaxUnmarshaller instance;
  
  public ServerCertificate unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ServerCertificate serverCertificate = new ServerCertificate();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return serverCertificate;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("ServerCertificateMetadata", targetDepth)) {
          serverCertificate.setServerCertificateMetadata(ServerCertificateMetadataStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("CertificateBody", targetDepth)) {
          serverCertificate.setCertificateBody(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("CertificateChain", targetDepth)) {
          serverCertificate.setCertificateChain(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return serverCertificate;
      }
    }
  }
  
  public static ServerCertificateStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ServerCertificateStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ServerCertificateStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */