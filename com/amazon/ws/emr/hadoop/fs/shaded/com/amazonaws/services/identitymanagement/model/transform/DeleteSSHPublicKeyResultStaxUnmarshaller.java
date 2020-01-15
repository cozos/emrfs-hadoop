package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSSHPublicKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteSSHPublicKeyResultStaxUnmarshaller
  implements Unmarshaller<DeleteSSHPublicKeyResult, StaxUnmarshallerContext>
{
  private static DeleteSSHPublicKeyResultStaxUnmarshaller instance;
  
  public DeleteSSHPublicKeyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteSSHPublicKeyResult deleteSSHPublicKeyResult = new DeleteSSHPublicKeyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteSSHPublicKeyResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteSSHPublicKeyResult;
        }
      }
    }
  }
  
  public static DeleteSSHPublicKeyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteSSHPublicKeyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteSSHPublicKeyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */