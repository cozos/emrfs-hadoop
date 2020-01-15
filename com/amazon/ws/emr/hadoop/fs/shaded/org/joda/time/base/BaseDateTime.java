package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableDateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ConverterManager;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.InstantConverter;
import java.io.Serializable;

public abstract class BaseDateTime
  extends AbstractDateTime
  implements ReadableDateTime, Serializable
{
  private static final long serialVersionUID = -6728882245981L;
  private volatile long iMillis;
  private volatile Chronology iChronology;
  
  public BaseDateTime()
  {
    this(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance());
  }
  
  public BaseDateTime(DateTimeZone paramDateTimeZone)
  {
    this(DateTimeUtils.currentTimeMillis(), ISOChronology.getInstance(paramDateTimeZone));
  }
  
  public BaseDateTime(Chronology paramChronology)
  {
    this(DateTimeUtils.currentTimeMillis(), paramChronology);
  }
  
  public BaseDateTime(long paramLong)
  {
    this(paramLong, ISOChronology.getInstance());
  }
  
  public BaseDateTime(long paramLong, DateTimeZone paramDateTimeZone)
  {
    this(paramLong, ISOChronology.getInstance(paramDateTimeZone));
  }
  
  public BaseDateTime(long paramLong, Chronology paramChronology)
  {
    iChronology = checkChronology(paramChronology);
    iMillis = checkInstant(paramLong, iChronology);
    adjustForMinMax();
  }
  
  public BaseDateTime(Object paramObject, DateTimeZone paramDateTimeZone)
  {
    InstantConverter localInstantConverter = ConverterManager.getInstance().getInstantConverter(paramObject);
    Chronology localChronology = checkChronology(localInstantConverter.getChronology(paramObject, paramDateTimeZone));
    iChronology = localChronology;
    iMillis = checkInstant(localInstantConverter.getInstantMillis(paramObject, localChronology), localChronology);
    adjustForMinMax();
  }
  
  public BaseDateTime(Object paramObject, Chronology paramChronology)
  {
    InstantConverter localInstantConverter = ConverterManager.getInstance().getInstantConverter(paramObject);
    iChronology = checkChronology(localInstantConverter.getChronology(paramObject, paramChronology));
    iMillis = checkInstant(localInstantConverter.getInstantMillis(paramObject, paramChronology), iChronology);
    adjustForMinMax();
  }
  
  public BaseDateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, ISOChronology.getInstance());
  }
  
  public BaseDateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, DateTimeZone paramDateTimeZone)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, ISOChronology.getInstance(paramDateTimeZone));
  }
  
  public BaseDateTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Chronology paramChronology)
  {
    iChronology = checkChronology(paramChronology);
    long l = iChronology.getDateTimeMillis(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
    
    iMillis = checkInstant(l, iChronology);
    adjustForMinMax();
  }
  
  private void adjustForMinMax()
  {
    if ((iMillis == Long.MIN_VALUE) || (iMillis == Long.MAX_VALUE)) {
      iChronology = iChronology.withUTC();
    }
  }
  
  protected Chronology checkChronology(Chronology paramChronology)
  {
    return DateTimeUtils.getChronology(paramChronology);
  }
  
  protected long checkInstant(long paramLong, Chronology paramChronology)
  {
    return paramLong;
  }
  
  public long getMillis()
  {
    return iMillis;
  }
  
  public Chronology getChronology()
  {
    return iChronology;
  }
  
  protected void setMillis(long paramLong)
  {
    iMillis = checkInstant(paramLong, iChronology);
  }
  
  protected void setChronology(Chronology paramChronology)
  {
    iChronology = checkChronology(paramChronology);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.base.BaseDateTime
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */