package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ServerSideEncryptionRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

class ServerSideEncryptionRuleStaxUnmarshaller
  implements Unmarshaller<ServerSideEncryptionRule, StaxUnmarshallerContext>
{
  private static final ServerSideEncryptionRuleStaxUnmarshaller instance = new ServerSideEncryptionRuleStaxUnmarshaller();
  
  public static ServerSideEncryptionRuleStaxUnmarshaller getInstance()
  {
    return instance;
  }
  
  public ServerSideEncryptionRule unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    ServerSideEncryptionRule rule = new ServerSideEncryptionRule();
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return rule;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("ApplyServerSideEncryptionByDefault", targetDepth)) {
          rule.setApplyServerSideEncryptionByDefault(
            ServerSideEncryptionByDefaultStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return rule;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.ServerSideEncryptionRuleStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */