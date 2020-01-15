package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class $Classes
{
  public static boolean isInnerClass(Class<?> clazz)
  {
    return (!Modifier.isStatic(clazz.getModifiers())) && (clazz.getEnclosingClass() != null);
  }
  
  public static boolean isConcrete(Class<?> clazz)
  {
    int modifiers = clazz.getModifiers();
    return (!clazz.isInterface()) && (!Modifier.isAbstract(modifiers));
  }
  
  public static String toString(Member member)
  {
    Class<? extends Member> memberType = memberType(member);
    if (memberType == Method.class) {
      return member.getDeclaringClass().getName() + "." + member.getName() + "()";
    }
    if (memberType == Field.class) {
      return member.getDeclaringClass().getName() + "." + member.getName();
    }
    if (memberType == Constructor.class) {
      return member.getDeclaringClass().getName() + ".<init>()";
    }
    throw new AssertionError();
  }
  
  public static Class<? extends Member> memberType(Member member)
  {
    .Preconditions.checkNotNull(member, "member");
    if ((member instanceof Field)) {
      return Field.class;
    }
    if ((member instanceof Method)) {
      return Method.class;
    }
    if ((member instanceof Constructor)) {
      return Constructor.class;
    }
    throw new IllegalArgumentException("Unsupported implementation class for Member, " + member.getClass());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Classes
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */