package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

final class Utils
{
  static int toIntExact(long headersLength)
  {
    if ((int)headersLength != headersLength) {
      throw new ArithmeticException("integer overflow");
    }
    return (int)headersLength;
  }
  
  static long toUnsignedLong(int x)
  {
    return x & 0xFFFFFFFF;
  }
  
  static String readShortString(ByteBuffer buf)
  {
    int length = buf.get() & 0xFF;
    checkStringBounds(length, 255);
    byte[] bytes = new byte[length];
    buf.get(bytes);
    return new String(bytes, StringUtils.UTF8);
  }
  
  static String readString(ByteBuffer buf)
  {
    int length = buf.getShort() & 0xFFFF;
    checkStringBounds(length, 32767);
    byte[] bytes = new byte[length];
    buf.get(bytes);
    return new String(bytes, StringUtils.UTF8);
  }
  
  static byte[] readBytes(ByteBuffer buf)
  {
    int length = buf.getShort() & 0xFFFF;
    checkByteArrayBounds(length);
    byte[] bytes = new byte[length];
    buf.get(bytes);
    return bytes;
  }
  
  static void writeShortString(DataOutputStream dos, String string)
    throws IOException
  {
    byte[] bytes = string.getBytes(StringUtils.UTF8);
    checkStringBounds(bytes.length, 255);
    dos.writeByte(bytes.length);
    dos.write(bytes);
  }
  
  static void writeString(DataOutputStream dos, String string)
    throws IOException
  {
    byte[] bytes = string.getBytes(StringUtils.UTF8);
    checkStringBounds(bytes.length, 32767);
    writeBytes(dos, bytes);
  }
  
  static void writeBytes(DataOutputStream dos, byte[] bytes)
    throws IOException
  {
    checkByteArrayBounds(bytes.length);
    dos.writeShort((short)bytes.length);
    dos.write(bytes);
  }
  
  private static void checkByteArrayBounds(int length)
  {
    if (length == 0) {
      throw new IllegalArgumentException("Byte arrays may not be empty");
    }
    if (length > 32767) {
      throw new IllegalArgumentException("Illegal byte array length: " + length);
    }
  }
  
  private static void checkStringBounds(int length, int maxLength)
  {
    if (length == 0) {
      throw new IllegalArgumentException("Strings may not be empty");
    }
    if (length > maxLength) {
      throw new IllegalArgumentException("Illegal string length: " + length);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.Utils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */