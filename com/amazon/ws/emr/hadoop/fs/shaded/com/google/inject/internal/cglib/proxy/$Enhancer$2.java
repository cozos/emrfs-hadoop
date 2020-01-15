package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..MethodWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ReflectUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Transformer;
import java.lang.reflect.Method;
import java.util.Set;

class $Enhancer$2
  implements .Transformer
{
  private final Set val$forcePublic;
  private final .Enhancer this$0;
  
  $Enhancer$2(.Enhancer paramEnhancer, Set paramSet)
  {
    this$0 = paramEnhancer;val$forcePublic = paramSet;
  }
  
  public Object transform(Object value)
  {
    Method method = (Method)value;
    int modifiers = 0x10 | method.getModifiers() & 0xFBFF & 0xFEFF & 0xFFFFFFDF;
    if (val$forcePublic.contains(.MethodWrapper.create(method))) {
      modifiers = modifiers & 0xFFFFFFFB | 0x1;
    }
    return .ReflectUtils.getMethodInfo(method, modifiers);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..Enhancer.2
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */