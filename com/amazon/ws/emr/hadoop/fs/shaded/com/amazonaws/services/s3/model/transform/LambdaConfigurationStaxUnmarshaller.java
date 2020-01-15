package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CloudFunctionConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Filter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.LambdaConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.NotificationConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import javax.xml.stream.events.XMLEvent;

class LambdaConfigurationStaxUnmarshaller
  implements Unmarshaller<Map.Entry<String, NotificationConfiguration>, StaxUnmarshallerContext>
{
  private static final LambdaConfigurationStaxUnmarshaller instance = new LambdaConfigurationStaxUnmarshaller();
  
  public static LambdaConfigurationStaxUnmarshaller getInstance()
  {
    return instance;
  }
  
  public Map.Entry<String, NotificationConfiguration> unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    String id = null;
    List<String> events = new ArrayList();
    Filter filter = null;
    String functionArn = null;
    String invocationRole = null;
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return createLambdaConfig(id, events, functionArn, invocationRole, filter);
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Id", targetDepth)) {
          id = SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context);
        } else if (context.testExpression("Event", targetDepth)) {
          events.add(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Filter", targetDepth)) {
          filter = FilterStaxUnmarshaller.getInstance().unmarshall(context);
        } else if (context.testExpression("CloudFunction", targetDepth)) {
          functionArn = SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context);
        } else if (context.testExpression("InvocationRole", targetDepth)) {
          invocationRole = SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context);
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return createLambdaConfig(id, events, functionArn, invocationRole, filter);
      }
    }
  }
  
  private Map.Entry<String, NotificationConfiguration> createLambdaConfig(String id, List<String> events, String functionArn, String invocationRole, Filter filter)
  {
    NotificationConfiguration config;
    NotificationConfiguration config;
    if (invocationRole == null) {
      config = new LambdaConfiguration(functionArn, (String[])events.toArray(new String[0]));
    } else {
      config = new CloudFunctionConfiguration(invocationRole, functionArn, (String[])events.toArray(new String[0]));
    }
    return new AbstractMap.SimpleEntry(id, config.withFilter(filter));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.LambdaConfigurationStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */