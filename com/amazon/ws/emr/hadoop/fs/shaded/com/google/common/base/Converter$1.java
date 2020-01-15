package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.util.Iterator;

class Converter$1
  implements Iterable<B>
{
  Converter$1(Converter paramConverter, Iterable paramIterable) {}
  
  public Iterator<B> iterator()
  {
    new Iterator()
    {
      private final Iterator<? extends A> fromIterator = val$fromIterable.iterator();
      
      public boolean hasNext()
      {
        return fromIterator.hasNext();
      }
      
      public B next()
      {
        return (B)this$0.convert(fromIterator.next());
      }
      
      public void remove()
      {
        fromIterator.remove();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Converter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */