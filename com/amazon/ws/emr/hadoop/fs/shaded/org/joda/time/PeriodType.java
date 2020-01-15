package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeriodType
  implements Serializable
{
  private static final long serialVersionUID = 2274324892792009998L;
  private static final Map<PeriodType, Object> cTypes = new HashMap(32);
  static int YEAR_INDEX = 0;
  static int MONTH_INDEX = 1;
  static int WEEK_INDEX = 2;
  static int DAY_INDEX = 3;
  static int HOUR_INDEX = 4;
  static int MINUTE_INDEX = 5;
  static int SECOND_INDEX = 6;
  static int MILLI_INDEX = 7;
  private static PeriodType cStandard;
  private static PeriodType cYMDTime;
  private static PeriodType cYMD;
  private static PeriodType cYWDTime;
  private static PeriodType cYWD;
  private static PeriodType cYDTime;
  private static PeriodType cYD;
  private static PeriodType cDTime;
  private static PeriodType cTime;
  private static PeriodType cYears;
  private static PeriodType cMonths;
  private static PeriodType cWeeks;
  private static PeriodType cDays;
  private static PeriodType cHours;
  private static PeriodType cMinutes;
  private static PeriodType cSeconds;
  private static PeriodType cMillis;
  private final String iName;
  private final DurationFieldType[] iTypes;
  private final int[] iIndices;
  
  public static PeriodType standard()
  {
    PeriodType localPeriodType = cStandard;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("Standard", new DurationFieldType[] { DurationFieldType.years(), DurationFieldType.months(), DurationFieldType.weeks(), DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis() }, new int[] { 0, 1, 2, 3, 4, 5, 6, 7 });
      
      cStandard = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType yearMonthDayTime()
  {
    PeriodType localPeriodType = cYMDTime;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("YearMonthDayTime", new DurationFieldType[] { DurationFieldType.years(), DurationFieldType.months(), DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis() }, new int[] { 0, 1, -1, 2, 3, 4, 5, 6 });
      
      cYMDTime = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType yearMonthDay()
  {
    PeriodType localPeriodType = cYMD;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("YearMonthDay", new DurationFieldType[] { DurationFieldType.years(), DurationFieldType.months(), DurationFieldType.days() }, new int[] { 0, 1, -1, 2, -1, -1, -1, -1 });
      
      cYMD = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType yearWeekDayTime()
  {
    PeriodType localPeriodType = cYWDTime;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("YearWeekDayTime", new DurationFieldType[] { DurationFieldType.years(), DurationFieldType.weeks(), DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis() }, new int[] { 0, -1, 1, 2, 3, 4, 5, 6 });
      
      cYWDTime = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType yearWeekDay()
  {
    PeriodType localPeriodType = cYWD;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("YearWeekDay", new DurationFieldType[] { DurationFieldType.years(), DurationFieldType.weeks(), DurationFieldType.days() }, new int[] { 0, -1, 1, 2, -1, -1, -1, -1 });
      
      cYWD = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType yearDayTime()
  {
    PeriodType localPeriodType = cYDTime;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("YearDayTime", new DurationFieldType[] { DurationFieldType.years(), DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis() }, new int[] { 0, -1, -1, 1, 2, 3, 4, 5 });
      
      cYDTime = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType yearDay()
  {
    PeriodType localPeriodType = cYD;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("YearDay", new DurationFieldType[] { DurationFieldType.years(), DurationFieldType.days() }, new int[] { 0, -1, -1, 1, -1, -1, -1, -1 });
      
      cYD = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType dayTime()
  {
    PeriodType localPeriodType = cDTime;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("DayTime", new DurationFieldType[] { DurationFieldType.days(), DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis() }, new int[] { -1, -1, -1, 0, 1, 2, 3, 4 });
      
      cDTime = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType time()
  {
    PeriodType localPeriodType = cTime;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("Time", new DurationFieldType[] { DurationFieldType.hours(), DurationFieldType.minutes(), DurationFieldType.seconds(), DurationFieldType.millis() }, new int[] { -1, -1, -1, -1, 0, 1, 2, 3 });
      
      cTime = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType years()
  {
    PeriodType localPeriodType = cYears;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("Years", new DurationFieldType[] { DurationFieldType.years() }, new int[] { 0, -1, -1, -1, -1, -1, -1, -1 });
      
      cYears = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType months()
  {
    PeriodType localPeriodType = cMonths;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("Months", new DurationFieldType[] { DurationFieldType.months() }, new int[] { -1, 0, -1, -1, -1, -1, -1, -1 });
      
      cMonths = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType weeks()
  {
    PeriodType localPeriodType = cWeeks;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("Weeks", new DurationFieldType[] { DurationFieldType.weeks() }, new int[] { -1, -1, 0, -1, -1, -1, -1, -1 });
      
      cWeeks = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType days()
  {
    PeriodType localPeriodType = cDays;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("Days", new DurationFieldType[] { DurationFieldType.days() }, new int[] { -1, -1, -1, 0, -1, -1, -1, -1 });
      
      cDays = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType hours()
  {
    PeriodType localPeriodType = cHours;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("Hours", new DurationFieldType[] { DurationFieldType.hours() }, new int[] { -1, -1, -1, -1, 0, -1, -1, -1 });
      
      cHours = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType minutes()
  {
    PeriodType localPeriodType = cMinutes;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("Minutes", new DurationFieldType[] { DurationFieldType.minutes() }, new int[] { -1, -1, -1, -1, -1, 0, -1, -1 });
      
      cMinutes = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType seconds()
  {
    PeriodType localPeriodType = cSeconds;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("Seconds", new DurationFieldType[] { DurationFieldType.seconds() }, new int[] { -1, -1, -1, -1, -1, -1, 0, -1 });
      
      cSeconds = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static PeriodType millis()
  {
    PeriodType localPeriodType = cMillis;
    if (localPeriodType == null)
    {
      localPeriodType = new PeriodType("Millis", new DurationFieldType[] { DurationFieldType.millis() }, new int[] { -1, -1, -1, -1, -1, -1, -1, 0 });
      
      cMillis = localPeriodType;
    }
    return localPeriodType;
  }
  
  public static synchronized PeriodType forFields(DurationFieldType[] paramArrayOfDurationFieldType)
  {
    if ((paramArrayOfDurationFieldType == null) || (paramArrayOfDurationFieldType.length == 0)) {
      throw new IllegalArgumentException("Types array must not be null or empty");
    }
    for (int i = 0; i < paramArrayOfDurationFieldType.length; i++) {
      if (paramArrayOfDurationFieldType[i] == null) {
        throw new IllegalArgumentException("Types array must not contain null");
      }
    }
    Map localMap = cTypes;
    if (localMap.isEmpty())
    {
      localMap.put(standard(), standard());
      localMap.put(yearMonthDayTime(), yearMonthDayTime());
      localMap.put(yearMonthDay(), yearMonthDay());
      localMap.put(yearWeekDayTime(), yearWeekDayTime());
      localMap.put(yearWeekDay(), yearWeekDay());
      localMap.put(yearDayTime(), yearDayTime());
      localMap.put(yearDay(), yearDay());
      localMap.put(dayTime(), dayTime());
      localMap.put(time(), time());
      localMap.put(years(), years());
      localMap.put(months(), months());
      localMap.put(weeks(), weeks());
      localMap.put(days(), days());
      localMap.put(hours(), hours());
      localMap.put(minutes(), minutes());
      localMap.put(seconds(), seconds());
      localMap.put(millis(), millis());
    }
    PeriodType localPeriodType1 = new PeriodType(null, paramArrayOfDurationFieldType, null);
    Object localObject = localMap.get(localPeriodType1);
    if ((localObject instanceof PeriodType)) {
      return (PeriodType)localObject;
    }
    if (localObject != null) {
      throw new IllegalArgumentException("PeriodType does not support fields: " + localObject);
    }
    PeriodType localPeriodType2 = standard();
    ArrayList localArrayList = new ArrayList(Arrays.asList(paramArrayOfDurationFieldType));
    if (!localArrayList.remove(DurationFieldType.years())) {
      localPeriodType2 = localPeriodType2.withYearsRemoved();
    }
    if (!localArrayList.remove(DurationFieldType.months())) {
      localPeriodType2 = localPeriodType2.withMonthsRemoved();
    }
    if (!localArrayList.remove(DurationFieldType.weeks())) {
      localPeriodType2 = localPeriodType2.withWeeksRemoved();
    }
    if (!localArrayList.remove(DurationFieldType.days())) {
      localPeriodType2 = localPeriodType2.withDaysRemoved();
    }
    if (!localArrayList.remove(DurationFieldType.hours())) {
      localPeriodType2 = localPeriodType2.withHoursRemoved();
    }
    if (!localArrayList.remove(DurationFieldType.minutes())) {
      localPeriodType2 = localPeriodType2.withMinutesRemoved();
    }
    if (!localArrayList.remove(DurationFieldType.seconds())) {
      localPeriodType2 = localPeriodType2.withSecondsRemoved();
    }
    if (!localArrayList.remove(DurationFieldType.millis())) {
      localPeriodType2 = localPeriodType2.withMillisRemoved();
    }
    if (localArrayList.size() > 0)
    {
      localMap.put(localPeriodType1, localArrayList);
      throw new IllegalArgumentException("PeriodType does not support fields: " + localArrayList);
    }
    PeriodType localPeriodType3 = new PeriodType(null, iTypes, null);
    PeriodType localPeriodType4 = (PeriodType)localMap.get(localPeriodType3);
    if (localPeriodType4 != null)
    {
      localMap.put(localPeriodType3, localPeriodType4);
      return localPeriodType4;
    }
    localMap.put(localPeriodType3, localPeriodType2);
    return localPeriodType2;
  }
  
  protected PeriodType(String paramString, DurationFieldType[] paramArrayOfDurationFieldType, int[] paramArrayOfInt)
  {
    iName = paramString;
    iTypes = paramArrayOfDurationFieldType;
    iIndices = paramArrayOfInt;
  }
  
  public String getName()
  {
    return iName;
  }
  
  public int size()
  {
    return iTypes.length;
  }
  
  public DurationFieldType getFieldType(int paramInt)
  {
    return iTypes[paramInt];
  }
  
  public boolean isSupported(DurationFieldType paramDurationFieldType)
  {
    return indexOf(paramDurationFieldType) >= 0;
  }
  
  public int indexOf(DurationFieldType paramDurationFieldType)
  {
    int i = 0;
    for (int j = size(); i < j; i++) {
      if (iTypes[i] == paramDurationFieldType) {
        return i;
      }
    }
    return -1;
  }
  
  public String toString()
  {
    return "PeriodType[" + getName() + "]";
  }
  
  int getIndexedField(ReadablePeriod paramReadablePeriod, int paramInt)
  {
    int i = iIndices[paramInt];
    return i == -1 ? 0 : paramReadablePeriod.getValue(i);
  }
  
  boolean setIndexedField(ReadablePeriod paramReadablePeriod, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int i = iIndices[paramInt1];
    if (i == -1) {
      throw new UnsupportedOperationException("Field is not supported");
    }
    paramArrayOfInt[i] = paramInt2;
    return true;
  }
  
  boolean addIndexedField(ReadablePeriod paramReadablePeriod, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramInt2 == 0) {
      return false;
    }
    int i = iIndices[paramInt1];
    if (i == -1) {
      throw new UnsupportedOperationException("Field is not supported");
    }
    paramArrayOfInt[i] = FieldUtils.safeAdd(paramArrayOfInt[i], paramInt2);
    return true;
  }
  
  public PeriodType withYearsRemoved()
  {
    return withFieldRemoved(0, "NoYears");
  }
  
  public PeriodType withMonthsRemoved()
  {
    return withFieldRemoved(1, "NoMonths");
  }
  
  public PeriodType withWeeksRemoved()
  {
    return withFieldRemoved(2, "NoWeeks");
  }
  
  public PeriodType withDaysRemoved()
  {
    return withFieldRemoved(3, "NoDays");
  }
  
  public PeriodType withHoursRemoved()
  {
    return withFieldRemoved(4, "NoHours");
  }
  
  public PeriodType withMinutesRemoved()
  {
    return withFieldRemoved(5, "NoMinutes");
  }
  
  public PeriodType withSecondsRemoved()
  {
    return withFieldRemoved(6, "NoSeconds");
  }
  
  public PeriodType withMillisRemoved()
  {
    return withFieldRemoved(7, "NoMillis");
  }
  
  private PeriodType withFieldRemoved(int paramInt, String paramString)
  {
    int i = iIndices[paramInt];
    if (i == -1) {
      return this;
    }
    DurationFieldType[] arrayOfDurationFieldType = new DurationFieldType[size() - 1];
    for (int j = 0; j < iTypes.length; j++) {
      if (j < i) {
        arrayOfDurationFieldType[j] = iTypes[j];
      } else if (j > i) {
        arrayOfDurationFieldType[(j - 1)] = iTypes[j];
      }
    }
    int[] arrayOfInt = new int[8];
    for (int k = 0; k < arrayOfInt.length; k++) {
      if (k < paramInt) {
        arrayOfInt[k] = iIndices[k];
      } else if (k > paramInt) {
        arrayOfInt[k] = (iIndices[k] == -1 ? -1 : iIndices[k] - 1);
      } else {
        arrayOfInt[k] = -1;
      }
    }
    return new PeriodType(getName() + paramString, arrayOfDurationFieldType, arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof PeriodType)) {
      return false;
    }
    PeriodType localPeriodType = (PeriodType)paramObject;
    return Arrays.equals(iTypes, iTypes);
  }
  
  public int hashCode()
  {
    int i = 0;
    for (int j = 0; j < iTypes.length; j++) {
      i += iTypes[j].hashCode();
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.PeriodType
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */