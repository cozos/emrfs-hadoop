package com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf;

import java.util.ListIterator;

class UnmodifiableLazyStringList$1
  implements ListIterator<String>
{
  ListIterator<String> iter = UnmodifiableLazyStringList.access$000(this$0).listIterator(val$index);
  
  UnmodifiableLazyStringList$1(UnmodifiableLazyStringList paramUnmodifiableLazyStringList, int paramInt) {}
  
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.protobuf.UnmodifiableLazyStringList.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */