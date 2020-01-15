package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeBindings;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public abstract class Annotated
{
  public abstract <A extends Annotation> A getAnnotation(Class<A> paramClass);
  
  public final <A extends Annotation> boolean hasAnnotation(Class<A> acls)
  {
    return getAnnotation(acls) != null;
  }
  
  public abstract Annotated withAnnotations(AnnotationMap paramAnnotationMap);
  
  public final Annotated withFallBackAnnotationsFrom(Annotated annotated)
  {
    return withAnnotations(AnnotationMap.merge(getAllAnnotations(), annotated.getAllAnnotations()));
  }
  
  public abstract AnnotatedElement getAnnotated();
  
  protected abstract int getModifiers();
  
  public final boolean isPublic()
  {
    return Modifier.isPublic(getModifiers());
  }
  
  public abstract String getName();
  
  public JavaType getType(TypeBindings context)
  {
    return context.resolveType(getGenericType());
  }
  
  public abstract Type getGenericType();
  
  public abstract Class<?> getRawType();
  
  public abstract Iterable<Annotation> annotations();
  
  protected abstract AnnotationMap getAllAnnotations();
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
  
  public abstract String toString();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.Annotated
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */