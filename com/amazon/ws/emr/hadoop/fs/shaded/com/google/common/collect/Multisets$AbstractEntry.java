package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import javax.annotation.Nullable;

abstract class Multisets$AbstractEntry<E>
  implements Multiset.Entry<E>
{
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof Multiset.Entry))
    {
      Multiset.Entry<?> that = (Multiset.Entry)object;
      return (getCount() == that.getCount()) && (Objects.equal(getElement(), that.getElement()));
    }
    return false;
  }
  
  public int hashCode()
  {
    E e = getElement();
    return (e == null ? 0 : e.hashCode()) ^ getCount();
  }
  
  public String toString()
  {
    String text = String.valueOf(getElement());
    int n = getCount();
    String str1 = String.valueOf(String.valueOf(text));int i = n;return 14 + str1.length() + str1 + " x " + i;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.AbstractEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */