package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.NoSuchElementException;

class $ImmutableCollection$ArrayImmutableCollection$1
  extends .UnmodifiableIterator<E>
{
  int i = 0;
  
  $ImmutableCollection$ArrayImmutableCollection$1(.ImmutableCollection.ArrayImmutableCollection paramArrayImmutableCollection) {}
  
  public boolean hasNext()
  {
    return i < .ImmutableCollection.ArrayImmutableCollection.access$300(this$0).length;
  }
  
  public E next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    return (E).ImmutableCollection.ArrayImmutableCollection.access$300(this$0)[(i++)];
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableCollection.ArrayImmutableCollection.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */