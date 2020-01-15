package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializationFeature;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class StdKeySerializers$Default
  extends StdSerializer<Object>
{
  static final int TYPE_DATE = 1;
  static final int TYPE_CALENDAR = 2;
  static final int TYPE_CLASS = 3;
  static final int TYPE_ENUM = 4;
  static final int TYPE_TO_STRING = 5;
  protected final int _typeId;
  
  public StdKeySerializers$Default(int typeId, Class<?> type)
  {
    super(type, false);
    _typeId = typeId;
  }
  
  public void serialize(Object value, JsonGenerator g, SerializerProvider provider)
    throws IOException
  {
    switch (_typeId)
    {
    case 1: 
      provider.defaultSerializeDateKey((Date)value, g);
      break;
    case 2: 
      provider.defaultSerializeDateKey(((Calendar)value).getTimeInMillis(), g);
      break;
    case 3: 
      g.writeFieldName(((Class)value).getName());
      break;
    case 4: 
      String str = provider.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING) ? value.toString() : ((Enum)value).name();
      
      g.writeFieldName(str);
      
      break;
    case 5: 
    default: 
      g.writeFieldName(value.toString());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */