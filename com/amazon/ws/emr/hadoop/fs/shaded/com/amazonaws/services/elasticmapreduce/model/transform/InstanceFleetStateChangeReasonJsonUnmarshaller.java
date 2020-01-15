package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleetStateChangeReason;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class InstanceFleetStateChangeReasonJsonUnmarshaller
  implements Unmarshaller<InstanceFleetStateChangeReason, JsonUnmarshallerContext>
{
  private static InstanceFleetStateChangeReasonJsonUnmarshaller instance;
  
  public InstanceFleetStateChangeReason unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    InstanceFleetStateChangeReason instanceFleetStateChangeReason = new InstanceFleetStateChangeReason();
    
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
        if (context.testExpression("Code", targetDepth))
        {
          context.nextToken();
          instanceFleetStateChangeReason.setCode((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Message", targetDepth))
        {
          context.nextToken();
          instanceFleetStateChangeReason.setMessage((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return instanceFleetStateChangeReason;
  }
  
  public static InstanceFleetStateChangeReasonJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new InstanceFleetStateChangeReasonJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceFleetStateChangeReasonJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */