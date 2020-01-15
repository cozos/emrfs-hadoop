package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.Serializable;

class $ImmutableCollection$SerializedForm
  implements Serializable
{
  final Object[] elements;
  private static final long serialVersionUID = 0L;
  
  $ImmutableCollection$SerializedForm(Object[] elements)
  {
    this.elements = elements;
  }
  
  Object readResolve()
  {
    return elements.length == 0 ? .ImmutableCollection.EMPTY_IMMUTABLE_COLLECTION : new .ImmutableCollection.ArrayImmutableCollection((Object[])elements.clone());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableCollection.SerializedForm
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */