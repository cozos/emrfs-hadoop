package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.Collection;

final class Collections2$1
  implements Function<Object, Object>
{
  Collections2$1(Collection paramCollection) {}
  
  public Object apply(Object input)
  {
    return input == val$collection ? "(this Collection)" : input;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Collections2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */