package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

import java.io.Serializable;

public class JsonLocation
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public static final JsonLocation NA = new JsonLocation("N/A", -1L, -1L, -1, -1);
  final long _totalBytes;
  final long _totalChars;
  final int _lineNr;
  final int _columnNr;
  final transient Object _sourceRef;
  
  public JsonLocation(Object srcRef, long totalChars, int lineNr, int colNr)
  {
    this(srcRef, -1L, totalChars, lineNr, colNr);
  }
  
  public JsonLocation(Object sourceRef, long totalBytes, long totalChars, int lineNr, int columnNr)
  {
    _sourceRef = sourceRef;
    _totalBytes = totalBytes;
    _totalChars = totalChars;
    _lineNr = lineNr;
    _columnNr = columnNr;
  }
  
  public Object getSourceRef()
  {
    return _sourceRef;
  }
  
  public int getLineNr()
  {
    return _lineNr;
  }
  
  public int getColumnNr()
  {
    return _columnNr;
  }
  
  public long getCharOffset()
  {
    return _totalChars;
  }
  
  public long getByteOffset()
  {
    return _totalBytes;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder(80);
    sb.append("[Source: ");
    if (_sourceRef == null) {
      sb.append("UNKNOWN");
    } else {
      sb.append(_sourceRef.toString());
    }
    sb.append("; line: ");
    sb.append(_lineNr);
    sb.append(", column: ");
    sb.append(_columnNr);
    sb.append(']');
    return sb.toString();
  }
  
  public int hashCode()
  {
    int hash = _sourceRef == null ? 1 : _sourceRef.hashCode();
    hash ^= _lineNr;
    hash += _columnNr;
    hash ^= (int)_totalChars;
    hash += (int)_totalBytes;
    return hash;
  }
  
  public boolean equals(Object other)
  {
    if (other == this) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (!(other instanceof JsonLocation)) {
      return false;
    }
    JsonLocation otherLoc = (JsonLocation)other;
    if (_sourceRef == null)
    {
      if (_sourceRef != null) {
        return false;
      }
    }
    else if (!_sourceRef.equals(_sourceRef)) {
      return false;
    }
    return (_lineNr == _lineNr) && (_columnNr == _columnNr) && (_totalChars == _totalChars) && (getByteOffset() == otherLoc.getByteOffset());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */