package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Datapoint;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.Map.Entry;
import javax.xml.stream.events.XMLEvent;

public class DatapointStaxUnmarshaller
  implements Unmarshaller<Datapoint, StaxUnmarshallerContext>
{
  private static DatapointStaxUnmarshaller instance;
  
  private static class ExtendedStatisticsMapEntryUnmarshaller
    implements Unmarshaller<Map.Entry<String, Double>, StaxUnmarshallerContext>
  {
    private static ExtendedStatisticsMapEntryUnmarshaller instance;
    
    public Map.Entry<String, Double> unmarshall(StaxUnmarshallerContext context)
      throws Exception
    {
      int originalDepth = context.getCurrentDepth();
      int targetDepth = originalDepth + 1;
      
      MapEntry<String, Double> entry = new MapEntry();
      for (;;)
      {
        XMLEvent xmlEvent = context.nextEvent();
        if (xmlEvent.isEndDocument()) {
          return entry;
        }
        if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
        {
          if (context.testExpression("key", targetDepth)) {
            entry.setKey(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
          } else if (context.testExpression("value", targetDepth)) {
            entry.setValue(SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context));
          }
        }
        else if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return entry;
        }
      }
    }
    
    public static ExtendedStatisticsMapEntryUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new ExtendedStatisticsMapEntryUnmarshaller();
      }
      return instance;
    }
  }
  
  public Datapoint unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    Datapoint datapoint = new Datapoint();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return datapoint;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Timestamp", targetDepth))
        {
          datapoint.setTimestamp(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        }
        else if (context.testExpression("SampleCount", targetDepth))
        {
          datapoint.setSampleCount(SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("Average", targetDepth))
        {
          datapoint.setAverage(SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("Sum", targetDepth))
        {
          datapoint.setSum(SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("Minimum", targetDepth))
        {
          datapoint.setMinimum(SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("Maximum", targetDepth))
        {
          datapoint.setMaximum(SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("Unit", targetDepth))
        {
          datapoint.setUnit(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("ExtendedStatistics/entry", targetDepth))
        {
          Map.Entry<String, Double> entry = ExtendedStatisticsMapEntryUnmarshaller.getInstance().unmarshall(context);
          datapoint.addExtendedStatisticsEntry((String)entry.getKey(), (Double)entry.getValue());
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return datapoint;
      }
    }
  }
  
  public static DatapointStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DatapointStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DatapointStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */