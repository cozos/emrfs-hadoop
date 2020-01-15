package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractPartialFieldProperty;
import java.io.Serializable;
import java.util.Locale;

@Deprecated
public class YearMonthDay$Property
  extends AbstractPartialFieldProperty
  implements Serializable
{
  private static final long serialVersionUID = 5727734012190224363L;
  private final YearMonthDay iYearMonthDay;
  private final int iFieldIndex;
  
  YearMonthDay$Property(YearMonthDay paramYearMonthDay, int paramInt)
  {
    iYearMonthDay = paramYearMonthDay;
    iFieldIndex = paramInt;
  }
  
  public DateTimeField getField()
  {
    return iYearMonthDay.getField(iFieldIndex);
  }
  
  protected ReadablePartial getReadablePartial()
  {
    return iYearMonthDay;
  }
  
  public YearMonthDay getYearMonthDay()
  {
    return iYearMonthDay;
  }
  
  public int get()
  {
    return iYearMonthDay.getValue(iFieldIndex);
  }
  
  public YearMonthDay addToCopy(int paramInt)
  {
    int[] arrayOfInt = iYearMonthDay.getValues();
    arrayOfInt = getField().add(iYearMonthDay, iFieldIndex, arrayOfInt, paramInt);
    return new YearMonthDay(iYearMonthDay, arrayOfInt);
  }
  
  public YearMonthDay addWrapFieldToCopy(int paramInt)
  {
    int[] arrayOfInt = iYearMonthDay.getValues();
    arrayOfInt = getField().addWrapField(iYearMonthDay, iFieldIndex, arrayOfInt, paramInt);
    return new YearMonthDay(iYearMonthDay, arrayOfInt);
  }
  
  public YearMonthDay setCopy(int paramInt)
  {
    int[] arrayOfInt = iYearMonthDay.getValues();
    arrayOfInt = getField().set(iYearMonthDay, iFieldIndex, arrayOfInt, paramInt);
    return new YearMonthDay(iYearMonthDay, arrayOfInt);
  }
  
  public YearMonthDay setCopy(String paramString, Locale paramLocale)
  {
    int[] arrayOfInt = iYearMonthDay.getValues();
    arrayOfInt = getField().set(iYearMonthDay, iFieldIndex, arrayOfInt, paramString, paramLocale);
    return new YearMonthDay(iYearMonthDay, arrayOfInt);
  }
  
  public YearMonthDay setCopy(String paramString)
  {
    return setCopy(paramString, null);
  }
  
  public YearMonthDay withMaximumValue()
  {
    return setCopy(getMaximumValue());
  }
  
  public YearMonthDay withMinimumValue()
  {
    return setCopy(getMinimumValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.YearMonthDay.Property
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */