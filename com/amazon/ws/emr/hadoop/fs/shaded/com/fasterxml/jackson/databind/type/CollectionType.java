package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import java.util.Collection;

public final class CollectionType
  extends CollectionLikeType
{
  private static final long serialVersionUID = 1L;
  
  private CollectionType(Class<?> collT, JavaType elemT, Object valueHandler, Object typeHandler, boolean asStatic)
  {
    super(collT, elemT, valueHandler, typeHandler, asStatic);
  }
  
  protected JavaType _narrow(Class<?> subclass)
  {
    return new CollectionType(subclass, _elementType, null, null, _asStatic);
  }
  
  public JavaType narrowContentsBy(Class<?> contentClass)
  {
    if (contentClass == _elementType.getRawClass()) {
      return this;
    }
    return new CollectionType(_class, _elementType.narrowBy(contentClass), _valueHandler, _typeHandler, _asStatic);
  }
  
  public JavaType widenContentsBy(Class<?> contentClass)
  {
    if (contentClass == _elementType.getRawClass()) {
      return this;
    }
    return new CollectionType(_class, _elementType.widenBy(contentClass), _valueHandler, _typeHandler, _asStatic);
  }
  
  public static CollectionType construct(Class<?> rawType, JavaType elemT)
  {
    return new CollectionType(rawType, elemT, null, null, false);
  }
  
  public CollectionType withTypeHandler(Object h)
  {
    return new CollectionType(_class, _elementType, _valueHandler, h, _asStatic);
  }
  
  public CollectionType withContentTypeHandler(Object h)
  {
    return new CollectionType(_class, _elementType.withTypeHandler(h), _valueHandler, _typeHandler, _asStatic);
  }
  
  public CollectionType withValueHandler(Object h)
  {
    return new CollectionType(_class, _elementType, h, _typeHandler, _asStatic);
  }
  
  public CollectionType withContentValueHandler(Object h)
  {
    return new CollectionType(_class, _elementType.withValueHandler(h), _valueHandler, _typeHandler, _asStatic);
  }
  
  public CollectionType withStaticTyping()
  {
    if (_asStatic) {
      return this;
    }
    return new CollectionType(_class, _elementType.withStaticTyping(), _valueHandler, _typeHandler, true);
  }
  
  public Class<?> getParameterSource()
  {
    return Collection.class;
  }
  
  public String toString()
  {
    return "[collection type; class " + _class.getName() + ", contains " + _elementType + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.CollectionType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */