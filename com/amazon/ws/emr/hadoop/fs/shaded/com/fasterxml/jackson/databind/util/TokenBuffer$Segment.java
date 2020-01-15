package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.util.TreeMap;

public final class TokenBuffer$Segment
{
  public static final int TOKENS_PER_SEGMENT = 16;
  private static final JsonToken[] TOKEN_TYPES_BY_INDEX = new JsonToken[16];
  protected Segment _next;
  protected long _tokenTypes;
  
  static
  {
    JsonToken[] t = JsonToken.values();
    
    System.arraycopy(t, 1, TOKEN_TYPES_BY_INDEX, 1, Math.min(15, t.length - 1));
  }
  
  protected final Object[] _tokens = new Object[16];
  protected TreeMap<Integer, Object> _nativeIds;
  
  public JsonToken type(int index)
  {
    long l = _tokenTypes;
    if (index > 0) {
      l >>= index << 2;
    }
    int ix = (int)l & 0xF;
    return TOKEN_TYPES_BY_INDEX[ix];
  }
  
  public int rawType(int index)
  {
    long l = _tokenTypes;
    if (index > 0) {
      l >>= index << 2;
    }
    int ix = (int)l & 0xF;
    return ix;
  }
  
  public Object get(int index)
  {
    return _tokens[index];
  }
  
  public Segment next()
  {
    return _next;
  }
  
  public boolean hasIds()
  {
    return _nativeIds != null;
  }
  
  public Segment append(int index, JsonToken tokenType)
  {
    if (index < 16)
    {
      set(index, tokenType);
      return null;
    }
    _next = new Segment();
    _next.set(0, tokenType);
    return _next;
  }
  
  public Segment append(int index, JsonToken tokenType, Object objectId, Object typeId)
  {
    if (index < 16)
    {
      set(index, tokenType, objectId, typeId);
      return null;
    }
    _next = new Segment();
    _next.set(0, tokenType, objectId, typeId);
    return _next;
  }
  
  public Segment append(int index, JsonToken tokenType, Object value)
  {
    if (index < 16)
    {
      set(index, tokenType, value);
      return null;
    }
    _next = new Segment();
    _next.set(0, tokenType, value);
    return _next;
  }
  
  public Segment append(int index, JsonToken tokenType, Object value, Object objectId, Object typeId)
  {
    if (index < 16)
    {
      set(index, tokenType, value, objectId, typeId);
      return null;
    }
    _next = new Segment();
    _next.set(0, tokenType, value, objectId, typeId);
    return _next;
  }
  
  public Segment appendRaw(int index, int rawTokenType, Object value)
  {
    if (index < 16)
    {
      set(index, rawTokenType, value);
      return null;
    }
    _next = new Segment();
    _next.set(0, rawTokenType, value);
    return _next;
  }
  
  public Segment appendRaw(int index, int rawTokenType, Object value, Object objectId, Object typeId)
  {
    if (index < 16)
    {
      set(index, rawTokenType, value, objectId, typeId);
      return null;
    }
    _next = new Segment();
    _next.set(0, rawTokenType, value, objectId, typeId);
    return _next;
  }
  
  private void set(int index, JsonToken tokenType)
  {
    long typeCode = tokenType.ordinal();
    if (index > 0) {
      typeCode <<= index << 2;
    }
    _tokenTypes |= typeCode;
  }
  
  private void set(int index, JsonToken tokenType, Object objectId, Object typeId)
  {
    long typeCode = tokenType.ordinal();
    if (index > 0) {
      typeCode <<= index << 2;
    }
    _tokenTypes |= typeCode;
    assignNativeIds(index, objectId, typeId);
  }
  
  private void set(int index, JsonToken tokenType, Object value)
  {
    _tokens[index] = value;
    long typeCode = tokenType.ordinal();
    if (index > 0) {
      typeCode <<= index << 2;
    }
    _tokenTypes |= typeCode;
  }
  
  private void set(int index, JsonToken tokenType, Object value, Object objectId, Object typeId)
  {
    _tokens[index] = value;
    long typeCode = tokenType.ordinal();
    if (index > 0) {
      typeCode <<= index << 2;
    }
    _tokenTypes |= typeCode;
    assignNativeIds(index, objectId, typeId);
  }
  
  private void set(int index, int rawTokenType, Object value)
  {
    _tokens[index] = value;
    long typeCode = rawTokenType;
    if (index > 0) {
      typeCode <<= index << 2;
    }
    _tokenTypes |= typeCode;
  }
  
  private void set(int index, int rawTokenType, Object value, Object objectId, Object typeId)
  {
    _tokens[index] = value;
    long typeCode = rawTokenType;
    if (index > 0) {
      typeCode <<= index << 2;
    }
    _tokenTypes |= typeCode;
    assignNativeIds(index, objectId, typeId);
  }
  
  private final void assignNativeIds(int index, Object objectId, Object typeId)
  {
    if (_nativeIds == null) {
      _nativeIds = new TreeMap();
    }
    if (objectId != null) {
      _nativeIds.put(Integer.valueOf(_objectIdIndex(index)), objectId);
    }
    if (typeId != null) {
      _nativeIds.put(Integer.valueOf(_typeIdIndex(index)), typeId);
    }
  }
  
  public Object findObjectId(int index)
  {
    return _nativeIds == null ? null : _nativeIds.get(Integer.valueOf(_objectIdIndex(index)));
  }
  
  public Object findTypeId(int index)
  {
    return _nativeIds == null ? null : _nativeIds.get(Integer.valueOf(_typeIdIndex(index)));
  }
  
  private final int _typeIdIndex(int i)
  {
    return i + i;
  }
  
  private final int _objectIdIndex(int i)
  {
    return i + i + 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.TokenBuffer.Segment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */