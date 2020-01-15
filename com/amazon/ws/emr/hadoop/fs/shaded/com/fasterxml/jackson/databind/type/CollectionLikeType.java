package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import java.util.Collection;

public class CollectionLikeType
  extends TypeBase
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _elementType;
  
  protected CollectionLikeType(Class<?> collT, JavaType elemT, Object valueHandler, Object typeHandler, boolean asStatic)
  {
    super(collT, elemT.hashCode(), valueHandler, typeHandler, asStatic);
    _elementType = elemT;
  }
  
  protected JavaType _narrow(Class<?> subclass)
  {
    return new CollectionLikeType(subclass, _elementType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public JavaType narrowContentsBy(Class<?> contentClass)
  {
    if (contentClass == _elementType.getRawClass()) {
      return this;
    }
    return new CollectionLikeType(_class, _elementType.narrowBy(contentClass), _valueHandler, _typeHandler, _asStatic);
  }
  
  public JavaType widenContentsBy(Class<?> contentClass)
  {
    if (contentClass == _elementType.getRawClass()) {
      return this;
    }
    return new CollectionLikeType(_class, _elementType.widenBy(contentClass), _valueHandler, _typeHandler, _asStatic);
  }
  
  public static CollectionLikeType construct(Class<?> rawType, JavaType elemT)
  {
    return new CollectionLikeType(rawType, elemT, null, null, false);
  }
  
  public CollectionLikeType withTypeHandler(Object h)
  {
    return new CollectionLikeType(_class, _elementType, _valueHandler, h, _asStatic);
  }
  
  public CollectionLikeType withContentTypeHandler(Object h)
  {
    return new CollectionLikeType(_class, _elementType.withTypeHandler(h), _valueHandler, _typeHandler, _asStatic);
  }
  
  public CollectionLikeType withValueHandler(Object h)
  {
    return new CollectionLikeType(_class, _elementType, h, _typeHandler, _asStatic);
  }
  
  public CollectionLikeType withContentValueHandler(Object h)
  {
    return new CollectionLikeType(_class, _elementType.withValueHandler(h), _valueHandler, _typeHandler, _asStatic);
  }
  
  public CollectionLikeType withStaticTyping()
  {
    if (_asStatic) {
      return this;
    }
    return new CollectionLikeType(_class, _elementType.withStaticTyping(), _valueHandler, _typeHandler, true);
  }
  
  public boolean isContainerType()
  {
    return true;
  }
  
  public boolean isCollectionLikeType()
  {
    return true;
  }
  
  public JavaType getContentType()
  {
    return _elementType;
  }
  
  public int containedTypeCount()
  {
    return 1;
  }
  
  public JavaType containedType(int index)
  {
    return index == 0 ? _elementType : null;
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
  
  public StringBuilder getErasedSignature(StringBuilder sb)
  {
    return _classSignature(_class, sb, true);
  }
  
  public StringBuilder getGenericSignature(StringBuilder sb)
  {
    _classSignature(_class, sb, false);
    sb.append('<');
    _elementType.getGenericSignature(sb);
    sb.append(">;");
    return sb;
  }
  
  protected String buildCanonicalName()
  {
    StringBuilder sb = new StringBuilder();
    sb.append(_class.getName());
    if (_elementType != null)
    {
      sb.append('<');
      sb.append(_elementType.toCanonical());
      sb.append('>');
    }
    return sb.toString();
  }
  
  public boolean isTrueCollectionType()
  {
    return Collection.class.isAssignableFrom(_class);
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
    CollectionLikeType other = (CollectionLikeType)o;
    return (_class == _class) && (_elementType.equals(_elementType));
  }
  
  public String toString()
  {
    return "[collection-like type; class " + _class.getName() + ", contains " + _elementType + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.CollectionLikeType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */