package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.HadoopJarStepConfig;
import java.util.ArrayList;
import java.util.List;

public class ResizeJobFlowStep
{
  private String bucket;
  
  public static enum OnArrested
  {
    Fail,  Wait,  Continue;
    
    private OnArrested() {}
  }
  
  public static enum OnFailure
  {
    Fail,  Continue;
    
    private OnFailure() {}
  }
  
  private List<String> args = new ArrayList();
  private boolean wait = true;
  private OnArrested onArrested = null;
  private OnFailure onFailure = null;
  
  public ResizeJobFlowStep()
  {
    this("us-east-1.elasticmapreduce");
  }
  
  public ResizeJobFlowStep(String bucket)
  {
    this.bucket = bucket;
  }
  
  public ResizeJobFlowStep withResizeAction(ResizeAction resizeAction)
  {
    args.addAll(resizeAction.getArgs());
    return this;
  }
  
  public ResizeJobFlowStep withWait(boolean wait)
  {
    this.wait = wait;
    return this;
  }
  
  public ResizeJobFlowStep withOnArrested(OnArrested onArrested)
  {
    this.onArrested = onArrested;
    return this;
  }
  
  public ResizeJobFlowStep withOnFailure(OnFailure onFailure)
  {
    this.onFailure = onFailure;
    return this;
  }
  
  public HadoopJarStepConfig toHadoopJarStepConfig()
  {
    if (args.size() == 0) {
      throw new AmazonServiceException("Cannot create a ResizeJobFlowStep with no resize actions.");
    }
    if (!wait) {
      args.add("--no-wait");
    }
    if (onArrested != null)
    {
      args.add("--on-arrested");
      args.add(onArrested.toString());
    }
    if (onFailure != null)
    {
      args.add("--on-failure");
      args.add(onFailure.toString());
    }
    return 
    
      new HadoopJarStepConfig().withJar("s3://" + bucket + "/libs/resize-job-flow/0.1/resize-job-flow.jar").withArgs(args);
  }
  
  public static abstract interface ResizeAction
  {
    public abstract List<String> getArgs();
  }
  
  public static class ModifyInstanceGroup
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
  
  public static class AddInstanceGroup
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.util.ResizeJobFlowStep
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */