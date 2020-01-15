package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.Iterator;
import java.util.Map.Entry;

final class Maps$2
  extends TransformedIterator<K, Map.Entry<K, V>>
{
  Maps$2(Iterator x0, Function paramFunction)
  {
    super(x0);
  }
  
  Map.Entry<K, V> transform(K key)
  {
    return Maps.immutableEntry(key, val$function.apply(key));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */