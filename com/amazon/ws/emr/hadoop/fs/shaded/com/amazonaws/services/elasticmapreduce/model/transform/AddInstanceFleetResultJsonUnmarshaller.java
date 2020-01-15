package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceFleetResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class AddInstanceFleetResultJsonUnmarshaller
  implements Unmarshaller<AddInstanceFleetResult, JsonUnmarshallerContext>
{
  private static AddInstanceFleetResultJsonUnmarshaller instance;
  
  public AddInstanceFleetResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AddInstanceFleetResult addInstanceFleetResult = new AddInstanceFleetResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return addInstanceFleetResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("ClusterId", targetDepth))
        {
          context.nextToken();
          addInstanceFleetResult.setClusterId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceFleetId", targetDepth))
        {
          context.nextToken();
          addInstanceFleetResult.setInstanceFleetId((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return addInstanceFleetResult;
  }
  
  public static AddInstanceFleetResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AddInstanceFleetResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AddInstanceFleetResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */