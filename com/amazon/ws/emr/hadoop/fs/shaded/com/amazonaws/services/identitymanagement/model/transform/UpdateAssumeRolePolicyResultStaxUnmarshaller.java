package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAssumeRolePolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class UpdateAssumeRolePolicyResultStaxUnmarshaller
  implements Unmarshaller<UpdateAssumeRolePolicyResult, StaxUnmarshallerContext>
{
  private static UpdateAssumeRolePolicyResultStaxUnmarshaller instance;
  
  public UpdateAssumeRolePolicyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UpdateAssumeRolePolicyResult updateAssumeRolePolicyResult = new UpdateAssumeRolePolicyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return updateAssumeRolePolicyResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return updateAssumeRolePolicyResult;
        }
      }
    }
  }
  
  public static UpdateAssumeRolePolicyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateAssumeRolePolicyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateAssumeRolePolicyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */