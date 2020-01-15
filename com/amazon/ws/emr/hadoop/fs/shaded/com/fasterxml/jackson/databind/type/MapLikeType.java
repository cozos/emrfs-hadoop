package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import java.util.Map;

public class MapLikeType
  extends TypeBase
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _keyType;
  protected final JavaType _valueType;
  
  protected MapLikeType(Class<?> mapType, JavaType keyT, JavaType valueT, Object valueHandler, Object typeHandler, boolean asStatic)
  {
    super(mapType, keyT.hashCode() ^ valueT.hashCode(), valueHandler, typeHandler, asStatic);
    _keyType = keyT;
    _valueType = valueT;
  }
  
  public static MapLikeType construct(Class<?> rawType, JavaType keyT, JavaType valueT)
  {
    return new MapLikeType(rawType, keyT, valueT, null, null, false);
  }
  
  protected JavaType _narrow(Class<?> subclass)
  {
    return new MapLikeType(subclass, _keyType, _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public JavaType narrowContentsBy(Class<?> contentClass)
  {
    if (contentClass == _valueType.getRawClass()) {
      return this;
    }
    return new MapLikeType(_class, _keyType, _valueType.narrowBy(contentClass), _valueHandler, _typeHandler, _asStatic);
  }
  
  public JavaType widenContentsBy(Class<?> contentClass)
  {
    if (contentClass == _valueType.getRawClass()) {
      return this;
    }
    return new MapLikeType(_class, _keyType, _valueType.widenBy(contentClass), _valueHandler, _typeHandler, _asStatic);
  }
  
  public JavaType narrowKey(Class<?> keySubclass)
  {
    if (keySubclass == _keyType.getRawClass()) {
      return this;
    }
    return new MapLikeType(_class, _keyType.narrowBy(keySubclass), _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public JavaType widenKey(Class<?> keySubclass)
  {
    if (keySubclass == _keyType.getRawClass()) {
      return this;
    }
    return new MapLikeType(_class, _keyType.widenBy(keySubclass), _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public MapLikeType withTypeHandler(Object h)
  {
    return new MapLikeType(_class, _keyType, _valueType, _valueHandler, h, _asStatic);
  }
  
  public MapLikeType withContentTypeHandler(Object h)
  {
    return new MapLikeType(_class, _keyType, _valueType.withTypeHandler(h), _valueHandler, _typeHandler, _asStatic);
  }
  
  public MapLikeType withValueHandler(Object h)
  {
    return new MapLikeType(_class, _keyType, _valueType, h, _typeHandler, _asStatic);
  }
  
  public MapLikeType withContentValueHandler(Object h)
  {
    return new MapLikeType(_class, _keyType, _valueType.withValueHandler(h), _valueHandler, _typeHandler, _asStatic);
  }
  
  public MapLikeType withStaticTyping()
  {
    if (_asStatic) {
      return this;
    }
    return new MapLikeType(_class, _keyType, _valueType.withStaticTyping(), _valueHandler, _typeHandler, true);
  }
  
  protected String buildCanonicalName()
  {
    StringBuilder sb = new StringBuilder();
    sb.append(_class.getName());
    if (_keyType != null)
    {
      sb.append('<');
      sb.append(_keyType.toCanonical());
      sb.append(',');
      sb.append(_valueType.toCanonical());
      sb.append('>');
    }
    return sb.toString();
  }
  
  public boolean isContainerType()
  {
    return true;
  }
  
  public boolean isMapLikeType()
  {
    return true;
  }
  
  public JavaType getKeyType()
  {
    return _keyType;
  }
  
  public JavaType getContentType()
  {
    return _valueType;
  }
  
  public int containedTypeCount()
  {
    return 2;
  }
  
  public JavaType containedType(int index)
  {
    if (index == 0) {
      return _keyType;
    }
    if (index == 1) {
      return _valueType;
    }
    return null;
  }
  
  public String containedTypeName(int index)
  {
    if (index == 0) {
      return "K";
    }
    if (index == 1) {
      return "V";
    }
    return null;
  }
  
  public Class<?> getParameterSource()
  {
    return null;
  }
  
  public StringBuilder getErasedSignature(StringBuilder sb)
  {
    return _classSignature(_class, sb, true);
  }
  
  public StringBuilder getGenericSignature(StringBuilder sb)
  {
    _classSignature(_class, sb, false);
    sb.append('<');
    _keyType.getGenericSignature(sb);
    _valueType.getGenericSignature(sb);
    sb.append(">;");
    return sb;
  }
  
  public MapLikeType withKeyTypeHandler(Object h)
  {
    return new MapLikeType(_class, _keyType.withTypeHandler(h), _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public MapLikeType withKeyValueHandler(Object h)
  {
    return new MapLikeType(_class, _keyType.withValueHandler(h), _valueType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public boolean isTrueMapType()
  {
    return Map.class.isAssignableFrom(_class);
  }
  
  public String toString()
  {
    return "[map-like type; class " + _class.getName() + ", " + _keyType + " -> " + _valueType + "]";
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
    MapLikeType other = (MapLikeType)o;
    return (_class == _class) && (_keyType.equals(_keyType)) && (_valueType.equals(_valueType));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.MapLikeType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */