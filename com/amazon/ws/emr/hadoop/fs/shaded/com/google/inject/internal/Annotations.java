package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.BindingAnnotation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Key;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.ScopeAnnotation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Classes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.name.Names;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import javax.inject.Qualifier;
import javax.inject.Scope;

public class Annotations
{
  public static boolean isMarker(Class<? extends Annotation> annotationType)
  {
    return annotationType.getDeclaredMethods().length == 0;
  }
  
  public static boolean isRetainedAtRuntime(Class<? extends Annotation> annotationType)
  {
    Retention retention = (Retention)annotationType.getAnnotation(Retention.class);
    return (retention != null) && (retention.value() == RetentionPolicy.RUNTIME);
  }
  
  public static Class<? extends Annotation> findScopeAnnotation(Errors errors, Class<?> implementation)
  {
    return findScopeAnnotation(errors, implementation.getAnnotations());
  }
  
  public static Class<? extends Annotation> findScopeAnnotation(Errors errors, Annotation[] annotations)
  {
    Class<? extends Annotation> found = null;
    for (Annotation annotation : annotations)
    {
      Class<? extends Annotation> annotationType = annotation.annotationType();
      if (isScopeAnnotation(annotationType)) {
        if (found != null) {
          errors.duplicateScopeAnnotations(found, annotationType);
        } else {
          found = annotationType;
        }
      }
    }
    return found;
  }
  
  static class AnnotationChecker
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
    
    AnnotationChecker(Collection<Class<? extends Annotation>> annotationTypes)
    {
      this.annotationTypes = annotationTypes;
    }
    
    boolean hasAnnotations(Class<? extends Annotation> annotated)
    {
      return ((Boolean)cache.get(annotated)).booleanValue();
    }
  }
  
  private static final AnnotationChecker scopeChecker = new AnnotationChecker(Arrays.asList(new Class[] { ScopeAnnotation.class, Scope.class }));
  
  public static boolean isScopeAnnotation(Class<? extends Annotation> annotationType)
  {
    return scopeChecker.hasAnnotations(annotationType);
  }
  
  public static void checkForMisplacedScopeAnnotations(Class<?> type, Object source, Errors errors)
  {
    if (.Classes.isConcrete(type)) {
      return;
    }
    Class<? extends Annotation> scopeAnnotation = findScopeAnnotation(errors, type);
    if (scopeAnnotation != null) {
      errors.withSource(type).scopeAnnotationOnAbstractType(scopeAnnotation, type, source);
    }
  }
  
  public static Key<?> getKey(TypeLiteral<?> type, Member member, Annotation[] annotations, Errors errors)
    throws ErrorsException
  {
    int numErrorsBefore = errors.size();
    Annotation found = findBindingAnnotation(errors, member, annotations);
    errors.throwIfNewErrors(numErrorsBefore);
    return found == null ? Key.get(type) : Key.get(type, found);
  }
  
  public static Annotation findBindingAnnotation(Errors errors, Member member, Annotation[] annotations)
  {
    Annotation found = null;
    for (Annotation annotation : annotations)
    {
      Class<? extends Annotation> annotationType = annotation.annotationType();
      if (isBindingAnnotation(annotationType)) {
        if (found != null) {
          errors.duplicateBindingAnnotations(member, found.annotationType(), annotationType);
        } else {
          found = annotation;
        }
      }
    }
    return found;
  }
  
  private static final AnnotationChecker bindingAnnotationChecker = new AnnotationChecker(Arrays.asList(new Class[] { BindingAnnotation.class, Qualifier.class }));
  
  public static boolean isBindingAnnotation(Class<? extends Annotation> annotationType)
  {
    return bindingAnnotationChecker.hasAnnotations(annotationType);
  }
  
  public static Annotation canonicalizeIfNamed(Annotation annotation)
  {
    if ((annotation instanceof javax.inject.Named)) {
      return Names.named(((javax.inject.Named)annotation).value());
    }
    return annotation;
  }
  
  public static Class<? extends Annotation> canonicalizeIfNamed(Class<? extends Annotation> annotationType)
  {
    if (annotationType == javax.inject.Named.class) {
      return com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.name.Named.class;
    }
    return annotationType;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Annotations
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */