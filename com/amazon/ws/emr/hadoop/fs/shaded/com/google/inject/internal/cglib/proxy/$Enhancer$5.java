package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..MethodInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ObjectSwitchCallback;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Signature;

class $Enhancer$5
  implements .ObjectSwitchCallback
{
  private final .CodeEmitter val$e;
  private final .Enhancer this$0;
  
  $Enhancer$5(.Enhancer paramEnhancer, .CodeEmitter paramCodeEmitter)
  {
    this$0 = paramEnhancer;val$e = paramCodeEmitter;
  }
  
  public void processCase(Object key, .Label end)
  {
    .MethodInfo constructor = (.MethodInfo)key;
    .Type[] types = constructor.getSignature().getArgumentTypes();
    for (int i = 0; i < types.length; i++)
    {
      val$e.load_arg(1);
      val$e.push(i);
      val$e.aaload();
      val$e.unbox(types[i]);
    }
    val$e.invoke_constructor_this(constructor.getSignature());
    val$e.goTo(end);
  }
  
  public void processDefault()
  {
    val$e.throw_exception(.Enhancer.access$200(), "Constructor not found");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..Enhancer.5
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */