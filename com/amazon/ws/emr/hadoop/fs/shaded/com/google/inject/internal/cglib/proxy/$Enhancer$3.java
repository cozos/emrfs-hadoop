package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ProcessSwitchCallback;

class $Enhancer$3
  implements .ProcessSwitchCallback
{
  private final .CodeEmitter val$e;
  private final .Enhancer this$0;
  
  $Enhancer$3(.Enhancer paramEnhancer, .CodeEmitter paramCodeEmitter)
  {
    this$0 = paramEnhancer;val$e = paramCodeEmitter;
  }
  
  public void processCase(int key, .Label end)
  {
    val$e.getfield(.Enhancer.access$000(key));
    val$e.goTo(end);
  }
  
  public void processDefault()
  {
    val$e.pop();
    val$e.aconst_null();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..Enhancer.3
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */