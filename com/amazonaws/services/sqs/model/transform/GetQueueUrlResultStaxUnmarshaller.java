package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import javax.xml.stream.events.XMLEvent;

public class GetQueueUrlResultStaxUnmarshaller
  implements Unmarshaller<GetQueueUrlResult, StaxUnmarshallerContext>
{
  private static GetQueueUrlResultStaxUnmarshaller instance;
  
  public GetQueueUrlResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetQueueUrlResult getQueueUrlResult = new GetQueueUrlResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getQueueUrlResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("QueueUrl", targetDepth)) {
          getQueueUrlResult.setQueueUrl(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getQueueUrlResult;
      }
    }
  }
  
  public static GetQueueUrlResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetQueueUrlResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.GetQueueUrlResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */