package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;

public class ReferenceType
  extends SimpleType
{
  private static final long serialVersionUID = 1L;
  protected final JavaType _referencedType;
  
  protected ReferenceType(Class<?> cls, JavaType refType, Object valueHandler, Object typeHandler, boolean asStatic)
  {
    super(cls, refType.hashCode(), valueHandler, typeHandler, asStatic);
    
    _referencedType = refType;
  }
  
  public static ReferenceType construct(Class<?> cls, JavaType refType, Object valueHandler, Object typeHandler)
  {
    return new ReferenceType(cls, refType, null, null, false);
  }
  
  public ReferenceType withTypeHandler(Object h)
  {
    if (h == _typeHandler) {
      return this;
    }
    return new ReferenceType(_class, _referencedType, _valueHandler, h, _asStatic);
  }
  
  public ReferenceType withContentTypeHandler(Object h)
  {
    if (h == _referencedType.getTypeHandler()) {
      return this;
    }
    return new ReferenceType(_class, _referencedType.withTypeHandler(h), _valueHandler, _typeHandler, _asStatic);
  }
  
  public ReferenceType withValueHandler(Object h)
  {
    if (h == _valueHandler) {
      return this;
    }
    return new ReferenceType(_class, _referencedType, h, _typeHandler, _asStatic);
  }
  
  public ReferenceType withContentValueHandler(Object h)
  {
    if (h == _referencedType.getValueHandler()) {
      return this;
    }
    return new ReferenceType(_class, _referencedType.withValueHandler(h), _valueHandler, _typeHandler, _asStatic);
  }
  
  public ReferenceType withStaticTyping()
  {
    if (_asStatic) {
      return this;
    }
    return new ReferenceType(_class, _referencedType.withStaticTyping(), _valueHandler, _typeHandler, true);
  }
  
  protected String buildCanonicalName()
  {
    StringBuilder sb = new StringBuilder();
    sb.append(_class.getName());
    sb.append('<');
    sb.append(_referencedType.toCanonical());
    return sb.toString();
  }
  
  protected JavaType _narrow(Class<?> subclass)
  {
    return new ReferenceType(subclass, _referencedType, _valueHandler, _typeHandler, _asStatic);
  }
  
  public JavaType getReferencedType()
  {
    return _referencedType;
  }
  
  public boolean isReferenceType()
  {
    return true;
  }
  
  public int containedTypeCount()
  {
    return 1;
  }
  
  public JavaType containedType(int index)
  {
    return index == 0 ? _referencedType : null;
  }
  
  public String containedTypeName(int index)
  {
    return index == 0 ? "T" : null;
  }
  
  public Class<?> getParameterSource()
  {
    return _class;
  }
  
  public StringBuilder getErasedSignature(StringBuilder sb)
  {
    return _classSignature(_class, sb, true);
  }
  
  public StringBuilder getGenericSignature(StringBuilder sb)
  {
    _classSignature(_class, sb, false);
    sb.append('<');
    sb = _referencedType.getGenericSignature(sb);
    sb.append(">;");
    return sb;
  }
  
  public String toString()
  {
    return 40 + "[reference type, class " + buildCanonicalName() + '<' + _referencedType + '>' + ']';
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
    ReferenceType other = (ReferenceType)o;
    if (_class != _class) {
      return false;
    }
    return _referencedType.equals(_referencedType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ReferenceType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */