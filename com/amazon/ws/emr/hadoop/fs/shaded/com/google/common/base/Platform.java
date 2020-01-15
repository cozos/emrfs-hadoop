package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;
import java.util.Map;

@GwtCompatible(emulated=true)
final class Platform
{
  static long systemNanoTime()
  {
    return System.nanoTime();
  }
  
  static CharMatcher precomputeCharMatcher(CharMatcher matcher)
  {
    return matcher.precomputedInternal();
  }
  
  static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> enumClass, String value)
  {
    WeakReference<? extends Enum<?>> ref = (WeakReference)Enums.getEnumConstants(enumClass).get(value);
    return ref == null ? Optional.absent() : Optional.of(enumClass.cast(ref.get()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Platform
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */