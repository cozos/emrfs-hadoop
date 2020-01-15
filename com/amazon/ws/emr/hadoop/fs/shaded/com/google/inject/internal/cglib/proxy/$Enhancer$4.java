package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ProcessSwitchCallback;

class $Enhancer$4
  implements .ProcessSwitchCallback
{
  private final .CodeEmitter val$e;
  private final .Enhancer this$0;
  
  $Enhancer$4(.Enhancer paramEnhancer, .CodeEmitter paramCodeEmitter)
  {
    this$0 = paramEnhancer;val$e = paramCodeEmitter;
  }
  
  public void processCase(int key, .Label end)
  {
    val$e.load_this();
    val$e.load_arg(1);
    val$e.checkcast(.Enhancer.access$100(this$0)[key]);
    val$e.putfield(.Enhancer.access$000(key));
    val$e.goTo(end);
  }
  
  public void processDefault() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..Enhancer.4
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */