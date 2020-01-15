package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.JodaTimePermission;

public final class ConverterManager
{
  private static ConverterManager INSTANCE;
  private ConverterSet iInstantConverters;
  private ConverterSet iPartialConverters;
  private ConverterSet iDurationConverters;
  private ConverterSet iPeriodConverters;
  private ConverterSet iIntervalConverters;
  
  public static ConverterManager getInstance()
  {
    if (INSTANCE == null) {
      INSTANCE = new ConverterManager();
    }
    return INSTANCE;
  }
  
  protected ConverterManager()
  {
    iInstantConverters = new ConverterSet(new Converter[] { ReadableInstantConverter.INSTANCE, StringConverter.INSTANCE, CalendarConverter.INSTANCE, DateConverter.INSTANCE, LongConverter.INSTANCE, NullConverter.INSTANCE });
    
    iPartialConverters = new ConverterSet(new Converter[] { ReadablePartialConverter.INSTANCE, ReadableInstantConverter.INSTANCE, StringConverter.INSTANCE, CalendarConverter.INSTANCE, DateConverter.INSTANCE, LongConverter.INSTANCE, NullConverter.INSTANCE });
    
    iDurationConverters = new ConverterSet(new Converter[] { ReadableDurationConverter.INSTANCE, ReadableIntervalConverter.INSTANCE, StringConverter.INSTANCE, LongConverter.INSTANCE, NullConverter.INSTANCE });
    
    iPeriodConverters = new ConverterSet(new Converter[] { ReadableDurationConverter.INSTANCE, ReadablePeriodConverter.INSTANCE, ReadableIntervalConverter.INSTANCE, StringConverter.INSTANCE, NullConverter.INSTANCE });
    
    iIntervalConverters = new ConverterSet(new Converter[] { ReadableIntervalConverter.INSTANCE, StringConverter.INSTANCE, NullConverter.INSTANCE });
  }
  
  public InstantConverter getInstantConverter(Object paramObject)
  {
    InstantConverter localInstantConverter = (InstantConverter)iInstantConverters.select(paramObject == null ? null : paramObject.getClass());
    if (localInstantConverter != null) {
      return localInstantConverter;
    }
    throw new IllegalArgumentException("No instant converter found for type: " + (paramObject == null ? "null" : paramObject.getClass().getName()));
  }
  
  public InstantConverter[] getInstantConverters()
  {
    ConverterSet localConverterSet = iInstantConverters;
    InstantConverter[] arrayOfInstantConverter = new InstantConverter[localConverterSet.size()];
    localConverterSet.copyInto(arrayOfInstantConverter);
    return arrayOfInstantConverter;
  }
  
  public InstantConverter addInstantConverter(InstantConverter paramInstantConverter)
    throws SecurityException
  {
    checkAlterInstantConverters();
    if (paramInstantConverter == null) {
      return null;
    }
    InstantConverter[] arrayOfInstantConverter = new InstantConverter[1];
    iInstantConverters = iInstantConverters.add(paramInstantConverter, arrayOfInstantConverter);
    return arrayOfInstantConverter[0];
  }
  
  public InstantConverter removeInstantConverter(InstantConverter paramInstantConverter)
    throws SecurityException
  {
    checkAlterInstantConverters();
    if (paramInstantConverter == null) {
      return null;
    }
    InstantConverter[] arrayOfInstantConverter = new InstantConverter[1];
    iInstantConverters = iInstantConverters.remove(paramInstantConverter, arrayOfInstantConverter);
    return arrayOfInstantConverter[0];
  }
  
  private void checkAlterInstantConverters()
    throws SecurityException
  {
    SecurityManager localSecurityManager = System.getSecurityManager();
    if (localSecurityManager != null) {
      localSecurityManager.checkPermission(new JodaTimePermission("ConverterManager.alterInstantConverters"));
    }
  }
  
  public PartialConverter getPartialConverter(Object paramObject)
  {
    PartialConverter localPartialConverter = (PartialConverter)iPartialConverters.select(paramObject == null ? null : paramObject.getClass());
    if (localPartialConverter != null) {
      return localPartialConverter;
    }
    throw new IllegalArgumentException("No partial converter found for type: " + (paramObject == null ? "null" : paramObject.getClass().getName()));
  }
  
  public PartialConverter[] getPartialConverters()
  {
    ConverterSet localConverterSet = iPartialConverters;
    PartialConverter[] arrayOfPartialConverter = new PartialConverter[localConverterSet.size()];
    localConverterSet.copyInto(arrayOfPartialConverter);
    return arrayOfPartialConverter;
  }
  
  public PartialConverter addPartialConverter(PartialConverter paramPartialConverter)
    throws SecurityException
  {
    checkAlterPartialConverters();
    if (paramPartialConverter == null) {
      return null;
    }
    PartialConverter[] arrayOfPartialConverter = new PartialConverter[1];
    iPartialConverters = iPartialConverters.add(paramPartialConverter, arrayOfPartialConverter);
    return arrayOfPartialConverter[0];
  }
  
  public PartialConverter removePartialConverter(PartialConverter paramPartialConverter)
    throws SecurityException
  {
    checkAlterPartialConverters();
    if (paramPartialConverter == null) {
      return null;
    }
    PartialConverter[] arrayOfPartialConverter = new PartialConverter[1];
    iPartialConverters = iPartialConverters.remove(paramPartialConverter, arrayOfPartialConverter);
    return arrayOfPartialConverter[0];
  }
  
  private void checkAlterPartialConverters()
    throws SecurityException
  {
    SecurityManager localSecurityManager = System.getSecurityManager();
    if (localSecurityManager != null) {
      localSecurityManager.checkPermission(new JodaTimePermission("ConverterManager.alterPartialConverters"));
    }
  }
  
  public DurationConverter getDurationConverter(Object paramObject)
  {
    DurationConverter localDurationConverter = (DurationConverter)iDurationConverters.select(paramObject == null ? null : paramObject.getClass());
    if (localDurationConverter != null) {
      return localDurationConverter;
    }
    throw new IllegalArgumentException("No duration converter found for type: " + (paramObject == null ? "null" : paramObject.getClass().getName()));
  }
  
  public DurationConverter[] getDurationConverters()
  {
    ConverterSet localConverterSet = iDurationConverters;
    DurationConverter[] arrayOfDurationConverter = new DurationConverter[localConverterSet.size()];
    localConverterSet.copyInto(arrayOfDurationConverter);
    return arrayOfDurationConverter;
  }
  
  public DurationConverter addDurationConverter(DurationConverter paramDurationConverter)
    throws SecurityException
  {
    checkAlterDurationConverters();
    if (paramDurationConverter == null) {
      return null;
    }
    DurationConverter[] arrayOfDurationConverter = new DurationConverter[1];
    iDurationConverters = iDurationConverters.add(paramDurationConverter, arrayOfDurationConverter);
    return arrayOfDurationConverter[0];
  }
  
  public DurationConverter removeDurationConverter(DurationConverter paramDurationConverter)
    throws SecurityException
  {
    checkAlterDurationConverters();
    if (paramDurationConverter == null) {
      return null;
    }
    DurationConverter[] arrayOfDurationConverter = new DurationConverter[1];
    iDurationConverters = iDurationConverters.remove(paramDurationConverter, arrayOfDurationConverter);
    return arrayOfDurationConverter[0];
  }
  
  private void checkAlterDurationConverters()
    throws SecurityException
  {
    SecurityManager localSecurityManager = System.getSecurityManager();
    if (localSecurityManager != null) {
      localSecurityManager.checkPermission(new JodaTimePermission("ConverterManager.alterDurationConverters"));
    }
  }
  
  public PeriodConverter getPeriodConverter(Object paramObject)
  {
    PeriodConverter localPeriodConverter = (PeriodConverter)iPeriodConverters.select(paramObject == null ? null : paramObject.getClass());
    if (localPeriodConverter != null) {
      return localPeriodConverter;
    }
    throw new IllegalArgumentException("No period converter found for type: " + (paramObject == null ? "null" : paramObject.getClass().getName()));
  }
  
  public PeriodConverter[] getPeriodConverters()
  {
    ConverterSet localConverterSet = iPeriodConverters;
    PeriodConverter[] arrayOfPeriodConverter = new PeriodConverter[localConverterSet.size()];
    localConverterSet.copyInto(arrayOfPeriodConverter);
    return arrayOfPeriodConverter;
  }
  
  public PeriodConverter addPeriodConverter(PeriodConverter paramPeriodConverter)
    throws SecurityException
  {
    checkAlterPeriodConverters();
    if (paramPeriodConverter == null) {
      return null;
    }
    PeriodConverter[] arrayOfPeriodConverter = new PeriodConverter[1];
    iPeriodConverters = iPeriodConverters.add(paramPeriodConverter, arrayOfPeriodConverter);
    return arrayOfPeriodConverter[0];
  }
  
  public PeriodConverter removePeriodConverter(PeriodConverter paramPeriodConverter)
    throws SecurityException
  {
    checkAlterPeriodConverters();
    if (paramPeriodConverter == null) {
      return null;
    }
    PeriodConverter[] arrayOfPeriodConverter = new PeriodConverter[1];
    iPeriodConverters = iPeriodConverters.remove(paramPeriodConverter, arrayOfPeriodConverter);
    return arrayOfPeriodConverter[0];
  }
  
  private void checkAlterPeriodConverters()
    throws SecurityException
  {
    SecurityManager localSecurityManager = System.getSecurityManager();
    if (localSecurityManager != null) {
      localSecurityManager.checkPermission(new JodaTimePermission("ConverterManager.alterPeriodConverters"));
    }
  }
  
  public IntervalConverter getIntervalConverter(Object paramObject)
  {
    IntervalConverter localIntervalConverter = (IntervalConverter)iIntervalConverters.select(paramObject == null ? null : paramObject.getClass());
    if (localIntervalConverter != null) {
      return localIntervalConverter;
    }
    throw new IllegalArgumentException("No interval converter found for type: " + (paramObject == null ? "null" : paramObject.getClass().getName()));
  }
  
  public IntervalConverter[] getIntervalConverters()
  {
    ConverterSet localConverterSet = iIntervalConverters;
    IntervalConverter[] arrayOfIntervalConverter = new IntervalConverter[localConverterSet.size()];
    localConverterSet.copyInto(arrayOfIntervalConverter);
    return arrayOfIntervalConverter;
  }
  
  public IntervalConverter addIntervalConverter(IntervalConverter paramIntervalConverter)
    throws SecurityException
  {
    checkAlterIntervalConverters();
    if (paramIntervalConverter == null) {
      return null;
    }
    IntervalConverter[] arrayOfIntervalConverter = new IntervalConverter[1];
    iIntervalConverters = iIntervalConverters.add(paramIntervalConverter, arrayOfIntervalConverter);
    return arrayOfIntervalConverter[0];
  }
  
  public IntervalConverter removeIntervalConverter(IntervalConverter paramIntervalConverter)
    throws SecurityException
  {
    checkAlterIntervalConverters();
    if (paramIntervalConverter == null) {
      return null;
    }
    IntervalConverter[] arrayOfIntervalConverter = new IntervalConverter[1];
    iIntervalConverters = iIntervalConverters.remove(paramIntervalConverter, arrayOfIntervalConverter);
    return arrayOfIntervalConverter[0];
  }
  
  private void checkAlterIntervalConverters()
    throws SecurityException
  {
    SecurityManager localSecurityManager = System.getSecurityManager();
    if (localSecurityManager != null) {
      localSecurityManager.checkPermission(new JodaTimePermission("ConverterManager.alterIntervalConverters"));
    }
  }
  
  public String toString()
  {
    return "ConverterManager[" + iInstantConverters.size() + " instant," + iPartialConverters.size() + " partial," + iDurationConverters.size() + " duration," + iPeriodConverters.size() + " period," + iIntervalConverters.size() + " interval]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.convert.ConverterManager
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */