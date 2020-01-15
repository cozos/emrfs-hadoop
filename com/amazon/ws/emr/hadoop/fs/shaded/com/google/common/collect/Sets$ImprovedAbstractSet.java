package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.AbstractSet;
import java.util.Collection;

abstract class Sets$ImprovedAbstractSet<E>
  extends AbstractSet<E>
{
  public boolean removeAll(Collection<?> c)
  {
    return Sets.removeAllImpl(this, c);
  }
  
  public boolean retainAll(Collection<?> c)
  {
    return super.retainAll((Collection)Preconditions.checkNotNull(c));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.ImprovedAbstractSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */