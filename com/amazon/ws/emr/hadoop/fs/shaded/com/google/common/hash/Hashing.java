package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.annotation.Nullable;

@Beta
public final class Hashing
{
  public static HashFunction goodFastHash(int minimumBits)
  {
    int bits = checkPositiveAndMakeMultipleOf32(minimumBits);
    if (bits == 32) {
      return Murmur3_32Holder.GOOD_FAST_HASH_FUNCTION_32;
    }
    if (bits <= 128) {
      return Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
    }
    int hashFunctionsNeeded = (bits + 127) / 128;
    HashFunction[] hashFunctions = new HashFunction[hashFunctionsNeeded];
    hashFunctions[0] = Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
    int seed = GOOD_FAST_HASH_SEED;
    for (int i = 1; i < hashFunctionsNeeded; i++)
    {
      seed += 1500450271;
      hashFunctions[i] = murmur3_128(seed);
    }
    return new ConcatenatedHashFunction(hashFunctions);
  }
  
  private static final int GOOD_FAST_HASH_SEED = (int)System.currentTimeMillis();
  
  public static HashFunction murmur3_32(int seed)
  {
    return new Murmur3_32HashFunction(seed);
  }
  
  public static HashFunction murmur3_32()
  {
    return Murmur3_32Holder.MURMUR3_32;
  }
  
  private static class Murmur3_32Holder
  {
    static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0);
    static final HashFunction GOOD_FAST_HASH_FUNCTION_32 = Hashing.murmur3_32(Hashing.GOOD_FAST_HASH_SEED);
  }
  
  public static HashFunction murmur3_128(int seed)
  {
    return new Murmur3_128HashFunction(seed);
  }
  
  public static HashFunction murmur3_128()
  {
    return Murmur3_128Holder.MURMUR3_128;
  }
  
  private static class Murmur3_128Holder
  {
    static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    static final HashFunction GOOD_FAST_HASH_FUNCTION_128 = Hashing.murmur3_128(Hashing.GOOD_FAST_HASH_SEED);
  }
  
  public static HashFunction sipHash24()
  {
    return SipHash24Holder.SIP_HASH_24;
  }
  
  private static class SipHash24Holder
  {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
  }
  
  public static HashFunction sipHash24(long k0, long k1)
  {
    return new SipHashFunction(2, 4, k0, k1);
  }
  
  public static HashFunction md5()
  {
    return Md5Holder.MD5;
  }
  
  private static class Md5Holder
  {
    static final HashFunction MD5 = new MessageDigestHashFunction("MD5", "Hashing.md5()");
  }
  
  public static HashFunction sha1()
  {
    return Sha1Holder.SHA_1;
  }
  
  private static class Sha1Holder
  {
    static final HashFunction SHA_1 = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");
  }
  
  public static HashFunction sha256()
  {
    return Sha256Holder.SHA_256;
  }
  
  private static class Sha256Holder
  {
    static final HashFunction SHA_256 = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");
  }
  
  public static HashFunction sha512()
  {
    return Sha512Holder.SHA_512;
  }
  
  private static class Sha512Holder
  {
    static final HashFunction SHA_512 = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
  }
  
  public static HashFunction crc32c()
  {
    return Crc32cHolder.CRC_32_C;
  }
  
  private static final class Crc32cHolder
  {
    static final HashFunction CRC_32_C = new Crc32cHashFunction();
  }
  
  public static HashFunction crc32()
  {
    return Crc32Holder.CRC_32;
  }
  
  private static class Crc32Holder
  {
    static final HashFunction CRC_32 = Hashing.checksumHashFunction(Hashing.ChecksumType.CRC_32, "Hashing.crc32()");
  }
  
  public static HashFunction adler32()
  {
    return Adler32Holder.ADLER_32;
  }
  
  private static class Adler32Holder
  {
    static final HashFunction ADLER_32 = Hashing.checksumHashFunction(Hashing.ChecksumType.ADLER_32, "Hashing.adler32()");
  }
  
  private static HashFunction checksumHashFunction(ChecksumType type, String toString)
  {
    return new ChecksumHashFunction(type, bits, toString);
  }
  
  static abstract enum ChecksumType
    implements Supplier<Checksum>
  {
    CRC_32(32),  ADLER_32(32);
    
    private final int bits;
    
    private ChecksumType(int bits)
    {
      this.bits = bits;
    }
    
    public abstract Checksum get();
  }
  
  public static int consistentHash(HashCode hashCode, int buckets)
  {
    return consistentHash(hashCode.padToLong(), buckets);
  }
  
  public static int consistentHash(long input, int buckets)
  {
    Preconditions.checkArgument(buckets > 0, "buckets must be positive: %s", new Object[] { Integer.valueOf(buckets) });
    LinearCongruentialGenerator generator = new LinearCongruentialGenerator(input);
    int candidate = 0;
    for (;;)
    {
      int next = (int)((candidate + 1) / generator.nextDouble());
      if ((next < 0) || (next >= buckets)) {
        break;
      }
      candidate = next;
    }
    return candidate;
  }
  
  public static HashCode combineOrdered(Iterable<HashCode> hashCodes)
  {
    Iterator<HashCode> iterator = hashCodes.iterator();
    Preconditions.checkArgument(iterator.hasNext(), "Must be at least 1 hash code to combine.");
    int bits = ((HashCode)iterator.next()).bits();
    byte[] resultBytes = new byte[bits / 8];
    for (HashCode hashCode : hashCodes)
    {
      byte[] nextBytes = hashCode.asBytes();
      Preconditions.checkArgument(nextBytes.length == resultBytes.length, "All hashcodes must have the same bit length.");
      for (int i = 0; i < nextBytes.length; i++) {
        resultBytes[i] = ((byte)(resultBytes[i] * 37 ^ nextBytes[i]));
      }
    }
    return HashCode.fromBytesNoCopy(resultBytes);
  }
  
  public static HashCode combineUnordered(Iterable<HashCode> hashCodes)
  {
    Iterator<HashCode> iterator = hashCodes.iterator();
    Preconditions.checkArgument(iterator.hasNext(), "Must be at least 1 hash code to combine.");
    byte[] resultBytes = new byte[((HashCode)iterator.next()).bits() / 8];
    for (HashCode hashCode : hashCodes)
    {
      byte[] nextBytes = hashCode.asBytes();
      Preconditions.checkArgument(nextBytes.length == resultBytes.length, "All hashcodes must have the same bit length.");
      for (int i = 0; i < nextBytes.length; tmp102_100++)
      {
        int tmp102_100 = i; byte[] tmp102_99 = resultBytes;tmp102_99[tmp102_100] = ((byte)(tmp102_99[tmp102_100] + nextBytes[tmp102_100]));
      }
    }
    return HashCode.fromBytesNoCopy(resultBytes);
  }
  
  static int checkPositiveAndMakeMultipleOf32(int bits)
  {
    Preconditions.checkArgument(bits > 0, "Number of bits must be positive");
    return bits + 31 & 0xFFFFFFE0;
  }
  
  @VisibleForTesting
  static final class ConcatenatedHashFunction
    extends AbstractCompositeHashFunction
  {
    private final int bits;
    
    ConcatenatedHashFunction(HashFunction... functions)
    {
      super();
      int bitSum = 0;
      for (HashFunction function : functions) {
        bitSum += function.bits();
      }
      bits = bitSum;
    }
    
    HashCode makeHash(Hasher[] hashers)
    {
      byte[] bytes = new byte[bits / 8];
      int i = 0;
      for (Hasher hasher : hashers)
      {
        HashCode newHash = hasher.hash();
        i += newHash.writeBytesTo(bytes, i, newHash.bits() / 8);
      }
      return HashCode.fromBytesNoCopy(bytes);
    }
    
    public int bits()
    {
      return bits;
    }
    
    public boolean equals(@Nullable Object object)
    {
      if ((object instanceof ConcatenatedHashFunction))
      {
        ConcatenatedHashFunction other = (ConcatenatedHashFunction)object;
        if ((bits != bits) || (functions.length != functions.length)) {
          return false;
        }
        for (int i = 0; i < functions.length; i++) {
          if (!functions[i].equals(functions[i])) {
            return false;
          }
        }
        return true;
      }
      return false;
    }
    
    public int hashCode()
    {
      int hash = bits;
      for (HashFunction function : functions) {
        hash ^= function.hashCode();
      }
      return hash;
    }
  }
  
  private static final class LinearCongruentialGenerator
  {
    private long state;
    
    public LinearCongruentialGenerator(long seed)
    {
      state = seed;
    }
    
    public double nextDouble()
    {
      state = (2862933555777941757L * state + 1L);
      return ((int)(state >>> 33) + 1) / 2.147483648E9D;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.hash.Hashing
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */