package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import java.util.ArrayList;
import java.util.Collection;

public class SdkInternalList<T>
  extends ArrayList<T>
{
  private static final long serialVersionUID = 1L;
  private final boolean autoConstruct;
  
  public SdkInternalList()
  {
    autoConstruct = true;
  }
  
  public SdkInternalList(Collection<? extends T> c)
  {
    super(c);
    autoConstruct = false;
  }
  
  public SdkInternalList(int initialCapacity)
  {
    super(initialCapacity);
    autoConstruct = false;
  }
  
  public boolean isAutoConstruct()
  {
    return autoConstruct;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */