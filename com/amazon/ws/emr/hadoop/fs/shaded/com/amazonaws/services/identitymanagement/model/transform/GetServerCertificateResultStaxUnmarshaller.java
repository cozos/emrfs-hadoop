package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServerCertificateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GetServerCertificateResultStaxUnmarshaller
  implements Unmarshaller<GetServerCertificateResult, StaxUnmarshallerContext>
{
  private static GetServerCertificateResultStaxUnmarshaller instance;
  
  public GetServerCertificateResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetServerCertificateResult getServerCertificateResult = new GetServerCertificateResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getServerCertificateResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("ServerCertificate", targetDepth)) {
          getServerCertificateResult.setServerCertificate(ServerCertificateStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getServerCertificateResult;
      }
    }
  }
  
  public static GetServerCertificateResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetServerCertificateResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServerCertificateResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */