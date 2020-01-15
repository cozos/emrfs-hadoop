package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PortRange;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class PortRangeJsonUnmarshaller
  implements Unmarshaller<PortRange, JsonUnmarshallerContext>
{
  private static PortRangeJsonUnmarshaller instance;
  
  public PortRange unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    PortRange portRange = new PortRange();
    
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
        if (context.testExpression("MinRange", targetDepth))
        {
          context.nextToken();
          portRange.setMinRange((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("MaxRange", targetDepth))
        {
          context.nextToken();
          portRange.setMaxRange((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
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
    return portRange;
  }
  
  public static PortRangeJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PortRangeJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.PortRangeJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */