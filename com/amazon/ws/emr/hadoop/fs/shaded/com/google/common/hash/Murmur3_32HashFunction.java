package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

final class Murmur3_32HashFunction
  extends AbstractStreamingHashFunction
  implements Serializable
{
  private static final int C1 = -862048943;
  private static final int C2 = 461845907;
  private final int seed;
  private static final long serialVersionUID = 0L;
  
  Murmur3_32HashFunction(int seed)
  {
    this.seed = seed;
  }
  
  public int bits()
  {
    return 32;
  }
  
  public Hasher newHasher()
  {
    return new Murmur3_32Hasher(seed);
  }
  
  public String toString()
  {
    int i = seed;return 31 + "Hashing.murmur3_32(" + i + ")";
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof Murmur3_32HashFunction))
    {
      Murmur3_32HashFunction other = (Murmur3_32HashFunction)object;
      return seed == seed;
    }
    return false;
  }
  
  public int hashCode()
  {
    return getClass().hashCode() ^ seed;
  }
  
  public HashCode hashInt(int input)
  {
    int k1 = mixK1(input);
    int h1 = mixH1(seed, k1);
    
    return fmix(h1, 4);
  }
  
  public HashCode hashLong(long input)
  {
    int low = (int)input;
    int high = (int)(input >>> 32);
    
    int k1 = mixK1(low);
    int h1 = mixH1(seed, k1);
    
    k1 = mixK1(high);
    h1 = mixH1(h1, k1);
    
    return fmix(h1, 8);
  }
  
  public HashCode hashUnencodedChars(CharSequence input)
  {
    int h1 = seed;
    for (int i = 1; i < input.length(); i += 2)
    {
      int k1 = input.charAt(i - 1) | input.charAt(i) << '\020';
      k1 = mixK1(k1);
      h1 = mixH1(h1, k1);
    }
    if ((input.length() & 0x1) == 1)
    {
      int k1 = input.charAt(input.length() - 1);
      k1 = mixK1(k1);
      h1 ^= k1;
    }
    return fmix(h1, 2 * input.length());
  }
  
  private static int mixK1(int k1)
  {
    k1 *= -862048943;
    k1 = Integer.rotateLeft(k1, 15);
    k1 *= 461845907;
    return k1;
  }
  
  private static int mixH1(int h1, int k1)
  {
    h1 ^= k1;
    h1 = Integer.rotateLeft(h1, 13);
    h1 = h1 * 5 + -430675100;
    return h1;
  }
  
  private static HashCode fmix(int h1, int length)
  {
    h1 ^= length;
    h1 ^= h1 >>> 16;
    h1 *= -2048144789;
    h1 ^= h1 >>> 13;
    h1 *= -1028477387;
    h1 ^= h1 >>> 16;
    return HashCode.fromInt(h1);
  }
  
  private static final class Murmur3_32Hasher
    extends AbstractStreamingHashFunction.AbstractStreamingHasher
  {
    private static final int CHUNK_SIZE = 4;
    private int h1;
    private int length;
    
    Murmur3_32Hasher(int seed)
    {
      super();
      h1 = seed;
      length = 0;
    }
    
    protected void process(ByteBuffer bb)
    {
      int k1 = Murmur3_32HashFunction.mixK1(bb.getInt());
      h1 = Murmur3_32HashFunction.mixH1(h1, k1);
      length += 4;
    }
    
    protected void processRemaining(ByteBuffer bb)
    {
      length += bb.remaining();
      int k1 = 0;
      for (int i = 0; bb.hasRemaining(); i += 8) {
        k1 ^= UnsignedBytes.toInt(bb.get()) << i;
      }
      h1 ^= Murmur3_32HashFunction.mixK1(k1);
    }
    
    public HashCode makeHash()
    {
      return Murmur3_32HashFunction.fmix(h1, length);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Murmur3_32HashFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */