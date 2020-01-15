package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EvaluationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResourceSpecificResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.Statement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import java.util.Map.Entry;
import javax.xml.stream.events.XMLEvent;

public class EvaluationResultStaxUnmarshaller
  implements Unmarshaller<EvaluationResult, StaxUnmarshallerContext>
{
  private static EvaluationResultStaxUnmarshaller instance;
  
  private static class EvalDecisionDetailsMapEntryUnmarshaller
    implements Unmarshaller<Map.Entry<String, String>, StaxUnmarshallerContext>
  {
    private static EvalDecisionDetailsMapEntryUnmarshaller instance;
    
    public Map.Entry<String, String> unmarshall(StaxUnmarshallerContext context)
      throws Exception
    {
      int originalDepth = context.getCurrentDepth();
      int targetDepth = originalDepth + 1;
      
      MapEntry<String, String> entry = new MapEntry();
      for (;;)
      {
        XMLEvent xmlEvent = context.nextEvent();
        if (xmlEvent.isEndDocument()) {
          return entry;
        }
        if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
        {
          if (context.testExpression("key", targetDepth)) {
            entry.setKey(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
          } else if (context.testExpression("value", targetDepth)) {
            entry.setValue(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
          }
        }
        else if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return entry;
        }
      }
    }
    
    public static EvalDecisionDetailsMapEntryUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new EvalDecisionDetailsMapEntryUnmarshaller();
      }
      return instance;
    }
  }
  
  public EvaluationResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    EvaluationResult evaluationResult = new EvaluationResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return evaluationResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("EvalActionName", targetDepth))
        {
          evaluationResult.setEvalActionName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("EvalResourceName", targetDepth))
        {
          evaluationResult.setEvalResourceName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("EvalDecision", targetDepth))
        {
          evaluationResult.setEvalDecision(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("MatchedStatements", targetDepth))
        {
          evaluationResult.withMatchedStatements(new ArrayList());
        }
        else if (context.testExpression("MatchedStatements/member", targetDepth))
        {
          evaluationResult.withMatchedStatements(new Statement[] { StatementStaxUnmarshaller.getInstance().unmarshall(context) });
        }
        else if (context.testExpression("MissingContextValues", targetDepth))
        {
          evaluationResult.withMissingContextValues(new ArrayList());
        }
        else if (context.testExpression("MissingContextValues/member", targetDepth))
        {
          evaluationResult.withMissingContextValues(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        }
        else if (context.testExpression("OrganizationsDecisionDetail", targetDepth))
        {
          evaluationResult.setOrganizationsDecisionDetail(OrganizationsDecisionDetailStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("EvalDecisionDetails/entry", targetDepth))
        {
          Map.Entry<String, String> entry = EvalDecisionDetailsMapEntryUnmarshaller.getInstance().unmarshall(context);
          evaluationResult.addEvalDecisionDetailsEntry((String)entry.getKey(), (String)entry.getValue());
        }
        else if (context.testExpression("ResourceSpecificResults", targetDepth))
        {
          evaluationResult.withResourceSpecificResults(new ArrayList());
        }
        else if (context.testExpression("ResourceSpecificResults/member", targetDepth))
        {
          evaluationResult.withResourceSpecificResults(new ResourceSpecificResult[] { ResourceSpecificResultStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return evaluationResult;
      }
    }
  }
  
  public static EvaluationResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new EvaluationResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.EvaluationResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */