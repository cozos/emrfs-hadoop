package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import java.util.Set;

class $AbstractClassGenerator$1
  implements .Predicate
{
  private final Set val$nameCache;
  private final .AbstractClassGenerator this$0;
  
  $AbstractClassGenerator$1(.AbstractClassGenerator paramAbstractClassGenerator, Set paramSet)
  {
    this$0 = paramAbstractClassGenerator;val$nameCache = paramSet;
  }
  
  public boolean evaluate(Object arg)
  {
    return val$nameCache.contains(arg);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..AbstractClassGenerator.1
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */