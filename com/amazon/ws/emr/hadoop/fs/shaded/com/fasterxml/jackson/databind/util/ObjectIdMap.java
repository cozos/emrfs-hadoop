package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import java.util.IdentityHashMap;

public class ObjectIdMap
  extends IdentityHashMap<Object, Object>
{
  public ObjectIdMap()
  {
    super(16);
  }
  
  public Object findId(Object pojo)
  {
    return get(pojo);
  }
  
  public void insertId(Object pojo, Object id)
  {
    put(pojo, id);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.ObjectIdMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */