package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import java.util.ArrayList;
import java.util.List;

public class ResizeJobFlowStep$AddInstanceGroup
  implements ResizeJobFlowStep.ResizeAction
{
  private String instanceGroup;
  private Integer instanceCount;
  private String instanceType;
  
  public AddInstanceGroup withInstanceGroup(String instanceGroup)
  {
    this.instanceGroup = instanceGroup;
    return this;
  }
  
  public AddInstanceGroup withInstanceCount(int instanceCount)
  {
    this.instanceCount = Integer.valueOf(instanceCount);
    return this;
  }
  
  public AddInstanceGroup withInstanceType(String instanceType)
  {
    this.instanceType = instanceType;
    return this;
  }
  
  public List<String> getArgs()
  {
    if (instanceGroup == null) {
      throw new AmazonServiceException("InstanceGroup must not be null.");
    }
    if (instanceCount == null) {
      throw new AmazonServiceException("InstanceCount must not be null.");
    }
    if (instanceType == null) {
      throw new AmazonServiceException("InstanceType must not be null.");
    }
    List<String> args = new ArrayList();
    args.add("--add-instance-group");
    args.add(instanceGroup);
    args.add("--instance-count");
    args.add(Integer.toString(instanceCount.intValue()));
    args.add("--instance-type");
    args.add(instanceType);
    return args;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util.ResizeJobFlowStep.AddInstanceGroup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */