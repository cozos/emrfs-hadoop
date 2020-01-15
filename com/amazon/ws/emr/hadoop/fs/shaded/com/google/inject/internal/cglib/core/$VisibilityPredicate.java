package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public class $VisibilityPredicate
  implements .Predicate
{
  private boolean protectedOk;
  private String pkg;
  
  public $VisibilityPredicate(Class source, boolean protectedOk)
  {
    this.protectedOk = protectedOk;
    pkg = .TypeUtils.getPackageName(.Type.getType(source));
  }
  
  public boolean evaluate(Object arg)
  {
    int mod = (arg instanceof Member) ? ((Member)arg).getModifiers() : ((Integer)arg).intValue();
    if (Modifier.isPrivate(mod)) {
      return false;
    }
    if (Modifier.isPublic(mod)) {
      return true;
    }
    if (Modifier.isProtected(mod)) {
      return protectedOk;
    }
    return pkg.equals(.TypeUtils.getPackageName(.Type.getType(((Member)arg).getDeclaringClass())));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..VisibilityPredicate
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */