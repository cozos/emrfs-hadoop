package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractReadableInstantFieldProperty;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

public final class DateTime$Property
  extends AbstractReadableInstantFieldProperty
{
  private static final long serialVersionUID = -6983323811635733510L;
  private DateTime iInstant;
  private DateTimeField iField;
  
  DateTime$Property(DateTime paramDateTime, DateTimeField paramDateTimeField)
  {
    iInstant = paramDateTime;
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
    iInstant = ((DateTime)paramObjectInputStream.readObject());
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
  
  public DateTime getDateTime()
  {
    return iInstant;
  }
  
  public DateTime addToCopy(int paramInt)
  {
    return iInstant.withMillis(iField.add(iInstant.getMillis(), paramInt));
  }
  
  public DateTime addToCopy(long paramLong)
  {
    return iInstant.withMillis(iField.add(iInstant.getMillis(), paramLong));
  }
  
  public DateTime addWrapFieldToCopy(int paramInt)
  {
    return iInstant.withMillis(iField.addWrapField(iInstant.getMillis(), paramInt));
  }
  
  public DateTime setCopy(int paramInt)
  {
    return iInstant.withMillis(iField.set(iInstant.getMillis(), paramInt));
  }
  
  public DateTime setCopy(String paramString, Locale paramLocale)
  {
    return iInstant.withMillis(iField.set(iInstant.getMillis(), paramString, paramLocale));
  }
  
  public DateTime setCopy(String paramString)
  {
    return setCopy(paramString, null);
  }
  
  public DateTime withMaximumValue()
  {
    try
    {
      return setCopy(getMaximumValue());
    }
    catch (RuntimeException localRuntimeException)
    {
      if (IllegalInstantException.isIllegalInstant(localRuntimeException))
      {
        long l = getChronology().getZone().previousTransition(getMillis() + 86400000L);
        return new DateTime(l, getChronology());
      }
      throw localRuntimeException;
    }
  }
  
  public DateTime withMinimumValue()
  {
    try
    {
      return setCopy(getMinimumValue());
    }
    catch (RuntimeException localRuntimeException)
    {
      if (IllegalInstantException.isIllegalInstant(localRuntimeException))
      {
        long l = getChronology().getZone().nextTransition(getMillis() - 86400000L);
        return new DateTime(l, getChronology());
      }
      throw localRuntimeException;
    }
  }
  
  public DateTime roundFloorCopy()
  {
    return iInstant.withMillis(iField.roundFloor(iInstant.getMillis()));
  }
  
  public DateTime roundCeilingCopy()
  {
    return iInstant.withMillis(iField.roundCeiling(iInstant.getMillis()));
  }
  
  public DateTime roundHalfFloorCopy()
  {
    return iInstant.withMillis(iField.roundHalfFloor(iInstant.getMillis()));
  }
  
  public DateTime roundHalfCeilingCopy()
  {
    return iInstant.withMillis(iField.roundHalfCeiling(iInstant.getMillis()));
  }
  
  public DateTime roundHalfEvenCopy()
  {
    return iInstant.withMillis(iField.roundHalfEven(iInstant.getMillis()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime.Property
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */