package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Attribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;

class $CodeEmitter$State
  extends .MethodInfo
{
  .ClassInfo classInfo;
  int access;
  .Signature sig;
  .Type[] argumentTypes;
  int localOffset;
  .Type[] exceptionTypes;
  
  $CodeEmitter$State(.ClassInfo classInfo, int access, .Signature sig, .Type[] exceptionTypes)
  {
    this.classInfo = classInfo;
    this.access = access;
    this.sig = sig;
    this.exceptionTypes = exceptionTypes;
    localOffset = (.TypeUtils.isStatic(access) ? 0 : 1);
    argumentTypes = sig.getArgumentTypes();
  }
  
  public .ClassInfo getClassInfo()
  {
    return classInfo;
  }
  
  public int getModifiers()
  {
    return access;
  }
  
  public .Signature getSignature()
  {
    return sig;
  }
  
  public .Type[] getExceptionTypes()
  {
    return exceptionTypes;
  }
  
  public .Attribute getAttribute()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..CodeEmitter.State
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */