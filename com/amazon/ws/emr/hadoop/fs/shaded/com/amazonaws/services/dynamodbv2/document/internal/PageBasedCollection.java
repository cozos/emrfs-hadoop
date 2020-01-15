package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.LowLevelResultListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Page;

public abstract class PageBasedCollection<T, R>
  implements Iterable<T>
{
  private volatile R lastLowLevelResult;
  private volatile LowLevelResultListener<R> listener = LowLevelResultListener.none();
  
  public IteratorSupport<T, R> iterator()
  {
    PageIterable<T, R> pageIterable = pages();
    PageIterator<T, R> pageIterator = pageIterable.iterator();
    return new IteratorSupport(pageIterator);
  }
  
  public PageIterable<T, R> pages()
  {
    return new PageIterable(this);
  }
  
  public abstract Page<T, R> firstPage();
  
  public abstract Integer getMaxResultSize();
  
  public R getLastLowLevelResult()
  {
    return (R)lastLowLevelResult;
  }
  
  protected void setLastLowLevelResult(R lowLevelResult)
  {
    lastLowLevelResult = lowLevelResult;
    
    listener.onLowLevelResult(lowLevelResult);
  }
  
  public LowLevelResultListener<R> registerLowLevelResultListener(LowLevelResultListener<R> listener)
  {
    LowLevelResultListener<R> prev = this.listener;
    if (listener == null) {
      this.listener = LowLevelResultListener.none();
    } else {
      this.listener = listener;
    }
    return prev;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.PageBasedCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */