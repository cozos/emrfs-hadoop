package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;

public class JsonWriteContext
  extends JsonStreamContext
{
  public static final int STATUS_OK_AS_IS = 0;
  public static final int STATUS_OK_AFTER_COMMA = 1;
  public static final int STATUS_OK_AFTER_COLON = 2;
  public static final int STATUS_OK_AFTER_SPACE = 3;
  public static final int STATUS_EXPECT_VALUE = 4;
  public static final int STATUS_EXPECT_NAME = 5;
  protected final JsonWriteContext _parent;
  protected DupDetector _dups;
  protected JsonWriteContext _child = null;
  protected String _currentName;
  protected Object _currentValue;
  protected boolean _gotName;
  
  protected JsonWriteContext(int type, JsonWriteContext parent, DupDetector dups)
  {
    _type = type;
    _parent = parent;
    _dups = dups;
    _index = -1;
  }
  
  protected JsonWriteContext reset(int type)
  {
    _type = type;
    _index = -1;
    _currentName = null;
    _gotName = false;
    _currentValue = null;
    if (_dups != null) {
      _dups.reset();
    }
    return this;
  }
  
  public JsonWriteContext withDupDetector(DupDetector dups)
  {
    _dups = dups;
    return this;
  }
  
  public Object getCurrentValue()
  {
    return _currentValue;
  }
  
  public void setCurrentValue(Object v)
  {
    _currentValue = v;
  }
  
  @Deprecated
  public static JsonWriteContext createRootContext()
  {
    return createRootContext(null);
  }
  
  public static JsonWriteContext createRootContext(DupDetector dd)
  {
    return new JsonWriteContext(0, null, dd);
  }
  
  public JsonWriteContext createChildArrayContext()
  {
    JsonWriteContext ctxt = _child;
    if (ctxt == null)
    {
      _child = (ctxt = new JsonWriteContext(1, this, _dups == null ? null : _dups.child()));
      return ctxt;
    }
    return ctxt.reset(1);
  }
  
  public JsonWriteContext createChildObjectContext()
  {
    JsonWriteContext ctxt = _child;
    if (ctxt == null)
    {
      _child = (ctxt = new JsonWriteContext(2, this, _dups == null ? null : _dups.child()));
      return ctxt;
    }
    return ctxt.reset(2);
  }
  
  public final JsonWriteContext getParent()
  {
    return _parent;
  }
  
  public final String getCurrentName()
  {
    return _currentName;
  }
  
  public DupDetector getDupDetector()
  {
    return _dups;
  }
  
  public int writeFieldName(String name)
    throws JsonProcessingException
  {
    if (_gotName) {
      return 4;
    }
    _gotName = true;
    _currentName = name;
    if (_dups != null) {
      _checkDup(_dups, name);
    }
    return _index < 0 ? 0 : 1;
  }
  
  private final void _checkDup(DupDetector dd, String name)
    throws JsonProcessingException
  {
    if (dd.isDup(name)) {
      throw new JsonGenerationException("Duplicate field '" + name + "'");
    }
  }
  
  public int writeValue()
  {
    if (_type == 2)
    {
      if (!_gotName) {
        return 5;
      }
      _gotName = false;
      _index += 1;
      return 2;
    }
    if (_type == 1)
    {
      int ix = _index;
      _index += 1;
      return ix < 0 ? 0 : 1;
    }
    _index += 1;
    return _index == 0 ? 0 : 3;
  }
  
  protected void appendDesc(StringBuilder sb)
  {
    if (_type == 2)
    {
      sb.append('{');
      if (_currentName != null)
      {
        sb.append('"');
        
        sb.append(_currentName);
        sb.append('"');
      }
      else
      {
        sb.append('?');
      }
      sb.append('}');
    }
    else if (_type == 1)
    {
      sb.append('[');
      sb.append(getCurrentIndex());
      sb.append(']');
    }
    else
    {
      sb.append("/");
    }
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder(64);
    appendDesc(sb);
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.JsonWriteContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */