package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;

@GwtCompatible(serializable=true)
class EmptyImmutableSetMultimap
  extends ImmutableSetMultimap<Object, Object>
{
  static final EmptyImmutableSetMultimap INSTANCE = new EmptyImmutableSetMultimap();
  private static final long serialVersionUID = 0L;
  
  private EmptyImmutableSetMultimap()
  {
    super(ImmutableMap.of(), 0, null);
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.EmptyImmutableSetMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */