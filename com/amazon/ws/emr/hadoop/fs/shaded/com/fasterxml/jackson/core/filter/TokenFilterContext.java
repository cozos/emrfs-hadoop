package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.filter;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

public class TokenFilterContext
  extends JsonStreamContext
{
  protected final TokenFilterContext _parent;
  protected TokenFilterContext _child = null;
  protected String _currentName;
  protected TokenFilter _filter;
  protected boolean _startHandled;
  protected boolean _needToHandleName;
  
  protected TokenFilterContext(int type, TokenFilterContext parent, TokenFilter filter, boolean startHandled)
  {
    _type = type;
    _parent = parent;
    _filter = filter;
    _index = -1;
    _startHandled = startHandled;
    _needToHandleName = false;
  }
  
  protected TokenFilterContext reset(int type, TokenFilter filter, boolean startWritten)
  {
    _type = type;
    _filter = filter;
    _index = -1;
    _currentName = null;
    _startHandled = startWritten;
    _needToHandleName = false;
    return this;
  }
  
  public static TokenFilterContext createRootContext(TokenFilter filter)
  {
    return new TokenFilterContext(0, null, filter, true);
  }
  
  public TokenFilterContext createChildArrayContext(TokenFilter filter, boolean writeStart)
  {
    TokenFilterContext ctxt = _child;
    if (ctxt == null)
    {
      _child = (ctxt = new TokenFilterContext(1, this, filter, writeStart));
      return ctxt;
    }
    return ctxt.reset(1, filter, writeStart);
  }
  
  public TokenFilterContext createChildObjectContext(TokenFilter filter, boolean writeStart)
  {
    TokenFilterContext ctxt = _child;
    if (ctxt == null)
    {
      _child = (ctxt = new TokenFilterContext(2, this, filter, writeStart));
      return ctxt;
    }
    return ctxt.reset(2, filter, writeStart);
  }
  
  public TokenFilter setFieldName(String name)
    throws JsonProcessingException
  {
    _currentName = name;
    _needToHandleName = true;
    return _filter;
  }
  
  public TokenFilter checkValue(TokenFilter filter)
  {
    if (_type == 2) {
      return filter;
    }
    int ix = ++_index;
    if (_type == 1) {
      return filter.includeElement(ix);
    }
    return filter.includeRootValue(ix);
  }
  
  public void writePath(JsonGenerator gen)
    throws IOException
  {
    if ((_filter == null) || (_filter == TokenFilter.INCLUDE_ALL)) {
      return;
    }
    if (_parent != null) {
      _parent._writePath(gen);
    }
    if (_startHandled)
    {
      if (_needToHandleName) {
        gen.writeFieldName(_currentName);
      }
    }
    else
    {
      _startHandled = true;
      if (_type == 2)
      {
        gen.writeStartObject();
        gen.writeFieldName(_currentName);
      }
      else if (_type == 1)
      {
        gen.writeStartArray();
      }
    }
  }
  
  public void writeImmediatePath(JsonGenerator gen)
    throws IOException
  {
    if ((_filter == null) || (_filter == TokenFilter.INCLUDE_ALL)) {
      return;
    }
    if (_startHandled)
    {
      if (_needToHandleName) {
        gen.writeFieldName(_currentName);
      }
    }
    else
    {
      _startHandled = true;
      if (_type == 2)
      {
        gen.writeStartObject();
        if (_needToHandleName) {
          gen.writeFieldName(_currentName);
        }
      }
      else if (_type == 1)
      {
        gen.writeStartArray();
      }
    }
  }
  
  private void _writePath(JsonGenerator gen)
    throws IOException
  {
    if ((_filter == null) || (_filter == TokenFilter.INCLUDE_ALL)) {
      return;
    }
    if (_parent != null) {
      _parent._writePath(gen);
    }
    if (_startHandled)
    {
      if (_needToHandleName)
      {
        _needToHandleName = false;
        gen.writeFieldName(_currentName);
      }
    }
    else
    {
      _startHandled = true;
      if (_type == 2)
      {
        gen.writeStartObject();
        if (_needToHandleName)
        {
          _needToHandleName = false;
          gen.writeFieldName(_currentName);
        }
      }
      else if (_type == 1)
      {
        gen.writeStartArray();
      }
    }
  }
  
  public TokenFilterContext closeArray(JsonGenerator gen)
    throws IOException
  {
    if (_startHandled) {
      gen.writeEndArray();
    }
    if ((_filter != null) && (_filter != TokenFilter.INCLUDE_ALL)) {
      _filter.filterFinishArray();
    }
    return _parent;
  }
  
  public TokenFilterContext closeObject(JsonGenerator gen)
    throws IOException
  {
    if (_startHandled) {
      gen.writeEndObject();
    }
    if ((_filter != null) && (_filter != TokenFilter.INCLUDE_ALL)) {
      _filter.filterFinishObject();
    }
    return _parent;
  }
  
  public void skipParentChecks()
  {
    _filter = null;
    for (TokenFilterContext ctxt = _parent; ctxt != null; ctxt = _parent) {
      _parent._filter = null;
    }
  }
  
  public Object getCurrentValue()
  {
    return null;
  }
  
  public void setCurrentValue(Object v) {}
  
  public final TokenFilterContext getParent()
  {
    return _parent;
  }
  
  public final String getCurrentName()
  {
    return _currentName;
  }
  
  public TokenFilter getFilter()
  {
    return _filter;
  }
  
  public boolean isStartHandled()
  {
    return _startHandled;
  }
  
  public JsonToken nextTokenToRead()
  {
    if (!_startHandled)
    {
      _startHandled = true;
      if (_type == 2) {
        return JsonToken.START_OBJECT;
      }
      return JsonToken.START_ARRAY;
    }
    if ((_needToHandleName) && (_type == 2))
    {
      _needToHandleName = false;
      return JsonToken.FIELD_NAME;
    }
    return null;
  }
  
  public TokenFilterContext findChildOf(TokenFilterContext parent)
  {
    if (_parent == parent) {
      return this;
    }
    TokenFilterContext curr = _parent;
    while (curr != null)
    {
      TokenFilterContext p = _parent;
      if (p == parent) {
        return curr;
      }
      curr = p;
    }
    return null;
  }
  
  protected void appendDesc(StringBuilder sb)
  {
    if (_parent != null) {
      _parent.appendDesc(sb);
    }
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.filter.TokenFilterContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */