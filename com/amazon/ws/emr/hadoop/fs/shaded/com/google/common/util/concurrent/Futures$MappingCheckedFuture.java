package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

class Futures$MappingCheckedFuture<V, X extends Exception>
  extends AbstractCheckedFuture<V, X>
{
  final Function<? super Exception, X> mapper;
  
  Futures$MappingCheckedFuture(ListenableFuture<V> delegate, Function<? super Exception, X> mapper)
  {
    super(delegate);
    
    this.mapper = ((Function)Preconditions.checkNotNull(mapper));
  }
  
  protected X mapException(Exception e)
  {
    return (Exception)mapper.apply(e);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.MappingCheckedFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */