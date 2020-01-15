package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet;

class TypeToken$TypeCollector$3
  extends TypeToken.TypeCollector.ForwardingTypeCollector<K>
{
  TypeToken$TypeCollector$3(TypeToken.TypeCollector paramTypeCollector1, TypeToken.TypeCollector x0)
  {
    super(x0);
  }
  
  Iterable<? extends K> getInterfaces(K type)
  {
    return ImmutableSet.of();
  }
  
  ImmutableList<K> collectTypes(Iterable<? extends K> types)
  {
    ImmutableList.Builder<K> builder = ImmutableList.builder();
    for (K type : types) {
      if (!getRawType(type).isInterface()) {
        builder.add(type);
      }
    }
    return super.collectTypes(builder.build());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.TypeCollector.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */