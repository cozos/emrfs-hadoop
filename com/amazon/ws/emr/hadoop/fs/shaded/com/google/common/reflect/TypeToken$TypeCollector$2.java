package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import java.util.Arrays;
import javax.annotation.Nullable;

final class TypeToken$TypeCollector$2
  extends TypeToken.TypeCollector<Class<?>>
{
  TypeToken$TypeCollector$2()
  {
    super(null);
  }
  
  Class<?> getRawType(Class<?> type)
  {
    return type;
  }
  
  Iterable<? extends Class<?>> getInterfaces(Class<?> type)
  {
    return Arrays.asList(type.getInterfaces());
  }
  
  @Nullable
  Class<?> getSuperclass(Class<?> type)
  {
    return type.getSuperclass();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.TypeCollector.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */