package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class CodedOutputStream
{
  private final byte[] buffer;
  private final int limit;
  private int position;
  private final OutputStream output;
  public static final int DEFAULT_BUFFER_SIZE = 4096;
  public static final int LITTLE_ENDIAN_32_SIZE = 4;
  public static final int LITTLE_ENDIAN_64_SIZE = 8;
  
  static int computePreferredBufferSize(int dataLength)
  {
    if (dataLength > 4096) {
      return 4096;
    }
    return dataLength;
  }
  
  private CodedOutputStream(byte[] buffer, int offset, int length)
  {
    output = null;
    this.buffer = buffer;
    position = offset;
    limit = (offset + length);
  }
  
  private CodedOutputStream(OutputStream output, byte[] buffer)
  {
    this.output = output;
    this.buffer = buffer;
    position = 0;
    limit = buffer.length;
  }
  
  public static CodedOutputStream newInstance(OutputStream output)
  {
    return newInstance(output, 4096);
  }
  
  public static CodedOutputStream newInstance(OutputStream output, int bufferSize)
  {
    return new CodedOutputStream(output, new byte[bufferSize]);
  }
  
  public static CodedOutputStream newInstance(byte[] flatArray)
  {
    return newInstance(flatArray, 0, flatArray.length);
  }
  
  public static CodedOutputStream newInstance(byte[] flatArray, int offset, int length)
  {
    return new CodedOutputStream(flatArray, offset, length);
  }
  
  public void writeDouble(int fieldNumber, double value)
    throws IOException
  {
    writeTag(fieldNumber, 1);
    writeDoubleNoTag(value);
  }
  
  public void writeFloat(int fieldNumber, float value)
    throws IOException
  {
    writeTag(fieldNumber, 5);
    writeFloatNoTag(value);
  }
  
  public void writeUInt64(int fieldNumber, long value)
    throws IOException
  {
    writeTag(fieldNumber, 0);
    writeUInt64NoTag(value);
  }
  
  public void writeInt64(int fieldNumber, long value)
    throws IOException
  {
    writeTag(fieldNumber, 0);
    writeInt64NoTag(value);
  }
  
  public void writeInt32(int fieldNumber, int value)
    throws IOException
  {
    writeTag(fieldNumber, 0);
    writeInt32NoTag(value);
  }
  
  public void writeFixed64(int fieldNumber, long value)
    throws IOException
  {
    writeTag(fieldNumber, 1);
    writeFixed64NoTag(value);
  }
  
  public void writeFixed32(int fieldNumber, int value)
    throws IOException
  {
    writeTag(fieldNumber, 5);
    writeFixed32NoTag(value);
  }
  
  public void writeBool(int fieldNumber, boolean value)
    throws IOException
  {
    writeTag(fieldNumber, 0);
    writeBoolNoTag(value);
  }
  
  public void writeString(int fieldNumber, String value)
    throws IOException
  {
    writeTag(fieldNumber, 2);
    writeStringNoTag(value);
  }
  
  public void writeGroup(int fieldNumber, MessageLite value)
    throws IOException
  {
    writeTag(fieldNumber, 3);
    writeGroupNoTag(value);
    writeTag(fieldNumber, 4);
  }
  
  @Deprecated
  public void writeUnknownGroup(int fieldNumber, MessageLite value)
    throws IOException
  {
    writeGroup(fieldNumber, value);
  }
  
  public void writeMessage(int fieldNumber, MessageLite value)
    throws IOException
  {
    writeTag(fieldNumber, 2);
    writeMessageNoTag(value);
  }
  
  public void writeBytes(int fieldNumber, ByteString value)
    throws IOException
  {
    writeTag(fieldNumber, 2);
    writeBytesNoTag(value);
  }
  
  public void writeUInt32(int fieldNumber, int value)
    throws IOException
  {
    writeTag(fieldNumber, 0);
    writeUInt32NoTag(value);
  }
  
  public void writeEnum(int fieldNumber, int value)
    throws IOException
  {
    writeTag(fieldNumber, 0);
    writeEnumNoTag(value);
  }
  
  public void writeSFixed32(int fieldNumber, int value)
    throws IOException
  {
    writeTag(fieldNumber, 5);
    writeSFixed32NoTag(value);
  }
  
  public void writeSFixed64(int fieldNumber, long value)
    throws IOException
  {
    writeTag(fieldNumber, 1);
    writeSFixed64NoTag(value);
  }
  
  public void writeSInt32(int fieldNumber, int value)
    throws IOException
  {
    writeTag(fieldNumber, 0);
    writeSInt32NoTag(value);
  }
  
  public void writeSInt64(int fieldNumber, long value)
    throws IOException
  {
    writeTag(fieldNumber, 0);
    writeSInt64NoTag(value);
  }
  
  public void writeMessageSetExtension(int fieldNumber, MessageLite value)
    throws IOException
  {
    writeTag(1, 3);
    writeUInt32(2, fieldNumber);
    writeMessage(3, value);
    writeTag(1, 4);
  }
  
  public void writeRawMessageSetExtension(int fieldNumber, ByteString value)
    throws IOException
  {
    writeTag(1, 3);
    writeUInt32(2, fieldNumber);
    writeBytes(3, value);
    writeTag(1, 4);
  }
  
  public void writeDoubleNoTag(double value)
    throws IOException
  {
    writeRawLittleEndian64(Double.doubleToRawLongBits(value));
  }
  
  public void writeFloatNoTag(float value)
    throws IOException
  {
    writeRawLittleEndian32(Float.floatToRawIntBits(value));
  }
  
  public void writeUInt64NoTag(long value)
    throws IOException
  {
    writeRawVarint64(value);
  }
  
  public void writeInt64NoTag(long value)
    throws IOException
  {
    writeRawVarint64(value);
  }
  
  public void writeInt32NoTag(int value)
    throws IOException
  {
    if (value >= 0) {
      writeRawVarint32(value);
    } else {
      writeRawVarint64(value);
    }
  }
  
  public void writeFixed64NoTag(long value)
    throws IOException
  {
    writeRawLittleEndian64(value);
  }
  
  public void writeFixed32NoTag(int value)
    throws IOException
  {
    writeRawLittleEndian32(value);
  }
  
  public void writeBoolNoTag(boolean value)
    throws IOException
  {
    writeRawByte(value ? 1 : 0);
  }
  
  public void writeStringNoTag(String value)
    throws IOException
  {
    byte[] bytes = value.getBytes("UTF-8");
    writeRawVarint32(bytes.length);
    writeRawBytes(bytes);
  }
  
  public void writeGroupNoTag(MessageLite value)
    throws IOException
  {
    value.writeTo(this);
  }
  
  @Deprecated
  public void writeUnknownGroupNoTag(MessageLite value)
    throws IOException
  {
    writeGroupNoTag(value);
  }
  
  public void writeMessageNoTag(MessageLite value)
    throws IOException
  {
    writeRawVarint32(value.getSerializedSize());
    value.writeTo(this);
  }
  
  public void writeBytesNoTag(ByteString value)
    throws IOException
  {
    writeRawVarint32(value.size());
    writeRawBytes(value);
  }
  
  public void writeUInt32NoTag(int value)
    throws IOException
  {
    writeRawVarint32(value);
  }
  
  public void writeEnumNoTag(int value)
    throws IOException
  {
    writeInt32NoTag(value);
  }
  
  public void writeSFixed32NoTag(int value)
    throws IOException
  {
    writeRawLittleEndian32(value);
  }
  
  public void writeSFixed64NoTag(long value)
    throws IOException
  {
    writeRawLittleEndian64(value);
  }
  
  public void writeSInt32NoTag(int value)
    throws IOException
  {
    writeRawVarint32(encodeZigZag32(value));
  }
  
  public void writeSInt64NoTag(long value)
    throws IOException
  {
    writeRawVarint64(encodeZigZag64(value));
  }
  
  public static int computeDoubleSize(int fieldNumber, double value)
  {
    return computeTagSize(fieldNumber) + computeDoubleSizeNoTag(value);
  }
  
  public static int computeFloatSize(int fieldNumber, float value)
  {
    return computeTagSize(fieldNumber) + computeFloatSizeNoTag(value);
  }
  
  public static int computeUInt64Size(int fieldNumber, long value)
  {
    return computeTagSize(fieldNumber) + computeUInt64SizeNoTag(value);
  }
  
  public static int computeInt64Size(int fieldNumber, long value)
  {
    return computeTagSize(fieldNumber) + computeInt64SizeNoTag(value);
  }
  
  public static int computeInt32Size(int fieldNumber, int value)
  {
    return computeTagSize(fieldNumber) + computeInt32SizeNoTag(value);
  }
  
  public static int computeFixed64Size(int fieldNumber, long value)
  {
    return computeTagSize(fieldNumber) + computeFixed64SizeNoTag(value);
  }
  
  public static int computeFixed32Size(int fieldNumber, int value)
  {
    return computeTagSize(fieldNumber) + computeFixed32SizeNoTag(value);
  }
  
  public static int computeBoolSize(int fieldNumber, boolean value)
  {
    return computeTagSize(fieldNumber) + computeBoolSizeNoTag(value);
  }
  
  public static int computeStringSize(int fieldNumber, String value)
  {
    return computeTagSize(fieldNumber) + computeStringSizeNoTag(value);
  }
  
  public static int computeGroupSize(int fieldNumber, MessageLite value)
  {
    return computeTagSize(fieldNumber) * 2 + computeGroupSizeNoTag(value);
  }
  
  @Deprecated
  public static int computeUnknownGroupSize(int fieldNumber, MessageLite value)
  {
    return computeGroupSize(fieldNumber, value);
  }
  
  public static int computeMessageSize(int fieldNumber, MessageLite value)
  {
    return computeTagSize(fieldNumber) + computeMessageSizeNoTag(value);
  }
  
  public static int computeBytesSize(int fieldNumber, ByteString value)
  {
    return computeTagSize(fieldNumber) + computeBytesSizeNoTag(value);
  }
  
  public static int computeLazyFieldSize(int fieldNumber, LazyField value)
  {
    return computeTagSize(fieldNumber) + computeLazyFieldSizeNoTag(value);
  }
  
  public static int computeUInt32Size(int fieldNumber, int value)
  {
    return computeTagSize(fieldNumber) + computeUInt32SizeNoTag(value);
  }
  
  public static int computeEnumSize(int fieldNumber, int value)
  {
    return computeTagSize(fieldNumber) + computeEnumSizeNoTag(value);
  }
  
  public static int computeSFixed32Size(int fieldNumber, int value)
  {
    return computeTagSize(fieldNumber) + computeSFixed32SizeNoTag(value);
  }
  
  public static int computeSFixed64Size(int fieldNumber, long value)
  {
    return computeTagSize(fieldNumber) + computeSFixed64SizeNoTag(value);
  }
  
  public static int computeSInt32Size(int fieldNumber, int value)
  {
    return computeTagSize(fieldNumber) + computeSInt32SizeNoTag(value);
  }
  
  public static int computeSInt64Size(int fieldNumber, long value)
  {
    return computeTagSize(fieldNumber) + computeSInt64SizeNoTag(value);
  }
  
  public static int computeMessageSetExtensionSize(int fieldNumber, MessageLite value)
  {
    return computeTagSize(1) * 2 + computeUInt32Size(2, fieldNumber) + computeMessageSize(3, value);
  }
  
  public static int computeRawMessageSetExtensionSize(int fieldNumber, ByteString value)
  {
    return computeTagSize(1) * 2 + computeUInt32Size(2, fieldNumber) + computeBytesSize(3, value);
  }
  
  public static int computeLazyFieldMessageSetExtensionSize(int fieldNumber, LazyField value)
  {
    return computeTagSize(1) * 2 + computeUInt32Size(2, fieldNumber) + computeLazyFieldSize(3, value);
  }
  
  public static int computeDoubleSizeNoTag(double value)
  {
    return 8;
  }
  
  public static int computeFloatSizeNoTag(float value)
  {
    return 4;
  }
  
  public static int computeUInt64SizeNoTag(long value)
  {
    return computeRawVarint64Size(value);
  }
  
  public static int computeInt64SizeNoTag(long value)
  {
    return computeRawVarint64Size(value);
  }
  
  public static int computeInt32SizeNoTag(int value)
  {
    if (value >= 0) {
      return computeRawVarint32Size(value);
    }
    return 10;
  }
  
  public static int computeFixed64SizeNoTag(long value)
  {
    return 8;
  }
  
  public static int computeFixed32SizeNoTag(int value)
  {
    return 4;
  }
  
  public static int computeBoolSizeNoTag(boolean value)
  {
    return 1;
  }
  
  public static int computeStringSizeNoTag(String value)
  {
    try
    {
      byte[] bytes = value.getBytes("UTF-8");
      return computeRawVarint32Size(bytes.length) + bytes.length;
    }
    catch (UnsupportedEncodingException e)
    {
      throw new RuntimeException("UTF-8 not supported.", e);
    }
  }
  
  public static int computeGroupSizeNoTag(MessageLite value)
  {
    return value.getSerializedSize();
  }
  
  @Deprecated
  public static int computeUnknownGroupSizeNoTag(MessageLite value)
  {
    return computeGroupSizeNoTag(value);
  }
  
  public static int computeMessageSizeNoTag(MessageLite value)
  {
    int size = value.getSerializedSize();
    return computeRawVarint32Size(size) + size;
  }
  
  public static int computeLazyFieldSizeNoTag(LazyField value)
  {
    int size = value.getSerializedSize();
    return computeRawVarint32Size(size) + size;
  }
  
  public static int computeBytesSizeNoTag(ByteString value)
  {
    return computeRawVarint32Size(value.size()) + value.size();
  }
  
  public static int computeUInt32SizeNoTag(int value)
  {
    return computeRawVarint32Size(value);
  }
  
  public static int computeEnumSizeNoTag(int value)
  {
    return computeInt32SizeNoTag(value);
  }
  
  public static int computeSFixed32SizeNoTag(int value)
  {
    return 4;
  }
  
  public static int computeSFixed64SizeNoTag(long value)
  {
    return 8;
  }
  
  public static int computeSInt32SizeNoTag(int value)
  {
    return computeRawVarint32Size(encodeZigZag32(value));
  }
  
  public static int computeSInt64SizeNoTag(long value)
  {
    return computeRawVarint64Size(encodeZigZag64(value));
  }
  
  private void refreshBuffer()
    throws IOException
  {
    if (output == null) {
      throw new OutOfSpaceException();
    }
    output.write(buffer, 0, position);
    position = 0;
  }
  
  public void flush()
    throws IOException
  {
    if (output != null) {
      refreshBuffer();
    }
  }
  
  public int spaceLeft()
  {
    if (output == null) {
      return limit - position;
    }
    throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
  }
  
  public void checkNoSpaceLeft()
  {
    if (spaceLeft() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  public static class OutOfSpaceException
    extends IOException
  {
    private static final long serialVersionUID = -6947486886997889499L;
    
    OutOfSpaceException()
    {
      super();
    }
  }
  
  public void writeRawByte(byte value)
    throws IOException
  {
    if (position == limit) {
      refreshBuffer();
    }
    buffer[(position++)] = value;
  }
  
  public void writeRawByte(int value)
    throws IOException
  {
    writeRawByte((byte)value);
  }
  
  public void writeRawBytes(ByteString value)
    throws IOException
  {
    writeRawBytes(value, 0, value.size());
  }
  
  public void writeRawBytes(byte[] value)
    throws IOException
  {
    writeRawBytes(value, 0, value.length);
  }
  
  public void writeRawBytes(byte[] value, int offset, int length)
    throws IOException
  {
    if (limit - position >= length)
    {
      System.arraycopy(value, offset, buffer, position, length);
      position += length;
    }
    else
    {
      int bytesWritten = limit - position;
      System.arraycopy(value, offset, buffer, position, bytesWritten);
      offset += bytesWritten;
      length -= bytesWritten;
      position = limit;
      refreshBuffer();
      if (length <= limit)
      {
        System.arraycopy(value, offset, buffer, 0, length);
        position = length;
      }
      else
      {
        output.write(value, offset, length);
      }
    }
  }
  
  public void writeRawBytes(ByteString value, int offset, int length)
    throws IOException
  {
    if (limit - position >= length)
    {
      value.copyTo(buffer, offset, position, length);
      position += length;
    }
    else
    {
      int bytesWritten = limit - position;
      value.copyTo(buffer, offset, position, bytesWritten);
      offset += bytesWritten;
      length -= bytesWritten;
      position = limit;
      refreshBuffer();
      if (length <= limit)
      {
        value.copyTo(buffer, offset, 0, length);
        position = length;
      }
      else
      {
        InputStream inputStreamFrom = value.newInput();
        if (offset != inputStreamFrom.skip(offset)) {
          throw new IllegalStateException("Skip failed? Should never happen.");
        }
        while (length > 0)
        {
          int bytesToRead = Math.min(length, limit);
          int bytesRead = inputStreamFrom.read(buffer, 0, bytesToRead);
          if (bytesRead != bytesToRead) {
            throw new IllegalStateException("Read failed? Should never happen");
          }
          output.write(buffer, 0, bytesRead);
          length -= bytesRead;
        }
      }
    }
  }
  
  public void writeTag(int fieldNumber, int wireType)
    throws IOException
  {
    writeRawVarint32(WireFormat.makeTag(fieldNumber, wireType));
  }
  
  public static int computeTagSize(int fieldNumber)
  {
    return computeRawVarint32Size(WireFormat.makeTag(fieldNumber, 0));
  }
  
  public void writeRawVarint32(int value)
    throws IOException
  {
    for (;;)
    {
      if ((value & 0xFFFFFF80) == 0)
      {
        writeRawByte(value);
        return;
      }
      writeRawByte(value & 0x7F | 0x80);
      value >>>= 7;
    }
  }
  
  public static int computeRawVarint32Size(int value)
  {
    if ((value & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((value & 0xC000) == 0) {
      return 2;
    }
    if ((value & 0xFFE00000) == 0) {
      return 3;
    }
    if ((value & 0xF0000000) == 0) {
      return 4;
    }
    return 5;
  }
  
  public void writeRawVarint64(long value)
    throws IOException
  {
    for (;;)
    {
      if ((value & 0xFFFFFFFFFFFFFF80) == 0L)
      {
        writeRawByte((int)value);
        return;
      }
      writeRawByte((int)value & 0x7F | 0x80);
      value >>>= 7;
    }
  }
  
  public static int computeRawVarint64Size(long value)
  {
    if ((value & 0xFFFFFFFFFFFFFF80) == 0L) {
      return 1;
    }
    if ((value & 0xFFFFFFFFFFFFC000) == 0L) {
      return 2;
    }
    if ((value & 0xFFFFFFFFFFE00000) == 0L) {
      return 3;
    }
    if ((value & 0xFFFFFFFFF0000000) == 0L) {
      return 4;
    }
    if ((value & 0xFFFFFFF800000000) == 0L) {
      return 5;
    }
    if ((value & 0xFFFFFC0000000000) == 0L) {
      return 6;
    }
    if ((value & 0xFFFE000000000000) == 0L) {
      return 7;
    }
    if ((value & 0xFF00000000000000) == 0L) {
      return 8;
    }
    if ((value & 0x8000000000000000) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public void writeRawLittleEndian32(int value)
    throws IOException
  {
    writeRawByte(value & 0xFF);
    writeRawByte(value >> 8 & 0xFF);
    writeRawByte(value >> 16 & 0xFF);
    writeRawByte(value >> 24 & 0xFF);
  }
  
  public void writeRawLittleEndian64(long value)
    throws IOException
  {
    writeRawByte((int)value & 0xFF);
    writeRawByte((int)(value >> 8) & 0xFF);
    writeRawByte((int)(value >> 16) & 0xFF);
    writeRawByte((int)(value >> 24) & 0xFF);
    writeRawByte((int)(value >> 32) & 0xFF);
    writeRawByte((int)(value >> 40) & 0xFF);
    writeRawByte((int)(value >> 48) & 0xFF);
    writeRawByte((int)(value >> 56) & 0xFF);
  }
  
  public static int encodeZigZag32(int n)
  {
    return n << 1 ^ n >> 31;
  }
  
  public static long encodeZigZag64(long n)
  {
    return n << 1 ^ n >> 63;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.CodedOutputStream
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */