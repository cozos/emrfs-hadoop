package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.util.Iterator;

class Converter$1$1
  implements Iterator<B>
{
  private final Iterator<? extends A> fromIterator = this$1.val$fromIterable.iterator();
  
  Converter$1$1(Converter.1 param1) {}
  
  public boolean hasNext()
  {
    return fromIterator.hasNext();
  }
  
  public B next()
  {
    return (B)this$1.this$0.convert(fromIterator.next());
  }
  
  public void remove()
  {
    fromIterator.remove();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Converter.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */