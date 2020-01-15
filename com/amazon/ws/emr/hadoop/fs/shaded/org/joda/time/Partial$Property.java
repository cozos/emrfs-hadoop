package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.AbstractPartialFieldProperty;
import java.io.Serializable;
import java.util.Locale;

public class Partial$Property
  extends AbstractPartialFieldProperty
  implements Serializable
{
  private static final long serialVersionUID = 53278362873888L;
  private final Partial iPartial;
  private final int iFieldIndex;
  
  Partial$Property(Partial paramPartial, int paramInt)
  {
    iPartial = paramPartial;
    iFieldIndex = paramInt;
  }
  
  public DateTimeField getField()
  {
    return iPartial.getField(iFieldIndex);
  }
  
  protected ReadablePartial getReadablePartial()
  {
    return iPartial;
  }
  
  public Partial getPartial()
  {
    return iPartial;
  }
  
  public int get()
  {
    return iPartial.getValue(iFieldIndex);
  }
  
  public Partial addToCopy(int paramInt)
  {
    int[] arrayOfInt = iPartial.getValues();
    arrayOfInt = getField().add(iPartial, iFieldIndex, arrayOfInt, paramInt);
    return new Partial(iPartial, arrayOfInt);
  }
  
  public Partial addWrapFieldToCopy(int paramInt)
  {
    int[] arrayOfInt = iPartial.getValues();
    arrayOfInt = getField().addWrapField(iPartial, iFieldIndex, arrayOfInt, paramInt);
    return new Partial(iPartial, arrayOfInt);
  }
  
  public Partial setCopy(int paramInt)
  {
    int[] arrayOfInt = iPartial.getValues();
    arrayOfInt = getField().set(iPartial, iFieldIndex, arrayOfInt, paramInt);
    return new Partial(iPartial, arrayOfInt);
  }
  
  public Partial setCopy(String paramString, Locale paramLocale)
  {
    int[] arrayOfInt = iPartial.getValues();
    arrayOfInt = getField().set(iPartial, iFieldIndex, arrayOfInt, paramString, paramLocale);
    return new Partial(iPartial, arrayOfInt);
  }
  
  public Partial setCopy(String paramString)
  {
    return setCopy(paramString, null);
  }
  
  public Partial withMaximumValue()
  {
    return setCopy(getMaximumValue());
  }
  
  public Partial withMinimumValue()
  {
    return setCopy(getMinimumValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Partial.Property
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */