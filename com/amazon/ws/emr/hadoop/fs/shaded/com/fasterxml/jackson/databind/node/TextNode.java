package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variants;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.CharTypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.NumberInput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class TextNode
  extends ValueNode
{
  static final TextNode EMPTY_STRING_NODE = new TextNode("");
  protected final String _value;
  
  public TextNode(String v)
  {
    _value = v;
  }
  
  public static TextNode valueOf(String v)
  {
    if (v == null) {
      return null;
    }
    if (v.length() == 0) {
      return EMPTY_STRING_NODE;
    }
    return new TextNode(v);
  }
  
  public JsonNodeType getNodeType()
  {
    return JsonNodeType.STRING;
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_STRING;
  }
  
  public String textValue()
  {
    return _value;
  }
  
  public byte[] getBinaryValue(Base64Variant b64variant)
    throws IOException
  {
    ByteArrayBuilder builder = new ByteArrayBuilder(100);
    String str = _value;
    int ptr = 0;
    int len = str.length();
    while (ptr < len)
    {
      do
      {
        ch = str.charAt(ptr++);
        if (ptr >= len) {
          break;
        }
      } while (ch <= ' ');
      int bits = b64variant.decodeBase64Char(ch);
      if (bits < 0) {
        _reportInvalidBase64(b64variant, ch, 0);
      }
      int decodedData = bits;
      if (ptr >= len) {
        _reportBase64EOF();
      }
      char ch = str.charAt(ptr++);
      bits = b64variant.decodeBase64Char(ch);
      if (bits < 0) {
        _reportInvalidBase64(b64variant, ch, 1);
      }
      decodedData = decodedData << 6 | bits;
      if (ptr >= len)
      {
        if (!b64variant.usesPadding())
        {
          decodedData >>= 4;
          builder.append(decodedData);
          break;
        }
        _reportBase64EOF();
      }
      ch = str.charAt(ptr++);
      bits = b64variant.decodeBase64Char(ch);
      if (bits < 0)
      {
        if (bits != -2) {
          _reportInvalidBase64(b64variant, ch, 2);
        }
        if (ptr >= len) {
          _reportBase64EOF();
        }
        ch = str.charAt(ptr++);
        if (!b64variant.usesPaddingChar(ch)) {
          _reportInvalidBase64(b64variant, ch, 3, "expected padding character '" + b64variant.getPaddingChar() + "'");
        }
        decodedData >>= 4;
        builder.append(decodedData);
      }
      else
      {
        decodedData = decodedData << 6 | bits;
        if (ptr >= len)
        {
          if (!b64variant.usesPadding())
          {
            decodedData >>= 2;
            builder.appendTwoBytes(decodedData);
            break;
          }
          _reportBase64EOF();
        }
        ch = str.charAt(ptr++);
        bits = b64variant.decodeBase64Char(ch);
        if (bits < 0)
        {
          if (bits != -2) {
            _reportInvalidBase64(b64variant, ch, 3);
          }
          decodedData >>= 2;
          builder.appendTwoBytes(decodedData);
        }
        else
        {
          decodedData = decodedData << 6 | bits;
          builder.appendThreeBytes(decodedData);
        }
      }
    }
    return builder.toByteArray();
  }
  
  public byte[] binaryValue()
    throws IOException
  {
    return getBinaryValue(Base64Variants.getDefaultVariant());
  }
  
  public String asText()
  {
    return _value;
  }
  
  public String asText(String defaultValue)
  {
    return _value == null ? defaultValue : _value;
  }
  
  public boolean asBoolean(boolean defaultValue)
  {
    if (_value != null)
    {
      String v = _value.trim();
      if ("true".equals(v)) {
        return true;
      }
      if ("false".equals(v)) {
        return false;
      }
    }
    return defaultValue;
  }
  
  public int asInt(int defaultValue)
  {
    return NumberInput.parseAsInt(_value, defaultValue);
  }
  
  public long asLong(long defaultValue)
  {
    return NumberInput.parseAsLong(_value, defaultValue);
  }
  
  public double asDouble(double defaultValue)
  {
    return NumberInput.parseAsDouble(_value, defaultValue);
  }
  
  public final void serialize(JsonGenerator jg, SerializerProvider provider)
    throws IOException
  {
    if (_value == null) {
      jg.writeNull();
    } else {
      jg.writeString(_value);
    }
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if ((o instanceof TextNode)) {
      return _value.equals(_value);
    }
    return false;
  }
  
  public int hashCode()
  {
    return _value.hashCode();
  }
  
  public String toString()
  {
    int len = _value.length();
    len = len + 2 + (len >> 4);
    StringBuilder sb = new StringBuilder(len);
    appendQuoted(sb, _value);
    return sb.toString();
  }
  
  protected static void appendQuoted(StringBuilder sb, String content)
  {
    sb.append('"');
    CharTypes.appendQuoted(sb, content);
    sb.append('"');
  }
  
  protected void _reportInvalidBase64(Base64Variant b64variant, char ch, int bindex)
    throws JsonParseException
  {
    _reportInvalidBase64(b64variant, ch, bindex, null);
  }
  
  protected void _reportInvalidBase64(Base64Variant b64variant, char ch, int bindex, String msg)
    throws JsonParseException
  {
    String base;
    String base;
    if (ch <= ' ')
    {
      base = "Illegal white space character (code 0x" + Integer.toHexString(ch) + ") as character #" + (bindex + 1) + " of 4-char base64 unit: can only used between units";
    }
    else
    {
      String base;
      if (b64variant.usesPaddingChar(ch))
      {
        base = "Unexpected padding character ('" + b64variant.getPaddingChar() + "') as character #" + (bindex + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
      }
      else
      {
        String base;
        if ((!Character.isDefined(ch)) || (Character.isISOControl(ch))) {
          base = "Illegal character (code 0x" + Integer.toHexString(ch) + ") in base64 content";
        } else {
          base = "Illegal character '" + ch + "' (code 0x" + Integer.toHexString(ch) + ") in base64 content";
        }
      }
    }
    if (msg != null) {
      base = base + ": " + msg;
    }
    throw new JsonParseException(base, JsonLocation.NA);
  }
  
  protected void _reportBase64EOF()
    throws JsonParseException
  {
    throw new JsonParseException("Unexpected end-of-String when base64 content", JsonLocation.NA);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.node.TextNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */