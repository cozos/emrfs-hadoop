package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractPartialFieldProperty;
import java.io.Serializable;
import java.util.Locale;

public class YearMonth$Property
  extends AbstractPartialFieldProperty
  implements Serializable
{
  private static final long serialVersionUID = 5727734012190224363L;
  private final YearMonth iBase;
  private final int iFieldIndex;
  
  YearMonth$Property(YearMonth paramYearMonth, int paramInt)
  {
    iBase = paramYearMonth;
    iFieldIndex = paramInt;
  }
  
  public DateTimeField getField()
  {
    return iBase.getField(iFieldIndex);
  }
  
  protected ReadablePartial getReadablePartial()
  {
    return iBase;
  }
  
  public YearMonth getYearMonth()
  {
    return iBase;
  }
  
  public int get()
  {
    return iBase.getValue(iFieldIndex);
  }
  
  public YearMonth addToCopy(int paramInt)
  {
    int[] arrayOfInt = iBase.getValues();
    arrayOfInt = getField().add(iBase, iFieldIndex, arrayOfInt, paramInt);
    return new YearMonth(iBase, arrayOfInt);
  }
  
  public YearMonth addWrapFieldToCopy(int paramInt)
  {
    int[] arrayOfInt = iBase.getValues();
    arrayOfInt = getField().addWrapField(iBase, iFieldIndex, arrayOfInt, paramInt);
    return new YearMonth(iBase, arrayOfInt);
  }
  
  public YearMonth setCopy(int paramInt)
  {
    int[] arrayOfInt = iBase.getValues();
    arrayOfInt = getField().set(iBase, iFieldIndex, arrayOfInt, paramInt);
    return new YearMonth(iBase, arrayOfInt);
  }
  
  public YearMonth setCopy(String paramString, Locale paramLocale)
  {
    int[] arrayOfInt = iBase.getValues();
    arrayOfInt = getField().set(iBase, iFieldIndex, arrayOfInt, paramString, paramLocale);
    return new YearMonth(iBase, arrayOfInt);
  }
  
  public YearMonth setCopy(String paramString)
  {
    return setCopy(paramString, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.YearMonth.Property
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */