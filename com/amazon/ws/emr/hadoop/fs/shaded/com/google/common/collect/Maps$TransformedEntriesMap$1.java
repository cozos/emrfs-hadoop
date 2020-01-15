package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Maps$TransformedEntriesMap$1
  extends Maps.EntrySet<K, V2>
{
  Maps$TransformedEntriesMap$1(Maps.TransformedEntriesMap paramTransformedEntriesMap) {}
  
  Map<K, V2> map()
  {
    return this$0;
  }
  
  public Iterator<Map.Entry<K, V2>> iterator()
  {
    return Iterators.transform(this$0.fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(this$0.transformer));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.TransformedEntriesMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */