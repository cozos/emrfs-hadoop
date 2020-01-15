package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import org.apache.hadoop.fs.Path;

abstract interface ConditionalUploadPlanner
  extends UploadPlanner
{
  public abstract boolean canPlan(Path paramPath);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.ConditionalUploadPlanner
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */