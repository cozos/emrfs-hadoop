package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateVirtualMFADeviceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class CreateVirtualMFADeviceResultStaxUnmarshaller
  implements Unmarshaller<CreateVirtualMFADeviceResult, StaxUnmarshallerContext>
{
  private static CreateVirtualMFADeviceResultStaxUnmarshaller instance;
  
  public CreateVirtualMFADeviceResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    CreateVirtualMFADeviceResult createVirtualMFADeviceResult = new CreateVirtualMFADeviceResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return createVirtualMFADeviceResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("VirtualMFADevice", targetDepth)) {
          createVirtualMFADeviceResult.setVirtualMFADevice(VirtualMFADeviceStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return createVirtualMFADeviceResult;
      }
    }
  }
  
  public static CreateVirtualMFADeviceResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CreateVirtualMFADeviceResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateVirtualMFADeviceResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */