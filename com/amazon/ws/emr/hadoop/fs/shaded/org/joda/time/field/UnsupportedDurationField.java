package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationFieldType;
import java.io.Serializable;
import java.util.HashMap;

public final class UnsupportedDurationField
  extends DurationField
  implements Serializable
{
  private static final long serialVersionUID = -6390301302770925357L;
  private static HashMap<DurationFieldType, UnsupportedDurationField> cCache;
  private final DurationFieldType iType;
  
  public static synchronized UnsupportedDurationField getInstance(DurationFieldType paramDurationFieldType)
  {
    UnsupportedDurationField localUnsupportedDurationField;
    if (cCache == null)
    {
      cCache = new HashMap(7);
      localUnsupportedDurationField = null;
    }
    else
    {
      localUnsupportedDurationField = (UnsupportedDurationField)cCache.get(paramDurationFieldType);
    }
    if (localUnsupportedDurationField == null)
    {
      localUnsupportedDurationField = new UnsupportedDurationField(paramDurationFieldType);
      cCache.put(paramDurationFieldType, localUnsupportedDurationField);
    }
    return localUnsupportedDurationField;
  }
  
  private UnsupportedDurationField(DurationFieldType paramDurationFieldType)
  {
    iType = paramDurationFieldType;
  }
  
  public final DurationFieldType getType()
  {
    return iType;
  }
  
  public String getName()
  {
    return iType.getName();
  }
  
  public boolean isSupported()
  {
    return false;
  }
  
  public boolean isPrecise()
  {
    return true;
  }
  
  public int getValue(long paramLong)
  {
    throw unsupported();
  }
  
  public long getValueAsLong(long paramLong)
  {
    throw unsupported();
  }
  
  public int getValue(long paramLong1, long paramLong2)
  {
    throw unsupported();
  }
  
  public long getValueAsLong(long paramLong1, long paramLong2)
  {
    throw unsupported();
  }
  
  public long getMillis(int paramInt)
  {
    throw unsupported();
  }
  
  public long getMillis(long paramLong)
  {
    throw unsupported();
  }
  
  public long getMillis(int paramInt, long paramLong)
  {
    throw unsupported();
  }
  
  public long getMillis(long paramLong1, long paramLong2)
  {
    throw unsupported();
  }
  
  public long add(long paramLong, int paramInt)
  {
    throw unsupported();
  }
  
  public long add(long paramLong1, long paramLong2)
  {
    throw unsupported();
  }
  
  public int getDifference(long paramLong1, long paramLong2)
  {
    throw unsupported();
  }
  
  public long getDifferenceAsLong(long paramLong1, long paramLong2)
  {
    throw unsupported();
  }
  
  public long getUnitMillis()
  {
    return 0L;
  }
  
  public int compareTo(DurationField paramDurationField)
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof UnsupportedDurationField))
    {
      UnsupportedDurationField localUnsupportedDurationField = (UnsupportedDurationField)paramObject;
      if (localUnsupportedDurationField.getName() == null) {
        return getName() == null;
      }
      return localUnsupportedDurationField.getName().equals(getName());
    }
    return false;
  }
  
  public int hashCode()
  {
    return getName().hashCode();
  }
  
  public String toString()
  {
    return "UnsupportedDurationField[" + getName() + ']';
  }
  
  private Object readResolve()
  {
    return getInstance(iType);
  }
  
  private UnsupportedOperationException unsupported()
  {
    return new UnsupportedOperationException(iType + " field is unsupported");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.UnsupportedDurationField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */