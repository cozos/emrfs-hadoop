package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetPublicAccessBlockResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PublicAccessBlockConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XmlUtils;
import java.io.InputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

public class GetPublicAccessBlockStaxUnmarshaller
  implements Unmarshaller<GetPublicAccessBlockResult, InputStream>
{
  private static final GetPublicAccessBlockStaxUnmarshaller instance = new GetPublicAccessBlockStaxUnmarshaller();
  
  public static GetPublicAccessBlockStaxUnmarshaller getInstance()
  {
    return instance;
  }
  
  public GetPublicAccessBlockResult unmarshall(InputStream inputStream)
    throws Exception
  {
    StaxUnmarshallerContext context = new StaxUnmarshallerContext(XmlUtils.getXmlInputFactory().createXMLEventReader(inputStream));
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    GetPublicAccessBlockResult result = new GetPublicAccessBlockResult();
    PublicAccessBlockConfiguration configuration = new PublicAccessBlockConfiguration();
    result.setPublicAccessBlockConfiguration(configuration);
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return result;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("BlockPublicAcls", targetDepth)) {
          configuration.setBlockPublicAcls(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("IgnorePublicAcls", targetDepth)) {
          configuration.setIgnorePublicAcls(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("BlockPublicPolicy", targetDepth)) {
          configuration.setBlockPublicPolicy(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("RestrictPublicBuckets", targetDepth)) {
          configuration.setRestrictPublicBuckets(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth))
      {
        return result;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.GetPublicAccessBlockStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */