package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import java.util.Locale;

class DateTimeParserBucket$SavedField
  implements Comparable<SavedField>
{
  DateTimeField iField;
  int iValue;
  String iText;
  Locale iLocale;
  
  void init(DateTimeField paramDateTimeField, int paramInt)
  {
    iField = paramDateTimeField;
    iValue = paramInt;
    iText = null;
    iLocale = null;
  }
  
  void init(DateTimeField paramDateTimeField, String paramString, Locale paramLocale)
  {
    iField = paramDateTimeField;
    iValue = 0;
    iText = paramString;
    iLocale = paramLocale;
  }
  
  long set(long paramLong, boolean paramBoolean)
  {
    if (iText == null) {
      paramLong = iField.setExtended(paramLong, iValue);
    } else {
      paramLong = iField.set(paramLong, iText, iLocale);
    }
    if (paramBoolean) {
      paramLong = iField.roundFloor(paramLong);
    }
    return paramLong;
  }
  
  public int compareTo(SavedField paramSavedField)
  {
    DateTimeField localDateTimeField = iField;
    int i = DateTimeParserBucket.compareReverse(iField.getRangeDurationField(), localDateTimeField.getRangeDurationField());
    if (i != 0) {
      return i;
    }
    return DateTimeParserBucket.compareReverse(iField.getDurationField(), localDateTimeField.getDurationField());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeParserBucket.SavedField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */