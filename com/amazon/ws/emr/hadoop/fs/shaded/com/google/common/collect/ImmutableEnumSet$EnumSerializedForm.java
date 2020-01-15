package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;
import java.util.EnumSet;

class ImmutableEnumSet$EnumSerializedForm<E extends Enum<E>>
  implements Serializable
{
  final EnumSet<E> delegate;
  private static final long serialVersionUID = 0L;
  
  ImmutableEnumSet$EnumSerializedForm(EnumSet<E> delegate)
  {
    this.delegate = delegate;
  }
  
  Object readResolve()
  {
    return new ImmutableEnumSet(delegate.clone(), null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableEnumSet.EnumSerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */