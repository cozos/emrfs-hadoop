package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;

@Beta
public enum Service$State
{
  NEW,  STARTING,  RUNNING,  STOPPING,  TERMINATED,  FAILED;
  
  private Service$State() {}
  
  abstract boolean isTerminal();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Service.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */