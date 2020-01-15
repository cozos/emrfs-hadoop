package com.amazon.ws.emr.hadoop.fs.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

public final class MorePreconditions
{
  private MorePreconditions()
  {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }
  
  public static void checkNotNegative(long position, String valueName)
  {
    Preconditions.checkArgument(position >= 0L, 
      String.format("Invalid %s: %d, should not be negative", new Object[] { valueName, Long.valueOf(position) }));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.MorePreconditions
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */