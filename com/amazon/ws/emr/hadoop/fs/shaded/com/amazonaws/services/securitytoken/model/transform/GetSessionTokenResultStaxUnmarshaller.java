package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GetSessionTokenResultStaxUnmarshaller
  implements Unmarshaller<GetSessionTokenResult, StaxUnmarshallerContext>
{
  private static GetSessionTokenResultStaxUnmarshaller instance;
  
  public GetSessionTokenResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetSessionTokenResult getSessionTokenResult = new GetSessionTokenResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getSessionTokenResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Credentials", targetDepth)) {
          getSessionTokenResult.setCredentials(CredentialsStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getSessionTokenResult;
      }
    }
  }
  
  public static GetSessionTokenResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetSessionTokenResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.GetSessionTokenResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */