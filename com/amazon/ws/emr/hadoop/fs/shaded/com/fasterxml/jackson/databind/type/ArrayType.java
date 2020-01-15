package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.Array;

public final class ArrayType
  extends TypeBase
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _componentType;
  protected final Object _emptyArray;
  
  protected ArrayType(JavaType componentType, Object emptyInstance, Object valueHandler, Object typeHandler, boolean asStatic)
  {
    super(emptyInstance.getClass(), componentType.hashCode(), valueHandler, typeHandler, asStatic);
    
    _componentType = componentType;
    _emptyArray = emptyInstance;
  }
  
  public static ArrayType construct(JavaType componentType, Object valueHandler, Object typeHandler)
  {
    Object emptyInstance = Array.newInstance(componentType.getRawClass(), 0);
    return new ArrayType(componentType, emptyInstance, null, null, false);
  }
  
  public ArrayType withTypeHandler(Object h)
  {
    if (h == _typeHandler) {
      return this;
    }
    return new ArrayType(_componentType, _emptyArray, _valueHandler, h, _asStatic);
  }
  
  public ArrayType withContentTypeHandler(Object h)
  {
    if (h == _componentType.getTypeHandler()) {
      return this;
    }
    return new ArrayType(_componentType.withTypeHandler(h), _emptyArray, _valueHandler, _typeHandler, _asStatic);
  }
  
  public ArrayType withValueHandler(Object h)
  {
    if (h == _valueHandler) {
      return this;
    }
    return new ArrayType(_componentType, _emptyArray, h, _typeHandler, _asStatic);
  }
  
  public ArrayType withContentValueHandler(Object h)
  {
    if (h == _componentType.getValueHandler()) {
      return this;
    }
    return new ArrayType(_componentType.withValueHandler(h), _emptyArray, _valueHandler, _typeHandler, _asStatic);
  }
  
  public ArrayType withStaticTyping()
  {
    if (_asStatic) {
      return this;
    }
    return new ArrayType(_componentType.withStaticTyping(), _emptyArray, _valueHandler, _typeHandler, true);
  }
  
  protected String buildCanonicalName()
  {
    return _class.getName();
  }
  
  protected JavaType _narrow(Class<?> subclass)
  {
    if (!subclass.isArray()) {
      throw new IllegalArgumentException("Incompatible narrowing operation: trying to narrow " + toString() + " to class " + subclass.getName());
    }
    Class<?> newCompClass = subclass.getComponentType();
    
    JavaType newCompType = TypeFactory.defaultInstance().constructType(newCompClass);
    return construct(newCompType, _valueHandler, _typeHandler);
  }
  
  public JavaType narrowContentsBy(Class<?> contentClass)
  {
    if (contentClass == _componentType.getRawClass()) {
      return this;
    }
    return construct(_componentType.narrowBy(contentClass), _valueHandler, _typeHandler);
  }
  
  public JavaType widenContentsBy(Class<?> contentClass)
  {
    if (contentClass == _componentType.getRawClass()) {
      return this;
    }
    return construct(_componentType.widenBy(contentClass), _valueHandler, _typeHandler);
  }
  
  public boolean isArrayType()
  {
    return true;
  }
  
  public boolean isAbstract()
  {
    return false;
  }
  
  public boolean isConcrete()
  {
    return true;
  }
  
  public boolean hasGenericTypes()
  {
    return _componentType.hasGenericTypes();
  }
  
  public String containedTypeName(int index)
  {
    if (index == 0) {
      return "E";
    }
    return null;
  }
  
  public Class<?> getParameterSource()
  {
    return null;
  }
  
  public boolean isContainerType()
  {
    return true;
  }
  
  public JavaType getContentType()
  {
    return _componentType;
  }
  
  public int containedTypeCount()
  {
    return 1;
  }
  
  public JavaType containedType(int index)
  {
    return index == 0 ? _componentType : null;
  }
  
  public StringBuilder getGenericSignature(StringBuilder sb)
  {
    sb.append('[');
    return _componentType.getGenericSignature(sb);
  }
  
  public StringBuilder getErasedSignature(StringBuilder sb)
  {
    sb.append('[');
    return _componentType.getErasedSignature(sb);
  }
  
  public String toString()
  {
    return "[array type, component type: " + _componentType + "]";
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (o.getClass() != getClass()) {
      return false;
    }
    ArrayType other = (ArrayType)o;
    return _componentType.equals(_componentType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ArrayType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */