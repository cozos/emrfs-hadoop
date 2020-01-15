package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractReadableInstantFieldProperty;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

public final class LocalDate$Property
  extends AbstractReadableInstantFieldProperty
{
  private static final long serialVersionUID = -3193829732634L;
  private transient LocalDate iInstant;
  private transient DateTimeField iField;
  
  LocalDate$Property(LocalDate paramLocalDate, DateTimeField paramDateTimeField)
  {
    iInstant = paramLocalDate;
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
    iInstant = ((LocalDate)paramObjectInputStream.readObject());
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
  
  public LocalDate getLocalDate()
  {
    return iInstant;
  }
  
  public LocalDate addToCopy(int paramInt)
  {
    return iInstant.withLocalMillis(iField.add(iInstant.getLocalMillis(), paramInt));
  }
  
  public LocalDate addWrapFieldToCopy(int paramInt)
  {
    return iInstant.withLocalMillis(iField.addWrapField(iInstant.getLocalMillis(), paramInt));
  }
  
  public LocalDate setCopy(int paramInt)
  {
    return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), paramInt));
  }
  
  public LocalDate setCopy(String paramString, Locale paramLocale)
  {
    return iInstant.withLocalMillis(iField.set(iInstant.getLocalMillis(), paramString, paramLocale));
  }
  
  public LocalDate setCopy(String paramString)
  {
    return setCopy(paramString, null);
  }
  
  public LocalDate withMaximumValue()
  {
    return setCopy(getMaximumValue());
  }
  
  public LocalDate withMinimumValue()
  {
    return setCopy(getMinimumValue());
  }
  
  public LocalDate roundFloorCopy()
  {
    return iInstant.withLocalMillis(iField.roundFloor(iInstant.getLocalMillis()));
  }
  
  public LocalDate roundCeilingCopy()
  {
    return iInstant.withLocalMillis(iField.roundCeiling(iInstant.getLocalMillis()));
  }
  
  public LocalDate roundHalfFloorCopy()
  {
    return iInstant.withLocalMillis(iField.roundHalfFloor(iInstant.getLocalMillis()));
  }
  
  public LocalDate roundHalfCeilingCopy()
  {
    return iInstant.withLocalMillis(iField.roundHalfCeiling(iInstant.getLocalMillis()));
  }
  
  public LocalDate roundHalfEvenCopy()
  {
    return iInstant.withLocalMillis(iField.roundHalfEven(iInstant.getLocalMillis()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.LocalDate.Property
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */