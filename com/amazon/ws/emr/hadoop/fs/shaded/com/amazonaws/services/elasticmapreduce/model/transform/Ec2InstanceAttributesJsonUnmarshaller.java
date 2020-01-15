package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Ec2InstanceAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class Ec2InstanceAttributesJsonUnmarshaller
  implements Unmarshaller<Ec2InstanceAttributes, JsonUnmarshallerContext>
{
  private static Ec2InstanceAttributesJsonUnmarshaller instance;
  
  public Ec2InstanceAttributes unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    Ec2InstanceAttributes ec2InstanceAttributes = new Ec2InstanceAttributes();
    
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
        if (context.testExpression("Ec2KeyName", targetDepth))
        {
          context.nextToken();
          ec2InstanceAttributes.setEc2KeyName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Ec2SubnetId", targetDepth))
        {
          context.nextToken();
          ec2InstanceAttributes.setEc2SubnetId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("RequestedEc2SubnetIds", targetDepth))
        {
          context.nextToken();
          ec2InstanceAttributes.setRequestedEc2SubnetIds(new ListUnmarshaller(context.getUnmarshaller(String.class)).unmarshall(context));
        }
        if (context.testExpression("Ec2AvailabilityZone", targetDepth))
        {
          context.nextToken();
          ec2InstanceAttributes.setEc2AvailabilityZone((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("RequestedEc2AvailabilityZones", targetDepth))
        {
          context.nextToken();
          ec2InstanceAttributes.setRequestedEc2AvailabilityZones(new ListUnmarshaller(context.getUnmarshaller(String.class))
            .unmarshall(context));
        }
        if (context.testExpression("IamInstanceProfile", targetDepth))
        {
          context.nextToken();
          ec2InstanceAttributes.setIamInstanceProfile((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("EmrManagedMasterSecurityGroup", targetDepth))
        {
          context.nextToken();
          ec2InstanceAttributes.setEmrManagedMasterSecurityGroup((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("EmrManagedSlaveSecurityGroup", targetDepth))
        {
          context.nextToken();
          ec2InstanceAttributes.setEmrManagedSlaveSecurityGroup((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ServiceAccessSecurityGroup", targetDepth))
        {
          context.nextToken();
          ec2InstanceAttributes.setServiceAccessSecurityGroup((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("AdditionalMasterSecurityGroups", targetDepth))
        {
          context.nextToken();
          ec2InstanceAttributes.setAdditionalMasterSecurityGroups(new ListUnmarshaller(context.getUnmarshaller(String.class))
            .unmarshall(context));
        }
        if (context.testExpression("AdditionalSlaveSecurityGroups", targetDepth))
        {
          context.nextToken();
          ec2InstanceAttributes.setAdditionalSlaveSecurityGroups(new ListUnmarshaller(context.getUnmarshaller(String.class))
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
    return ec2InstanceAttributes;
  }
  
  public static Ec2InstanceAttributesJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new Ec2InstanceAttributesJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.Ec2InstanceAttributesJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */