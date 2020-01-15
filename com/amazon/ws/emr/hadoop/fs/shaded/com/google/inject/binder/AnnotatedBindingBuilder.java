package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder;

import java.lang.annotation.Annotation;

public abstract interface AnnotatedBindingBuilder<T>
  extends LinkedBindingBuilder<T>
{
  public abstract LinkedBindingBuilder<T> annotatedWith(Class<? extends Annotation> paramClass);
  
  public abstract LinkedBindingBuilder<T> annotatedWith(Annotation paramAnnotation);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedBindingBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */