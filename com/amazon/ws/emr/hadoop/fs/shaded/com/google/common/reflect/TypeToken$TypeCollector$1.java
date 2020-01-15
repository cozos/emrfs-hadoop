package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import javax.annotation.Nullable;

final class TypeToken$TypeCollector$1
  extends TypeToken.TypeCollector<TypeToken<?>>
{
  TypeToken$TypeCollector$1()
  {
    super(null);
  }
  
  Class<?> getRawType(TypeToken<?> type)
  {
    return type.getRawType();
  }
  
  Iterable<? extends TypeToken<?>> getInterfaces(TypeToken<?> type)
  {
    return type.getGenericInterfaces();
  }
  
  @Nullable
  TypeToken<?> getSuperclass(TypeToken<?> type)
  {
    return type.getGenericSuperclass();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.TypeCollector.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */