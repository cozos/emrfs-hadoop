package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.IllegalFieldValueException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.IllegalInstantException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.BaseDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.BaseDurationField;
import java.util.HashMap;
import java.util.Locale;

public final class ZonedChronology
  extends AssembledChronology
{
  private static final long serialVersionUID = -1079258847191166848L;
  private static final long NEAR_ZERO = 604800000L;
  
  public static ZonedChronology getInstance(Chronology paramChronology, DateTimeZone paramDateTimeZone)
  {
    if (paramChronology == null) {
      throw new IllegalArgumentException("Must supply a chronology");
    }
    paramChronology = paramChronology.withUTC();
    if (paramChronology == null) {
      throw new IllegalArgumentException("UTC chronology must not be null");
    }
    if (paramDateTimeZone == null) {
      throw new IllegalArgumentException("DateTimeZone must not be null");
    }
    return new ZonedChronology(paramChronology, paramDateTimeZone);
  }
  
  static boolean useTimeArithmetic(DurationField paramDurationField)
  {
    return (paramDurationField != null) && (paramDurationField.getUnitMillis() < 43200000L);
  }
  
  private ZonedChronology(Chronology paramChronology, DateTimeZone paramDateTimeZone)
  {
    super(paramChronology, paramDateTimeZone);
  }
  
  public DateTimeZone getZone()
  {
    return (DateTimeZone)getParam();
  }
  
  public Chronology withUTC()
  {
    return getBase();
  }
  
  public Chronology withZone(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      paramDateTimeZone = DateTimeZone.getDefault();
    }
    if (paramDateTimeZone == getParam()) {
      return this;
    }
    if (paramDateTimeZone == DateTimeZone.UTC) {
      return getBase();
    }
    return new ZonedChronology(getBase(), paramDateTimeZone);
  }
  
  public long getDateTimeMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    return localToUTC(getBase().getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public long getDateTimeMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    throws IllegalArgumentException
  {
    return localToUTC(getBase().getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7));
  }
  
  public long getDateTimeMillis(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    return localToUTC(getBase().getDateTimeMillis(paramLong + getZone().getOffset(paramLong), paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  private long localToUTC(long paramLong)
  {
    if (paramLong == Long.MAX_VALUE) {
      return Long.MAX_VALUE;
    }
    if (paramLong == Long.MIN_VALUE) {
      return Long.MIN_VALUE;
    }
    DateTimeZone localDateTimeZone = getZone();
    int i = localDateTimeZone.getOffsetFromLocal(paramLong);
    long l = paramLong - i;
    if ((paramLong > 604800000L) && (l < 0L)) {
      return Long.MAX_VALUE;
    }
    if ((paramLong < -604800000L) && (l > 0L)) {
      return Long.MIN_VALUE;
    }
    int j = localDateTimeZone.getOffset(l);
    if (i != j) {
      throw new IllegalInstantException(paramLong, localDateTimeZone.getID());
    }
    return l;
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
    ZonedDurationField localZonedDurationField = new ZonedDurationField(paramDurationField, getZone());
    paramHashMap.put(paramDurationField, localZonedDurationField);
    return localZonedDurationField;
  }
  
  private DateTimeField convertField(DateTimeField paramDateTimeField, HashMap<Object, Object> paramHashMap)
  {
    if ((paramDateTimeField == null) || (!paramDateTimeField.isSupported())) {
      return paramDateTimeField;
    }
    if (paramHashMap.containsKey(paramDateTimeField)) {
      return (DateTimeField)paramHashMap.get(paramDateTimeField);
    }
    ZonedDateTimeField localZonedDateTimeField = new ZonedDateTimeField(paramDateTimeField, getZone(), convertField(paramDateTimeField.getDurationField(), paramHashMap), convertField(paramDateTimeField.getRangeDurationField(), paramHashMap), convertField(paramDateTimeField.getLeapDurationField(), paramHashMap));
    
    paramHashMap.put(paramDateTimeField, localZonedDateTimeField);
    return localZonedDateTimeField;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ZonedChronology)) {
      return false;
    }
    ZonedChronology localZonedChronology = (ZonedChronology)paramObject;
    return (getBase().equals(localZonedChronology.getBase())) && (getZone().equals(localZonedChronology.getZone()));
  }
  
  public int hashCode()
  {
    return 326565 + getZone().hashCode() * 11 + getBase().hashCode() * 7;
  }
  
  public String toString()
  {
    return "ZonedChronology[" + getBase() + ", " + getZone().getID() + ']';
  }
  
  static class ZonedDurationField
    extends BaseDurationField
  {
    private static final long serialVersionUID = -485345310999208286L;
    final DurationField iField;
    final boolean iTimeField;
    final DateTimeZone iZone;
    
    ZonedDurationField(DurationField paramDurationField, DateTimeZone paramDateTimeZone)
    {
      super();
      if (!paramDurationField.isSupported()) {
        throw new IllegalArgumentException();
      }
      iField = paramDurationField;
      iTimeField = ZonedChronology.useTimeArithmetic(paramDurationField);
      iZone = paramDateTimeZone;
    }
    
    public boolean isPrecise()
    {
      return (iField.isPrecise()) && (iZone.isFixed()) ? true : iTimeField ? iField.isPrecise() : false;
    }
    
    public long getUnitMillis()
    {
      return iField.getUnitMillis();
    }
    
    public int getValue(long paramLong1, long paramLong2)
    {
      return iField.getValue(paramLong1, addOffset(paramLong2));
    }
    
    public long getValueAsLong(long paramLong1, long paramLong2)
    {
      return iField.getValueAsLong(paramLong1, addOffset(paramLong2));
    }
    
    public long getMillis(int paramInt, long paramLong)
    {
      return iField.getMillis(paramInt, addOffset(paramLong));
    }
    
    public long getMillis(long paramLong1, long paramLong2)
    {
      return iField.getMillis(paramLong1, addOffset(paramLong2));
    }
    
    public long add(long paramLong, int paramInt)
    {
      int i = getOffsetToAdd(paramLong);
      paramLong = iField.add(paramLong + i, paramInt);
      return paramLong - (iTimeField ? i : getOffsetFromLocalToSubtract(paramLong));
    }
    
    public long add(long paramLong1, long paramLong2)
    {
      int i = getOffsetToAdd(paramLong1);
      paramLong1 = iField.add(paramLong1 + i, paramLong2);
      return paramLong1 - (iTimeField ? i : getOffsetFromLocalToSubtract(paramLong1));
    }
    
    public int getDifference(long paramLong1, long paramLong2)
    {
      int i = getOffsetToAdd(paramLong2);
      return iField.getDifference(paramLong1 + (iTimeField ? i : getOffsetToAdd(paramLong1)), paramLong2 + i);
    }
    
    public long getDifferenceAsLong(long paramLong1, long paramLong2)
    {
      int i = getOffsetToAdd(paramLong2);
      return iField.getDifferenceAsLong(paramLong1 + (iTimeField ? i : getOffsetToAdd(paramLong1)), paramLong2 + i);
    }
    
    private int getOffsetToAdd(long paramLong)
    {
      int i = iZone.getOffset(paramLong);
      long l = paramLong + i;
      if (((paramLong ^ l) < 0L) && ((paramLong ^ i) >= 0L)) {
        throw new ArithmeticException("Adding time zone offset caused overflow");
      }
      return i;
    }
    
    private int getOffsetFromLocalToSubtract(long paramLong)
    {
      int i = iZone.getOffsetFromLocal(paramLong);
      long l = paramLong - i;
      if (((paramLong ^ l) < 0L) && ((paramLong ^ i) < 0L)) {
        throw new ArithmeticException("Subtracting time zone offset caused overflow");
      }
      return i;
    }
    
    private long addOffset(long paramLong)
    {
      return iZone.convertUTCToLocal(paramLong);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject instanceof ZonedDurationField))
      {
        ZonedDurationField localZonedDurationField = (ZonedDurationField)paramObject;
        return (iField.equals(iField)) && (iZone.equals(iZone));
      }
      return false;
    }
    
    public int hashCode()
    {
      return iField.hashCode() ^ iZone.hashCode();
    }
  }
  
  static final class ZonedDateTimeField
    extends BaseDateTimeField
  {
    private static final long serialVersionUID = -3968986277775529794L;
    final DateTimeField iField;
    final DateTimeZone iZone;
    final DurationField iDurationField;
    final boolean iTimeField;
    final DurationField iRangeDurationField;
    final DurationField iLeapDurationField;
    
    ZonedDateTimeField(DateTimeField paramDateTimeField, DateTimeZone paramDateTimeZone, DurationField paramDurationField1, DurationField paramDurationField2, DurationField paramDurationField3)
    {
      super();
      if (!paramDateTimeField.isSupported()) {
        throw new IllegalArgumentException();
      }
      iField = paramDateTimeField;
      iZone = paramDateTimeZone;
      iDurationField = paramDurationField1;
      iTimeField = ZonedChronology.useTimeArithmetic(paramDurationField1);
      iRangeDurationField = paramDurationField2;
      iLeapDurationField = paramDurationField3;
    }
    
    public boolean isLenient()
    {
      return iField.isLenient();
    }
    
    public int get(long paramLong)
    {
      long l = iZone.convertUTCToLocal(paramLong);
      return iField.get(l);
    }
    
    public String getAsText(long paramLong, Locale paramLocale)
    {
      long l = iZone.convertUTCToLocal(paramLong);
      return iField.getAsText(l, paramLocale);
    }
    
    public String getAsShortText(long paramLong, Locale paramLocale)
    {
      long l = iZone.convertUTCToLocal(paramLong);
      return iField.getAsShortText(l, paramLocale);
    }
    
    public String getAsText(int paramInt, Locale paramLocale)
    {
      return iField.getAsText(paramInt, paramLocale);
    }
    
    public String getAsShortText(int paramInt, Locale paramLocale)
    {
      return iField.getAsShortText(paramInt, paramLocale);
    }
    
    public long add(long paramLong, int paramInt)
    {
      if (iTimeField)
      {
        int i = getOffsetToAdd(paramLong);
        long l1 = iField.add(paramLong + i, paramInt);
        return l1 - i;
      }
      long l2 = iZone.convertUTCToLocal(paramLong);
      l2 = iField.add(l2, paramInt);
      return iZone.convertLocalToUTC(l2, false, paramLong);
    }
    
    public long add(long paramLong1, long paramLong2)
    {
      if (iTimeField)
      {
        int i = getOffsetToAdd(paramLong1);
        long l1 = iField.add(paramLong1 + i, paramLong2);
        return l1 - i;
      }
      long l2 = iZone.convertUTCToLocal(paramLong1);
      l2 = iField.add(l2, paramLong2);
      return iZone.convertLocalToUTC(l2, false, paramLong1);
    }
    
    public long addWrapField(long paramLong, int paramInt)
    {
      if (iTimeField)
      {
        int i = getOffsetToAdd(paramLong);
        long l1 = iField.addWrapField(paramLong + i, paramInt);
        return l1 - i;
      }
      long l2 = iZone.convertUTCToLocal(paramLong);
      l2 = iField.addWrapField(l2, paramInt);
      return iZone.convertLocalToUTC(l2, false, paramLong);
    }
    
    public long set(long paramLong, int paramInt)
    {
      long l1 = iZone.convertUTCToLocal(paramLong);
      l1 = iField.set(l1, paramInt);
      long l2 = iZone.convertLocalToUTC(l1, false, paramLong);
      if (get(l2) != paramInt)
      {
        IllegalInstantException localIllegalInstantException = new IllegalInstantException(l1, iZone.getID());
        IllegalFieldValueException localIllegalFieldValueException = new IllegalFieldValueException(iField.getType(), Integer.valueOf(paramInt), localIllegalInstantException.getMessage());
        localIllegalFieldValueException.initCause(localIllegalInstantException);
        throw localIllegalFieldValueException;
      }
      return l2;
    }
    
    public long set(long paramLong, String paramString, Locale paramLocale)
    {
      long l = iZone.convertUTCToLocal(paramLong);
      l = iField.set(l, paramString, paramLocale);
      return iZone.convertLocalToUTC(l, false, paramLong);
    }
    
    public int getDifference(long paramLong1, long paramLong2)
    {
      int i = getOffsetToAdd(paramLong2);
      return iField.getDifference(paramLong1 + (iTimeField ? i : getOffsetToAdd(paramLong1)), paramLong2 + i);
    }
    
    public long getDifferenceAsLong(long paramLong1, long paramLong2)
    {
      int i = getOffsetToAdd(paramLong2);
      return iField.getDifferenceAsLong(paramLong1 + (iTimeField ? i : getOffsetToAdd(paramLong1)), paramLong2 + i);
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
      long l = iZone.convertUTCToLocal(paramLong);
      return iField.isLeap(l);
    }
    
    public int getLeapAmount(long paramLong)
    {
      long l = iZone.convertUTCToLocal(paramLong);
      return iField.getLeapAmount(l);
    }
    
    public final DurationField getLeapDurationField()
    {
      return iLeapDurationField;
    }
    
    public long roundFloor(long paramLong)
    {
      if (iTimeField)
      {
        int i = getOffsetToAdd(paramLong);
        paramLong = iField.roundFloor(paramLong + i);
        return paramLong - i;
      }
      long l = iZone.convertUTCToLocal(paramLong);
      l = iField.roundFloor(l);
      return iZone.convertLocalToUTC(l, false, paramLong);
    }
    
    public long roundCeiling(long paramLong)
    {
      if (iTimeField)
      {
        int i = getOffsetToAdd(paramLong);
        paramLong = iField.roundCeiling(paramLong + i);
        return paramLong - i;
      }
      long l = iZone.convertUTCToLocal(paramLong);
      l = iField.roundCeiling(l);
      return iZone.convertLocalToUTC(l, false, paramLong);
    }
    
    public long remainder(long paramLong)
    {
      long l = iZone.convertUTCToLocal(paramLong);
      return iField.remainder(l);
    }
    
    public int getMinimumValue()
    {
      return iField.getMinimumValue();
    }
    
    public int getMinimumValue(long paramLong)
    {
      long l = iZone.convertUTCToLocal(paramLong);
      return iField.getMinimumValue(l);
    }
    
    public int getMinimumValue(ReadablePartial paramReadablePartial)
    {
      return iField.getMinimumValue(paramReadablePartial);
    }
    
    public int getMinimumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
    {
      return iField.getMinimumValue(paramReadablePartial, paramArrayOfInt);
    }
    
    public int getMaximumValue()
    {
      return iField.getMaximumValue();
    }
    
    public int getMaximumValue(long paramLong)
    {
      long l = iZone.convertUTCToLocal(paramLong);
      return iField.getMaximumValue(l);
    }
    
    public int getMaximumValue(ReadablePartial paramReadablePartial)
    {
      return iField.getMaximumValue(paramReadablePartial);
    }
    
    public int getMaximumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
    {
      return iField.getMaximumValue(paramReadablePartial, paramArrayOfInt);
    }
    
    public int getMaximumTextLength(Locale paramLocale)
    {
      return iField.getMaximumTextLength(paramLocale);
    }
    
    public int getMaximumShortTextLength(Locale paramLocale)
    {
      return iField.getMaximumShortTextLength(paramLocale);
    }
    
    private int getOffsetToAdd(long paramLong)
    {
      int i = iZone.getOffset(paramLong);
      long l = paramLong + i;
      if (((paramLong ^ l) < 0L) && ((paramLong ^ i) >= 0L)) {
        throw new ArithmeticException("Adding time zone offset caused overflow");
      }
      return i;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject instanceof ZonedDateTimeField))
      {
        ZonedDateTimeField localZonedDateTimeField = (ZonedDateTimeField)paramObject;
        return (iField.equals(iField)) && (iZone.equals(iZone)) && (iDurationField.equals(iDurationField)) && (iRangeDurationField.equals(iRangeDurationField));
      }
      return false;
    }
    
    public int hashCode()
    {
      return iField.hashCode() ^ iZone.hashCode();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ZonedChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */