package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

final class RpcUtil$1
  implements RpcCallback<Message>
{
  RpcUtil$1(Class paramClass, Message paramMessage, RpcCallback paramRpcCallback) {}
  
  public void run(Message parameter)
  {
    Type typedParameter;
    try
    {
      typedParameter = (Message)val$originalClass.cast(parameter);
    }
    catch (ClassCastException ignored)
    {
      typedParameter = RpcUtil.access$000(val$defaultInstance, parameter);
    }
    val$originalCallback.run(typedParameter);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.RpcUtil.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */