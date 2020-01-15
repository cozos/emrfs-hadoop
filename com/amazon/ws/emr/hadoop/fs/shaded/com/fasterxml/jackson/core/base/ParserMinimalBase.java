package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.NumberInput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;

public abstract class ParserMinimalBase
  extends JsonParser
{
  protected static final int INT_TAB = 9;
  protected static final int INT_LF = 10;
  protected static final int INT_CR = 13;
  protected static final int INT_SPACE = 32;
  protected static final int INT_LBRACKET = 91;
  protected static final int INT_RBRACKET = 93;
  protected static final int INT_LCURLY = 123;
  protected static final int INT_RCURLY = 125;
  protected static final int INT_QUOTE = 34;
  protected static final int INT_BACKSLASH = 92;
  protected static final int INT_SLASH = 47;
  protected static final int INT_COLON = 58;
  protected static final int INT_COMMA = 44;
  protected static final int INT_HASH = 35;
  protected static final int INT_PERIOD = 46;
  protected static final int INT_e = 101;
  protected static final int INT_E = 69;
  protected JsonToken _currToken;
  protected JsonToken _lastClearedToken;
  
  protected ParserMinimalBase() {}
  
  protected ParserMinimalBase(int features)
  {
    super(features);
  }
  
  public abstract JsonToken nextToken()
    throws IOException;
  
  public JsonToken getCurrentToken()
  {
    return _currToken;
  }
  
  public int getCurrentTokenId()
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
  
  public boolean hasToken(JsonToken t)
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
      if (t == null)
      {
        _handleEOF();
        
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
  
  protected abstract void _handleEOF()
    throws JsonParseException;
  
  public abstract String getCurrentName()
    throws IOException;
  
  public abstract void close()
    throws IOException;
  
  public abstract boolean isClosed();
  
  public abstract JsonStreamContext getParsingContext();
  
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
  
  public abstract void overrideCurrentName(String paramString);
  
  public abstract String getText()
    throws IOException;
  
  public abstract char[] getTextCharacters()
    throws IOException;
  
  public abstract boolean hasTextCharacters();
  
  public abstract int getTextLength()
    throws IOException;
  
  public abstract int getTextOffset()
    throws IOException;
  
  public abstract byte[] getBinaryValue(Base64Variant paramBase64Variant)
    throws IOException;
  
  public boolean getValueAsBoolean(boolean defaultValue)
    throws IOException
  {
    JsonToken t = _currToken;
    if (t != null) {
      switch (t.id())
      {
      case 6: 
        String str = getText().trim();
        if ("true".equals(str)) {
          return true;
        }
        if ("false".equals(str)) {
          return false;
        }
        if (_hasTextualNull(str)) {
          return false;
        }
        break;
      case 7: 
        return getIntValue() != 0;
      case 9: 
        return true;
      case 10: 
      case 11: 
        return false;
      case 12: 
        Object value = getEmbeddedObject();
        if ((value instanceof Boolean)) {
          return ((Boolean)value).booleanValue();
        }
        break;
      }
    }
    return defaultValue;
  }
  
  public int getValueAsInt()
    throws IOException
  {
    JsonToken t = _currToken;
    if (t == JsonToken.VALUE_NUMBER_INT) {
      return getIntValue();
    }
    if (t == JsonToken.VALUE_NUMBER_FLOAT) {
      return getIntValue();
    }
    return getValueAsInt(0);
  }
  
  public int getValueAsInt(int defaultValue)
    throws IOException
  {
    JsonToken t = _currToken;
    if (t == JsonToken.VALUE_NUMBER_INT) {
      return getIntValue();
    }
    if (t == JsonToken.VALUE_NUMBER_FLOAT) {
      return getIntValue();
    }
    if (t != null) {
      switch (t.id())
      {
      case 6: 
        String str = getText();
        if (_hasTextualNull(str)) {
          return 0;
        }
        return NumberInput.parseAsInt(str, defaultValue);
      case 9: 
        return 1;
      case 10: 
        return 0;
      case 11: 
        return 0;
      case 12: 
        Object value = getEmbeddedObject();
        if ((value instanceof Number)) {
          return ((Number)value).intValue();
        }
        break;
      }
    }
    return defaultValue;
  }
  
  public long getValueAsLong()
    throws IOException
  {
    JsonToken t = _currToken;
    if (t == JsonToken.VALUE_NUMBER_INT) {
      return getLongValue();
    }
    if (t == JsonToken.VALUE_NUMBER_FLOAT) {
      return getLongValue();
    }
    return getValueAsLong(0L);
  }
  
  public long getValueAsLong(long defaultValue)
    throws IOException
  {
    JsonToken t = _currToken;
    if (t == JsonToken.VALUE_NUMBER_INT) {
      return getLongValue();
    }
    if (t == JsonToken.VALUE_NUMBER_FLOAT) {
      return getLongValue();
    }
    if (t != null) {
      switch (t.id())
      {
      case 6: 
        String str = getText();
        if (_hasTextualNull(str)) {
          return 0L;
        }
        return NumberInput.parseAsLong(str, defaultValue);
      case 9: 
        return 1L;
      case 10: 
      case 11: 
        return 0L;
      case 12: 
        Object value = getEmbeddedObject();
        if ((value instanceof Number)) {
          return ((Number)value).longValue();
        }
        break;
      }
    }
    return defaultValue;
  }
  
  public double getValueAsDouble(double defaultValue)
    throws IOException
  {
    JsonToken t = _currToken;
    if (t != null) {
      switch (t.id())
      {
      case 6: 
        String str = getText();
        if (_hasTextualNull(str)) {
          return 0.0D;
        }
        return NumberInput.parseAsDouble(str, defaultValue);
      case 7: 
      case 8: 
        return getDoubleValue();
      case 9: 
        return 1.0D;
      case 10: 
      case 11: 
        return 0.0D;
      case 12: 
        Object value = getEmbeddedObject();
        if ((value instanceof Number)) {
          return ((Number)value).doubleValue();
        }
        break;
      }
    }
    return defaultValue;
  }
  
  public String getValueAsString()
    throws IOException
  {
    if (_currToken == JsonToken.VALUE_STRING) {
      return getText();
    }
    if (_currToken == JsonToken.FIELD_NAME) {
      return getCurrentName();
    }
    return getValueAsString(null);
  }
  
  public String getValueAsString(String defaultValue)
    throws IOException
  {
    if (_currToken == JsonToken.VALUE_STRING) {
      return getText();
    }
    if (_currToken == JsonToken.FIELD_NAME) {
      return getCurrentName();
    }
    if ((_currToken == null) || (_currToken == JsonToken.VALUE_NULL) || (!_currToken.isScalarValue())) {
      return defaultValue;
    }
    return getText();
  }
  
  protected void _decodeBase64(String str, ByteArrayBuilder builder, Base64Variant b64variant)
    throws IOException
  {
    try
    {
      b64variant.decode(str, builder);
    }
    catch (IllegalArgumentException e)
    {
      _reportError(e.getMessage());
    }
  }
  
  protected boolean _hasTextualNull(String value)
  {
    return "null".equals(value);
  }
  
  protected void _reportUnexpectedChar(int ch, String comment)
    throws JsonParseException
  {
    if (ch < 0) {
      _reportInvalidEOF();
    }
    String msg = "Unexpected character (" + _getCharDesc(ch) + ")";
    if (comment != null) {
      msg = msg + ": " + comment;
    }
    _reportError(msg);
  }
  
  protected void _reportInvalidEOF()
    throws JsonParseException
  {
    _reportInvalidEOF(" in " + _currToken);
  }
  
  protected void _reportInvalidEOF(String msg)
    throws JsonParseException
  {
    _reportError("Unexpected end-of-input" + msg);
  }
  
  protected void _reportInvalidEOFInValue()
    throws JsonParseException
  {
    _reportInvalidEOF(" in a value");
  }
  
  protected void _reportMissingRootWS(int ch)
    throws JsonParseException
  {
    _reportUnexpectedChar(ch, "Expected space separating root-level values");
  }
  
  protected void _throwInvalidSpace(int i)
    throws JsonParseException
  {
    char c = (char)i;
    String msg = "Illegal character (" + _getCharDesc(c) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens";
    _reportError(msg);
  }
  
  protected void _throwUnquotedSpace(int i, String ctxtDesc)
    throws JsonParseException
  {
    if ((!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS)) || (i > 32))
    {
      char c = (char)i;
      String msg = "Illegal unquoted character (" + _getCharDesc(c) + "): has to be escaped using backslash to be included in " + ctxtDesc;
      _reportError(msg);
    }
  }
  
  protected char _handleUnrecognizedCharacterEscape(char ch)
    throws JsonProcessingException
  {
    if (isEnabled(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {
      return ch;
    }
    if ((ch == '\'') && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
      return ch;
    }
    _reportError("Unrecognized character escape " + _getCharDesc(ch));
    return ch;
  }
  
  protected static final String _getCharDesc(int ch)
  {
    char c = (char)ch;
    if (Character.isISOControl(c)) {
      return "(CTRL-CHAR, code " + ch + ")";
    }
    if (ch > 255) {
      return "'" + c + "' (code " + ch + " / 0x" + Integer.toHexString(ch) + ")";
    }
    return "'" + c + "' (code " + ch + ")";
  }
  
  protected final void _reportError(String msg)
    throws JsonParseException
  {
    throw _constructError(msg);
  }
  
  protected final void _wrapError(String msg, Throwable t)
    throws JsonParseException
  {
    throw _constructError(msg, t);
  }
  
  protected final void _throwInternal() {}
  
  protected final JsonParseException _constructError(String msg, Throwable t)
  {
    return new JsonParseException(msg, getCurrentLocation(), t);
  }
  
  protected static byte[] _asciiBytes(String str)
  {
    byte[] b = new byte[str.length()];
    int i = 0;
    for (int len = str.length(); i < len; i++) {
      b[i] = ((byte)str.charAt(i));
    }
    return b;
  }
  
  protected static String _ascii(byte[] b)
  {
    try
    {
      return new String(b, "US-ASCII");
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.base.ParserMinimalBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */