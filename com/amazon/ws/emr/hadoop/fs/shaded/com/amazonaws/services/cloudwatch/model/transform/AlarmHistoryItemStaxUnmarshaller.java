package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.AlarmHistoryItem;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class AlarmHistoryItemStaxUnmarshaller
  implements Unmarshaller<AlarmHistoryItem, StaxUnmarshallerContext>
{
  private static AlarmHistoryItemStaxUnmarshaller instance;
  
  public AlarmHistoryItem unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AlarmHistoryItem alarmHistoryItem = new AlarmHistoryItem();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return alarmHistoryItem;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("AlarmName", targetDepth)) {
          alarmHistoryItem.setAlarmName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Timestamp", targetDepth)) {
          alarmHistoryItem.setTimestamp(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("HistoryItemType", targetDepth)) {
          alarmHistoryItem.setHistoryItemType(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("HistorySummary", targetDepth)) {
          alarmHistoryItem.setHistorySummary(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("HistoryData", targetDepth)) {
          alarmHistoryItem.setHistoryData(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return alarmHistoryItem;
      }
    }
  }
  
  public static AlarmHistoryItemStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AlarmHistoryItemStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.AlarmHistoryItemStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */