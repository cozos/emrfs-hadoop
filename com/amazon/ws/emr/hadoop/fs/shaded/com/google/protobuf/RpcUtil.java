package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

public final class RpcUtil
{
  public static <Type extends Message> RpcCallback<Type> specializeCallback(RpcCallback<Message> originalCallback)
  {
    return originalCallback;
  }
  
  public static <Type extends Message> RpcCallback<Message> generalizeCallback(final RpcCallback<Type> originalCallback, Class<Type> originalClass, final Type defaultInstance)
  {
    new RpcCallback()
    {
      public void run(Message parameter)
      {
        Type typedParameter;
        try
        {
          typedParameter = (Message)val$originalClass.cast(parameter);
        }
        catch (ClassCastException ignored)
        {
          typedParameter = RpcUtil.copyAsType(defaultInstance, parameter);
        }
        originalCallback.run(typedParameter);
      }
    };
  }
  
  private static <Type extends Message> Type copyAsType(Type typeDefaultInstance, Message source)
  {
    return typeDefaultInstance.newBuilderForType().mergeFrom(source).build();
  }
  
  public static <ParameterType> RpcCallback<ParameterType> newOneTimeCallback(RpcCallback<ParameterType> originalCallback)
  {
    new RpcCallback()
    {
      private boolean alreadyCalled = false;
      
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
    };
  }
  
  public static final class AlreadyCalledException
    extends RuntimeException
  {
    private static final long serialVersionUID = 5469741279507848266L;
    
    public AlreadyCalledException()
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.RpcUtil
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */