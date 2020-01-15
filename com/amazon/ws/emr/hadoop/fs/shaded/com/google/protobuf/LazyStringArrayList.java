package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList
  extends AbstractList<String>
  implements LazyStringList, RandomAccess
{
  public static final LazyStringList EMPTY = new UnmodifiableLazyStringList(new LazyStringArrayList());
  private final List<Object> list;
  
  public LazyStringArrayList()
  {
    list = new ArrayList();
  }
  
  public LazyStringArrayList(LazyStringList from)
  {
    list = new ArrayList(from.size());
    addAll(from);
  }
  
  public LazyStringArrayList(List<String> from)
  {
    list = new ArrayList(from);
  }
  
  public String get(int index)
  {
    Object o = list.get(index);
    if ((o instanceof String)) {
      return (String)o;
    }
    ByteString bs = (ByteString)o;
    String s = bs.toStringUtf8();
    if (bs.isValidUtf8()) {
      list.set(index, s);
    }
    return s;
  }
  
  public int size()
  {
    return list.size();
  }
  
  public String set(int index, String s)
  {
    Object o = list.set(index, s);
    return asString(o);
  }
  
  public void add(int index, String element)
  {
    list.add(index, element);
    modCount += 1;
  }
  
  public boolean addAll(Collection<? extends String> c)
  {
    return addAll(size(), c);
  }
  
  public boolean addAll(int index, Collection<? extends String> c)
  {
    Collection<?> collection = (c instanceof LazyStringList) ? ((LazyStringList)c).getUnderlyingElements() : c;
    
    boolean ret = list.addAll(index, collection);
    modCount += 1;
    return ret;
  }
  
  public String remove(int index)
  {
    Object o = list.remove(index);
    modCount += 1;
    return asString(o);
  }
  
  public void clear()
  {
    list.clear();
    modCount += 1;
  }
  
  public void add(ByteString element)
  {
    list.add(element);
    modCount += 1;
  }
  
  public ByteString getByteString(int index)
  {
    Object o = list.get(index);
    if ((o instanceof String))
    {
      ByteString b = ByteString.copyFromUtf8((String)o);
      list.set(index, b);
      return b;
    }
    return (ByteString)o;
  }
  
  private String asString(Object o)
  {
    if ((o instanceof String)) {
      return (String)o;
    }
    return ((ByteString)o).toStringUtf8();
  }
  
  public List<?> getUnderlyingElements()
  {
    return Collections.unmodifiableList(list);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.LazyStringArrayList
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */