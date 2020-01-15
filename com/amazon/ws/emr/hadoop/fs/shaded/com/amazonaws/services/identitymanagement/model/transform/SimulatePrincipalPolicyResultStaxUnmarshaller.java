package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EvaluationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SimulatePrincipalPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class SimulatePrincipalPolicyResultStaxUnmarshaller
  implements Unmarshaller<SimulatePrincipalPolicyResult, StaxUnmarshallerContext>
{
  private static SimulatePrincipalPolicyResultStaxUnmarshaller instance;
  
  public SimulatePrincipalPolicyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    SimulatePrincipalPolicyResult simulatePrincipalPolicyResult = new SimulatePrincipalPolicyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return simulatePrincipalPolicyResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("EvaluationResults", targetDepth)) {
          simulatePrincipalPolicyResult.withEvaluationResults(new ArrayList());
        } else if (context.testExpression("EvaluationResults/member", targetDepth)) {
          simulatePrincipalPolicyResult.withEvaluationResults(new EvaluationResult[] { EvaluationResultStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("IsTruncated", targetDepth)) {
          simulatePrincipalPolicyResult.setIsTruncated(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Marker", targetDepth)) {
          simulatePrincipalPolicyResult.setMarker(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return simulatePrincipalPolicyResult;
      }
    }
  }
  
  public static SimulatePrincipalPolicyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SimulatePrincipalPolicyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SimulatePrincipalPolicyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */