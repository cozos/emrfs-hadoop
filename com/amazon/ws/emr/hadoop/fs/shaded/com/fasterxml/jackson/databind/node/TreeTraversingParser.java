package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.cfg.PackageVersion;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class TreeTraversingParser
  extends ParserMinimalBase
{
  protected ObjectCodec _objectCodec;
  protected NodeCursor _nodeCursor;
  protected JsonToken _nextToken;
  protected boolean _startContainer;
  protected boolean _closed;
  
  public TreeTraversingParser(JsonNode n)
  {
    this(n, null);
  }
  
  public TreeTraversingParser(JsonNode n, ObjectCodec codec)
  {
    super(0);
    _objectCodec = codec;
    if (n.isArray())
    {
      _nextToken = JsonToken.START_ARRAY;
      _nodeCursor = new NodeCursor.ArrayCursor(n, null);
    }
    else if (n.isObject())
    {
      _nextToken = JsonToken.START_OBJECT;
      _nodeCursor = new NodeCursor.ObjectCursor(n, null);
    }
    else
    {
      _nodeCursor = new NodeCursor.RootCursor(n, null);
    }
  }
  
  public void setCodec(ObjectCodec c)
  {
    _objectCodec = c;
  }
  
  public ObjectCodec getCodec()
  {
    return _objectCodec;
  }
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
  
  public void close()
    throws IOException
  {
    if (!_closed)
    {
      _closed = true;
      _nodeCursor = null;
      _currToken = null;
    }
  }
  
  public JsonToken nextToken()
    throws IOException, JsonParseException
  {
    if (_nextToken != null)
    {
      _currToken = _nextToken;
      _nextToken = null;
      return _currToken;
    }
    if (_startContainer)
    {
      _startContainer = false;
      if (!_nodeCursor.currentHasChildren())
      {
        _currToken = (_currToken == JsonToken.START_OBJECT ? JsonToken.END_OBJECT : JsonToken.END_ARRAY);
        
        return _currToken;
      }
      _nodeCursor = _nodeCursor.iterateChildren();
      _currToken = _nodeCursor.nextToken();
      if ((_currToken == JsonToken.START_OBJECT) || (_currToken == JsonToken.START_ARRAY)) {
        _startContainer = true;
      }
      return _currToken;
    }
    if (_nodeCursor == null)
    {
      _closed = true;
      return null;
    }
    _currToken = _nodeCursor.nextToken();
    if (_currToken != null)
    {
      if ((_currToken == JsonToken.START_OBJECT) || (_currToken == JsonToken.START_ARRAY)) {
        _startContainer = true;
      }
      return _currToken;
    }
    _currToken = _nodeCursor.endToken();
    _nodeCursor = _nodeCursor.getParent();
    return _currToken;
  }
  
  public JsonParser skipChildren()
    throws IOException, JsonParseException
  {
    if (_currToken == JsonToken.START_OBJECT)
    {
      _startContainer = false;
      _currToken = JsonToken.END_OBJECT;
    }
    else if (_currToken == JsonToken.START_ARRAY)
    {
      _startContainer = false;
      _currToken = JsonToken.END_ARRAY;
    }
    return this;
  }
  
  public boolean isClosed()
  {
    return _closed;
  }
  
  public String getCurrentName()
  {
    return _nodeCursor == null ? null : _nodeCursor.getCurrentName();
  }
  
  public void overrideCurrentName(String name)
  {
    if (_nodeCursor != null) {
      _nodeCursor.overrideCurrentName(name);
    }
  }
  
  public JsonStreamContext getParsingContext()
  {
    return _nodeCursor;
  }
  
  public JsonLocation getTokenLocation()
  {
    return JsonLocation.NA;
  }
  
  public JsonLocation getCurrentLocation()
  {
    return JsonLocation.NA;
  }
  
  public String getText()
  {
    if (_closed) {
      return null;
    }
    switch (_currToken)
    {
    case FIELD_NAME: 
      return _nodeCursor.getCurrentName();
    case VALUE_STRING: 
      return currentNode().textValue();
    case VALUE_NUMBER_INT: 
    case VALUE_NUMBER_FLOAT: 
      return String.valueOf(currentNode().numberValue());
    case VALUE_EMBEDDED_OBJECT: 
      JsonNode n = currentNode();
      if ((n != null) && (n.isBinary())) {
        return n.asText();
      }
      break;
    }
    return _currToken == null ? null : _currToken.asString();
  }
  
  public char[] getTextCharacters()
    throws IOException, JsonParseException
  {
    return getText().toCharArray();
  }
  
  public int getTextLength()
    throws IOException, JsonParseException
  {
    return getText().length();
  }
  
  public int getTextOffset()
    throws IOException, JsonParseException
  {
    return 0;
  }
  
  public boolean hasTextCharacters()
  {
    return false;
  }
  
  public JsonParser.NumberType getNumberType()
    throws IOException, JsonParseException
  {
    JsonNode n = currentNumericNode();
    return n == null ? null : n.numberType();
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException, JsonParseException
  {
    return currentNumericNode().bigIntegerValue();
  }
  
  public BigDecimal getDecimalValue()
    throws IOException, JsonParseException
  {
    return currentNumericNode().decimalValue();
  }
  
  public double getDoubleValue()
    throws IOException, JsonParseException
  {
    return currentNumericNode().doubleValue();
  }
  
  public float getFloatValue()
    throws IOException, JsonParseException
  {
    return (float)currentNumericNode().doubleValue();
  }
  
  public long getLongValue()
    throws IOException, JsonParseException
  {
    return currentNumericNode().longValue();
  }
  
  public int getIntValue()
    throws IOException, JsonParseException
  {
    return currentNumericNode().intValue();
  }
  
  public Number getNumberValue()
    throws IOException, JsonParseException
  {
    return currentNumericNode().numberValue();
  }
  
  public Object getEmbeddedObject()
  {
    if (!_closed)
    {
      JsonNode n = currentNode();
      if (n != null)
      {
        if (n.isPojo()) {
          return ((POJONode)n).getPojo();
        }
        if (n.isBinary()) {
          return ((BinaryNode)n).binaryValue();
        }
      }
    }
    return null;
  }
  
  public byte[] getBinaryValue(Base64Variant b64variant)
    throws IOException, JsonParseException
  {
    JsonNode n = currentNode();
    if (n != null)
    {
      byte[] data = n.binaryValue();
      if (data != null) {
        return data;
      }
      if (n.isPojo())
      {
        Object ob = ((POJONode)n).getPojo();
        if ((ob instanceof byte[])) {
          return (byte[])ob;
        }
      }
    }
    return null;
  }
  
  public int readBinaryValue(Base64Variant b64variant, OutputStream out)
    throws IOException, JsonParseException
  {
    byte[] data = getBinaryValue(b64variant);
    if (data != null)
    {
      out.write(data, 0, data.length);
      return data.length;
    }
    return 0;
  }
  
  protected JsonNode currentNode()
  {
    if ((_closed) || (_nodeCursor == null)) {
      return null;
    }
    return _nodeCursor.currentNode();
  }
  
  protected JsonNode currentNumericNode()
    throws JsonParseException
  {
    JsonNode n = currentNode();
    if ((n == null) || (!n.isNumber()))
    {
      JsonToken t = n == null ? null : n.asToken();
      throw _constructError("Current token (" + t + ") not numeric, can not use numeric value accessors");
    }
    return n;
  }
  
  protected void _handleEOF()
    throws JsonParseException
  {
    _throwInternal();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.TreeTraversingParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */