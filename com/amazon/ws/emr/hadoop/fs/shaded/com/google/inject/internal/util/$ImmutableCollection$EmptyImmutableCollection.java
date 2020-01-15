package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

class $ImmutableCollection$EmptyImmutableCollection
  extends .ImmutableCollection<Object>
{
  public int size()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean contains(@.Nullable Object object)
  {
    return false;
  }
  
  public .UnmodifiableIterator<Object> iterator()
  {
    return .ImmutableCollection.access$100();
  }
  
  public Object[] toArray()
  {
    return .ImmutableCollection.access$200();
  }
  
  public <T> T[] toArray(T[] array)
  {
    if (array.length > 0) {
      array[0] = null;
    }
    return array;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableCollection.EmptyImmutableCollection
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */