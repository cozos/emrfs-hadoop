package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ClassEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..MethodInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Signature;

public abstract interface $CallbackGenerator$Context
{
  public abstract ClassLoader getClassLoader();
  
  public abstract .CodeEmitter beginMethod(.ClassEmitter paramClassEmitter, .MethodInfo paramMethodInfo);
  
  public abstract int getOriginalModifiers(.MethodInfo paramMethodInfo);
  
  public abstract int getIndex(.MethodInfo paramMethodInfo);
  
  public abstract void emitCallback(.CodeEmitter paramCodeEmitter, int paramInt);
  
  public abstract .Signature getImplSignature(.MethodInfo paramMethodInfo);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..CallbackGenerator.Context
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */