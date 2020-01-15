package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.JobFlowInstancesDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class JobFlowInstancesDetailJsonUnmarshaller
  implements Unmarshaller<JobFlowInstancesDetail, JsonUnmarshallerContext>
{
  private static JobFlowInstancesDetailJsonUnmarshaller instance;
  
  public JobFlowInstancesDetail unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    JobFlowInstancesDetail jobFlowInstancesDetail = new JobFlowInstancesDetail();
    
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
        if (context.testExpression("MasterInstanceType", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesDetail.setMasterInstanceType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("MasterPublicDnsName", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesDetail.setMasterPublicDnsName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("MasterInstanceId", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesDetail.setMasterInstanceId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("SlaveInstanceType", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesDetail.setSlaveInstanceType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceCount", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesDetail.setInstanceCount((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("InstanceGroups", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesDetail.setInstanceGroups(new ListUnmarshaller(InstanceGroupDetailJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("NormalizedInstanceHours", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesDetail.setNormalizedInstanceHours((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("Ec2KeyName", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesDetail.setEc2KeyName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Ec2SubnetId", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesDetail.setEc2SubnetId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Placement", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesDetail.setPlacement(PlacementTypeJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("KeepJobFlowAliveWhenNoSteps", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesDetail.setKeepJobFlowAliveWhenNoSteps((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("TerminationProtected", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesDetail.setTerminationProtected((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("HadoopVersion", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesDetail.setHadoopVersion((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return jobFlowInstancesDetail;
  }
  
  public static JobFlowInstancesDetailJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new JobFlowInstancesDetailJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.JobFlowInstancesDetailJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */