package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;

@GwtIncompatible("serialization")
class ImmutableAsList$SerializedForm
  implements Serializable
{
  final ImmutableCollection<?> collection;
  private static final long serialVersionUID = 0L;
  
  ImmutableAsList$SerializedForm(ImmutableCollection<?> collection)
  {
    this.collection = collection;
  }
  
  Object readResolve()
  {
    return collection.asList();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableAsList.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */