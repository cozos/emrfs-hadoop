package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResyncMFADeviceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class ResyncMFADeviceResultStaxUnmarshaller
  implements Unmarshaller<ResyncMFADeviceResult, StaxUnmarshallerContext>
{
  private static ResyncMFADeviceResultStaxUnmarshaller instance;
  
  public ResyncMFADeviceResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ResyncMFADeviceResult resyncMFADeviceResult = new ResyncMFADeviceResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return resyncMFADeviceResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return resyncMFADeviceResult;
        }
      }
    }
  }
  
  public static ResyncMFADeviceResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ResyncMFADeviceResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ResyncMFADeviceResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */