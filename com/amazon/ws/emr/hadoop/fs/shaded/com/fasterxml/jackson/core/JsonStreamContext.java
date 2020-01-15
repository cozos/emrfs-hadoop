package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

public abstract class JsonStreamContext
{
  protected static final int TYPE_ROOT = 0;
  protected static final int TYPE_ARRAY = 1;
  protected static final int TYPE_OBJECT = 2;
  protected int _type;
  protected int _index;
  
  public abstract JsonStreamContext getParent();
  
  public final boolean inArray()
  {
    return _type == 1;
  }
  
  public final boolean inRoot()
  {
    return _type == 0;
  }
  
  public final boolean inObject()
  {
    return _type == 2;
  }
  
  public final String getTypeDesc()
  {
    switch (_type)
    {
    case 0: 
      return "ROOT";
    case 1: 
      return "ARRAY";
    case 2: 
      return "OBJECT";
    }
    return "?";
  }
  
  public final int getEntryCount()
  {
    return _index + 1;
  }
  
  public final int getCurrentIndex()
  {
    return _index < 0 ? 0 : _index;
  }
  
  public abstract String getCurrentName();
  
  public Object getCurrentValue()
  {
    return null;
  }
  
  public void setCurrentValue(Object v) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */