package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class JsonMappingException
  extends JsonProcessingException
{
  private static final long serialVersionUID = 1L;
  static final int MAX_REFS_TO_LIST = 1000;
  protected LinkedList<Reference> _path;
  
  public static class Reference
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    protected Object _from;
    protected String _fieldName;
    protected int _index = -1;
    
    protected Reference() {}
    
    public Reference(Object from)
    {
      _from = from;
    }
    
    public Reference(Object from, String fieldName)
    {
      _from = from;
      if (fieldName == null) {
        throw new NullPointerException("Can not pass null fieldName");
      }
      _fieldName = fieldName;
    }
    
    public Reference(Object from, int index)
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
  
  public JsonMappingException(String msg)
  {
    super(msg);
  }
  
  public JsonMappingException(String msg, Throwable rootCause)
  {
    super(msg, rootCause);
  }
  
  public JsonMappingException(String msg, JsonLocation loc)
  {
    super(msg, loc);
  }
  
  public JsonMappingException(String msg, JsonLocation loc, Throwable rootCause)
  {
    super(msg, loc, rootCause);
  }
  
  public static JsonMappingException from(JsonParser jp, String msg)
  {
    return new JsonMappingException(msg, jp == null ? null : jp.getTokenLocation());
  }
  
  public static JsonMappingException from(JsonParser jp, String msg, Throwable problem)
  {
    return new JsonMappingException(msg, jp == null ? null : jp.getTokenLocation(), problem);
  }
  
  public static JsonMappingException fromUnexpectedIOE(IOException src)
  {
    return new JsonMappingException("Unexpected IOException (of type " + src.getClass().getName() + "): " + src.getMessage(), (JsonLocation)null, src);
  }
  
  public static JsonMappingException wrapWithPath(Throwable src, Object refFrom, String refFieldName)
  {
    return wrapWithPath(src, new Reference(refFrom, refFieldName));
  }
  
  public static JsonMappingException wrapWithPath(Throwable src, Object refFrom, int index)
  {
    return wrapWithPath(src, new Reference(refFrom, index));
  }
  
  public static JsonMappingException wrapWithPath(Throwable src, Reference ref)
  {
    JsonMappingException jme;
    JsonMappingException jme;
    if ((src instanceof JsonMappingException))
    {
      jme = (JsonMappingException)src;
    }
    else
    {
      String msg = src.getMessage();
      if ((msg == null) || (msg.length() == 0)) {
        msg = "(was " + src.getClass().getName() + ")";
      }
      jme = new JsonMappingException(msg, null, src);
    }
    jme.prependPath(ref);
    return jme;
  }
  
  public List<Reference> getPath()
  {
    if (_path == null) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(_path);
  }
  
  public String getPathReference()
  {
    return getPathReference(new StringBuilder()).toString();
  }
  
  public StringBuilder getPathReference(StringBuilder sb)
  {
    _appendPathDesc(sb);
    return sb;
  }
  
  public void prependPath(Object referrer, String fieldName)
  {
    Reference ref = new Reference(referrer, fieldName);
    prependPath(ref);
  }
  
  public void prependPath(Object referrer, int index)
  {
    Reference ref = new Reference(referrer, index);
    prependPath(ref);
  }
  
  public void prependPath(Reference r)
  {
    if (_path == null) {
      _path = new LinkedList();
    }
    if (_path.size() < 1000) {
      _path.addFirst(r);
    }
  }
  
  public String getLocalizedMessage()
  {
    return _buildMessage();
  }
  
  public String getMessage()
  {
    return _buildMessage();
  }
  
  protected String _buildMessage()
  {
    String msg = super.getMessage();
    if (_path == null) {
      return msg;
    }
    StringBuilder sb = msg == null ? new StringBuilder() : new StringBuilder(msg);
    
    sb.append(" (through reference chain: ");
    sb = getPathReference(sb);
    sb.append(')');
    return sb.toString();
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + getMessage();
  }
  
  protected void _appendPathDesc(StringBuilder sb)
  {
    if (_path == null) {
      return;
    }
    Iterator<Reference> it = _path.iterator();
    while (it.hasNext())
    {
      sb.append(((Reference)it.next()).toString());
      if (it.hasNext()) {
        sb.append("->");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */