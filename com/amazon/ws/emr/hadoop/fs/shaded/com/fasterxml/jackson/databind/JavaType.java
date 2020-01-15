package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.type.ResolvedType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public abstract class JavaType
  extends ResolvedType
  implements Serializable, Type
{
  private static final long serialVersionUID = 1L;
  protected final Class<?> _class;
  protected final int _hash;
  protected final Object _valueHandler;
  protected final Object _typeHandler;
  protected final boolean _asStatic;
  
  protected JavaType(Class<?> raw, int additionalHash, Object valueHandler, Object typeHandler, boolean asStatic)
  {
    _class = raw;
    _hash = (raw.getName().hashCode() + additionalHash);
    _valueHandler = valueHandler;
    _typeHandler = typeHandler;
    _asStatic = asStatic;
  }
  
  public abstract JavaType withTypeHandler(Object paramObject);
  
  public abstract JavaType withContentTypeHandler(Object paramObject);
  
  public abstract JavaType withValueHandler(Object paramObject);
  
  public abstract JavaType withContentValueHandler(Object paramObject);
  
  public abstract JavaType withStaticTyping();
  
  public JavaType narrowBy(Class<?> subclass)
  {
    if (subclass == _class) {
      return this;
    }
    _assertSubclass(subclass, _class);
    
    JavaType result = _narrow(subclass);
    if (_valueHandler != result.getValueHandler()) {
      result = result.withValueHandler(_valueHandler);
    }
    if (_typeHandler != result.getTypeHandler()) {
      result = result.withTypeHandler(_typeHandler);
    }
    return result;
  }
  
  public JavaType forcedNarrowBy(Class<?> subclass)
  {
    if (subclass == _class) {
      return this;
    }
    JavaType result = _narrow(subclass);
    if (_valueHandler != result.getValueHandler()) {
      result = result.withValueHandler(_valueHandler);
    }
    if (_typeHandler != result.getTypeHandler()) {
      result = result.withTypeHandler(_typeHandler);
    }
    return result;
  }
  
  public JavaType widenBy(Class<?> superclass)
  {
    if (superclass == _class) {
      return this;
    }
    _assertSubclass(_class, superclass);
    return _widen(superclass);
  }
  
  protected abstract JavaType _narrow(Class<?> paramClass);
  
  protected JavaType _widen(Class<?> superclass)
  {
    return _narrow(superclass);
  }
  
  public abstract JavaType narrowContentsBy(Class<?> paramClass);
  
  public abstract JavaType widenContentsBy(Class<?> paramClass);
  
  public final Class<?> getRawClass()
  {
    return _class;
  }
  
  public final boolean hasRawClass(Class<?> clz)
  {
    return _class == clz;
  }
  
  public final boolean isTypeOrSubTypeOf(Class<?> clz)
  {
    return (_class == clz) || (clz.isAssignableFrom(_class));
  }
  
  public boolean isAbstract()
  {
    return Modifier.isAbstract(_class.getModifiers());
  }
  
  public boolean isConcrete()
  {
    int mod = _class.getModifiers();
    if ((mod & 0x600) == 0) {
      return true;
    }
    return _class.isPrimitive();
  }
  
  public boolean isThrowable()
  {
    return Throwable.class.isAssignableFrom(_class);
  }
  
  public boolean isArrayType()
  {
    return false;
  }
  
  public final boolean isEnumType()
  {
    return _class.isEnum();
  }
  
  public final boolean isInterface()
  {
    return _class.isInterface();
  }
  
  public final boolean isPrimitive()
  {
    return _class.isPrimitive();
  }
  
  public final boolean isFinal()
  {
    return Modifier.isFinal(_class.getModifiers());
  }
  
  public abstract boolean isContainerType();
  
  public boolean isCollectionLikeType()
  {
    return false;
  }
  
  public boolean isMapLikeType()
  {
    return false;
  }
  
  public final boolean isJavaLangObject()
  {
    return _class == Object.class;
  }
  
  public final boolean useStaticType()
  {
    return _asStatic;
  }
  
  public boolean hasGenericTypes()
  {
    return containedTypeCount() > 0;
  }
  
  public JavaType getKeyType()
  {
    return null;
  }
  
  public JavaType getContentType()
  {
    return null;
  }
  
  public JavaType getReferencedType()
  {
    return null;
  }
  
  public int containedTypeCount()
  {
    return 0;
  }
  
  public JavaType containedType(int index)
  {
    return null;
  }
  
  public String containedTypeName(int index)
  {
    return null;
  }
  
  public abstract Class<?> getParameterSource();
  
  public JavaType containedTypeOrUnknown(int index)
  {
    JavaType t = containedType(index);
    return t == null ? TypeFactory.unknownType() : t;
  }
  
  public <T> T getValueHandler()
  {
    return (T)_valueHandler;
  }
  
  public <T> T getTypeHandler()
  {
    return (T)_typeHandler;
  }
  
  public boolean hasValueHandler()
  {
    return _valueHandler != null;
  }
  
  public String getGenericSignature()
  {
    StringBuilder sb = new StringBuilder(40);
    getGenericSignature(sb);
    return sb.toString();
  }
  
  public abstract StringBuilder getGenericSignature(StringBuilder paramStringBuilder);
  
  public String getErasedSignature()
  {
    StringBuilder sb = new StringBuilder(40);
    getErasedSignature(sb);
    return sb.toString();
  }
  
  public abstract StringBuilder getErasedSignature(StringBuilder paramStringBuilder);
  
  protected void _assertSubclass(Class<?> subclass, Class<?> superClass)
  {
    if (!_class.isAssignableFrom(subclass)) {
      throw new IllegalArgumentException("Class " + subclass.getName() + " is not assignable to " + _class.getName());
    }
  }
  
  public abstract String toString();
  
  public abstract boolean equals(Object paramObject);
  
  public final int hashCode()
  {
    return _hash;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */