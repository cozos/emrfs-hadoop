package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class $Sets
{
  public static <E> HashSet<E> newHashSet()
  {
    return new HashSet();
  }
  
  public static <E> LinkedHashSet<E> newLinkedHashSet()
  {
    return new LinkedHashSet();
  }
  
  public static <E> Set<E> newSetFromMap(Map<E, Boolean> map)
  {
    return new SetFromMap(map);
  }
  
  private static class SetFromMap<E>
    extends AbstractSet<E>
    implements Set<E>, Serializable
  {
    private final Map<E, Boolean> m;
    private transient Set<E> s;
    static final long serialVersionUID = 0L;
    
    SetFromMap(Map<E, Boolean> map)
    {
      .Preconditions.checkArgument(map.isEmpty(), "Map is non-empty");
      m = map;
      s = map.keySet();
    }
    
    public void clear()
    {
      m.clear();
    }
    
    public int size()
    {
      return m.size();
    }
    
    public boolean isEmpty()
    {
      return m.isEmpty();
    }
    
    public boolean contains(Object o)
    {
      return m.containsKey(o);
    }
    
    public boolean remove(Object o)
    {
      return m.remove(o) != null;
    }
    
    public boolean add(E e)
    {
      return m.put(e, Boolean.TRUE) == null;
    }
    
    public Iterator<E> iterator()
    {
      return s.iterator();
    }
    
    public Object[] toArray()
    {
      return s.toArray();
    }
    
    public <T> T[] toArray(T[] a)
    {
      return s.toArray(a);
    }
    
    public String toString()
    {
      return s.toString();
    }
    
    public int hashCode()
    {
      return s.hashCode();
    }
    
    public boolean equals(@.Nullable Object object)
    {
      return (this == object) || (s.equals(object));
    }
    
    public boolean containsAll(Collection<?> c)
    {
      return s.containsAll(c);
    }
    
    public boolean removeAll(Collection<?> c)
    {
      return s.removeAll(c);
    }
    
    public boolean retainAll(Collection<?> c)
    {
      return s.retainAll(c);
    }
    
    private void readObject(ObjectInputStream stream)
      throws IOException, ClassNotFoundException
    {
      stream.defaultReadObject();
      s = m.keySet();
    }
  }
  
  static int hashCodeImpl(Set<?> s)
  {
    int hashCode = 0;
    for (Object o : s) {
      hashCode += (o != null ? o.hashCode() : 0);
    }
    return hashCode;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Sets
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */