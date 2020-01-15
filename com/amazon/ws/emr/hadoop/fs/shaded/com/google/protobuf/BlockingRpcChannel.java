package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public abstract interface BlockingRpcChannel
{
  public abstract Message callBlockingMethod(Descriptors.MethodDescriptor paramMethodDescriptor, RpcController paramRpcController, Message paramMessage1, Message paramMessage2)
    throws ServiceException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.BlockingRpcChannel
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */