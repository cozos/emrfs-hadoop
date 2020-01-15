package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

final class MultimapBuilder$1
  extends MultimapBuilder.MultimapBuilderWithKeys<Object>
{
  MultimapBuilder$1(int paramInt) {}
  
  <K, V> Map<K, Collection<V>> createMap()
  {
    return new HashMap(val$expectedKeys);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MultimapBuilder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */