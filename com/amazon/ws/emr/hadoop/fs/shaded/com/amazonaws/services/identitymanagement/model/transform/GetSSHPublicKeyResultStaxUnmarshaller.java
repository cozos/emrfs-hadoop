package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetSSHPublicKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GetSSHPublicKeyResultStaxUnmarshaller
  implements Unmarshaller<GetSSHPublicKeyResult, StaxUnmarshallerContext>
{
  private static GetSSHPublicKeyResultStaxUnmarshaller instance;
  
  public GetSSHPublicKeyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetSSHPublicKeyResult getSSHPublicKeyResult = new GetSSHPublicKeyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getSSHPublicKeyResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("SSHPublicKey", targetDepth)) {
          getSSHPublicKeyResult.setSSHPublicKey(SSHPublicKeyStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getSSHPublicKeyResult;
      }
    }
  }
  
  public static GetSSHPublicKeyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetSSHPublicKeyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetSSHPublicKeyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */