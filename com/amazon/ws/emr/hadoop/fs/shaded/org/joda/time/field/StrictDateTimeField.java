package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;

public class StrictDateTimeField
  extends DelegatedDateTimeField
{
  private static final long serialVersionUID = 3154803964207950910L;
  
  public static DateTimeField getInstance(DateTimeField paramDateTimeField)
  {
    if (paramDateTimeField == null) {
      return null;
    }
    if ((paramDateTimeField instanceof LenientDateTimeField)) {
      paramDateTimeField = ((LenientDateTimeField)paramDateTimeField).getWrappedField();
    }
    if (!paramDateTimeField.isLenient()) {
      return paramDateTimeField;
    }
    return new StrictDateTimeField(paramDateTimeField);
  }
  
  protected StrictDateTimeField(DateTimeField paramDateTimeField)
  {
    super(paramDateTimeField);
  }
  
  public final boolean isLenient()
  {
    return false;
  }
  
  public long set(long paramLong, int paramInt)
  {
    FieldUtils.verifyValueBounds(this, paramInt, getMinimumValue(paramLong), getMaximumValue(paramLong));
    
    return super.set(paramLong, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.StrictDateTimeField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */