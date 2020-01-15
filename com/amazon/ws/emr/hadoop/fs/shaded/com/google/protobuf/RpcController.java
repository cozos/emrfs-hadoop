package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public abstract interface RpcController
{
  public abstract void reset();
  
  public abstract boolean failed();
  
  public abstract String errorText();
  
  public abstract void startCancel();
  
  public abstract void setFailed(String paramString);
  
  public abstract boolean isCanceled();
  
  public abstract void notifyOnCancel(RpcCallback<Object> paramRpcCallback);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.RpcController
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */