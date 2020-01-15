package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ConverterManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.PartialConverter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormat;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import java.io.Serializable;
import java.util.Locale;

public abstract class BasePartial
  extends AbstractPartial
  implements ReadablePartial, Serializable
{
  private static final long serialVersionUID = 2353678632973660L;
  private final Chronology iChronology;
  private final int[] iValues;
  
  protected BasePartial()
  {
    this(DateTimeUtils.currentTimeMillis(), null);
  }
  
  protected BasePartial(Chronology paramChronology)
  {
    this(DateTimeUtils.currentTimeMillis(), paramChronology);
  }
  
  protected BasePartial(long paramLong)
  {
    this(paramLong, null);
  }
  
  protected BasePartial(long paramLong, Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    iChronology = paramChronology.withUTC();
    iValues = paramChronology.get(this, paramLong);
  }
  
  protected BasePartial(Object paramObject, Chronology paramChronology)
  {
    PartialConverter localPartialConverter = ConverterManager.getInstance().getPartialConverter(paramObject);
    paramChronology = localPartialConverter.getChronology(paramObject, paramChronology);
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    iChronology = paramChronology.withUTC();
    iValues = localPartialConverter.getPartialValues(this, paramObject, paramChronology);
  }
  
  protected BasePartial(Object paramObject, Chronology paramChronology, DateTimeFormatter paramDateTimeFormatter)
  {
    PartialConverter localPartialConverter = ConverterManager.getInstance().getPartialConverter(paramObject);
    paramChronology = localPartialConverter.getChronology(paramObject, paramChronology);
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    iChronology = paramChronology.withUTC();
    iValues = localPartialConverter.getPartialValues(this, paramObject, paramChronology, paramDateTimeFormatter);
  }
  
  protected BasePartial(int[] paramArrayOfInt, Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    iChronology = paramChronology.withUTC();
    paramChronology.validate(this, paramArrayOfInt);
    iValues = paramArrayOfInt;
  }
  
  protected BasePartial(BasePartial paramBasePartial, int[] paramArrayOfInt)
  {
    iChronology = iChronology;
    iValues = paramArrayOfInt;
  }
  
  protected BasePartial(BasePartial paramBasePartial, Chronology paramChronology)
  {
    iChronology = paramChronology.withUTC();
    iValues = iValues;
  }
  
  public int getValue(int paramInt)
  {
    return iValues[paramInt];
  }
  
  public int[] getValues()
  {
    return (int[])iValues.clone();
  }
  
  public Chronology getChronology()
  {
    return iChronology;
  }
  
  protected void setValue(int paramInt1, int paramInt2)
  {
    DateTimeField localDateTimeField = getField(paramInt1);
    int[] arrayOfInt = localDateTimeField.set(this, paramInt1, iValues, paramInt2);
    System.arraycopy(arrayOfInt, 0, iValues, 0, iValues.length);
  }
  
  protected void setValues(int[] paramArrayOfInt)
  {
    getChronology().validate(this, paramArrayOfInt);
    System.arraycopy(paramArrayOfInt, 0, iValues, 0, iValues.length);
  }
  
  public String toString(String paramString)
  {
    if (paramString == null) {
      return toString();
    }
    return DateTimeFormat.forPattern(paramString).print(this);
  }
  
  public String toString(String paramString, Locale paramLocale)
    throws IllegalArgumentException
  {
    if (paramString == null) {
      return toString();
    }
    return DateTimeFormat.forPattern(paramString).withLocale(paramLocale).print(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BasePartial
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */