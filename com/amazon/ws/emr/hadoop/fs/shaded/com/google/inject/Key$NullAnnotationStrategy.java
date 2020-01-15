package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import java.lang.annotation.Annotation;

 enum Key$NullAnnotationStrategy
  implements Key.AnnotationStrategy
{
  INSTANCE;
  
  private Key$NullAnnotationStrategy() {}
  
  public boolean hasAttributes()
  {
    return false;
  }
  
  public Key.AnnotationStrategy withoutAttributes()
  {
    throw new UnsupportedOperationException("Key already has no attributes.");
  }
  
  public Annotation getAnnotation()
  {
    return null;
  }
  
  public Class<? extends Annotation> getAnnotationType()
  {
    return null;
  }
  
  public String toString()
  {
    return "[none]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key.NullAnnotationStrategy
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */