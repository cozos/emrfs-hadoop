package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class MultimapBuilder$MultimapBuilderWithKeys$4
  extends MultimapBuilder.SetMultimapBuilder<K0, Object>
{
  MultimapBuilder$MultimapBuilderWithKeys$4(MultimapBuilder.MultimapBuilderWithKeys paramMultimapBuilderWithKeys, int paramInt) {}
  
  public <K extends K0, V> SetMultimap<K, V> build()
  {
    return Multimaps.newSetMultimap(this$0.createMap(), new MultimapBuilder.LinkedHashSetSupplier(val$expectedValuesPerKey));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */