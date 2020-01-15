package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..DefaultNamingPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Predicate;

final class BytecodeGen$2
  extends .DefaultNamingPolicy
{
  protected String getTag()
  {
    return "ByGuice";
  }
  
  public String getClassName(String prefix, String source, Object key, .Predicate names)
  {
    return super.getClassName(prefix, "Enhancer", key, names);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.BytecodeGen.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */