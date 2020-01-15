package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractReadableInstantFieldProperty;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

public final class LocalTime$Property
  extends AbstractReadableInstantFieldProperty
{
  private static final long serialVersionUID = -325842547277223L;
  private transient LocalTime iInstant;
  private transient DateTimeField iField;
  
  LocalTime$Property(LocalTime paramLocalTime, DateTimeField paramDateTimeField)
  {
    iInstant = paramLocalTime;
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
    iInstant = ((LocalTime)paramObjectInputStream.readObject());
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
  
  public LocalTime getLocalTime()
  {
    return iInstant;
  }
  
  public LocalTime addCopy(int paramInt)
  {
    return iInstant.withLocalMillis(iField.add(iInstant.getLocalMillis(), paramInt));
  }
  
  public LocalTime addCopy(long paramLong)
  {
    return iInstant.withLocalMillis(iField.add(iInstant.getLocalMillis(), paramLong));
  }
  
  public LocalTime addNoWrapToCopy(int paramInt)
  {
    long l1 = iField.add(iInstant.getLocalMillis(), paramInt);
    long l2 = iInstant.getChronology().millisOfDay().get(l1);
    if (l2 != l1) {
      throw new IllegalArgumentException("The addition exceeded the boundaries of LocalTime");
    }
    return iInstant.withLocalMillis(l1);
  }
  
  public LocalTime addWrapFieldToCopy(int paramInt)
  {
    return iInstant.withLocalMillis(iField.addWrapField(iInstant.getLocalMillis(), paramInt));
  }
  
  public LocalTime setCopy(int paramInt)
  {
    return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), paramInt));
  }
  
  public LocalTime setCopy(String paramString, Locale paramLocale)
  {
    return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), paramString, paramLocale));
  }
  
  public LocalTime setCopy(String paramString)
  {
    return setCopy(paramString, null);
  }
  
  public LocalTime withMaximumValue()
  {
    return setCopy(getMaximumValue());
  }
  
  public LocalTime withMinimumValue()
  {
    return setCopy(getMinimumValue());
  }
  
  public LocalTime roundFloorCopy()
  {
    return iInstant.withLocalMillis(iField.roundFloor(iInstant.getLocalMillis()));
  }
  
  public LocalTime roundCeilingCopy()
  {
    return iInstant.withLocalMillis(iField.roundCeiling(iInstant.getLocalMillis()));
  }
  
  public LocalTime roundHalfFloorCopy()
  {
    return iInstant.withLocalMillis(iField.roundHalfFloor(iInstant.getLocalMillis()));
  }
  
  public LocalTime roundHalfCeilingCopy()
  {
    return iInstant.withLocalMillis(iField.roundHalfCeiling(iInstant.getLocalMillis()));
  }
  
  public LocalTime roundHalfEvenCopy()
  {
    return iInstant.withLocalMillis(iField.roundHalfEven(iInstant.getLocalMillis()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.LocalTime.Property
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */