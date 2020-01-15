package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Attribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;
import java.lang.reflect.Member;

final class $ReflectUtils$3
  extends .MethodInfo
{
  private .ClassInfo ci;
  private final Member val$member;
  private final int val$modifiers;
  private final .Signature val$sig;
  
  $ReflectUtils$3(Member paramMember, int paramInt, .Signature paramSignature)
  {
    val$member = paramMember;val$modifiers = paramInt;val$sig = paramSignature;
  }
  
  public .ClassInfo getClassInfo()
  {
    if (ci == null) {
      ci = .ReflectUtils.getClassInfo(val$member.getDeclaringClass());
    }
    return ci;
  }
  
  public int getModifiers()
  {
    return val$modifiers;
  }
  
  public .Signature getSignature()
  {
    return val$sig;
  }
  
  public .Type[] getExceptionTypes()
  {
    return .ReflectUtils.getExceptionTypes(val$member);
  }
  
  public .Attribute getAttribute()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ReflectUtils.3
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */