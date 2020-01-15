package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public abstract interface BlockingService
{
  public abstract Descriptors.ServiceDescriptor getDescriptorForType();
  
  public abstract Message callBlockingMethod(Descriptors.MethodDescriptor paramMethodDescriptor, RpcController paramRpcController, Message paramMessage)
    throws ServiceException;
  
  public abstract Message getRequestPrototype(Descriptors.MethodDescriptor paramMethodDescriptor);
  
  public abstract Message getResponsePrototype(Descriptors.MethodDescriptor paramMethodDescriptor);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.BlockingService
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */