package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import java.lang.annotation.Annotation;

abstract interface Key$AnnotationStrategy
{
  public abstract Annotation getAnnotation();
  
  public abstract Class<? extends Annotation> getAnnotationType();
  
  public abstract boolean hasAttributes();
  
  public abstract AnnotationStrategy withoutAttributes();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key.AnnotationStrategy
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */