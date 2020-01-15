package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountSummaryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.Map.Entry;
import javax.xml.stream.events.XMLEvent;

public class GetAccountSummaryResultStaxUnmarshaller
  implements Unmarshaller<GetAccountSummaryResult, StaxUnmarshallerContext>
{
  private static GetAccountSummaryResultStaxUnmarshaller instance;
  
  private static class SummaryMapMapEntryUnmarshaller
    implements Unmarshaller<Map.Entry<String, Integer>, StaxUnmarshallerContext>
  {
    private static SummaryMapMapEntryUnmarshaller instance;
    
    public Map.Entry<String, Integer> unmarshall(StaxUnmarshallerContext context)
      throws Exception
    {
      int originalDepth = context.getCurrentDepth();
      int targetDepth = originalDepth + 1;
      
      MapEntry<String, Integer> entry = new MapEntry();
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
            entry.setValue(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
          }
        }
        else if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return entry;
        }
      }
    }
    
    public static SummaryMapMapEntryUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new SummaryMapMapEntryUnmarshaller();
      }
      return instance;
    }
  }
  
  public GetAccountSummaryResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetAccountSummaryResult getAccountSummaryResult = new GetAccountSummaryResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getAccountSummaryResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("SummaryMap/entry", targetDepth))
        {
          Map.Entry<String, Integer> entry = SummaryMapMapEntryUnmarshaller.getInstance().unmarshall(context);
          getAccountSummaryResult.addSummaryMapEntry((String)entry.getKey(), (Integer)entry.getValue());
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getAccountSummaryResult;
      }
    }
  }
  
  public static GetAccountSummaryResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetAccountSummaryResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccountSummaryResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */