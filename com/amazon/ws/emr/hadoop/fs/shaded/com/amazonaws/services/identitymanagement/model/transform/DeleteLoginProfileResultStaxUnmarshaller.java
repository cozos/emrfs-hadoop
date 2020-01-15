package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteLoginProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteLoginProfileResultStaxUnmarshaller
  implements Unmarshaller<DeleteLoginProfileResult, StaxUnmarshallerContext>
{
  private static DeleteLoginProfileResultStaxUnmarshaller instance;
  
  public DeleteLoginProfileResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteLoginProfileResult deleteLoginProfileResult = new DeleteLoginProfileResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteLoginProfileResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteLoginProfileResult;
        }
      }
    }
  }
  
  public static DeleteLoginProfileResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteLoginProfileResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteLoginProfileResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */