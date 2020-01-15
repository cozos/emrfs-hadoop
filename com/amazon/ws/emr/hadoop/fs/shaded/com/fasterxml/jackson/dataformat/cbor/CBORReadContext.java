package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.CharTypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.DupDetector;

public final class CBORReadContext
  extends JsonStreamContext
{
  protected final CBORReadContext _parent;
  protected final DupDetector _dups;
  protected int _expEntryCount;
  protected String _currentName;
  protected CBORReadContext _child = null;
  
  public CBORReadContext(CBORReadContext parent, DupDetector dups, int type, int expEntryCount)
  {
    _parent = parent;
    _dups = dups;
    _type = type;
    _expEntryCount = expEntryCount;
    _index = -1;
  }
  
  protected void reset(int type, int expEntryCount)
  {
    _type = type;
    _expEntryCount = expEntryCount;
    _index = -1;
    _currentName = null;
    if (_dups != null) {
      _dups.reset();
    }
  }
  
  public static CBORReadContext createRootContext(DupDetector dups)
  {
    return new CBORReadContext(null, dups, 0, -1);
  }
  
  public CBORReadContext createChildArrayContext(int expEntryCount)
  {
    CBORReadContext ctxt = _child;
    if (ctxt == null) {
      _child = (ctxt = new CBORReadContext(this, _dups == null ? null : _dups.child(), 1, expEntryCount));
    } else {
      ctxt.reset(1, expEntryCount);
    }
    return ctxt;
  }
  
  public CBORReadContext createChildObjectContext(int expEntryCount)
  {
    CBORReadContext ctxt = _child;
    if (ctxt == null)
    {
      _child = (ctxt = new CBORReadContext(this, _dups == null ? null : _dups.child(), 2, expEntryCount));
      
      return ctxt;
    }
    ctxt.reset(2, expEntryCount);
    return ctxt;
  }
  
  public String getCurrentName()
  {
    return _currentName;
  }
  
  public CBORReadContext getParent()
  {
    return _parent;
  }
  
  public boolean hasExpectedLength()
  {
    return _expEntryCount >= 0;
  }
  
  public int getExpectedLength()
  {
    return _expEntryCount;
  }
  
  public boolean acceptsBreakMarker()
  {
    return (_expEntryCount < 0) && (_type != 0);
  }
  
  public boolean expectMoreValues()
  {
    if (++_index == _expEntryCount) {
      return false;
    }
    return true;
  }
  
  public JsonLocation getStartLocation(Object srcRef)
  {
    return new JsonLocation(srcRef, 1L, -1, -1);
  }
  
  public void setCurrentName(String name)
    throws JsonProcessingException
  {
    _currentName = name;
    if (_dups != null) {
      _checkDup(_dups, name);
    }
  }
  
  private void _checkDup(DupDetector dd, String name)
    throws JsonProcessingException
  {
    if (dd.isDup(name)) {
      throw new JsonParseException("Duplicate field '" + name + "'", dd.findLocation());
    }
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder(64);
    switch (_type)
    {
    case 0: 
      sb.append("/");
      break;
    case 1: 
      sb.append('[');
      sb.append(getCurrentIndex());
      sb.append(']');
      break;
    case 2: 
      sb.append('{');
      if (_currentName != null)
      {
        sb.append('"');
        CharTypes.appendQuoted(sb, _currentName);
        sb.append('"');
      }
      else
      {
        sb.append('?');
      }
      sb.append('}');
    }
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor.CBORReadContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */