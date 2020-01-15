package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeletePolicyVersionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeletePolicyVersionResultStaxUnmarshaller
  implements Unmarshaller<DeletePolicyVersionResult, StaxUnmarshallerContext>
{
  private static DeletePolicyVersionResultStaxUnmarshaller instance;
  
  public DeletePolicyVersionResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeletePolicyVersionResult deletePolicyVersionResult = new DeletePolicyVersionResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deletePolicyVersionResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deletePolicyVersionResult;
        }
      }
    }
  }
  
  public static DeletePolicyVersionResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeletePolicyVersionResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeletePolicyVersionResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */