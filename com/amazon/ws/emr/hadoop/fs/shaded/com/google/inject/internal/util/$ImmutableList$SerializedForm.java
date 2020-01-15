package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.Serializable;

class $ImmutableList$SerializedForm
  implements Serializable
{
  final Object[] elements;
  private static final long serialVersionUID = 0L;
  
  $ImmutableList$SerializedForm(Object[] elements)
  {
    this.elements = elements;
  }
  
  Object readResolve()
  {
    return .ImmutableList.of(elements);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList.SerializedForm
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */