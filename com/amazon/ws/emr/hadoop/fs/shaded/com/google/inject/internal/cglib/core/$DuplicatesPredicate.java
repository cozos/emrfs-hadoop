package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class $DuplicatesPredicate
  implements .Predicate
{
  private Set unique = new HashSet();
  
  public boolean evaluate(Object arg)
  {
    return unique.add(.MethodWrapper.create((Method)arg));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..DuplicatesPredicate
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */