package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.Map.Entry;
import javax.xml.stream.events.XMLEvent;

class DatapointStaxUnmarshaller$ExtendedStatisticsMapEntryUnmarshaller
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DatapointStaxUnmarshaller.ExtendedStatisticsMapEntryUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */