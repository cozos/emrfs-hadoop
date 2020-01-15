package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@SdkProtectedApi
public abstract class ClientHandler
{
  public abstract <Input, Output> Output execute(ClientExecutionParams<Input, Output> paramClientExecutionParams);
  
  public abstract void shutdown();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.ClientHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */