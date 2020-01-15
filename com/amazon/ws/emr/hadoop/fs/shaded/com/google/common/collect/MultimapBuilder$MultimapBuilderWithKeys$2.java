package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class MultimapBuilder$MultimapBuilderWithKeys$2
  extends MultimapBuilder.ListMultimapBuilder<K0, Object>
{
  MultimapBuilder$MultimapBuilderWithKeys$2(MultimapBuilder.MultimapBuilderWithKeys paramMultimapBuilderWithKeys) {}
  
  public <K extends K0, V> ListMultimap<K, V> build()
  {
    return Multimaps.newListMultimap(this$0.createMap(), MultimapBuilder.LinkedListSupplier.instance());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */