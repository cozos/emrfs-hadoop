package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ShrinkPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ShrinkPolicyJsonUnmarshaller
  implements Unmarshaller<ShrinkPolicy, JsonUnmarshallerContext>
{
  private static ShrinkPolicyJsonUnmarshaller instance;
  
  public ShrinkPolicy unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ShrinkPolicy shrinkPolicy = new ShrinkPolicy();
    
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
        if (context.testExpression("DecommissionTimeout", targetDepth))
        {
          context.nextToken();
          shrinkPolicy.setDecommissionTimeout((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("InstanceResizePolicy", targetDepth))
        {
          context.nextToken();
          shrinkPolicy.setInstanceResizePolicy(InstanceResizePolicyJsonUnmarshaller.getInstance().unmarshall(context));
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
    return shrinkPolicy;
  }
  
  public static ShrinkPolicyJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ShrinkPolicyJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ShrinkPolicyJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */