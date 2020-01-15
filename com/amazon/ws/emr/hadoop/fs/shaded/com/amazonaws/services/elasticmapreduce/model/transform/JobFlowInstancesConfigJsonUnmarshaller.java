package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.JobFlowInstancesConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class JobFlowInstancesConfigJsonUnmarshaller
  implements Unmarshaller<JobFlowInstancesConfig, JsonUnmarshallerContext>
{
  private static JobFlowInstancesConfigJsonUnmarshaller instance;
  
  public JobFlowInstancesConfig unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    JobFlowInstancesConfig jobFlowInstancesConfig = new JobFlowInstancesConfig();
    
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
          jobFlowInstancesConfig.setMasterInstanceType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("SlaveInstanceType", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setSlaveInstanceType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceCount", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setInstanceCount((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("InstanceGroups", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setInstanceGroups(new ListUnmarshaller(InstanceGroupConfigJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("InstanceFleets", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setInstanceFleets(new ListUnmarshaller(InstanceFleetConfigJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("Ec2KeyName", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setEc2KeyName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Placement", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setPlacement(PlacementTypeJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("KeepJobFlowAliveWhenNoSteps", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setKeepJobFlowAliveWhenNoSteps((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("TerminationProtected", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setTerminationProtected((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("HadoopVersion", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setHadoopVersion((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Ec2SubnetId", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setEc2SubnetId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Ec2SubnetIds", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setEc2SubnetIds(new ListUnmarshaller(context.getUnmarshaller(String.class)).unmarshall(context));
        }
        if (context.testExpression("EmrManagedMasterSecurityGroup", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setEmrManagedMasterSecurityGroup((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("EmrManagedSlaveSecurityGroup", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setEmrManagedSlaveSecurityGroup((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ServiceAccessSecurityGroup", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setServiceAccessSecurityGroup((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("AdditionalMasterSecurityGroups", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setAdditionalMasterSecurityGroups(new ListUnmarshaller(context.getUnmarshaller(String.class))
            .unmarshall(context));
        }
        if (context.testExpression("AdditionalSlaveSecurityGroups", targetDepth))
        {
          context.nextToken();
          jobFlowInstancesConfig.setAdditionalSlaveSecurityGroups(new ListUnmarshaller(context.getUnmarshaller(String.class))
            .unmarshall(context));
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
    return jobFlowInstancesConfig;
  }
  
  public static JobFlowInstancesConfigJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new JobFlowInstancesConfigJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.JobFlowInstancesConfigJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */