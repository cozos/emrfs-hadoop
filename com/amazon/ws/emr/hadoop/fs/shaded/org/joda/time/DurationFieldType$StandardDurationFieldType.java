package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

class DurationFieldType$StandardDurationFieldType
  extends DurationFieldType
{
  private static final long serialVersionUID = 31156755687123L;
  private final byte iOrdinal;
  
  DurationFieldType$StandardDurationFieldType(String paramString, byte paramByte)
  {
    super(paramString);
    iOrdinal = paramByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof StandardDurationFieldType)) {
      return iOrdinal == iOrdinal;
    }
    return false;
  }
  
  public int hashCode()
  {
    return 1 << iOrdinal;
  }
  
  public DurationField getField(Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    switch (iOrdinal)
    {
    case 1: 
      return paramChronology.eras();
    case 2: 
      return paramChronology.centuries();
    case 3: 
      return paramChronology.weekyears();
    case 4: 
      return paramChronology.years();
    case 5: 
      return paramChronology.months();
    case 6: 
      return paramChronology.weeks();
    case 7: 
      return paramChronology.days();
    case 8: 
      return paramChronology.halfdays();
    case 9: 
      return paramChronology.hours();
    case 10: 
      return paramChronology.minutes();
    case 11: 
      return paramChronology.seconds();
    case 12: 
      return paramChronology.millis();
    }
    throw new InternalError();
  }
  
  private Object readResolve()
  {
    switch (iOrdinal)
    {
    case 1: 
      return ERAS_TYPE;
    case 2: 
      return CENTURIES_TYPE;
    case 3: 
      return WEEKYEARS_TYPE;
    case 4: 
      return YEARS_TYPE;
    case 5: 
      return MONTHS_TYPE;
    case 6: 
      return WEEKS_TYPE;
    case 7: 
      return DAYS_TYPE;
    case 8: 
      return HALFDAYS_TYPE;
    case 9: 
      return HOURS_TYPE;
    case 10: 
      return MINUTES_TYPE;
    case 11: 
      return SECONDS_TYPE;
    case 12: 
      return MILLIS_TYPE;
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType.StandardDurationFieldType
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */