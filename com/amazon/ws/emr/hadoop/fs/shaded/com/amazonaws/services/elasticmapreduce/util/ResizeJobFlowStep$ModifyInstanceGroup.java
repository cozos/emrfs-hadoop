package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import java.util.ArrayList;
import java.util.List;

public class ResizeJobFlowStep$ModifyInstanceGroup
  implements ResizeJobFlowStep.ResizeAction
{
  private String instanceGroup;
  private Integer instanceCount;
  
  public ModifyInstanceGroup withInstanceGroup(String instanceGroup)
  {
    this.instanceGroup = instanceGroup;
    return this;
  }
  
  public ModifyInstanceGroup withInstanceCount(Integer instanceCount)
  {
    this.instanceCount = instanceCount;
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
    List<String> args = new ArrayList();
    args.add("--modify-instance-group");
    args.add(instanceGroup);
    args.add("--instance-count");
    args.add(Integer.toString(instanceCount.intValue()));
    return args;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util.ResizeJobFlowStep.ModifyInstanceGroup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */