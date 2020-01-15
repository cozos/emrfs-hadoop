package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.AnomalyDetector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAnomalyDetectorsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class DescribeAnomalyDetectorsResultStaxUnmarshaller
  implements Unmarshaller<DescribeAnomalyDetectorsResult, StaxUnmarshallerContext>
{
  private static DescribeAnomalyDetectorsResultStaxUnmarshaller instance;
  
  public DescribeAnomalyDetectorsResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DescribeAnomalyDetectorsResult describeAnomalyDetectorsResult = new DescribeAnomalyDetectorsResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return describeAnomalyDetectorsResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("AnomalyDetectors", targetDepth)) {
          describeAnomalyDetectorsResult.withAnomalyDetectors(new ArrayList());
        } else if (context.testExpression("AnomalyDetectors/member", targetDepth)) {
          describeAnomalyDetectorsResult.withAnomalyDetectors(new AnomalyDetector[] { AnomalyDetectorStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("NextToken", targetDepth)) {
          describeAnomalyDetectorsResult.setNextToken(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return describeAnomalyDetectorsResult;
      }
    }
  }
  
  public static DescribeAnomalyDetectorsResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DescribeAnomalyDetectorsResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAnomalyDetectorsResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */