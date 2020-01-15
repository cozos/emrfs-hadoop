package com.amazon.ws.emr.hadoop.fs.s3.upload.plan;

import com.amazon.ws.emr.hadoop.fs.util.io.IOPredicate;
import lombok.NonNull;
import org.apache.hadoop.fs.Path;

public final class RegularUploadPlannerFactory
  implements UploadPlannerFactory
{
  @NonNull
  private final IOPredicate<Path> existenceCheck;
  
  public RegularUploadPlannerFactory(@NonNull IOPredicate<Path> existenceCheck)
  {
    if (existenceCheck == null) {
      throw new NullPointerException("existenceCheck");
    }
    this.existenceCheck = existenceCheck;
  }
  
  public UploadPlanner create(UploadPlanTemplate template)
  {
    return new RegularUploadPlanner(template, existenceCheck);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.plan.RegularUploadPlannerFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */