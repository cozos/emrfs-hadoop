package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Base64Variant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.FormatFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerationException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonStreamContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.ObjectCodec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.PrettyPrinter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.SerializableString;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.base.GeneratorBase;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.IOContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.json.JsonWriteContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class CBORGenerator
  extends GeneratorBase
{
  static final int BYTE_BUFFER_FOR_OUTPUT = 16000;
  private static final int MAX_LONG_STRING_CHARS = 3996;
  private static final int MAX_LONG_STRING_BYTES = 11991;
  private static final int MIN_BUFFER_LENGTH = 770;
  private static final long MIN_INT_AS_LONG = -2147483648L;
  private static final long MAX_INT_AS_LONG = 2147483647L;
  protected final IOContext _ioContext;
  protected final OutputStream _out;
  protected int _formatFeatures;
  protected boolean _cfgMinimalInts;
  protected byte[] _outputBuffer;
  
  public static enum Feature
    implements FormatFeature
  {
    WRITE_MINIMAL_INTS(true),  WRITE_TYPE_HEADER(false);
    
    protected final boolean _defaultState;
    protected final int _mask;
    
    public static int collectDefaults()
    {
      int flags = 0;
      for (Feature f : values()) {
        if (f.enabledByDefault()) {
          flags |= f.getMask();
        }
      }
      return flags;
    }
    
    private Feature(boolean defaultState)
    {
      _defaultState = defaultState;
      _mask = (1 << ordinal());
    }
    
    public boolean enabledByDefault()
    {
      return _defaultState;
    }
    
    public boolean enabledIn(int flags)
    {
      return (flags & getMask()) != 0;
    }
    
    public int getMask()
    {
      return _mask;
    }
  }
  
  protected int _outputTail = 0;
  protected final int _outputEnd;
  protected char[] _charBuffer;
  protected final int _charBufferLength;
  protected int _bytesWritten;
  protected boolean _bufferRecyclable;
  private static final int MAX_SHORT_STRING_CHARS = 23;
  private static final int MAX_SHORT_STRING_BYTES = 71;
  private static final int MAX_MEDIUM_STRING_CHARS = 255;
  private static final int MAX_MEDIUM_STRING_BYTES = 768;
  
  public CBORGenerator(IOContext ctxt, int jsonFeatures, int formatFeatures, ObjectCodec codec, OutputStream out)
  {
    super(jsonFeatures, codec);
    _formatFeatures = formatFeatures;
    _cfgMinimalInts = Feature.WRITE_MINIMAL_INTS.enabledIn(formatFeatures);
    _ioContext = ctxt;
    _out = out;
    _bufferRecyclable = true;
    _outputBuffer = ctxt.allocWriteEncodingBuffer(16000);
    _outputEnd = _outputBuffer.length;
    _charBuffer = ctxt.allocConcatBuffer();
    _charBufferLength = _charBuffer.length;
    if (_outputEnd < 770) {
      throw new IllegalStateException("Internal encoding buffer length (" + _outputEnd + ") too short, must be at least " + 770);
    }
  }
  
  public CBORGenerator(IOContext ctxt, int jsonFeatures, int formatFeatures, ObjectCodec codec, OutputStream out, byte[] outputBuffer, int offset, boolean bufferRecyclable)
  {
    super(jsonFeatures, codec);
    _formatFeatures = formatFeatures;
    _cfgMinimalInts = Feature.WRITE_MINIMAL_INTS.enabledIn(formatFeatures);
    _ioContext = ctxt;
    _out = out;
    _bufferRecyclable = bufferRecyclable;
    _outputTail = offset;
    _outputBuffer = outputBuffer;
    _outputEnd = _outputBuffer.length;
    _charBuffer = ctxt.allocConcatBuffer();
    _charBufferLength = _charBuffer.length;
    if (_outputEnd < 770) {
      throw new IllegalStateException("Internal encoding buffer length (" + _outputEnd + ") too short, must be at least " + 770);
    }
  }
  
  public Version version()
  {
    return PackageVersion.VERSION;
  }
  
  public boolean canWriteBinaryNatively()
  {
    return true;
  }
  
  public JsonGenerator useDefaultPrettyPrinter()
  {
    return this;
  }
  
  public JsonGenerator setPrettyPrinter(PrettyPrinter pp)
  {
    return this;
  }
  
  public Object getOutputTarget()
  {
    return _out;
  }
  
  public int getOutputBuffered()
  {
    return _outputTail;
  }
  
  public int getFormatFeatures()
  {
    return _formatFeatures;
  }
  
  public JsonGenerator overrideFormatFeatures(int values, int mask)
  {
    _formatFeatures = (_formatFeatures & (mask ^ 0xFFFFFFFF) | values & mask);
    return this;
  }
  
  public final void writeFieldName(String name)
    throws IOException
  {
    if (_writeContext.writeFieldName(name) == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    _writeString(name);
  }
  
  public final void writeFieldName(SerializableString name)
    throws IOException
  {
    if (_writeContext.writeFieldName(name.getValue()) == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    byte[] raw = name.asUnquotedUTF8();
    int len = raw.length;
    if (len == 0)
    {
      _writeByte((byte)96);
      return;
    }
    _writeLengthMarker(96, len);
    _writeBytes(raw, 0, len);
  }
  
  public final void writeStringField(String fieldName, String value)
    throws IOException
  {
    if (_writeContext.writeFieldName(fieldName) == 4) {
      _reportError("Can not write a field name, expecting a value");
    }
    _writeString(fieldName);
    if (value == null)
    {
      writeNull();
      return;
    }
    _verifyValueWrite("write String value");
    _writeString(value);
  }
  
  public CBORGenerator enable(Feature f)
  {
    _formatFeatures |= f.getMask();
    if (f == Feature.WRITE_MINIMAL_INTS) {
      _cfgMinimalInts = true;
    }
    return this;
  }
  
  public CBORGenerator disable(Feature f)
  {
    _formatFeatures &= (f.getMask() ^ 0xFFFFFFFF);
    if (f == Feature.WRITE_MINIMAL_INTS) {
      _cfgMinimalInts = false;
    }
    return this;
  }
  
  public final boolean isEnabled(Feature f)
  {
    return (_formatFeatures & f.getMask()) != 0;
  }
  
  public CBORGenerator configure(Feature f, boolean state)
  {
    if (state) {
      enable(f);
    } else {
      disable(f);
    }
    return this;
  }
  
  public void writeTag(int tagId)
    throws IOException
  {
    if (tagId < 0) {
      throw new IllegalArgumentException("Can not write negative tag ids (" + tagId + ")");
    }
    _writeLengthMarker(192, tagId);
  }
  
  public void writeRaw(byte b)
    throws IOException
  {
    _writeByte(b);
  }
  
  public void writeBytes(byte[] data, int offset, int len)
    throws IOException
  {
    _writeBytes(data, offset, len);
  }
  
  public final void writeStartArray()
    throws IOException
  {
    _verifyValueWrite("start an array");
    _writeContext = _writeContext.createChildArrayContext();
    _writeByte((byte)-97);
  }
  
  public void writeStartArray(int size)
    throws IOException
  {
    _verifyValueWrite("start an array");
    _writeContext = _writeContext.createChildArrayContext();
    
    _writeByte((byte)-97);
  }
  
  public final void writeEndArray()
    throws IOException
  {
    if (!_writeContext.inArray()) {
      _reportError("Current context not an ARRAY but " + _writeContext.getTypeDesc());
    }
    _writeByte((byte)-1);
    _writeContext = _writeContext.getParent();
  }
  
  public final void writeStartObject()
    throws IOException
  {
    _verifyValueWrite("start an object");
    _writeContext = _writeContext.createChildObjectContext();
    _writeByte((byte)-65);
  }
  
  public final void writeEndObject()
    throws IOException
  {
    if (!_writeContext.inObject()) {
      _reportError("Current context not an object but " + _writeContext.getTypeDesc());
    }
    _writeContext = _writeContext.getParent();
    _writeByte((byte)-1);
  }
  
  public void writeString(String text)
    throws IOException, JsonGenerationException
  {
    if (text == null)
    {
      writeNull();
      return;
    }
    _verifyValueWrite("write String value");
    _writeString(text);
  }
  
  public final void writeString(SerializableString sstr)
    throws IOException
  {
    _verifyValueWrite("write String value");
    byte[] raw = sstr.asUnquotedUTF8();
    int len = raw.length;
    if (len == 0)
    {
      _writeByte((byte)96);
      return;
    }
    _writeLengthMarker(96, len);
    _writeBytes(raw, 0, len);
  }
  
  public void writeString(char[] text, int offset, int len)
    throws IOException
  {
    _verifyValueWrite("write String value");
    if (len == 0)
    {
      _writeByte((byte)96);
      return;
    }
    _writeString(text, offset, len);
  }
  
  public void writeRawUTF8String(byte[] raw, int offset, int len)
    throws IOException
  {
    _verifyValueWrite("write String value");
    if (len == 0)
    {
      _writeByte((byte)96);
      return;
    }
    _writeLengthMarker(96, len);
    _writeBytes(raw, 0, len);
  }
  
  public final void writeUTF8String(byte[] text, int offset, int len)
    throws IOException
  {
    writeRawUTF8String(text, offset, len);
  }
  
  public void writeRaw(String text)
    throws IOException
  {
    throw _notSupported();
  }
  
  public void writeRaw(String text, int offset, int len)
    throws IOException
  {
    throw _notSupported();
  }
  
  public void writeRaw(char[] text, int offset, int len)
    throws IOException
  {
    throw _notSupported();
  }
  
  public void writeRaw(char c)
    throws IOException
  {
    throw _notSupported();
  }
  
  public void writeRawValue(String text)
    throws IOException
  {
    throw _notSupported();
  }
  
  public void writeRawValue(String text, int offset, int len)
    throws IOException
  {
    throw _notSupported();
  }
  
  public void writeRawValue(char[] text, int offset, int len)
    throws IOException
  {
    throw _notSupported();
  }
  
  public void writeBinary(Base64Variant b64variant, byte[] data, int offset, int len)
    throws IOException
  {
    if (data == null)
    {
      writeNull();
      return;
    }
    _verifyValueWrite("write Binary value");
    _writeLengthMarker(64, len);
    _writeBytes(data, offset, len);
  }
  
  public int writeBinary(InputStream data, int dataLength)
    throws IOException
  {
    if (dataLength < 0) {
      throw new UnsupportedOperationException("Must pass actual length for CBOR encoded data");
    }
    _verifyValueWrite("write Binary value");
    
    _writeLengthMarker(64, dataLength);
    int missing = _writeBytes(data, dataLength);
    if (missing > 0) {
      _reportError("Too few bytes available: missing " + missing + " bytes (out of " + dataLength + ")");
    }
    return dataLength;
  }
  
  public int writeBinary(Base64Variant b64variant, InputStream data, int dataLength)
    throws IOException
  {
    return writeBinary(data, dataLength);
  }
  
  public void writeBoolean(boolean state)
    throws IOException
  {
    _verifyValueWrite("write boolean value");
    if (state) {
      _writeByte((byte)-11);
    } else {
      _writeByte((byte)-12);
    }
  }
  
  public void writeNull()
    throws IOException
  {
    _verifyValueWrite("write null value");
    _writeByte((byte)-10);
  }
  
  public void writeNumber(int i)
    throws IOException
  {
    _verifyValueWrite("write number");
    int marker;
    int marker;
    if (i < 0)
    {
      i = -i - 1;
      marker = 32;
    }
    else
    {
      marker = 0;
    }
    _ensureRoomForOutput(5);
    byte b0;
    if (_cfgMinimalInts)
    {
      if (i < 24)
      {
        _outputBuffer[(_outputTail++)] = ((byte)(marker + i));
        return;
      }
      if (i <= 255)
      {
        _outputBuffer[(_outputTail++)] = ((byte)(marker + 24));
        _outputBuffer[(_outputTail++)] = ((byte)i);
        return;
      }
      byte b0 = (byte)i;
      i >>= 8;
      if (i <= 255)
      {
        _outputBuffer[(_outputTail++)] = ((byte)(marker + 25));
        _outputBuffer[(_outputTail++)] = ((byte)i);
        _outputBuffer[(_outputTail++)] = b0;
      }
    }
    else
    {
      b0 = (byte)i;
      i >>= 8;
    }
    _outputBuffer[(_outputTail++)] = ((byte)(marker + 26));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 16));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 8));
    _outputBuffer[(_outputTail++)] = ((byte)i);
    _outputBuffer[(_outputTail++)] = b0;
  }
  
  public void writeNumber(long l)
    throws IOException
  {
    if (_cfgMinimalInts) {
      if ((l <= 2147483647L) && (l >= -2147483648L))
      {
        writeNumber((int)l);
        return;
      }
    }
    _verifyValueWrite("write number");
    _ensureRoomForOutput(9);
    if (l < 0L)
    {
      l += 1L;
      l = -l;
      _outputBuffer[(_outputTail++)] = 59;
    }
    else
    {
      _outputBuffer[(_outputTail++)] = 27;
    }
    int i = (int)(l >> 32);
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 24));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 16));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 8));
    _outputBuffer[(_outputTail++)] = ((byte)i);
    i = (int)l;
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 24));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 16));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 8));
    _outputBuffer[(_outputTail++)] = ((byte)i);
  }
  
  public void writeNumber(BigInteger v)
    throws IOException
  {
    if (v == null)
    {
      writeNull();
      return;
    }
    _verifyValueWrite("write number");
    if (v.signum() < 0)
    {
      _writeByte((byte)-61);
      v = v.negate();
    }
    else
    {
      _writeByte((byte)-62);
    }
    byte[] data = v.toByteArray();
    int len = data.length;
    _writeLengthMarker(64, len);
    _writeBytes(data, 0, len);
  }
  
  public void writeNumber(double d)
    throws IOException
  {
    _verifyValueWrite("write number");
    _ensureRoomForOutput(11);
    
    long l = Double.doubleToRawLongBits(d);
    _outputBuffer[(_outputTail++)] = -5;
    
    int i = (int)(l >> 32);
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 24));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 16));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 8));
    _outputBuffer[(_outputTail++)] = ((byte)i);
    i = (int)l;
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 24));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 16));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 8));
    _outputBuffer[(_outputTail++)] = ((byte)i);
  }
  
  public void writeNumber(float f)
    throws IOException
  {
    _ensureRoomForOutput(6);
    _verifyValueWrite("write number");
    
    int i = Float.floatToRawIntBits(f);
    _outputBuffer[(_outputTail++)] = -6;
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 24));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 16));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 8));
    _outputBuffer[(_outputTail++)] = ((byte)i);
  }
  
  public void writeNumber(BigDecimal dec)
    throws IOException
  {
    if (dec == null)
    {
      writeNull();
      return;
    }
    _verifyValueWrite("write number");
    
    _writeByte((byte)-59);
    _writeByte((byte)-126);
    
    int scale = dec.scale();
    _writeIntValue(scale);
    
    BigInteger unscaled = dec.unscaledValue();
    byte[] data = unscaled.toByteArray();
    if (data.length <= 4)
    {
      int v = data[0];
      for (int i = 1; i < data.length; i++) {
        v = (v << 8) + (data[i] & 0xFF);
      }
      _writeIntValue(v);
    }
    else if (data.length <= 8)
    {
      long v = data[0];
      for (int i = 1; i < data.length; i++) {
        v = (v << 8) + (data[i] & 0xFF);
      }
      _writeLongValue(v);
    }
    else
    {
      int len = data.length;
      _writeLengthMarker(64, len);
      _writeBytes(data, 0, len);
    }
  }
  
  public void writeNumber(String encodedValue)
    throws IOException, JsonGenerationException, UnsupportedOperationException
  {
    writeString(encodedValue);
  }
  
  protected final void _verifyValueWrite(String typeMsg)
    throws IOException
  {
    int status = _writeContext.writeValue();
    if (status == 5) {
      _reportError("Can not " + typeMsg + ", expecting field name");
    }
  }
  
  public final void flush()
    throws IOException
  {
    _flushBuffer();
    if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
      _out.flush();
    }
  }
  
  public void close()
    throws IOException
  {
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
    super.close();
    _flushBuffer();
    if ((_ioContext.isResourceManaged()) || (isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET))) {
      _out.close();
    } else {
      _out.flush();
    }
    _releaseBuffers();
  }
  
  protected final void _writeString(String name)
    throws IOException
  {
    int len = name.length();
    if (len == 0)
    {
      _writeByte((byte)96);
      return;
    }
    if (len <= 23)
    {
      _ensureSpace(71);
      int actual = _encode(_outputTail + 1, name, len);
      byte[] buf = _outputBuffer;
      int ix = _outputTail;
      if (actual < 23)
      {
        buf[(ix++)] = ((byte)(96 + actual));
        _outputTail = (ix + actual);
        return;
      }
      System.arraycopy(buf, ix + 1, buf, ix + 2, actual);
      buf[(ix++)] = 120;
      buf[(ix++)] = ((byte)actual);
      _outputTail = (ix + actual);
      return;
    }
    char[] cbuf = _charBuffer;
    if (len > cbuf.length) {
      _charBuffer = (cbuf = new char[Math.max(_charBuffer.length + 32, len)]);
    }
    name.getChars(0, len, cbuf, 0);
    _writeString(cbuf, 0, len);
  }
  
  protected final void _ensureSpace(int needed)
    throws IOException
  {
    if (_outputTail + needed + 3 > _outputEnd) {
      _flushBuffer();
    }
  }
  
  protected final void _writeString(char[] text, int offset, int len)
    throws IOException
  {
    if (len <= 23)
    {
      _ensureSpace(71);
      int actual = _encode(_outputTail + 1, text, offset, offset + len);
      byte[] buf = _outputBuffer;
      int ix = _outputTail;
      if (actual < 23)
      {
        buf[(ix++)] = ((byte)(96 + actual));
        _outputTail = (ix + actual);
        return;
      }
      System.arraycopy(buf, ix + 1, buf, ix + 2, actual);
      buf[(ix++)] = 120;
      buf[(ix++)] = ((byte)actual);
      _outputTail = (ix + actual);
      return;
    }
    if (len <= 255)
    {
      _ensureSpace(768);
      int actual = _encode(_outputTail + 2, text, offset, offset + len);
      byte[] buf = _outputBuffer;
      int ix = _outputTail;
      if (actual < 255)
      {
        buf[(ix++)] = 120;
        buf[(ix++)] = ((byte)actual);
        _outputTail = (ix + actual);
        return;
      }
      System.arraycopy(buf, ix + 2, buf, ix + 3, actual);
      buf[(ix++)] = 121;
      buf[(ix++)] = ((byte)(actual >> 8));
      buf[(ix++)] = ((byte)actual);
      _outputTail = (ix + actual);
      return;
    }
    if (len <= 3996)
    {
      _ensureSpace(11991);
      int ix = _outputTail;
      int actual = _encode(ix + 3, text, offset, offset + len);
      byte[] buf = _outputBuffer;
      buf[(ix++)] = 121;
      buf[(ix++)] = ((byte)(actual >> 8));
      buf[(ix++)] = ((byte)actual);
      _outputTail = (ix + actual);
      return;
    }
    _writeChunkedString(text, offset, len);
  }
  
  protected final void _writeChunkedString(char[] text, int offset, int len)
    throws IOException
  {
    _writeByte((byte)Byte.MAX_VALUE);
    while (len > 3996)
    {
      _ensureSpace(11991);
      int ix = _outputTail;
      int actual = _encode(_outputTail + 3, text, offset, offset + 3996);
      byte[] buf = _outputBuffer;
      buf[(ix++)] = 121;
      buf[(ix++)] = ((byte)(actual >> 8));
      buf[(ix++)] = ((byte)actual);
      _outputTail = (ix + actual);
      offset += 3996;
      len -= 3996;
    }
    if (len > 0) {
      _writeString(text, offset, len);
    }
    _writeByte((byte)-1);
  }
  
  private final int _encode(int outputPtr, char[] str, int i, int end)
  {
    byte[] outBuf = _outputBuffer;
    int outputStart = outputPtr;
    do
    {
      int c = str[i];
      if (c > 127) {
        return _shortUTF8Encode2(str, i, end, outputPtr, outputStart);
      }
      outBuf[(outputPtr++)] = ((byte)c);
      i++;
    } while (i < end);
    return outputPtr - outputStart;
  }
  
  private final int _shortUTF8Encode2(char[] str, int i, int end, int outputPtr, int outputStart)
  {
    byte[] outBuf = _outputBuffer;
    while (i < end)
    {
      int c = str[(i++)];
      if (c <= 127)
      {
        outBuf[(outputPtr++)] = ((byte)c);
      }
      else if (c < 2048)
      {
        outBuf[(outputPtr++)] = ((byte)(0xC0 | c >> 6));
        outBuf[(outputPtr++)] = ((byte)(0x80 | c & 0x3F));
      }
      else if ((c < 55296) || (c > 57343))
      {
        outBuf[(outputPtr++)] = ((byte)(0xE0 | c >> 12));
        outBuf[(outputPtr++)] = ((byte)(0x80 | c >> 6 & 0x3F));
        outBuf[(outputPtr++)] = ((byte)(0x80 | c & 0x3F));
      }
      else
      {
        if (c > 56319) {
          _throwIllegalSurrogate(c);
        }
        if (i >= end) {
          _throwIllegalSurrogate(c);
        }
        c = _convertSurrogate(c, str[(i++)]);
        if (c > 1114111) {
          _throwIllegalSurrogate(c);
        }
        outBuf[(outputPtr++)] = ((byte)(0xF0 | c >> 18));
        outBuf[(outputPtr++)] = ((byte)(0x80 | c >> 12 & 0x3F));
        outBuf[(outputPtr++)] = ((byte)(0x80 | c >> 6 & 0x3F));
        outBuf[(outputPtr++)] = ((byte)(0x80 | c & 0x3F));
      }
    }
    return outputPtr - outputStart;
  }
  
  private final int _encode(int outputPtr, String str, int len)
  {
    byte[] outBuf = _outputBuffer;
    int outputStart = outputPtr;
    for (int i = 0; i < len; i++)
    {
      int c = str.charAt(i);
      if (c > 127) {
        return _encode2(i, outputPtr, str, len, outputStart);
      }
      outBuf[(outputPtr++)] = ((byte)c);
    }
    return outputPtr - outputStart;
  }
  
  private final int _encode2(int i, int outputPtr, String str, int len, int outputStart)
  {
    byte[] outBuf = _outputBuffer;
    while (i < len)
    {
      int c = str.charAt(i++);
      if (c <= 127)
      {
        outBuf[(outputPtr++)] = ((byte)c);
      }
      else if (c < 2048)
      {
        outBuf[(outputPtr++)] = ((byte)(0xC0 | c >> 6));
        outBuf[(outputPtr++)] = ((byte)(0x80 | c & 0x3F));
      }
      else if ((c < 55296) || (c > 57343))
      {
        outBuf[(outputPtr++)] = ((byte)(0xE0 | c >> 12));
        outBuf[(outputPtr++)] = ((byte)(0x80 | c >> 6 & 0x3F));
        outBuf[(outputPtr++)] = ((byte)(0x80 | c & 0x3F));
      }
      else
      {
        if (c > 56319) {
          _throwIllegalSurrogate(c);
        }
        if (i >= len) {
          _throwIllegalSurrogate(c);
        }
        c = _convertSurrogate(c, str.charAt(i++));
        if (c > 1114111) {
          _throwIllegalSurrogate(c);
        }
        outBuf[(outputPtr++)] = ((byte)(0xF0 | c >> 18));
        outBuf[(outputPtr++)] = ((byte)(0x80 | c >> 12 & 0x3F));
        outBuf[(outputPtr++)] = ((byte)(0x80 | c >> 6 & 0x3F));
        outBuf[(outputPtr++)] = ((byte)(0x80 | c & 0x3F));
      }
    }
    return outputPtr - outputStart;
  }
  
  private int _convertSurrogate(int firstPart, int secondPart)
  {
    if ((secondPart < 56320) || (secondPart > 57343)) {
      throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(firstPart) + ", second 0x" + Integer.toHexString(secondPart) + "; illegal combination");
    }
    return 65536 + (firstPart - 55296 << 10) + (secondPart - 56320);
  }
  
  private void _throwIllegalSurrogate(int code)
  {
    if (code > 1114111) {
      throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(code) + ") to output; max is 0x10FFFF as per RFC 4627");
    }
    if (code >= 55296)
    {
      if (code <= 56319) {
        throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(code) + ")");
      }
      throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(code) + ")");
    }
    throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(code) + ") to output");
  }
  
  private final void _ensureRoomForOutput(int needed)
    throws IOException
  {
    if (_outputTail + needed >= _outputEnd) {
      _flushBuffer();
    }
  }
  
  private final void _writeIntValue(int i)
    throws IOException
  {
    int marker;
    int marker;
    if (i < 0)
    {
      i++;
      i = -1;
      marker = 32;
    }
    else
    {
      marker = 0;
    }
    _writeLengthMarker(marker, i);
  }
  
  private final void _writeLongValue(long l)
    throws IOException
  {
    _ensureRoomForOutput(9);
    if (l < 0L)
    {
      l += 1L;
      l = -1L;
      _outputBuffer[(_outputTail++)] = 59;
    }
    else
    {
      _outputBuffer[(_outputTail++)] = 27;
    }
    int i = (int)(l >> 32);
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 24));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 16));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 8));
    _outputBuffer[(_outputTail++)] = ((byte)i);
    i = (int)l;
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 24));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 16));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 8));
    _outputBuffer[(_outputTail++)] = ((byte)i);
  }
  
  private final void _writeLengthMarker(int majorType, int i)
    throws IOException
  {
    _ensureRoomForOutput(5);
    if (i < 24)
    {
      _outputBuffer[(_outputTail++)] = ((byte)(majorType + i));
      return;
    }
    if (i <= 255)
    {
      _outputBuffer[(_outputTail++)] = ((byte)(majorType + 24));
      _outputBuffer[(_outputTail++)] = ((byte)i);
      return;
    }
    byte b0 = (byte)i;
    i >>= 8;
    if (i <= 255)
    {
      _outputBuffer[(_outputTail++)] = ((byte)(majorType + 25));
      _outputBuffer[(_outputTail++)] = ((byte)i);
      _outputBuffer[(_outputTail++)] = b0;
      return;
    }
    _outputBuffer[(_outputTail++)] = ((byte)(majorType + 26));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 16));
    _outputBuffer[(_outputTail++)] = ((byte)(i >> 8));
    _outputBuffer[(_outputTail++)] = ((byte)i);
    _outputBuffer[(_outputTail++)] = b0;
  }
  
  private final void _writeByte(byte b)
    throws IOException
  {
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    _outputBuffer[(_outputTail++)] = b;
  }
  
  private final void _writeBytes(byte[] data, int offset, int len)
    throws IOException
  {
    if (len == 0) {
      return;
    }
    if (_outputTail + len >= _outputEnd)
    {
      _writeBytesLong(data, offset, len);
      return;
    }
    System.arraycopy(data, offset, _outputBuffer, _outputTail, len);
    _outputTail += len;
  }
  
  private final int _writeBytes(InputStream in, int bytesLeft)
    throws IOException
  {
    while (bytesLeft > 0)
    {
      int room = _outputEnd - _outputTail;
      if (room <= 0)
      {
        _flushBuffer();
        room = _outputEnd - _outputTail;
      }
      int count = in.read(_outputBuffer, _outputTail, room);
      if (count < 0) {
        break;
      }
      _outputTail += count;
      bytesLeft -= count;
    }
    return bytesLeft;
  }
  
  private final void _writeBytesLong(byte[] data, int offset, int len)
    throws IOException
  {
    if (_outputTail >= _outputEnd) {
      _flushBuffer();
    }
    for (;;)
    {
      int currLen = Math.min(len, _outputEnd - _outputTail);
      System.arraycopy(data, offset, _outputBuffer, _outputTail, currLen);
      _outputTail += currLen;
      if (len -= currLen == 0) {
        break;
      }
      offset += currLen;
      _flushBuffer();
    }
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
  
  protected final void _flushBuffer()
    throws IOException
  {
    if (_outputTail > 0)
    {
      _bytesWritten += _outputTail;
      _out.write(_outputBuffer, 0, _outputTail);
      _outputTail = 0;
    }
  }
  
  protected UnsupportedOperationException _notSupported()
  {
    return new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.dataformat.cbor.CBORGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */