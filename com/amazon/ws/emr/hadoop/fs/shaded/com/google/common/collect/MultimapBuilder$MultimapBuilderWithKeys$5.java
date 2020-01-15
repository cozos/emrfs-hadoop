package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;

class MultimapBuilder$MultimapBuilderWithKeys$5
  extends MultimapBuilder.SortedSetMultimapBuilder<K0, V0>
{
  MultimapBuilder$MultimapBuilderWithKeys$5(MultimapBuilder.MultimapBuilderWithKeys paramMultimapBuilderWithKeys, Comparator paramComparator) {}
  
  public <K extends K0, V extends V0> SortedSetMultimap<K, V> build()
  {
    return Multimaps.newSortedSetMultimap(this$0.createMap(), new MultimapBuilder.TreeSetSupplier(val$comparator));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */