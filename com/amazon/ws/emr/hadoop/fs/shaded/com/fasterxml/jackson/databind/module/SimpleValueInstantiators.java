package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.module;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.BeanDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiators.Base;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;
import java.util.HashMap;

public class SimpleValueInstantiators
  extends ValueInstantiators.Base
  implements Serializable
{
  private static final long serialVersionUID = -8929386427526115130L;
  protected HashMap<ClassKey, ValueInstantiator> _classMappings;
  
  public SimpleValueInstantiators()
  {
    _classMappings = new HashMap();
  }
  
  public SimpleValueInstantiators addValueInstantiator(Class<?> forType, ValueInstantiator inst)
  {
    _classMappings.put(new ClassKey(forType), inst);
    return this;
  }
  
  public ValueInstantiator findValueInstantiator(DeserializationConfig config, BeanDescription beanDesc, ValueInstantiator defaultInstantiator)
  {
    ValueInstantiator inst = (ValueInstantiator)_classMappings.get(new ClassKey(beanDesc.getBeanClass()));
    return inst == null ? defaultInstantiator : inst;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.module.SimpleValueInstantiators
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */