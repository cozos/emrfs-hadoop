package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.LocalDate;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.LocalDateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.LocalTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutableDateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadableInstant;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

public class DateTimeFormatter
{
  private final InternalPrinter iPrinter;
  private final InternalParser iParser;
  private final Locale iLocale;
  private final boolean iOffsetParsed;
  private final Chronology iChrono;
  private final DateTimeZone iZone;
  private final Integer iPivotYear;
  private final int iDefaultYear;
  
  public DateTimeFormatter(DateTimePrinter paramDateTimePrinter, DateTimeParser paramDateTimeParser)
  {
    this(DateTimePrinterInternalPrinter.of(paramDateTimePrinter), DateTimeParserInternalParser.of(paramDateTimeParser));
  }
  
  DateTimeFormatter(InternalPrinter paramInternalPrinter, InternalParser paramInternalParser)
  {
    iPrinter = paramInternalPrinter;
    iParser = paramInternalParser;
    iLocale = null;
    iOffsetParsed = false;
    iChrono = null;
    iZone = null;
    iPivotYear = null;
    iDefaultYear = 2000;
  }
  
  private DateTimeFormatter(InternalPrinter paramInternalPrinter, InternalParser paramInternalParser, Locale paramLocale, boolean paramBoolean, Chronology paramChronology, DateTimeZone paramDateTimeZone, Integer paramInteger, int paramInt)
  {
    iPrinter = paramInternalPrinter;
    iParser = paramInternalParser;
    iLocale = paramLocale;
    iOffsetParsed = paramBoolean;
    iChrono = paramChronology;
    iZone = paramDateTimeZone;
    iPivotYear = paramInteger;
    iDefaultYear = paramInt;
  }
  
  public boolean isPrinter()
  {
    return iPrinter != null;
  }
  
  public DateTimePrinter getPrinter()
  {
    return InternalPrinterDateTimePrinter.of(iPrinter);
  }
  
  InternalPrinter getPrinter0()
  {
    return iPrinter;
  }
  
  public boolean isParser()
  {
    return iParser != null;
  }
  
  public DateTimeParser getParser()
  {
    return InternalParserDateTimeParser.of(iParser);
  }
  
  InternalParser getParser0()
  {
    return iParser;
  }
  
  public DateTimeFormatter withLocale(Locale paramLocale)
  {
    if ((paramLocale == getLocale()) || ((paramLocale != null) && (paramLocale.equals(getLocale())))) {
      return this;
    }
    return new DateTimeFormatter(iPrinter, iParser, paramLocale, iOffsetParsed, iChrono, iZone, iPivotYear, iDefaultYear);
  }
  
  public Locale getLocale()
  {
    return iLocale;
  }
  
  public DateTimeFormatter withOffsetParsed()
  {
    if (iOffsetParsed == true) {
      return this;
    }
    return new DateTimeFormatter(iPrinter, iParser, iLocale, true, iChrono, null, iPivotYear, iDefaultYear);
  }
  
  public boolean isOffsetParsed()
  {
    return iOffsetParsed;
  }
  
  public DateTimeFormatter withChronology(Chronology paramChronology)
  {
    if (iChrono == paramChronology) {
      return this;
    }
    return new DateTimeFormatter(iPrinter, iParser, iLocale, iOffsetParsed, paramChronology, iZone, iPivotYear, iDefaultYear);
  }
  
  public Chronology getChronology()
  {
    return iChrono;
  }
  
  @Deprecated
  public Chronology getChronolgy()
  {
    return iChrono;
  }
  
  public DateTimeFormatter withZoneUTC()
  {
    return withZone(DateTimeZone.UTC);
  }
  
  public DateTimeFormatter withZone(DateTimeZone paramDateTimeZone)
  {
    if (iZone == paramDateTimeZone) {
      return this;
    }
    return new DateTimeFormatter(iPrinter, iParser, iLocale, false, iChrono, paramDateTimeZone, iPivotYear, iDefaultYear);
  }
  
  public DateTimeZone getZone()
  {
    return iZone;
  }
  
  public DateTimeFormatter withPivotYear(Integer paramInteger)
  {
    if ((iPivotYear == paramInteger) || ((iPivotYear != null) && (iPivotYear.equals(paramInteger)))) {
      return this;
    }
    return new DateTimeFormatter(iPrinter, iParser, iLocale, iOffsetParsed, iChrono, iZone, paramInteger, iDefaultYear);
  }
  
  public DateTimeFormatter withPivotYear(int paramInt)
  {
    return withPivotYear(Integer.valueOf(paramInt));
  }
  
  public Integer getPivotYear()
  {
    return iPivotYear;
  }
  
  public DateTimeFormatter withDefaultYear(int paramInt)
  {
    return new DateTimeFormatter(iPrinter, iParser, iLocale, iOffsetParsed, iChrono, iZone, iPivotYear, paramInt);
  }
  
  public int getDefaultYear()
  {
    return iDefaultYear;
  }
  
  public void printTo(StringBuffer paramStringBuffer, ReadableInstant paramReadableInstant)
  {
    try
    {
      printTo(paramStringBuffer, paramReadableInstant);
    }
    catch (IOException localIOException) {}
  }
  
  public void printTo(StringBuilder paramStringBuilder, ReadableInstant paramReadableInstant)
  {
    try
    {
      printTo(paramStringBuilder, paramReadableInstant);
    }
    catch (IOException localIOException) {}
  }
  
  public void printTo(Writer paramWriter, ReadableInstant paramReadableInstant)
    throws IOException
  {
    printTo(paramWriter, paramReadableInstant);
  }
  
  public void printTo(Appendable paramAppendable, ReadableInstant paramReadableInstant)
    throws IOException
  {
    long l = DateTimeUtils.getInstantMillis(paramReadableInstant);
    Chronology localChronology = DateTimeUtils.getInstantChronology(paramReadableInstant);
    printTo(paramAppendable, l, localChronology);
  }
  
  public void printTo(StringBuffer paramStringBuffer, long paramLong)
  {
    try
    {
      printTo(paramStringBuffer, paramLong);
    }
    catch (IOException localIOException) {}
  }
  
  public void printTo(StringBuilder paramStringBuilder, long paramLong)
  {
    try
    {
      printTo(paramStringBuilder, paramLong);
    }
    catch (IOException localIOException) {}
  }
  
  public void printTo(Writer paramWriter, long paramLong)
    throws IOException
  {
    printTo(paramWriter, paramLong);
  }
  
  public void printTo(Appendable paramAppendable, long paramLong)
    throws IOException
  {
    printTo(paramAppendable, paramLong, null);
  }
  
  public void printTo(StringBuffer paramStringBuffer, ReadablePartial paramReadablePartial)
  {
    try
    {
      printTo(paramStringBuffer, paramReadablePartial);
    }
    catch (IOException localIOException) {}
  }
  
  public void printTo(StringBuilder paramStringBuilder, ReadablePartial paramReadablePartial)
  {
    try
    {
      printTo(paramStringBuilder, paramReadablePartial);
    }
    catch (IOException localIOException) {}
  }
  
  public void printTo(Writer paramWriter, ReadablePartial paramReadablePartial)
    throws IOException
  {
    printTo(paramWriter, paramReadablePartial);
  }
  
  public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial)
    throws IOException
  {
    InternalPrinter localInternalPrinter = requirePrinter();
    if (paramReadablePartial == null) {
      throw new IllegalArgumentException("The partial must not be null");
    }
    localInternalPrinter.printTo(paramAppendable, paramReadablePartial, iLocale);
  }
  
  public String print(ReadableInstant paramReadableInstant)
  {
    StringBuilder localStringBuilder = new StringBuilder(requirePrinter().estimatePrintedLength());
    try
    {
      printTo(localStringBuilder, paramReadableInstant);
    }
    catch (IOException localIOException) {}
    return localStringBuilder.toString();
  }
  
  public String print(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder(requirePrinter().estimatePrintedLength());
    try
    {
      printTo(localStringBuilder, paramLong);
    }
    catch (IOException localIOException) {}
    return localStringBuilder.toString();
  }
  
  public String print(ReadablePartial paramReadablePartial)
  {
    StringBuilder localStringBuilder = new StringBuilder(requirePrinter().estimatePrintedLength());
    try
    {
      printTo(localStringBuilder, paramReadablePartial);
    }
    catch (IOException localIOException) {}
    return localStringBuilder.toString();
  }
  
  private void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology)
    throws IOException
  {
    InternalPrinter localInternalPrinter = requirePrinter();
    paramChronology = selectChronology(paramChronology);
    
    DateTimeZone localDateTimeZone = paramChronology.getZone();
    int i = localDateTimeZone.getOffset(paramLong);
    long l = paramLong + i;
    if (((paramLong ^ l) < 0L) && ((paramLong ^ i) >= 0L))
    {
      localDateTimeZone = DateTimeZone.UTC;
      i = 0;
      l = paramLong;
    }
    localInternalPrinter.printTo(paramAppendable, l, paramChronology.withUTC(), i, localDateTimeZone, iLocale);
  }
  
  private InternalPrinter requirePrinter()
  {
    InternalPrinter localInternalPrinter = iPrinter;
    if (localInternalPrinter == null) {
      throw new UnsupportedOperationException("Printing not supported");
    }
    return localInternalPrinter;
  }
  
  public int parseInto(ReadWritableInstant paramReadWritableInstant, String paramString, int paramInt)
  {
    InternalParser localInternalParser = requireParser();
    if (paramReadWritableInstant == null) {
      throw new IllegalArgumentException("Instant must not be null");
    }
    long l1 = paramReadWritableInstant.getMillis();
    Chronology localChronology = paramReadWritableInstant.getChronology();
    int i = DateTimeUtils.getChronology(localChronology).year().get(l1);
    long l2 = l1 + localChronology.getZone().getOffset(l1);
    localChronology = selectChronology(localChronology);
    
    DateTimeParserBucket localDateTimeParserBucket = new DateTimeParserBucket(l2, localChronology, iLocale, iPivotYear, i);
    
    int j = localInternalParser.parseInto(localDateTimeParserBucket, paramString, paramInt);
    paramReadWritableInstant.setMillis(localDateTimeParserBucket.computeMillis(false, paramString));
    if ((iOffsetParsed) && (localDateTimeParserBucket.getOffsetInteger() != null))
    {
      int k = localDateTimeParserBucket.getOffsetInteger().intValue();
      DateTimeZone localDateTimeZone = DateTimeZone.forOffsetMillis(k);
      localChronology = localChronology.withZone(localDateTimeZone);
    }
    else if (localDateTimeParserBucket.getZone() != null)
    {
      localChronology = localChronology.withZone(localDateTimeParserBucket.getZone());
    }
    paramReadWritableInstant.setChronology(localChronology);
    if (iZone != null) {
      paramReadWritableInstant.setZone(iZone);
    }
    return j;
  }
  
  public long parseMillis(String paramString)
  {
    InternalParser localInternalParser = requireParser();
    Chronology localChronology = selectChronology(iChrono);
    DateTimeParserBucket localDateTimeParserBucket = new DateTimeParserBucket(0L, localChronology, iLocale, iPivotYear, iDefaultYear);
    return localDateTimeParserBucket.doParseMillis(localInternalParser, paramString);
  }
  
  public LocalDate parseLocalDate(String paramString)
  {
    return parseLocalDateTime(paramString).toLocalDate();
  }
  
  public LocalTime parseLocalTime(String paramString)
  {
    return parseLocalDateTime(paramString).toLocalTime();
  }
  
  public LocalDateTime parseLocalDateTime(String paramString)
  {
    InternalParser localInternalParser = requireParser();
    
    Chronology localChronology = selectChronology(null).withUTC();
    DateTimeParserBucket localDateTimeParserBucket = new DateTimeParserBucket(0L, localChronology, iLocale, iPivotYear, iDefaultYear);
    int i = localInternalParser.parseInto(localDateTimeParserBucket, paramString, 0);
    if (i >= 0)
    {
      if (i >= paramString.length())
      {
        long l = localDateTimeParserBucket.computeMillis(true, paramString);
        if (localDateTimeParserBucket.getOffsetInteger() != null)
        {
          int j = localDateTimeParserBucket.getOffsetInteger().intValue();
          DateTimeZone localDateTimeZone = DateTimeZone.forOffsetMillis(j);
          localChronology = localChronology.withZone(localDateTimeZone);
        }
        else if (localDateTimeParserBucket.getZone() != null)
        {
          localChronology = localChronology.withZone(localDateTimeParserBucket.getZone());
        }
        return new LocalDateTime(l, localChronology);
      }
    }
    else {
      i ^= 0xFFFFFFFF;
    }
    throw new IllegalArgumentException(FormatUtils.createErrorMessage(paramString, i));
  }
  
  public DateTime parseDateTime(String paramString)
  {
    InternalParser localInternalParser = requireParser();
    
    Chronology localChronology = selectChronology(null);
    DateTimeParserBucket localDateTimeParserBucket = new DateTimeParserBucket(0L, localChronology, iLocale, iPivotYear, iDefaultYear);
    int i = localInternalParser.parseInto(localDateTimeParserBucket, paramString, 0);
    if (i >= 0)
    {
      if (i >= paramString.length())
      {
        long l = localDateTimeParserBucket.computeMillis(true, paramString);
        if ((iOffsetParsed) && (localDateTimeParserBucket.getOffsetInteger() != null))
        {
          int j = localDateTimeParserBucket.getOffsetInteger().intValue();
          DateTimeZone localDateTimeZone = DateTimeZone.forOffsetMillis(j);
          localChronology = localChronology.withZone(localDateTimeZone);
        }
        else if (localDateTimeParserBucket.getZone() != null)
        {
          localChronology = localChronology.withZone(localDateTimeParserBucket.getZone());
        }
        DateTime localDateTime = new DateTime(l, localChronology);
        if (iZone != null) {
          localDateTime = localDateTime.withZone(iZone);
        }
        return localDateTime;
      }
    }
    else {
      i ^= 0xFFFFFFFF;
    }
    throw new IllegalArgumentException(FormatUtils.createErrorMessage(paramString, i));
  }
  
  public MutableDateTime parseMutableDateTime(String paramString)
  {
    InternalParser localInternalParser = requireParser();
    
    Chronology localChronology = selectChronology(null);
    DateTimeParserBucket localDateTimeParserBucket = new DateTimeParserBucket(0L, localChronology, iLocale, iPivotYear, iDefaultYear);
    int i = localInternalParser.parseInto(localDateTimeParserBucket, paramString, 0);
    if (i >= 0)
    {
      if (i >= paramString.length())
      {
        long l = localDateTimeParserBucket.computeMillis(true, paramString);
        if ((iOffsetParsed) && (localDateTimeParserBucket.getOffsetInteger() != null))
        {
          int j = localDateTimeParserBucket.getOffsetInteger().intValue();
          DateTimeZone localDateTimeZone = DateTimeZone.forOffsetMillis(j);
          localChronology = localChronology.withZone(localDateTimeZone);
        }
        else if (localDateTimeParserBucket.getZone() != null)
        {
          localChronology = localChronology.withZone(localDateTimeParserBucket.getZone());
        }
        MutableDateTime localMutableDateTime = new MutableDateTime(l, localChronology);
        if (iZone != null) {
          localMutableDateTime.setZone(iZone);
        }
        return localMutableDateTime;
      }
    }
    else {
      i ^= 0xFFFFFFFF;
    }
    throw new IllegalArgumentException(FormatUtils.createErrorMessage(paramString, i));
  }
  
  private InternalParser requireParser()
  {
    InternalParser localInternalParser = iParser;
    if (localInternalParser == null) {
      throw new UnsupportedOperationException("Parsing not supported");
    }
    return localInternalParser;
  }
  
  private Chronology selectChronology(Chronology paramChronology)
  {
    paramChronology = DateTimeUtils.getChronology(paramChronology);
    if (iChrono != null) {
      paramChronology = iChrono;
    }
    if (iZone != null) {
      paramChronology = paramChronology.withZone(iZone);
    }
    return paramChronology;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */