package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.lang.reflect.Type;

final class Types$1
  implements Function<Type, String>
{
  public String apply(Type from)
  {
    return Types.JavaVersion.CURRENT.typeName(from);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Types.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */