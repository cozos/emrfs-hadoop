package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractReadableInstantFieldProperty;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

public final class MutableDateTime$Property
  extends AbstractReadableInstantFieldProperty
{
  private static final long serialVersionUID = -4481126543819298617L;
  private MutableDateTime iInstant;
  private DateTimeField iField;
  
  MutableDateTime$Property(MutableDateTime paramMutableDateTime, DateTimeField paramDateTimeField)
  {
    iInstant = paramMutableDateTime;
    iField = paramDateTimeField;
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(iInstant);
    paramObjectOutputStream.writeObject(iField.getType());
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    iInstant = ((MutableDateTime)paramObjectInputStream.readObject());
    DateTimeFieldType localDateTimeFieldType = (DateTimeFieldType)paramObjectInputStream.readObject();
    iField = localDateTimeFieldType.getField(iInstant.getChronology());
  }
  
  public DateTimeField getField()
  {
    return iField;
  }
  
  protected long getMillis()
  {
    return iInstant.getMillis();
  }
  
  protected Chronology getChronology()
  {
    return iInstant.getChronology();
  }
  
  public MutableDateTime getMutableDateTime()
  {
    return iInstant;
  }
  
  public MutableDateTime add(int paramInt)
  {
    iInstant.setMillis(getField().add(iInstant.getMillis(), paramInt));
    return iInstant;
  }
  
  public MutableDateTime add(long paramLong)
  {
    iInstant.setMillis(getField().add(iInstant.getMillis(), paramLong));
    return iInstant;
  }
  
  public MutableDateTime addWrapField(int paramInt)
  {
    iInstant.setMillis(getField().addWrapField(iInstant.getMillis(), paramInt));
    return iInstant;
  }
  
  public MutableDateTime set(int paramInt)
  {
    iInstant.setMillis(getField().set(iInstant.getMillis(), paramInt));
    return iInstant;
  }
  
  public MutableDateTime set(String paramString, Locale paramLocale)
  {
    iInstant.setMillis(getField().set(iInstant.getMillis(), paramString, paramLocale));
    return iInstant;
  }
  
  public MutableDateTime set(String paramString)
  {
    set(paramString, null);
    return iInstant;
  }
  
  public MutableDateTime roundFloor()
  {
    iInstant.setMillis(getField().roundFloor(iInstant.getMillis()));
    return iInstant;
  }
  
  public MutableDateTime roundCeiling()
  {
    iInstant.setMillis(getField().roundCeiling(iInstant.getMillis()));
    return iInstant;
  }
  
  public MutableDateTime roundHalfFloor()
  {
    iInstant.setMillis(getField().roundHalfFloor(iInstant.getMillis()));
    return iInstant;
  }
  
  public MutableDateTime roundHalfCeiling()
  {
    iInstant.setMillis(getField().roundHalfCeiling(iInstant.getMillis()));
    return iInstant;
  }
  
  public MutableDateTime roundHalfEven()
  {
    iInstant.setMillis(getField().roundHalfEven(iInstant.getMillis()));
    return iInstant;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutableDateTime.Property
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */