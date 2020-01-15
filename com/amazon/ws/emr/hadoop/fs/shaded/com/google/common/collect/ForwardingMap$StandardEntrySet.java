package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import java.util.Map;

@Beta
public abstract class ForwardingMap$StandardEntrySet
  extends Maps.EntrySet<K, V>
{
  public ForwardingMap$StandardEntrySet(ForwardingMap paramForwardingMap) {}
  
  Map<K, V> map()
  {
    return this$0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingMap.StandardEntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */