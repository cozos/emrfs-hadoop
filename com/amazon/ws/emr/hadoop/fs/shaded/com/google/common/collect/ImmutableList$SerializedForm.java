package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;

class ImmutableList$SerializedForm
  implements Serializable
{
  final Object[] elements;
  private static final long serialVersionUID = 0L;
  
  ImmutableList$SerializedForm(Object[] elements)
  {
    this.elements = elements;
  }
  
  Object readResolve()
  {
    return ImmutableList.copyOf(elements);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */