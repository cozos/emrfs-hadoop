package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import java.util.HashSet;

public class DupDetector
{
  protected final Object _source;
  protected String _firstName;
  protected String _secondName;
  protected HashSet<String> _seen;
  
  private DupDetector(Object src)
  {
    _source = src;
  }
  
  public static DupDetector rootDetector(JsonParser p)
  {
    return new DupDetector(p);
  }
  
  public static DupDetector rootDetector(JsonGenerator g)
  {
    return new DupDetector(g);
  }
  
  public DupDetector child()
  {
    return new DupDetector(_source);
  }
  
  public void reset()
  {
    _firstName = null;
    _secondName = null;
    _seen = null;
  }
  
  public JsonLocation findLocation()
  {
    if ((_source instanceof JsonParser)) {
      return ((JsonParser)_source).getCurrentLocation();
    }
    return null;
  }
  
  public boolean isDup(String name)
    throws JsonParseException
  {
    if (_firstName == null)
    {
      _firstName = name;
      return false;
    }
    if (name.equals(_firstName)) {
      return true;
    }
    if (_secondName == null)
    {
      _secondName = name;
      return false;
    }
    if (name.equals(_secondName)) {
      return true;
    }
    if (_seen == null)
    {
      _seen = new HashSet(16);
      _seen.add(_firstName);
      _seen.add(_secondName);
    }
    return !_seen.add(name);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.DupDetector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */