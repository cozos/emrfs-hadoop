package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DecodeAuthorizationMessageResultStaxUnmarshaller
  implements Unmarshaller<DecodeAuthorizationMessageResult, StaxUnmarshallerContext>
{
  private static DecodeAuthorizationMessageResultStaxUnmarshaller instance;
  
  public DecodeAuthorizationMessageResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DecodeAuthorizationMessageResult decodeAuthorizationMessageResult = new DecodeAuthorizationMessageResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return decodeAuthorizationMessageResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("DecodedMessage", targetDepth)) {
          decodeAuthorizationMessageResult.setDecodedMessage(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return decodeAuthorizationMessageResult;
      }
    }
  }
  
  public static DecodeAuthorizationMessageResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DecodeAuthorizationMessageResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.DecodeAuthorizationMessageResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */