package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec;

public abstract interface ExecuteResultHandler
{
  public abstract void onProcessComplete(int paramInt);
  
  public abstract void onProcessFailed(ExecuteException paramExecuteException);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.exec.ExecuteResultHandler
 * Java Class Version: 1.3 (47.0)
 * JD-Core Version:    0.7.1
 */