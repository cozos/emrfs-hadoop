package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import java.lang.annotation.Annotation;

public abstract interface BindingScopingVisitor<V>
{
  public abstract V visitEagerSingleton();
  
  public abstract V visitScope(Scope paramScope);
  
  public abstract V visitScopeAnnotation(Class<? extends Annotation> paramClass);
  
  public abstract V visitNoScoping();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingScopingVisitor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */