package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import java.lang.reflect.Method;
import java.text.DateFormatSymbols;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class DateTimeUtils
{
  public static final MillisProvider SYSTEM_MILLIS_PROVIDER = new SystemMillisProvider();
  private static volatile MillisProvider cMillisProvider = SYSTEM_MILLIS_PROVIDER;
  private static final AtomicReference<Map<String, DateTimeZone>> cZoneNames = new AtomicReference();
  
  public static final long currentTimeMillis()
  {
    return cMillisProvider.getMillis();
  }
  
  public static final void setCurrentMillisSystem()
    throws SecurityException
  {
    checkPermission();
    cMillisProvider = SYSTEM_MILLIS_PROVIDER;
  }
  
  public static final void setCurrentMillisFixed(long paramLong)
    throws SecurityException
  {
    checkPermission();
    cMillisProvider = new FixedMillisProvider(paramLong);
  }
  
  public static final void setCurrentMillisOffset(long paramLong)
    throws SecurityException
  {
    
    if (paramLong == 0L) {
      cMillisProvider = SYSTEM_MILLIS_PROVIDER;
    } else {
      cMillisProvider = new OffsetMillisProvider(paramLong);
    }
  }
  
  public static final void setCurrentMillisProvider(MillisProvider paramMillisProvider)
    throws SecurityException
  {
    if (paramMillisProvider == null) {
      throw new IllegalArgumentException("The MillisProvider must not be null");
    }
    checkPermission();
    cMillisProvider = paramMillisProvider;
  }
  
  private static void checkPermission()
    throws SecurityException
  {
    SecurityManager localSecurityManager = System.getSecurityManager();
    if (localSecurityManager != null) {
      localSecurityManager.checkPermission(new JodaTimePermission("CurrentTime.setProvider"));
    }
  }
  
  public static final long getInstantMillis(ReadableInstant paramReadableInstant)
  {
    if (paramReadableInstant == null) {
      return currentTimeMillis();
    }
    return paramReadableInstant.getMillis();
  }
  
  public static final Chronology getInstantChronology(ReadableInstant paramReadableInstant)
  {
    if (paramReadableInstant == null) {
      return ISOChronology.getInstance();
    }
    Chronology localChronology = paramReadableInstant.getChronology();
    if (localChronology == null) {
      return ISOChronology.getInstance();
    }
    return localChronology;
  }
  
  public static final Chronology getIntervalChronology(ReadableInstant paramReadableInstant1, ReadableInstant paramReadableInstant2)
  {
    Object localObject = null;
    if (paramReadableInstant1 != null) {
      localObject = paramReadableInstant1.getChronology();
    } else if (paramReadableInstant2 != null) {
      localObject = paramReadableInstant2.getChronology();
    }
    if (localObject == null) {
      localObject = ISOChronology.getInstance();
    }
    return (Chronology)localObject;
  }
  
  public static final Chronology getIntervalChronology(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval == null) {
      return ISOChronology.getInstance();
    }
    Chronology localChronology = paramReadableInterval.getChronology();
    if (localChronology == null) {
      return ISOChronology.getInstance();
    }
    return localChronology;
  }
  
  public static final ReadableInterval getReadableInterval(ReadableInterval paramReadableInterval)
  {
    if (paramReadableInterval == null)
    {
      long l = currentTimeMillis();
      paramReadableInterval = new Interval(l, l);
    }
    return paramReadableInterval;
  }
  
  public static final Chronology getChronology(Chronology paramChronology)
  {
    if (paramChronology == null) {
      return ISOChronology.getInstance();
    }
    return paramChronology;
  }
  
  public static final DateTimeZone getZone(DateTimeZone paramDateTimeZone)
  {
    if (paramDateTimeZone == null) {
      return DateTimeZone.getDefault();
    }
    return paramDateTimeZone;
  }
  
  public static final PeriodType getPeriodType(PeriodType paramPeriodType)
  {
    if (paramPeriodType == null) {
      return PeriodType.standard();
    }
    return paramPeriodType;
  }
  
  public static final long getDurationMillis(ReadableDuration paramReadableDuration)
  {
    if (paramReadableDuration == null) {
      return 0L;
    }
    return paramReadableDuration.getMillis();
  }
  
  public static final boolean isContiguous(ReadablePartial paramReadablePartial)
  {
    if (paramReadablePartial == null) {
      throw new IllegalArgumentException("Partial must not be null");
    }
    DurationFieldType localDurationFieldType = null;
    for (int i = 0; i < paramReadablePartial.size(); i++)
    {
      DateTimeField localDateTimeField = paramReadablePartial.getField(i);
      if ((i > 0) && (
        (localDateTimeField.getRangeDurationField() == null) || (localDateTimeField.getRangeDurationField().getType() != localDurationFieldType))) {
        return false;
      }
      localDurationFieldType = localDateTimeField.getDurationField().getType();
    }
    return true;
  }
  
  public static final DateFormatSymbols getDateFormatSymbols(Locale paramLocale)
  {
    try
    {
      Method localMethod = DateFormatSymbols.class.getMethod("getInstance", new Class[] { Locale.class });
      return (DateFormatSymbols)localMethod.invoke(null, new Object[] { paramLocale });
    }
    catch (Exception localException) {}
    return new DateFormatSymbols(paramLocale);
  }
  
  public static final Map<String, DateTimeZone> getDefaultTimeZoneNames()
  {
    Map localMap = (Map)cZoneNames.get();
    if (localMap == null)
    {
      localMap = buildDefaultTimeZoneNames();
      if (!cZoneNames.compareAndSet(null, localMap)) {
        localMap = (Map)cZoneNames.get();
      }
    }
    return localMap;
  }
  
  public static final void setDefaultTimeZoneNames(Map<String, DateTimeZone> paramMap)
  {
    cZoneNames.set(Collections.unmodifiableMap(new HashMap(paramMap)));
  }
  
  private static Map<String, DateTimeZone> buildDefaultTimeZoneNames()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("UT", DateTimeZone.UTC);
    localLinkedHashMap.put("UTC", DateTimeZone.UTC);
    localLinkedHashMap.put("GMT", DateTimeZone.UTC);
    put(localLinkedHashMap, "EST", "America/New_York");
    put(localLinkedHashMap, "EDT", "America/New_York");
    put(localLinkedHashMap, "CST", "America/Chicago");
    put(localLinkedHashMap, "CDT", "America/Chicago");
    put(localLinkedHashMap, "MST", "America/Denver");
    put(localLinkedHashMap, "MDT", "America/Denver");
    put(localLinkedHashMap, "PST", "America/Los_Angeles");
    put(localLinkedHashMap, "PDT", "America/Los_Angeles");
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  private static void put(Map<String, DateTimeZone> paramMap, String paramString1, String paramString2)
  {
    try
    {
      paramMap.put(paramString1, DateTimeZone.forID(paramString2));
    }
    catch (RuntimeException localRuntimeException) {}
  }
  
  public static final double toJulianDay(long paramLong)
  {
    double d = paramLong / 8.64E7D;
    return d + 2440587.5D;
  }
  
  public static final long toJulianDayNumber(long paramLong)
  {
    return Math.floor(toJulianDay(paramLong) + 0.5D);
  }
  
  public static final long fromJulianDay(double paramDouble)
  {
    double d = paramDouble - 2440587.5D;
    return (d * 8.64E7D);
  }
  
  public static abstract interface MillisProvider
  {
    public abstract long getMillis();
  }
  
  static class SystemMillisProvider
    implements DateTimeUtils.MillisProvider
  {
    public long getMillis()
    {
      return System.currentTimeMillis();
    }
  }
  
  static class FixedMillisProvider
    implements DateTimeUtils.MillisProvider
  {
    private final long iMillis;
    
    FixedMillisProvider(long paramLong)
    {
      iMillis = paramLong;
    }
    
    public long getMillis()
    {
      return iMillis;
    }
  }
  
  static class OffsetMillisProvider
    implements DateTimeUtils.MillisProvider
  {
    private final long iMillis;
    
    OffsetMillisProvider(long paramLong)
    {
      iMillis = paramLong;
    }
    
    public long getMillis()
    {
      return System.currentTimeMillis() + iMillis;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */