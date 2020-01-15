package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadServerCertificateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class UploadServerCertificateResultStaxUnmarshaller
  implements Unmarshaller<UploadServerCertificateResult, StaxUnmarshallerContext>
{
  private static UploadServerCertificateResultStaxUnmarshaller instance;
  
  public UploadServerCertificateResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UploadServerCertificateResult uploadServerCertificateResult = new UploadServerCertificateResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return uploadServerCertificateResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("ServerCertificateMetadata", targetDepth)) {
          uploadServerCertificateResult.setServerCertificateMetadata(ServerCertificateMetadataStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return uploadServerCertificateResult;
      }
    }
  }
  
  public static UploadServerCertificateResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UploadServerCertificateResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UploadServerCertificateResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */