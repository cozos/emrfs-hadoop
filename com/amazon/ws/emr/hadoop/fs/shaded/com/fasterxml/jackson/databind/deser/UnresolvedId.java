package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;

public class UnresolvedId
{
  private final Object _id;
  private final JsonLocation _location;
  private final Class<?> _type;
  
  public UnresolvedId(Object id, Class<?> type, JsonLocation where)
  {
    _id = id;
    _type = type;
    _location = where;
  }
  
  public Object getId()
  {
    return _id;
  }
  
  public Class<?> getType()
  {
    return _type;
  }
  
  public JsonLocation getLocation()
  {
    return _location;
  }
  
  public String toString()
  {
    return String.format("Object id [%s] (for %s) at %s", new Object[] { _id, _type == null ? "NULL" : _type.getName(), _location });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.UnresolvedId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */