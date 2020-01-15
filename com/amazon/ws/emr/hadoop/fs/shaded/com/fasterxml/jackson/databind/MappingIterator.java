package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.FormatSchema;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MappingIterator<T>
  implements Iterator<T>, Closeable
{
  protected static final MappingIterator<?> EMPTY_ITERATOR = new MappingIterator(null, null, null, null, false, null);
  protected static final int STATE_CLOSED = 0;
  protected static final int STATE_NEED_RESYNC = 1;
  protected static final int STATE_MAY_HAVE_VALUE = 2;
  protected static final int STATE_HAS_VALUE = 3;
  protected final JavaType _type;
  protected final DeserializationContext _context;
  protected final JsonDeserializer<T> _deserializer;
  protected final JsonParser _parser;
  protected final JsonStreamContext _seqContext;
  protected final T _updatedValue;
  protected final boolean _closeParser;
  protected int _state;
  
  protected MappingIterator(JavaType type, JsonParser p, DeserializationContext ctxt, JsonDeserializer<?> deser, boolean managedParser, Object valueToUpdate)
  {
    _type = type;
    _parser = p;
    _context = ctxt;
    _deserializer = deser;
    _closeParser = managedParser;
    if (valueToUpdate == null) {
      _updatedValue = null;
    } else {
      _updatedValue = valueToUpdate;
    }
    if (p == null)
    {
      _seqContext = null;
      _state = 0;
    }
    else
    {
      JsonStreamContext sctxt = p.getParsingContext();
      if ((managedParser) && (p.isExpectedStartArrayToken()))
      {
        p.clearCurrentToken();
      }
      else
      {
        JsonToken t = p.getCurrentToken();
        if ((t == JsonToken.START_OBJECT) || (t == JsonToken.START_ARRAY)) {
          sctxt = sctxt.getParent();
        }
      }
      _seqContext = sctxt;
      _state = 2;
    }
  }
  
  protected static <T> MappingIterator<T> emptyIterator()
  {
    return EMPTY_ITERATOR;
  }
  
  public boolean hasNext()
  {
    try
    {
      return hasNextValue();
    }
    catch (JsonMappingException e)
    {
      return ((Boolean)_handleMappingException(e)).booleanValue();
    }
    catch (IOException e)
    {
      return ((Boolean)_handleIOException(e)).booleanValue();
    }
  }
  
  public T next()
  {
    try
    {
      return (T)nextValue();
    }
    catch (JsonMappingException e)
    {
      throw new RuntimeJsonMappingException(e.getMessage(), e);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e.getMessage(), e);
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
  
  public void close()
    throws IOException
  {
    if (_state != 0)
    {
      _state = 0;
      if (_parser != null) {
        _parser.close();
      }
    }
  }
  
  public boolean hasNextValue()
    throws IOException
  {
    switch (_state)
    {
    case 0: 
      return false;
    case 1: 
      _resync();
    case 2: 
      JsonToken t = _parser.getCurrentToken();
      if (t == null)
      {
        t = _parser.nextToken();
        if ((t == null) || (t == JsonToken.END_ARRAY))
        {
          _state = 0;
          if ((_closeParser) && (_parser != null)) {
            _parser.close();
          }
          return false;
        }
      }
      _state = 3;
      return true;
    }
    return true;
  }
  
  public T nextValue()
    throws IOException
  {
    switch (_state)
    {
    case 0: 
      return (T)_throwNoSuchElement();
    case 1: 
    case 2: 
      if (!hasNextValue()) {
        return (T)_throwNoSuchElement();
      }
      break;
    }
    int nextState = 1;
    try
    {
      T value;
      T value;
      if (_updatedValue == null)
      {
        value = _deserializer.deserialize(_parser, _context);
      }
      else
      {
        _deserializer.deserialize(_parser, _context, _updatedValue);
        value = _updatedValue;
      }
      nextState = 2;
      return value;
    }
    finally
    {
      _state = nextState;
      
      _parser.clearCurrentToken();
    }
  }
  
  public List<T> readAll()
    throws IOException
  {
    return readAll(new ArrayList());
  }
  
  public <L extends List<? super T>> L readAll(L resultList)
    throws IOException
  {
    while (hasNextValue()) {
      resultList.add(nextValue());
    }
    return resultList;
  }
  
  public <C extends Collection<? super T>> C readAll(C results)
    throws IOException
  {
    while (hasNextValue()) {
      results.add(nextValue());
    }
    return results;
  }
  
  public JsonParser getParser()
  {
    return _parser;
  }
  
  public FormatSchema getParserSchema()
  {
    return _parser.getSchema();
  }
  
  public JsonLocation getCurrentLocation()
  {
    return _parser.getCurrentLocation();
  }
  
  protected void _resync()
    throws IOException
  {
    JsonParser p = _parser;
    if (p.getParsingContext() == _seqContext) {
      return;
    }
    for (;;)
    {
      JsonToken t = p.nextToken();
      if ((t == JsonToken.END_ARRAY) || (t == JsonToken.END_OBJECT))
      {
        if (p.getParsingContext() == _seqContext) {
          p.clearCurrentToken();
        }
      }
      else if ((t == JsonToken.START_ARRAY) || (t == JsonToken.START_OBJECT)) {
        p.skipChildren();
      } else if (t == null) {
        return;
      }
    }
  }
  
  protected <R> R _throwNoSuchElement()
  {
    throw new NoSuchElementException();
  }
  
  protected <R> R _handleMappingException(JsonMappingException e)
  {
    throw new RuntimeJsonMappingException(e.getMessage(), e);
  }
  
  protected <R> R _handleIOException(IOException e)
  {
    throw new RuntimeException(e.getMessage(), e);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.MappingIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */