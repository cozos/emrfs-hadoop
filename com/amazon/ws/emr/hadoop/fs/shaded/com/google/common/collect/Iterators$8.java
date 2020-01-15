package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.Iterator;

final class Iterators$8
  extends TransformedIterator<F, T>
{
  Iterators$8(Iterator x0, Function paramFunction)
  {
    super(x0);
  }
  
  T transform(F from)
  {
    return (T)val$function.apply(from);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */