package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.VirtualMFADevice;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class VirtualMFADeviceStaxUnmarshaller
  implements Unmarshaller<VirtualMFADevice, StaxUnmarshallerContext>
{
  private static VirtualMFADeviceStaxUnmarshaller instance;
  
  public VirtualMFADevice unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    VirtualMFADevice virtualMFADevice = new VirtualMFADevice();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return virtualMFADevice;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("SerialNumber", targetDepth)) {
          virtualMFADevice.setSerialNumber(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Base32StringSeed", targetDepth)) {
          virtualMFADevice.setBase32StringSeed(SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("QRCodePNG", targetDepth)) {
          virtualMFADevice.setQRCodePNG(SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("User", targetDepth)) {
          virtualMFADevice.setUser(UserStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("EnableDate", targetDepth)) {
          virtualMFADevice.setEnableDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return virtualMFADevice;
      }
    }
  }
  
  public static VirtualMFADeviceStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new VirtualMFADeviceStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.VirtualMFADeviceStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */