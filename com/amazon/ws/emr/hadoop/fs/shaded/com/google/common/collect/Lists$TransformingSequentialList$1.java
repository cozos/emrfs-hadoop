package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.ListIterator;

class Lists$TransformingSequentialList$1
  extends TransformedListIterator<F, T>
{
  Lists$TransformingSequentialList$1(Lists.TransformingSequentialList paramTransformingSequentialList, ListIterator x0)
  {
    super(x0);
  }
  
  T transform(F from)
  {
    return (T)this$0.function.apply(from);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists.TransformingSequentialList.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */