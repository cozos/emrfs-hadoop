package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.lang.annotation.Annotation;

class Key$AnnotationInstanceStrategy
  implements Key.AnnotationStrategy
{
  final Annotation annotation;
  
  Key$AnnotationInstanceStrategy(Annotation annotation)
  {
    this.annotation = ((Annotation).Preconditions.checkNotNull(annotation, "annotation"));
  }
  
  public boolean hasAttributes()
  {
    return true;
  }
  
  public Key.AnnotationStrategy withoutAttributes()
  {
    return new Key.AnnotationTypeStrategy(getAnnotationType(), annotation);
  }
  
  public Annotation getAnnotation()
  {
    return annotation;
  }
  
  public Class<? extends Annotation> getAnnotationType()
  {
    return annotation.annotationType();
  }
  
  public boolean equals(Object o)
  {
    if (!(o instanceof AnnotationInstanceStrategy)) {
      return false;
    }
    AnnotationInstanceStrategy other = (AnnotationInstanceStrategy)o;
    return annotation.equals(annotation);
  }
  
  public int hashCode()
  {
    return annotation.hashCode();
  }
  
  public String toString()
  {
    return annotation.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key.AnnotationInstanceStrategy
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */