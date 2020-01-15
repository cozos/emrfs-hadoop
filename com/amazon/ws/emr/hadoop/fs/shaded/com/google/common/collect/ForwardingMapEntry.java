package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingMapEntry<K, V>
  extends ForwardingObject
  implements Map.Entry<K, V>
{
  protected abstract Map.Entry<K, V> delegate();
  
  public K getKey()
  {
    return (K)delegate().getKey();
  }
  
  public V getValue()
  {
    return (V)delegate().getValue();
  }
  
  public V setValue(V value)
  {
    return (V)delegate().setValue(value);
  }
  
  public boolean equals(@Nullable Object object)
  {
    return delegate().equals(object);
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  protected boolean standardEquals(@Nullable Object object)
  {
    if ((object instanceof Map.Entry))
    {
      Map.Entry<?, ?> that = (Map.Entry)object;
      return (Objects.equal(getKey(), that.getKey())) && (Objects.equal(getValue(), that.getValue()));
    }
    return false;
  }
  
  protected int standardHashCode()
  {
    K k = getKey();
    V v = getValue();
    return (k == null ? 0 : k.hashCode()) ^ (v == null ? 0 : v.hashCode());
  }
  
  @Beta
  protected String standardToString()
  {
    String str1 = String.valueOf(String.valueOf(getKey()));String str2 = String.valueOf(String.valueOf(getValue()));return 1 + str1.length() + str2.length() + str1 + "=" + str2;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingMapEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */