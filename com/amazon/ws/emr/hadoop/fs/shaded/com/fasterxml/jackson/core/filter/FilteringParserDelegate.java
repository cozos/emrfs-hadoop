package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.filter;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.JsonParserDelegate;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class FilteringParserDelegate
  extends JsonParserDelegate
{
  protected TokenFilter rootFilter;
  protected boolean _allowMultipleMatches;
  protected boolean _includePath;
  @Deprecated
  protected boolean _includeImmediateParent = false;
  protected JsonToken _currToken;
  protected JsonToken _lastClearedToken;
  protected TokenFilterContext _headContext;
  protected TokenFilterContext _exposedContext;
  protected TokenFilter _itemFilter;
  protected int _matchCount;
  
  public FilteringParserDelegate(JsonParser p, TokenFilter f, boolean includePath, boolean allowMultipleMatches)
  {
    super(p);
    rootFilter = f;
    
    _itemFilter = f;
    _headContext = TokenFilterContext.createRootContext(f);
    _includePath = includePath;
    _allowMultipleMatches = allowMultipleMatches;
  }
  
  public TokenFilter getFilter()
  {
    return rootFilter;
  }
  
  public int getMatchCount()
  {
    return _matchCount;
  }
  
  public JsonToken getCurrentToken()
  {
    return _currToken;
  }
  
  public final int getCurrentTokenId()
  {
    JsonToken t = _currToken;
    return t == null ? 0 : t.id();
  }
  
  public boolean hasCurrentToken()
  {
    return _currToken != null;
  }
  
  public boolean hasTokenId(int id)
  {
    JsonToken t = _currToken;
    if (t == null) {
      return 0 == id;
    }
    return t.id() == id;
  }
  
  public final boolean hasToken(JsonToken t)
  {
    return _currToken == t;
  }
  
  public boolean isExpectedStartArrayToken()
  {
    return _currToken == JsonToken.START_ARRAY;
  }
  
  public boolean isExpectedStartObjectToken()
  {
    return _currToken == JsonToken.START_OBJECT;
  }
  
  public JsonLocation getCurrentLocation()
  {
    return delegate.getCurrentLocation();
  }
  
  public JsonStreamContext getParsingContext()
  {
    return _filterContext();
  }
  
  public String getCurrentName()
    throws IOException
  {
    JsonStreamContext ctxt = _filterContext();
    if ((_currToken == JsonToken.START_OBJECT) || (_currToken == JsonToken.START_ARRAY))
    {
      JsonStreamContext parent = ctxt.getParent();
      return parent == null ? null : parent.getCurrentName();
    }
    return ctxt.getCurrentName();
  }
  
  public void clearCurrentToken()
  {
    if (_currToken != null)
    {
      _lastClearedToken = _currToken;
      _currToken = null;
    }
  }
  
  public JsonToken getLastClearedToken()
  {
    return _lastClearedToken;
  }
  
  public void overrideCurrentName(String name)
  {
    throw new UnsupportedOperationException("Can not currently override name during filtering read");
  }
  
  public JsonToken nextToken()
    throws IOException
  {
    TokenFilterContext ctxt = _exposedContext;
    if (ctxt != null) {
      for (;;)
      {
        JsonToken t = ctxt.nextTokenToRead();
        if (t != null)
        {
          _currToken = t;
          return t;
        }
        if (ctxt == _headContext)
        {
          _exposedContext = null;
          if (!ctxt.inArray()) {
            break;
          }
          t = delegate.getCurrentToken();
          
          _currToken = t;
          return t;
        }
        ctxt = _headContext.findChildOf(ctxt);
        _exposedContext = ctxt;
        if (ctxt == null) {
          throw _constructError("Unexpected problem: chain of filtered context broken");
        }
      }
    }
    JsonToken t = delegate.nextToken();
    if (t == null) {
      return _currToken = t;
    }
    TokenFilter f;
    switch (t.id())
    {
    case 3: 
      f = _itemFilter;
      if (f == TokenFilter.INCLUDE_ALL)
      {
        _headContext = _headContext.createChildArrayContext(f, true);
        return _currToken = t;
      }
      if (f == null)
      {
        delegate.skipChildren();
      }
      else
      {
        f = _headContext.checkValue(f);
        if (f == null)
        {
          delegate.skipChildren();
        }
        else
        {
          if (f != TokenFilter.INCLUDE_ALL) {
            f = f.filterStartArray();
          }
          _itemFilter = f;
          if (f == TokenFilter.INCLUDE_ALL)
          {
            _headContext = _headContext.createChildArrayContext(f, true);
            return _currToken = t;
          }
          _headContext = _headContext.createChildArrayContext(f, false);
          if (_includePath)
          {
            t = _nextTokenWithBuffering(_headContext);
            if (t != null)
            {
              _currToken = t;
              return t;
            }
          }
        }
      }
      break;
    case 1: 
      f = _itemFilter;
      if (f == TokenFilter.INCLUDE_ALL)
      {
        _headContext = _headContext.createChildObjectContext(f, true);
        return _currToken = t;
      }
      if (f == null)
      {
        delegate.skipChildren();
      }
      else
      {
        f = _headContext.checkValue(f);
        if (f == null)
        {
          delegate.skipChildren();
        }
        else
        {
          if (f != TokenFilter.INCLUDE_ALL) {
            f = f.filterStartObject();
          }
          _itemFilter = f;
          if (f == TokenFilter.INCLUDE_ALL)
          {
            _headContext = _headContext.createChildObjectContext(f, true);
            return _currToken = t;
          }
          _headContext = _headContext.createChildObjectContext(f, false);
          if (_includePath)
          {
            t = _nextTokenWithBuffering(_headContext);
            if (t != null)
            {
              _currToken = t;
              return t;
            }
          }
        }
      }
      break;
    case 2: 
    case 4: 
      boolean returnEnd = _headContext.isStartHandled();
      f = _headContext.getFilter();
      if ((f != null) && (f != TokenFilter.INCLUDE_ALL)) {
        f.filterFinishArray();
      }
      _headContext = _headContext.getParent();
      _itemFilter = _headContext.getFilter();
      if (returnEnd) {
        return _currToken = t;
      }
      break;
    case 5: 
      String name = delegate.getCurrentName();
      
      f = _headContext.setFieldName(name);
      if (f == TokenFilter.INCLUDE_ALL)
      {
        _itemFilter = f;
        if (!_includePath) {
          if ((_includeImmediateParent) && (!_headContext.isStartHandled()))
          {
            t = _headContext.nextTokenToRead();
            _exposedContext = _headContext;
          }
        }
        return _currToken = t;
      }
      if (f == null)
      {
        delegate.nextToken();
        delegate.skipChildren();
      }
      else
      {
        f = f.includeProperty(name);
        if (f == null)
        {
          delegate.nextToken();
          delegate.skipChildren();
        }
        else
        {
          _itemFilter = f;
          if ((f == TokenFilter.INCLUDE_ALL) && 
            (_includePath)) {
            return _currToken = t;
          }
          if (_includePath)
          {
            t = _nextTokenWithBuffering(_headContext);
            if (t != null)
            {
              _currToken = t;
              return t;
            }
          }
        }
      }
      break;
    default: 
      f = _itemFilter;
      if (f == TokenFilter.INCLUDE_ALL) {
        return _currToken = t;
      }
      if (f != null)
      {
        f = _headContext.checkValue(f);
        if ((f == TokenFilter.INCLUDE_ALL) || ((f != null) && (f.includeValue(delegate)))) {
          return _currToken = t;
        }
      }
      break;
    }
    return _nextToken2();
  }
  
  protected final JsonToken _nextToken2()
    throws IOException
  {
    for (;;)
    {
      JsonToken t = delegate.nextToken();
      if (t == null) {
        return _currToken = t;
      }
      TokenFilter f;
      switch (t.id())
      {
      case 3: 
        f = _itemFilter;
        if (f == TokenFilter.INCLUDE_ALL)
        {
          _headContext = _headContext.createChildArrayContext(f, true);
          return _currToken = t;
        }
        if (f == null)
        {
          delegate.skipChildren();
        }
        else
        {
          f = _headContext.checkValue(f);
          if (f == null)
          {
            delegate.skipChildren();
          }
          else
          {
            if (f != TokenFilter.INCLUDE_ALL) {
              f = f.filterStartArray();
            }
            _itemFilter = f;
            if (f == TokenFilter.INCLUDE_ALL)
            {
              _headContext = _headContext.createChildArrayContext(f, true);
              return _currToken = t;
            }
            _headContext = _headContext.createChildArrayContext(f, false);
            if (_includePath)
            {
              t = _nextTokenWithBuffering(_headContext);
              if (t != null)
              {
                _currToken = t;
                return t;
              }
            }
          }
        }
        break;
      case 1: 
        f = _itemFilter;
        if (f == TokenFilter.INCLUDE_ALL)
        {
          _headContext = _headContext.createChildObjectContext(f, true);
          return _currToken = t;
        }
        if (f == null)
        {
          delegate.skipChildren();
        }
        else
        {
          f = _headContext.checkValue(f);
          if (f == null)
          {
            delegate.skipChildren();
          }
          else
          {
            if (f != TokenFilter.INCLUDE_ALL) {
              f = f.filterStartObject();
            }
            _itemFilter = f;
            if (f == TokenFilter.INCLUDE_ALL)
            {
              _headContext = _headContext.createChildObjectContext(f, true);
              return _currToken = t;
            }
            _headContext = _headContext.createChildObjectContext(f, false);
            if (_includePath)
            {
              t = _nextTokenWithBuffering(_headContext);
              if (t != null)
              {
                _currToken = t;
                return t;
              }
            }
          }
        }
        break;
      case 2: 
      case 4: 
        boolean returnEnd = _headContext.isStartHandled();
        f = _headContext.getFilter();
        if ((f != null) && (f != TokenFilter.INCLUDE_ALL)) {
          f.filterFinishArray();
        }
        _headContext = _headContext.getParent();
        _itemFilter = _headContext.getFilter();
        if (returnEnd) {
          return _currToken = t;
        }
        break;
      case 5: 
        String name = delegate.getCurrentName();
        f = _headContext.setFieldName(name);
        if (f == TokenFilter.INCLUDE_ALL)
        {
          _itemFilter = f;
          return _currToken = t;
        }
        if (f == null)
        {
          delegate.nextToken();
          delegate.skipChildren();
        }
        else
        {
          f = f.includeProperty(name);
          if (f == null)
          {
            delegate.nextToken();
            delegate.skipChildren();
          }
          else
          {
            _itemFilter = f;
            if (f == TokenFilter.INCLUDE_ALL)
            {
              if (_includePath) {
                return _currToken = t;
              }
            }
            else if (_includePath)
            {
              t = _nextTokenWithBuffering(_headContext);
              if (t != null)
              {
                _currToken = t;
                return t;
              }
            }
          }
        }
        break;
      default: 
        f = _itemFilter;
        if (f == TokenFilter.INCLUDE_ALL) {
          return _currToken = t;
        }
        if (f != null)
        {
          f = _headContext.checkValue(f);
          if ((f == TokenFilter.INCLUDE_ALL) || ((f != null) && (f.includeValue(delegate)))) {
            return _currToken = t;
          }
        }
        break;
      }
    }
  }
  
  protected final JsonToken _nextTokenWithBuffering(TokenFilterContext buffRoot)
    throws IOException
  {
    TokenFilter f;
    do
    {
      do
      {
        for (;;)
        {
          JsonToken t = delegate.nextToken();
          if (t == null) {
            return t;
          }
          switch (t.id())
          {
          case 3: 
            f = _headContext.checkValue(_itemFilter);
            if (f == null)
            {
              delegate.skipChildren();
            }
            else
            {
              if (f != TokenFilter.INCLUDE_ALL) {
                f = f.filterStartArray();
              }
              _itemFilter = f;
              if (f == TokenFilter.INCLUDE_ALL)
              {
                _headContext = _headContext.createChildArrayContext(f, true);
                return _nextBuffered(buffRoot);
              }
              _headContext = _headContext.createChildArrayContext(f, false);
            }
            break;
          case 1: 
            f = _itemFilter;
            if (f == TokenFilter.INCLUDE_ALL)
            {
              _headContext = _headContext.createChildObjectContext(f, true);
              return t;
            }
            if (f == null)
            {
              delegate.skipChildren();
            }
            else
            {
              f = _headContext.checkValue(f);
              if (f == null)
              {
                delegate.skipChildren();
              }
              else
              {
                if (f != TokenFilter.INCLUDE_ALL) {
                  f = f.filterStartObject();
                }
                _itemFilter = f;
                if (f == TokenFilter.INCLUDE_ALL)
                {
                  _headContext = _headContext.createChildObjectContext(f, true);
                  return _nextBuffered(buffRoot);
                }
                _headContext = _headContext.createChildObjectContext(f, false);
              }
            }
            break;
          case 2: 
          case 4: 
            f = _headContext.getFilter();
            if ((f != null) && (f != TokenFilter.INCLUDE_ALL)) {
              f.filterFinishArray();
            }
            boolean gotEnd = _headContext == buffRoot;
            boolean returnEnd = (gotEnd) && (_headContext.isStartHandled());
            
            _headContext = _headContext.getParent();
            _itemFilter = _headContext.getFilter();
            if (returnEnd) {
              return t;
            }
            if ((gotEnd) || (_headContext == buffRoot)) {
              return null;
            }
            break;
          case 5: 
            String name = delegate.getCurrentName();
            f = _headContext.setFieldName(name);
            if (f == TokenFilter.INCLUDE_ALL)
            {
              _itemFilter = f;
              return _nextBuffered(buffRoot);
            }
            if (f == null)
            {
              delegate.nextToken();
              delegate.skipChildren();
            }
            else
            {
              f = f.includeProperty(name);
              if (f == null)
              {
                delegate.nextToken();
                delegate.skipChildren();
              }
              else
              {
                _itemFilter = f;
                if (f == TokenFilter.INCLUDE_ALL) {
                  return _nextBuffered(buffRoot);
                }
              }
            }
            break;
          }
        }
        f = _itemFilter;
        if (f == TokenFilter.INCLUDE_ALL) {
          return _nextBuffered(buffRoot);
        }
      } while (f == null);
      f = _headContext.checkValue(f);
    } while ((f != TokenFilter.INCLUDE_ALL) && ((f == null) || (!f.includeValue(delegate))));
    return _nextBuffered(buffRoot);
  }
  
  private JsonToken _nextBuffered(TokenFilterContext buffRoot)
    throws IOException
  {
    _exposedContext = buffRoot;
    TokenFilterContext ctxt = buffRoot;
    JsonToken t = ctxt.nextTokenToRead();
    if (t != null) {
      return t;
    }
    do
    {
      if (ctxt == _headContext) {
        throw _constructError("Internal error: failed to locate expected buffered tokens");
      }
      ctxt = _exposedContext.findChildOf(ctxt);
      _exposedContext = ctxt;
      if (ctxt == null) {
        throw _constructError("Unexpected problem: chain of filtered context broken");
      }
      t = _exposedContext.nextTokenToRead();
    } while (t == null);
    return t;
  }
  
  public JsonToken nextValue()
    throws IOException
  {
    JsonToken t = nextToken();
    if (t == JsonToken.FIELD_NAME) {
      t = nextToken();
    }
    return t;
  }
  
  public JsonParser skipChildren()
    throws IOException
  {
    if ((_currToken != JsonToken.START_OBJECT) && (_currToken != JsonToken.START_ARRAY)) {
      return this;
    }
    int open = 1;
    for (;;)
    {
      JsonToken t = nextToken();
      if (t == null) {
        return this;
      }
      if (t.isStructStart())
      {
        open++;
      }
      else if (t.isStructEnd())
      {
        open--;
        if (open == 0) {
          return this;
        }
      }
    }
  }
  
  public String getText()
    throws IOException
  {
    return delegate.getText();
  }
  
  public boolean hasTextCharacters()
  {
    return delegate.hasTextCharacters();
  }
  
  public char[] getTextCharacters()
    throws IOException
  {
    return delegate.getTextCharacters();
  }
  
  public int getTextLength()
    throws IOException
  {
    return delegate.getTextLength();
  }
  
  public int getTextOffset()
    throws IOException
  {
    return delegate.getTextOffset();
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException
  {
    return delegate.getBigIntegerValue();
  }
  
  public boolean getBooleanValue()
    throws IOException
  {
    return delegate.getBooleanValue();
  }
  
  public byte getByteValue()
    throws IOException
  {
    return delegate.getByteValue();
  }
  
  public short getShortValue()
    throws IOException
  {
    return delegate.getShortValue();
  }
  
  public BigDecimal getDecimalValue()
    throws IOException
  {
    return delegate.getDecimalValue();
  }
  
  public double getDoubleValue()
    throws IOException
  {
    return delegate.getDoubleValue();
  }
  
  public float getFloatValue()
    throws IOException
  {
    return delegate.getFloatValue();
  }
  
  public int getIntValue()
    throws IOException
  {
    return delegate.getIntValue();
  }
  
  public long getLongValue()
    throws IOException
  {
    return delegate.getLongValue();
  }
  
  public JsonParser.NumberType getNumberType()
    throws IOException
  {
    return delegate.getNumberType();
  }
  
  public Number getNumberValue()
    throws IOException
  {
    return delegate.getNumberValue();
  }
  
  public int getValueAsInt()
    throws IOException
  {
    return delegate.getValueAsInt();
  }
  
  public int getValueAsInt(int defaultValue)
    throws IOException
  {
    return delegate.getValueAsInt(defaultValue);
  }
  
  public long getValueAsLong()
    throws IOException
  {
    return delegate.getValueAsLong();
  }
  
  public long getValueAsLong(long defaultValue)
    throws IOException
  {
    return delegate.getValueAsLong(defaultValue);
  }
  
  public double getValueAsDouble()
    throws IOException
  {
    return delegate.getValueAsDouble();
  }
  
  public double getValueAsDouble(double defaultValue)
    throws IOException
  {
    return delegate.getValueAsDouble(defaultValue);
  }
  
  public boolean getValueAsBoolean()
    throws IOException
  {
    return delegate.getValueAsBoolean();
  }
  
  public boolean getValueAsBoolean(boolean defaultValue)
    throws IOException
  {
    return delegate.getValueAsBoolean(defaultValue);
  }
  
  public String getValueAsString()
    throws IOException
  {
    return delegate.getValueAsString();
  }
  
  public String getValueAsString(String defaultValue)
    throws IOException
  {
    return delegate.getValueAsString(defaultValue);
  }
  
  public Object getEmbeddedObject()
    throws IOException
  {
    return delegate.getEmbeddedObject();
  }
  
  public byte[] getBinaryValue(Base64Variant b64variant)
    throws IOException
  {
    return delegate.getBinaryValue(b64variant);
  }
  
  public int readBinaryValue(Base64Variant b64variant, OutputStream out)
    throws IOException
  {
    return delegate.readBinaryValue(b64variant, out);
  }
  
  public JsonLocation getTokenLocation()
  {
    return delegate.getTokenLocation();
  }
  
  protected JsonStreamContext _filterContext()
  {
    if (_exposedContext != null) {
      return _exposedContext;
    }
    return _headContext;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.filter.FilteringParserDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */