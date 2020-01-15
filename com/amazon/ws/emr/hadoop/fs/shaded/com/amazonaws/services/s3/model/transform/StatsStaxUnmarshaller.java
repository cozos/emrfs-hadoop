package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Stats;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

class StatsStaxUnmarshaller
  implements Unmarshaller<Stats, StaxUnmarshallerContext>
{
  private static final StatsStaxUnmarshaller instance = new StatsStaxUnmarshaller();
  
  public static StatsStaxUnmarshaller getInstance()
  {
    return instance;
  }
  
  public Stats unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    Stats result = new Stats();
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return result;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("BytesScanned", targetDepth)) {
          result.setBytesScanned(SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("BytesReturned", targetDepth)) {
          result.setBytesReturned(SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("BytesProcessed", targetDepth)) {
          result.setBytesProcessed(SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth))
      {
        return result;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.StatsStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */