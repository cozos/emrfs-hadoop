package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Scope;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.lang.annotation.Annotation;

public final class ScopeBinding
  implements Element
{
  private final Object source;
  private final Class<? extends Annotation> annotationType;
  private final Scope scope;
  
  ScopeBinding(Object source, Class<? extends Annotation> annotationType, Scope scope)
  {
    this.source = .Preconditions.checkNotNull(source, "source");
    this.annotationType = ((Class).Preconditions.checkNotNull(annotationType, "annotationType"));
    this.scope = ((Scope).Preconditions.checkNotNull(scope, "scope"));
  }
  
  public Object getSource()
  {
    return source;
  }
  
  public Class<? extends Annotation> getAnnotationType()
  {
    return annotationType;
  }
  
  public Scope getScope()
  {
    return scope;
  }
  
  public <T> T acceptVisitor(ElementVisitor<T> visitor)
  {
    return (T)visitor.visit(this);
  }
  
  public void applyTo(Binder binder)
  {
    binder.withSource(getSource()).bindScope(annotationType, scope);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.ScopeBinding
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */