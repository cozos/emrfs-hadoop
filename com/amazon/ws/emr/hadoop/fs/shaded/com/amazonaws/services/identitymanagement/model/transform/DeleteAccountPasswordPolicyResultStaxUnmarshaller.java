package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccountPasswordPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteAccountPasswordPolicyResultStaxUnmarshaller
  implements Unmarshaller<DeleteAccountPasswordPolicyResult, StaxUnmarshallerContext>
{
  private static DeleteAccountPasswordPolicyResultStaxUnmarshaller instance;
  
  public DeleteAccountPasswordPolicyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteAccountPasswordPolicyResult deleteAccountPasswordPolicyResult = new DeleteAccountPasswordPolicyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteAccountPasswordPolicyResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteAccountPasswordPolicyResult;
        }
      }
    }
  }
  
  public static DeleteAccountPasswordPolicyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteAccountPasswordPolicyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteAccountPasswordPolicyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */