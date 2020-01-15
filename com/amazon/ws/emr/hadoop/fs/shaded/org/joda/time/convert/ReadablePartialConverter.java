package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;

class ReadablePartialConverter
  extends AbstractConverter
  implements PartialConverter
{
  static final ReadablePartialConverter INSTANCE = new ReadablePartialConverter();
  
  public Chronology getChronology(Object paramObject, DateTimeZone paramDateTimeZone)
  {
    return getChronology(paramObject, (Chronology)null).withZone(paramDateTimeZone);
  }
  
  public Chronology getChronology(Object paramObject, Chronology paramChronology)
  {
    if (paramChronology == null)
    {
      paramChronology = ((ReadablePartial)paramObject).getChronology();
      paramChronology = DateTimeUtils.getChronology(paramChronology);
    }
    return paramChronology;
  }
  
  public int[] getPartialValues(ReadablePartial paramReadablePartial, Object paramObject, Chronology paramChronology)
  {
    ReadablePartial localReadablePartial = (ReadablePartial)paramObject;
    int i = paramReadablePartial.size();
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++) {
      arrayOfInt[j] = localReadablePartial.get(paramReadablePartial.getFieldType(j));
    }
    paramChronology.validate(paramReadablePartial, arrayOfInt);
    return arrayOfInt;
  }
  
  public Class<?> getSupportedType()
  {
    return ReadablePartial.class;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ReadablePartialConverter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */