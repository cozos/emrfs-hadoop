package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Singleton;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.ScopedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingScopingVisitor;
import java.lang.annotation.Annotation;

final class Scoping$2
  extends Scoping
{
  Scoping$2()
  {
    super(null);
  }
  
  public <V> V acceptVisitor(BindingScopingVisitor<V> visitor)
  {
    return (V)visitor.visitScopeAnnotation(Singleton.class);
  }
  
  public Class<? extends Annotation> getScopeAnnotation()
  {
    return Singleton.class;
  }
  
  public String toString()
  {
    return Singleton.class.getName();
  }
  
  public void applyTo(ScopedBindingBuilder scopedBindingBuilder)
  {
    scopedBindingBuilder.in(Singleton.class);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Scoping.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */