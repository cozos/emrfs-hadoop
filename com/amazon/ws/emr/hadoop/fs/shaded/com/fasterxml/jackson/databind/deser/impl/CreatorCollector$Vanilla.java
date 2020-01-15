package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class CreatorCollector$Vanilla
  extends ValueInstantiator
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public static final int TYPE_COLLECTION = 1;
  public static final int TYPE_MAP = 2;
  public static final int TYPE_HASH_MAP = 3;
  private final int _type;
  
  public CreatorCollector$Vanilla(int t)
  {
    _type = t;
  }
  
  public String getValueTypeDesc()
  {
    switch (_type)
    {
    case 1: 
      return ArrayList.class.getName();
    case 2: 
      return LinkedHashMap.class.getName();
    case 3: 
      return HashMap.class.getName();
    }
    return Object.class.getName();
  }
  
  public boolean canInstantiate()
  {
    return true;
  }
  
  public boolean canCreateUsingDefault()
  {
    return true;
  }
  
  public Object createUsingDefault(DeserializationContext ctxt)
    throws IOException
  {
    switch (_type)
    {
    case 1: 
      return new ArrayList();
    case 2: 
      return new LinkedHashMap();
    case 3: 
      return new HashMap();
    }
    throw new IllegalStateException("Unknown type " + _type);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.impl.CreatorCollector.Vanilla
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */