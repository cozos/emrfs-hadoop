package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.IllegalFieldValueException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.IllegalInstantException;
import java.util.Arrays;
import java.util.Locale;

public class DateTimeParserBucket
{
  private final Chronology iChrono;
  private final long iMillis;
  private final Locale iLocale;
  private final int iDefaultYear;
  private final DateTimeZone iDefaultZone;
  private final Integer iDefaultPivotYear;
  private DateTimeZone iZone;
  private Integer iOffset;
  private Integer iPivotYear;
  private SavedField[] iSavedFields;
  private int iSavedFieldsCount;
  private boolean iSavedFieldsShared;
  private Object iSavedState;
  
  @Deprecated
  public DateTimeParserBucket(long paramLong, Chronology paramChronology, Locale paramLocale)
  {
    this(paramLong, paramChronology, paramLocale, null, 2000);
  }
  
  @Deprecated
  public DateTimeParserBucket(long paramLong, Chronology paramChronology, Locale paramLocale, Integer paramInteger)
  {
    this(paramLong, paramChronology, paramLocale, paramInteger, 2000);
  }
  
  public DateTimeParserBucket(long paramLong, Chronology paramChronology, Locale paramLocale, Integer paramInteger, int paramInt)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    iMillis = paramLong;
    iDefaultZone = paramChronology.getZone();
    iChrono = paramChronology.withUTC();
    iLocale = (paramLocale == null ? Locale.getDefault() : paramLocale);
    iDefaultYear = paramInt;
    iDefaultPivotYear = paramInteger;
    
    iZone = iDefaultZone;
    iPivotYear = iDefaultPivotYear;
    iSavedFields = new SavedField[8];
  }
  
  public void reset()
  {
    iZone = iDefaultZone;
    iOffset = null;
    iPivotYear = iDefaultPivotYear;
    iSavedFieldsCount = 0;
    iSavedFieldsShared = false;
    iSavedState = null;
  }
  
  public long parseMillis(DateTimeParser paramDateTimeParser, CharSequence paramCharSequence)
  {
    reset();
    return doParseMillis(DateTimeParserInternalParser.of(paramDateTimeParser), paramCharSequence);
  }
  
  long doParseMillis(InternalParser paramInternalParser, CharSequence paramCharSequence)
  {
    int i = paramInternalParser.parseInto(this, paramCharSequence, 0);
    if (i >= 0)
    {
      if (i >= paramCharSequence.length()) {
        return computeMillis(true, paramCharSequence);
      }
    }
    else {
      i ^= 0xFFFFFFFF;
    }
    throw new IllegalArgumentException(FormatUtils.createErrorMessage(paramCharSequence.toString(), i));
  }
  
  public Chronology getChronology()
  {
    return iChrono;
  }
  
  public Locale getLocale()
  {
    return iLocale;
  }
  
  public DateTimeZone getZone()
  {
    return iZone;
  }
  
  public void setZone(DateTimeZone paramDateTimeZone)
  {
    iSavedState = null;
    iZone = paramDateTimeZone;
  }
  
  @Deprecated
  public int getOffset()
  {
    return iOffset != null ? iOffset.intValue() : 0;
  }
  
  public Integer getOffsetInteger()
  {
    return iOffset;
  }
  
  @Deprecated
  public void setOffset(int paramInt)
  {
    iSavedState = null;
    iOffset = Integer.valueOf(paramInt);
  }
  
  public void setOffset(Integer paramInteger)
  {
    iSavedState = null;
    iOffset = paramInteger;
  }
  
  public Integer getPivotYear()
  {
    return iPivotYear;
  }
  
  @Deprecated
  public void setPivotYear(Integer paramInteger)
  {
    iPivotYear = paramInteger;
  }
  
  public void saveField(DateTimeField paramDateTimeField, int paramInt)
  {
    obtainSaveField().init(paramDateTimeField, paramInt);
  }
  
  public void saveField(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    obtainSaveField().init(paramDateTimeFieldType.getField(iChrono), paramInt);
  }
  
  public void saveField(DateTimeFieldType paramDateTimeFieldType, String paramString, Locale paramLocale)
  {
    obtainSaveField().init(paramDateTimeFieldType.getField(iChrono), paramString, paramLocale);
  }
  
  private SavedField obtainSaveField()
  {
    Object localObject1 = iSavedFields;
    int i = iSavedFieldsCount;
    if ((i == localObject1.length) || (iSavedFieldsShared))
    {
      localObject2 = new SavedField[i == localObject1.length ? i * 2 : localObject1.length];
      
      System.arraycopy(localObject1, 0, localObject2, 0, i);
      iSavedFields = (localObject1 = localObject2);
      iSavedFieldsShared = false;
    }
    iSavedState = null;
    Object localObject2 = localObject1[i];
    if (localObject2 == null) {
      localObject2 = localObject1[i] = new SavedField();
    }
    iSavedFieldsCount = (i + 1);
    return (SavedField)localObject2;
  }
  
  public Object saveState()
  {
    if (iSavedState == null) {
      iSavedState = new SavedState();
    }
    return iSavedState;
  }
  
  public boolean restoreState(Object paramObject)
  {
    if (((paramObject instanceof SavedState)) && 
      (((SavedState)paramObject).restoreState(this)))
    {
      iSavedState = paramObject;
      return true;
    }
    return false;
  }
  
  public long computeMillis()
  {
    return computeMillis(false, (CharSequence)null);
  }
  
  public long computeMillis(boolean paramBoolean)
  {
    return computeMillis(paramBoolean, (CharSequence)null);
  }
  
  public long computeMillis(boolean paramBoolean, String paramString)
  {
    return computeMillis(paramBoolean, paramString);
  }
  
  public long computeMillis(boolean paramBoolean, CharSequence paramCharSequence)
  {
    SavedField[] arrayOfSavedField = iSavedFields;
    int i = iSavedFieldsCount;
    if (iSavedFieldsShared)
    {
      iSavedFields = (arrayOfSavedField = (SavedField[])iSavedFields.clone());
      iSavedFieldsShared = false;
    }
    sort(arrayOfSavedField, i);
    if (i > 0)
    {
      DurationField localDurationField1 = DurationFieldType.months().getField(iChrono);
      DurationField localDurationField2 = DurationFieldType.days().getField(iChrono);
      DurationField localDurationField3 = 0iField.getDurationField();
      if ((compareReverse(localDurationField3, localDurationField1) >= 0) && (compareReverse(localDurationField3, localDurationField2) <= 0))
      {
        saveField(DateTimeFieldType.year(), iDefaultYear);
        return computeMillis(paramBoolean, paramCharSequence);
      }
    }
    long l = iMillis;
    try
    {
      for (int j = 0; j < i; j++) {
        l = arrayOfSavedField[j].set(l, paramBoolean);
      }
      if (paramBoolean) {
        for (j = 0; j < i; j++) {
          l = arrayOfSavedField[j].set(l, j == i - 1);
        }
      }
    }
    catch (IllegalFieldValueException localIllegalFieldValueException)
    {
      if (paramCharSequence != null) {
        localIllegalFieldValueException.prependMessage("Cannot parse \"" + paramCharSequence + '"');
      }
      throw localIllegalFieldValueException;
    }
    if (iOffset != null)
    {
      l -= iOffset.intValue();
    }
    else if (iZone != null)
    {
      int k = iZone.getOffsetFromLocal(l);
      l -= k;
      if (k != iZone.getOffset(l))
      {
        String str = "Illegal instant due to time zone offset transition (" + iZone + ')';
        if (paramCharSequence != null) {
          str = "Cannot parse \"" + paramCharSequence + "\": " + str;
        }
        throw new IllegalInstantException(str);
      }
    }
    return l;
  }
  
  private static void sort(SavedField[] paramArrayOfSavedField, int paramInt)
  {
    if (paramInt > 10) {
      Arrays.sort(paramArrayOfSavedField, 0, paramInt);
    } else {
      for (int i = 0; i < paramInt; i++) {
        for (int j = i; (j > 0) && (paramArrayOfSavedField[(j - 1)].compareTo(paramArrayOfSavedField[j]) > 0); j--)
        {
          SavedField localSavedField = paramArrayOfSavedField[j];
          paramArrayOfSavedField[j] = paramArrayOfSavedField[(j - 1)];
          paramArrayOfSavedField[(j - 1)] = localSavedField;
        }
      }
    }
  }
  
  class SavedState
  {
    final DateTimeZone iZone;
    final Integer iOffset;
    final DateTimeParserBucket.SavedField[] iSavedFields;
    final int iSavedFieldsCount;
    
    SavedState()
    {
      iZone = iZone;
      iOffset = iOffset;
      iSavedFields = iSavedFields;
      iSavedFieldsCount = iSavedFieldsCount;
    }
    
    boolean restoreState(DateTimeParserBucket paramDateTimeParserBucket)
    {
      if (paramDateTimeParserBucket != DateTimeParserBucket.this) {
        return false;
      }
      iZone = iZone;
      iOffset = iOffset;
      iSavedFields = iSavedFields;
      if (iSavedFieldsCount < iSavedFieldsCount) {
        iSavedFieldsShared = true;
      }
      iSavedFieldsCount = iSavedFieldsCount;
      return true;
    }
  }
  
  static class SavedField
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
  
  static int compareReverse(DurationField paramDurationField1, DurationField paramDurationField2)
  {
    if ((paramDurationField1 == null) || (!paramDurationField1.isSupported()))
    {
      if ((paramDurationField2 == null) || (!paramDurationField2.isSupported())) {
        return 0;
      }
      return -1;
    }
    if ((paramDurationField2 == null) || (!paramDurationField2.isSupported())) {
      return 1;
    }
    return -paramDurationField1.compareTo(paramDurationField2);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeParserBucket
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */