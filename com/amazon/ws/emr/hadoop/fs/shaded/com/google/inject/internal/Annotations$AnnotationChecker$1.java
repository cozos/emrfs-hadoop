package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Function;
import java.lang.annotation.Annotation;
import java.util.Collection;

class Annotations$AnnotationChecker$1
  implements .Function<Class<? extends Annotation>, Boolean>
{
  Annotations$AnnotationChecker$1(Annotations.AnnotationChecker paramAnnotationChecker) {}
  
  public Boolean apply(Class<? extends Annotation> annotationType)
  {
    for (Annotation annotation : annotationType.getAnnotations()) {
      if (Annotations.AnnotationChecker.access$000(this$0).contains(annotation.annotationType())) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Annotations.AnnotationChecker.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */