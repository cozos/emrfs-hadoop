package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.IllegalFieldValueException;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class GJLocaleSymbols
{
  private static ConcurrentMap<Locale, GJLocaleSymbols> cCache = new ConcurrentHashMap();
  private final String[] iEras;
  private final String[] iDaysOfWeek;
  private final String[] iShortDaysOfWeek;
  private final String[] iMonths;
  private final String[] iShortMonths;
  private final String[] iHalfday;
  private final TreeMap<String, Integer> iParseEras;
  private final TreeMap<String, Integer> iParseDaysOfWeek;
  private final TreeMap<String, Integer> iParseMonths;
  private final int iMaxEraLength;
  private final int iMaxDayOfWeekLength;
  private final int iMaxShortDayOfWeekLength;
  private final int iMaxMonthLength;
  private final int iMaxShortMonthLength;
  private final int iMaxHalfdayLength;
  
  static GJLocaleSymbols forLocale(Locale paramLocale)
  {
    if (paramLocale == null) {
      paramLocale = Locale.getDefault();
    }
    Object localObject = (GJLocaleSymbols)cCache.get(paramLocale);
    if (localObject == null)
    {
      localObject = new GJLocaleSymbols(paramLocale);
      GJLocaleSymbols localGJLocaleSymbols = (GJLocaleSymbols)cCache.putIfAbsent(paramLocale, localObject);
      if (localGJLocaleSymbols != null) {
        localObject = localGJLocaleSymbols;
      }
    }
    return (GJLocaleSymbols)localObject;
  }
  
  private static String[] realignMonths(String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[13];
    for (int i = 1; i < 13; i++) {
      arrayOfString[i] = paramArrayOfString[(i - 1)];
    }
    return arrayOfString;
  }
  
  private static String[] realignDaysOfWeek(String[] paramArrayOfString)
  {
    String[] arrayOfString = new String[8];
    for (int i = 1; i < 8; i++) {
      arrayOfString[i] = paramArrayOfString[1];
    }
    return arrayOfString;
  }
  
  private static void addSymbols(TreeMap<String, Integer> paramTreeMap, String[] paramArrayOfString, Integer[] paramArrayOfInteger)
  {
    int i = paramArrayOfString.length;
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      String str = paramArrayOfString[i];
      if (str != null) {
        paramTreeMap.put(str, paramArrayOfInteger[i]);
      }
    }
  }
  
  private static void addNumerals(TreeMap<String, Integer> paramTreeMap, int paramInt1, int paramInt2, Integer[] paramArrayOfInteger)
  {
    for (int i = paramInt1; i <= paramInt2; i++) {
      paramTreeMap.put(String.valueOf(i).intern(), paramArrayOfInteger[i]);
    }
  }
  
  private static int maxLength(String[] paramArrayOfString)
  {
    int i = 0;
    int j = paramArrayOfString.length;
    for (;;)
    {
      j--;
      if (j < 0) {
        break;
      }
      String str = paramArrayOfString[j];
      if (str != null)
      {
        int k = str.length();
        if (k > i) {
          i = k;
        }
      }
    }
    return i;
  }
  
  private GJLocaleSymbols(Locale paramLocale)
  {
    DateFormatSymbols localDateFormatSymbols = DateTimeUtils.getDateFormatSymbols(paramLocale);
    
    iEras = localDateFormatSymbols.getEras();
    iDaysOfWeek = realignDaysOfWeek(localDateFormatSymbols.getWeekdays());
    iShortDaysOfWeek = realignDaysOfWeek(localDateFormatSymbols.getShortWeekdays());
    iMonths = realignMonths(localDateFormatSymbols.getMonths());
    iShortMonths = realignMonths(localDateFormatSymbols.getShortMonths());
    iHalfday = localDateFormatSymbols.getAmPmStrings();
    
    Integer[] arrayOfInteger = new Integer[13];
    for (int i = 0; i < 13; i++) {
      arrayOfInteger[i] = Integer.valueOf(i);
    }
    iParseEras = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    addSymbols(iParseEras, iEras, arrayOfInteger);
    if ("en".equals(paramLocale.getLanguage()))
    {
      iParseEras.put("BCE", arrayOfInteger[0]);
      iParseEras.put("CE", arrayOfInteger[1]);
    }
    iParseDaysOfWeek = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    addSymbols(iParseDaysOfWeek, iDaysOfWeek, arrayOfInteger);
    addSymbols(iParseDaysOfWeek, iShortDaysOfWeek, arrayOfInteger);
    addNumerals(iParseDaysOfWeek, 1, 7, arrayOfInteger);
    
    iParseMonths = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    addSymbols(iParseMonths, iMonths, arrayOfInteger);
    addSymbols(iParseMonths, iShortMonths, arrayOfInteger);
    addNumerals(iParseMonths, 1, 12, arrayOfInteger);
    
    iMaxEraLength = maxLength(iEras);
    iMaxDayOfWeekLength = maxLength(iDaysOfWeek);
    iMaxShortDayOfWeekLength = maxLength(iShortDaysOfWeek);
    iMaxMonthLength = maxLength(iMonths);
    iMaxShortMonthLength = maxLength(iShortMonths);
    iMaxHalfdayLength = maxLength(iHalfday);
  }
  
  public String eraValueToText(int paramInt)
  {
    return iEras[paramInt];
  }
  
  public int eraTextToValue(String paramString)
  {
    Integer localInteger = (Integer)iParseEras.get(paramString);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new IllegalFieldValueException(DateTimeFieldType.era(), paramString);
  }
  
  public int getEraMaxTextLength()
  {
    return iMaxEraLength;
  }
  
  public String monthOfYearValueToText(int paramInt)
  {
    return iMonths[paramInt];
  }
  
  public String monthOfYearValueToShortText(int paramInt)
  {
    return iShortMonths[paramInt];
  }
  
  public int monthOfYearTextToValue(String paramString)
  {
    Integer localInteger = (Integer)iParseMonths.get(paramString);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new IllegalFieldValueException(DateTimeFieldType.monthOfYear(), paramString);
  }
  
  public int getMonthMaxTextLength()
  {
    return iMaxMonthLength;
  }
  
  public int getMonthMaxShortTextLength()
  {
    return iMaxShortMonthLength;
  }
  
  public String dayOfWeekValueToText(int paramInt)
  {
    return iDaysOfWeek[paramInt];
  }
  
  public String dayOfWeekValueToShortText(int paramInt)
  {
    return iShortDaysOfWeek[paramInt];
  }
  
  public int dayOfWeekTextToValue(String paramString)
  {
    Integer localInteger = (Integer)iParseDaysOfWeek.get(paramString);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new IllegalFieldValueException(DateTimeFieldType.dayOfWeek(), paramString);
  }
  
  public int getDayOfWeekMaxTextLength()
  {
    return iMaxDayOfWeekLength;
  }
  
  public int getDayOfWeekMaxShortTextLength()
  {
    return iMaxShortDayOfWeekLength;
  }
  
  public String halfdayValueToText(int paramInt)
  {
    return iHalfday[paramInt];
  }
  
  public int halfdayTextToValue(String paramString)
  {
    String[] arrayOfString = iHalfday;
    int i = arrayOfString.length;
    do
    {
      i--;
      if (i < 0) {
        break;
      }
    } while (!arrayOfString[i].equalsIgnoreCase(paramString));
    return i;
    
    throw new IllegalFieldValueException(DateTimeFieldType.halfdayOfDay(), paramString);
  }
  
  public int getHalfdayMaxTextLength()
  {
    return iMaxHalfdayLength;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.GJLocaleSymbols
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */