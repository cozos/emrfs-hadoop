package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming;

import java.nio.ByteBuffer;
import java.util.zip.Checksum;

final class Checksums
{
  static void update(Checksum checksum, ByteBuffer buffer)
  {
    if (buffer.hasArray())
    {
      int pos = buffer.position();
      int off = buffer.arrayOffset();
      int limit = buffer.limit();
      int rem = limit - pos;
      checksum.update(buffer.array(), pos + off, rem);
      buffer.position(limit);
    }
    else
    {
      int length = buffer.remaining();
      byte[] b = new byte[length];
      buffer.get(b, 0, length);
      checksum.update(b, 0, length);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.eventstreaming.Checksums
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */