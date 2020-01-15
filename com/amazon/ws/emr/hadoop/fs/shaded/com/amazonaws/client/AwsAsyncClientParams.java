package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import java.util.concurrent.ExecutorService;

@SdkProtectedApi
public abstract class AwsAsyncClientParams
  extends AwsSyncClientParams
{
  public abstract ExecutorService getExecutor();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */