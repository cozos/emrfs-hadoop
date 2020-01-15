package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import java.util.Map;

public final class MapType
  extends MapLikeType
{
  private static final long serialVersionUID = 1L;
  
  private MapType(Class<?> mapType, JavaType keyT, JavaType valueT, Object valueHandler, Object typeHandler, boolean asStatic)
  {
    super(mapType, keyT, valueT, valueHandler, typeHandler, asStatic);
  }
  
  public static MapType construct(Class<?> rawType, JavaType keyT, JavaType valueT)
  {
    return new MapType(rawType, keyT, valueT, null, null, false);
  }
  
  protected JavaType _narrow(Class<?> subclass)
  {
    return new MapType(subclass, _keyType, _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public JavaType narrowContentsBy(Class<?> contentClass)
  {
    if (contentClass == _valueType.getRawClass()) {
      return this;
    }
    return new MapType(_class, _keyType, _valueType.narrowBy(contentClass), _valueHandler, _typeHandler, _asStatic);
  }
  
  public JavaType widenContentsBy(Class<?> contentClass)
  {
    if (contentClass == _valueType.getRawClass()) {
      return this;
    }
    return new MapType(_class, _keyType, _valueType.widenBy(contentClass), _valueHandler, _typeHandler, _asStatic);
  }
  
  public JavaType narrowKey(Class<?> keySubclass)
  {
    if (keySubclass == _keyType.getRawClass()) {
      return this;
    }
    return new MapType(_class, _keyType.narrowBy(keySubclass), _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public JavaType widenKey(Class<?> keySubclass)
  {
    if (keySubclass == _keyType.getRawClass()) {
      return this;
    }
    return new MapType(_class, _keyType.widenBy(keySubclass), _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public MapType withTypeHandler(Object h)
  {
    return new MapType(_class, _keyType, _valueType, _valueHandler, h, _asStatic);
  }
  
  public MapType withContentTypeHandler(Object h)
  {
    return new MapType(_class, _keyType, _valueType.withTypeHandler(h), _valueHandler, _typeHandler, _asStatic);
  }
  
  public MapType withValueHandler(Object h)
  {
    return new MapType(_class, _keyType, _valueType, h, _typeHandler, _asStatic);
  }
  
  public MapType withContentValueHandler(Object h)
  {
    return new MapType(_class, _keyType, _valueType.withValueHandler(h), _valueHandler, _typeHandler, _asStatic);
  }
  
  public MapType withStaticTyping()
  {
    if (_asStatic) {
      return this;
    }
    return new MapType(_class, _keyType.withStaticTyping(), _valueType.withStaticTyping(), _valueHandler, _typeHandler, true);
  }
  
  public Class<?> getParameterSource()
  {
    return Map.class;
  }
  
  public MapType withKeyTypeHandler(Object h)
  {
    return new MapType(_class, _keyType.withTypeHandler(h), _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public MapType withKeyValueHandler(Object h)
  {
    return new MapType(_class, _keyType.withValueHandler(h), _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public String toString()
  {
    return "[map type; class " + _class.getName() + ", " + _keyType + " -> " + _valueType + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.MapType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */