package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetInstanceProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GetInstanceProfileResultStaxUnmarshaller
  implements Unmarshaller<GetInstanceProfileResult, StaxUnmarshallerContext>
{
  private static GetInstanceProfileResultStaxUnmarshaller instance;
  
  public GetInstanceProfileResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetInstanceProfileResult getInstanceProfileResult = new GetInstanceProfileResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getInstanceProfileResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("InstanceProfile", targetDepth)) {
          getInstanceProfileResult.setInstanceProfile(InstanceProfileStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getInstanceProfileResult;
      }
    }
  }
  
  public static GetInstanceProfileResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetInstanceProfileResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetInstanceProfileResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */