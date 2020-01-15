package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractReadableInstantFieldProperty;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

public final class LocalDateTime$Property
  extends AbstractReadableInstantFieldProperty
{
  private static final long serialVersionUID = -358138762846288L;
  private transient LocalDateTime iInstant;
  private transient DateTimeField iField;
  
  LocalDateTime$Property(LocalDateTime paramLocalDateTime, DateTimeField paramDateTimeField)
  {
    iInstant = paramLocalDateTime;
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
    iInstant = ((LocalDateTime)paramObjectInputStream.readObject());
    DateTimeFieldType localDateTimeFieldType = (DateTimeFieldType)paramObjectInputStream.readObject();
    iField = localDateTimeFieldType.getField(iInstant.getChronology());
  }
  
  public DateTimeField getField()
  {
    return iField;
  }
  
  protected long getMillis()
  {
    return iInstant.getLocalMillis();
  }
  
  protected Chronology getChronology()
  {
    return iInstant.getChronology();
  }
  
  public LocalDateTime getLocalDateTime()
  {
    return iInstant;
  }
  
  public LocalDateTime addToCopy(int paramInt)
  {
    return iInstant.withLocalMillis(iField.add(iInstant.getLocalMillis(), paramInt));
  }
  
  public LocalDateTime addToCopy(long paramLong)
  {
    return iInstant.withLocalMillis(iField.add(iInstant.getLocalMillis(), paramLong));
  }
  
  public LocalDateTime addWrapFieldToCopy(int paramInt)
  {
    return iInstant.withLocalMillis(iField.addWrapField(iInstant.getLocalMillis(), paramInt));
  }
  
  public LocalDateTime setCopy(int paramInt)
  {
    return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), paramInt));
  }
  
  public LocalDateTime setCopy(String paramString, Locale paramLocale)
  {
    return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), paramString, paramLocale));
  }
  
  public LocalDateTime setCopy(String paramString)
  {
    return setCopy(paramString, null);
  }
  
  public LocalDateTime withMaximumValue()
  {
    return setCopy(getMaximumValue());
  }
  
  public LocalDateTime withMinimumValue()
  {
    return setCopy(getMinimumValue());
  }
  
  public LocalDateTime roundFloorCopy()
  {
    return iInstant.withLocalMillis(iField.roundFloor(iInstant.getLocalMillis()));
  }
  
  public LocalDateTime roundCeilingCopy()
  {
    return iInstant.withLocalMillis(iField.roundCeiling(iInstant.getLocalMillis()));
  }
  
  public LocalDateTime roundHalfFloorCopy()
  {
    return iInstant.withLocalMillis(iField.roundHalfFloor(iInstant.getLocalMillis()));
  }
  
  public LocalDateTime roundHalfCeilingCopy()
  {
    return iInstant.withLocalMillis(iField.roundHalfCeiling(iInstant.getLocalMillis()));
  }
  
  public LocalDateTime roundHalfEvenCopy()
  {
    return iInstant.withLocalMillis(iField.roundHalfEven(iInstant.getLocalMillis()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.LocalDateTime.Property
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */