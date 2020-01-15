package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class LexicographicalOrdering<T>
  extends Ordering<Iterable<T>>
  implements Serializable
{
  final Ordering<? super T> elementOrder;
  private static final long serialVersionUID = 0L;
  
  LexicographicalOrdering(Ordering<? super T> elementOrder)
  {
    this.elementOrder = elementOrder;
  }
  
  public int compare(Iterable<T> leftIterable, Iterable<T> rightIterable)
  {
    Iterator<T> left = leftIterable.iterator();
    Iterator<T> right = rightIterable.iterator();
    while (left.hasNext())
    {
      if (!right.hasNext()) {
        return 1;
      }
      int result = elementOrder.compare(left.next(), right.next());
      if (result != 0) {
        return result;
      }
    }
    if (right.hasNext()) {
      return -1;
    }
    return 0;
  }
  
  public boolean equals(@Nullable Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof LexicographicalOrdering))
    {
      LexicographicalOrdering<?> that = (LexicographicalOrdering)object;
      return elementOrder.equals(elementOrder);
    }
    return false;
  }
  
  public int hashCode()
  {
    return elementOrder.hashCode() ^ 0x7BB78CF5;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(elementOrder));return 18 + str.length() + str + ".lexicographical()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LexicographicalOrdering
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */