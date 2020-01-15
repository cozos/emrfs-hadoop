package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetContextKeysForPrincipalPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class GetContextKeysForPrincipalPolicyResultStaxUnmarshaller
  implements Unmarshaller<GetContextKeysForPrincipalPolicyResult, StaxUnmarshallerContext>
{
  private static GetContextKeysForPrincipalPolicyResultStaxUnmarshaller instance;
  
  public GetContextKeysForPrincipalPolicyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetContextKeysForPrincipalPolicyResult getContextKeysForPrincipalPolicyResult = new GetContextKeysForPrincipalPolicyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getContextKeysForPrincipalPolicyResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("ContextKeyNames", targetDepth)) {
          getContextKeysForPrincipalPolicyResult.withContextKeyNames(new ArrayList());
        } else if (context.testExpression("ContextKeyNames/member", targetDepth)) {
          getContextKeysForPrincipalPolicyResult.withContextKeyNames(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getContextKeysForPrincipalPolicyResult;
      }
    }
  }
  
  public static GetContextKeysForPrincipalPolicyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetContextKeysForPrincipalPolicyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetContextKeysForPrincipalPolicyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */