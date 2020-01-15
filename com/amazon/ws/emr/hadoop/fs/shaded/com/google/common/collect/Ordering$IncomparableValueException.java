package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;

@VisibleForTesting
class Ordering$IncomparableValueException
  extends ClassCastException
{
  final Object value;
  private static final long serialVersionUID = 0L;
  
  Ordering$IncomparableValueException(Object value)
  {
    super(22 + str.length() + "Cannot compare value: " + str);
    this.value = value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Ordering.IncomparableValueException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */