package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Label;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ClassEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..EmitUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..MethodInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Signature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..TypeUtils;
import java.util.Map;

class $Enhancer$6
  implements .CallbackGenerator.Context
{
  private final Map val$originalModifiers;
  private final Map val$indexes;
  private final Map val$positions;
  private final .Enhancer this$0;
  
  $Enhancer$6(.Enhancer paramEnhancer, Map paramMap1, Map paramMap2, Map paramMap3)
  {
    this$0 = paramEnhancer;val$originalModifiers = paramMap1;val$indexes = paramMap2;val$positions = paramMap3;
  }
  
  public ClassLoader getClassLoader()
  {
    return this$0.getClassLoader();
  }
  
  public int getOriginalModifiers(.MethodInfo method)
  {
    return ((Integer)val$originalModifiers.get(method)).intValue();
  }
  
  public int getIndex(.MethodInfo method)
  {
    return ((Integer)val$indexes.get(method)).intValue();
  }
  
  public void emitCallback(.CodeEmitter e, int index)
  {
    .Enhancer.access$300(this$0, e, index);
  }
  
  public .Signature getImplSignature(.MethodInfo method)
  {
    return .Enhancer.access$400(this$0, method.getSignature(), ((Integer)val$positions.get(method)).intValue());
  }
  
  public .CodeEmitter beginMethod(.ClassEmitter ce, .MethodInfo method)
  {
    .CodeEmitter e = .EmitUtils.begin_method(ce, method);
    if ((!.Enhancer.access$500(this$0)) && (!.TypeUtils.isAbstract(method.getModifiers())))
    {
      .Label constructed = e.make_label();
      e.load_this();
      e.getfield("CGLIB$CONSTRUCTED");
      e.if_jump(154, constructed);
      e.load_this();
      e.load_args();
      e.super_invoke();
      e.return_value();
      e.mark(constructed);
    }
    return e;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..Enhancer.6
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */