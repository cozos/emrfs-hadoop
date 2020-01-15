package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListVirtualMFADevicesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.VirtualMFADevice;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListVirtualMFADevicesResultStaxUnmarshaller
  implements Unmarshaller<ListVirtualMFADevicesResult, StaxUnmarshallerContext>
{
  private static ListVirtualMFADevicesResultStaxUnmarshaller instance;
  
  public ListVirtualMFADevicesResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListVirtualMFADevicesResult listVirtualMFADevicesResult = new ListVirtualMFADevicesResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listVirtualMFADevicesResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("VirtualMFADevices", targetDepth)) {
          listVirtualMFADevicesResult.withVirtualMFADevices(new ArrayList());
        } else if (context.testExpression("VirtualMFADevices/member", targetDepth)) {
          listVirtualMFADevicesResult.withVirtualMFADevices(new VirtualMFADevice[] { VirtualMFADeviceStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("IsTruncated", targetDepth)) {
          listVirtualMFADevicesResult.setIsTruncated(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Marker", targetDepth)) {
          listVirtualMFADevicesResult.setMarker(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listVirtualMFADevicesResult;
      }
    }
  }
  
  public static ListVirtualMFADevicesResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListVirtualMFADevicesResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListVirtualMFADevicesResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */