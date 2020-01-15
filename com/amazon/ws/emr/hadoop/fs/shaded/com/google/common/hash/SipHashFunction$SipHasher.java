package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import java.nio.ByteBuffer;

final class SipHashFunction$SipHasher
  extends AbstractStreamingHashFunction.AbstractStreamingHasher
{
  private static final int CHUNK_SIZE = 8;
  private final int c;
  private final int d;
  private long v0 = 8317987319222330741L;
  private long v1 = 7237128888997146477L;
  private long v2 = 7816392313619706465L;
  private long v3 = 8387220255154660723L;
  private long b = 0L;
  private long finalM = 0L;
  
  SipHashFunction$SipHasher(int c, int d, long k0, long k1)
  {
    super(8);
    this.c = c;
    this.d = d;
    v0 ^= k0;
    v1 ^= k1;
    v2 ^= k0;
    v3 ^= k1;
  }
  
  protected void process(ByteBuffer buffer)
  {
    b += 8L;
    processM(buffer.getLong());
  }
  
  protected void processRemaining(ByteBuffer buffer)
  {
    b += buffer.remaining();
    for (int i = 0; buffer.hasRemaining(); i += 8) {
      finalM ^= (buffer.get() & 0xFF) << i;
    }
  }
  
  public HashCode makeHash()
  {
    finalM ^= b << 56;
    processM(finalM);
    
    v2 ^= 0xFF;
    sipRound(d);
    return HashCode.fromLong(v0 ^ v1 ^ v2 ^ v3);
  }
  
  private void processM(long m)
  {
    v3 ^= m;
    sipRound(c);
    v0 ^= m;
  }
  
  private void sipRound(int iterations)
  {
    for (int i = 0; i < iterations; i++)
    {
      v0 += v1;
      v2 += v3;
      v1 = Long.rotateLeft(v1, 13);
      v3 = Long.rotateLeft(v3, 16);
      v1 ^= v0;
      v3 ^= v2;
      v0 = Long.rotateLeft(v0, 32);
      v2 += v1;
      v0 += v3;
      v1 = Long.rotateLeft(v1, 17);
      v3 = Long.rotateLeft(v3, 21);
      v1 ^= v2;
      v3 ^= v0;
      v2 = Long.rotateLeft(v2, 32);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.SipHashFunction.SipHasher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */