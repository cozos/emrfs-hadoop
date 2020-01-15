package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import java.io.Serializable;

public class JsonMappingException$Reference
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Object _from;
  protected String _fieldName;
  protected int _index = -1;
  
  protected JsonMappingException$Reference() {}
  
  public JsonMappingException$Reference(Object from)
  {
    _from = from;
  }
  
  public JsonMappingException$Reference(Object from, String fieldName)
  {
    _from = from;
    if (fieldName == null) {
      throw new NullPointerException("Can not pass null fieldName");
    }
    _fieldName = fieldName;
  }
  
  public JsonMappingException$Reference(Object from, int index)
  {
    _from = from;
    _index = index;
  }
  
  public void setFrom(Object o)
  {
    _from = o;
  }
  
  public void setFieldName(String n)
  {
    _fieldName = n;
  }
  
  public void setIndex(int ix)
  {
    _index = ix;
  }
  
  public Object getFrom()
  {
    return _from;
  }
  
  public String getFieldName()
  {
    return _fieldName;
  }
  
  public int getIndex()
  {
    return _index;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    Class<?> cls = (_from instanceof Class) ? (Class)_from : _from.getClass();
    
    Package pkg = cls.getPackage();
    if (pkg != null)
    {
      sb.append(pkg.getName());
      sb.append('.');
    }
    sb.append(cls.getSimpleName());
    sb.append('[');
    if (_fieldName != null)
    {
      sb.append('"');
      sb.append(_fieldName);
      sb.append('"');
    }
    else if (_index >= 0)
    {
      sb.append(_index);
    }
    else
    {
      sb.append('?');
    }
    sb.append(']');
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException.Reference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */