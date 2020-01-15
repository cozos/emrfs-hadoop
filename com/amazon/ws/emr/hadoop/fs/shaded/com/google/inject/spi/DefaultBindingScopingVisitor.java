package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import java.lang.annotation.Annotation;

public class DefaultBindingScopingVisitor<V>
  implements BindingScopingVisitor<V>
{
  protected V visitOther()
  {
    return null;
  }
  
  public V visitEagerSingleton()
  {
    return (V)visitOther();
  }
  
  public V visitScope(Scope scope)
  {
    return (V)visitOther();
  }
  
  public V visitScopeAnnotation(Class<? extends Annotation> scopeAnnotation)
  {
    return (V)visitOther();
  }
  
  public V visitNoScoping()
  {
    return (V)visitOther();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.DefaultBindingScopingVisitor
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */