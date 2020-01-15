package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.FilterProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.PropertyFilter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SimpleFilterProvider
  extends FilterProvider
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected final Map<String, PropertyFilter> _filtersById;
  protected PropertyFilter _defaultFilter;
  protected boolean _cfgFailOnUnknownId = true;
  
  public SimpleFilterProvider()
  {
    this(new HashMap());
  }
  
  public SimpleFilterProvider(Map<String, ?> mapping)
  {
    for (Object ob : mapping.values()) {
      if (!(ob instanceof PropertyFilter))
      {
        _filtersById = _convert(mapping);
        return;
      }
    }
    _filtersById = mapping;
  }
  
  private static final Map<String, PropertyFilter> _convert(Map<String, ?> filters)
  {
    HashMap<String, PropertyFilter> result = new HashMap();
    for (Map.Entry<String, ?> entry : filters.entrySet())
    {
      Object f = entry.getValue();
      if ((f instanceof PropertyFilter)) {
        result.put(entry.getKey(), (PropertyFilter)f);
      } else if ((f instanceof BeanPropertyFilter)) {
        result.put(entry.getKey(), _convert((BeanPropertyFilter)f));
      } else {
        throw new IllegalArgumentException("Unrecognized filter type (" + f.getClass().getName() + ")");
      }
    }
    return result;
  }
  
  private static final PropertyFilter _convert(BeanPropertyFilter f)
  {
    return SimpleBeanPropertyFilter.from(f);
  }
  
  @Deprecated
  public SimpleFilterProvider setDefaultFilter(BeanPropertyFilter f)
  {
    _defaultFilter = SimpleBeanPropertyFilter.from(f);
    return this;
  }
  
  public SimpleFilterProvider setDefaultFilter(PropertyFilter f)
  {
    _defaultFilter = f;
    return this;
  }
  
  public SimpleFilterProvider setDefaultFilter(SimpleBeanPropertyFilter f)
  {
    _defaultFilter = f;
    return this;
  }
  
  public PropertyFilter getDefaultFilter()
  {
    return _defaultFilter;
  }
  
  public SimpleFilterProvider setFailOnUnknownId(boolean state)
  {
    _cfgFailOnUnknownId = state;
    return this;
  }
  
  public boolean willFailOnUnknownId()
  {
    return _cfgFailOnUnknownId;
  }
  
  @Deprecated
  public SimpleFilterProvider addFilter(String id, BeanPropertyFilter filter)
  {
    _filtersById.put(id, _convert(filter));
    return this;
  }
  
  public SimpleFilterProvider addFilter(String id, PropertyFilter filter)
  {
    _filtersById.put(id, filter);
    return this;
  }
  
  public SimpleFilterProvider addFilter(String id, SimpleBeanPropertyFilter filter)
  {
    _filtersById.put(id, filter);
    return this;
  }
  
  public PropertyFilter removeFilter(String id)
  {
    return (PropertyFilter)_filtersById.remove(id);
  }
  
  @Deprecated
  public BeanPropertyFilter findFilter(Object filterId)
  {
    throw new UnsupportedOperationException("Access to deprecated filters not supported");
  }
  
  public PropertyFilter findPropertyFilter(Object filterId, Object valueToFilter)
  {
    PropertyFilter f = (PropertyFilter)_filtersById.get(filterId);
    if (f == null)
    {
      f = _defaultFilter;
      if ((f == null) && (_cfgFailOnUnknownId)) {
        throw new IllegalArgumentException("No filter configured with id '" + filterId + "' (type " + filterId.getClass().getName() + ")");
      }
    }
    return f;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */