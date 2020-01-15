package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAccessKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class UpdateAccessKeyResultStaxUnmarshaller
  implements Unmarshaller<UpdateAccessKeyResult, StaxUnmarshallerContext>
{
  private static UpdateAccessKeyResultStaxUnmarshaller instance;
  
  public UpdateAccessKeyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UpdateAccessKeyResult updateAccessKeyResult = new UpdateAccessKeyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return updateAccessKeyResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return updateAccessKeyResult;
        }
      }
    }
  }
  
  public static UpdateAccessKeyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateAccessKeyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateAccessKeyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */