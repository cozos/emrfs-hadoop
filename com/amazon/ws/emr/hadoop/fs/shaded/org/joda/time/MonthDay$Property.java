package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractPartialFieldProperty;
import java.io.Serializable;
import java.util.Locale;

public class MonthDay$Property
  extends AbstractPartialFieldProperty
  implements Serializable
{
  private static final long serialVersionUID = 5727734012190224363L;
  private final MonthDay iBase;
  private final int iFieldIndex;
  
  MonthDay$Property(MonthDay paramMonthDay, int paramInt)
  {
    iBase = paramMonthDay;
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
  
  public MonthDay getMonthDay()
  {
    return iBase;
  }
  
  public int get()
  {
    return iBase.getValue(iFieldIndex);
  }
  
  public MonthDay addToCopy(int paramInt)
  {
    int[] arrayOfInt = iBase.getValues();
    arrayOfInt = getField().add(iBase, iFieldIndex, arrayOfInt, paramInt);
    return new MonthDay(iBase, arrayOfInt);
  }
  
  public MonthDay addWrapFieldToCopy(int paramInt)
  {
    int[] arrayOfInt = iBase.getValues();
    arrayOfInt = getField().addWrapField(iBase, iFieldIndex, arrayOfInt, paramInt);
    return new MonthDay(iBase, arrayOfInt);
  }
  
  public MonthDay setCopy(int paramInt)
  {
    int[] arrayOfInt = iBase.getValues();
    arrayOfInt = getField().set(iBase, iFieldIndex, arrayOfInt, paramInt);
    return new MonthDay(iBase, arrayOfInt);
  }
  
  public MonthDay setCopy(String paramString, Locale paramLocale)
  {
    int[] arrayOfInt = iBase.getValues();
    arrayOfInt = getField().set(iBase, iFieldIndex, arrayOfInt, paramString, paramLocale);
    return new MonthDay(iBase, arrayOfInt);
  }
  
  public MonthDay setCopy(String paramString)
  {
    return setCopy(paramString, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MonthDay.Property
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */