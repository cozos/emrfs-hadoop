package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public final class RpcUtil$AlreadyCalledException
  extends RuntimeException
{
  private static final long serialVersionUID = 5469741279507848266L;
  
  public RpcUtil$AlreadyCalledException()
  {
    super("This RpcCallback was already called and cannot be called multiple times.");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.RpcUtil.AlreadyCalledException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */