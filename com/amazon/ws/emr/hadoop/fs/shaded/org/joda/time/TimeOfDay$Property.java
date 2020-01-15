package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractPartialFieldProperty;
import java.io.Serializable;
import java.util.Locale;

@Deprecated
public class TimeOfDay$Property
  extends AbstractPartialFieldProperty
  implements Serializable
{
  private static final long serialVersionUID = 5598459141741063833L;
  private final TimeOfDay iTimeOfDay;
  private final int iFieldIndex;
  
  TimeOfDay$Property(TimeOfDay paramTimeOfDay, int paramInt)
  {
    iTimeOfDay = paramTimeOfDay;
    iFieldIndex = paramInt;
  }
  
  public DateTimeField getField()
  {
    return iTimeOfDay.getField(iFieldIndex);
  }
  
  protected ReadablePartial getReadablePartial()
  {
    return iTimeOfDay;
  }
  
  public TimeOfDay getTimeOfDay()
  {
    return iTimeOfDay;
  }
  
  public int get()
  {
    return iTimeOfDay.getValue(iFieldIndex);
  }
  
  public TimeOfDay addToCopy(int paramInt)
  {
    int[] arrayOfInt = iTimeOfDay.getValues();
    arrayOfInt = getField().addWrapPartial(iTimeOfDay, iFieldIndex, arrayOfInt, paramInt);
    return new TimeOfDay(iTimeOfDay, arrayOfInt);
  }
  
  public TimeOfDay addNoWrapToCopy(int paramInt)
  {
    int[] arrayOfInt = iTimeOfDay.getValues();
    arrayOfInt = getField().add(iTimeOfDay, iFieldIndex, arrayOfInt, paramInt);
    return new TimeOfDay(iTimeOfDay, arrayOfInt);
  }
  
  public TimeOfDay addWrapFieldToCopy(int paramInt)
  {
    int[] arrayOfInt = iTimeOfDay.getValues();
    arrayOfInt = getField().addWrapField(iTimeOfDay, iFieldIndex, arrayOfInt, paramInt);
    return new TimeOfDay(iTimeOfDay, arrayOfInt);
  }
  
  public TimeOfDay setCopy(int paramInt)
  {
    int[] arrayOfInt = iTimeOfDay.getValues();
    arrayOfInt = getField().set(iTimeOfDay, iFieldIndex, arrayOfInt, paramInt);
    return new TimeOfDay(iTimeOfDay, arrayOfInt);
  }
  
  public TimeOfDay setCopy(String paramString, Locale paramLocale)
  {
    int[] arrayOfInt = iTimeOfDay.getValues();
    arrayOfInt = getField().set(iTimeOfDay, iFieldIndex, arrayOfInt, paramString, paramLocale);
    return new TimeOfDay(iTimeOfDay, arrayOfInt);
  }
  
  public TimeOfDay setCopy(String paramString)
  {
    return setCopy(paramString, null);
  }
  
  public TimeOfDay withMaximumValue()
  {
    return setCopy(getMaximumValue());
  }
  
  public TimeOfDay withMinimumValue()
  {
    return setCopy(getMinimumValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.TimeOfDay.Property
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */