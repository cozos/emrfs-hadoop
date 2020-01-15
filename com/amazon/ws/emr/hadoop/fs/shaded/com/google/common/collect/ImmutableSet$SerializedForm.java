package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;

class ImmutableSet$SerializedForm
  implements Serializable
{
  final Object[] elements;
  private static final long serialVersionUID = 0L;
  
  ImmutableSet$SerializedForm(Object[] elements)
  {
    this.elements = elements;
  }
  
  Object readResolve()
  {
    return ImmutableSet.copyOf(elements);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */