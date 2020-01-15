package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.PageBasedCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.PageIterable;

public abstract class TableCollection<R>
  extends PageBasedCollection<Table, R>
{
  public PageIterable<Table, R> pages()
  {
    return super.pages();
  }
  
  public abstract Integer getMaxResultSize();
  
  public R getLastLowLevelResult()
  {
    return (R)super.getLastLowLevelResult();
  }
  
  public LowLevelResultListener<R> registerLowLevelResultListener(LowLevelResultListener<R> listener)
  {
    return super.registerLowLevelResultListener(listener);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.TableCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */