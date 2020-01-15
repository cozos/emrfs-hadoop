package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.BindingAnnotation;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicInteger;

public class UniqueAnnotations
{
  private static final AtomicInteger nextUniqueValue = new AtomicInteger(1);
  
  public static Annotation create()
  {
    return create(nextUniqueValue.getAndIncrement());
  }
  
  static Annotation create(int value)
  {
    new Internal()
    {
      public int value()
      {
        return val$value;
      }
      
      public Class<? extends Annotation> annotationType()
      {
        return UniqueAnnotations.Internal.class;
      }
      
      public String toString()
      {
        return "@" + UniqueAnnotations.Internal.class.getName() + "(value=" + val$value + ")";
      }
      
      public boolean equals(Object o)
      {
        return ((o instanceof UniqueAnnotations.Internal)) && (((UniqueAnnotations.Internal)o).value() == value());
      }
      
      public int hashCode()
      {
        return 127 * "value".hashCode() ^ val$value;
      }
    };
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @BindingAnnotation
  static @interface Internal
  {
    int value();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.UniqueAnnotations
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */