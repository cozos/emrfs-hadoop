package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;

public class LenientDateTimeField
  extends DelegatedDateTimeField
{
  private static final long serialVersionUID = 8714085824173290599L;
  private final Chronology iBase;
  
  public static DateTimeField getInstance(DateTimeField paramDateTimeField, Chronology paramChronology)
  {
    if (paramDateTimeField == null) {
      return null;
    }
    if ((paramDateTimeField instanceof StrictDateTimeField)) {
      paramDateTimeField = ((StrictDateTimeField)paramDateTimeField).getWrappedField();
    }
    if (paramDateTimeField.isLenient()) {
      return paramDateTimeField;
    }
    return new LenientDateTimeField(paramDateTimeField, paramChronology);
  }
  
  protected LenientDateTimeField(DateTimeField paramDateTimeField, Chronology paramChronology)
  {
    super(paramDateTimeField);
    iBase = paramChronology;
  }
  
  public final boolean isLenient()
  {
    return true;
  }
  
  public long set(long paramLong, int paramInt)
  {
    long l1 = iBase.getZone().convertUTCToLocal(paramLong);
    long l2 = FieldUtils.safeSubtract(paramInt, get(paramLong));
    l1 = getType().getField(iBase.withUTC()).add(l1, l2);
    return iBase.getZone().convertLocalToUTC(l1, false, paramLong);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.LenientDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */