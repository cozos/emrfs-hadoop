package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSigningCertificateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteSigningCertificateResultStaxUnmarshaller
  implements Unmarshaller<DeleteSigningCertificateResult, StaxUnmarshallerContext>
{
  private static DeleteSigningCertificateResultStaxUnmarshaller instance;
  
  public DeleteSigningCertificateResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteSigningCertificateResult deleteSigningCertificateResult = new DeleteSigningCertificateResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteSigningCertificateResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteSigningCertificateResult;
        }
      }
    }
  }
  
  public static DeleteSigningCertificateResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteSigningCertificateResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteSigningCertificateResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */