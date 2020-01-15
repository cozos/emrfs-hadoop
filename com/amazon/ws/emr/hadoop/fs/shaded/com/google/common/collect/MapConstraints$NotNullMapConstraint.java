package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

 enum MapConstraints$NotNullMapConstraint
  implements MapConstraint<Object, Object>
{
  INSTANCE;
  
  private MapConstraints$NotNullMapConstraint() {}
  
  public void checkKeyValue(Object key, Object value)
  {
    Preconditions.checkNotNull(key);
    Preconditions.checkNotNull(value);
  }
  
  public String toString()
  {
    return "Not null";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.NotNullMapConstraint
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */