package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.util.Set;

class MultimapBuilder$MultimapBuilderWithKeys$6
  extends MultimapBuilder.SetMultimapBuilder<K0, V0>
{
  MultimapBuilder$MultimapBuilderWithKeys$6(MultimapBuilder.MultimapBuilderWithKeys paramMultimapBuilderWithKeys, Class paramClass) {}
  
  public <K extends K0, V extends V0> SetMultimap<K, V> build()
  {
    Supplier<Set<V>> factory = new MultimapBuilder.EnumSetSupplier(val$valueClass);
    return Multimaps.newSetMultimap(this$0.createMap(), factory);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */