package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServiceSpecificCredentialResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteServiceSpecificCredentialResultStaxUnmarshaller
  implements Unmarshaller<DeleteServiceSpecificCredentialResult, StaxUnmarshallerContext>
{
  private static DeleteServiceSpecificCredentialResultStaxUnmarshaller instance;
  
  public DeleteServiceSpecificCredentialResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteServiceSpecificCredentialResult deleteServiceSpecificCredentialResult = new DeleteServiceSpecificCredentialResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteServiceSpecificCredentialResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteServiceSpecificCredentialResult;
        }
      }
    }
  }
  
  public static DeleteServiceSpecificCredentialResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteServiceSpecificCredentialResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteServiceSpecificCredentialResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */