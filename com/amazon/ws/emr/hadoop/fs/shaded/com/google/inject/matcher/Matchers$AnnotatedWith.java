package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

class Matchers$AnnotatedWith
  extends AbstractMatcher<AnnotatedElement>
  implements Serializable
{
  private final Annotation annotation;
  private static final long serialVersionUID = 0L;
  
  public Matchers$AnnotatedWith(Annotation annotation)
  {
    this.annotation = ((Annotation).Preconditions.checkNotNull(annotation, "annotation"));
    Matchers.access$200(annotation.annotationType());
  }
  
  public boolean matches(AnnotatedElement element)
  {
    Annotation fromElement = element.getAnnotation(annotation.annotationType());
    return (fromElement != null) && (annotation.equals(fromElement));
  }
  
  public boolean equals(Object other)
  {
    return ((other instanceof AnnotatedWith)) && (annotation.equals(annotation));
  }
  
  public int hashCode()
  {
    return 37 * annotation.hashCode();
  }
  
  public String toString()
  {
    return "annotatedWith(" + annotation + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.matcher.Matchers.AnnotatedWith
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */