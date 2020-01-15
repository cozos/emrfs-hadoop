package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityResult;
import javax.xml.stream.events.XMLEvent;

public class ChangeMessageVisibilityResultStaxUnmarshaller
  implements Unmarshaller<ChangeMessageVisibilityResult, StaxUnmarshallerContext>
{
  private static ChangeMessageVisibilityResultStaxUnmarshaller instance;
  
  public ChangeMessageVisibilityResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ChangeMessageVisibilityResult changeMessageVisibilityResult = new ChangeMessageVisibilityResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return changeMessageVisibilityResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return changeMessageVisibilityResult;
        }
      }
    }
  }
  
  public static ChangeMessageVisibilityResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ChangeMessageVisibilityResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.ChangeMessageVisibilityResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */