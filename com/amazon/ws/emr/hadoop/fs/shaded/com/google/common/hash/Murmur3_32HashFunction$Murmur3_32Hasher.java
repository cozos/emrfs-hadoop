package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;

final class Murmur3_32HashFunction$Murmur3_32Hasher
  extends AbstractStreamingHashFunction.AbstractStreamingHasher
{
  private static final int CHUNK_SIZE = 4;
  private int h1;
  private int length;
  
  Murmur3_32HashFunction$Murmur3_32Hasher(int seed)
  {
    super(4);
    h1 = seed;
    length = 0;
  }
  
  protected void process(ByteBuffer bb)
  {
    int k1 = Murmur3_32HashFunction.access$000(bb.getInt());
    h1 = Murmur3_32HashFunction.access$100(h1, k1);
    length += 4;
  }
  
  protected void processRemaining(ByteBuffer bb)
  {
    length += bb.remaining();
    int k1 = 0;
    for (int i = 0; bb.hasRemaining(); i += 8) {
      k1 ^= UnsignedBytes.toInt(bb.get()) << i;
    }
    h1 ^= Murmur3_32HashFunction.access$000(k1);
  }
  
  public HashCode makeHash()
  {
    return Murmur3_32HashFunction.access$200(h1, length);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Murmur3_32HashFunction.Murmur3_32Hasher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */