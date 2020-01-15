package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class MultimapBuilder$MultimapBuilderWithKeys$1
  extends MultimapBuilder.ListMultimapBuilder<K0, Object>
{
  MultimapBuilder$MultimapBuilderWithKeys$1(MultimapBuilder.MultimapBuilderWithKeys paramMultimapBuilderWithKeys, int paramInt) {}
  
  public <K extends K0, V> ListMultimap<K, V> build()
  {
    return Multimaps.newListMultimap(this$0.createMap(), new MultimapBuilder.ArrayListSupplier(val$expectedValuesPerKey));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */