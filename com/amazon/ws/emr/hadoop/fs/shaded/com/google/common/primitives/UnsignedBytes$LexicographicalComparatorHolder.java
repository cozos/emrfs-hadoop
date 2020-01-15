package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Comparator;
import sun.misc.Unsafe;

@VisibleForTesting
class UnsignedBytes$LexicographicalComparatorHolder
{
  static final String UNSAFE_COMPARATOR_NAME = String.valueOf(LexicographicalComparatorHolder.class.getName()).concat("$UnsafeComparator");
  static final Comparator<byte[]> BEST_COMPARATOR = getBestComparator();
  
  @VisibleForTesting
  static enum UnsafeComparator
    implements Comparator<byte[]>
  {
    INSTANCE;
    
    static final boolean BIG_ENDIAN;
    static final Unsafe theUnsafe;
    static final int BYTE_ARRAY_BASE_OFFSET;
    
    static
    {
      BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
      
      theUnsafe = getUnsafe();
      
      BYTE_ARRAY_BASE_OFFSET = theUnsafe.arrayBaseOffset(byte[].class);
      if (theUnsafe.arrayIndexScale(byte[].class) != 1) {
        throw new AssertionError();
      }
    }
    
    private static Unsafe getUnsafe()
    {
      try
      {
        return Unsafe.getUnsafe();
      }
      catch (SecurityException tryReflectionInstead)
      {
        try
        {
          (Unsafe)AccessController.doPrivileged(new PrivilegedExceptionAction()
          {
            public Unsafe run()
              throws Exception
            {
              Class<Unsafe> k = Unsafe.class;
              for (Field f : k.getDeclaredFields())
              {
                f.setAccessible(true);
                Object x = f.get(null);
                if (k.isInstance(x)) {
                  return (Unsafe)k.cast(x);
                }
              }
              throw new NoSuchFieldError("the Unsafe");
            }
          });
        }
        catch (PrivilegedActionException e)
        {
          throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }
      }
    }
    
    public int compare(byte[] left, byte[] right)
    {
      int minLength = Math.min(left.length, right.length);
      int minWords = minLength / 8;
      for (int i = 0; i < minWords * 8; i += 8)
      {
        long lw = theUnsafe.getLong(left, BYTE_ARRAY_BASE_OFFSET + i);
        long rw = theUnsafe.getLong(right, BYTE_ARRAY_BASE_OFFSET + i);
        if (lw != rw)
        {
          if (BIG_ENDIAN) {
            return UnsignedLongs.compare(lw, rw);
          }
          int n = Long.numberOfTrailingZeros(lw ^ rw) & 0xFFFFFFF8;
          return (int)((lw >>> n & 0xFF) - (rw >>> n & 0xFF));
        }
      }
      for (int i = minWords * 8; i < minLength; i++)
      {
        int result = UnsignedBytes.compare(left[i], right[i]);
        if (result != 0) {
          return result;
        }
      }
      return left.length - right.length;
    }
    
    private UnsafeComparator() {}
  }
  
  static enum PureJavaComparator
    implements Comparator<byte[]>
  {
    INSTANCE;
    
    private PureJavaComparator() {}
    
    public int compare(byte[] left, byte[] right)
    {
      int minLength = Math.min(left.length, right.length);
      for (int i = 0; i < minLength; i++)
      {
        int result = UnsignedBytes.compare(left[i], right[i]);
        if (result != 0) {
          return result;
        }
      }
      return left.length - right.length;
    }
  }
  
  static Comparator<byte[]> getBestComparator()
  {
    try
    {
      Class<?> theClass = Class.forName(UNSAFE_COMPARATOR_NAME);
      
      return (Comparator)theClass.getEnumConstants()[0];
    }
    catch (Throwable t) {}
    return UnsignedBytes.lexicographicalComparatorJavaImpl();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */