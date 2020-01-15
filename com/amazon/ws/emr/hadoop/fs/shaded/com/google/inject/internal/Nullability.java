package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Nullable;
import java.lang.annotation.Annotation;

public class Nullability
{
  public static boolean allowsNull(Annotation[] annotations)
  {
    for (Annotation a : annotations)
    {
      Class<? extends Annotation> type = a.annotationType();
      if (("Nullable".equals(type.getSimpleName())) || (type == .Nullable.class)) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.Nullability
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */