package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.IllegalFieldValueException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Instant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.LocalDate;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.BaseDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.DecoratedDurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public final class GJChronology
  extends AssembledChronology
{
  private static final long serialVersionUID = -2545574827706931671L;
  
  private static long convertByYear(long paramLong, Chronology paramChronology1, Chronology paramChronology2)
  {
    return paramChronology2.getDateTimeMillis(paramChronology1.year().get(paramLong), paramChronology1.monthOfYear().get(paramLong), paramChronology1.dayOfMonth().get(paramLong), paramChronology1.millisOfDay().get(paramLong));
  }
  
  private static long convertByWeekyear(long paramLong, Chronology paramChronology1, Chronology paramChronology2)
  {
    long l = paramChronology2.weekyear().set(0L, paramChronology1.weekyear().get(paramLong));
    l = paramChronology2.weekOfWeekyear().set(l, paramChronology1.weekOfWeekyear().get(paramLong));
    l = paramChronology2.dayOfWeek().set(l, paramChronology1.dayOfWeek().get(paramLong));
    l = paramChronology2.millisOfDay().set(l, paramChronology1.millisOfDay().get(paramLong));
    return l;
  }
  
  static final Instant DEFAULT_CUTOVER = new Instant(-12219292800000L);
  private static final ConcurrentHashMap<GJCacheKey, GJChronology> cCache = new ConcurrentHashMap();
  private JulianChronology iJulianChronology;
  private GregorianChronology iGregorianChronology;
  private Instant iCutoverInstant;
  private long iCutoverMillis;
  private long iGapDuration;
  
  public static GJChronology getInstanceUTC()
  {
    return getInstance(DateTimeZone.UTC, DEFAULT_CUTOVER, 4);
  }
  
  public static GJChronology getInstance()
  {
    return getInstance(DateTimeZone.getDefault(), DEFAULT_CUTOVER, 4);
  }
  
  public static GJChronology getInstance(DateTimeZone paramDateTimeZone)
  {
    return getInstance(paramDateTimeZone, DEFAULT_CUTOVER, 4);
  }
  
  public static GJChronology getInstance(DateTimeZone paramDateTimeZone, ReadableInstant paramReadableInstant)
  {
    return getInstance(paramDateTimeZone, paramReadableInstant, 4);
  }
  
  public static GJChronology getInstance(DateTimeZone paramDateTimeZone, ReadableInstant paramReadableInstant, int paramInt)
  {
    paramDateTimeZone = DateTimeUtils.getZone(paramDateTimeZone);
    Instant localInstant;
    if (paramReadableInstant == null)
    {
      localInstant = DEFAULT_CUTOVER;
    }
    else
    {
      localInstant = paramReadableInstant.toInstant();
      localObject1 = new LocalDate(localInstant.getMillis(), GregorianChronology.getInstance(paramDateTimeZone));
      if (((LocalDate)localObject1).getYear() <= 0) {
        throw new IllegalArgumentException("Cutover too early. Must be on or after 0001-01-01.");
      }
    }
    Object localObject1 = new GJCacheKey(paramDateTimeZone, localInstant, paramInt);
    Object localObject2 = (GJChronology)cCache.get(localObject1);
    if (localObject2 == null)
    {
      if (paramDateTimeZone == DateTimeZone.UTC)
      {
        localObject2 = new GJChronology(JulianChronology.getInstance(paramDateTimeZone, paramInt), GregorianChronology.getInstance(paramDateTimeZone, paramInt), localInstant);
      }
      else
      {
        localObject2 = getInstance(DateTimeZone.UTC, localInstant, paramInt);
        localObject2 = new GJChronology(ZonedChronology.getInstance((Chronology)localObject2, paramDateTimeZone), iJulianChronology, iGregorianChronology, iCutoverInstant);
      }
      GJChronology localGJChronology = (GJChronology)cCache.putIfAbsent(localObject1, localObject2);
      if (localGJChronology != null) {
        localObject2 = localGJChronology;
      }
    }
    return (GJChronology)localObject2;
  }
  
  public static GJChronology getInstance(DateTimeZone paramDateTimeZone, long paramLong, int paramInt)
  {
    Instant localInstant;
    if (paramLong == DEFAULT_CUTOVER.getMillis()) {
      localInstant = null;
    } else {
      localInstant = new Instant(paramLong);
    }
    return getInstance(paramDateTimeZone, localInstant, paramInt);
  }
  
  private GJChronology(JulianChronology paramJulianChronology, GregorianChronology paramGregorianChronology, Instant paramInstant)
  {
    super(null, new Object[] { paramJulianChronology, paramGregorianChronology, paramInstant });
  }
  
  private GJChronology(Chronology paramChronology, JulianChronology paramJulianChronology, GregorianChronology paramGregorianChronology, Instant paramInstant)
  {
    super(paramChronology, new Object[] { paramJulianChronology, paramGregorianChronology, paramInstant });
  }
  
  private Object readResolve()
  {
    return getInstance(getZone(), iCutoverInstant, getMinimumDaysInFirstWeek());
  }
  
  public DateTimeZone getZone()
  {
    Chronology localChronology;
    if ((localChronology = getBase()) != null) {
      return localChronology.getZone();
    }
    return DateTimeZone.UTC;
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
    return getInstance(paramDateTimeZone, iCutoverInstant, getMinimumDaysInFirstWeek());
  }
  
  public long getDateTimeMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException
  {
    Chronology localChronology;
    if ((localChronology = getBase()) != null) {
      return localChronology.getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    long l = iGregorianChronology.getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4);
    if (l < iCutoverMillis)
    {
      l = iJulianChronology.getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4);
      if (l >= iCutoverMillis) {
        throw new IllegalArgumentException("Specified date does not exist");
      }
    }
    return l;
  }
  
  public long getDateTimeMillis(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    throws IllegalArgumentException
  {
    Chronology localChronology;
    if ((localChronology = getBase()) != null) {
      return localChronology.getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    }
    long l;
    try
    {
      l = iGregorianChronology.getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    }
    catch (IllegalFieldValueException localIllegalFieldValueException)
    {
      if ((paramInt2 != 2) || (paramInt3 != 29)) {
        throw localIllegalFieldValueException;
      }
      l = iGregorianChronology.getDateTimeMillis(paramInt1, paramInt2, 28, paramInt4, paramInt5, paramInt6, paramInt7);
      if (l >= iCutoverMillis) {
        throw localIllegalFieldValueException;
      }
    }
    if (l < iCutoverMillis)
    {
      l = iJulianChronology.getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      if (l >= iCutoverMillis) {
        throw new IllegalArgumentException("Specified date does not exist");
      }
    }
    return l;
  }
  
  public Instant getGregorianCutover()
  {
    return iCutoverInstant;
  }
  
  public int getMinimumDaysInFirstWeek()
  {
    return iGregorianChronology.getMinimumDaysInFirstWeek();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof GJChronology))
    {
      GJChronology localGJChronology = (GJChronology)paramObject;
      return (iCutoverMillis == iCutoverMillis) && (getMinimumDaysInFirstWeek() == localGJChronology.getMinimumDaysInFirstWeek()) && (getZone().equals(localGJChronology.getZone()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return "GJ".hashCode() * 11 + getZone().hashCode() + getMinimumDaysInFirstWeek() + iCutoverInstant.hashCode();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(60);
    localStringBuffer.append("GJChronology");
    localStringBuffer.append('[');
    localStringBuffer.append(getZone().getID());
    if (iCutoverMillis != DEFAULT_CUTOVER.getMillis())
    {
      localStringBuffer.append(",cutover=");
      DateTimeFormatter localDateTimeFormatter;
      if (withUTC().dayOfYear().remainder(iCutoverMillis) == 0L) {
        localDateTimeFormatter = ISODateTimeFormat.date();
      } else {
        localDateTimeFormatter = ISODateTimeFormat.dateTime();
      }
      localDateTimeFormatter.withChronology(withUTC()).printTo(localStringBuffer, iCutoverMillis);
    }
    if (getMinimumDaysInFirstWeek() != 4)
    {
      localStringBuffer.append(",mdfw=");
      localStringBuffer.append(getMinimumDaysInFirstWeek());
    }
    localStringBuffer.append(']');
    
    return localStringBuffer.toString();
  }
  
  protected void assemble(AssembledChronology.Fields paramFields)
  {
    Object[] arrayOfObject = (Object[])getParam();
    
    JulianChronology localJulianChronology = (JulianChronology)arrayOfObject[0];
    GregorianChronology localGregorianChronology = (GregorianChronology)arrayOfObject[1];
    Instant localInstant = (Instant)arrayOfObject[2];
    iCutoverMillis = localInstant.getMillis();
    
    iJulianChronology = localJulianChronology;
    iGregorianChronology = localGregorianChronology;
    iCutoverInstant = localInstant;
    if (getBase() != null) {
      return;
    }
    if (localJulianChronology.getMinimumDaysInFirstWeek() != localGregorianChronology.getMinimumDaysInFirstWeek()) {
      throw new IllegalArgumentException();
    }
    iGapDuration = (iCutoverMillis - julianToGregorianByYear(iCutoverMillis));
    
    paramFields.copyFieldsFrom(localGregorianChronology);
    if (localGregorianChronology.millisOfDay().get(iCutoverMillis) == 0)
    {
      millisOfSecond = new CutoverField(localJulianChronology.millisOfSecond(), millisOfSecond, iCutoverMillis);
      millisOfDay = new CutoverField(localJulianChronology.millisOfDay(), millisOfDay, iCutoverMillis);
      secondOfMinute = new CutoverField(localJulianChronology.secondOfMinute(), secondOfMinute, iCutoverMillis);
      secondOfDay = new CutoverField(localJulianChronology.secondOfDay(), secondOfDay, iCutoverMillis);
      minuteOfHour = new CutoverField(localJulianChronology.minuteOfHour(), minuteOfHour, iCutoverMillis);
      minuteOfDay = new CutoverField(localJulianChronology.minuteOfDay(), minuteOfDay, iCutoverMillis);
      hourOfDay = new CutoverField(localJulianChronology.hourOfDay(), hourOfDay, iCutoverMillis);
      hourOfHalfday = new CutoverField(localJulianChronology.hourOfHalfday(), hourOfHalfday, iCutoverMillis);
      clockhourOfDay = new CutoverField(localJulianChronology.clockhourOfDay(), clockhourOfDay, iCutoverMillis);
      clockhourOfHalfday = new CutoverField(localJulianChronology.clockhourOfHalfday(), clockhourOfHalfday, iCutoverMillis);
      
      halfdayOfDay = new CutoverField(localJulianChronology.halfdayOfDay(), halfdayOfDay, iCutoverMillis);
    }
    era = new CutoverField(localJulianChronology.era(), era, iCutoverMillis);
    
    year = new ImpreciseCutoverField(localJulianChronology.year(), year, iCutoverMillis);
    
    years = year.getDurationField();
    yearOfEra = new ImpreciseCutoverField(localJulianChronology.yearOfEra(), yearOfEra, years, iCutoverMillis);
    
    centuryOfEra = new ImpreciseCutoverField(localJulianChronology.centuryOfEra(), centuryOfEra, iCutoverMillis);
    
    centuries = centuryOfEra.getDurationField();
    
    yearOfCentury = new ImpreciseCutoverField(localJulianChronology.yearOfCentury(), yearOfCentury, years, centuries, iCutoverMillis);
    
    monthOfYear = new ImpreciseCutoverField(localJulianChronology.monthOfYear(), monthOfYear, null, years, iCutoverMillis);
    
    months = monthOfYear.getDurationField();
    
    weekyear = new ImpreciseCutoverField(localJulianChronology.weekyear(), weekyear, null, iCutoverMillis, true);
    
    weekyears = weekyear.getDurationField();
    weekyearOfCentury = new ImpreciseCutoverField(localJulianChronology.weekyearOfCentury(), weekyearOfCentury, weekyears, centuries, iCutoverMillis);
    
    long l = localGregorianChronology.year().roundCeiling(iCutoverMillis);
    dayOfYear = new CutoverField(localJulianChronology.dayOfYear(), dayOfYear, years, l, false);
    
    l = localGregorianChronology.weekyear().roundCeiling(iCutoverMillis);
    weekOfWeekyear = new CutoverField(localJulianChronology.weekOfWeekyear(), weekOfWeekyear, weekyears, l, true);
    
    CutoverField localCutoverField = new CutoverField(localJulianChronology.dayOfMonth(), dayOfMonth, iCutoverMillis);
    
    iRangeDurationField = months;
    dayOfMonth = localCutoverField;
  }
  
  long julianToGregorianByYear(long paramLong)
  {
    return convertByYear(paramLong, iJulianChronology, iGregorianChronology);
  }
  
  long gregorianToJulianByYear(long paramLong)
  {
    return convertByYear(paramLong, iGregorianChronology, iJulianChronology);
  }
  
  long julianToGregorianByWeekyear(long paramLong)
  {
    return convertByWeekyear(paramLong, iJulianChronology, iGregorianChronology);
  }
  
  long gregorianToJulianByWeekyear(long paramLong)
  {
    return convertByWeekyear(paramLong, iGregorianChronology, iJulianChronology);
  }
  
  private class CutoverField
    extends BaseDateTimeField
  {
    private static final long serialVersionUID = 3528501219481026402L;
    final DateTimeField iJulianField;
    final DateTimeField iGregorianField;
    final long iCutover;
    final boolean iConvertByWeekyear;
    protected DurationField iDurationField;
    protected DurationField iRangeDurationField;
    
    CutoverField(DateTimeField paramDateTimeField1, DateTimeField paramDateTimeField2, long paramLong)
    {
      this(paramDateTimeField1, paramDateTimeField2, paramLong, false);
    }
    
    CutoverField(DateTimeField paramDateTimeField1, DateTimeField paramDateTimeField2, long paramLong, boolean paramBoolean)
    {
      this(paramDateTimeField1, paramDateTimeField2, null, paramLong, paramBoolean);
    }
    
    CutoverField(DateTimeField paramDateTimeField1, DateTimeField paramDateTimeField2, DurationField paramDurationField, long paramLong, boolean paramBoolean)
    {
      super();
      iJulianField = paramDateTimeField1;
      iGregorianField = paramDateTimeField2;
      iCutover = paramLong;
      iConvertByWeekyear = paramBoolean;
      
      iDurationField = paramDateTimeField2.getDurationField();
      if (paramDurationField == null)
      {
        paramDurationField = paramDateTimeField2.getRangeDurationField();
        if (paramDurationField == null) {
          paramDurationField = paramDateTimeField1.getRangeDurationField();
        }
      }
      iRangeDurationField = paramDurationField;
    }
    
    public boolean isLenient()
    {
      return false;
    }
    
    public int get(long paramLong)
    {
      if (paramLong >= iCutover) {
        return iGregorianField.get(paramLong);
      }
      return iJulianField.get(paramLong);
    }
    
    public String getAsText(long paramLong, Locale paramLocale)
    {
      if (paramLong >= iCutover) {
        return iGregorianField.getAsText(paramLong, paramLocale);
      }
      return iJulianField.getAsText(paramLong, paramLocale);
    }
    
    public String getAsText(int paramInt, Locale paramLocale)
    {
      return iGregorianField.getAsText(paramInt, paramLocale);
    }
    
    public String getAsShortText(long paramLong, Locale paramLocale)
    {
      if (paramLong >= iCutover) {
        return iGregorianField.getAsShortText(paramLong, paramLocale);
      }
      return iJulianField.getAsShortText(paramLong, paramLocale);
    }
    
    public String getAsShortText(int paramInt, Locale paramLocale)
    {
      return iGregorianField.getAsShortText(paramInt, paramLocale);
    }
    
    public long add(long paramLong, int paramInt)
    {
      return iGregorianField.add(paramLong, paramInt);
    }
    
    public long add(long paramLong1, long paramLong2)
    {
      return iGregorianField.add(paramLong1, paramLong2);
    }
    
    public int[] add(ReadablePartial paramReadablePartial, int paramInt1, int[] paramArrayOfInt, int paramInt2)
    {
      if (paramInt2 == 0) {
        return paramArrayOfInt;
      }
      if (DateTimeUtils.isContiguous(paramReadablePartial))
      {
        long l = 0L;
        int i = 0;
        for (int j = paramReadablePartial.size(); i < j; i++) {
          l = paramReadablePartial.getFieldType(i).getField(GJChronology.this).set(l, paramArrayOfInt[i]);
        }
        l = add(l, paramInt2);
        return get(paramReadablePartial, l);
      }
      return super.add(paramReadablePartial, paramInt1, paramArrayOfInt, paramInt2);
    }
    
    public int getDifference(long paramLong1, long paramLong2)
    {
      return iGregorianField.getDifference(paramLong1, paramLong2);
    }
    
    public long getDifferenceAsLong(long paramLong1, long paramLong2)
    {
      return iGregorianField.getDifferenceAsLong(paramLong1, paramLong2);
    }
    
    public long set(long paramLong, int paramInt)
    {
      if (paramLong >= iCutover)
      {
        paramLong = iGregorianField.set(paramLong, paramInt);
        if (paramLong < iCutover)
        {
          if (paramLong + iGapDuration < iCutover) {
            paramLong = gregorianToJulian(paramLong);
          }
          if (get(paramLong) != paramInt) {
            throw new IllegalFieldValueException(iGregorianField.getType(), Integer.valueOf(paramInt), null, null);
          }
        }
      }
      else
      {
        paramLong = iJulianField.set(paramLong, paramInt);
        if (paramLong >= iCutover)
        {
          if (paramLong - iGapDuration >= iCutover) {
            paramLong = julianToGregorian(paramLong);
          }
          if (get(paramLong) != paramInt) {
            throw new IllegalFieldValueException(iJulianField.getType(), Integer.valueOf(paramInt), null, null);
          }
        }
      }
      return paramLong;
    }
    
    public long set(long paramLong, String paramString, Locale paramLocale)
    {
      if (paramLong >= iCutover)
      {
        paramLong = iGregorianField.set(paramLong, paramString, paramLocale);
        if (paramLong < iCutover) {
          if (paramLong + iGapDuration < iCutover) {
            paramLong = gregorianToJulian(paramLong);
          }
        }
      }
      else
      {
        paramLong = iJulianField.set(paramLong, paramString, paramLocale);
        if (paramLong >= iCutover) {
          if (paramLong - iGapDuration >= iCutover) {
            paramLong = julianToGregorian(paramLong);
          }
        }
      }
      return paramLong;
    }
    
    public DurationField getDurationField()
    {
      return iDurationField;
    }
    
    public DurationField getRangeDurationField()
    {
      return iRangeDurationField;
    }
    
    public boolean isLeap(long paramLong)
    {
      if (paramLong >= iCutover) {
        return iGregorianField.isLeap(paramLong);
      }
      return iJulianField.isLeap(paramLong);
    }
    
    public int getLeapAmount(long paramLong)
    {
      if (paramLong >= iCutover) {
        return iGregorianField.getLeapAmount(paramLong);
      }
      return iJulianField.getLeapAmount(paramLong);
    }
    
    public DurationField getLeapDurationField()
    {
      return iGregorianField.getLeapDurationField();
    }
    
    public int getMinimumValue()
    {
      return iJulianField.getMinimumValue();
    }
    
    public int getMinimumValue(ReadablePartial paramReadablePartial)
    {
      return iJulianField.getMinimumValue(paramReadablePartial);
    }
    
    public int getMinimumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
    {
      return iJulianField.getMinimumValue(paramReadablePartial, paramArrayOfInt);
    }
    
    public int getMinimumValue(long paramLong)
    {
      if (paramLong < iCutover) {
        return iJulianField.getMinimumValue(paramLong);
      }
      int i = iGregorianField.getMinimumValue(paramLong);
      
      paramLong = iGregorianField.set(paramLong, i);
      if (paramLong < iCutover) {
        i = iGregorianField.get(iCutover);
      }
      return i;
    }
    
    public int getMaximumValue()
    {
      return iGregorianField.getMaximumValue();
    }
    
    public int getMaximumValue(long paramLong)
    {
      if (paramLong >= iCutover) {
        return iGregorianField.getMaximumValue(paramLong);
      }
      int i = iJulianField.getMaximumValue(paramLong);
      
      paramLong = iJulianField.set(paramLong, i);
      if (paramLong >= iCutover) {
        i = iJulianField.get(iJulianField.add(iCutover, -1));
      }
      return i;
    }
    
    public int getMaximumValue(ReadablePartial paramReadablePartial)
    {
      long l = GJChronology.getInstanceUTC().set(paramReadablePartial, 0L);
      return getMaximumValue(l);
    }
    
    public int getMaximumValue(ReadablePartial paramReadablePartial, int[] paramArrayOfInt)
    {
      GJChronology localGJChronology = GJChronology.getInstanceUTC();
      long l = 0L;
      int i = 0;
      for (int j = paramReadablePartial.size(); i < j; i++)
      {
        DateTimeField localDateTimeField = paramReadablePartial.getFieldType(i).getField(localGJChronology);
        if (paramArrayOfInt[i] <= localDateTimeField.getMaximumValue(l)) {
          l = localDateTimeField.set(l, paramArrayOfInt[i]);
        }
      }
      return getMaximumValue(l);
    }
    
    public long roundFloor(long paramLong)
    {
      if (paramLong >= iCutover)
      {
        paramLong = iGregorianField.roundFloor(paramLong);
        if (paramLong < iCutover) {
          if (paramLong + iGapDuration < iCutover) {
            paramLong = gregorianToJulian(paramLong);
          }
        }
      }
      else
      {
        paramLong = iJulianField.roundFloor(paramLong);
      }
      return paramLong;
    }
    
    public long roundCeiling(long paramLong)
    {
      if (paramLong >= iCutover)
      {
        paramLong = iGregorianField.roundCeiling(paramLong);
      }
      else
      {
        paramLong = iJulianField.roundCeiling(paramLong);
        if (paramLong >= iCutover) {
          if (paramLong - iGapDuration >= iCutover) {
            paramLong = julianToGregorian(paramLong);
          }
        }
      }
      return paramLong;
    }
    
    public int getMaximumTextLength(Locale paramLocale)
    {
      return Math.max(iJulianField.getMaximumTextLength(paramLocale), iGregorianField.getMaximumTextLength(paramLocale));
    }
    
    public int getMaximumShortTextLength(Locale paramLocale)
    {
      return Math.max(iJulianField.getMaximumShortTextLength(paramLocale), iGregorianField.getMaximumShortTextLength(paramLocale));
    }
    
    protected long julianToGregorian(long paramLong)
    {
      if (iConvertByWeekyear) {
        return julianToGregorianByWeekyear(paramLong);
      }
      return julianToGregorianByYear(paramLong);
    }
    
    protected long gregorianToJulian(long paramLong)
    {
      if (iConvertByWeekyear) {
        return gregorianToJulianByWeekyear(paramLong);
      }
      return gregorianToJulianByYear(paramLong);
    }
  }
  
  private final class ImpreciseCutoverField
    extends GJChronology.CutoverField
  {
    private static final long serialVersionUID = 3410248757173576441L;
    
    ImpreciseCutoverField(DateTimeField paramDateTimeField1, DateTimeField paramDateTimeField2, long paramLong)
    {
      this(paramDateTimeField1, paramDateTimeField2, null, paramLong, false);
    }
    
    ImpreciseCutoverField(DateTimeField paramDateTimeField1, DateTimeField paramDateTimeField2, DurationField paramDurationField, long paramLong)
    {
      this(paramDateTimeField1, paramDateTimeField2, paramDurationField, paramLong, false);
    }
    
    ImpreciseCutoverField(DateTimeField paramDateTimeField1, DateTimeField paramDateTimeField2, DurationField paramDurationField1, DurationField paramDurationField2, long paramLong)
    {
      this(paramDateTimeField1, paramDateTimeField2, paramDurationField1, paramLong, false);
      iRangeDurationField = paramDurationField2;
    }
    
    ImpreciseCutoverField(DateTimeField paramDateTimeField1, DateTimeField paramDateTimeField2, DurationField paramDurationField, long paramLong, boolean paramBoolean)
    {
      super(paramDateTimeField1, paramDateTimeField2, paramLong, paramBoolean);
      if (paramDurationField == null) {
        paramDurationField = new GJChronology.LinkedDurationField(iDurationField, this);
      }
      iDurationField = paramDurationField;
    }
    
    public long add(long paramLong, int paramInt)
    {
      if (paramLong >= iCutover)
      {
        paramLong = iGregorianField.add(paramLong, paramInt);
        if (paramLong < iCutover) {
          if (paramLong + iGapDuration < iCutover)
          {
            int i;
            if (iConvertByWeekyear)
            {
              i = iGregorianChronology.weekyear().get(paramLong);
              if (i <= 0) {
                paramLong = iGregorianChronology.weekyear().add(paramLong, -1);
              }
            }
            else
            {
              i = iGregorianChronology.year().get(paramLong);
              if (i <= 0) {
                paramLong = iGregorianChronology.year().add(paramLong, -1);
              }
            }
            paramLong = gregorianToJulian(paramLong);
          }
        }
      }
      else
      {
        paramLong = iJulianField.add(paramLong, paramInt);
        if (paramLong >= iCutover) {
          if (paramLong - iGapDuration >= iCutover) {
            paramLong = julianToGregorian(paramLong);
          }
        }
      }
      return paramLong;
    }
    
    public long add(long paramLong1, long paramLong2)
    {
      if (paramLong1 >= iCutover)
      {
        paramLong1 = iGregorianField.add(paramLong1, paramLong2);
        if (paramLong1 < iCutover) {
          if (paramLong1 + iGapDuration < iCutover)
          {
            int i;
            if (iConvertByWeekyear)
            {
              i = iGregorianChronology.weekyear().get(paramLong1);
              if (i <= 0) {
                paramLong1 = iGregorianChronology.weekyear().add(paramLong1, -1);
              }
            }
            else
            {
              i = iGregorianChronology.year().get(paramLong1);
              if (i <= 0) {
                paramLong1 = iGregorianChronology.year().add(paramLong1, -1);
              }
            }
            paramLong1 = gregorianToJulian(paramLong1);
          }
        }
      }
      else
      {
        paramLong1 = iJulianField.add(paramLong1, paramLong2);
        if (paramLong1 >= iCutover) {
          if (paramLong1 - iGapDuration >= iCutover) {
            paramLong1 = julianToGregorian(paramLong1);
          }
        }
      }
      return paramLong1;
    }
    
    public int getDifference(long paramLong1, long paramLong2)
    {
      if (paramLong1 >= iCutover)
      {
        if (paramLong2 >= iCutover) {
          return iGregorianField.getDifference(paramLong1, paramLong2);
        }
        paramLong1 = gregorianToJulian(paramLong1);
        return iJulianField.getDifference(paramLong1, paramLong2);
      }
      if (paramLong2 < iCutover) {
        return iJulianField.getDifference(paramLong1, paramLong2);
      }
      paramLong1 = julianToGregorian(paramLong1);
      return iGregorianField.getDifference(paramLong1, paramLong2);
    }
    
    public long getDifferenceAsLong(long paramLong1, long paramLong2)
    {
      if (paramLong1 >= iCutover)
      {
        if (paramLong2 >= iCutover) {
          return iGregorianField.getDifferenceAsLong(paramLong1, paramLong2);
        }
        paramLong1 = gregorianToJulian(paramLong1);
        return iJulianField.getDifferenceAsLong(paramLong1, paramLong2);
      }
      if (paramLong2 < iCutover) {
        return iJulianField.getDifferenceAsLong(paramLong1, paramLong2);
      }
      paramLong1 = julianToGregorian(paramLong1);
      return iGregorianField.getDifferenceAsLong(paramLong1, paramLong2);
    }
    
    public int getMinimumValue(long paramLong)
    {
      if (paramLong >= iCutover) {
        return iGregorianField.getMinimumValue(paramLong);
      }
      return iJulianField.getMinimumValue(paramLong);
    }
    
    public int getMaximumValue(long paramLong)
    {
      if (paramLong >= iCutover) {
        return iGregorianField.getMaximumValue(paramLong);
      }
      return iJulianField.getMaximumValue(paramLong);
    }
  }
  
  private static class LinkedDurationField
    extends DecoratedDurationField
  {
    private static final long serialVersionUID = 4097975388007713084L;
    private final GJChronology.ImpreciseCutoverField iField;
    
    LinkedDurationField(DurationField paramDurationField, GJChronology.ImpreciseCutoverField paramImpreciseCutoverField)
    {
      super(paramDurationField.getType());
      iField = paramImpreciseCutoverField;
    }
    
    public long add(long paramLong, int paramInt)
    {
      return iField.add(paramLong, paramInt);
    }
    
    public long add(long paramLong1, long paramLong2)
    {
      return iField.add(paramLong1, paramLong2);
    }
    
    public int getDifference(long paramLong1, long paramLong2)
    {
      return iField.getDifference(paramLong1, paramLong2);
    }
    
    public long getDifferenceAsLong(long paramLong1, long paramLong2)
    {
      return iField.getDifferenceAsLong(paramLong1, paramLong2);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.GJChronology
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */