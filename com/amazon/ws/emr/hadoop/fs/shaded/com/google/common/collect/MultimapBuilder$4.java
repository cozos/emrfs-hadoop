package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

final class MultimapBuilder$4
  extends MultimapBuilder.MultimapBuilderWithKeys<K0>
{
  MultimapBuilder$4(Class paramClass) {}
  
  <K extends K0, V> Map<K, Collection<V>> createMap()
  {
    return new EnumMap(val$keyClass);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MultimapBuilder.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */