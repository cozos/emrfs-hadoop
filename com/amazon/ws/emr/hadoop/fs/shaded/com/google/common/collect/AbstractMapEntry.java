package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractMapEntry<K, V>
  implements Map.Entry<K, V>
{
  public abstract K getKey();
  
  public abstract V getValue();
  
  public V setValue(V value)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof Map.Entry))
    {
      Map.Entry<?, ?> that = (Map.Entry)object;
      return (Objects.equal(getKey(), that.getKey())) && (Objects.equal(getValue(), that.getValue()));
    }
    return false;
  }
  
  public int hashCode()
  {
    K k = getKey();
    V v = getValue();
    return (k == null ? 0 : k.hashCode()) ^ (v == null ? 0 : v.hashCode());
  }
  
  public String toString()
  {
    String str1 = String.valueOf(String.valueOf(getKey()));String str2 = String.valueOf(String.valueOf(getValue()));return 1 + str1.length() + str2.length() + str1 + "=" + str2;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */