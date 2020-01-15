package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeactivateMFADeviceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeactivateMFADeviceResultStaxUnmarshaller
  implements Unmarshaller<DeactivateMFADeviceResult, StaxUnmarshallerContext>
{
  private static DeactivateMFADeviceResultStaxUnmarshaller instance;
  
  public DeactivateMFADeviceResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeactivateMFADeviceResult deactivateMFADeviceResult = new DeactivateMFADeviceResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deactivateMFADeviceResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deactivateMFADeviceResult;
        }
      }
    }
  }
  
  public static DeactivateMFADeviceResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeactivateMFADeviceResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeactivateMFADeviceResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */