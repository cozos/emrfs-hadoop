package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketPolicyStatusResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PolicyStatus;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XmlUtils;
import java.io.InputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

public class GetBucketPolicyStatusStaxUnmarshaller
  implements Unmarshaller<GetBucketPolicyStatusResult, InputStream>
{
  private static final GetBucketPolicyStatusStaxUnmarshaller instance = new GetBucketPolicyStatusStaxUnmarshaller();
  
  public static GetBucketPolicyStatusStaxUnmarshaller getInstance()
  {
    return instance;
  }
  
  public GetBucketPolicyStatusResult unmarshall(InputStream inputStream)
    throws Exception
  {
    StaxUnmarshallerContext context = new StaxUnmarshallerContext(XmlUtils.getXmlInputFactory().createXMLEventReader(inputStream));
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    GetBucketPolicyStatusResult result = new GetBucketPolicyStatusResult();
    PolicyStatus policyStatus = new PolicyStatus();
    result.setPolicyStatus(policyStatus);
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return result;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("IsPublic", targetDepth)) {
          policyStatus.setIsPublic(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.GetBucketPolicyStatusStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */