package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSSHPublicKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class UpdateSSHPublicKeyResultStaxUnmarshaller
  implements Unmarshaller<UpdateSSHPublicKeyResult, StaxUnmarshallerContext>
{
  private static UpdateSSHPublicKeyResultStaxUnmarshaller instance;
  
  public UpdateSSHPublicKeyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UpdateSSHPublicKeyResult updateSSHPublicKeyResult = new UpdateSSHPublicKeyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return updateSSHPublicKeyResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return updateSSHPublicKeyResult;
        }
      }
    }
  }
  
  public static UpdateSSHPublicKeyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateSSHPublicKeyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateSSHPublicKeyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */