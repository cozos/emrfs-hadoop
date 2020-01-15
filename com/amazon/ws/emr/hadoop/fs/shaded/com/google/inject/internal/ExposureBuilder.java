package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.binder.AnnotatedElementBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.lang.annotation.Annotation;

public class ExposureBuilder<T>
  implements AnnotatedElementBuilder
{
  private final Binder binder;
  private final Object source;
  private Key<T> key;
  
  public ExposureBuilder(Binder binder, Object source, Key<T> key)
  {
    this.binder = binder;
    this.source = source;
    this.key = key;
  }
  
  protected void checkNotAnnotated()
  {
    if (key.getAnnotationType() != null) {
      binder.addError("More than one annotation is specified for this binding.", new Object[0]);
    }
  }
  
  public void annotatedWith(Class<? extends Annotation> annotationType)
  {
    .Preconditions.checkNotNull(annotationType, "annotationType");
    checkNotAnnotated();
    key = Key.get(key.getTypeLiteral(), annotationType);
  }
  
  public void annotatedWith(Annotation annotation)
  {
    .Preconditions.checkNotNull(annotation, "annotation");
    checkNotAnnotated();
    key = Key.get(key.getTypeLiteral(), annotation);
  }
  
  public Key<?> getKey()
  {
    return key;
  }
  
  public Object getSource()
  {
    return source;
  }
  
  public String toString()
  {
    return "AnnotatedElementBuilder";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ExposureBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */