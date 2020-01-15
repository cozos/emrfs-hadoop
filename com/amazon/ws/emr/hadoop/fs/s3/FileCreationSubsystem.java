package com.amazon.ws.emr.hadoop.fs.s3;

import com.amazon.ws.emr.hadoop.fs.s3.upload.plan.UploadPlanner;
import com.amazon.ws.emr.hadoop.fs.staging.StagingMechanism;
import java.io.Closeable;
import java.io.IOException;
import lombok.NonNull;

public final class FileCreationSubsystem
  implements Closeable
{
  @NonNull
  private final StagingMechanism stagingMechanism;
  @NonNull
  private final UploadPlanner uploadPlanner;
  
  public FileCreationSubsystem(@NonNull StagingMechanism stagingMechanism, @NonNull UploadPlanner uploadPlanner)
  {
    if (stagingMechanism == null) {
      throw new NullPointerException("stagingMechanism");
    }
    if (uploadPlanner == null) {
      throw new NullPointerException("uploadPlanner");
    }
    this.stagingMechanism = stagingMechanism;this.uploadPlanner = uploadPlanner;
  }
  
  @NonNull
  public StagingMechanism getStagingMechanism()
  {
    return stagingMechanism;
  }
  
  @NonNull
  public UploadPlanner getUploadPlanner()
  {
    return uploadPlanner;
  }
  
  public void close()
    throws IOException
  {
    stagingMechanism.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.FileCreationSubsystem
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */