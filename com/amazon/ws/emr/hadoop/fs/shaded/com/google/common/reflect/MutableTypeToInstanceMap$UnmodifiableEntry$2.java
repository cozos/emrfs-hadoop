package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.Map.Entry;

final class MutableTypeToInstanceMap$UnmodifiableEntry$2
  implements Function<Map.Entry<K, V>, Map.Entry<K, V>>
{
  public Map.Entry<K, V> apply(Map.Entry<K, V> entry)
  {
    return new MutableTypeToInstanceMap.UnmodifiableEntry(entry, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */