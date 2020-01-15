package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder;

import java.util.concurrent.ExecutorService;

public abstract interface ExecutorFactory
{
  public abstract ExecutorService newExecutor();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.ExecutorFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */