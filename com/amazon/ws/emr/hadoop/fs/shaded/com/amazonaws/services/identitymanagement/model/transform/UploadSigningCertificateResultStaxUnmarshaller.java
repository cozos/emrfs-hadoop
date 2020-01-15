package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadSigningCertificateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class UploadSigningCertificateResultStaxUnmarshaller
  implements Unmarshaller<UploadSigningCertificateResult, StaxUnmarshallerContext>
{
  private static UploadSigningCertificateResultStaxUnmarshaller instance;
  
  public UploadSigningCertificateResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UploadSigningCertificateResult uploadSigningCertificateResult = new UploadSigningCertificateResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return uploadSigningCertificateResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Certificate", targetDepth)) {
          uploadSigningCertificateResult.setCertificate(SigningCertificateStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return uploadSigningCertificateResult;
      }
    }
  }
  
  public static UploadSigningCertificateResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UploadSigningCertificateResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UploadSigningCertificateResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */