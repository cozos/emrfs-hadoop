package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAnomalyDetectorResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteAnomalyDetectorResultStaxUnmarshaller
  implements Unmarshaller<DeleteAnomalyDetectorResult, StaxUnmarshallerContext>
{
  private static DeleteAnomalyDetectorResultStaxUnmarshaller instance;
  
  public DeleteAnomalyDetectorResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteAnomalyDetectorResult deleteAnomalyDetectorResult = new DeleteAnomalyDetectorResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteAnomalyDetectorResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteAnomalyDetectorResult;
        }
      }
    }
  }
  
  public static DeleteAnomalyDetectorResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteAnomalyDetectorResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DeleteAnomalyDetectorResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */