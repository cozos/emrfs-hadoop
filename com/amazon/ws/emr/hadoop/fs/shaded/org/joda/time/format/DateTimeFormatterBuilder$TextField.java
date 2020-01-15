package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutableDateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutableDateTime.Property;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class DateTimeFormatterBuilder$TextField
  implements InternalPrinter, InternalParser
{
  private static Map<Locale, Map<DateTimeFieldType, Object[]>> cParseCache = new ConcurrentHashMap();
  private final DateTimeFieldType iFieldType;
  private final boolean iShort;
  
  DateTimeFormatterBuilder$TextField(DateTimeFieldType paramDateTimeFieldType, boolean paramBoolean)
  {
    iFieldType = paramDateTimeFieldType;
    iShort = paramBoolean;
  }
  
  public int estimatePrintedLength()
  {
    return iShort ? 6 : 20;
  }
  
  public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
    throws IOException
  {
    try
    {
      paramAppendable.append(print(paramLong, paramChronology, paramLocale));
    }
    catch (RuntimeException localRuntimeException)
    {
      paramAppendable.append(65533);
    }
  }
  
  public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
    throws IOException
  {
    try
    {
      paramAppendable.append(print(paramReadablePartial, paramLocale));
    }
    catch (RuntimeException localRuntimeException)
    {
      paramAppendable.append(65533);
    }
  }
  
  private String print(long paramLong, Chronology paramChronology, Locale paramLocale)
  {
    DateTimeField localDateTimeField = iFieldType.getField(paramChronology);
    if (iShort) {
      return localDateTimeField.getAsShortText(paramLong, paramLocale);
    }
    return localDateTimeField.getAsText(paramLong, paramLocale);
  }
  
  private String print(ReadablePartial paramReadablePartial, Locale paramLocale)
  {
    if (paramReadablePartial.isSupported(iFieldType))
    {
      DateTimeField localDateTimeField = iFieldType.getField(paramReadablePartial.getChronology());
      if (iShort) {
        return localDateTimeField.getAsShortText(paramReadablePartial, paramLocale);
      }
      return localDateTimeField.getAsText(paramReadablePartial, paramLocale);
    }
    return "�";
  }
  
  public int estimateParsedLength()
  {
    return estimatePrintedLength();
  }
  
  public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
  {
    Locale localLocale = paramDateTimeParserBucket.getLocale();
    
    Object localObject1 = null;
    int i = 0;
    Object localObject2 = (Map)cParseCache.get(localLocale);
    if (localObject2 == null)
    {
      localObject2 = new ConcurrentHashMap();
      cParseCache.put(localLocale, localObject2);
    }
    Object[] arrayOfObject = (Object[])((Map)localObject2).get(iFieldType);
    if (arrayOfObject == null)
    {
      localObject1 = new ConcurrentHashMap(32);
      MutableDateTime localMutableDateTime = new MutableDateTime(0L, DateTimeZone.UTC);
      localProperty2 = localMutableDateTime.property(iFieldType);
      int j = localProperty2.getMinimumValueOverall();
      int k = localProperty2.getMaximumValueOverall();
      if (k - j > 32) {
        return paramInt ^ 0xFFFFFFFF;
      }
      i = localProperty2.getMaximumTextLength(localLocale);
      for (int m = j; m <= k; m++)
      {
        localProperty2.set(m);
        ((Map)localObject1).put(localProperty2.getAsShortText(localLocale), Boolean.TRUE);
        ((Map)localObject1).put(localProperty2.getAsShortText(localLocale).toLowerCase(localLocale), Boolean.TRUE);
        ((Map)localObject1).put(localProperty2.getAsShortText(localLocale).toUpperCase(localLocale), Boolean.TRUE);
        ((Map)localObject1).put(localProperty2.getAsText(localLocale), Boolean.TRUE);
        ((Map)localObject1).put(localProperty2.getAsText(localLocale).toLowerCase(localLocale), Boolean.TRUE);
        ((Map)localObject1).put(localProperty2.getAsText(localLocale).toUpperCase(localLocale), Boolean.TRUE);
      }
      if (("en".equals(localLocale.getLanguage())) && (iFieldType == DateTimeFieldType.era()))
      {
        ((Map)localObject1).put("BCE", Boolean.TRUE);
        ((Map)localObject1).put("bce", Boolean.TRUE);
        ((Map)localObject1).put("CE", Boolean.TRUE);
        ((Map)localObject1).put("ce", Boolean.TRUE);
        i = 3;
      }
      arrayOfObject = new Object[] { localObject1, Integer.valueOf(i) };
      ((Map)localObject2).put(iFieldType, arrayOfObject);
    }
    else
    {
      localObject1 = (Map)arrayOfObject[0];
      i = ((Integer)arrayOfObject[1]).intValue();
    }
    MutableDateTime.Property localProperty1 = Math.min(paramCharSequence.length(), paramInt + i);
    for (MutableDateTime.Property localProperty2 = localProperty1; localProperty2 > paramInt; localProperty2--)
    {
      String str = paramCharSequence.subSequence(paramInt, localProperty2).toString();
      if (((Map)localObject1).containsKey(str))
      {
        paramDateTimeParserBucket.saveField(iFieldType, str, localLocale);
        return localProperty2;
      }
    }
    return paramInt ^ 0xFFFFFFFF;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder.TextField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */