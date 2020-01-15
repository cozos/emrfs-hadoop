package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import java.util.Collection;
import java.util.Map;

public class SimpleType
  extends TypeBase
{
  private static final long serialVersionUID = 1L;
  protected final Class<?> _typeParametersFor;
  protected final JavaType[] _typeParameters;
  protected final String[] _typeNames;
  
  protected SimpleType(Class<?> cls)
  {
    this(cls, null, null, null, null, false, null);
  }
  
  @Deprecated
  protected SimpleType(Class<?> cls, String[] typeNames, JavaType[] typeParams, Object valueHandler, Object typeHandler, boolean asStatic)
  {
    this(cls, typeNames, typeParams, valueHandler, typeHandler, asStatic, null);
  }
  
  protected SimpleType(Class<?> cls, String[] typeNames, JavaType[] typeParams, Object valueHandler, Object typeHandler, boolean asStatic, Class<?> parametersFrom)
  {
    super(cls, 0, valueHandler, typeHandler, asStatic);
    if ((typeNames == null) || (typeNames.length == 0))
    {
      _typeNames = null;
      _typeParameters = null;
    }
    else
    {
      _typeNames = typeNames;
      _typeParameters = typeParams;
    }
    _typeParametersFor = parametersFrom;
  }
  
  protected SimpleType(Class<?> cls, int extraHash, Object valueHandler, Object typeHandler, boolean asStatic)
  {
    super(cls, extraHash, valueHandler, typeHandler, asStatic);
    _typeNames = null;
    _typeParameters = null;
    _typeParametersFor = cls;
  }
  
  public static SimpleType constructUnsafe(Class<?> raw)
  {
    return new SimpleType(raw, null, null, null, null, false, null);
  }
  
  protected JavaType _narrow(Class<?> subclass)
  {
    return new SimpleType(subclass, _typeNames, _typeParameters, _valueHandler, _typeHandler, _asStatic, _typeParametersFor);
  }
  
  public JavaType narrowContentsBy(Class<?> subclass)
  {
    throw new IllegalArgumentException("Internal error: SimpleType.narrowContentsBy() should never be called");
  }
  
  public JavaType widenContentsBy(Class<?> subclass)
  {
    throw new IllegalArgumentException("Internal error: SimpleType.widenContentsBy() should never be called");
  }
  
  public static SimpleType construct(Class<?> cls)
  {
    if (Map.class.isAssignableFrom(cls)) {
      throw new IllegalArgumentException("Can not construct SimpleType for a Map (class: " + cls.getName() + ")");
    }
    if (Collection.class.isAssignableFrom(cls)) {
      throw new IllegalArgumentException("Can not construct SimpleType for a Collection (class: " + cls.getName() + ")");
    }
    if (cls.isArray()) {
      throw new IllegalArgumentException("Can not construct SimpleType for an array (class: " + cls.getName() + ")");
    }
    return new SimpleType(cls);
  }
  
  public SimpleType withTypeHandler(Object h)
  {
    return new SimpleType(_class, _typeNames, _typeParameters, _valueHandler, h, _asStatic, _typeParametersFor);
  }
  
  public JavaType withContentTypeHandler(Object h)
  {
    throw new IllegalArgumentException("Simple types have no content types; can not call withContenTypeHandler()");
  }
  
  public SimpleType withValueHandler(Object h)
  {
    if (h == _valueHandler) {
      return this;
    }
    return new SimpleType(_class, _typeNames, _typeParameters, h, _typeHandler, _asStatic, _typeParametersFor);
  }
  
  public SimpleType withContentValueHandler(Object h)
  {
    throw new IllegalArgumentException("Simple types have no content types; can not call withContenValueHandler()");
  }
  
  public SimpleType withStaticTyping()
  {
    return _asStatic ? this : new SimpleType(_class, _typeNames, _typeParameters, _valueHandler, _typeHandler, true, _typeParametersFor);
  }
  
  protected String buildCanonicalName()
  {
    StringBuilder sb = new StringBuilder();
    sb.append(_class.getName());
    if ((_typeParameters != null) && (_typeParameters.length > 0))
    {
      sb.append('<');
      boolean first = true;
      for (JavaType t : _typeParameters)
      {
        if (first) {
          first = false;
        } else {
          sb.append(',');
        }
        sb.append(t.toCanonical());
      }
      sb.append('>');
    }
    return sb.toString();
  }
  
  public boolean isContainerType()
  {
    return false;
  }
  
  public int containedTypeCount()
  {
    return _typeParameters == null ? 0 : _typeParameters.length;
  }
  
  public JavaType containedType(int index)
  {
    if ((index < 0) || (_typeParameters == null) || (index >= _typeParameters.length)) {
      return null;
    }
    return _typeParameters[index];
  }
  
  public String containedTypeName(int index)
  {
    if ((index < 0) || (_typeNames == null) || (index >= _typeNames.length)) {
      return null;
    }
    return _typeNames[index];
  }
  
  public Class<?> getParameterSource()
  {
    return _typeParametersFor;
  }
  
  public StringBuilder getErasedSignature(StringBuilder sb)
  {
    return _classSignature(_class, sb, true);
  }
  
  public StringBuilder getGenericSignature(StringBuilder sb)
  {
    _classSignature(_class, sb, false);
    if (_typeParameters != null)
    {
      sb.append('<');
      for (JavaType param : _typeParameters) {
        sb = param.getGenericSignature(sb);
      }
      sb.append('>');
    }
    sb.append(';');
    return sb;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder(40);
    sb.append("[simple type, class ").append(buildCanonicalName()).append(']');
    return sb.toString();
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
    SimpleType other = (SimpleType)o;
    if (_class != _class) {
      return false;
    }
    JavaType[] p1 = _typeParameters;
    JavaType[] p2 = _typeParameters;
    if (p1 == null) {
      return (p2 == null) || (p2.length == 0);
    }
    if (p2 == null) {
      return false;
    }
    if (p1.length != p2.length) {
      return false;
    }
    int i = 0;
    for (int len = p1.length; i < len; i++) {
      if (!p1[i].equals(p2[i])) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.SimpleType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */