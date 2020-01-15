package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

class $ImmutableSet$TransformedImmutableSet$1
  extends .AbstractIterator<E>
{
  int index = 0;
  
  $ImmutableSet$TransformedImmutableSet$1(.ImmutableSet.TransformedImmutableSet paramTransformedImmutableSet) {}
  
  protected E computeNext()
  {
    return (E)(index < this$0.source.length ? this$0.transform(this$0.source[(index++)]) : endOfData());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet.TransformedImmutableSet.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */