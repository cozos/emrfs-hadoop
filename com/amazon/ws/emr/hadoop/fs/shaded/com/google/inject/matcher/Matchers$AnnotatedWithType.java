package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

class Matchers$AnnotatedWithType
  extends AbstractMatcher<AnnotatedElement>
  implements Serializable
{
  private final Class<? extends Annotation> annotationType;
  private static final long serialVersionUID = 0L;
  
  public Matchers$AnnotatedWithType(Class<? extends Annotation> annotationType)
  {
    this.annotationType = ((Class).Preconditions.checkNotNull(annotationType, "annotation type"));
    Matchers.access$200(annotationType);
  }
  
  public boolean matches(AnnotatedElement element)
  {
    return element.getAnnotation(annotationType) != null;
  }
  
  public boolean equals(Object other)
  {
    return ((other instanceof AnnotatedWithType)) && (annotationType.equals(annotationType));
  }
  
  public int hashCode()
  {
    return 37 * annotationType.hashCode();
  }
  
  public String toString()
  {
    return "annotatedWith(" + annotationType.getSimpleName() + ".class)";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matchers.AnnotatedWithType
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */