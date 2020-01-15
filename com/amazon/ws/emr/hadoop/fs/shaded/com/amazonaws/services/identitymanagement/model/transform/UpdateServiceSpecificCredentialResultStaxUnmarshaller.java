package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateServiceSpecificCredentialResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class UpdateServiceSpecificCredentialResultStaxUnmarshaller
  implements Unmarshaller<UpdateServiceSpecificCredentialResult, StaxUnmarshallerContext>
{
  private static UpdateServiceSpecificCredentialResultStaxUnmarshaller instance;
  
  public UpdateServiceSpecificCredentialResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UpdateServiceSpecificCredentialResult updateServiceSpecificCredentialResult = new UpdateServiceSpecificCredentialResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return updateServiceSpecificCredentialResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return updateServiceSpecificCredentialResult;
        }
      }
    }
  }
  
  public static UpdateServiceSpecificCredentialResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateServiceSpecificCredentialResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateServiceSpecificCredentialResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */