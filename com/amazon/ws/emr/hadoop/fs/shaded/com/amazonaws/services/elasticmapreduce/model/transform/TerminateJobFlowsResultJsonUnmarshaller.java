package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.TerminateJobFlowsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class TerminateJobFlowsResultJsonUnmarshaller
  implements Unmarshaller<TerminateJobFlowsResult, JsonUnmarshallerContext>
{
  private static TerminateJobFlowsResultJsonUnmarshaller instance;
  
  public TerminateJobFlowsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    TerminateJobFlowsResult terminateJobFlowsResult = new TerminateJobFlowsResult();
    
    return terminateJobFlowsResult;
  }
  
  public static TerminateJobFlowsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new TerminateJobFlowsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.TerminateJobFlowsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */