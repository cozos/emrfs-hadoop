package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

public abstract interface UploadPlannerFactory
{
  public abstract UploadPlanner create(UploadPlanTemplate paramUploadPlanTemplate);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlannerFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */