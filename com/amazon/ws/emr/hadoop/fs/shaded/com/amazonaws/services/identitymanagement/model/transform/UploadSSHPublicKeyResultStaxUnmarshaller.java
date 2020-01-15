package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadSSHPublicKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class UploadSSHPublicKeyResultStaxUnmarshaller
  implements Unmarshaller<UploadSSHPublicKeyResult, StaxUnmarshallerContext>
{
  private static UploadSSHPublicKeyResultStaxUnmarshaller instance;
  
  public UploadSSHPublicKeyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UploadSSHPublicKeyResult uploadSSHPublicKeyResult = new UploadSSHPublicKeyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return uploadSSHPublicKeyResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("SSHPublicKey", targetDepth)) {
          uploadSSHPublicKeyResult.setSSHPublicKey(SSHPublicKeyStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return uploadSSHPublicKeyResult;
      }
    }
  }
  
  public static UploadSSHPublicKeyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UploadSSHPublicKeyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UploadSSHPublicKeyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */