package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Page;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorSupport<T, R>
  implements Iterator<T>
{
  final PageIterator<T, R> resourcePageIterator;
  private Iterator<T> localResourceIterator;
  private T resource;
  
  IteratorSupport(PageIterator<T, R> resourcePageIterator)
  {
    this.resourcePageIterator = resourcePageIterator;
  }
  
  public boolean hasNext()
  {
    if (resource != null) {
      return true;
    }
    resource = nextResource();
    return resource != null;
  }
  
  public T next()
  {
    T rval = resource;
    if (rval == null)
    {
      rval = nextResource();
      if (rval == null) {
        throw new NoSuchElementException("No more elements");
      }
    }
    else
    {
      resource = null;
    }
    return rval;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Collection is read-only");
  }
  
  private T nextResource()
  {
    for (;;)
    {
      if ((localResourceIterator != null) && (localResourceIterator.hasNext())) {
        return (T)localResourceIterator.next();
      }
      if (!resourcePageIterator.hasNext()) {
        return null;
      }
      Page<T, R> resourcePage = resourcePageIterator.next();
      localResourceIterator = resourcePage.iterator();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.IteratorSupport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */