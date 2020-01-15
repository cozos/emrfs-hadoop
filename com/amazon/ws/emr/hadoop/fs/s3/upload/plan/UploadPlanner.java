package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import java.io.IOException;
import org.apache.hadoop.fs.Path;

public abstract interface UploadPlanner
{
  public abstract UploadPlan plan(Path paramPath, boolean paramBoolean)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlanner
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */