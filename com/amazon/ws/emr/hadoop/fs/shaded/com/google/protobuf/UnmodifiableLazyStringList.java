package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList
  extends AbstractList<String>
  implements LazyStringList, RandomAccess
{
  private final LazyStringList list;
  
  public UnmodifiableLazyStringList(LazyStringList list)
  {
    this.list = list;
  }
  
  public String get(int index)
  {
    return (String)list.get(index);
  }
  
  public int size()
  {
    return list.size();
  }
  
  public ByteString getByteString(int index)
  {
    return list.getByteString(index);
  }
  
  public void add(ByteString element)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListIterator<String> listIterator(final int index)
  {
    new ListIterator()
    {
      ListIterator<String> iter = list.listIterator(index);
      
      public boolean hasNext()
      {
        return iter.hasNext();
      }
      
      public String next()
      {
        return (String)iter.next();
      }
      
      public boolean hasPrevious()
      {
        return iter.hasPrevious();
      }
      
      public String previous()
      {
        return (String)iter.previous();
      }
      
      public int nextIndex()
      {
        return iter.nextIndex();
      }
      
      public int previousIndex()
      {
        return iter.previousIndex();
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
      
      public void set(String o)
      {
        throw new UnsupportedOperationException();
      }
      
      public void add(String o)
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  public Iterator<String> iterator()
  {
    new Iterator()
    {
      Iterator<String> iter = list.iterator();
      
      public boolean hasNext()
      {
        return iter.hasNext();
      }
      
      public String next()
      {
        return (String)iter.next();
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  public List<?> getUnderlyingElements()
  {
    return list.getUnderlyingElements();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.UnmodifiableLazyStringList
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */