package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.util.AbstractList;

final class Joiner$3
  extends AbstractList<Object>
{
  Joiner$3(Object[] paramArrayOfObject, Object paramObject1, Object paramObject2) {}
  
  public int size()
  {
    return val$rest.length + 2;
  }
  
  public Object get(int index)
  {
    switch (index)
    {
    case 0: 
      return val$first;
    case 1: 
      return val$second;
    }
    return val$rest[(index - 2)];
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */