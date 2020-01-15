package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class POJOPropertyBuilder$MemberIterator<T extends AnnotatedMember>
  implements Iterator<T>
{
  private POJOPropertyBuilder.Linked<T> next;
  
  public POJOPropertyBuilder$MemberIterator(POJOPropertyBuilder.Linked<T> first)
  {
    next = first;
  }
  
  public boolean hasNext()
  {
    return next != null;
  }
  
  public T next()
  {
    if (next == null) {
      throw new NoSuchElementException();
    }
    T result = (AnnotatedMember)next.value;
    next = next.next;
    return result;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.MemberIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */