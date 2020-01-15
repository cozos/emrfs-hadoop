package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DelegatedDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DividedDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.OffsetDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.RemainderDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.SkipUndoDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.UnsupportedDurationField;
import java.util.concurrent.ConcurrentHashMap;

public final class BuddhistChronology
  extends AssembledChronology
{
  private static final long serialVersionUID = -3474595157769370126L;
  public static final int BE = 1;
  private static final DateTimeField ERA_FIELD = new BasicSingleEraDateTimeField("BE");
  private static final int BUDDHIST_OFFSET = 543;
  private static final ConcurrentHashMap<DateTimeZone, BuddhistChronology> cCache = new ConcurrentHashMap();
  private static final BuddhistChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);
  
  public static BuddhistChronology getInstanceUTC()
  {
    return INSTANCE_UTC;
  }
  
  public static BuddhistChronology getInstance()
  {
    return getInstance(DateTimeZone.getDefault());
  }
  
  public static BuddhistChronology getInstance(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      paramDateTimeZone = DateTimeZone.getDefault();
    }
    Object localObject = (BuddhistChronology)cCache.get(paramDateTimeZone);
    if (localObject == null)
    {
      localObject = new BuddhistChronology(GJChronology.getInstance(paramDateTimeZone, null), null);
      
      DateTime localDateTime = new DateTime(1, 1, 1, 0, 0, 0, 0, (Chronology)localObject);
      localObject = new BuddhistChronology(LimitChronology.getInstance((Chronology)localObject, localDateTime, null), "");
      BuddhistChronology localBuddhistChronology = (BuddhistChronology)cCache.putIfAbsent(paramDateTimeZone, localObject);
      if (localBuddhistChronology != null) {
        localObject = localBuddhistChronology;
      }
    }
    return (BuddhistChronology)localObject;
  }
  
  private BuddhistChronology(Chronology paramChronology, Object paramObject)
  {
    super(paramChronology, paramObject);
  }
  
  private Object readResolve()
  {
    Chronology localChronology = getBase();
    return localChronology == null ? getInstanceUTC() : getInstance(localChronology.getZone());
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
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof BuddhistChronology))
    {
      BuddhistChronology localBuddhistChronology = (BuddhistChronology)paramObject;
      return getZone().equals(localBuddhistChronology.getZone());
    }
    return false;
  }
  
  public int hashCode()
  {
    return "Buddhist".hashCode() * 11 + getZone().hashCode();
  }
  
  public String toString()
  {
    String str = "BuddhistChronology";
    DateTimeZone localDateTimeZone = getZone();
    if (localDateTimeZone != null) {
      str = str + '[' + localDateTimeZone.getID() + ']';
    }
    return str;
  }
  
  protected void assemble(AssembledChronology.Fields paramFields)
  {
    if (getParam() == null)
    {
      eras = UnsupportedDurationField.getInstance(DurationFieldType.eras());
      
      Object localObject = year;
      year = new OffsetDateTimeField(new SkipUndoDateTimeField(this, (DateTimeField)localObject), 543);
      
      localObject = yearOfEra;
      yearOfEra = new DelegatedDateTimeField(year, eras, DateTimeFieldType.yearOfEra());
      
      localObject = weekyear;
      weekyear = new OffsetDateTimeField(new SkipUndoDateTimeField(this, (DateTimeField)localObject), 543);
      
      localObject = new OffsetDateTimeField(yearOfEra, 99);
      centuryOfEra = new DividedDateTimeField((DateTimeField)localObject, eras, DateTimeFieldType.centuryOfEra(), 100);
      
      centuries = centuryOfEra.getDurationField();
      
      localObject = new RemainderDateTimeField((DividedDateTimeField)centuryOfEra);
      
      yearOfCentury = new OffsetDateTimeField((DateTimeField)localObject, DateTimeFieldType.yearOfCentury(), 1);
      
      localObject = new RemainderDateTimeField(weekyear, centuries, DateTimeFieldType.weekyearOfCentury(), 100);
      
      weekyearOfCentury = new OffsetDateTimeField((DateTimeField)localObject, DateTimeFieldType.weekyearOfCentury(), 1);
      
      era = ERA_FIELD;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BuddhistChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */