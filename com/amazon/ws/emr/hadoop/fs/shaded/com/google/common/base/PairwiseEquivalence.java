package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class PairwiseEquivalence<T>
  extends Equivalence<Iterable<T>>
  implements Serializable
{
  final Equivalence<? super T> elementEquivalence;
  private static final long serialVersionUID = 1L;
  
  PairwiseEquivalence(Equivalence<? super T> elementEquivalence)
  {
    this.elementEquivalence = ((Equivalence)Preconditions.checkNotNull(elementEquivalence));
  }
  
  protected boolean doEquivalent(Iterable<T> iterableA, Iterable<T> iterableB)
  {
    Iterator<T> iteratorA = iterableA.iterator();
    Iterator<T> iteratorB = iterableB.iterator();
    while ((iteratorA.hasNext()) && (iteratorB.hasNext())) {
      if (!elementEquivalence.equivalent(iteratorA.next(), iteratorB.next())) {
        return false;
      }
    }
    return (!iteratorA.hasNext()) && (!iteratorB.hasNext());
  }
  
  protected int doHash(Iterable<T> iterable)
  {
    int hash = 78721;
    for (T element : iterable) {
      hash = hash * 24943 + elementEquivalence.hash(element);
    }
    return hash;
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof PairwiseEquivalence))
    {
      PairwiseEquivalence<?> that = (PairwiseEquivalence)object;
      return elementEquivalence.equals(elementEquivalence);
    }
    return false;
  }
  
  public int hashCode()
  {
    return elementEquivalence.hashCode() ^ 0x46A3EB07;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(elementEquivalence));return 11 + str.length() + str + ".pairwise()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.PairwiseEquivalence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */