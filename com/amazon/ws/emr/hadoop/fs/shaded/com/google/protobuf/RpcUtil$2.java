package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

final class RpcUtil$2
  implements RpcCallback<ParameterType>
{
  private boolean alreadyCalled = false;
  
  RpcUtil$2(RpcCallback paramRpcCallback) {}
  
  public void run(ParameterType parameter)
  {
    synchronized (this)
    {
      if (alreadyCalled) {
        throw new RpcUtil.AlreadyCalledException();
      }
      alreadyCalled = true;
    }
    val$originalCallback.run(parameter);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.RpcUtil.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */