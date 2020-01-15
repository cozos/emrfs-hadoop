package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.IllegalFieldValueException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.BaseDateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.UnsupportedDurationField;
import java.util.Locale;

final class BasicSingleEraDateTimeField
  extends BaseDateTimeField
{
  private static final int ERA_VALUE = 1;
  private final String iEraText;
  
  BasicSingleEraDateTimeField(String paramString)
  {
    super(DateTimeFieldType.era());
    iEraText = paramString;
  }
  
  public boolean isLenient()
  {
    return false;
  }
  
  public int get(long paramLong)
  {
    return 1;
  }
  
  public long set(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, paramInt, 1, 1);
    return paramLong;
  }
  
  public long set(long paramLong, String paramString, Locale paramLocale)
  {
    if ((!iEraText.equals(paramString)) && (!"1".equals(paramString))) {
      throw new IllegalFieldValueException(DateTimeFieldType.era(), paramString);
    }
    return paramLong;
  }
  
  public long roundFloor(long paramLong)
  {
    return Long.MIN_VALUE;
  }
  
  public long roundCeiling(long paramLong)
  {
    return Long.MAX_VALUE;
  }
  
  public long roundHalfFloor(long paramLong)
  {
    return Long.MIN_VALUE;
  }
  
  public long roundHalfCeiling(long paramLong)
  {
    return Long.MIN_VALUE;
  }
  
  public long roundHalfEven(long paramLong)
  {
    return Long.MIN_VALUE;
  }
  
  public DurationField getDurationField()
  {
    return UnsupportedDurationField.getInstance(DurationFieldType.eras());
  }
  
  public DurationField getRangeDurationField()
  {
    return null;
  }
  
  public int getMinimumValue()
  {
    return 1;
  }
  
  public int getMaximumValue()
  {
    return 1;
  }
  
  public String getAsText(int paramInt, Locale paramLocale)
  {
    return iEraText;
  }
  
  public int getMaximumTextLength(Locale paramLocale)
  {
    return iEraText.length();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BasicSingleEraDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */