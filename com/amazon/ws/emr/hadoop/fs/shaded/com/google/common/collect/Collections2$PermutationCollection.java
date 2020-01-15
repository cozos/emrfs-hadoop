package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

final class Collections2$PermutationCollection<E>
  extends AbstractCollection<List<E>>
{
  final ImmutableList<E> inputList;
  
  Collections2$PermutationCollection(ImmutableList<E> input)
  {
    inputList = input;
  }
  
  public int size()
  {
    return IntMath.factorial(inputList.size());
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public Iterator<List<E>> iterator()
  {
    return new Collections2.PermutationIterator(inputList);
  }
  
  public boolean contains(@Nullable Object obj)
  {
    if ((obj instanceof List))
    {
      List<?> list = (List)obj;
      return Collections2.access$100(inputList, list);
    }
    return false;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(inputList));return 14 + str.length() + "permutations(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Collections2.PermutationCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */