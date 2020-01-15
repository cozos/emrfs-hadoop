package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class CodedInputStream
{
  private final byte[] buffer;
  private int bufferSize;
  private int bufferSizeAfterLimit;
  private int bufferPos;
  private final InputStream input;
  private int lastTag;
  private int totalBytesRetired;
  
  public static CodedInputStream newInstance(InputStream input)
  {
    return new CodedInputStream(input);
  }
  
  public static CodedInputStream newInstance(byte[] buf)
  {
    return newInstance(buf, 0, buf.length);
  }
  
  public static CodedInputStream newInstance(byte[] buf, int off, int len)
  {
    CodedInputStream result = new CodedInputStream(buf, off, len);
    try
    {
      result.pushLimit(len);
    }
    catch (InvalidProtocolBufferException ex)
    {
      throw new IllegalArgumentException(ex);
    }
    return result;
  }
  
  public int readTag()
    throws IOException
  {
    if (isAtEnd())
    {
      lastTag = 0;
      return 0;
    }
    lastTag = readRawVarint32();
    if (WireFormat.getTagFieldNumber(lastTag) == 0) {
      throw InvalidProtocolBufferException.invalidTag();
    }
    return lastTag;
  }
  
  public void checkLastTagWas(int value)
    throws InvalidProtocolBufferException
  {
    if (lastTag != value) {
      throw InvalidProtocolBufferException.invalidEndTag();
    }
  }
  
  public boolean skipField(int tag)
    throws IOException
  {
    switch (WireFormat.getTagWireType(tag))
    {
    case 0: 
      readInt32();
      return true;
    case 1: 
      readRawLittleEndian64();
      return true;
    case 2: 
      skipRawBytes(readRawVarint32());
      return true;
    case 3: 
      skipMessage();
      checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(tag), 4));
      
      return true;
    case 4: 
      return false;
    case 5: 
      readRawLittleEndian32();
      return true;
    }
    throw InvalidProtocolBufferException.invalidWireType();
  }
  
  public void skipMessage()
    throws IOException
  {
    for (;;)
    {
      int tag = readTag();
      if ((tag == 0) || (!skipField(tag))) {
        return;
      }
    }
  }
  
  public double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(readRawLittleEndian64());
  }
  
  public float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(readRawLittleEndian32());
  }
  
  public long readUInt64()
    throws IOException
  {
    return readRawVarint64();
  }
  
  public long readInt64()
    throws IOException
  {
    return readRawVarint64();
  }
  
  public int readInt32()
    throws IOException
  {
    return readRawVarint32();
  }
  
  public long readFixed64()
    throws IOException
  {
    return readRawLittleEndian64();
  }
  
  public int readFixed32()
    throws IOException
  {
    return readRawLittleEndian32();
  }
  
  public boolean readBool()
    throws IOException
  {
    return readRawVarint32() != 0;
  }
  
  public String readString()
    throws IOException
  {
    int size = readRawVarint32();
    if ((size <= bufferSize - bufferPos) && (size > 0))
    {
      String result = new String(buffer, bufferPos, size, "UTF-8");
      bufferPos += size;
      return result;
    }
    return new String(readRawBytes(size), "UTF-8");
  }
  
  public void readGroup(int fieldNumber, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    if (recursionDepth >= recursionLimit) {
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    recursionDepth += 1;
    builder.mergeFrom(this, extensionRegistry);
    checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
    
    recursionDepth -= 1;
  }
  
  public <T extends MessageLite> T readGroup(int fieldNumber, Parser<T> parser, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    if (recursionDepth >= recursionLimit) {
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    recursionDepth += 1;
    T result = (MessageLite)parser.parsePartialFrom(this, extensionRegistry);
    checkLastTagWas(WireFormat.makeTag(fieldNumber, 4));
    
    recursionDepth -= 1;
    return result;
  }
  
  @Deprecated
  public void readUnknownGroup(int fieldNumber, MessageLite.Builder builder)
    throws IOException
  {
    readGroup(fieldNumber, builder, null);
  }
  
  public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    int length = readRawVarint32();
    if (recursionDepth >= recursionLimit) {
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    int oldLimit = pushLimit(length);
    recursionDepth += 1;
    builder.mergeFrom(this, extensionRegistry);
    checkLastTagWas(0);
    recursionDepth -= 1;
    popLimit(oldLimit);
  }
  
  public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistry)
    throws IOException
  {
    int length = readRawVarint32();
    if (recursionDepth >= recursionLimit) {
      throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    int oldLimit = pushLimit(length);
    recursionDepth += 1;
    T result = (MessageLite)parser.parsePartialFrom(this, extensionRegistry);
    checkLastTagWas(0);
    recursionDepth -= 1;
    popLimit(oldLimit);
    return result;
  }
  
  public ByteString readBytes()
    throws IOException
  {
    int size = readRawVarint32();
    if (size == 0) {
      return ByteString.EMPTY;
    }
    if ((size <= bufferSize - bufferPos) && (size > 0))
    {
      ByteString result = ByteString.copyFrom(buffer, bufferPos, size);
      bufferPos += size;
      return result;
    }
    return ByteString.copyFrom(readRawBytes(size));
  }
  
  public int readUInt32()
    throws IOException
  {
    return readRawVarint32();
  }
  
  public int readEnum()
    throws IOException
  {
    return readRawVarint32();
  }
  
  public int readSFixed32()
    throws IOException
  {
    return readRawLittleEndian32();
  }
  
  public long readSFixed64()
    throws IOException
  {
    return readRawLittleEndian64();
  }
  
  public int readSInt32()
    throws IOException
  {
    return decodeZigZag32(readRawVarint32());
  }
  
  public long readSInt64()
    throws IOException
  {
    return decodeZigZag64(readRawVarint64());
  }
  
  public int readRawVarint32()
    throws IOException
  {
    byte tmp = readRawByte();
    if (tmp >= 0) {
      return tmp;
    }
    int result = tmp & 0x7F;
    if ((tmp = readRawByte()) >= 0)
    {
      result |= tmp << 7;
    }
    else
    {
      result |= (tmp & 0x7F) << 7;
      if ((tmp = readRawByte()) >= 0)
      {
        result |= tmp << 14;
      }
      else
      {
        result |= (tmp & 0x7F) << 14;
        if ((tmp = readRawByte()) >= 0)
        {
          result |= tmp << 21;
        }
        else
        {
          result |= (tmp & 0x7F) << 21;
          result |= (tmp = readRawByte()) << 28;
          if (tmp < 0)
          {
            for (int i = 0; i < 5; i++) {
              if (readRawByte() >= 0) {
                return result;
              }
            }
            throw InvalidProtocolBufferException.malformedVarint();
          }
        }
      }
    }
    return result;
  }
  
  static int readRawVarint32(InputStream input)
    throws IOException
  {
    int firstByte = input.read();
    if (firstByte == -1) {
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    return readRawVarint32(firstByte, input);
  }
  
  public static int readRawVarint32(int firstByte, InputStream input)
    throws IOException
  {
    if ((firstByte & 0x80) == 0) {
      return firstByte;
    }
    int result = firstByte & 0x7F;
    for (int offset = 7; offset < 32; offset += 7)
    {
      int b = input.read();
      if (b == -1) {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
      result |= (b & 0x7F) << offset;
      if ((b & 0x80) == 0) {
        return result;
      }
    }
    for (; offset < 64; offset += 7)
    {
      int b = input.read();
      if (b == -1) {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
      if ((b & 0x80) == 0) {
        return result;
      }
    }
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  public long readRawVarint64()
    throws IOException
  {
    int shift = 0;
    long result = 0L;
    while (shift < 64)
    {
      byte b = readRawByte();
      result |= (b & 0x7F) << shift;
      if ((b & 0x80) == 0) {
        return result;
      }
      shift += 7;
    }
    throw InvalidProtocolBufferException.malformedVarint();
  }
  
  public int readRawLittleEndian32()
    throws IOException
  {
    byte b1 = readRawByte();
    byte b2 = readRawByte();
    byte b3 = readRawByte();
    byte b4 = readRawByte();
    return b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16 | (b4 & 0xFF) << 24;
  }
  
  public long readRawLittleEndian64()
    throws IOException
  {
    byte b1 = readRawByte();
    byte b2 = readRawByte();
    byte b3 = readRawByte();
    byte b4 = readRawByte();
    byte b5 = readRawByte();
    byte b6 = readRawByte();
    byte b7 = readRawByte();
    byte b8 = readRawByte();
    return b1 & 0xFF | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16 | (b4 & 0xFF) << 24 | (b5 & 0xFF) << 32 | (b6 & 0xFF) << 40 | (b7 & 0xFF) << 48 | (b8 & 0xFF) << 56;
  }
  
  public static int decodeZigZag32(int n)
  {
    return n >>> 1 ^ -(n & 0x1);
  }
  
  public static long decodeZigZag64(long n)
  {
    return n >>> 1 ^ -(n & 1L);
  }
  
  private int currentLimit = Integer.MAX_VALUE;
  private int recursionDepth;
  private int recursionLimit = 64;
  private int sizeLimit = 67108864;
  private static final int DEFAULT_RECURSION_LIMIT = 64;
  private static final int DEFAULT_SIZE_LIMIT = 67108864;
  private static final int BUFFER_SIZE = 4096;
  
  private CodedInputStream(byte[] buffer, int off, int len)
  {
    this.buffer = buffer;
    bufferSize = (off + len);
    bufferPos = off;
    totalBytesRetired = (-off);
    input = null;
  }
  
  private CodedInputStream(InputStream input)
  {
    buffer = new byte['က'];
    bufferSize = 0;
    bufferPos = 0;
    totalBytesRetired = 0;
    this.input = input;
  }
  
  public int setRecursionLimit(int limit)
  {
    if (limit < 0) {
      throw new IllegalArgumentException("Recursion limit cannot be negative: " + limit);
    }
    int oldLimit = recursionLimit;
    recursionLimit = limit;
    return oldLimit;
  }
  
  public int setSizeLimit(int limit)
  {
    if (limit < 0) {
      throw new IllegalArgumentException("Size limit cannot be negative: " + limit);
    }
    int oldLimit = sizeLimit;
    sizeLimit = limit;
    return oldLimit;
  }
  
  public void resetSizeCounter()
  {
    totalBytesRetired = (-bufferPos);
  }
  
  public int pushLimit(int byteLimit)
    throws InvalidProtocolBufferException
  {
    if (byteLimit < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    byteLimit += totalBytesRetired + bufferPos;
    int oldLimit = currentLimit;
    if (byteLimit > oldLimit) {
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    currentLimit = byteLimit;
    
    recomputeBufferSizeAfterLimit();
    
    return oldLimit;
  }
  
  private void recomputeBufferSizeAfterLimit()
  {
    bufferSize += bufferSizeAfterLimit;
    int bufferEnd = totalBytesRetired + bufferSize;
    if (bufferEnd > currentLimit)
    {
      bufferSizeAfterLimit = (bufferEnd - currentLimit);
      bufferSize -= bufferSizeAfterLimit;
    }
    else
    {
      bufferSizeAfterLimit = 0;
    }
  }
  
  public void popLimit(int oldLimit)
  {
    currentLimit = oldLimit;
    recomputeBufferSizeAfterLimit();
  }
  
  public int getBytesUntilLimit()
  {
    if (currentLimit == Integer.MAX_VALUE) {
      return -1;
    }
    int currentAbsolutePosition = totalBytesRetired + bufferPos;
    return currentLimit - currentAbsolutePosition;
  }
  
  public boolean isAtEnd()
    throws IOException
  {
    return (bufferPos == bufferSize) && (!refillBuffer(false));
  }
  
  public int getTotalBytesRead()
  {
    return totalBytesRetired + bufferPos;
  }
  
  private boolean refillBuffer(boolean mustSucceed)
    throws IOException
  {
    if (bufferPos < bufferSize) {
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }
    if (totalBytesRetired + bufferSize == currentLimit)
    {
      if (mustSucceed) {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
      return false;
    }
    totalBytesRetired += bufferSize;
    
    bufferPos = 0;
    bufferSize = (input == null ? -1 : input.read(buffer));
    if ((bufferSize == 0) || (bufferSize < -1)) {
      throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + bufferSize + "\nThe InputStream implementation is buggy.");
    }
    if (bufferSize == -1)
    {
      bufferSize = 0;
      if (mustSucceed) {
        throw InvalidProtocolBufferException.truncatedMessage();
      }
      return false;
    }
    recomputeBufferSizeAfterLimit();
    int totalBytesRead = totalBytesRetired + bufferSize + bufferSizeAfterLimit;
    if ((totalBytesRead > sizeLimit) || (totalBytesRead < 0)) {
      throw InvalidProtocolBufferException.sizeLimitExceeded();
    }
    return true;
  }
  
  public byte readRawByte()
    throws IOException
  {
    if (bufferPos == bufferSize) {
      refillBuffer(true);
    }
    return buffer[(bufferPos++)];
  }
  
  public byte[] readRawBytes(int size)
    throws IOException
  {
    if (size < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    if (totalBytesRetired + bufferPos + size > currentLimit)
    {
      skipRawBytes(currentLimit - totalBytesRetired - bufferPos);
      
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    if (size <= bufferSize - bufferPos)
    {
      byte[] bytes = new byte[size];
      System.arraycopy(buffer, bufferPos, bytes, 0, size);
      bufferPos += size;
      return bytes;
    }
    if (size < 4096)
    {
      byte[] bytes = new byte[size];
      int pos = bufferSize - bufferPos;
      System.arraycopy(buffer, bufferPos, bytes, 0, pos);
      bufferPos = bufferSize;
      
      refillBuffer(true);
      while (size - pos > bufferSize)
      {
        System.arraycopy(buffer, 0, bytes, pos, bufferSize);
        pos += bufferSize;
        bufferPos = bufferSize;
        refillBuffer(true);
      }
      System.arraycopy(buffer, 0, bytes, pos, size - pos);
      bufferPos = (size - pos);
      
      return bytes;
    }
    int originalBufferPos = bufferPos;
    int originalBufferSize = bufferSize;
    
    totalBytesRetired += bufferSize;
    bufferPos = 0;
    bufferSize = 0;
    
    int sizeLeft = size - (originalBufferSize - originalBufferPos);
    List<byte[]> chunks = new ArrayList();
    while (sizeLeft > 0)
    {
      byte[] chunk = new byte[Math.min(sizeLeft, 4096)];
      int pos = 0;
      while (pos < chunk.length)
      {
        int n = input == null ? -1 : input.read(chunk, pos, chunk.length - pos);
        if (n == -1) {
          throw InvalidProtocolBufferException.truncatedMessage();
        }
        totalBytesRetired += n;
        pos += n;
      }
      sizeLeft -= chunk.length;
      chunks.add(chunk);
    }
    byte[] bytes = new byte[size];
    
    int pos = originalBufferSize - originalBufferPos;
    System.arraycopy(buffer, originalBufferPos, bytes, 0, pos);
    for (byte[] chunk : chunks)
    {
      System.arraycopy(chunk, 0, bytes, pos, chunk.length);
      pos += chunk.length;
    }
    return bytes;
  }
  
  public void skipRawBytes(int size)
    throws IOException
  {
    if (size < 0) {
      throw InvalidProtocolBufferException.negativeSize();
    }
    if (totalBytesRetired + bufferPos + size > currentLimit)
    {
      skipRawBytes(currentLimit - totalBytesRetired - bufferPos);
      
      throw InvalidProtocolBufferException.truncatedMessage();
    }
    if (size <= bufferSize - bufferPos)
    {
      bufferPos += size;
    }
    else
    {
      int pos = bufferSize - bufferPos;
      bufferPos = bufferSize;
      
      refillBuffer(true);
      while (size - pos > bufferSize)
      {
        pos += bufferSize;
        bufferPos = bufferSize;
        refillBuffer(true);
      }
      bufferPos = (size - pos);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.CodedInputStream
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */