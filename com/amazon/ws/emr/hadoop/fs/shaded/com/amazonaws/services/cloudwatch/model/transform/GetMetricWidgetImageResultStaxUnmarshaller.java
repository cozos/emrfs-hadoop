package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricWidgetImageResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GetMetricWidgetImageResultStaxUnmarshaller
  implements Unmarshaller<GetMetricWidgetImageResult, StaxUnmarshallerContext>
{
  private static GetMetricWidgetImageResultStaxUnmarshaller instance;
  
  public GetMetricWidgetImageResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetMetricWidgetImageResult getMetricWidgetImageResult = new GetMetricWidgetImageResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getMetricWidgetImageResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("MetricWidgetImage", targetDepth)) {
          getMetricWidgetImageResult.setMetricWidgetImage(SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getMetricWidgetImageResult;
      }
    }
  }
  
  public static GetMetricWidgetImageResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetMetricWidgetImageResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.GetMetricWidgetImageResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */