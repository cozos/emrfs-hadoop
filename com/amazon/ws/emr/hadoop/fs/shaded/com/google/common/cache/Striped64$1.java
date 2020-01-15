package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class Striped64$1
  implements PrivilegedExceptionAction<Unsafe>
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.Striped64.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */