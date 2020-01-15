package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

public enum UploadConstraint
{
  SINGLE_PART_UPLOAD,  MULTIPART_UPLOAD;
  
  private UploadConstraint() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadConstraint
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */