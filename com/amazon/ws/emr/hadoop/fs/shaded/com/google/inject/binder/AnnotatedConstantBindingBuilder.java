package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder;

import java.lang.annotation.Annotation;

public abstract interface AnnotatedConstantBindingBuilder
{
  public abstract ConstantBindingBuilder annotatedWith(Class<? extends Annotation> paramClass);
  
  public abstract ConstantBindingBuilder annotatedWith(Annotation paramAnnotation);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedConstantBindingBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */