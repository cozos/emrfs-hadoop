package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

final class Prelude
{
  static final int LENGTH = 8;
  static final int LENGTH_WITH_CRC = 12;
  private final int totalLength;
  private final long headersLength;
  
  private Prelude(int totalLength, long headersLength)
  {
    this.totalLength = totalLength;
    this.headersLength = headersLength;
  }
  
  static Prelude decode(ByteBuffer buf)
  {
    buf = buf.duplicate();
    
    long computedPreludeCrc = computePreludeCrc(buf);
    
    long totalLength = intToUnsignedLong(buf.getInt());
    long headersLength = intToUnsignedLong(buf.getInt());
    long wirePreludeCrc = intToUnsignedLong(buf.getInt());
    if (computedPreludeCrc != wirePreludeCrc) {
      throw new IllegalArgumentException(String.format("Prelude checksum failure: expected 0x%x, computed 0x%x", new Object[] {
        Long.valueOf(wirePreludeCrc), Long.valueOf(computedPreludeCrc) }));
    }
    if ((headersLength < 0L) || (headersLength > 131072L)) {
      throw new IllegalArgumentException("Illegal headers_length value: " + headersLength);
    }
    long payloadLength = totalLength - headersLength - 16L;
    if ((payloadLength < 0L) || (payloadLength > 16777216L)) {
      throw new IllegalArgumentException("Illegal payload size: " + payloadLength);
    }
    return new Prelude(toIntExact(totalLength), headersLength);
  }
  
  private static long intToUnsignedLong(int i)
  {
    return i & 0xFFFFFFFF;
  }
  
  private static int toIntExact(long value)
  {
    if ((int)value != value) {
      throw new ArithmeticException("integer overflow");
    }
    return (int)value;
  }
  
  private static long computePreludeCrc(ByteBuffer buf)
  {
    byte[] prelude = new byte[8];
    buf.duplicate().get(prelude);
    
    Checksum crc = new CRC32();
    crc.update(prelude, 0, prelude.length);
    return crc.getValue();
  }
  
  int getTotalLength()
  {
    return totalLength;
  }
  
  long getHeadersLength()
  {
    return headersLength;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.Prelude
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */