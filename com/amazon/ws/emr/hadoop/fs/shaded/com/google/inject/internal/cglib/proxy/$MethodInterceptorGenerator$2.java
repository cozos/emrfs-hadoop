package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ObjectSwitchCallback;
import java.util.Map;

class $MethodInterceptorGenerator$2
  implements .ObjectSwitchCallback
{
  private final .CodeEmitter val$e;
  private final Map val$sigMap;
  private final .MethodInterceptorGenerator this$0;
  
  $MethodInterceptorGenerator$2(.MethodInterceptorGenerator paramMethodInterceptorGenerator, .CodeEmitter paramCodeEmitter, Map paramMap)
  {
    this$0 = paramMethodInterceptorGenerator;val$e = paramCodeEmitter;val$sigMap = paramMap;
  }
  
  public void processCase(Object key, .Label end)
  {
    val$e.getfield((String)val$sigMap.get(key));
    val$e.return_value();
  }
  
  public void processDefault()
  {
    val$e.aconst_null();
    val$e.return_value();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..MethodInterceptorGenerator.2
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */