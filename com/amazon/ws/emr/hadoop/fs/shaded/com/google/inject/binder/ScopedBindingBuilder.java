package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import java.lang.annotation.Annotation;

public abstract interface ScopedBindingBuilder
{
  public abstract void in(Class<? extends Annotation> paramClass);
  
  public abstract void in(Scope paramScope);
  
  public abstract void asEagerSingleton();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.ScopedBindingBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */