package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutableDateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableDateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DecoratedDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DecoratedDurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.util.HashMap;
import java.util.Locale;

public final class LimitChronology
  extends AssembledChronology
{
  private static final long serialVersionUID = 7670866536893052522L;
  final DateTime iLowerLimit;
  final DateTime iUpperLimit;
  private transient LimitChronology iWithUTC;
  
  public static LimitChronology getInstance(Chronology paramChronology, ReadableDateTime paramReadableDateTime1, ReadableDateTime paramReadableDateTime2)
  {
    if (paramChronology == null) {
      throw new IllegalArgumentException("Must supply a chronology");
    }
    paramReadableDateTime1 = paramReadableDateTime1 == null ? null : paramReadableDateTime1.toDateTime();
    paramReadableDateTime2 = paramReadableDateTime2 == null ? null : paramReadableDateTime2.toDateTime();
    if ((paramReadableDateTime1 != null) && (paramReadableDateTime2 != null) && (!paramReadableDateTime1.isBefore(paramReadableDateTime2))) {
      throw new IllegalArgumentException("The lower limit must be come before than the upper limit");
    }
    return new LimitChronology(paramChronology, (DateTime)paramReadableDateTime1, (DateTime)paramReadableDateTime2);
  }
  
  private LimitChronology(Chronology paramChronology, DateTime paramDateTime1, DateTime paramDateTime2)
  {
    super(paramChronology, null);
    
    iLowerLimit = paramDateTime1;
    iUpperLimit = paramDateTime2;
  }
  
  public DateTime getLowerLimit()
  {
    return iLowerLimit;
  }
  
  public DateTime getUpperLimit()
  {
    return iUpperLimit;
  }
  
  public Chronology withUTC()
  {
    return withZone(DateTimeZone.UTC);
  }
  
  public Chronology withZone(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      paramDateTimeZone = DateTimeZone.getDefault();
    }
    if (paramDateTimeZone == getZone()) {
      return this;
    }
    if ((paramDateTimeZone == DateTimeZone.UTC) && (iWithUTC != null)) {
      return iWithUTC;
    }
    DateTime localDateTime = iLowerLimit;
    if (localDateTime != null)
    {
      localObject1 = localDateTime.toMutableDateTime();
      ((MutableDateTime)localObject1).setZoneRetainFields(paramDateTimeZone);
      localDateTime = ((MutableDateTime)localObject1).toDateTime();
    }
    Object localObject1 = iUpperLimit;
    if (localObject1 != null)
    {
      localObject2 = ((DateTime)localObject1).toMutableDateTime();
      ((MutableDateTime)localObject2).setZoneRetainFields(paramDateTimeZone);
      localObject1 = ((MutableDateTime)localObject2).toDateTime();
    }
    Object localObject2 = getInstance(getBase().withZone(paramDateTimeZone), localDateTime, (ReadableDateTime)localObject1);
    if (paramDateTimeZone == DateTimeZone.UTC) {
      iWithUTC = ((LimitChronology)localObject2);
    }
    return (Chronology)localObject2;
  }
  
  public long getDateTimeMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    long l = getBase().getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4);
    checkLimits(l, "resulting");
    return l;
  }
  
  public long getDateTimeMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    throws IllegalArgumentException
  {
    long l = getBase().getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    
    checkLimits(l, "resulting");
    return l;
  }
  
  public long getDateTimeMillis(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    checkLimits(paramLong, null);
    paramLong = getBase().getDateTimeMillis(paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
    
    checkLimits(paramLong, "resulting");
    return paramLong;
  }
  
  protected void assemble(AssembledChronology.Fields paramFields)
  {
    HashMap localHashMap = new HashMap();
    
    eras = convertField(eras, localHashMap);
    centuries = convertField(centuries, localHashMap);
    years = convertField(years, localHashMap);
    months = convertField(months, localHashMap);
    weekyears = convertField(weekyears, localHashMap);
    weeks = convertField(weeks, localHashMap);
    days = convertField(days, localHashMap);
    
    halfdays = convertField(halfdays, localHashMap);
    hours = convertField(hours, localHashMap);
    minutes = convertField(minutes, localHashMap);
    seconds = convertField(seconds, localHashMap);
    millis = convertField(millis, localHashMap);
    
    year = convertField(year, localHashMap);
    yearOfEra = convertField(yearOfEra, localHashMap);
    yearOfCentury = convertField(yearOfCentury, localHashMap);
    centuryOfEra = convertField(centuryOfEra, localHashMap);
    era = convertField(era, localHashMap);
    dayOfWeek = convertField(dayOfWeek, localHashMap);
    dayOfMonth = convertField(dayOfMonth, localHashMap);
    dayOfYear = convertField(dayOfYear, localHashMap);
    monthOfYear = convertField(monthOfYear, localHashMap);
    weekOfWeekyear = convertField(weekOfWeekyear, localHashMap);
    weekyear = convertField(weekyear, localHashMap);
    weekyearOfCentury = convertField(weekyearOfCentury, localHashMap);
    
    millisOfSecond = convertField(millisOfSecond, localHashMap);
    millisOfDay = convertField(millisOfDay, localHashMap);
    secondOfMinute = convertField(secondOfMinute, localHashMap);
    secondOfDay = convertField(secondOfDay, localHashMap);
    minuteOfHour = convertField(minuteOfHour, localHashMap);
    minuteOfDay = convertField(minuteOfDay, localHashMap);
    hourOfDay = convertField(hourOfDay, localHashMap);
    hourOfHalfday = convertField(hourOfHalfday, localHashMap);
    clockhourOfDay = convertField(clockhourOfDay, localHashMap);
    clockhourOfHalfday = convertField(clockhourOfHalfday, localHashMap);
    halfdayOfDay = convertField(halfdayOfDay, localHashMap);
  }
  
  private DurationField convertField(DurationField paramDurationField, HashMap<Object, Object> paramHashMap)
  {
    if ((paramDurationField == null) || (!paramDurationField.isSupported())) {
      return paramDurationField;
    }
    if (paramHashMap.containsKey(paramDurationField)) {
      return (DurationField)paramHashMap.get(paramDurationField);
    }
    LimitDurationField localLimitDurationField = new LimitDurationField(paramDurationField);
    paramHashMap.put(paramDurationField, localLimitDurationField);
    return localLimitDurationField;
  }
  
  private DateTimeField convertField(DateTimeField paramDateTimeField, HashMap<Object, Object> paramHashMap)
  {
    if ((paramDateTimeField == null) || (!paramDateTimeField.isSupported())) {
      return paramDateTimeField;
    }
    if (paramHashMap.containsKey(paramDateTimeField)) {
      return (DateTimeField)paramHashMap.get(paramDateTimeField);
    }
    LimitDateTimeField localLimitDateTimeField = new LimitDateTimeField(paramDateTimeField, convertField(paramDateTimeField.getDurationField(), paramHashMap), convertField(paramDateTimeField.getRangeDurationField(), paramHashMap), convertField(paramDateTimeField.getLeapDurationField(), paramHashMap));
    
    paramHashMap.put(paramDateTimeField, localLimitDateTimeField);
    return localLimitDateTimeField;
  }
  
  void checkLimits(long paramLong, String paramString)
  {
    DateTime localDateTime;
    if (((localDateTime = iLowerLimit) != null) && (paramLong < localDateTime.getMillis())) {
      throw new LimitException(paramString, true);
    }
    if (((localDateTime = iUpperLimit) != null) && (paramLong >= localDateTime.getMillis())) {
      throw new LimitException(paramString, false);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LimitChronology)) {
      return false;
    }
    LimitChronology localLimitChronology = (LimitChronology)paramObject;
    return (getBase().equals(localLimitChronology.getBase())) && (FieldUtils.equals(getLowerLimit(), localLimitChronology.getLowerLimit())) && (FieldUtils.equals(getUpperLimit(), localLimitChronology.getUpperLimit()));
  }
  
  public int hashCode()
  {
    int i = 317351877;
    i += (getLowerLimit() != null ? getLowerLimit().hashCode() : 0);
    i += (getUpperLimit() != null ? getUpperLimit().hashCode() : 0);
    i += getBase().hashCode() * 7;
    return i;
  }
  
  public String toString()
  {
    return "LimitChronology[" + getBase().toString() + ", " + (getLowerLimit() == null ? "NoLimit" : getLowerLimit().toString()) + ", " + (getUpperLimit() == null ? "NoLimit" : getUpperLimit().toString()) + ']';
  }
  
  private class LimitException
    extends IllegalArgumentException
  {
    private static final long serialVersionUID = -5924689995607498581L;
    private final boolean iIsLow;
    
    LimitException(String paramString, boolean paramBoolean)
    {
      super();
      iIsLow = paramBoolean;
    }
    
    public String getMessage()
    {
      StringBuffer localStringBuffer = new StringBuffer(85);
      localStringBuffer.append("The");
      String str = super.getMessage();
      if (str != null)
      {
        localStringBuffer.append(' ');
        localStringBuffer.append(str);
      }
      localStringBuffer.append(" instant is ");
      
      DateTimeFormatter localDateTimeFormatter = ISODateTimeFormat.dateTime();
      localDateTimeFormatter = localDateTimeFormatter.withChronology(getBase());
      if (iIsLow)
      {
        localStringBuffer.append("below the supported minimum of ");
        localDateTimeFormatter.printTo(localStringBuffer, getLowerLimit().getMillis());
      }
      else
      {
        localStringBuffer.append("above the supported maximum of ");
        localDateTimeFormatter.printTo(localStringBuffer, getUpperLimit().getMillis());
      }
      localStringBuffer.append(" (");
      localStringBuffer.append(getBase());
      localStringBuffer.append(')');
      
      return localStringBuffer.toString();
    }
    
    public String toString()
    {
      return "IllegalArgumentException: " + getMessage();
    }
  }
  
  private class LimitDurationField
    extends DecoratedDurationField
  {
    private static final long serialVersionUID = 8049297699408782284L;
    
    LimitDurationField(DurationField paramDurationField)
    {
      super(paramDurationField.getType());
    }
    
    public int getValue(long paramLong1, long paramLong2)
    {
      checkLimits(paramLong2, null);
      return getWrappedField().getValue(paramLong1, paramLong2);
    }
    
    public long getValueAsLong(long paramLong1, long paramLong2)
    {
      checkLimits(paramLong2, null);
      return getWrappedField().getValueAsLong(paramLong1, paramLong2);
    }
    
    public long getMillis(int paramInt, long paramLong)
    {
      checkLimits(paramLong, null);
      return getWrappedField().getMillis(paramInt, paramLong);
    }
    
    public long getMillis(long paramLong1, long paramLong2)
    {
      checkLimits(paramLong2, null);
      return getWrappedField().getMillis(paramLong1, paramLong2);
    }
    
    public long add(long paramLong, int paramInt)
    {
      checkLimits(paramLong, null);
      long l = getWrappedField().add(paramLong, paramInt);
      checkLimits(l, "resulting");
      return l;
    }
    
    public long add(long paramLong1, long paramLong2)
    {
      checkLimits(paramLong1, null);
      long l = getWrappedField().add(paramLong1, paramLong2);
      checkLimits(l, "resulting");
      return l;
    }
    
    public int getDifference(long paramLong1, long paramLong2)
    {
      checkLimits(paramLong1, "minuend");
      checkLimits(paramLong2, "subtrahend");
      return getWrappedField().getDifference(paramLong1, paramLong2);
    }
    
    public long getDifferenceAsLong(long paramLong1, long paramLong2)
    {
      checkLimits(paramLong1, "minuend");
      checkLimits(paramLong2, "subtrahend");
      return getWrappedField().getDifferenceAsLong(paramLong1, paramLong2);
    }
  }
  
  private class LimitDateTimeField
    extends DecoratedDateTimeField
  {
    private static final long serialVersionUID = -2435306746995699312L;
    private final DurationField iDurationField;
    private final DurationField iRangeDurationField;
    private final DurationField iLeapDurationField;
    
    LimitDateTimeField(DateTimeField paramDateTimeField, DurationField paramDurationField1, DurationField paramDurationField2, DurationField paramDurationField3)
    {
      super(paramDateTimeField.getType());
      iDurationField = paramDurationField1;
      iRangeDurationField = paramDurationField2;
      iLeapDurationField = paramDurationField3;
    }
    
    public int get(long paramLong)
    {
      checkLimits(paramLong, null);
      return getWrappedField().get(paramLong);
    }
    
    public String getAsText(long paramLong, Locale paramLocale)
    {
      checkLimits(paramLong, null);
      return getWrappedField().getAsText(paramLong, paramLocale);
    }
    
    public String getAsShortText(long paramLong, Locale paramLocale)
    {
      checkLimits(paramLong, null);
      return getWrappedField().getAsShortText(paramLong, paramLocale);
    }
    
    public long add(long paramLong, int paramInt)
    {
      checkLimits(paramLong, null);
      long l = getWrappedField().add(paramLong, paramInt);
      checkLimits(l, "resulting");
      return l;
    }
    
    public long add(long paramLong1, long paramLong2)
    {
      checkLimits(paramLong1, null);
      long l = getWrappedField().add(paramLong1, paramLong2);
      checkLimits(l, "resulting");
      return l;
    }
    
    public long addWrapField(long paramLong, int paramInt)
    {
      checkLimits(paramLong, null);
      long l = getWrappedField().addWrapField(paramLong, paramInt);
      checkLimits(l, "resulting");
      return l;
    }
    
    public int getDifference(long paramLong1, long paramLong2)
    {
      checkLimits(paramLong1, "minuend");
      checkLimits(paramLong2, "subtrahend");
      return getWrappedField().getDifference(paramLong1, paramLong2);
    }
    
    public long getDifferenceAsLong(long paramLong1, long paramLong2)
    {
      checkLimits(paramLong1, "minuend");
      checkLimits(paramLong2, "subtrahend");
      return getWrappedField().getDifferenceAsLong(paramLong1, paramLong2);
    }
    
    public long set(long paramLong, int paramInt)
    {
      checkLimits(paramLong, null);
      long l = getWrappedField().set(paramLong, paramInt);
      checkLimits(l, "resulting");
      return l;
    }
    
    public long set(long paramLong, String paramString, Locale paramLocale)
    {
      checkLimits(paramLong, null);
      long l = getWrappedField().set(paramLong, paramString, paramLocale);
      checkLimits(l, "resulting");
      return l;
    }
    
    public final DurationField getDurationField()
    {
      return iDurationField;
    }
    
    public final DurationField getRangeDurationField()
    {
      return iRangeDurationField;
    }
    
    public boolean isLeap(long paramLong)
    {
      checkLimits(paramLong, null);
      return getWrappedField().isLeap(paramLong);
    }
    
    public int getLeapAmount(long paramLong)
    {
      checkLimits(paramLong, null);
      return getWrappedField().getLeapAmount(paramLong);
    }
    
    public final DurationField getLeapDurationField()
    {
      return iLeapDurationField;
    }
    
    public long roundFloor(long paramLong)
    {
      checkLimits(paramLong, null);
      long l = getWrappedField().roundFloor(paramLong);
      checkLimits(l, "resulting");
      return l;
    }
    
    public long roundCeiling(long paramLong)
    {
      checkLimits(paramLong, null);
      long l = getWrappedField().roundCeiling(paramLong);
      checkLimits(l, "resulting");
      return l;
    }
    
    public long roundHalfFloor(long paramLong)
    {
      checkLimits(paramLong, null);
      long l = getWrappedField().roundHalfFloor(paramLong);
      checkLimits(l, "resulting");
      return l;
    }
    
    public long roundHalfCeiling(long paramLong)
    {
      checkLimits(paramLong, null);
      long l = getWrappedField().roundHalfCeiling(paramLong);
      checkLimits(l, "resulting");
      return l;
    }
    
    public long roundHalfEven(long paramLong)
    {
      checkLimits(paramLong, null);
      long l = getWrappedField().roundHalfEven(paramLong);
      checkLimits(l, "resulting");
      return l;
    }
    
    public long remainder(long paramLong)
    {
      checkLimits(paramLong, null);
      long l = getWrappedField().remainder(paramLong);
      checkLimits(l, "resulting");
      return l;
    }
    
    public int getMinimumValue(long paramLong)
    {
      checkLimits(paramLong, null);
      return getWrappedField().getMinimumValue(paramLong);
    }
    
    public int getMaximumValue(long paramLong)
    {
      checkLimits(paramLong, null);
      return getWrappedField().getMaximumValue(paramLong);
    }
    
    public int getMaximumTextLength(Locale paramLocale)
    {
      return getWrappedField().getMaximumTextLength(paramLocale);
    }
    
    public int getMaximumShortTextLength(Locale paramLocale)
    {
      return getWrappedField().getMaximumShortTextLength(paramLocale);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.LimitChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */