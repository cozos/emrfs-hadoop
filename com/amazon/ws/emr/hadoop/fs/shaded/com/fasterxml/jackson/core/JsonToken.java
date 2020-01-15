package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

public enum JsonToken
{
  NOT_AVAILABLE(null, -1),  START_OBJECT("{", 1),  END_OBJECT("}", 2),  START_ARRAY("[", 3),  END_ARRAY("]", 4),  FIELD_NAME(null, 5),  VALUE_EMBEDDED_OBJECT(null, 12),  VALUE_STRING(null, 6),  VALUE_NUMBER_INT(null, 7),  VALUE_NUMBER_FLOAT(null, 8),  VALUE_TRUE("true", 9),  VALUE_FALSE("false", 10),  VALUE_NULL("null", 11);
  
  final String _serialized;
  final char[] _serializedChars;
  final byte[] _serializedBytes;
  final int _id;
  final boolean _isStructStart;
  final boolean _isStructEnd;
  final boolean _isNumber;
  final boolean _isBoolean;
  final boolean _isScalar;
  
  private JsonToken(String token, int id)
  {
    if (token == null)
    {
      _serialized = null;
      _serializedChars = null;
      _serializedBytes = null;
    }
    else
    {
      _serialized = token;
      _serializedChars = token.toCharArray();
      
      int len = _serializedChars.length;
      _serializedBytes = new byte[len];
      for (int i = 0; i < len; i++) {
        _serializedBytes[i] = ((byte)_serializedChars[i]);
      }
    }
    _id = id;
    
    _isBoolean = ((id == 10) || (id == 9));
    _isNumber = ((id == 7) || (id == 8));
    
    _isStructStart = ((id == 1) || (id == 3));
    _isStructEnd = ((id == 2) || (id == 4));
    
    _isScalar = ((!_isStructStart) && (!_isStructEnd) && (id != 5) && (id != -1));
  }
  
  public final int id()
  {
    return _id;
  }
  
  public final String asString()
  {
    return _serialized;
  }
  
  public final char[] asCharArray()
  {
    return _serializedChars;
  }
  
  public final byte[] asByteArray()
  {
    return _serializedBytes;
  }
  
  public final boolean isNumeric()
  {
    return _isNumber;
  }
  
  public final boolean isStructStart()
  {
    return _isStructStart;
  }
  
  public final boolean isStructEnd()
  {
    return _isStructEnd;
  }
  
  public final boolean isScalarValue()
  {
    return _isScalar;
  }
  
  public final boolean isBoolean()
  {
    return _isBoolean;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */