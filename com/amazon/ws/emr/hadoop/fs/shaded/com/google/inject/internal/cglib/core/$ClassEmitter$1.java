package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;

class $ClassEmitter$1
  extends .ClassInfo
{
  private final .Type val$classType;
  private final .Type val$superType;
  private final .Type[] val$interfaces;
  private final int val$access;
  private final .ClassEmitter this$0;
  
  $ClassEmitter$1(.ClassEmitter paramClassEmitter, .Type paramType1, .Type paramType2, .Type[] paramArrayOfType, int paramInt)
  {
    this$0 = paramClassEmitter;val$classType = paramType1;val$superType = paramType2;val$interfaces = paramArrayOfType;val$access = paramInt;
  }
  
  public .Type getType()
  {
    return val$classType;
  }
  
  public .Type getSuperType()
  {
    return val$superType != null ? val$superType : .Constants.TYPE_OBJECT;
  }
  
  public .Type[] getInterfaces()
  {
    return val$interfaces;
  }
  
  public int getModifiers()
  {
    return val$access;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ClassEmitter.1
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */