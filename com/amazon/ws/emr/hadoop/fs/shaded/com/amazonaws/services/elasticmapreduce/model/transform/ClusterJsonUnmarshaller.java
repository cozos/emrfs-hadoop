package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Cluster;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ClusterJsonUnmarshaller
  implements Unmarshaller<Cluster, JsonUnmarshallerContext>
{
  private static ClusterJsonUnmarshaller instance;
  
  public Cluster unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    Cluster cluster = new Cluster();
    
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
        if (context.testExpression("Id", targetDepth))
        {
          context.nextToken();
          cluster.setId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Name", targetDepth))
        {
          context.nextToken();
          cluster.setName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Status", targetDepth))
        {
          context.nextToken();
          cluster.setStatus(ClusterStatusJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Ec2InstanceAttributes", targetDepth))
        {
          context.nextToken();
          cluster.setEc2InstanceAttributes(Ec2InstanceAttributesJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("InstanceCollectionType", targetDepth))
        {
          context.nextToken();
          cluster.setInstanceCollectionType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("LogUri", targetDepth))
        {
          context.nextToken();
          cluster.setLogUri((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("RequestedAmiVersion", targetDepth))
        {
          context.nextToken();
          cluster.setRequestedAmiVersion((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("RunningAmiVersion", targetDepth))
        {
          context.nextToken();
          cluster.setRunningAmiVersion((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ReleaseLabel", targetDepth))
        {
          context.nextToken();
          cluster.setReleaseLabel((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("AutoTerminate", targetDepth))
        {
          context.nextToken();
          cluster.setAutoTerminate((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("TerminationProtected", targetDepth))
        {
          context.nextToken();
          cluster.setTerminationProtected((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("VisibleToAllUsers", targetDepth))
        {
          context.nextToken();
          cluster.setVisibleToAllUsers((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("Applications", targetDepth))
        {
          context.nextToken();
          cluster.setApplications(new ListUnmarshaller(ApplicationJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("Tags", targetDepth))
        {
          context.nextToken();
          cluster.setTags(new ListUnmarshaller(TagJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("ServiceRole", targetDepth))
        {
          context.nextToken();
          cluster.setServiceRole((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("NormalizedInstanceHours", targetDepth))
        {
          context.nextToken();
          cluster.setNormalizedInstanceHours((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("MasterPublicDnsName", targetDepth))
        {
          context.nextToken();
          cluster.setMasterPublicDnsName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Configurations", targetDepth))
        {
          context.nextToken();
          cluster.setConfigurations(new ListUnmarshaller(ConfigurationJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("SecurityConfiguration", targetDepth))
        {
          context.nextToken();
          cluster.setSecurityConfiguration((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("AutoScalingRole", targetDepth))
        {
          context.nextToken();
          cluster.setAutoScalingRole((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ScaleDownBehavior", targetDepth))
        {
          context.nextToken();
          cluster.setScaleDownBehavior((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CustomAmiId", targetDepth))
        {
          context.nextToken();
          cluster.setCustomAmiId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("EbsRootVolumeSize", targetDepth))
        {
          context.nextToken();
          cluster.setEbsRootVolumeSize((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("RepoUpgradeOnBoot", targetDepth))
        {
          context.nextToken();
          cluster.setRepoUpgradeOnBoot((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("KerberosAttributes", targetDepth))
        {
          context.nextToken();
          cluster.setKerberosAttributes(KerberosAttributesJsonUnmarshaller.getInstance().unmarshall(context));
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
    return cluster;
  }
  
  public static ClusterJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ClusterJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ClusterJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */