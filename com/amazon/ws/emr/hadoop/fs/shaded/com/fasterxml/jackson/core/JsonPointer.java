package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.NumberInput;

public class JsonPointer
{
  protected static final JsonPointer EMPTY = new JsonPointer();
  protected final JsonPointer _nextSegment;
  protected volatile JsonPointer _head;
  protected final String _asString;
  protected final String _matchingPropertyName;
  protected final int _matchingElementIndex;
  
  protected JsonPointer()
  {
    _nextSegment = null;
    _matchingPropertyName = "";
    _matchingElementIndex = -1;
    _asString = "";
  }
  
  protected JsonPointer(String fullString, String segment, JsonPointer next)
  {
    _asString = fullString;
    _nextSegment = next;
    
    _matchingPropertyName = segment;
    
    _matchingElementIndex = _parseIndex(segment);
  }
  
  protected JsonPointer(String fullString, String segment, int matchIndex, JsonPointer next)
  {
    _asString = fullString;
    _nextSegment = next;
    _matchingPropertyName = segment;
    _matchingElementIndex = matchIndex;
  }
  
  public static JsonPointer compile(String input)
    throws IllegalArgumentException
  {
    if ((input == null) || (input.length() == 0)) {
      return EMPTY;
    }
    if (input.charAt(0) != '/') {
      throw new IllegalArgumentException("Invalid input: JSON Pointer expression must start with '/': \"" + input + "\"");
    }
    return _parseTail(input);
  }
  
  public static JsonPointer valueOf(String input)
  {
    return compile(input);
  }
  
  public boolean matches()
  {
    return _nextSegment == null;
  }
  
  public String getMatchingProperty()
  {
    return _matchingPropertyName;
  }
  
  public int getMatchingIndex()
  {
    return _matchingElementIndex;
  }
  
  public boolean mayMatchProperty()
  {
    return _matchingPropertyName != null;
  }
  
  public boolean mayMatchElement()
  {
    return _matchingElementIndex >= 0;
  }
  
  public JsonPointer last()
  {
    JsonPointer current = this;
    if (current == EMPTY) {
      return null;
    }
    JsonPointer next;
    while ((next = _nextSegment) != EMPTY) {
      current = next;
    }
    return current;
  }
  
  public JsonPointer append(JsonPointer tail)
  {
    if (this == EMPTY) {
      return tail;
    }
    if (tail == EMPTY) {
      return this;
    }
    String currentJsonPointer = _asString;
    if (currentJsonPointer.endsWith("/")) {
      currentJsonPointer = currentJsonPointer.substring(0, currentJsonPointer.length() - 1);
    }
    return compile(currentJsonPointer + _asString);
  }
  
  public boolean matchesProperty(String name)
  {
    return (_nextSegment != null) && (_matchingPropertyName.equals(name));
  }
  
  public JsonPointer matchProperty(String name)
  {
    if ((_nextSegment != null) && (_matchingPropertyName.equals(name))) {
      return _nextSegment;
    }
    return null;
  }
  
  public boolean matchesElement(int index)
  {
    return (index == _matchingElementIndex) && (index >= 0);
  }
  
  public JsonPointer matchElement(int index)
  {
    if ((index != _matchingElementIndex) || (index < 0)) {
      return null;
    }
    return _nextSegment;
  }
  
  public JsonPointer tail()
  {
    return _nextSegment;
  }
  
  public JsonPointer head()
  {
    JsonPointer h = _head;
    if (h == null)
    {
      if (this != EMPTY) {
        h = _constructHead();
      }
      _head = h;
    }
    return h;
  }
  
  public String toString()
  {
    return _asString;
  }
  
  public int hashCode()
  {
    return _asString.hashCode();
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (!(o instanceof JsonPointer)) {
      return false;
    }
    return _asString.equals(_asString);
  }
  
  private static final int _parseIndex(String str)
  {
    int len = str.length();
    if ((len == 0) || (len > 10)) {
      return -1;
    }
    char c = str.charAt(0);
    if (c <= '0') {
      return (len == 1) && (c == '0') ? 0 : -1;
    }
    if (c > '9') {
      return -1;
    }
    for (int i = 1; i < len; i++)
    {
      c = str.charAt(i);
      if ((c > '9') || (c < '0')) {
        return -1;
      }
    }
    if (len == 10)
    {
      long l = NumberInput.parseLong(str);
      if (l > 2147483647L) {
        return -1;
      }
    }
    return NumberInput.parseInt(str);
  }
  
  protected static JsonPointer _parseTail(String input)
  {
    int end = input.length();
    for (int i = 1; i < end;)
    {
      char c = input.charAt(i);
      if (c == '/') {
        return new JsonPointer(input, input.substring(1, i), _parseTail(input.substring(i)));
      }
      i++;
      if ((c == '~') && (i < end)) {
        return _parseQuotedTail(input, i);
      }
    }
    return new JsonPointer(input, input.substring(1), EMPTY);
  }
  
  protected static JsonPointer _parseQuotedTail(String input, int i)
  {
    int end = input.length();
    StringBuilder sb = new StringBuilder(Math.max(16, end));
    if (i > 2) {
      sb.append(input, 1, i - 1);
    }
    _appendEscape(sb, input.charAt(i++));
    while (i < end)
    {
      char c = input.charAt(i);
      if (c == '/') {
        return new JsonPointer(input, sb.toString(), _parseTail(input.substring(i)));
      }
      i++;
      if ((c == '~') && (i < end)) {
        _appendEscape(sb, input.charAt(i++));
      } else {
        sb.append(c);
      }
    }
    return new JsonPointer(input, sb.toString(), EMPTY);
  }
  
  protected JsonPointer _constructHead()
  {
    JsonPointer last = last();
    if (last == this) {
      return EMPTY;
    }
    int suffixLength = _asString.length();
    JsonPointer next = _nextSegment;
    return new JsonPointer(_asString.substring(0, _asString.length() - suffixLength), _matchingPropertyName, _matchingElementIndex, next._constructHead(suffixLength, last));
  }
  
  protected JsonPointer _constructHead(int suffixLength, JsonPointer last)
  {
    if (this == last) {
      return EMPTY;
    }
    JsonPointer next = _nextSegment;
    String str = _asString;
    return new JsonPointer(str.substring(0, str.length() - suffixLength), _matchingPropertyName, _matchingElementIndex, next._constructHead(suffixLength, last));
  }
  
  private static void _appendEscape(StringBuilder sb, char c)
  {
    if (c == '0') {
      c = '~';
    } else if (c == '1') {
      c = '/';
    } else {
      sb.append('~');
    }
    sb.append(c);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonPointer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */