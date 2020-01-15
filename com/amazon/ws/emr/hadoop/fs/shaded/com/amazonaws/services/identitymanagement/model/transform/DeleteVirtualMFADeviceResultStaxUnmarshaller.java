package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteVirtualMFADeviceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteVirtualMFADeviceResultStaxUnmarshaller
  implements Unmarshaller<DeleteVirtualMFADeviceResult, StaxUnmarshallerContext>
{
  private static DeleteVirtualMFADeviceResultStaxUnmarshaller instance;
  
  public DeleteVirtualMFADeviceResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteVirtualMFADeviceResult deleteVirtualMFADeviceResult = new DeleteVirtualMFADeviceResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteVirtualMFADeviceResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteVirtualMFADeviceResult;
        }
      }
    }
  }
  
  public static DeleteVirtualMFADeviceResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteVirtualMFADeviceResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteVirtualMFADeviceResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */