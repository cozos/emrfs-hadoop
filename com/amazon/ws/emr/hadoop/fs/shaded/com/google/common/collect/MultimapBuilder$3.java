package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

final class MultimapBuilder$3
  extends MultimapBuilder.MultimapBuilderWithKeys<K0>
{
  MultimapBuilder$3(Comparator paramComparator) {}
  
  <K extends K0, V> Map<K, Collection<V>> createMap()
  {
    return new TreeMap(val$comparator);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MultimapBuilder.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */