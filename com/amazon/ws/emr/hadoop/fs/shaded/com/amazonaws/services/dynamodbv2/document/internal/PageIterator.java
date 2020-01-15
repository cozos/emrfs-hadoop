package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Page;
import java.util.Iterator;

class PageIterator<T, R>
  implements Iterator<Page<T, R>>
{
  private Page<T, R> page;
  private final PageBasedCollection<T, R> col;
  
  PageIterator(PageBasedCollection<T, R> col)
  {
    this.col = col;
  }
  
  public boolean hasNext()
  {
    Integer max = col.getMaxResultSize();
    if ((max != null) && (max.intValue() <= 0)) {
      return false;
    }
    return (page == null) || (page.hasNextPage());
  }
  
  public Page<T, R> next()
  {
    if (page == null)
    {
      page = col.firstPage();
    }
    else
    {
      page = page.nextPage();
      col.setLastLowLevelResult(page.getLowLevelResult());
    }
    return page;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Collection is read-only");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.PageIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */