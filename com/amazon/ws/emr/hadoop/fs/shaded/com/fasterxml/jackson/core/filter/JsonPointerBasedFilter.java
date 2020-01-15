package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.filter;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonPointer;

public class JsonPointerBasedFilter
  extends TokenFilter
{
  protected final JsonPointer _pathToMatch;
  
  public JsonPointerBasedFilter(String ptrExpr)
  {
    this(JsonPointer.compile(ptrExpr));
  }
  
  public JsonPointerBasedFilter(JsonPointer match)
  {
    _pathToMatch = match;
  }
  
  public TokenFilter includeElement(int index)
  {
    JsonPointer next = _pathToMatch.matchElement(index);
    if (next == null) {
      return null;
    }
    if (next.matches()) {
      return TokenFilter.INCLUDE_ALL;
    }
    return new JsonPointerBasedFilter(next);
  }
  
  public TokenFilter includeProperty(String name)
  {
    JsonPointer next = _pathToMatch.matchProperty(name);
    if (next == null) {
      return null;
    }
    if (next.matches()) {
      return TokenFilter.INCLUDE_ALL;
    }
    return new JsonPointerBasedFilter(next);
  }
  
  public TokenFilter filterStartArray()
  {
    return this;
  }
  
  public TokenFilter filterStartObject()
  {
    return this;
  }
  
  protected boolean _includeScalar()
  {
    return _pathToMatch.matches();
  }
  
  public String toString()
  {
    return "[JsonPointerFilter at: " + _pathToMatch + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.filter.JsonPointerBasedFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */