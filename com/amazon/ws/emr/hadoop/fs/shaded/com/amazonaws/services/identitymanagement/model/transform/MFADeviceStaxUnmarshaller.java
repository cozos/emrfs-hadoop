package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.MFADevice;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class MFADeviceStaxUnmarshaller
  implements Unmarshaller<MFADevice, StaxUnmarshallerContext>
{
  private static MFADeviceStaxUnmarshaller instance;
  
  public MFADevice unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    MFADevice mFADevice = new MFADevice();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return mFADevice;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("UserName", targetDepth)) {
          mFADevice.setUserName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("SerialNumber", targetDepth)) {
          mFADevice.setSerialNumber(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("EnableDate", targetDepth)) {
          mFADevice.setEnableDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return mFADevice;
      }
    }
  }
  
  public static MFADeviceStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new MFADeviceStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.MFADeviceStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */