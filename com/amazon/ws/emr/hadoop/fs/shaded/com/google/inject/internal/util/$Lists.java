package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public final class $Lists
{
  public static <E> ArrayList<E> newArrayList()
  {
    return new ArrayList();
  }
  
  public static <E> ArrayList<E> newArrayList(E... elements)
  {
    int capacity = computeArrayListCapacity(elements.length);
    ArrayList<E> list = new ArrayList(capacity);
    Collections.addAll(list, elements);
    return list;
  }
  
  static int computeArrayListCapacity(int arraySize)
  {
    .Preconditions.checkArgument(arraySize >= 0);
    
    return (int)Math.min(5L + arraySize + arraySize / 10, 2147483647L);
  }
  
  public static <E> ArrayList<E> newArrayList(Iterable<? extends E> elements)
  {
    if ((elements instanceof Collection))
    {
      Collection<? extends E> collection = (Collection)elements;
      return new ArrayList(collection);
    }
    return newArrayList(elements.iterator());
  }
  
  public static <E> ArrayList<E> newArrayList(Iterator<? extends E> elements)
  {
    ArrayList<E> list = newArrayList();
    while (elements.hasNext()) {
      list.add(elements.next());
    }
    return list;
  }
  
  public static <E> ArrayList<E> newArrayList(@.Nullable E first, E[] rest)
  {
    ArrayList<E> result = new ArrayList(rest.length + 1);
    result.add(first);
    for (E element : rest) {
      result.add(element);
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Lists
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */