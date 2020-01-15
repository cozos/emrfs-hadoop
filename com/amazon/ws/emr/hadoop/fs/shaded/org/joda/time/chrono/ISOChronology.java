package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DividedDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.RemainderDateTimeField;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public final class ISOChronology
  extends AssembledChronology
{
  private static final long serialVersionUID = -6212696554273812441L;
  private static final ISOChronology INSTANCE_UTC;
  private static final ConcurrentHashMap<DateTimeZone, ISOChronology> cCache = new ConcurrentHashMap();
  
  static
  {
    INSTANCE_UTC = new ISOChronology(GregorianChronology.getInstanceUTC());
    cCache.put(DateTimeZone.UTC, INSTANCE_UTC);
  }
  
  public static ISOChronology getInstanceUTC()
  {
    return INSTANCE_UTC;
  }
  
  public static ISOChronology getInstance()
  {
    return getInstance(DateTimeZone.getDefault());
  }
  
  public static ISOChronology getInstance(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      paramDateTimeZone = DateTimeZone.getDefault();
    }
    Object localObject = (ISOChronology)cCache.get(paramDateTimeZone);
    if (localObject == null)
    {
      localObject = new ISOChronology(ZonedChronology.getInstance(INSTANCE_UTC, paramDateTimeZone));
      ISOChronology localISOChronology = (ISOChronology)cCache.putIfAbsent(paramDateTimeZone, localObject);
      if (localISOChronology != null) {
        localObject = localISOChronology;
      }
    }
    return (ISOChronology)localObject;
  }
  
  private ISOChronology(Chronology paramChronology)
  {
    super(paramChronology, null);
  }
  
  public Chronology withUTC()
  {
    return INSTANCE_UTC;
  }
  
  public Chronology withZone(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      paramDateTimeZone = DateTimeZone.getDefault();
    }
    if (paramDateTimeZone == getZone()) {
      return this;
    }
    return getInstance(paramDateTimeZone);
  }
  
  public String toString()
  {
    String str = "ISOChronology";
    DateTimeZone localDateTimeZone = getZone();
    if (localDateTimeZone != null) {
      str = str + '[' + localDateTimeZone.getID() + ']';
    }
    return str;
  }
  
  protected void assemble(AssembledChronology.Fields paramFields)
  {
    if (getBase().getZone() == DateTimeZone.UTC)
    {
      centuryOfEra = new DividedDateTimeField(ISOYearOfEraDateTimeField.INSTANCE, DateTimeFieldType.centuryOfEra(), 100);
      
      centuries = centuryOfEra.getDurationField();
      
      yearOfCentury = new RemainderDateTimeField((DividedDateTimeField)centuryOfEra, DateTimeFieldType.yearOfCentury());
      
      weekyearOfCentury = new RemainderDateTimeField((DividedDateTimeField)centuryOfEra, weekyears, DateTimeFieldType.weekyearOfCentury());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof ISOChronology))
    {
      ISOChronology localISOChronology = (ISOChronology)paramObject;
      return getZone().equals(localISOChronology.getZone());
    }
    return false;
  }
  
  public int hashCode()
  {
    return "ISO".hashCode() * 11 + getZone().hashCode();
  }
  
  private Object writeReplace()
  {
    return new Stub(getZone());
  }
  
  private static final class Stub
    implements Serializable
  {
    private static final long serialVersionUID = -6212696554273812441L;
    private transient DateTimeZone iZone;
    
    Stub(DateTimeZone paramDateTimeZone)
    {
      iZone = paramDateTimeZone;
    }
    
    private Object readResolve()
    {
      return ISOChronology.getInstance(iZone);
    }
    
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.writeObject(iZone);
    }
    
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      iZone = ((DateTimeZone)paramObjectInputStream.readObject());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */