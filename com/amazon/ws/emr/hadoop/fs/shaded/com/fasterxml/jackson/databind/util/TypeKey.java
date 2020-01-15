package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;

public class TypeKey
{
  protected int _hashCode;
  protected Class<?> _class;
  protected JavaType _type;
  protected boolean _isTyped;
  
  public TypeKey() {}
  
  public TypeKey(TypeKey src)
  {
    _hashCode = _hashCode;
    _class = _class;
    _type = _type;
    _isTyped = _isTyped;
  }
  
  public TypeKey(Class<?> key, boolean typed)
  {
    _class = key;
    _type = null;
    _isTyped = typed;
    _hashCode = (typed ? typedHash(key) : untypedHash(key));
  }
  
  public TypeKey(JavaType key, boolean typed)
  {
    _type = key;
    _class = null;
    _isTyped = typed;
    _hashCode = (typed ? typedHash(key) : untypedHash(key));
  }
  
  public static final int untypedHash(Class<?> cls)
  {
    return cls.getName().hashCode();
  }
  
  public static final int typedHash(Class<?> cls)
  {
    return cls.getName().hashCode() + 1;
  }
  
  public static final int untypedHash(JavaType type)
  {
    return type.hashCode() - 1;
  }
  
  public static final int typedHash(JavaType type)
  {
    return type.hashCode() - 2;
  }
  
  public final void resetTyped(Class<?> cls)
  {
    _type = null;
    _class = cls;
    _isTyped = true;
    _hashCode = typedHash(cls);
  }
  
  public final void resetUntyped(Class<?> cls)
  {
    _type = null;
    _class = cls;
    _isTyped = false;
    _hashCode = untypedHash(cls);
  }
  
  public final void resetTyped(JavaType type)
  {
    _type = type;
    _class = null;
    _isTyped = true;
    _hashCode = typedHash(type);
  }
  
  public final void resetUntyped(JavaType type)
  {
    _type = type;
    _class = null;
    _isTyped = false;
    _hashCode = untypedHash(type);
  }
  
  public boolean isTyped()
  {
    return _isTyped;
  }
  
  public Class<?> getRawType()
  {
    return _class;
  }
  
  public JavaType getType()
  {
    return _type;
  }
  
  public final int hashCode()
  {
    return _hashCode;
  }
  
  public final String toString()
  {
    if (_class != null) {
      return "{class: " + _class.getName() + ", typed? " + _isTyped + "}";
    }
    return "{type: " + _type + ", typed? " + _isTyped + "}";
  }
  
  public final boolean equals(Object o)
  {
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (o.getClass() != getClass()) {
      return false;
    }
    TypeKey other = (TypeKey)o;
    if (_isTyped == _isTyped)
    {
      if (_class != null) {
        return _class == _class;
      }
      return _type.equals(_type);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TypeKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */