package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder;

import java.lang.annotation.Annotation;

public abstract interface AnnotatedElementBuilder
{
  public abstract void annotatedWith(Class<? extends Annotation> paramClass);
  
  public abstract void annotatedWith(Annotation paramAnnotation);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedElementBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */