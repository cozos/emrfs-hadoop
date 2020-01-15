package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ConverterManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.InstantConverter;
import java.io.Serializable;
import java.util.Comparator;

public class DateTimeComparator
  implements Comparator<Object>, Serializable
{
  private static final long serialVersionUID = -6097339773320178364L;
  private static final DateTimeComparator ALL_INSTANCE = new DateTimeComparator(null, null);
  private static final DateTimeComparator DATE_INSTANCE = new DateTimeComparator(DateTimeFieldType.dayOfYear(), null);
  private static final DateTimeComparator TIME_INSTANCE = new DateTimeComparator(null, DateTimeFieldType.dayOfYear());
  private final DateTimeFieldType iLowerLimit;
  private final DateTimeFieldType iUpperLimit;
  
  public static DateTimeComparator getInstance()
  {
    return ALL_INSTANCE;
  }
  
  public static DateTimeComparator getInstance(DateTimeFieldType paramDateTimeFieldType)
  {
    return getInstance(paramDateTimeFieldType, null);
  }
  
  public static DateTimeComparator getInstance(DateTimeFieldType paramDateTimeFieldType1, DateTimeFieldType paramDateTimeFieldType2)
  {
    if ((paramDateTimeFieldType1 == null) && (paramDateTimeFieldType2 == null)) {
      return ALL_INSTANCE;
    }
    if ((paramDateTimeFieldType1 == DateTimeFieldType.dayOfYear()) && (paramDateTimeFieldType2 == null)) {
      return DATE_INSTANCE;
    }
    if ((paramDateTimeFieldType1 == null) && (paramDateTimeFieldType2 == DateTimeFieldType.dayOfYear())) {
      return TIME_INSTANCE;
    }
    return new DateTimeComparator(paramDateTimeFieldType1, paramDateTimeFieldType2);
  }
  
  public static DateTimeComparator getDateOnlyInstance()
  {
    return DATE_INSTANCE;
  }
  
  public static DateTimeComparator getTimeOnlyInstance()
  {
    return TIME_INSTANCE;
  }
  
  protected DateTimeComparator(DateTimeFieldType paramDateTimeFieldType1, DateTimeFieldType paramDateTimeFieldType2)
  {
    iLowerLimit = paramDateTimeFieldType1;
    iUpperLimit = paramDateTimeFieldType2;
  }
  
  public DateTimeFieldType getLowerLimit()
  {
    return iLowerLimit;
  }
  
  public DateTimeFieldType getUpperLimit()
  {
    return iUpperLimit;
  }
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    InstantConverter localInstantConverter = ConverterManager.getInstance().getInstantConverter(paramObject1);
    Chronology localChronology1 = localInstantConverter.getChronology(paramObject1, (Chronology)null);
    long l1 = localInstantConverter.getInstantMillis(paramObject1, localChronology1);
    
    localInstantConverter = ConverterManager.getInstance().getInstantConverter(paramObject2);
    Chronology localChronology2 = localInstantConverter.getChronology(paramObject2, (Chronology)null);
    long l2 = localInstantConverter.getInstantMillis(paramObject2, localChronology2);
    if (iLowerLimit != null)
    {
      l1 = iLowerLimit.getField(localChronology1).roundFloor(l1);
      l2 = iLowerLimit.getField(localChronology2).roundFloor(l2);
    }
    if (iUpperLimit != null)
    {
      l1 = iUpperLimit.getField(localChronology1).remainder(l1);
      l2 = iUpperLimit.getField(localChronology2).remainder(l2);
    }
    if (l1 < l2) {
      return -1;
    }
    if (l1 > l2) {
      return 1;
    }
    return 0;
  }
  
  private Object readResolve()
  {
    return getInstance(iLowerLimit, iUpperLimit);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof DateTimeComparator))
    {
      DateTimeComparator localDateTimeComparator = (DateTimeComparator)paramObject;
      return ((iLowerLimit == localDateTimeComparator.getLowerLimit()) || ((iLowerLimit != null) && (iLowerLimit.equals(localDateTimeComparator.getLowerLimit())))) && ((iUpperLimit == localDateTimeComparator.getUpperLimit()) || ((iUpperLimit != null) && (iUpperLimit.equals(localDateTimeComparator.getUpperLimit()))));
    }
    return false;
  }
  
  public int hashCode()
  {
    return (iLowerLimit == null ? 0 : iLowerLimit.hashCode()) + 123 * (iUpperLimit == null ? 0 : iUpperLimit.hashCode());
  }
  
  public String toString()
  {
    if (iLowerLimit == iUpperLimit) {
      return "DateTimeComparator[" + (iLowerLimit == null ? "" : iLowerLimit.getName()) + "]";
    }
    return "DateTimeComparator[" + (iLowerLimit == null ? "" : iLowerLimit.getName()) + "-" + (iUpperLimit == null ? "" : iUpperLimit.getName()) + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeComparator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */