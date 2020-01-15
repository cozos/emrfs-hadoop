package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

@GwtCompatible(serializable=true, emulated=true)
public final class HashMultiset<E>
  extends AbstractMapBasedMultiset<E>
{
  @GwtIncompatible("Not needed in emulated source.")
  private static final long serialVersionUID = 0L;
  
  public static <E> HashMultiset<E> create()
  {
    return new HashMultiset();
  }
  
  public static <E> HashMultiset<E> create(int distinctElements)
  {
    return new HashMultiset(distinctElements);
  }
  
  public static <E> HashMultiset<E> create(Iterable<? extends E> elements)
  {
    HashMultiset<E> multiset = create(Multisets.inferDistinctElements(elements));
    
    Iterables.addAll(multiset, elements);
    return multiset;
  }
  
  private HashMultiset()
  {
    super(new HashMap());
  }
  
  private HashMultiset(int distinctElements)
  {
    super(Maps.newHashMapWithExpectedSize(distinctElements));
  }
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private void writeObject(ObjectOutputStream stream)
    throws IOException
  {
    stream.defaultWriteObject();
    Serialization.writeMultiset(this, stream);
  }
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private void readObject(ObjectInputStream stream)
    throws IOException, ClassNotFoundException
  {
    stream.defaultReadObject();
    int distinctElements = Serialization.readCount(stream);
    setBackingMap(Maps.newHashMapWithExpectedSize(distinctElements));
    
    Serialization.populateMultiset(this, stream, distinctElements);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.HashMultiset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */