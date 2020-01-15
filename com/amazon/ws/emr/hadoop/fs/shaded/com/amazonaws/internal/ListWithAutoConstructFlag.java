package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import java.util.ArrayList;
import java.util.Collection;

public class ListWithAutoConstructFlag<T>
  extends ArrayList<T>
{
  private static final long serialVersionUID = 1L;
  private boolean autoConstruct;
  
  public ListWithAutoConstructFlag() {}
  
  public ListWithAutoConstructFlag(Collection<? extends T> c)
  {
    super(c);
  }
  
  public ListWithAutoConstructFlag(int initialCapacity)
  {
    super(initialCapacity);
  }
  
  public void setAutoConstruct(boolean autoConstruct)
  {
    this.autoConstruct = autoConstruct;
  }
  
  public boolean isAutoConstruct()
  {
    return autoConstruct;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ListWithAutoConstructFlag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */