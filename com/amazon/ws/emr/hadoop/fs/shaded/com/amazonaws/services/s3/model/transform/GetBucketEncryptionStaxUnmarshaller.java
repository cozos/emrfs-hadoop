package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketEncryptionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ServerSideEncryptionConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XmlUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

public class GetBucketEncryptionStaxUnmarshaller
  implements Unmarshaller<GetBucketEncryptionResult, InputStream>
{
  private static final GetBucketEncryptionStaxUnmarshaller instance = new GetBucketEncryptionStaxUnmarshaller();
  
  public static GetBucketEncryptionStaxUnmarshaller getInstance()
  {
    return instance;
  }
  
  public GetBucketEncryptionResult unmarshall(InputStream inputStream)
    throws Exception
  {
    StaxUnmarshallerContext context = new StaxUnmarshallerContext(XmlUtils.getXmlInputFactory().createXMLEventReader(inputStream));
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    GetBucketEncryptionResult result = new GetBucketEncryptionResult();
    ServerSideEncryptionConfiguration sseConfig = new ServerSideEncryptionConfiguration();
    result.setServerSideEncryptionConfiguration(sseConfig);
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return result;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Rule", targetDepth))
        {
          if (sseConfig.getRules() == null) {
            sseConfig.setRules(new ArrayList());
          }
          sseConfig.getRules().add(ServerSideEncryptionRuleStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return result;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.GetBucketEncryptionStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */