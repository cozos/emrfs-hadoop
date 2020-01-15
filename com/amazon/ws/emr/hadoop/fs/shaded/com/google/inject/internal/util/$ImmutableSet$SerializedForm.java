package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.Serializable;

class $ImmutableSet$SerializedForm
  implements Serializable
{
  final Object[] elements;
  private static final long serialVersionUID = 0L;
  
  $ImmutableSet$SerializedForm(Object[] elements)
  {
    this.elements = elements;
  }
  
  Object readResolve()
  {
    return .ImmutableSet.of(elements);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet.SerializedForm
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */