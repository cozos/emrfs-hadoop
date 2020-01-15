package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Map.Entry;

class $ImmutableMap$RegularImmutableMap$Values$1
  extends .AbstractIterator<V>
{
  int index = 0;
  
  $ImmutableMap$RegularImmutableMap$Values$1(.ImmutableMap.RegularImmutableMap.Values paramValues) {}
  
  protected V computeNext()
  {
    return (V)(index < .ImmutableMap.RegularImmutableMap.access$500(this$0.map).length ? .ImmutableMap.RegularImmutableMap.access$500(this$0.map)[(index++)].getValue() : endOfData());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap.RegularImmutableMap.Values.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */