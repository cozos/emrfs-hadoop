package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceStatus;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class InstanceStatusJsonUnmarshaller
  implements Unmarshaller<InstanceStatus, JsonUnmarshallerContext>
{
  private static InstanceStatusJsonUnmarshaller instance;
  
  public InstanceStatus unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    InstanceStatus instanceStatus = new InstanceStatus();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return null;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("State", targetDepth))
        {
          context.nextToken();
          instanceStatus.setState((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("StateChangeReason", targetDepth))
        {
          context.nextToken();
          instanceStatus.setStateChangeReason(InstanceStateChangeReasonJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Timeline", targetDepth))
        {
          context.nextToken();
          instanceStatus.setTimeline(InstanceTimelineJsonUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else
      {
        if (((token == JsonToken.END_ARRAY) || (token == JsonToken.END_OBJECT)) && 
          ((context.getLastParsedParentElement() == null) || (context.getLastParsedParentElement().equals(currentParentElement))) && 
          (context.getCurrentDepth() <= originalDepth)) {
          break;
        }
      }
      token = context.nextToken();
    }
    return instanceStatus;
  }
  
  public static InstanceStatusJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new InstanceStatusJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceStatusJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */