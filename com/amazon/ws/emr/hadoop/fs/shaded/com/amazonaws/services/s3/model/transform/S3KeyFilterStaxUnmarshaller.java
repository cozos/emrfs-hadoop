package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3KeyFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

class S3KeyFilterStaxUnmarshaller
  implements Unmarshaller<S3KeyFilter, StaxUnmarshallerContext>
{
  private static final S3KeyFilterStaxUnmarshaller instance = new S3KeyFilterStaxUnmarshaller();
  
  public static S3KeyFilterStaxUnmarshaller getInstance()
  {
    return instance;
  }
  
  public S3KeyFilter unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    S3KeyFilter filter = new S3KeyFilter();
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return filter;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("FilterRule", targetDepth)) {
          filter.addFilterRule(FilterRuleStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return filter;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.S3KeyFilterStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */