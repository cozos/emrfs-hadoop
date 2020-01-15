package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricDataResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MessageData;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricDataResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class GetMetricDataResultStaxUnmarshaller
  implements Unmarshaller<GetMetricDataResult, StaxUnmarshallerContext>
{
  private static GetMetricDataResultStaxUnmarshaller instance;
  
  public GetMetricDataResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetMetricDataResult getMetricDataResult = new GetMetricDataResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getMetricDataResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("MetricDataResults", targetDepth)) {
          getMetricDataResult.withMetricDataResults(new ArrayList());
        } else if (context.testExpression("MetricDataResults/member", targetDepth)) {
          getMetricDataResult.withMetricDataResults(new MetricDataResult[] { MetricDataResultStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("NextToken", targetDepth)) {
          getMetricDataResult.setNextToken(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Messages", targetDepth)) {
          getMetricDataResult.withMessages(new ArrayList());
        } else if (context.testExpression("Messages/member", targetDepth)) {
          getMetricDataResult.withMessages(new MessageData[] { MessageDataStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getMetricDataResult;
      }
    }
  }
  
  public static GetMetricDataResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetMetricDataResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.GetMetricDataResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */