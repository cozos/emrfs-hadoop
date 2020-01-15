package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.JobFlowDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class JobFlowDetailJsonUnmarshaller
  implements Unmarshaller<JobFlowDetail, JsonUnmarshallerContext>
{
  private static JobFlowDetailJsonUnmarshaller instance;
  
  public JobFlowDetail unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    JobFlowDetail jobFlowDetail = new JobFlowDetail();
    
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
        if (context.testExpression("JobFlowId", targetDepth))
        {
          context.nextToken();
          jobFlowDetail.setJobFlowId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Name", targetDepth))
        {
          context.nextToken();
          jobFlowDetail.setName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("LogUri", targetDepth))
        {
          context.nextToken();
          jobFlowDetail.setLogUri((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("AmiVersion", targetDepth))
        {
          context.nextToken();
          jobFlowDetail.setAmiVersion((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ExecutionStatusDetail", targetDepth))
        {
          context.nextToken();
          jobFlowDetail.setExecutionStatusDetail(JobFlowExecutionStatusDetailJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Instances", targetDepth))
        {
          context.nextToken();
          jobFlowDetail.setInstances(JobFlowInstancesDetailJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Steps", targetDepth))
        {
          context.nextToken();
          jobFlowDetail.setSteps(new ListUnmarshaller(StepDetailJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("BootstrapActions", targetDepth))
        {
          context.nextToken();
          jobFlowDetail.setBootstrapActions(new ListUnmarshaller(BootstrapActionDetailJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("SupportedProducts", targetDepth))
        {
          context.nextToken();
          jobFlowDetail.setSupportedProducts(new ListUnmarshaller(context.getUnmarshaller(String.class)).unmarshall(context));
        }
        if (context.testExpression("VisibleToAllUsers", targetDepth))
        {
          context.nextToken();
          jobFlowDetail.setVisibleToAllUsers((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("JobFlowRole", targetDepth))
        {
          context.nextToken();
          jobFlowDetail.setJobFlowRole((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ServiceRole", targetDepth))
        {
          context.nextToken();
          jobFlowDetail.setServiceRole((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("AutoScalingRole", targetDepth))
        {
          context.nextToken();
          jobFlowDetail.setAutoScalingRole((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ScaleDownBehavior", targetDepth))
        {
          context.nextToken();
          jobFlowDetail.setScaleDownBehavior((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return jobFlowDetail;
  }
  
  public static JobFlowDetailJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new JobFlowDetailJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.JobFlowDetailJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */