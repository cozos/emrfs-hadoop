package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParserSequence
  extends JsonParserDelegate
{
  protected final JsonParser[] _parsers;
  protected int _nextParser;
  
  protected JsonParserSequence(JsonParser[] parsers)
  {
    super(parsers[0]);
    _parsers = parsers;
    _nextParser = 1;
  }
  
  public static JsonParserSequence createFlattened(JsonParser first, JsonParser second)
  {
    if ((!(first instanceof JsonParserSequence)) && (!(second instanceof JsonParserSequence))) {
      return new JsonParserSequence(new JsonParser[] { first, second });
    }
    ArrayList<JsonParser> p = new ArrayList();
    if ((first instanceof JsonParserSequence)) {
      ((JsonParserSequence)first).addFlattenedActiveParsers(p);
    } else {
      p.add(first);
    }
    if ((second instanceof JsonParserSequence)) {
      ((JsonParserSequence)second).addFlattenedActiveParsers(p);
    } else {
      p.add(second);
    }
    return new JsonParserSequence((JsonParser[])p.toArray(new JsonParser[p.size()]));
  }
  
  protected void addFlattenedActiveParsers(List<JsonParser> result)
  {
    int i = _nextParser - 1;
    for (int len = _parsers.length; i < len; i++)
    {
      JsonParser p = _parsers[i];
      if ((p instanceof JsonParserSequence)) {
        ((JsonParserSequence)p).addFlattenedActiveParsers(result);
      } else {
        result.add(p);
      }
    }
  }
  
  public void close()
    throws IOException
  {
    do
    {
      delegate.close();
    } while (switchToNext());
  }
  
  public JsonToken nextToken()
    throws IOException, JsonParseException
  {
    JsonToken t = delegate.nextToken();
    if (t != null) {
      return t;
    }
    while (switchToNext())
    {
      t = delegate.nextToken();
      if (t != null) {
        return t;
      }
    }
    return null;
  }
  
  public int containedParsersCount()
  {
    return _parsers.length;
  }
  
  protected boolean switchToNext()
  {
    if (_nextParser >= _parsers.length) {
      return false;
    }
    delegate = _parsers[(_nextParser++)];
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.JsonParserSequence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */