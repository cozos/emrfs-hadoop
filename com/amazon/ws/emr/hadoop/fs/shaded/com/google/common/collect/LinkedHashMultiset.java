package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;

@GwtCompatible(serializable=true, emulated=true)
public final class LinkedHashMultiset<E>
  extends AbstractMapBasedMultiset<E>
{
  @GwtIncompatible("not needed in emulated source")
  private static final long serialVersionUID = 0L;
  
  public static <E> LinkedHashMultiset<E> create()
  {
    return new LinkedHashMultiset();
  }
  
  public static <E> LinkedHashMultiset<E> create(int distinctElements)
  {
    return new LinkedHashMultiset(distinctElements);
  }
  
  public static <E> LinkedHashMultiset<E> create(Iterable<? extends E> elements)
  {
    LinkedHashMultiset<E> multiset = create(Multisets.inferDistinctElements(elements));
    
    Iterables.addAll(multiset, elements);
    return multiset;
  }
  
  private LinkedHashMultiset()
  {
    super(new LinkedHashMap());
  }
  
  private LinkedHashMultiset(int distinctElements)
  {
    super(new LinkedHashMap(Maps.capacity(distinctElements)));
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
    setBackingMap(new LinkedHashMap(Maps.capacity(distinctElements)));
    
    Serialization.populateMultiset(this, stream, distinctElements);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedHashMultiset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */