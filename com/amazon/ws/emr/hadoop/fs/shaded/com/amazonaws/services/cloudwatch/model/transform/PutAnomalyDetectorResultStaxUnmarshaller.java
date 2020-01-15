package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutAnomalyDetectorResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class PutAnomalyDetectorResultStaxUnmarshaller
  implements Unmarshaller<PutAnomalyDetectorResult, StaxUnmarshallerContext>
{
  private static PutAnomalyDetectorResultStaxUnmarshaller instance;
  
  public PutAnomalyDetectorResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    PutAnomalyDetectorResult putAnomalyDetectorResult = new PutAnomalyDetectorResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return putAnomalyDetectorResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return putAnomalyDetectorResult;
        }
      }
    }
  }
  
  public static PutAnomalyDetectorResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PutAnomalyDetectorResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutAnomalyDetectorResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */