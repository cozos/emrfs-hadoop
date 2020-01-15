package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Binding;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Maps;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class InjectorImpl$BindingsMultimap
{
  final Map<TypeLiteral<?>, List<Binding<?>>> multimap = .Maps.newHashMap();
  
  <T> void put(TypeLiteral<T> type, Binding<T> binding)
  {
    List<Binding<?>> bindingsForType = (List)multimap.get(type);
    if (bindingsForType == null)
    {
      bindingsForType = .Lists.newArrayList();
      multimap.put(type, bindingsForType);
    }
    bindingsForType.add(binding);
  }
  
  <T> List<Binding<T>> getAll(TypeLiteral<T> type)
  {
    List<Binding<?>> bindings = (List)multimap.get(type);
    return bindings != null ? Collections.unmodifiableList((List)multimap.get(type)) : .ImmutableList.of();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.InjectorImpl.BindingsMultimap
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */