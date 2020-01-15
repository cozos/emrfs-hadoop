package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.Serializable;
import java.util.Arrays;

public final class Base64Variant
  implements Serializable
{
  private static final int INT_SPACE = 32;
  private static final long serialVersionUID = 1L;
  static final char PADDING_CHAR_NONE = '\000';
  public static final int BASE64_VALUE_INVALID = -1;
  public static final int BASE64_VALUE_PADDING = -2;
  private final transient int[] _asciiToBase64 = new int[''];
  private final transient char[] _base64ToAsciiC = new char[64];
  private final transient byte[] _base64ToAsciiB = new byte[64];
  protected final String _name;
  protected final transient boolean _usesPadding;
  protected final transient char _paddingChar;
  protected final transient int _maxLineLength;
  
  public Base64Variant(String name, String base64Alphabet, boolean usesPadding, char paddingChar, int maxLineLength)
  {
    _name = name;
    _usesPadding = usesPadding;
    _paddingChar = paddingChar;
    _maxLineLength = maxLineLength;
    
    int alphaLen = base64Alphabet.length();
    if (alphaLen != 64) {
      throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + alphaLen + ")");
    }
    base64Alphabet.getChars(0, alphaLen, _base64ToAsciiC, 0);
    Arrays.fill(_asciiToBase64, -1);
    for (int i = 0; i < alphaLen; i++)
    {
      char alpha = _base64ToAsciiC[i];
      _base64ToAsciiB[i] = ((byte)alpha);
      _asciiToBase64[alpha] = i;
    }
    if (usesPadding) {
      _asciiToBase64[paddingChar] = -2;
    }
  }
  
  public Base64Variant(Base64Variant base, String name, int maxLineLength)
  {
    this(base, name, _usesPadding, _paddingChar, maxLineLength);
  }
  
  public Base64Variant(Base64Variant base, String name, boolean usesPadding, char paddingChar, int maxLineLength)
  {
    _name = name;
    byte[] srcB = _base64ToAsciiB;
    System.arraycopy(srcB, 0, _base64ToAsciiB, 0, srcB.length);
    char[] srcC = _base64ToAsciiC;
    System.arraycopy(srcC, 0, _base64ToAsciiC, 0, srcC.length);
    int[] srcV = _asciiToBase64;
    System.arraycopy(srcV, 0, _asciiToBase64, 0, srcV.length);
    
    _usesPadding = usesPadding;
    _paddingChar = paddingChar;
    _maxLineLength = maxLineLength;
  }
  
  protected Object readResolve()
  {
    return Base64Variants.valueOf(_name);
  }
  
  public String getName()
  {
    return _name;
  }
  
  public boolean usesPadding()
  {
    return _usesPadding;
  }
  
  public boolean usesPaddingChar(char c)
  {
    return c == _paddingChar;
  }
  
  public boolean usesPaddingChar(int ch)
  {
    return ch == _paddingChar;
  }
  
  public char getPaddingChar()
  {
    return _paddingChar;
  }
  
  public byte getPaddingByte()
  {
    return (byte)_paddingChar;
  }
  
  public int getMaxLineLength()
  {
    return _maxLineLength;
  }
  
  public int decodeBase64Char(char c)
  {
    int ch = c;
    return ch <= 127 ? _asciiToBase64[ch] : -1;
  }
  
  public int decodeBase64Char(int ch)
  {
    return ch <= 127 ? _asciiToBase64[ch] : -1;
  }
  
  public int decodeBase64Byte(byte b)
  {
    int ch = b;
    return ch <= 127 ? _asciiToBase64[ch] : -1;
  }
  
  public char encodeBase64BitsAsChar(int value)
  {
    return _base64ToAsciiC[value];
  }
  
  public int encodeBase64Chunk(int b24, char[] buffer, int ptr)
  {
    buffer[(ptr++)] = _base64ToAsciiC[(b24 >> 18 & 0x3F)];
    buffer[(ptr++)] = _base64ToAsciiC[(b24 >> 12 & 0x3F)];
    buffer[(ptr++)] = _base64ToAsciiC[(b24 >> 6 & 0x3F)];
    buffer[(ptr++)] = _base64ToAsciiC[(b24 & 0x3F)];
    return ptr;
  }
  
  public void encodeBase64Chunk(StringBuilder sb, int b24)
  {
    sb.append(_base64ToAsciiC[(b24 >> 18 & 0x3F)]);
    sb.append(_base64ToAsciiC[(b24 >> 12 & 0x3F)]);
    sb.append(_base64ToAsciiC[(b24 >> 6 & 0x3F)]);
    sb.append(_base64ToAsciiC[(b24 & 0x3F)]);
  }
  
  public int encodeBase64Partial(int bits, int outputBytes, char[] buffer, int outPtr)
  {
    buffer[(outPtr++)] = _base64ToAsciiC[(bits >> 18 & 0x3F)];
    buffer[(outPtr++)] = _base64ToAsciiC[(bits >> 12 & 0x3F)];
    if (_usesPadding)
    {
      buffer[(outPtr++)] = (outputBytes == 2 ? _base64ToAsciiC[(bits >> 6 & 0x3F)] : _paddingChar);
      
      buffer[(outPtr++)] = _paddingChar;
    }
    else if (outputBytes == 2)
    {
      buffer[(outPtr++)] = _base64ToAsciiC[(bits >> 6 & 0x3F)];
    }
    return outPtr;
  }
  
  public void encodeBase64Partial(StringBuilder sb, int bits, int outputBytes)
  {
    sb.append(_base64ToAsciiC[(bits >> 18 & 0x3F)]);
    sb.append(_base64ToAsciiC[(bits >> 12 & 0x3F)]);
    if (_usesPadding)
    {
      sb.append(outputBytes == 2 ? _base64ToAsciiC[(bits >> 6 & 0x3F)] : _paddingChar);
      
      sb.append(_paddingChar);
    }
    else if (outputBytes == 2)
    {
      sb.append(_base64ToAsciiC[(bits >> 6 & 0x3F)]);
    }
  }
  
  public byte encodeBase64BitsAsByte(int value)
  {
    return _base64ToAsciiB[value];
  }
  
  public int encodeBase64Chunk(int b24, byte[] buffer, int ptr)
  {
    buffer[(ptr++)] = _base64ToAsciiB[(b24 >> 18 & 0x3F)];
    buffer[(ptr++)] = _base64ToAsciiB[(b24 >> 12 & 0x3F)];
    buffer[(ptr++)] = _base64ToAsciiB[(b24 >> 6 & 0x3F)];
    buffer[(ptr++)] = _base64ToAsciiB[(b24 & 0x3F)];
    return ptr;
  }
  
  public int encodeBase64Partial(int bits, int outputBytes, byte[] buffer, int outPtr)
  {
    buffer[(outPtr++)] = _base64ToAsciiB[(bits >> 18 & 0x3F)];
    buffer[(outPtr++)] = _base64ToAsciiB[(bits >> 12 & 0x3F)];
    if (_usesPadding)
    {
      byte pb = (byte)_paddingChar;
      buffer[(outPtr++)] = (outputBytes == 2 ? _base64ToAsciiB[(bits >> 6 & 0x3F)] : pb);
      
      buffer[(outPtr++)] = pb;
    }
    else if (outputBytes == 2)
    {
      buffer[(outPtr++)] = _base64ToAsciiB[(bits >> 6 & 0x3F)];
    }
    return outPtr;
  }
  
  public String encode(byte[] input)
  {
    return encode(input, false);
  }
  
  public String encode(byte[] input, boolean addQuotes)
  {
    int inputEnd = input.length;
    
    int outputLen = inputEnd + (inputEnd >> 2) + (inputEnd >> 3);
    StringBuilder sb = new StringBuilder(outputLen);
    if (addQuotes) {
      sb.append('"');
    }
    int chunksBeforeLF = getMaxLineLength() >> 2;
    
    int inputPtr = 0;
    int safeInputEnd = inputEnd - 3;
    while (inputPtr <= safeInputEnd)
    {
      int b24 = input[(inputPtr++)] << 8;
      b24 |= input[(inputPtr++)] & 0xFF;
      b24 = b24 << 8 | input[(inputPtr++)] & 0xFF;
      encodeBase64Chunk(sb, b24);
      chunksBeforeLF--;
      if (chunksBeforeLF <= 0)
      {
        sb.append('\\');
        sb.append('n');
        chunksBeforeLF = getMaxLineLength() >> 2;
      }
    }
    int inputLeft = inputEnd - inputPtr;
    if (inputLeft > 0)
    {
      int b24 = input[(inputPtr++)] << 16;
      if (inputLeft == 2) {
        b24 |= (input[(inputPtr++)] & 0xFF) << 8;
      }
      encodeBase64Partial(sb, b24, inputLeft);
    }
    if (addQuotes) {
      sb.append('"');
    }
    return sb.toString();
  }
  
  public byte[] decode(String input)
    throws IllegalArgumentException
  {
    ByteArrayBuilder b = new ByteArrayBuilder();
    decode(input, b);
    return b.toByteArray();
  }
  
  public void decode(String str, ByteArrayBuilder builder)
    throws IllegalArgumentException
  {
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
      int bits = decodeBase64Char(ch);
      if (bits < 0) {
        _reportInvalidBase64(ch, 0, null);
      }
      int decodedData = bits;
      if (ptr >= len) {
        _reportBase64EOF();
      }
      char ch = str.charAt(ptr++);
      bits = decodeBase64Char(ch);
      if (bits < 0) {
        _reportInvalidBase64(ch, 1, null);
      }
      decodedData = decodedData << 6 | bits;
      if (ptr >= len)
      {
        if (!usesPadding())
        {
          decodedData >>= 4;
          builder.append(decodedData);
          break;
        }
        _reportBase64EOF();
      }
      ch = str.charAt(ptr++);
      bits = decodeBase64Char(ch);
      if (bits < 0)
      {
        if (bits != -2) {
          _reportInvalidBase64(ch, 2, null);
        }
        if (ptr >= len) {
          _reportBase64EOF();
        }
        ch = str.charAt(ptr++);
        if (!usesPaddingChar(ch)) {
          _reportInvalidBase64(ch, 3, "expected padding character '" + getPaddingChar() + "'");
        }
        decodedData >>= 4;
        builder.append(decodedData);
      }
      else
      {
        decodedData = decodedData << 6 | bits;
        if (ptr >= len)
        {
          if (!usesPadding())
          {
            decodedData >>= 2;
            builder.appendTwoBytes(decodedData);
            break;
          }
          _reportBase64EOF();
        }
        ch = str.charAt(ptr++);
        bits = decodeBase64Char(ch);
        if (bits < 0)
        {
          if (bits != -2) {
            _reportInvalidBase64(ch, 3, null);
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
  }
  
  public String toString()
  {
    return _name;
  }
  
  public boolean equals(Object o)
  {
    return o == this;
  }
  
  public int hashCode()
  {
    return _name.hashCode();
  }
  
  protected void _reportInvalidBase64(char ch, int bindex, String msg)
    throws IllegalArgumentException
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
      if (usesPaddingChar(ch))
      {
        base = "Unexpected padding character ('" + getPaddingChar() + "') as character #" + (bindex + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
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
    throw new IllegalArgumentException(base);
  }
  
  protected void _reportBase64EOF()
    throws IllegalArgumentException
  {
    throw new IllegalArgumentException("Unexpected end-of-String in base64 content");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */