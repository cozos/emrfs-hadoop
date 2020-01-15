package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.PrettyPrinter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.CharTypes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.CharacterEscapes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.IOContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.NumberOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class UTF8JsonGenerator
  extends JsonGeneratorImpl
{
  private static final byte BYTE_u = 117;
  private static final byte BYTE_0 = 48;
  private static final byte BYTE_LBRACKET = 91;
  private static final byte BYTE_RBRACKET = 93;
  private static final byte BYTE_LCURLY = 123;
  private static final byte BYTE_RCURLY = 125;
  private static final byte BYTE_BACKSLASH = 92;
  private static final byte BYTE_COMMA = 44;
  private static final byte BYTE_COLON = 58;
  private static final byte BYTE_QUOTE = 34;
  private static final int MAX_BYTES_TO_BUFFER = 512;
  static final byte[] HEX_CHARS = ;
  private static final byte[] NULL_BYTES = { 110, 117, 108, 108 };
  private static final byte[] TRUE_BYTES = { 116, 114, 117, 101 };
  private static final byte[] FALSE_BYTES = { 102, 97, 108, 115, 101 };
  protected final OutputStream _outputStream;
  protected byte[] _outputBuffer;
  protected int _outputTail = 0;
  protected final int _outputEnd;
  protected final int _outputMaxContiguous;
  protected char[] _charBuffer;
  protected final int _charBufferLength;
  protected byte[] _entityBuffer;
  protected boolean _bufferRecyclable;
  protected boolean _cfgUnqNames;
  
  public UTF8JsonGenerator(IOContext ctxt, int features, ObjectCodec codec, OutputStream out)
  {
    super(ctxt, features, codec);
    _outputStream = out;
    _bufferRecyclable = true;
    _outputBuffer = ctxt.allocWriteEncodingBuffer();
    _outputEnd = _outputBuffer.length;
    
    _outputMaxContiguous = (_outputEnd >> 3);
    _charBuffer = ctxt.allocConcatBuffer();
    _charBufferLength = _charBuffer.length;
    if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
      setHighestNonEscapedChar(127);
    }
    _cfgUnqNames = (!JsonGenerator.Feature.QUOTE_FIELD_NAMES.enabledIn(features));
  }
  
  public UTF8JsonGenerator(IOContext ctxt, int features, ObjectCodec codec, OutputStream out, byte[] outputBuffer, int outputOffset, boolean bufferRecyclable)
  {
    super(ctxt, features, codec);
    _outputStream = out;
    _bufferRecyclable = bufferRecyclable;
    _outputTail = outputOffset;
    _outputBuffer = outputBuffer;
    _outputEnd = _outputBuffer.length;
    
    _outputMaxContiguous = (_outputEnd >> 3);
    _charBuffer = ctxt.allocConcatBuffer();
    _charBufferLength = _charBuffer.length;
    _cfgUnqNames = (!JsonGenerator.Feature.QUOTE_FIELD_NAMES.enabledIn(features));
  }
  
  public Object getOutputTarget()
  {
    return _outputStream;
  }
  
  public int getOutputBuffered()
  {
    return _outputTail;
  }
  
  public void writeFieldName(String name)
    throws IOException
  {
    if (_cfgPrettyPrinter != null)
    {
      _writePPFieldName(name);
      return;
    }
    int status = _writeContext.writeFieldName(name);
    if (status == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    if (status == 1)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = 44;
    }
    if (_cfgUnqNames)
    {
      _writeStringSegments(name, false);
      return;
    }
    int len = name.length();
    if (len > _charBufferLength)
    {
      _writeStringSegments(name, true);
      return;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    if (len <= _outputMaxContiguous)
    {
      if (_outputTail + len > _outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(name, 0, len);
    }
    else
    {
      _writeStringSegments(name, 0, len);
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
  }
  
  public void writeFieldName(SerializableString name)
    throws IOException
  {
    if (_cfgPrettyPrinter != null)
    {
      _writePPFieldName(name);
      return;
    }
    int status = _writeContext.writeFieldName(name.getValue());
    if (status == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    if (status == 1)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = 44;
    }
    if (_cfgUnqNames)
    {
      _writeUnq(name);
      return;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    int len = name.appendQuotedUTF8(_outputBuffer, _outputTail);
    if (len < 0) {
      _writeBytes(name.asQuotedUTF8());
    } else {
      _outputTail += len;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
  }
  
  private final void _writeUnq(SerializableString name)
    throws IOException
  {
    int len = name.appendQuotedUTF8(_outputBuffer, _outputTail);
    if (len < 0) {
      _writeBytes(name.asQuotedUTF8());
    } else {
      _outputTail += len;
    }
  }
  
  public final void writeStartArray()
    throws IOException
  {
    _verifyValueWrite("start an array");
    _writeContext = _writeContext.createChildArrayContext();
    if (_cfgPrettyPrinter != null)
    {
      _cfgPrettyPrinter.writeStartArray(this);
    }
    else
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = 91;
    }
  }
  
  public final void writeEndArray()
    throws IOException
  {
    if (!_writeContext.inArray()) {
      _reportError("Current context not an ARRAY but " + _writeContext.getTypeDesc());
    }
    if (_cfgPrettyPrinter != null)
    {
      _cfgPrettyPrinter.writeEndArray(this, _writeContext.getEntryCount());
    }
    else
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = 93;
    }
    _writeContext = _writeContext.getParent();
  }
  
  public final void writeStartObject()
    throws IOException
  {
    _verifyValueWrite("start an object");
    _writeContext = _writeContext.createChildObjectContext();
    if (_cfgPrettyPrinter != null)
    {
      _cfgPrettyPrinter.writeStartObject(this);
    }
    else
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = 123;
    }
  }
  
  public final void writeEndObject()
    throws IOException
  {
    if (!_writeContext.inObject()) {
      _reportError("Current context not an object but " + _writeContext.getTypeDesc());
    }
    if (_cfgPrettyPrinter != null)
    {
      _cfgPrettyPrinter.writeEndObject(this, _writeContext.getEntryCount());
    }
    else
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = 125;
    }
    _writeContext = _writeContext.getParent();
  }
  
  protected final void _writePPFieldName(String name)
    throws IOException
  {
    int status = _writeContext.writeFieldName(name);
    if (status == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    if (status == 1) {
      _cfgPrettyPrinter.writeObjectEntrySeparator(this);
    } else {
      _cfgPrettyPrinter.beforeObjectEntries(this);
    }
    if (_cfgUnqNames)
    {
      _writeStringSegments(name, false);
      return;
    }
    int len = name.length();
    if (len > _charBufferLength)
    {
      _writeStringSegments(name, true);
      return;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    name.getChars(0, len, _charBuffer, 0);
    if (len <= _outputMaxContiguous)
    {
      if (_outputTail + len > _outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(_charBuffer, 0, len);
    }
    else
    {
      _writeStringSegments(_charBuffer, 0, len);
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
  }
  
  protected final void _writePPFieldName(SerializableString name)
    throws IOException
  {
    int status = _writeContext.writeFieldName(name.getValue());
    if (status == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    if (status == 1) {
      _cfgPrettyPrinter.writeObjectEntrySeparator(this);
    } else {
      _cfgPrettyPrinter.beforeObjectEntries(this);
    }
    boolean addQuotes = !_cfgUnqNames;
    if (addQuotes)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = 34;
    }
    _writeBytes(name.asQuotedUTF8());
    if (addQuotes)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = 34;
    }
  }
  
  public void writeString(String text)
    throws IOException
  {
    _verifyValueWrite("write a string");
    if (text == null)
    {
      _writeNull();
      return;
    }
    int len = text.length();
    if (len > _outputMaxContiguous)
    {
      _writeStringSegments(text, true);
      return;
    }
    if (_outputTail + len >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    _writeStringSegment(text, 0, len);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
  }
  
  public void writeString(char[] text, int offset, int len)
    throws IOException
  {
    _verifyValueWrite("write a string");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    if (len <= _outputMaxContiguous)
    {
      if (_outputTail + len > _outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(text, offset, len);
    }
    else
    {
      _writeStringSegments(text, offset, len);
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
  }
  
  public final void writeString(SerializableString text)
    throws IOException
  {
    _verifyValueWrite("write a string");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    int len = text.appendQuotedUTF8(_outputBuffer, _outputTail);
    if (len < 0) {
      _writeBytes(text.asQuotedUTF8());
    } else {
      _outputTail += len;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
  }
  
  public void writeRawUTF8String(byte[] text, int offset, int length)
    throws IOException
  {
    _verifyValueWrite("write a string");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    _writeBytes(text, offset, length);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
  }
  
  public void writeUTF8String(byte[] text, int offset, int len)
    throws IOException
  {
    _verifyValueWrite("write a string");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    if (len <= _outputMaxContiguous) {
      _writeUTF8Segment(text, offset, len);
    } else {
      _writeUTF8Segments(text, offset, len);
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
  }
  
  public void writeRaw(String text)
    throws IOException, JsonGenerationException
  {
    int start = 0;
    int len = text.length();
    while (len > 0)
    {
      char[] buf = _charBuffer;
      int blen = buf.length;
      int len2 = len < blen ? len : blen;
      text.getChars(start, start + len2, buf, 0);
      writeRaw(buf, 0, len2);
      start += len2;
      len -= len2;
    }
  }
  
  public void writeRaw(String text, int offset, int len)
    throws IOException, JsonGenerationException
  {
    while (len > 0)
    {
      char[] buf = _charBuffer;
      int blen = buf.length;
      int len2 = len < blen ? len : blen;
      text.getChars(offset, offset + len2, buf, 0);
      writeRaw(buf, 0, len2);
      offset += len2;
      len -= len2;
    }
  }
  
  public void writeRaw(SerializableString text)
    throws IOException, JsonGenerationException
  {
    byte[] raw = text.asUnquotedUTF8();
    if (raw.length > 0) {
      _writeBytes(raw);
    }
  }
  
  public void writeRawValue(SerializableString text)
    throws IOException
  {
    _verifyValueWrite("write a raw (unencoded) value");
    byte[] raw = text.asUnquotedUTF8();
    if (raw.length > 0) {
      _writeBytes(raw);
    }
  }
  
  public final void writeRaw(char[] cbuf, int offset, int len)
    throws IOException, JsonGenerationException
  {
    int len3 = len + len + len;
    if (_outputTail + len3 > _outputEnd)
    {
      if (_outputEnd < len3)
      {
        _writeSegmentedRaw(cbuf, offset, len);
        return;
      }
      _flushBuffer();
    }
    len += offset;
    while (offset < len)
    {
      for (;;)
      {
        int ch = cbuf[offset];
        if (ch > 127) {
          break;
        }
        _outputBuffer[(_outputTail++)] = ((byte)ch);
        offset++;
        if (offset >= len) {
          return;
        }
      }
      char ch = cbuf[(offset++)];
      if (ch < 'ࠀ')
      {
        _outputBuffer[(_outputTail++)] = ((byte)(0xC0 | ch >> '\006'));
        _outputBuffer[(_outputTail++)] = ((byte)(0x80 | ch & 0x3F));
      }
      else
      {
        offset = _outputRawMultiByteChar(ch, cbuf, offset, len);
      }
    }
  }
  
  public void writeRaw(char ch)
    throws IOException, JsonGenerationException
  {
    if (_outputTail + 3 >= _outputEnd) {
      _flushBuffer();
    }
    byte[] bbuf = _outputBuffer;
    if (ch <= '')
    {
      bbuf[(_outputTail++)] = ((byte)ch);
    }
    else if (ch < 'ࠀ')
    {
      bbuf[(_outputTail++)] = ((byte)(0xC0 | ch >> '\006'));
      bbuf[(_outputTail++)] = ((byte)(0x80 | ch & 0x3F));
    }
    else
    {
      _outputRawMultiByteChar(ch, null, 0, 0);
    }
  }
  
  private final void _writeSegmentedRaw(char[] cbuf, int offset, int len)
    throws IOException, JsonGenerationException
  {
    int end = _outputEnd;
    byte[] bbuf = _outputBuffer;
    while (offset < len)
    {
      for (;;)
      {
        int ch = cbuf[offset];
        if (ch >= 128) {
          break;
        }
        if (_outputTail >= end) {
          _flushBuffer();
        }
        bbuf[(_outputTail++)] = ((byte)ch);
        offset++;
        if (offset >= len) {
          return;
        }
      }
      if (_outputTail + 3 >= _outputEnd) {
        _flushBuffer();
      }
      char ch = cbuf[(offset++)];
      if (ch < 'ࠀ')
      {
        bbuf[(_outputTail++)] = ((byte)(0xC0 | ch >> '\006'));
        bbuf[(_outputTail++)] = ((byte)(0x80 | ch & 0x3F));
      }
      else
      {
        offset = _outputRawMultiByteChar(ch, cbuf, offset, len);
      }
    }
  }
  
  public void writeBinary(Base64Variant b64variant, byte[] data, int offset, int len)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write a binary value");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    _writeBinary(b64variant, data, offset, offset + len);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
  }
  
  public int writeBinary(Base64Variant b64variant, InputStream data, int dataLength)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write a binary value");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    byte[] encodingBuffer = _ioContext.allocBase64Buffer();
    int bytes;
    try
    {
      int bytes;
      if (dataLength < 0)
      {
        bytes = _writeBinary(b64variant, data, encodingBuffer);
      }
      else
      {
        int missing = _writeBinary(b64variant, data, encodingBuffer, dataLength);
        if (missing > 0) {
          _reportError("Too few bytes available: missing " + missing + " bytes (out of " + dataLength + ")");
        }
        bytes = dataLength;
      }
    }
    finally
    {
      _ioContext.releaseBase64Buffer(encodingBuffer);
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    return bytes;
  }
  
  public void writeNumber(short s)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write a number");
    if (_outputTail + 6 >= _outputEnd) {
      _flushBuffer();
    }
    if (_cfgNumbersAsStrings)
    {
      _writeQuotedShort(s);
      return;
    }
    _outputTail = NumberOutput.outputInt(s, _outputBuffer, _outputTail);
  }
  
  private final void _writeQuotedShort(short s)
    throws IOException
  {
    if (_outputTail + 8 >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    _outputTail = NumberOutput.outputInt(s, _outputBuffer, _outputTail);
    _outputBuffer[(_outputTail++)] = 34;
  }
  
  public void writeNumber(int i)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write a number");
    if (_outputTail + 11 >= _outputEnd) {
      _flushBuffer();
    }
    if (_cfgNumbersAsStrings)
    {
      _writeQuotedInt(i);
      return;
    }
    _outputTail = NumberOutput.outputInt(i, _outputBuffer, _outputTail);
  }
  
  private final void _writeQuotedInt(int i)
    throws IOException
  {
    if (_outputTail + 13 >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    _outputTail = NumberOutput.outputInt(i, _outputBuffer, _outputTail);
    _outputBuffer[(_outputTail++)] = 34;
  }
  
  public void writeNumber(long l)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write a number");
    if (_cfgNumbersAsStrings)
    {
      _writeQuotedLong(l);
      return;
    }
    if (_outputTail + 21 >= _outputEnd) {
      _flushBuffer();
    }
    _outputTail = NumberOutput.outputLong(l, _outputBuffer, _outputTail);
  }
  
  private final void _writeQuotedLong(long l)
    throws IOException
  {
    if (_outputTail + 23 >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    _outputTail = NumberOutput.outputLong(l, _outputBuffer, _outputTail);
    _outputBuffer[(_outputTail++)] = 34;
  }
  
  public void writeNumber(BigInteger value)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write a number");
    if (value == null) {
      _writeNull();
    } else if (_cfgNumbersAsStrings) {
      _writeQuotedRaw(value.toString());
    } else {
      writeRaw(value.toString());
    }
  }
  
  public void writeNumber(double d)
    throws IOException, JsonGenerationException
  {
    if ((_cfgNumbersAsStrings) || (((Double.isNaN(d)) || (Double.isInfinite(d))) && (isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))))
    {
      writeString(String.valueOf(d));
      return;
    }
    _verifyValueWrite("write a number");
    writeRaw(String.valueOf(d));
  }
  
  public void writeNumber(float f)
    throws IOException, JsonGenerationException
  {
    if ((_cfgNumbersAsStrings) || (((Float.isNaN(f)) || (Float.isInfinite(f))) && (isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))))
    {
      writeString(String.valueOf(f));
      return;
    }
    _verifyValueWrite("write a number");
    writeRaw(String.valueOf(f));
  }
  
  public void writeNumber(BigDecimal value)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write a number");
    if (value == null)
    {
      _writeNull();
    }
    else if (_cfgNumbersAsStrings)
    {
      String raw = isEnabled(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) ? value.toPlainString() : value.toString();
      _writeQuotedRaw(raw);
    }
    else if (isEnabled(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN))
    {
      writeRaw(value.toPlainString());
    }
    else
    {
      writeRaw(value.toString());
    }
  }
  
  public void writeNumber(String encodedValue)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write a number");
    if (_cfgNumbersAsStrings) {
      _writeQuotedRaw(encodedValue);
    } else {
      writeRaw(encodedValue);
    }
  }
  
  private final void _writeQuotedRaw(String value)
    throws IOException
  {
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
    writeRaw(value);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = 34;
  }
  
  public void writeBoolean(boolean state)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write a boolean value");
    if (_outputTail + 5 >= _outputEnd) {
      _flushBuffer();
    }
    byte[] keyword = state ? TRUE_BYTES : FALSE_BYTES;
    int len = keyword.length;
    System.arraycopy(keyword, 0, _outputBuffer, _outputTail, len);
    _outputTail += len;
  }
  
  public void writeNull()
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write a null");
    _writeNull();
  }
  
  protected final void _verifyValueWrite(String typeMsg)
    throws IOException
  {
    int status = _writeContext.writeValue();
    if (status == 5) {
      _reportError("Can not " + typeMsg + ", expecting field name");
    }
    if (_cfgPrettyPrinter == null)
    {
      byte b;
      switch (status)
      {
      case 1: 
        b = 44;
        break;
      case 2: 
        b = 58;
        break;
      case 3: 
        if (_rootValueSeparator != null)
        {
          byte[] raw = _rootValueSeparator.asUnquotedUTF8();
          if (raw.length > 0) {
            _writeBytes(raw);
          }
        }
        return;
      case 0: 
      default: 
        return;
      }
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[_outputTail] = b;
      _outputTail += 1;
      return;
    }
    _verifyPrettyValueWrite(typeMsg, status);
  }
  
  protected final void _verifyPrettyValueWrite(String typeMsg, int status)
    throws IOException
  {
    switch (status)
    {
    case 1: 
      _cfgPrettyPrinter.writeArrayValueSeparator(this);
      break;
    case 2: 
      _cfgPrettyPrinter.writeObjectFieldValueSeparator(this);
      break;
    case 3: 
      _cfgPrettyPrinter.writeRootValueSeparator(this);
      break;
    case 0: 
      if (_writeContext.inArray()) {
        _cfgPrettyPrinter.beforeArrayValues(this);
      } else if (_writeContext.inObject()) {
        _cfgPrettyPrinter.beforeObjectEntries(this);
      }
      break;
    default: 
      _throwInternal();
    }
  }
  
  public void flush()
    throws IOException
  {
    _flushBuffer();
    if ((_outputStream != null) && 
      (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM))) {
      _outputStream.flush();
    }
  }
  
  public void close()
    throws IOException
  {
    super.close();
    if ((_outputBuffer != null) && (isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT))) {
      for (;;)
      {
        JsonStreamContext ctxt = getOutputContext();
        if (ctxt.inArray())
        {
          writeEndArray();
        }
        else
        {
          if (!ctxt.inObject()) {
            break;
          }
          writeEndObject();
        }
      }
    }
    _flushBuffer();
    _outputTail = 0;
    if (_outputStream != null) {
      if ((_ioContext.isResourceManaged()) || (isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET))) {
        _outputStream.close();
      } else if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
        _outputStream.flush();
      }
    }
    _releaseBuffers();
  }
  
  protected void _releaseBuffers()
  {
    byte[] buf = _outputBuffer;
    if ((buf != null) && (_bufferRecyclable))
    {
      _outputBuffer = null;
      _ioContext.releaseWriteEncodingBuffer(buf);
    }
    char[] cbuf = _charBuffer;
    if (cbuf != null)
    {
      _charBuffer = null;
      _ioContext.releaseConcatBuffer(cbuf);
    }
  }
  
  private final void _writeBytes(byte[] bytes)
    throws IOException
  {
    int len = bytes.length;
    if (_outputTail + len > _outputEnd)
    {
      _flushBuffer();
      if (len > 512)
      {
        _outputStream.write(bytes, 0, len);
        return;
      }
    }
    System.arraycopy(bytes, 0, _outputBuffer, _outputTail, len);
    _outputTail += len;
  }
  
  private final void _writeBytes(byte[] bytes, int offset, int len)
    throws IOException
  {
    if (_outputTail + len > _outputEnd)
    {
      _flushBuffer();
      if (len > 512)
      {
        _outputStream.write(bytes, offset, len);
        return;
      }
    }
    System.arraycopy(bytes, offset, _outputBuffer, _outputTail, len);
    _outputTail += len;
  }
  
  private final void _writeStringSegments(String text, boolean addQuotes)
    throws IOException
  {
    if (addQuotes)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = 34;
    }
    int left = text.length();
    int offset = 0;
    while (left > 0)
    {
      int len = Math.min(_outputMaxContiguous, left);
      if (_outputTail + len > _outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(text, offset, len);
      offset += len;
      left -= len;
    }
    if (addQuotes)
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = 34;
    }
  }
  
  private final void _writeStringSegments(char[] cbuf, int offset, int totalLen)
    throws IOException
  {
    do
    {
      int len = Math.min(_outputMaxContiguous, totalLen);
      if (_outputTail + len > _outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(cbuf, offset, len);
      offset += len;
      totalLen -= len;
    } while (totalLen > 0);
  }
  
  private final void _writeStringSegments(String text, int offset, int totalLen)
    throws IOException
  {
    do
    {
      int len = Math.min(_outputMaxContiguous, totalLen);
      if (_outputTail + len > _outputEnd) {
        _flushBuffer();
      }
      _writeStringSegment(text, offset, len);
      offset += len;
      totalLen -= len;
    } while (totalLen > 0);
  }
  
  private final void _writeStringSegment(char[] cbuf, int offset, int len)
    throws IOException
  {
    len += offset;
    
    int outputPtr = _outputTail;
    byte[] outputBuffer = _outputBuffer;
    int[] escCodes = _outputEscapes;
    while (offset < len)
    {
      int ch = cbuf[offset];
      if ((ch > 127) || (escCodes[ch] != 0)) {
        break;
      }
      outputBuffer[(outputPtr++)] = ((byte)ch);
      offset++;
    }
    _outputTail = outputPtr;
    if (offset < len) {
      if (_characterEscapes != null) {
        _writeCustomStringSegment2(cbuf, offset, len);
      } else if (_maximumNonEscapedChar == 0) {
        _writeStringSegment2(cbuf, offset, len);
      } else {
        _writeStringSegmentASCII2(cbuf, offset, len);
      }
    }
  }
  
  private final void _writeStringSegment(String text, int offset, int len)
    throws IOException
  {
    len += offset;
    
    int outputPtr = _outputTail;
    byte[] outputBuffer = _outputBuffer;
    int[] escCodes = _outputEscapes;
    while (offset < len)
    {
      int ch = text.charAt(offset);
      if ((ch > 127) || (escCodes[ch] != 0)) {
        break;
      }
      outputBuffer[(outputPtr++)] = ((byte)ch);
      offset++;
    }
    _outputTail = outputPtr;
    if (offset < len) {
      if (_characterEscapes != null) {
        _writeCustomStringSegment2(text, offset, len);
      } else if (_maximumNonEscapedChar == 0) {
        _writeStringSegment2(text, offset, len);
      } else {
        _writeStringSegmentASCII2(text, offset, len);
      }
    }
  }
  
  private final void _writeStringSegment2(char[] cbuf, int offset, int end)
    throws IOException
  {
    if (_outputTail + 6 * (end - offset) > _outputEnd) {
      _flushBuffer();
    }
    int outputPtr = _outputTail;
    
    byte[] outputBuffer = _outputBuffer;
    int[] escCodes = _outputEscapes;
    while (offset < end)
    {
      int ch = cbuf[(offset++)];
      if (ch <= 127)
      {
        if (escCodes[ch] == 0)
        {
          outputBuffer[(outputPtr++)] = ((byte)ch);
        }
        else
        {
          int escape = escCodes[ch];
          if (escape > 0)
          {
            outputBuffer[(outputPtr++)] = 92;
            outputBuffer[(outputPtr++)] = ((byte)escape);
          }
          else
          {
            outputPtr = _writeGenericEscape(ch, outputPtr);
          }
        }
      }
      else if (ch <= 2047)
      {
        outputBuffer[(outputPtr++)] = ((byte)(0xC0 | ch >> 6));
        outputBuffer[(outputPtr++)] = ((byte)(0x80 | ch & 0x3F));
      }
      else
      {
        outputPtr = _outputMultiByteChar(ch, outputPtr);
      }
    }
    _outputTail = outputPtr;
  }
  
  private final void _writeStringSegment2(String text, int offset, int end)
    throws IOException
  {
    if (_outputTail + 6 * (end - offset) > _outputEnd) {
      _flushBuffer();
    }
    int outputPtr = _outputTail;
    
    byte[] outputBuffer = _outputBuffer;
    int[] escCodes = _outputEscapes;
    while (offset < end)
    {
      int ch = text.charAt(offset++);
      if (ch <= 127)
      {
        if (escCodes[ch] == 0)
        {
          outputBuffer[(outputPtr++)] = ((byte)ch);
        }
        else
        {
          int escape = escCodes[ch];
          if (escape > 0)
          {
            outputBuffer[(outputPtr++)] = 92;
            outputBuffer[(outputPtr++)] = ((byte)escape);
          }
          else
          {
            outputPtr = _writeGenericEscape(ch, outputPtr);
          }
        }
      }
      else if (ch <= 2047)
      {
        outputBuffer[(outputPtr++)] = ((byte)(0xC0 | ch >> 6));
        outputBuffer[(outputPtr++)] = ((byte)(0x80 | ch & 0x3F));
      }
      else
      {
        outputPtr = _outputMultiByteChar(ch, outputPtr);
      }
    }
    _outputTail = outputPtr;
  }
  
  private final void _writeStringSegmentASCII2(char[] cbuf, int offset, int end)
    throws IOException
  {
    if (_outputTail + 6 * (end - offset) > _outputEnd) {
      _flushBuffer();
    }
    int outputPtr = _outputTail;
    
    byte[] outputBuffer = _outputBuffer;
    int[] escCodes = _outputEscapes;
    int maxUnescaped = _maximumNonEscapedChar;
    while (offset < end)
    {
      int ch = cbuf[(offset++)];
      if (ch <= 127)
      {
        if (escCodes[ch] == 0)
        {
          outputBuffer[(outputPtr++)] = ((byte)ch);
        }
        else
        {
          int escape = escCodes[ch];
          if (escape > 0)
          {
            outputBuffer[(outputPtr++)] = 92;
            outputBuffer[(outputPtr++)] = ((byte)escape);
          }
          else
          {
            outputPtr = _writeGenericEscape(ch, outputPtr);
          }
        }
      }
      else if (ch > maxUnescaped)
      {
        outputPtr = _writeGenericEscape(ch, outputPtr);
      }
      else if (ch <= 2047)
      {
        outputBuffer[(outputPtr++)] = ((byte)(0xC0 | ch >> 6));
        outputBuffer[(outputPtr++)] = ((byte)(0x80 | ch & 0x3F));
      }
      else
      {
        outputPtr = _outputMultiByteChar(ch, outputPtr);
      }
    }
    _outputTail = outputPtr;
  }
  
  private final void _writeStringSegmentASCII2(String text, int offset, int end)
    throws IOException
  {
    if (_outputTail + 6 * (end - offset) > _outputEnd) {
      _flushBuffer();
    }
    int outputPtr = _outputTail;
    
    byte[] outputBuffer = _outputBuffer;
    int[] escCodes = _outputEscapes;
    int maxUnescaped = _maximumNonEscapedChar;
    while (offset < end)
    {
      int ch = text.charAt(offset++);
      if (ch <= 127)
      {
        if (escCodes[ch] == 0)
        {
          outputBuffer[(outputPtr++)] = ((byte)ch);
        }
        else
        {
          int escape = escCodes[ch];
          if (escape > 0)
          {
            outputBuffer[(outputPtr++)] = 92;
            outputBuffer[(outputPtr++)] = ((byte)escape);
          }
          else
          {
            outputPtr = _writeGenericEscape(ch, outputPtr);
          }
        }
      }
      else if (ch > maxUnescaped)
      {
        outputPtr = _writeGenericEscape(ch, outputPtr);
      }
      else if (ch <= 2047)
      {
        outputBuffer[(outputPtr++)] = ((byte)(0xC0 | ch >> 6));
        outputBuffer[(outputPtr++)] = ((byte)(0x80 | ch & 0x3F));
      }
      else
      {
        outputPtr = _outputMultiByteChar(ch, outputPtr);
      }
    }
    _outputTail = outputPtr;
  }
  
  private final void _writeCustomStringSegment2(char[] cbuf, int offset, int end)
    throws IOException
  {
    if (_outputTail + 6 * (end - offset) > _outputEnd) {
      _flushBuffer();
    }
    int outputPtr = _outputTail;
    
    byte[] outputBuffer = _outputBuffer;
    int[] escCodes = _outputEscapes;
    
    int maxUnescaped = _maximumNonEscapedChar <= 0 ? 65535 : _maximumNonEscapedChar;
    CharacterEscapes customEscapes = _characterEscapes;
    while (offset < end)
    {
      int ch = cbuf[(offset++)];
      if (ch <= 127)
      {
        if (escCodes[ch] == 0)
        {
          outputBuffer[(outputPtr++)] = ((byte)ch);
        }
        else
        {
          int escape = escCodes[ch];
          if (escape > 0)
          {
            outputBuffer[(outputPtr++)] = 92;
            outputBuffer[(outputPtr++)] = ((byte)escape);
          }
          else if (escape == -2)
          {
            SerializableString esc = customEscapes.getEscapeSequence(ch);
            if (esc == null) {
              _reportError("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(ch) + ", although was supposed to have one");
            }
            outputPtr = _writeCustomEscape(outputBuffer, outputPtr, esc, end - offset);
          }
          else
          {
            outputPtr = _writeGenericEscape(ch, outputPtr);
          }
        }
      }
      else if (ch > maxUnescaped)
      {
        outputPtr = _writeGenericEscape(ch, outputPtr);
      }
      else
      {
        SerializableString esc = customEscapes.getEscapeSequence(ch);
        if (esc != null)
        {
          outputPtr = _writeCustomEscape(outputBuffer, outputPtr, esc, end - offset);
        }
        else if (ch <= 2047)
        {
          outputBuffer[(outputPtr++)] = ((byte)(0xC0 | ch >> 6));
          outputBuffer[(outputPtr++)] = ((byte)(0x80 | ch & 0x3F));
        }
        else
        {
          outputPtr = _outputMultiByteChar(ch, outputPtr);
        }
      }
    }
    _outputTail = outputPtr;
  }
  
  private final void _writeCustomStringSegment2(String text, int offset, int end)
    throws IOException
  {
    if (_outputTail + 6 * (end - offset) > _outputEnd) {
      _flushBuffer();
    }
    int outputPtr = _outputTail;
    
    byte[] outputBuffer = _outputBuffer;
    int[] escCodes = _outputEscapes;
    
    int maxUnescaped = _maximumNonEscapedChar <= 0 ? 65535 : _maximumNonEscapedChar;
    CharacterEscapes customEscapes = _characterEscapes;
    while (offset < end)
    {
      int ch = text.charAt(offset++);
      if (ch <= 127)
      {
        if (escCodes[ch] == 0)
        {
          outputBuffer[(outputPtr++)] = ((byte)ch);
        }
        else
        {
          int escape = escCodes[ch];
          if (escape > 0)
          {
            outputBuffer[(outputPtr++)] = 92;
            outputBuffer[(outputPtr++)] = ((byte)escape);
          }
          else if (escape == -2)
          {
            SerializableString esc = customEscapes.getEscapeSequence(ch);
            if (esc == null) {
              _reportError("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(ch) + ", although was supposed to have one");
            }
            outputPtr = _writeCustomEscape(outputBuffer, outputPtr, esc, end - offset);
          }
          else
          {
            outputPtr = _writeGenericEscape(ch, outputPtr);
          }
        }
      }
      else if (ch > maxUnescaped)
      {
        outputPtr = _writeGenericEscape(ch, outputPtr);
      }
      else
      {
        SerializableString esc = customEscapes.getEscapeSequence(ch);
        if (esc != null)
        {
          outputPtr = _writeCustomEscape(outputBuffer, outputPtr, esc, end - offset);
        }
        else if (ch <= 2047)
        {
          outputBuffer[(outputPtr++)] = ((byte)(0xC0 | ch >> 6));
          outputBuffer[(outputPtr++)] = ((byte)(0x80 | ch & 0x3F));
        }
        else
        {
          outputPtr = _outputMultiByteChar(ch, outputPtr);
        }
      }
    }
    _outputTail = outputPtr;
  }
  
  private final int _writeCustomEscape(byte[] outputBuffer, int outputPtr, SerializableString esc, int remainingChars)
    throws IOException, JsonGenerationException
  {
    byte[] raw = esc.asUnquotedUTF8();
    int len = raw.length;
    if (len > 6) {
      return _handleLongCustomEscape(outputBuffer, outputPtr, _outputEnd, raw, remainingChars);
    }
    System.arraycopy(raw, 0, outputBuffer, outputPtr, len);
    return outputPtr + len;
  }
  
  private final int _handleLongCustomEscape(byte[] outputBuffer, int outputPtr, int outputEnd, byte[] raw, int remainingChars)
    throws IOException, JsonGenerationException
  {
    int len = raw.length;
    if (outputPtr + len > outputEnd)
    {
      _outputTail = outputPtr;
      _flushBuffer();
      outputPtr = _outputTail;
      if (len > outputBuffer.length)
      {
        _outputStream.write(raw, 0, len);
        return outputPtr;
      }
      System.arraycopy(raw, 0, outputBuffer, outputPtr, len);
      outputPtr += len;
    }
    if (outputPtr + 6 * remainingChars > outputEnd)
    {
      _flushBuffer();
      return _outputTail;
    }
    return outputPtr;
  }
  
  private final void _writeUTF8Segments(byte[] utf8, int offset, int totalLen)
    throws IOException, JsonGenerationException
  {
    do
    {
      int len = Math.min(_outputMaxContiguous, totalLen);
      _writeUTF8Segment(utf8, offset, len);
      offset += len;
      totalLen -= len;
    } while (totalLen > 0);
  }
  
  private final void _writeUTF8Segment(byte[] utf8, int offset, int len)
    throws IOException, JsonGenerationException
  {
    int[] escCodes = _outputEscapes;
    
    int ptr = offset;
    for (int end = offset + len; ptr < end;)
    {
      int ch = utf8[(ptr++)];
      if ((ch >= 0) && (escCodes[ch] != 0))
      {
        _writeUTF8Segment2(utf8, offset, len);
        return;
      }
    }
    if (_outputTail + len > _outputEnd) {
      _flushBuffer();
    }
    System.arraycopy(utf8, offset, _outputBuffer, _outputTail, len);
    _outputTail += len;
  }
  
  private final void _writeUTF8Segment2(byte[] utf8, int offset, int len)
    throws IOException, JsonGenerationException
  {
    int outputPtr = _outputTail;
    if (outputPtr + len * 6 > _outputEnd)
    {
      _flushBuffer();
      outputPtr = _outputTail;
    }
    byte[] outputBuffer = _outputBuffer;
    int[] escCodes = _outputEscapes;
    len += offset;
    while (offset < len)
    {
      byte b = utf8[(offset++)];
      int ch = b;
      if ((ch < 0) || (escCodes[ch] == 0))
      {
        outputBuffer[(outputPtr++)] = b;
      }
      else
      {
        int escape = escCodes[ch];
        if (escape > 0)
        {
          outputBuffer[(outputPtr++)] = 92;
          outputBuffer[(outputPtr++)] = ((byte)escape);
        }
        else
        {
          outputPtr = _writeGenericEscape(ch, outputPtr);
        }
      }
    }
    _outputTail = outputPtr;
  }
  
  protected final void _writeBinary(Base64Variant b64variant, byte[] input, int inputPtr, int inputEnd)
    throws IOException, JsonGenerationException
  {
    int safeInputEnd = inputEnd - 3;
    
    int safeOutputEnd = _outputEnd - 6;
    int chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
    while (inputPtr <= safeInputEnd)
    {
      if (_outputTail > safeOutputEnd) {
        _flushBuffer();
      }
      int b24 = input[(inputPtr++)] << 8;
      b24 |= input[(inputPtr++)] & 0xFF;
      b24 = b24 << 8 | input[(inputPtr++)] & 0xFF;
      _outputTail = b64variant.encodeBase64Chunk(b24, _outputBuffer, _outputTail);
      chunksBeforeLF--;
      if (chunksBeforeLF <= 0)
      {
        _outputBuffer[(_outputTail++)] = 92;
        _outputBuffer[(_outputTail++)] = 110;
        chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
      }
    }
    int inputLeft = inputEnd - inputPtr;
    if (inputLeft > 0)
    {
      if (_outputTail > safeOutputEnd) {
        _flushBuffer();
      }
      int b24 = input[(inputPtr++)] << 16;
      if (inputLeft == 2) {
        b24 |= (input[(inputPtr++)] & 0xFF) << 8;
      }
      _outputTail = b64variant.encodeBase64Partial(b24, inputLeft, _outputBuffer, _outputTail);
    }
  }
  
  protected final int _writeBinary(Base64Variant b64variant, InputStream data, byte[] readBuffer, int bytesLeft)
    throws IOException, JsonGenerationException
  {
    int inputPtr = 0;
    int inputEnd = 0;
    int lastFullOffset = -3;
    
    int safeOutputEnd = _outputEnd - 6;
    int chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
    while (bytesLeft > 2)
    {
      if (inputPtr > lastFullOffset)
      {
        inputEnd = _readMore(data, readBuffer, inputPtr, inputEnd, bytesLeft);
        inputPtr = 0;
        if (inputEnd < 3) {
          break;
        }
        lastFullOffset = inputEnd - 3;
      }
      if (_outputTail > safeOutputEnd) {
        _flushBuffer();
      }
      int b24 = readBuffer[(inputPtr++)] << 8;
      b24 |= readBuffer[(inputPtr++)] & 0xFF;
      b24 = b24 << 8 | readBuffer[(inputPtr++)] & 0xFF;
      bytesLeft -= 3;
      _outputTail = b64variant.encodeBase64Chunk(b24, _outputBuffer, _outputTail);
      chunksBeforeLF--;
      if (chunksBeforeLF <= 0)
      {
        _outputBuffer[(_outputTail++)] = 92;
        _outputBuffer[(_outputTail++)] = 110;
        chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
      }
    }
    if (bytesLeft > 0)
    {
      inputEnd = _readMore(data, readBuffer, inputPtr, inputEnd, bytesLeft);
      inputPtr = 0;
      if (inputEnd > 0)
      {
        if (_outputTail > safeOutputEnd) {
          _flushBuffer();
        }
        int b24 = readBuffer[(inputPtr++)] << 16;
        int amount;
        int amount;
        if (inputPtr < inputEnd)
        {
          b24 |= (readBuffer[inputPtr] & 0xFF) << 8;
          amount = 2;
        }
        else
        {
          amount = 1;
        }
        _outputTail = b64variant.encodeBase64Partial(b24, amount, _outputBuffer, _outputTail);
        bytesLeft -= amount;
      }
    }
    return bytesLeft;
  }
  
  protected final int _writeBinary(Base64Variant b64variant, InputStream data, byte[] readBuffer)
    throws IOException, JsonGenerationException
  {
    int inputPtr = 0;
    int inputEnd = 0;
    int lastFullOffset = -3;
    int bytesDone = 0;
    
    int safeOutputEnd = _outputEnd - 6;
    int chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
    for (;;)
    {
      if (inputPtr > lastFullOffset)
      {
        inputEnd = _readMore(data, readBuffer, inputPtr, inputEnd, readBuffer.length);
        inputPtr = 0;
        if (inputEnd < 3) {
          break;
        }
        lastFullOffset = inputEnd - 3;
      }
      if (_outputTail > safeOutputEnd) {
        _flushBuffer();
      }
      int b24 = readBuffer[(inputPtr++)] << 8;
      b24 |= readBuffer[(inputPtr++)] & 0xFF;
      b24 = b24 << 8 | readBuffer[(inputPtr++)] & 0xFF;
      bytesDone += 3;
      _outputTail = b64variant.encodeBase64Chunk(b24, _outputBuffer, _outputTail);
      chunksBeforeLF--;
      if (chunksBeforeLF <= 0)
      {
        _outputBuffer[(_outputTail++)] = 92;
        _outputBuffer[(_outputTail++)] = 110;
        chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
      }
    }
    if (inputPtr < inputEnd)
    {
      if (_outputTail > safeOutputEnd) {
        _flushBuffer();
      }
      int b24 = readBuffer[(inputPtr++)] << 16;
      int amount = 1;
      if (inputPtr < inputEnd)
      {
        b24 |= (readBuffer[inputPtr] & 0xFF) << 8;
        amount = 2;
      }
      bytesDone += amount;
      _outputTail = b64variant.encodeBase64Partial(b24, amount, _outputBuffer, _outputTail);
    }
    return bytesDone;
  }
  
  private final int _readMore(InputStream in, byte[] readBuffer, int inputPtr, int inputEnd, int maxRead)
    throws IOException
  {
    int i = 0;
    while (inputPtr < inputEnd) {
      readBuffer[(i++)] = readBuffer[(inputPtr++)];
    }
    inputPtr = 0;
    inputEnd = i;
    maxRead = Math.min(maxRead, readBuffer.length);
    do
    {
      int length = maxRead - inputEnd;
      if (length == 0) {
        break;
      }
      int count = in.read(readBuffer, inputEnd, length);
      if (count < 0) {
        return inputEnd;
      }
      inputEnd += count;
    } while (inputEnd < 3);
    return inputEnd;
  }
  
  private final int _outputRawMultiByteChar(int ch, char[] cbuf, int inputOffset, int inputLen)
    throws IOException
  {
    if ((ch >= 55296) && 
      (ch <= 57343))
    {
      if ((inputOffset >= inputLen) || (cbuf == null)) {
        _reportError("Split surrogate on writeRaw() input (last character)");
      }
      _outputSurrogates(ch, cbuf[inputOffset]);
      return inputOffset + 1;
    }
    byte[] bbuf = _outputBuffer;
    bbuf[(_outputTail++)] = ((byte)(0xE0 | ch >> 12));
    bbuf[(_outputTail++)] = ((byte)(0x80 | ch >> 6 & 0x3F));
    bbuf[(_outputTail++)] = ((byte)(0x80 | ch & 0x3F));
    return inputOffset;
  }
  
  protected final void _outputSurrogates(int surr1, int surr2)
    throws IOException
  {
    int c = _decodeSurrogate(surr1, surr2);
    if (_outputTail + 4 > _outputEnd) {
      _flushBuffer();
    }
    byte[] bbuf = _outputBuffer;
    bbuf[(_outputTail++)] = ((byte)(0xF0 | c >> 18));
    bbuf[(_outputTail++)] = ((byte)(0x80 | c >> 12 & 0x3F));
    bbuf[(_outputTail++)] = ((byte)(0x80 | c >> 6 & 0x3F));
    bbuf[(_outputTail++)] = ((byte)(0x80 | c & 0x3F));
  }
  
  private final int _outputMultiByteChar(int ch, int outputPtr)
    throws IOException
  {
    byte[] bbuf = _outputBuffer;
    if ((ch >= 55296) && (ch <= 57343))
    {
      bbuf[(outputPtr++)] = 92;
      bbuf[(outputPtr++)] = 117;
      
      bbuf[(outputPtr++)] = HEX_CHARS[(ch >> 12 & 0xF)];
      bbuf[(outputPtr++)] = HEX_CHARS[(ch >> 8 & 0xF)];
      bbuf[(outputPtr++)] = HEX_CHARS[(ch >> 4 & 0xF)];
      bbuf[(outputPtr++)] = HEX_CHARS[(ch & 0xF)];
    }
    else
    {
      bbuf[(outputPtr++)] = ((byte)(0xE0 | ch >> 12));
      bbuf[(outputPtr++)] = ((byte)(0x80 | ch >> 6 & 0x3F));
      bbuf[(outputPtr++)] = ((byte)(0x80 | ch & 0x3F));
    }
    return outputPtr;
  }
  
  private final void _writeNull()
    throws IOException
  {
    if (_outputTail + 4 >= _outputEnd) {
      _flushBuffer();
    }
    System.arraycopy(NULL_BYTES, 0, _outputBuffer, _outputTail, 4);
    _outputTail += 4;
  }
  
  private int _writeGenericEscape(int charToEscape, int outputPtr)
    throws IOException
  {
    byte[] bbuf = _outputBuffer;
    bbuf[(outputPtr++)] = 92;
    bbuf[(outputPtr++)] = 117;
    if (charToEscape > 255)
    {
      int hi = charToEscape >> 8 & 0xFF;
      bbuf[(outputPtr++)] = HEX_CHARS[(hi >> 4)];
      bbuf[(outputPtr++)] = HEX_CHARS[(hi & 0xF)];
      charToEscape &= 0xFF;
    }
    else
    {
      bbuf[(outputPtr++)] = 48;
      bbuf[(outputPtr++)] = 48;
    }
    bbuf[(outputPtr++)] = HEX_CHARS[(charToEscape >> 4)];
    bbuf[(outputPtr++)] = HEX_CHARS[(charToEscape & 0xF)];
    return outputPtr;
  }
  
  protected final void _flushBuffer()
    throws IOException
  {
    int len = _outputTail;
    if (len > 0)
    {
      _outputTail = 0;
      _outputStream.write(_outputBuffer, 0, len);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.UTF8JsonGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */