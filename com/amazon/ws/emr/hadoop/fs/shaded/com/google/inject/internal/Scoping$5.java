package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.ScopedBindingBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.BindingScopingVisitor;
import java.lang.annotation.Annotation;

final class Scoping$5
  extends Scoping
{
  Scoping$5(Class paramClass)
  {
    super(null);
  }
  
  public <V> V acceptVisitor(BindingScopingVisitor<V> visitor)
  {
    return (V)visitor.visitScopeAnnotation(val$scopingAnnotation);
  }
  
  public Class<? extends Annotation> getScopeAnnotation()
  {
    return val$scopingAnnotation;
  }
  
  public String toString()
  {
    return val$scopingAnnotation.getName();
  }
  
  public void applyTo(ScopedBindingBuilder scopedBindingBuilder)
  {
    scopedBindingBuilder.in(val$scopingAnnotation);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Scoping.5
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */