package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono;

import java.io.Serializable;

public class IslamicChronology$LeapYearPatternType
  implements Serializable
{
  private static final long serialVersionUID = 26581275372698L;
  final byte index;
  final int pattern;
  
  IslamicChronology$LeapYearPatternType(int paramInt1, int paramInt2)
  {
    index = ((byte)paramInt1);
    pattern = paramInt2;
  }
  
  boolean isLeapYear(int paramInt)
  {
    int i = 1 << paramInt % 30;
    return (pattern & i) > 0;
  }
  
  private Object readResolve()
  {
    switch (index)
    {
    case 0: 
      return IslamicChronology.LEAP_YEAR_15_BASED;
    case 1: 
      return IslamicChronology.LEAP_YEAR_16_BASED;
    case 2: 
      return IslamicChronology.LEAP_YEAR_INDIAN;
    case 3: 
      return IslamicChronology.LEAP_YEAR_HABASH_AL_HASIB;
    }
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof LeapYearPatternType)) {
      return index == index;
    }
    return false;
  }
  
  public int hashCode()
  {
    return index;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.IslamicChronology.LeapYearPatternType
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */