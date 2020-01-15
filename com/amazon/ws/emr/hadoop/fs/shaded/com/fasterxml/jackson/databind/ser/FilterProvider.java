package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

public abstract class FilterProvider
{
  @Deprecated
  public abstract BeanPropertyFilter findFilter(Object paramObject);
  
  public PropertyFilter findPropertyFilter(Object filterId, Object valueToFilter)
  {
    BeanPropertyFilter old = findFilter(filterId);
    if (old == null) {
      return null;
    }
    return SimpleBeanPropertyFilter.from(old);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.FilterProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */