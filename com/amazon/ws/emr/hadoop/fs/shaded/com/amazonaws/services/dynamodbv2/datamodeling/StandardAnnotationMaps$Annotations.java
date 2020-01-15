package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;

final class StandardAnnotationMaps$Annotations
  extends LinkedHashMap<Class<? extends Annotation>, Annotation>
{
  private static final long serialVersionUID = -1L;
  
  public boolean putIfAnnotated(Class<? extends Annotation> annotationType, Annotation annotation)
  {
    if (!annotationType.isAnnotationPresent(DynamoDB.class)) {
      return false;
    }
    if ((annotation = (Annotation)put(annotationType, annotation)) == null) {
      return true;
    }
    throw new DynamoDBMappingException("conflicting annotations " + annotation + " and " + get(annotationType) + "; allowed only one of @" + annotationType.getSimpleName());
  }
  
  public Annotations putAll(Annotation... annotations)
  {
    for (Annotation a1 : annotations)
    {
      putIfAnnotated(a1.annotationType(), a1);
      for (Annotation a2 : a1.annotationType().getAnnotations()) {
        if (putIfAnnotated(a2.annotationType(), a1)) {
          for (Annotation a3 : a2.annotationType().getAnnotations()) {
            putIfAnnotated(a3.annotationType(), a2);
          }
        }
      }
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardAnnotationMaps.Annotations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */