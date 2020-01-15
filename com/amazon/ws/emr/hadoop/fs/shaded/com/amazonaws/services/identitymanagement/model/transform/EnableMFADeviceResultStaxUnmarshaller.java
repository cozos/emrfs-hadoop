package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EnableMFADeviceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class EnableMFADeviceResultStaxUnmarshaller
  implements Unmarshaller<EnableMFADeviceResult, StaxUnmarshallerContext>
{
  private static EnableMFADeviceResultStaxUnmarshaller instance;
  
  public EnableMFADeviceResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    EnableMFADeviceResult enableMFADeviceResult = new EnableMFADeviceResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return enableMFADeviceResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return enableMFADeviceResult;
        }
      }
    }
  }
  
  public static EnableMFADeviceResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new EnableMFADeviceResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.EnableMFADeviceResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */