package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

abstract class StandardAnnotationMaps$AbstractAnnotationMap
{
  private final StandardAnnotationMaps.Annotations map = new StandardAnnotationMaps.Annotations(null);
  
  final <A extends Annotation> A actualOf(Class<A> annotationType)
  {
    Annotation annotation = (Annotation)map.get(annotationType);
    if ((annotation == null) || (annotation.annotationType() == annotationType)) {
      return annotation;
    }
    if (annotation.annotationType().isAnnotationPresent(annotationType)) {
      return annotation.annotationType().getAnnotation(annotationType);
    }
    throw new DynamoDBMappingException("could not resolve annotation by type; @" + annotationType.getSimpleName() + " not present on " + annotation);
  }
  
  final void putAll(AnnotatedElement annotated)
  {
    if (annotated != null) {
      map.putAll(new StandardAnnotationMaps.Annotations(null).putAll(annotated.getAnnotations()));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardAnnotationMaps.AbstractAnnotationMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */