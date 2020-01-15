package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.AlarmHistoryItem;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class DescribeAlarmHistoryResultStaxUnmarshaller
  implements Unmarshaller<DescribeAlarmHistoryResult, StaxUnmarshallerContext>
{
  private static DescribeAlarmHistoryResultStaxUnmarshaller instance;
  
  public DescribeAlarmHistoryResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DescribeAlarmHistoryResult describeAlarmHistoryResult = new DescribeAlarmHistoryResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return describeAlarmHistoryResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("AlarmHistoryItems", targetDepth)) {
          describeAlarmHistoryResult.withAlarmHistoryItems(new ArrayList());
        } else if (context.testExpression("AlarmHistoryItems/member", targetDepth)) {
          describeAlarmHistoryResult.withAlarmHistoryItems(new AlarmHistoryItem[] { AlarmHistoryItemStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("NextToken", targetDepth)) {
          describeAlarmHistoryResult.setNextToken(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return describeAlarmHistoryResult;
      }
    }
  }
  
  public static DescribeAlarmHistoryResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DescribeAlarmHistoryResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmHistoryResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */