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
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class WriterBasedJsonGenerator
  extends JsonGeneratorImpl
{
  protected static final int SHORT_WRITE = 32;
  protected static final char[] HEX_CHARS = ;
  protected final Writer _writer;
  protected char[] _outputBuffer;
  protected int _outputHead = 0;
  protected int _outputTail = 0;
  protected int _outputEnd;
  protected char[] _entityBuffer;
  protected SerializableString _currentEscape;
  
  public WriterBasedJsonGenerator(IOContext ctxt, int features, ObjectCodec codec, Writer w)
  {
    super(ctxt, features, codec);
    _writer = w;
    _outputBuffer = ctxt.allocConcatBuffer();
    _outputEnd = _outputBuffer.length;
  }
  
  public Object getOutputTarget()
  {
    return _writer;
  }
  
  public int getOutputBuffered()
  {
    int len = _outputTail - _outputHead;
    return Math.max(0, len);
  }
  
  public void writeFieldName(String name)
    throws IOException
  {
    int status = _writeContext.writeFieldName(name);
    if (status == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    _writeFieldName(name, status == 1);
  }
  
  public void writeFieldName(SerializableString name)
    throws IOException
  {
    int status = _writeContext.writeFieldName(name.getValue());
    if (status == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    _writeFieldName(name, status == 1);
  }
  
  public void writeStartArray()
    throws IOException, JsonGenerationException
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
      _outputBuffer[(_outputTail++)] = '[';
    }
  }
  
  public void writeEndArray()
    throws IOException, JsonGenerationException
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
      _outputBuffer[(_outputTail++)] = ']';
    }
    _writeContext = _writeContext.getParent();
  }
  
  public void writeStartObject()
    throws IOException, JsonGenerationException
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
      _outputBuffer[(_outputTail++)] = '{';
    }
  }
  
  public void writeEndObject()
    throws IOException, JsonGenerationException
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
      _outputBuffer[(_outputTail++)] = '}';
    }
    _writeContext = _writeContext.getParent();
  }
  
  protected void _writeFieldName(String name, boolean commaBefore)
    throws IOException
  {
    if (_cfgPrettyPrinter != null)
    {
      _writePPFieldName(name, commaBefore);
      return;
    }
    if (_outputTail + 1 >= _outputEnd) {
      _flushBuffer();
    }
    if (commaBefore) {
      _outputBuffer[(_outputTail++)] = ',';
    }
    if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      _writeString(name);
      return;
    }
    _outputBuffer[(_outputTail++)] = '"';
    
    _writeString(name);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
  }
  
  protected void _writeFieldName(SerializableString name, boolean commaBefore)
    throws IOException
  {
    if (_cfgPrettyPrinter != null)
    {
      _writePPFieldName(name, commaBefore);
      return;
    }
    if (_outputTail + 1 >= _outputEnd) {
      _flushBuffer();
    }
    if (commaBefore) {
      _outputBuffer[(_outputTail++)] = ',';
    }
    char[] quoted = name.asQuotedChars();
    if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      writeRaw(quoted, 0, quoted.length);
      return;
    }
    _outputBuffer[(_outputTail++)] = '"';
    
    int qlen = quoted.length;
    if (_outputTail + qlen + 1 >= _outputEnd)
    {
      writeRaw(quoted, 0, qlen);
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = '"';
    }
    else
    {
      System.arraycopy(quoted, 0, _outputBuffer, _outputTail, qlen);
      _outputTail += qlen;
      _outputBuffer[(_outputTail++)] = '"';
    }
  }
  
  protected void _writePPFieldName(String name, boolean commaBefore)
    throws IOException, JsonGenerationException
  {
    if (commaBefore) {
      _cfgPrettyPrinter.writeObjectEntrySeparator(this);
    } else {
      _cfgPrettyPrinter.beforeObjectEntries(this);
    }
    if (isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = '"';
      _writeString(name);
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = '"';
    }
    else
    {
      _writeString(name);
    }
  }
  
  protected void _writePPFieldName(SerializableString name, boolean commaBefore)
    throws IOException, JsonGenerationException
  {
    if (commaBefore) {
      _cfgPrettyPrinter.writeObjectEntrySeparator(this);
    } else {
      _cfgPrettyPrinter.beforeObjectEntries(this);
    }
    char[] quoted = name.asQuotedChars();
    if (isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES))
    {
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = '"';
      writeRaw(quoted, 0, quoted.length);
      if (_outputTail >= _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = '"';
    }
    else
    {
      writeRaw(quoted, 0, quoted.length);
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
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
    _writeString(text);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
  }
  
  public void writeString(char[] text, int offset, int len)
    throws IOException
  {
    _verifyValueWrite("write a string");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
    _writeString(text, offset, len);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
  }
  
  public void writeString(SerializableString sstr)
    throws IOException
  {
    _verifyValueWrite("write a string");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
    
    char[] text = sstr.asQuotedChars();
    int len = text.length;
    if (len < 32)
    {
      int room = _outputEnd - _outputTail;
      if (len > room) {
        _flushBuffer();
      }
      System.arraycopy(text, 0, _outputBuffer, _outputTail, len);
      _outputTail += len;
    }
    else
    {
      _flushBuffer();
      _writer.write(text, 0, len);
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
  }
  
  public void writeRawUTF8String(byte[] text, int offset, int length)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeUTF8String(byte[] text, int offset, int length)
    throws IOException
  {
    _reportUnsupportedOperation();
  }
  
  public void writeRaw(String text)
    throws IOException
  {
    int len = text.length();
    int room = _outputEnd - _outputTail;
    if (room == 0)
    {
      _flushBuffer();
      room = _outputEnd - _outputTail;
    }
    if (room >= len)
    {
      text.getChars(0, len, _outputBuffer, _outputTail);
      _outputTail += len;
    }
    else
    {
      writeRawLong(text);
    }
  }
  
  public void writeRaw(String text, int start, int len)
    throws IOException
  {
    int room = _outputEnd - _outputTail;
    if (room < len)
    {
      _flushBuffer();
      room = _outputEnd - _outputTail;
    }
    if (room >= len)
    {
      text.getChars(start, start + len, _outputBuffer, _outputTail);
      _outputTail += len;
    }
    else
    {
      writeRawLong(text.substring(start, start + len));
    }
  }
  
  public void writeRaw(SerializableString text)
    throws IOException
  {
    writeRaw(text.getValue());
  }
  
  public void writeRaw(char[] text, int offset, int len)
    throws IOException
  {
    if (len < 32)
    {
      int room = _outputEnd - _outputTail;
      if (len > room) {
        _flushBuffer();
      }
      System.arraycopy(text, offset, _outputBuffer, _outputTail, len);
      _outputTail += len;
      return;
    }
    _flushBuffer();
    _writer.write(text, offset, len);
  }
  
  public void writeRaw(char c)
    throws IOException
  {
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = c;
  }
  
  private void writeRawLong(String text)
    throws IOException
  {
    int room = _outputEnd - _outputTail;
    
    text.getChars(0, room, _outputBuffer, _outputTail);
    _outputTail += room;
    _flushBuffer();
    int offset = room;
    int len = text.length() - room;
    while (len > _outputEnd)
    {
      int amount = _outputEnd;
      text.getChars(offset, offset + amount, _outputBuffer, 0);
      _outputHead = 0;
      _outputTail = amount;
      _flushBuffer();
      offset += amount;
      len -= amount;
    }
    text.getChars(offset, offset + len, _outputBuffer, 0);
    _outputHead = 0;
    _outputTail = len;
  }
  
  public void writeBinary(Base64Variant b64variant, byte[] data, int offset, int len)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write a binary value");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
    _writeBinary(b64variant, data, offset, offset + len);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
  }
  
  public int writeBinary(Base64Variant b64variant, InputStream data, int dataLength)
    throws IOException, JsonGenerationException
  {
    _verifyValueWrite("write a binary value");
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
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
    _outputBuffer[(_outputTail++)] = '"';
    return bytes;
  }
  
  public void writeNumber(short s)
    throws IOException
  {
    _verifyValueWrite("write a number");
    if (_cfgNumbersAsStrings)
    {
      _writeQuotedShort(s);
      return;
    }
    if (_outputTail + 6 >= _outputEnd) {
      _flushBuffer();
    }
    _outputTail = NumberOutput.outputInt(s, _outputBuffer, _outputTail);
  }
  
  private void _writeQuotedShort(short s)
    throws IOException
  {
    if (_outputTail + 8 >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
    _outputTail = NumberOutput.outputInt(s, _outputBuffer, _outputTail);
    _outputBuffer[(_outputTail++)] = '"';
  }
  
  public void writeNumber(int i)
    throws IOException
  {
    _verifyValueWrite("write a number");
    if (_cfgNumbersAsStrings)
    {
      _writeQuotedInt(i);
      return;
    }
    if (_outputTail + 11 >= _outputEnd) {
      _flushBuffer();
    }
    _outputTail = NumberOutput.outputInt(i, _outputBuffer, _outputTail);
  }
  
  private void _writeQuotedInt(int i)
    throws IOException
  {
    if (_outputTail + 13 >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
    _outputTail = NumberOutput.outputInt(i, _outputBuffer, _outputTail);
    _outputBuffer[(_outputTail++)] = '"';
  }
  
  public void writeNumber(long l)
    throws IOException
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
  
  private void _writeQuotedLong(long l)
    throws IOException
  {
    if (_outputTail + 23 >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
    _outputTail = NumberOutput.outputLong(l, _outputBuffer, _outputTail);
    _outputBuffer[(_outputTail++)] = '"';
  }
  
  public void writeNumber(BigInteger value)
    throws IOException
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
    throws IOException
  {
    if ((_cfgNumbersAsStrings) || ((isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)) && ((Double.isNaN(d)) || (Double.isInfinite(d)))))
    {
      writeString(String.valueOf(d));
      return;
    }
    _verifyValueWrite("write a number");
    writeRaw(String.valueOf(d));
  }
  
  public void writeNumber(float f)
    throws IOException
  {
    if ((_cfgNumbersAsStrings) || ((isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)) && ((Float.isNaN(f)) || (Float.isInfinite(f)))))
    {
      writeString(String.valueOf(f));
      return;
    }
    _verifyValueWrite("write a number");
    writeRaw(String.valueOf(f));
  }
  
  public void writeNumber(BigDecimal value)
    throws IOException
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
    throws IOException
  {
    _verifyValueWrite("write a number");
    if (_cfgNumbersAsStrings) {
      _writeQuotedRaw(encodedValue);
    } else {
      writeRaw(encodedValue);
    }
  }
  
  private void _writeQuotedRaw(String value)
    throws IOException
  {
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
    writeRaw(value);
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = '"';
  }
  
  public void writeBoolean(boolean state)
    throws IOException
  {
    _verifyValueWrite("write a boolean value");
    if (_outputTail + 5 >= _outputEnd) {
      _flushBuffer();
    }
    int ptr = _outputTail;
    char[] buf = _outputBuffer;
    if (state)
    {
      buf[ptr] = 't';
      buf[(++ptr)] = 'r';
      buf[(++ptr)] = 'u';
      buf[(++ptr)] = 'e';
    }
    else
    {
      buf[ptr] = 'f';
      buf[(++ptr)] = 'a';
      buf[(++ptr)] = 'l';
      buf[(++ptr)] = 's';
      buf[(++ptr)] = 'e';
    }
    _outputTail = (ptr + 1);
  }
  
  public void writeNull()
    throws IOException
  {
    _verifyValueWrite("write a null");
    _writeNull();
  }
  
  protected void _verifyValueWrite(String typeMsg)
    throws IOException
  {
    if (_cfgPrettyPrinter != null)
    {
      _verifyPrettyValueWrite(typeMsg);
      return;
    }
    int status = _writeContext.writeValue();
    if (status == 5) {
      _reportError("Can not " + typeMsg + ", expecting field name");
    }
    char c;
    switch (status)
    {
    case 1: 
      c = ',';
      break;
    case 2: 
      c = ':';
      break;
    case 3: 
      if (_rootValueSeparator != null) {
        writeRaw(_rootValueSeparator.getValue());
      }
      return;
    case 0: 
    default: 
      return;
    }
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[_outputTail] = c;
    _outputTail += 1;
  }
  
  protected void _verifyPrettyValueWrite(String typeMsg)
    throws IOException
  {
    int status = _writeContext.writeValue();
    if (status == 5) {
      _reportError("Can not " + typeMsg + ", expecting field name");
    }
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
    if ((_writer != null) && 
      (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM))) {
      _writer.flush();
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
    _outputHead = 0;
    _outputTail = 0;
    if (_writer != null) {
      if ((_ioContext.isResourceManaged()) || (isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET))) {
        _writer.close();
      } else if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
        _writer.flush();
      }
    }
    _releaseBuffers();
  }
  
  protected void _releaseBuffers()
  {
    char[] buf = _outputBuffer;
    if (buf != null)
    {
      _outputBuffer = null;
      _ioContext.releaseConcatBuffer(buf);
    }
  }
  
  private void _writeString(String text)
    throws IOException
  {
    int len = text.length();
    if (len > _outputEnd)
    {
      _writeLongString(text);
      return;
    }
    if (_outputTail + len > _outputEnd) {
      _flushBuffer();
    }
    text.getChars(0, len, _outputBuffer, _outputTail);
    if (_characterEscapes != null) {
      _writeStringCustom(len);
    } else if (_maximumNonEscapedChar != 0) {
      _writeStringASCII(len, _maximumNonEscapedChar);
    } else {
      _writeString2(len);
    }
  }
  
  private void _writeString2(int len)
    throws IOException
  {
    int end = _outputTail + len;
    int[] escCodes = _outputEscapes;
    int escLen = escCodes.length;
    while (_outputTail < end)
    {
      for (;;)
      {
        char c = _outputBuffer[_outputTail];
        if ((c < escLen) && (escCodes[c] != 0)) {
          break;
        }
        if (++_outputTail >= end) {
          return;
        }
      }
      int flushLen = _outputTail - _outputHead;
      if (flushLen > 0) {
        _writer.write(_outputBuffer, _outputHead, flushLen);
      }
      char c = _outputBuffer[(_outputTail++)];
      _prependOrWriteCharacterEscape(c, escCodes[c]);
    }
  }
  
  private void _writeLongString(String text)
    throws IOException
  {
    _flushBuffer();
    
    int textLen = text.length();
    int offset = 0;
    do
    {
      int max = _outputEnd;
      int segmentLen = offset + max > textLen ? textLen - offset : max;
      
      text.getChars(offset, offset + segmentLen, _outputBuffer, 0);
      if (_characterEscapes != null) {
        _writeSegmentCustom(segmentLen);
      } else if (_maximumNonEscapedChar != 0) {
        _writeSegmentASCII(segmentLen, _maximumNonEscapedChar);
      } else {
        _writeSegment(segmentLen);
      }
      offset += segmentLen;
    } while (offset < textLen);
  }
  
  private void _writeSegment(int end)
    throws IOException
  {
    int[] escCodes = _outputEscapes;
    int escLen = escCodes.length;
    
    int ptr = 0;
    int start = ptr;
    while (ptr < end)
    {
      char c;
      for (;;)
      {
        c = _outputBuffer[ptr];
        if ((c >= escLen) || (escCodes[c] == 0))
        {
          ptr++;
          if (ptr >= end) {
            break;
          }
        }
      }
      int flushLen = ptr - start;
      if (flushLen > 0)
      {
        _writer.write(_outputBuffer, start, flushLen);
        if (ptr >= end) {
          break;
        }
      }
      ptr++;
      
      start = _prependOrWriteCharacterEscape(_outputBuffer, ptr, end, c, escCodes[c]);
    }
  }
  
  private void _writeString(char[] text, int offset, int len)
    throws IOException
  {
    if (_characterEscapes != null)
    {
      _writeStringCustom(text, offset, len);
      return;
    }
    if (_maximumNonEscapedChar != 0)
    {
      _writeStringASCII(text, offset, len, _maximumNonEscapedChar);
      return;
    }
    len += offset;
    int[] escCodes = _outputEscapes;
    int escLen = escCodes.length;
    while (offset < len)
    {
      int start = offset;
      for (;;)
      {
        char c = text[offset];
        if ((c < escLen) && (escCodes[c] != 0)) {
          break;
        }
        offset++;
        if (offset >= len) {
          break;
        }
      }
      int newAmount = offset - start;
      if (newAmount < 32)
      {
        if (_outputTail + newAmount > _outputEnd) {
          _flushBuffer();
        }
        if (newAmount > 0)
        {
          System.arraycopy(text, start, _outputBuffer, _outputTail, newAmount);
          _outputTail += newAmount;
        }
      }
      else
      {
        _flushBuffer();
        _writer.write(text, start, newAmount);
      }
      if (offset >= len) {
        break;
      }
      char c = text[(offset++)];
      _appendCharacterEscape(c, escCodes[c]);
    }
  }
  
  private void _writeStringASCII(int len, int maxNonEscaped)
    throws IOException, JsonGenerationException
  {
    int end = _outputTail + len;
    int[] escCodes = _outputEscapes;
    int escLimit = Math.min(escCodes.length, maxNonEscaped + 1);
    int escCode = 0;
    while (_outputTail < end)
    {
      char c;
      do
      {
        c = _outputBuffer[_outputTail];
        if (c < escLimit)
        {
          escCode = escCodes[c];
          if (escCode != 0) {
            break;
          }
        }
        else if (c > maxNonEscaped)
        {
          escCode = -1;
          break;
        }
      } while (++_outputTail < end);
      break;
      
      int flushLen = _outputTail - _outputHead;
      if (flushLen > 0) {
        _writer.write(_outputBuffer, _outputHead, flushLen);
      }
      _outputTail += 1;
      _prependOrWriteCharacterEscape(c, escCode);
    }
  }
  
  private void _writeSegmentASCII(int end, int maxNonEscaped)
    throws IOException, JsonGenerationException
  {
    int[] escCodes = _outputEscapes;
    int escLimit = Math.min(escCodes.length, maxNonEscaped + 1);
    
    int ptr = 0;
    int escCode = 0;
    int start = ptr;
    while (ptr < end)
    {
      char c;
      for (;;)
      {
        c = _outputBuffer[ptr];
        if (c < escLimit)
        {
          escCode = escCodes[c];
          if (escCode != 0) {
            break;
          }
        }
        else if (c > maxNonEscaped)
        {
          escCode = -1;
          break;
        }
        ptr++;
        if (ptr >= end) {
          break;
        }
      }
      int flushLen = ptr - start;
      if (flushLen > 0)
      {
        _writer.write(_outputBuffer, start, flushLen);
        if (ptr >= end) {
          break;
        }
      }
      ptr++;
      start = _prependOrWriteCharacterEscape(_outputBuffer, ptr, end, c, escCode);
    }
  }
  
  private void _writeStringASCII(char[] text, int offset, int len, int maxNonEscaped)
    throws IOException, JsonGenerationException
  {
    len += offset;
    int[] escCodes = _outputEscapes;
    int escLimit = Math.min(escCodes.length, maxNonEscaped + 1);
    
    int escCode = 0;
    while (offset < len)
    {
      int start = offset;
      char c;
      for (;;)
      {
        c = text[offset];
        if (c < escLimit)
        {
          escCode = escCodes[c];
          if (escCode != 0) {
            break;
          }
        }
        else if (c > maxNonEscaped)
        {
          escCode = -1;
          break;
        }
        offset++;
        if (offset >= len) {
          break;
        }
      }
      int newAmount = offset - start;
      if (newAmount < 32)
      {
        if (_outputTail + newAmount > _outputEnd) {
          _flushBuffer();
        }
        if (newAmount > 0)
        {
          System.arraycopy(text, start, _outputBuffer, _outputTail, newAmount);
          _outputTail += newAmount;
        }
      }
      else
      {
        _flushBuffer();
        _writer.write(text, start, newAmount);
      }
      if (offset >= len) {
        break;
      }
      offset++;
      _appendCharacterEscape(c, escCode);
    }
  }
  
  private void _writeStringCustom(int len)
    throws IOException, JsonGenerationException
  {
    int end = _outputTail + len;
    int[] escCodes = _outputEscapes;
    int maxNonEscaped = _maximumNonEscapedChar < 1 ? 65535 : _maximumNonEscapedChar;
    int escLimit = Math.min(escCodes.length, maxNonEscaped + 1);
    int escCode = 0;
    CharacterEscapes customEscapes = _characterEscapes;
    while (_outputTail < end)
    {
      char c;
      do
      {
        c = _outputBuffer[_outputTail];
        if (c < escLimit)
        {
          escCode = escCodes[c];
          if (escCode != 0) {
            break;
          }
        }
        else
        {
          if (c > maxNonEscaped)
          {
            escCode = -1;
            break;
          }
          if ((_currentEscape = customEscapes.getEscapeSequence(c)) != null)
          {
            escCode = -2;
            break;
          }
        }
      } while (++_outputTail < end);
      break;
      
      int flushLen = _outputTail - _outputHead;
      if (flushLen > 0) {
        _writer.write(_outputBuffer, _outputHead, flushLen);
      }
      _outputTail += 1;
      _prependOrWriteCharacterEscape(c, escCode);
    }
  }
  
  private void _writeSegmentCustom(int end)
    throws IOException, JsonGenerationException
  {
    int[] escCodes = _outputEscapes;
    int maxNonEscaped = _maximumNonEscapedChar < 1 ? 65535 : _maximumNonEscapedChar;
    int escLimit = Math.min(escCodes.length, maxNonEscaped + 1);
    CharacterEscapes customEscapes = _characterEscapes;
    
    int ptr = 0;
    int escCode = 0;
    int start = ptr;
    while (ptr < end)
    {
      char c;
      for (;;)
      {
        c = _outputBuffer[ptr];
        if (c < escLimit)
        {
          escCode = escCodes[c];
          if (escCode != 0) {
            break;
          }
        }
        else
        {
          if (c > maxNonEscaped)
          {
            escCode = -1;
            break;
          }
          if ((_currentEscape = customEscapes.getEscapeSequence(c)) != null)
          {
            escCode = -2;
            break;
          }
        }
        ptr++;
        if (ptr >= end) {
          break;
        }
      }
      int flushLen = ptr - start;
      if (flushLen > 0)
      {
        _writer.write(_outputBuffer, start, flushLen);
        if (ptr >= end) {
          break;
        }
      }
      ptr++;
      start = _prependOrWriteCharacterEscape(_outputBuffer, ptr, end, c, escCode);
    }
  }
  
  private void _writeStringCustom(char[] text, int offset, int len)
    throws IOException, JsonGenerationException
  {
    len += offset;
    int[] escCodes = _outputEscapes;
    int maxNonEscaped = _maximumNonEscapedChar < 1 ? 65535 : _maximumNonEscapedChar;
    int escLimit = Math.min(escCodes.length, maxNonEscaped + 1);
    CharacterEscapes customEscapes = _characterEscapes;
    
    int escCode = 0;
    while (offset < len)
    {
      int start = offset;
      char c;
      for (;;)
      {
        c = text[offset];
        if (c < escLimit)
        {
          escCode = escCodes[c];
          if (escCode != 0) {
            break;
          }
        }
        else
        {
          if (c > maxNonEscaped)
          {
            escCode = -1;
            break;
          }
          if ((_currentEscape = customEscapes.getEscapeSequence(c)) != null)
          {
            escCode = -2;
            break;
          }
        }
        offset++;
        if (offset >= len) {
          break;
        }
      }
      int newAmount = offset - start;
      if (newAmount < 32)
      {
        if (_outputTail + newAmount > _outputEnd) {
          _flushBuffer();
        }
        if (newAmount > 0)
        {
          System.arraycopy(text, start, _outputBuffer, _outputTail, newAmount);
          _outputTail += newAmount;
        }
      }
      else
      {
        _flushBuffer();
        _writer.write(text, start, newAmount);
      }
      if (offset >= len) {
        break;
      }
      offset++;
      _appendCharacterEscape(c, escCode);
    }
  }
  
  protected void _writeBinary(Base64Variant b64variant, byte[] input, int inputPtr, int inputEnd)
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
        _outputBuffer[(_outputTail++)] = '\\';
        _outputBuffer[(_outputTail++)] = 'n';
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
  
  protected int _writeBinary(Base64Variant b64variant, InputStream data, byte[] readBuffer, int bytesLeft)
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
        _outputBuffer[(_outputTail++)] = '\\';
        _outputBuffer[(_outputTail++)] = 'n';
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
  
  protected int _writeBinary(Base64Variant b64variant, InputStream data, byte[] readBuffer)
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
        _outputBuffer[(_outputTail++)] = '\\';
        _outputBuffer[(_outputTail++)] = 'n';
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
  
  private int _readMore(InputStream in, byte[] readBuffer, int inputPtr, int inputEnd, int maxRead)
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
  
  private final void _writeNull()
    throws IOException
  {
    if (_outputTail + 4 >= _outputEnd) {
      _flushBuffer();
    }
    int ptr = _outputTail;
    char[] buf = _outputBuffer;
    buf[ptr] = 'n';
    buf[(++ptr)] = 'u';
    buf[(++ptr)] = 'l';
    buf[(++ptr)] = 'l';
    _outputTail = (ptr + 1);
  }
  
  private void _prependOrWriteCharacterEscape(char ch, int escCode)
    throws IOException, JsonGenerationException
  {
    if (escCode >= 0)
    {
      if (_outputTail >= 2)
      {
        int ptr = _outputTail - 2;
        _outputHead = ptr;
        _outputBuffer[(ptr++)] = '\\';
        _outputBuffer[ptr] = ((char)escCode);
        return;
      }
      char[] buf = _entityBuffer;
      if (buf == null) {
        buf = _allocateEntityBuffer();
      }
      _outputHead = _outputTail;
      buf[1] = ((char)escCode);
      _writer.write(buf, 0, 2);
      return;
    }
    if (escCode != -2)
    {
      if (_outputTail >= 6)
      {
        char[] buf = _outputBuffer;
        int ptr = _outputTail - 6;
        _outputHead = ptr;
        buf[ptr] = '\\';
        buf[(++ptr)] = 'u';
        if (ch > 'ÿ')
        {
          int hi = ch >> '\b' & 0xFF;
          buf[(++ptr)] = HEX_CHARS[(hi >> 4)];
          buf[(++ptr)] = HEX_CHARS[(hi & 0xF)];
          ch = (char)(ch & 0xFF);
        }
        else
        {
          buf[(++ptr)] = '0';
          buf[(++ptr)] = '0';
        }
        buf[(++ptr)] = HEX_CHARS[(ch >> '\004')];
        buf[(++ptr)] = HEX_CHARS[(ch & 0xF)];
        return;
      }
      char[] buf = _entityBuffer;
      if (buf == null) {
        buf = _allocateEntityBuffer();
      }
      _outputHead = _outputTail;
      if (ch > 'ÿ')
      {
        int hi = ch >> '\b' & 0xFF;
        int lo = ch & 0xFF;
        buf[10] = HEX_CHARS[(hi >> 4)];
        buf[11] = HEX_CHARS[(hi & 0xF)];
        buf[12] = HEX_CHARS[(lo >> 4)];
        buf[13] = HEX_CHARS[(lo & 0xF)];
        _writer.write(buf, 8, 6);
      }
      else
      {
        buf[6] = HEX_CHARS[(ch >> '\004')];
        buf[7] = HEX_CHARS[(ch & 0xF)];
        _writer.write(buf, 2, 6);
      }
      return;
    }
    String escape;
    String escape;
    if (_currentEscape == null)
    {
      escape = _characterEscapes.getEscapeSequence(ch).getValue();
    }
    else
    {
      escape = _currentEscape.getValue();
      _currentEscape = null;
    }
    int len = escape.length();
    if (_outputTail >= len)
    {
      int ptr = _outputTail - len;
      _outputHead = ptr;
      escape.getChars(0, len, _outputBuffer, ptr);
      return;
    }
    _outputHead = _outputTail;
    _writer.write(escape);
  }
  
  private int _prependOrWriteCharacterEscape(char[] buffer, int ptr, int end, char ch, int escCode)
    throws IOException, JsonGenerationException
  {
    if (escCode >= 0)
    {
      if ((ptr > 1) && (ptr < end))
      {
        ptr -= 2;
        buffer[ptr] = '\\';
        buffer[(ptr + 1)] = ((char)escCode);
      }
      else
      {
        char[] ent = _entityBuffer;
        if (ent == null) {
          ent = _allocateEntityBuffer();
        }
        ent[1] = ((char)escCode);
        _writer.write(ent, 0, 2);
      }
      return ptr;
    }
    if (escCode != -2)
    {
      if ((ptr > 5) && (ptr < end))
      {
        ptr -= 6;
        buffer[(ptr++)] = '\\';
        buffer[(ptr++)] = 'u';
        if (ch > 'ÿ')
        {
          int hi = ch >> '\b' & 0xFF;
          buffer[(ptr++)] = HEX_CHARS[(hi >> 4)];
          buffer[(ptr++)] = HEX_CHARS[(hi & 0xF)];
          ch = (char)(ch & 0xFF);
        }
        else
        {
          buffer[(ptr++)] = '0';
          buffer[(ptr++)] = '0';
        }
        buffer[(ptr++)] = HEX_CHARS[(ch >> '\004')];
        buffer[ptr] = HEX_CHARS[(ch & 0xF)];
        ptr -= 5;
      }
      else
      {
        char[] ent = _entityBuffer;
        if (ent == null) {
          ent = _allocateEntityBuffer();
        }
        _outputHead = _outputTail;
        if (ch > 'ÿ')
        {
          int hi = ch >> '\b' & 0xFF;
          int lo = ch & 0xFF;
          ent[10] = HEX_CHARS[(hi >> 4)];
          ent[11] = HEX_CHARS[(hi & 0xF)];
          ent[12] = HEX_CHARS[(lo >> 4)];
          ent[13] = HEX_CHARS[(lo & 0xF)];
          _writer.write(ent, 8, 6);
        }
        else
        {
          ent[6] = HEX_CHARS[(ch >> '\004')];
          ent[7] = HEX_CHARS[(ch & 0xF)];
          _writer.write(ent, 2, 6);
        }
      }
      return ptr;
    }
    String escape;
    String escape;
    if (_currentEscape == null)
    {
      escape = _characterEscapes.getEscapeSequence(ch).getValue();
    }
    else
    {
      escape = _currentEscape.getValue();
      _currentEscape = null;
    }
    int len = escape.length();
    if ((ptr >= len) && (ptr < end))
    {
      ptr -= len;
      escape.getChars(0, len, buffer, ptr);
    }
    else
    {
      _writer.write(escape);
    }
    return ptr;
  }
  
  private void _appendCharacterEscape(char ch, int escCode)
    throws IOException, JsonGenerationException
  {
    if (escCode >= 0)
    {
      if (_outputTail + 2 > _outputEnd) {
        _flushBuffer();
      }
      _outputBuffer[(_outputTail++)] = '\\';
      _outputBuffer[(_outputTail++)] = ((char)escCode);
      return;
    }
    if (escCode != -2)
    {
      if (_outputTail + 5 >= _outputEnd) {
        _flushBuffer();
      }
      int ptr = _outputTail;
      char[] buf = _outputBuffer;
      buf[(ptr++)] = '\\';
      buf[(ptr++)] = 'u';
      if (ch > 'ÿ')
      {
        int hi = ch >> '\b' & 0xFF;
        buf[(ptr++)] = HEX_CHARS[(hi >> 4)];
        buf[(ptr++)] = HEX_CHARS[(hi & 0xF)];
        ch = (char)(ch & 0xFF);
      }
      else
      {
        buf[(ptr++)] = '0';
        buf[(ptr++)] = '0';
      }
      buf[(ptr++)] = HEX_CHARS[(ch >> '\004')];
      buf[(ptr++)] = HEX_CHARS[(ch & 0xF)];
      _outputTail = ptr; return;
    }
    String escape;
    String escape;
    if (_currentEscape == null)
    {
      escape = _characterEscapes.getEscapeSequence(ch).getValue();
    }
    else
    {
      escape = _currentEscape.getValue();
      _currentEscape = null;
    }
    int len = escape.length();
    if (_outputTail + len > _outputEnd)
    {
      _flushBuffer();
      if (len > _outputEnd)
      {
        _writer.write(escape);
        return;
      }
    }
    escape.getChars(0, len, _outputBuffer, _outputTail);
    _outputTail += len;
  }
  
  private char[] _allocateEntityBuffer()
  {
    char[] buf = new char[14];
    
    buf[0] = '\\';
    
    buf[2] = '\\';
    buf[3] = 'u';
    buf[4] = '0';
    buf[5] = '0';
    
    buf[8] = '\\';
    buf[9] = 'u';
    _entityBuffer = buf;
    return buf;
  }
  
  protected void _flushBuffer()
    throws IOException
  {
    int len = _outputTail - _outputHead;
    if (len > 0)
    {
      int offset = _outputHead;
      _outputTail = (_outputHead = 0);
      _writer.write(_outputBuffer, offset, len);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.WriterBasedJsonGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */