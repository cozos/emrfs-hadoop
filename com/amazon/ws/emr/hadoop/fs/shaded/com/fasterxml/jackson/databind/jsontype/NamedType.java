package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype;

import java.io.Serializable;

public final class NamedType
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final Class<?> _class;
  protected final int _hashCode;
  protected String _name;
  
  public NamedType(Class<?> c)
  {
    this(c, null);
  }
  
  public NamedType(Class<?> c, String name)
  {
    _class = c;
    _hashCode = c.getName().hashCode();
    setName(name);
  }
  
  public Class<?> getType()
  {
    return _class;
  }
  
  public String getName()
  {
    return _name;
  }
  
  public void setName(String name)
  {
    _name = ((name == null) || (name.length() == 0) ? null : name);
  }
  
  public boolean hasName()
  {
    return _name != null;
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
    return _class == _class;
  }
  
  public int hashCode()
  {
    return _hashCode;
  }
  
  public String toString()
  {
    return "[NamedType, class " + _class.getName() + ", name: " + (_name == null ? "null" : new StringBuilder().append("'").append(_name).append("'").toString()) + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.NamedType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */