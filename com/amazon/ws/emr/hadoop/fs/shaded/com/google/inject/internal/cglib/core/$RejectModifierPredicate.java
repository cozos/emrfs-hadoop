package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import java.lang.reflect.Member;

public class $RejectModifierPredicate
  implements .Predicate
{
  private int rejectMask;
  
  public $RejectModifierPredicate(int rejectMask)
  {
    this.rejectMask = rejectMask;
  }
  
  public boolean evaluate(Object arg)
  {
    return (((Member)arg).getModifiers() & rejectMask) == 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..RejectModifierPredicate
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */