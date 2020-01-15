package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.PropertyName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.ValueInstantiator;

public class JsonLocationInstantiator
  extends ValueInstantiator
{
  public String getValueTypeDesc()
  {
    return JsonLocation.class.getName();
  }
  
  public boolean canCreateFromObjectWith()
  {
    return true;
  }
  
  public SettableBeanProperty[] getFromObjectArguments(DeserializationConfig config)
  {
    JavaType intType = config.constructType(Integer.TYPE);
    JavaType longType = config.constructType(Long.TYPE);
    return new SettableBeanProperty[] { creatorProp("sourceRef", config.constructType(Object.class), 0), creatorProp("byteOffset", longType, 1), creatorProp("charOffset", longType, 2), creatorProp("lineNr", intType, 3), creatorProp("columnNr", intType, 4) };
  }
  
  private static CreatorProperty creatorProp(String name, JavaType type, int index)
  {
    return new CreatorProperty(PropertyName.construct(name), type, null, null, null, null, index, null, PropertyMetadata.STD_REQUIRED);
  }
  
  public Object createFromObjectWith(DeserializationContext ctxt, Object[] args)
  {
    return new JsonLocation(args[0], _long(args[1]), _long(args[2]), _int(args[3]), _int(args[4]));
  }
  
  private static final long _long(Object o)
  {
    return o == null ? 0L : ((Number)o).longValue();
  }
  
  private static final int _int(Object o)
  {
    return o == null ? 0 : ((Number)o).intValue();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */