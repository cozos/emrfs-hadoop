package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.TextBuffer;
import java.lang.ref.SoftReference;

public final class JsonStringEncoder
{
  private static final char[] HC = ;
  private static final byte[] HB = CharTypes.copyHexBytes();
  private static final int SURR1_FIRST = 55296;
  private static final int SURR1_LAST = 56319;
  private static final int SURR2_FIRST = 56320;
  private static final int SURR2_LAST = 57343;
  protected static final ThreadLocal<SoftReference<JsonStringEncoder>> _threadEncoder = new ThreadLocal();
  protected TextBuffer _text;
  protected ByteArrayBuilder _bytes;
  protected final char[] _qbuf;
  
  public JsonStringEncoder()
  {
    _qbuf = new char[6];
    _qbuf[0] = '\\';
    _qbuf[2] = '0';
    _qbuf[3] = '0';
  }
  
  public static JsonStringEncoder getInstance()
  {
    SoftReference<JsonStringEncoder> ref = (SoftReference)_threadEncoder.get();
    JsonStringEncoder enc = ref == null ? null : (JsonStringEncoder)ref.get();
    if (enc == null)
    {
      enc = new JsonStringEncoder();
      _threadEncoder.set(new SoftReference(enc));
    }
    return enc;
  }
  
  public char[] quoteAsString(String input)
  {
    TextBuffer textBuffer = _text;
    if (textBuffer == null) {
      _text = (textBuffer = new TextBuffer(null));
    }
    char[] outputBuffer = textBuffer.emptyAndGetCurrentSegment();
    int[] escCodes = CharTypes.get7BitOutputEscapes();
    int escCodeCount = escCodes.length;
    int inPtr = 0;
    int inputLen = input.length();
    int outPtr = 0;
    while (inPtr < inputLen)
    {
      for (;;)
      {
        char c = input.charAt(inPtr);
        if ((c < escCodeCount) && (escCodes[c] != 0)) {
          break;
        }
        if (outPtr >= outputBuffer.length)
        {
          outputBuffer = textBuffer.finishCurrentSegment();
          outPtr = 0;
        }
        outputBuffer[(outPtr++)] = c;
        inPtr++;
        if (inPtr >= inputLen) {
          break label261;
        }
      }
      char d = input.charAt(inPtr++);
      int escCode = escCodes[d];
      int length = escCode < 0 ? _appendNumeric(d, _qbuf) : _appendNamed(escCode, _qbuf);
      if (outPtr + length > outputBuffer.length)
      {
        int first = outputBuffer.length - outPtr;
        if (first > 0) {
          System.arraycopy(_qbuf, 0, outputBuffer, outPtr, first);
        }
        outputBuffer = textBuffer.finishCurrentSegment();
        int second = length - first;
        System.arraycopy(_qbuf, first, outputBuffer, 0, second);
        outPtr = second;
      }
      else
      {
        System.arraycopy(_qbuf, 0, outputBuffer, outPtr, length);
        outPtr += length;
      }
    }
    label261:
    textBuffer.setCurrentLength(outPtr);
    return textBuffer.contentsAsArray();
  }
  
  public byte[] quoteAsUTF8(String text)
  {
    ByteArrayBuilder bb = _bytes;
    if (bb == null) {
      _bytes = (bb = new ByteArrayBuilder(null));
    }
    int inputPtr = 0;
    int inputEnd = text.length();
    int outputPtr = 0;
    byte[] outputBuffer = bb.resetAndGetFirstSegment();
    while (inputPtr < inputEnd)
    {
      int[] escCodes = CharTypes.get7BitOutputEscapes();
      for (;;)
      {
        int ch = text.charAt(inputPtr);
        if ((ch > 127) || (escCodes[ch] != 0)) {
          break;
        }
        if (outputPtr >= outputBuffer.length)
        {
          outputBuffer = bb.finishCurrentSegment();
          outputPtr = 0;
        }
        outputBuffer[(outputPtr++)] = ((byte)ch);
        inputPtr++;
        if (inputPtr >= inputEnd) {
          break label492;
        }
      }
      if (outputPtr >= outputBuffer.length)
      {
        outputBuffer = bb.finishCurrentSegment();
        outputPtr = 0;
      }
      int ch = text.charAt(inputPtr++);
      if (ch <= 127)
      {
        int escape = escCodes[ch];
        
        outputPtr = _appendByte(ch, escape, bb, outputPtr);
        outputBuffer = bb.getCurrentSegment();
      }
      else
      {
        if (ch <= 2047)
        {
          outputBuffer[(outputPtr++)] = ((byte)(0xC0 | ch >> 6));
          ch = 0x80 | ch & 0x3F;
        }
        else if ((ch < 55296) || (ch > 57343))
        {
          outputBuffer[(outputPtr++)] = ((byte)(0xE0 | ch >> 12));
          if (outputPtr >= outputBuffer.length)
          {
            outputBuffer = bb.finishCurrentSegment();
            outputPtr = 0;
          }
          outputBuffer[(outputPtr++)] = ((byte)(0x80 | ch >> 6 & 0x3F));
          ch = 0x80 | ch & 0x3F;
        }
        else
        {
          if (ch > 56319) {
            _illegal(ch);
          }
          if (inputPtr >= inputEnd) {
            _illegal(ch);
          }
          ch = _convert(ch, text.charAt(inputPtr++));
          if (ch > 1114111) {
            _illegal(ch);
          }
          outputBuffer[(outputPtr++)] = ((byte)(0xF0 | ch >> 18));
          if (outputPtr >= outputBuffer.length)
          {
            outputBuffer = bb.finishCurrentSegment();
            outputPtr = 0;
          }
          outputBuffer[(outputPtr++)] = ((byte)(0x80 | ch >> 12 & 0x3F));
          if (outputPtr >= outputBuffer.length)
          {
            outputBuffer = bb.finishCurrentSegment();
            outputPtr = 0;
          }
          outputBuffer[(outputPtr++)] = ((byte)(0x80 | ch >> 6 & 0x3F));
          ch = 0x80 | ch & 0x3F;
        }
        if (outputPtr >= outputBuffer.length)
        {
          outputBuffer = bb.finishCurrentSegment();
          outputPtr = 0;
        }
        outputBuffer[(outputPtr++)] = ((byte)ch);
      }
    }
    label492:
    return _bytes.completeAndCoalesce(outputPtr);
  }
  
  public byte[] encodeAsUTF8(String text)
  {
    ByteArrayBuilder byteBuilder = _bytes;
    if (byteBuilder == null) {
      _bytes = (byteBuilder = new ByteArrayBuilder(null));
    }
    int inputPtr = 0;
    int inputEnd = text.length();
    int outputPtr = 0;
    byte[] outputBuffer = byteBuilder.resetAndGetFirstSegment();
    int outputEnd = outputBuffer.length;
    while (inputPtr < inputEnd)
    {
      int c = text.charAt(inputPtr++);
      while (c <= 127)
      {
        if (outputPtr >= outputEnd)
        {
          outputBuffer = byteBuilder.finishCurrentSegment();
          outputEnd = outputBuffer.length;
          outputPtr = 0;
        }
        outputBuffer[(outputPtr++)] = ((byte)c);
        if (inputPtr >= inputEnd) {
          break label443;
        }
        c = text.charAt(inputPtr++);
      }
      if (outputPtr >= outputEnd)
      {
        outputBuffer = byteBuilder.finishCurrentSegment();
        outputEnd = outputBuffer.length;
        outputPtr = 0;
      }
      if (c < 2048)
      {
        outputBuffer[(outputPtr++)] = ((byte)(0xC0 | c >> 6));
      }
      else if ((c < 55296) || (c > 57343))
      {
        outputBuffer[(outputPtr++)] = ((byte)(0xE0 | c >> 12));
        if (outputPtr >= outputEnd)
        {
          outputBuffer = byteBuilder.finishCurrentSegment();
          outputEnd = outputBuffer.length;
          outputPtr = 0;
        }
        outputBuffer[(outputPtr++)] = ((byte)(0x80 | c >> 6 & 0x3F));
      }
      else
      {
        if (c > 56319) {
          _illegal(c);
        }
        if (inputPtr >= inputEnd) {
          _illegal(c);
        }
        c = _convert(c, text.charAt(inputPtr++));
        if (c > 1114111) {
          _illegal(c);
        }
        outputBuffer[(outputPtr++)] = ((byte)(0xF0 | c >> 18));
        if (outputPtr >= outputEnd)
        {
          outputBuffer = byteBuilder.finishCurrentSegment();
          outputEnd = outputBuffer.length;
          outputPtr = 0;
        }
        outputBuffer[(outputPtr++)] = ((byte)(0x80 | c >> 12 & 0x3F));
        if (outputPtr >= outputEnd)
        {
          outputBuffer = byteBuilder.finishCurrentSegment();
          outputEnd = outputBuffer.length;
          outputPtr = 0;
        }
        outputBuffer[(outputPtr++)] = ((byte)(0x80 | c >> 6 & 0x3F));
      }
      if (outputPtr >= outputEnd)
      {
        outputBuffer = byteBuilder.finishCurrentSegment();
        outputEnd = outputBuffer.length;
        outputPtr = 0;
      }
      outputBuffer[(outputPtr++)] = ((byte)(0x80 | c & 0x3F));
    }
    label443:
    return _bytes.completeAndCoalesce(outputPtr);
  }
  
  private int _appendNumeric(int value, char[] qbuf)
  {
    qbuf[1] = 'u';
    
    qbuf[4] = HC[(value >> 4)];
    qbuf[5] = HC[(value & 0xF)];
    return 6;
  }
  
  private int _appendNamed(int esc, char[] qbuf)
  {
    qbuf[1] = ((char)esc);
    return 2;
  }
  
  private int _appendByte(int ch, int esc, ByteArrayBuilder bb, int ptr)
  {
    bb.setCurrentSegmentLength(ptr);
    bb.append(92);
    if (esc < 0)
    {
      bb.append(117);
      if (ch > 255)
      {
        int hi = ch >> 8;
        bb.append(HB[(hi >> 4)]);
        bb.append(HB[(hi & 0xF)]);
        ch &= 0xFF;
      }
      else
      {
        bb.append(48);
        bb.append(48);
      }
      bb.append(HB[(ch >> 4)]);
      bb.append(HB[(ch & 0xF)]);
    }
    else
    {
      bb.append((byte)esc);
    }
    return bb.getCurrentSegmentLength();
  }
  
  private static int _convert(int p1, int p2)
  {
    if ((p2 < 56320) || (p2 > 57343)) {
      throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(p1) + ", second 0x" + Integer.toHexString(p2) + "; illegal combination");
    }
    return 65536 + (p1 - 55296 << 10) + (p2 - 56320);
  }
  
  private static void _illegal(int c)
  {
    throw new IllegalArgumentException(UTF8Writer.illegalSurrogateDesc(c));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.JsonStringEncoder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */