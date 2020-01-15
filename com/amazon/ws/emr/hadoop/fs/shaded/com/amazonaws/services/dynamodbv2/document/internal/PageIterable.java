package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Page;

public class PageIterable<T, R>
  implements Iterable<Page<T, R>>
{
  private final PageBasedCollection<T, R> col;
  
  PageIterable(PageBasedCollection<T, R> col)
  {
    this.col = col;
  }
  
  public PageIterator<T, R> iterator()
  {
    return new PageIterator(col);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.PageIterable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */