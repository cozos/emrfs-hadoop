package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public abstract interface Service
{
  public abstract Descriptors.ServiceDescriptor getDescriptorForType();
  
  public abstract void callMethod(Descriptors.MethodDescriptor paramMethodDescriptor, RpcController paramRpcController, Message paramMessage, RpcCallback<Message> paramRpcCallback);
  
  public abstract Message getRequestPrototype(Descriptors.MethodDescriptor paramMethodDescriptor);
  
  public abstract Message getResponsePrototype(Descriptors.MethodDescriptor paramMethodDescriptor);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.Service
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */