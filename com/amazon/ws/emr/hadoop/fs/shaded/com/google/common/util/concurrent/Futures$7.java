package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

final class Futures$7
  implements Function<Constructor<?>, Boolean>
{
  public Boolean apply(Constructor<?> input)
  {
    return Boolean.valueOf(Arrays.asList(input.getParameterTypes()).contains(String.class));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */