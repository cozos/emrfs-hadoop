package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeBindings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public abstract class AnnotatedWithParams
  extends AnnotatedMember
{
  private static final long serialVersionUID = 1L;
  protected final AnnotationMap[] _paramAnnotations;
  
  protected AnnotatedWithParams(AnnotatedClass ctxt, AnnotationMap annotations, AnnotationMap[] paramAnnotations)
  {
    super(ctxt, annotations);
    _paramAnnotations = paramAnnotations;
  }
  
  public final void addOrOverrideParam(int paramIndex, Annotation a)
  {
    AnnotationMap old = _paramAnnotations[paramIndex];
    if (old == null)
    {
      old = new AnnotationMap();
      _paramAnnotations[paramIndex] = old;
    }
    old.add(a);
  }
  
  protected AnnotatedParameter replaceParameterAnnotations(int index, AnnotationMap ann)
  {
    _paramAnnotations[index] = ann;
    return getParameter(index);
  }
  
  protected JavaType getType(TypeBindings bindings, TypeVariable<?>[] typeParams)
  {
    if ((typeParams != null) && (typeParams.length > 0))
    {
      bindings = bindings.childInstance();
      for (TypeVariable<?> var : typeParams)
      {
        String name = var.getName();
        
        bindings._addPlaceholder(name);
        
        Type lowerBound = var.getBounds()[0];
        JavaType type = lowerBound == null ? TypeFactory.unknownType() : bindings.resolveType(lowerBound);
        
        bindings.addBinding(var.getName(), type);
      }
    }
    return bindings.resolveType(getGenericType());
  }
  
  public final <A extends Annotation> A getAnnotation(Class<A> acls)
  {
    return _annotations.get(acls);
  }
  
  public final AnnotationMap getParameterAnnotations(int index)
  {
    if ((_paramAnnotations != null) && 
      (index >= 0) && (index < _paramAnnotations.length)) {
      return _paramAnnotations[index];
    }
    return null;
  }
  
  public final AnnotatedParameter getParameter(int index)
  {
    return new AnnotatedParameter(this, getGenericParameterType(index), getParameterAnnotations(index), index);
  }
  
  public abstract int getParameterCount();
  
  public abstract Class<?> getRawParameterType(int paramInt);
  
  public abstract Type getGenericParameterType(int paramInt);
  
  public final JavaType resolveParameterType(int index, TypeBindings bindings)
  {
    return bindings.resolveType(getGenericParameterType(index));
  }
  
  public final int getAnnotationCount()
  {
    return _annotations.size();
  }
  
  public abstract Object call()
    throws Exception;
  
  public abstract Object call(Object[] paramArrayOfObject)
    throws Exception;
  
  public abstract Object call1(Object paramObject)
    throws Exception;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */