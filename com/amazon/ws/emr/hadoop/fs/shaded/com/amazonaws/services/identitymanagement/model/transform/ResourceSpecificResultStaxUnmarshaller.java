package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResourceSpecificResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.Statement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import java.util.Map.Entry;
import javax.xml.stream.events.XMLEvent;

public class ResourceSpecificResultStaxUnmarshaller
  implements Unmarshaller<ResourceSpecificResult, StaxUnmarshallerContext>
{
  private static ResourceSpecificResultStaxUnmarshaller instance;
  
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
  
  public ResourceSpecificResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ResourceSpecificResult resourceSpecificResult = new ResourceSpecificResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return resourceSpecificResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("EvalResourceName", targetDepth))
        {
          resourceSpecificResult.setEvalResourceName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("EvalResourceDecision", targetDepth))
        {
          resourceSpecificResult.setEvalResourceDecision(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("MatchedStatements", targetDepth))
        {
          resourceSpecificResult.withMatchedStatements(new ArrayList());
        }
        else if (context.testExpression("MatchedStatements/member", targetDepth))
        {
          resourceSpecificResult.withMatchedStatements(new Statement[] { StatementStaxUnmarshaller.getInstance().unmarshall(context) });
        }
        else if (context.testExpression("MissingContextValues", targetDepth))
        {
          resourceSpecificResult.withMissingContextValues(new ArrayList());
        }
        else if (context.testExpression("MissingContextValues/member", targetDepth))
        {
          resourceSpecificResult.withMissingContextValues(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        }
        else if (context.testExpression("EvalDecisionDetails/entry", targetDepth))
        {
          Map.Entry<String, String> entry = EvalDecisionDetailsMapEntryUnmarshaller.getInstance().unmarshall(context);
          resourceSpecificResult.addEvalDecisionDetailsEntry((String)entry.getKey(), (String)entry.getValue());
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return resourceSpecificResult;
      }
    }
  }
  
  public static ResourceSpecificResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ResourceSpecificResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ResourceSpecificResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */