package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;

class Annotations$AnnotationChecker
{
  private final Collection<Class<? extends Annotation>> annotationTypes;
  private .Function<Class<? extends Annotation>, Boolean> hasAnnotations = new .Function()
  {
    public Boolean apply(Class<? extends Annotation> annotationType)
    {
      for (Annotation annotation : annotationType.getAnnotations()) {
        if (annotationTypes.contains(annotation.annotationType())) {
          return Boolean.valueOf(true);
        }
      }
      return Boolean.valueOf(false);
    }
  };
  final Map<Class<? extends Annotation>, Boolean> cache = new .MapMaker().weakKeys().makeComputingMap(hasAnnotations);
  
  Annotations$AnnotationChecker(Collection<Class<? extends Annotation>> annotationTypes)
  {
    this.annotationTypes = annotationTypes;
  }
  
  boolean hasAnnotations(Class<? extends Annotation> annotated)
  {
    return ((Boolean)cache.get(annotated)).booleanValue();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Annotations.AnnotationChecker
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */