package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.JobFlowExecutionStatusDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class JobFlowExecutionStatusDetailJsonUnmarshaller
  implements Unmarshaller<JobFlowExecutionStatusDetail, JsonUnmarshallerContext>
{
  private static JobFlowExecutionStatusDetailJsonUnmarshaller instance;
  
  public JobFlowExecutionStatusDetail unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    JobFlowExecutionStatusDetail jobFlowExecutionStatusDetail = new JobFlowExecutionStatusDetail();
    
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
          jobFlowExecutionStatusDetail.setState((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CreationDateTime", targetDepth))
        {
          context.nextToken();
          jobFlowExecutionStatusDetail.setCreationDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("StartDateTime", targetDepth))
        {
          context.nextToken();
          jobFlowExecutionStatusDetail.setStartDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("ReadyDateTime", targetDepth))
        {
          context.nextToken();
          jobFlowExecutionStatusDetail.setReadyDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("EndDateTime", targetDepth))
        {
          context.nextToken();
          jobFlowExecutionStatusDetail.setEndDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("LastStateChangeReason", targetDepth))
        {
          context.nextToken();
          jobFlowExecutionStatusDetail.setLastStateChangeReason((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return jobFlowExecutionStatusDetail;
  }
  
  public static JobFlowExecutionStatusDetailJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new JobFlowExecutionStatusDetailJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.JobFlowExecutionStatusDetailJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */