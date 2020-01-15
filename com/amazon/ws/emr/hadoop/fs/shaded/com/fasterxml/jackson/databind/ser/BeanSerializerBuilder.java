package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import java.util.List;

public class BeanSerializerBuilder
{
  private static final BeanPropertyWriter[] NO_PROPERTIES = new BeanPropertyWriter[0];
  protected final BeanDescription _beanDesc;
  protected SerializationConfig _config;
  protected List<BeanPropertyWriter> _properties;
  protected BeanPropertyWriter[] _filteredProperties;
  protected AnyGetterWriter _anyGetter;
  protected Object _filterId;
  protected AnnotatedMember _typeId;
  protected ObjectIdWriter _objectIdWriter;
  
  public BeanSerializerBuilder(BeanDescription beanDesc)
  {
    _beanDesc = beanDesc;
  }
  
  protected BeanSerializerBuilder(BeanSerializerBuilder src)
  {
    _beanDesc = _beanDesc;
    _properties = _properties;
    _filteredProperties = _filteredProperties;
    _anyGetter = _anyGetter;
    _filterId = _filterId;
  }
  
  protected void setConfig(SerializationConfig config)
  {
    _config = config;
  }
  
  public void setProperties(List<BeanPropertyWriter> properties)
  {
    _properties = properties;
  }
  
  public void setFilteredProperties(BeanPropertyWriter[] properties)
  {
    _filteredProperties = properties;
  }
  
  public void setAnyGetter(AnyGetterWriter anyGetter)
  {
    _anyGetter = anyGetter;
  }
  
  public void setFilterId(Object filterId)
  {
    _filterId = filterId;
  }
  
  public void setTypeId(AnnotatedMember idProp)
  {
    if (_typeId != null) {
      throw new IllegalArgumentException("Multiple type ids specified with " + _typeId + " and " + idProp);
    }
    _typeId = idProp;
  }
  
  public void setObjectIdWriter(ObjectIdWriter w)
  {
    _objectIdWriter = w;
  }
  
  public AnnotatedClass getClassInfo()
  {
    return _beanDesc.getClassInfo();
  }
  
  public BeanDescription getBeanDescription()
  {
    return _beanDesc;
  }
  
  public List<BeanPropertyWriter> getProperties()
  {
    return _properties;
  }
  
  public boolean hasProperties()
  {
    return (_properties != null) && (_properties.size() > 0);
  }
  
  public BeanPropertyWriter[] getFilteredProperties()
  {
    return _filteredProperties;
  }
  
  public AnyGetterWriter getAnyGetter()
  {
    return _anyGetter;
  }
  
  public Object getFilterId()
  {
    return _filterId;
  }
  
  public AnnotatedMember getTypeId()
  {
    return _typeId;
  }
  
  public ObjectIdWriter getObjectIdWriter()
  {
    return _objectIdWriter;
  }
  
  public JsonSerializer<?> build()
  {
    BeanPropertyWriter[] properties;
    BeanPropertyWriter[] properties;
    if ((_properties == null) || (_properties.isEmpty()))
    {
      if ((_anyGetter == null) && (_objectIdWriter == null)) {
        return null;
      }
      properties = NO_PROPERTIES;
    }
    else
    {
      properties = (BeanPropertyWriter[])_properties.toArray(new BeanPropertyWriter[_properties.size()]);
    }
    return new BeanSerializer(_beanDesc.getType(), this, properties, _filteredProperties);
  }
  
  public BeanSerializer createDummy()
  {
    return BeanSerializer.createDummy(_beanDesc.getType());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanSerializerBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */