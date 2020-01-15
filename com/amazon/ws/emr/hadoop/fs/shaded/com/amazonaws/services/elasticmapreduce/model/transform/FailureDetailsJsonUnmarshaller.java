package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.FailureDetails;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class FailureDetailsJsonUnmarshaller
  implements Unmarshaller<FailureDetails, JsonUnmarshallerContext>
{
  private static FailureDetailsJsonUnmarshaller instance;
  
  public FailureDetails unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    FailureDetails failureDetails = new FailureDetails();
    
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
        if (context.testExpression("Reason", targetDepth))
        {
          context.nextToken();
          failureDetails.setReason((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Message", targetDepth))
        {
          context.nextToken();
          failureDetails.setMessage((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("LogFile", targetDepth))
        {
          context.nextToken();
          failureDetails.setLogFile((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return failureDetails;
  }
  
  public static FailureDetailsJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new FailureDetailsJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.FailureDetailsJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */