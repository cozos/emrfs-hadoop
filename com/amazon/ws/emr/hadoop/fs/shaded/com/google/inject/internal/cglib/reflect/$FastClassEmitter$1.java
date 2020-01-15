package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ReflectUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Signature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Transformer;
import java.lang.reflect.Method;

class $FastClassEmitter$1
  implements .Transformer
{
  private final .FastClassEmitter this$0;
  
  $FastClassEmitter$1(.FastClassEmitter paramFastClassEmitter)
  {
    this$0 = paramFastClassEmitter;
  }
  
  public Object transform(Object obj)
  {
    return .ReflectUtils.getSignature((Method)obj).toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastClassEmitter.1
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */