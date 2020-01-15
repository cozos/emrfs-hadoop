package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.BootstrapActionDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class BootstrapActionDetailJsonUnmarshaller
  implements Unmarshaller<BootstrapActionDetail, JsonUnmarshallerContext>
{
  private static BootstrapActionDetailJsonUnmarshaller instance;
  
  public BootstrapActionDetail unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    BootstrapActionDetail bootstrapActionDetail = new BootstrapActionDetail();
    
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
        if (context.testExpression("BootstrapActionConfig", targetDepth))
        {
          context.nextToken();
          bootstrapActionDetail.setBootstrapActionConfig(BootstrapActionConfigJsonUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else {
        if (((token == JsonToken.END_ARRAY) || (token == JsonToken.END_OBJECT)) && 
          ((context.getLastParsedParentElement() == null) || (context.getLastParsedParentElement().equals(currentParentElement))) && 
          (context.getCurrentDepth() <= originalDepth)) {
          break;
        }
      }
      token = context.nextToken();
    }
    return bootstrapActionDetail;
  }
  
  public static BootstrapActionDetailJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new BootstrapActionDetailJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.BootstrapActionDetailJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */