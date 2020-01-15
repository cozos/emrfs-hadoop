package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateServerCertificateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class UpdateServerCertificateResultStaxUnmarshaller
  implements Unmarshaller<UpdateServerCertificateResult, StaxUnmarshallerContext>
{
  private static UpdateServerCertificateResultStaxUnmarshaller instance;
  
  public UpdateServerCertificateResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UpdateServerCertificateResult updateServerCertificateResult = new UpdateServerCertificateResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return updateServerCertificateResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return updateServerCertificateResult;
        }
      }
    }
  }
  
  public static UpdateServerCertificateResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateServerCertificateResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateServerCertificateResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */