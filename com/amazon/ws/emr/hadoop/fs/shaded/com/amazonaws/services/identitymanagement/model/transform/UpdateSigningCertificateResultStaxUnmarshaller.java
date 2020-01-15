package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSigningCertificateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class UpdateSigningCertificateResultStaxUnmarshaller
  implements Unmarshaller<UpdateSigningCertificateResult, StaxUnmarshallerContext>
{
  private static UpdateSigningCertificateResultStaxUnmarshaller instance;
  
  public UpdateSigningCertificateResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UpdateSigningCertificateResult updateSigningCertificateResult = new UpdateSigningCertificateResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return updateSigningCertificateResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return updateSigningCertificateResult;
        }
      }
    }
  }
  
  public static UpdateSigningCertificateResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateSigningCertificateResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateSigningCertificateResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */