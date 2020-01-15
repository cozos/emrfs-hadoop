package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import com.amazon.ws.emr.hadoop.fs.consistency.FileStatusExt;
import com.amazon.ws.emr.hadoop.fs.util.io.IOFunction;
import lombok.NonNull;
import org.apache.hadoop.fs.Path;

public final class ConsistentViewUploadPlannerFactory
  implements UploadPlannerFactory
{
  @NonNull
  private final IOFunction<Path, FileStatusExt> statusGetter;
  
  public ConsistentViewUploadPlannerFactory(@NonNull IOFunction<Path, FileStatusExt> statusGetter)
  {
    if (statusGetter == null) {
      throw new NullPointerException("statusGetter");
    }
    this.statusGetter = statusGetter;
  }
  
  public UploadPlanner create(UploadPlanTemplate template)
  {
    return new ConsistentViewUploadPlanner(template, statusGetter);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.ConsistentViewUploadPlannerFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */