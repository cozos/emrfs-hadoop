package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteInstanceProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteInstanceProfileResultStaxUnmarshaller
  implements Unmarshaller<DeleteInstanceProfileResult, StaxUnmarshallerContext>
{
  private static DeleteInstanceProfileResultStaxUnmarshaller instance;
  
  public DeleteInstanceProfileResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteInstanceProfileResult deleteInstanceProfileResult = new DeleteInstanceProfileResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteInstanceProfileResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteInstanceProfileResult;
        }
      }
    }
  }
  
  public static DeleteInstanceProfileResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteInstanceProfileResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteInstanceProfileResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */