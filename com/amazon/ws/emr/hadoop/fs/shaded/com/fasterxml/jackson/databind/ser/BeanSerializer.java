package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.BeanAsArraySerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;

public class BeanSerializer
  extends BeanSerializerBase
{
  private static final long serialVersionUID = -3618164443537292758L;
  
  public BeanSerializer(JavaType type, BeanSerializerBuilder builder, BeanPropertyWriter[] properties, BeanPropertyWriter[] filteredProperties)
  {
    super(type, builder, properties, filteredProperties);
  }
  
  protected BeanSerializer(BeanSerializerBase src)
  {
    super(src);
  }
  
  protected BeanSerializer(BeanSerializerBase src, ObjectIdWriter objectIdWriter)
  {
    super(src, objectIdWriter);
  }
  
  protected BeanSerializer(BeanSerializerBase src, ObjectIdWriter objectIdWriter, Object filterId)
  {
    super(src, objectIdWriter, filterId);
  }
  
  protected BeanSerializer(BeanSerializerBase src, String[] toIgnore)
  {
    super(src, toIgnore);
  }
  
  public static BeanSerializer createDummy(JavaType forType)
  {
    return new BeanSerializer(forType, null, NO_PROPS, null);
  }
  
  public JsonSerializer<Object> unwrappingSerializer(NameTransformer unwrapper)
  {
    return new UnwrappingBeanSerializer(this, unwrapper);
  }
  
  public BeanSerializerBase withObjectIdWriter(ObjectIdWriter objectIdWriter)
  {
    return new BeanSerializer(this, objectIdWriter, _propertyFilterId);
  }
  
  public BeanSerializerBase withFilterId(Object filterId)
  {
    return new BeanSerializer(this, _objectIdWriter, filterId);
  }
  
  protected BeanSerializerBase withIgnorals(String[] toIgnore)
  {
    return new BeanSerializer(this, toIgnore);
  }
  
  protected BeanSerializerBase asArraySerializer()
  {
    if ((_objectIdWriter == null) && (_anyGetterWriter == null) && (_propertyFilterId == null)) {
      return new BeanAsArraySerializer(this);
    }
    return this;
  }
  
  public final void serialize(Object bean, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    if (_objectIdWriter != null)
    {
      gen.setCurrentValue(bean);
      _serializeWithObjectId(bean, gen, provider, true);
      return;
    }
    gen.writeStartObject();
    
    gen.setCurrentValue(bean);
    if (_propertyFilterId != null) {
      serializeFieldsFiltered(bean, gen, provider);
    } else {
      serializeFields(bean, gen, provider);
    }
    gen.writeEndObject();
  }
  
  public String toString()
  {
    return "BeanSerializer for " + handledType().getName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.BeanSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */