package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.lang.annotation.Annotation;

class Key$AnnotationTypeStrategy
  implements Key.AnnotationStrategy
{
  final Class<? extends Annotation> annotationType;
  final Annotation annotation;
  
  Key$AnnotationTypeStrategy(Class<? extends Annotation> annotationType, Annotation annotation)
  {
    this.annotationType = ((Class).Preconditions.checkNotNull(annotationType, "annotation type"));
    this.annotation = annotation;
  }
  
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
    return annotation;
  }
  
  public Class<? extends Annotation> getAnnotationType()
  {
    return annotationType;
  }
  
  public boolean equals(Object o)
  {
    if (!(o instanceof AnnotationTypeStrategy)) {
      return false;
    }
    AnnotationTypeStrategy other = (AnnotationTypeStrategy)o;
    return annotationType.equals(annotationType);
  }
  
  public int hashCode()
  {
    return annotationType.hashCode();
  }
  
  public String toString()
  {
    return "@" + annotationType.getName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key.AnnotationTypeStrategy
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */