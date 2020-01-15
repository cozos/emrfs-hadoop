package com.amazon.ws.emr.hadoop.fs.s3.lite.executor;

import com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Call;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;

public final class SimpleS3Executor<C extends AmazonS3>
  implements S3Executor<C>
{
  private final C client;
  
  public SimpleS3Executor(C client)
  {
    this.client = client;
  }
  
  public <R> R execute(S3Call<R, ? super C> call)
  {
    return (R)execute(call, false);
  }
  
  public <R> R execute(S3Call<R, ? super C> call, boolean shouldTryInitialTimeout)
  {
    return (R)call.perform(client);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.executor.SimpleS3Executor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */