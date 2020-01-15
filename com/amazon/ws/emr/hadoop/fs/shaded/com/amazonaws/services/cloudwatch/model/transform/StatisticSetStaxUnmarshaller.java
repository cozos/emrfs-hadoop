package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.StatisticSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class StatisticSetStaxUnmarshaller
  implements Unmarshaller<StatisticSet, StaxUnmarshallerContext>
{
  private static StatisticSetStaxUnmarshaller instance;
  
  public StatisticSet unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    StatisticSet statisticSet = new StatisticSet();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return statisticSet;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("SampleCount", targetDepth)) {
          statisticSet.setSampleCount(SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Sum", targetDepth)) {
          statisticSet.setSum(SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Minimum", targetDepth)) {
          statisticSet.setMinimum(SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Maximum", targetDepth)) {
          statisticSet.setMaximum(SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return statisticSet;
      }
    }
  }
  
  public static StatisticSetStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new StatisticSetStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.StatisticSetStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */