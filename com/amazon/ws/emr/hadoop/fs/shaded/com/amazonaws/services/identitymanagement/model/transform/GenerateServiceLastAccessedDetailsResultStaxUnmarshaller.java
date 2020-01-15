package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateServiceLastAccessedDetailsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GenerateServiceLastAccessedDetailsResultStaxUnmarshaller
  implements Unmarshaller<GenerateServiceLastAccessedDetailsResult, StaxUnmarshallerContext>
{
  private static GenerateServiceLastAccessedDetailsResultStaxUnmarshaller instance;
  
  public GenerateServiceLastAccessedDetailsResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GenerateServiceLastAccessedDetailsResult generateServiceLastAccessedDetailsResult = new GenerateServiceLastAccessedDetailsResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return generateServiceLastAccessedDetailsResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("JobId", targetDepth)) {
          generateServiceLastAccessedDetailsResult.setJobId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return generateServiceLastAccessedDetailsResult;
      }
    }
  }
  
  public static GenerateServiceLastAccessedDetailsResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GenerateServiceLastAccessedDetailsResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GenerateServiceLastAccessedDetailsResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */