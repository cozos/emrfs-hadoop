package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeFieldType;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutableDateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutableDateTime.Property;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePartial;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.MillisDurationField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.PreciseDateTimeField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DateTimeFormatterBuilder
{
  private ArrayList<Object> iElementPairs;
  private Object iFormatter;
  
  public DateTimeFormatterBuilder()
  {
    iElementPairs = new ArrayList();
  }
  
  public DateTimeFormatter toFormatter()
  {
    Object localObject = getFormatter();
    InternalPrinter localInternalPrinter = null;
    if (isPrinter(localObject)) {
      localInternalPrinter = (InternalPrinter)localObject;
    }
    InternalParser localInternalParser = null;
    if (isParser(localObject)) {
      localInternalParser = (InternalParser)localObject;
    }
    if ((localInternalPrinter != null) || (localInternalParser != null)) {
      return new DateTimeFormatter(localInternalPrinter, localInternalParser);
    }
    throw new UnsupportedOperationException("Both printing and parsing not supported");
  }
  
  public DateTimePrinter toPrinter()
  {
    Object localObject = getFormatter();
    if (isPrinter(localObject))
    {
      InternalPrinter localInternalPrinter = (InternalPrinter)localObject;
      return InternalPrinterDateTimePrinter.of(localInternalPrinter);
    }
    throw new UnsupportedOperationException("Printing is not supported");
  }
  
  public DateTimeParser toParser()
  {
    Object localObject = getFormatter();
    if (isParser(localObject))
    {
      InternalParser localInternalParser = (InternalParser)localObject;
      return InternalParserDateTimeParser.of(localInternalParser);
    }
    throw new UnsupportedOperationException("Parsing is not supported");
  }
  
  public boolean canBuildFormatter()
  {
    return isFormatter(getFormatter());
  }
  
  public boolean canBuildPrinter()
  {
    return isPrinter(getFormatter());
  }
  
  public boolean canBuildParser()
  {
    return isParser(getFormatter());
  }
  
  public void clear()
  {
    iFormatter = null;
    iElementPairs.clear();
  }
  
  public DateTimeFormatterBuilder append(DateTimeFormatter paramDateTimeFormatter)
  {
    if (paramDateTimeFormatter == null) {
      throw new IllegalArgumentException("No formatter supplied");
    }
    return append0(paramDateTimeFormatter.getPrinter0(), paramDateTimeFormatter.getParser0());
  }
  
  public DateTimeFormatterBuilder append(DateTimePrinter paramDateTimePrinter)
  {
    checkPrinter(paramDateTimePrinter);
    return append0(DateTimePrinterInternalPrinter.of(paramDateTimePrinter), null);
  }
  
  public DateTimeFormatterBuilder append(DateTimeParser paramDateTimeParser)
  {
    checkParser(paramDateTimeParser);
    return append0(null, DateTimeParserInternalParser.of(paramDateTimeParser));
  }
  
  public DateTimeFormatterBuilder append(DateTimePrinter paramDateTimePrinter, DateTimeParser paramDateTimeParser)
  {
    checkPrinter(paramDateTimePrinter);
    checkParser(paramDateTimeParser);
    return append0(DateTimePrinterInternalPrinter.of(paramDateTimePrinter), DateTimeParserInternalParser.of(paramDateTimeParser));
  }
  
  public DateTimeFormatterBuilder append(DateTimePrinter paramDateTimePrinter, DateTimeParser[] paramArrayOfDateTimeParser)
  {
    if (paramDateTimePrinter != null) {
      checkPrinter(paramDateTimePrinter);
    }
    if (paramArrayOfDateTimeParser == null) {
      throw new IllegalArgumentException("No parsers supplied");
    }
    int i = paramArrayOfDateTimeParser.length;
    if (i == 1)
    {
      if (paramArrayOfDateTimeParser[0] == null) {
        throw new IllegalArgumentException("No parser supplied");
      }
      return append0(DateTimePrinterInternalPrinter.of(paramDateTimePrinter), DateTimeParserInternalParser.of(paramArrayOfDateTimeParser[0]));
    }
    InternalParser[] arrayOfInternalParser = new InternalParser[i];
    for (int j = 0; j < i - 1; j++) {
      if ((arrayOfInternalParser[j] = DateTimeParserInternalParser.of(paramArrayOfDateTimeParser[j])) == null) {
        throw new IllegalArgumentException("Incomplete parser array");
      }
    }
    arrayOfInternalParser[j] = DateTimeParserInternalParser.of(paramArrayOfDateTimeParser[j]);
    
    return append0(DateTimePrinterInternalPrinter.of(paramDateTimePrinter), new MatchingParser(arrayOfInternalParser));
  }
  
  public DateTimeFormatterBuilder appendOptional(DateTimeParser paramDateTimeParser)
  {
    checkParser(paramDateTimeParser);
    InternalParser[] arrayOfInternalParser = { DateTimeParserInternalParser.of(paramDateTimeParser), null };
    return append0(null, new MatchingParser(arrayOfInternalParser));
  }
  
  private void checkParser(DateTimeParser paramDateTimeParser)
  {
    if (paramDateTimeParser == null) {
      throw new IllegalArgumentException("No parser supplied");
    }
  }
  
  private void checkPrinter(DateTimePrinter paramDateTimePrinter)
  {
    if (paramDateTimePrinter == null) {
      throw new IllegalArgumentException("No printer supplied");
    }
  }
  
  private DateTimeFormatterBuilder append0(Object paramObject)
  {
    iFormatter = null;
    
    iElementPairs.add(paramObject);
    iElementPairs.add(paramObject);
    return this;
  }
  
  private DateTimeFormatterBuilder append0(InternalPrinter paramInternalPrinter, InternalParser paramInternalParser)
  {
    iFormatter = null;
    iElementPairs.add(paramInternalPrinter);
    iElementPairs.add(paramInternalParser);
    return this;
  }
  
  public DateTimeFormatterBuilder appendLiteral(char paramChar)
  {
    return append0(new CharacterLiteral(paramChar));
  }
  
  public DateTimeFormatterBuilder appendLiteral(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Literal must not be null");
    }
    switch (paramString.length())
    {
    case 0: 
      return this;
    case 1: 
      return append0(new CharacterLiteral(paramString.charAt(0)));
    }
    return append0(new StringLiteral(paramString));
  }
  
  public DateTimeFormatterBuilder appendDecimal(DateTimeFieldType paramDateTimeFieldType, int paramInt1, int paramInt2)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("Field type must not be null");
    }
    if (paramInt2 < paramInt1) {
      paramInt2 = paramInt1;
    }
    if ((paramInt1 < 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException();
    }
    if (paramInt1 <= 1) {
      return append0(new UnpaddedNumber(paramDateTimeFieldType, paramInt2, false));
    }
    return append0(new PaddedNumber(paramDateTimeFieldType, paramInt2, false, paramInt1));
  }
  
  public DateTimeFormatterBuilder appendFixedDecimal(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("Field type must not be null");
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Illegal number of digits: " + paramInt);
    }
    return append0(new FixedNumber(paramDateTimeFieldType, paramInt, false));
  }
  
  public DateTimeFormatterBuilder appendSignedDecimal(DateTimeFieldType paramDateTimeFieldType, int paramInt1, int paramInt2)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("Field type must not be null");
    }
    if (paramInt2 < paramInt1) {
      paramInt2 = paramInt1;
    }
    if ((paramInt1 < 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException();
    }
    if (paramInt1 <= 1) {
      return append0(new UnpaddedNumber(paramDateTimeFieldType, paramInt2, true));
    }
    return append0(new PaddedNumber(paramDateTimeFieldType, paramInt2, true, paramInt1));
  }
  
  public DateTimeFormatterBuilder appendFixedSignedDecimal(DateTimeFieldType paramDateTimeFieldType, int paramInt)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("Field type must not be null");
    }
    if (paramInt <= 0) {
      throw new IllegalArgumentException("Illegal number of digits: " + paramInt);
    }
    return append0(new FixedNumber(paramDateTimeFieldType, paramInt, true));
  }
  
  public DateTimeFormatterBuilder appendText(DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("Field type must not be null");
    }
    return append0(new TextField(paramDateTimeFieldType, false));
  }
  
  public DateTimeFormatterBuilder appendShortText(DateTimeFieldType paramDateTimeFieldType)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("Field type must not be null");
    }
    return append0(new TextField(paramDateTimeFieldType, true));
  }
  
  public DateTimeFormatterBuilder appendFraction(DateTimeFieldType paramDateTimeFieldType, int paramInt1, int paramInt2)
  {
    if (paramDateTimeFieldType == null) {
      throw new IllegalArgumentException("Field type must not be null");
    }
    if (paramInt2 < paramInt1) {
      paramInt2 = paramInt1;
    }
    if ((paramInt1 < 0) || (paramInt2 <= 0)) {
      throw new IllegalArgumentException();
    }
    return append0(new Fraction(paramDateTimeFieldType, paramInt1, paramInt2));
  }
  
  public DateTimeFormatterBuilder appendFractionOfSecond(int paramInt1, int paramInt2)
  {
    return appendFraction(DateTimeFieldType.secondOfDay(), paramInt1, paramInt2);
  }
  
  public DateTimeFormatterBuilder appendFractionOfMinute(int paramInt1, int paramInt2)
  {
    return appendFraction(DateTimeFieldType.minuteOfDay(), paramInt1, paramInt2);
  }
  
  public DateTimeFormatterBuilder appendFractionOfHour(int paramInt1, int paramInt2)
  {
    return appendFraction(DateTimeFieldType.hourOfDay(), paramInt1, paramInt2);
  }
  
  public DateTimeFormatterBuilder appendFractionOfDay(int paramInt1, int paramInt2)
  {
    return appendFraction(DateTimeFieldType.dayOfYear(), paramInt1, paramInt2);
  }
  
  public DateTimeFormatterBuilder appendMillisOfSecond(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.millisOfSecond(), paramInt, 3);
  }
  
  public DateTimeFormatterBuilder appendMillisOfDay(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.millisOfDay(), paramInt, 8);
  }
  
  public DateTimeFormatterBuilder appendSecondOfMinute(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.secondOfMinute(), paramInt, 2);
  }
  
  public DateTimeFormatterBuilder appendSecondOfDay(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.secondOfDay(), paramInt, 5);
  }
  
  public DateTimeFormatterBuilder appendMinuteOfHour(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.minuteOfHour(), paramInt, 2);
  }
  
  public DateTimeFormatterBuilder appendMinuteOfDay(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.minuteOfDay(), paramInt, 4);
  }
  
  public DateTimeFormatterBuilder appendHourOfDay(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.hourOfDay(), paramInt, 2);
  }
  
  public DateTimeFormatterBuilder appendClockhourOfDay(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.clockhourOfDay(), paramInt, 2);
  }
  
  public DateTimeFormatterBuilder appendHourOfHalfday(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.hourOfHalfday(), paramInt, 2);
  }
  
  public DateTimeFormatterBuilder appendClockhourOfHalfday(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.clockhourOfHalfday(), paramInt, 2);
  }
  
  public DateTimeFormatterBuilder appendDayOfWeek(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.dayOfWeek(), paramInt, 1);
  }
  
  public DateTimeFormatterBuilder appendDayOfMonth(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.dayOfMonth(), paramInt, 2);
  }
  
  public DateTimeFormatterBuilder appendDayOfYear(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.dayOfYear(), paramInt, 3);
  }
  
  public DateTimeFormatterBuilder appendWeekOfWeekyear(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.weekOfWeekyear(), paramInt, 2);
  }
  
  public DateTimeFormatterBuilder appendWeekyear(int paramInt1, int paramInt2)
  {
    return appendSignedDecimal(DateTimeFieldType.weekyear(), paramInt1, paramInt2);
  }
  
  public DateTimeFormatterBuilder appendMonthOfYear(int paramInt)
  {
    return appendDecimal(DateTimeFieldType.monthOfYear(), paramInt, 2);
  }
  
  public DateTimeFormatterBuilder appendYear(int paramInt1, int paramInt2)
  {
    return appendSignedDecimal(DateTimeFieldType.year(), paramInt1, paramInt2);
  }
  
  public DateTimeFormatterBuilder appendTwoDigitYear(int paramInt)
  {
    return appendTwoDigitYear(paramInt, false);
  }
  
  public DateTimeFormatterBuilder appendTwoDigitYear(int paramInt, boolean paramBoolean)
  {
    return append0(new TwoDigitYear(DateTimeFieldType.year(), paramInt, paramBoolean));
  }
  
  public DateTimeFormatterBuilder appendTwoDigitWeekyear(int paramInt)
  {
    return appendTwoDigitWeekyear(paramInt, false);
  }
  
  public DateTimeFormatterBuilder appendTwoDigitWeekyear(int paramInt, boolean paramBoolean)
  {
    return append0(new TwoDigitYear(DateTimeFieldType.weekyear(), paramInt, paramBoolean));
  }
  
  public DateTimeFormatterBuilder appendYearOfEra(int paramInt1, int paramInt2)
  {
    return appendDecimal(DateTimeFieldType.yearOfEra(), paramInt1, paramInt2);
  }
  
  public DateTimeFormatterBuilder appendYearOfCentury(int paramInt1, int paramInt2)
  {
    return appendDecimal(DateTimeFieldType.yearOfCentury(), paramInt1, paramInt2);
  }
  
  public DateTimeFormatterBuilder appendCenturyOfEra(int paramInt1, int paramInt2)
  {
    return appendSignedDecimal(DateTimeFieldType.centuryOfEra(), paramInt1, paramInt2);
  }
  
  public DateTimeFormatterBuilder appendHalfdayOfDayText()
  {
    return appendText(DateTimeFieldType.halfdayOfDay());
  }
  
  public DateTimeFormatterBuilder appendDayOfWeekText()
  {
    return appendText(DateTimeFieldType.dayOfWeek());
  }
  
  public DateTimeFormatterBuilder appendDayOfWeekShortText()
  {
    return appendShortText(DateTimeFieldType.dayOfWeek());
  }
  
  public DateTimeFormatterBuilder appendMonthOfYearText()
  {
    return appendText(DateTimeFieldType.monthOfYear());
  }
  
  public DateTimeFormatterBuilder appendMonthOfYearShortText()
  {
    return appendShortText(DateTimeFieldType.monthOfYear());
  }
  
  public DateTimeFormatterBuilder appendEraText()
  {
    return appendText(DateTimeFieldType.era());
  }
  
  public DateTimeFormatterBuilder appendTimeZoneName()
  {
    return append0(new TimeZoneName(0, null), null);
  }
  
  public DateTimeFormatterBuilder appendTimeZoneName(Map<String, DateTimeZone> paramMap)
  {
    TimeZoneName localTimeZoneName = new TimeZoneName(0, paramMap);
    return append0(localTimeZoneName, localTimeZoneName);
  }
  
  public DateTimeFormatterBuilder appendTimeZoneShortName()
  {
    return append0(new TimeZoneName(1, null), null);
  }
  
  public DateTimeFormatterBuilder appendTimeZoneShortName(Map<String, DateTimeZone> paramMap)
  {
    TimeZoneName localTimeZoneName = new TimeZoneName(1, paramMap);
    return append0(localTimeZoneName, localTimeZoneName);
  }
  
  public DateTimeFormatterBuilder appendTimeZoneId()
  {
    return append0(TimeZoneId.INSTANCE, TimeZoneId.INSTANCE);
  }
  
  public DateTimeFormatterBuilder appendTimeZoneOffset(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return append0(new TimeZoneOffset(paramString, paramString, paramBoolean, paramInt1, paramInt2));
  }
  
  public DateTimeFormatterBuilder appendTimeZoneOffset(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return append0(new TimeZoneOffset(paramString1, paramString2, paramBoolean, paramInt1, paramInt2));
  }
  
  public DateTimeFormatterBuilder appendPattern(String paramString)
  {
    DateTimeFormat.appendPatternTo(this, paramString);
    return this;
  }
  
  private Object getFormatter()
  {
    Object localObject1 = iFormatter;
    if (localObject1 == null)
    {
      if (iElementPairs.size() == 2)
      {
        Object localObject2 = iElementPairs.get(0);
        Object localObject3 = iElementPairs.get(1);
        if (localObject2 != null)
        {
          if ((localObject2 == localObject3) || (localObject3 == null)) {
            localObject1 = localObject2;
          }
        }
        else {
          localObject1 = localObject3;
        }
      }
      if (localObject1 == null) {
        localObject1 = new Composite(iElementPairs);
      }
      iFormatter = localObject1;
    }
    return localObject1;
  }
  
  private boolean isPrinter(Object paramObject)
  {
    if ((paramObject instanceof InternalPrinter))
    {
      if ((paramObject instanceof Composite)) {
        return ((Composite)paramObject).isPrinter();
      }
      return true;
    }
    return false;
  }
  
  private boolean isParser(Object paramObject)
  {
    if ((paramObject instanceof InternalParser))
    {
      if ((paramObject instanceof Composite)) {
        return ((Composite)paramObject).isParser();
      }
      return true;
    }
    return false;
  }
  
  private boolean isFormatter(Object paramObject)
  {
    return (isPrinter(paramObject)) || (isParser(paramObject));
  }
  
  static void appendUnknownString(Appendable paramAppendable, int paramInt)
    throws IOException
  {
    int i = paramInt;
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      paramAppendable.append(65533);
    }
  }
  
  static class CharacterLiteral
    implements InternalPrinter, InternalParser
  {
    private final char iValue;
    
    CharacterLiteral(char paramChar)
    {
      iValue = paramChar;
    }
    
    public int estimatePrintedLength()
    {
      return 1;
    }
    
    public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
      throws IOException
    {
      paramAppendable.append(iValue);
    }
    
    public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
      throws IOException
    {
      paramAppendable.append(iValue);
    }
    
    public int estimateParsedLength()
    {
      return 1;
    }
    
    public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
    {
      if (paramInt >= paramCharSequence.length()) {
        return paramInt ^ 0xFFFFFFFF;
      }
      char c1 = paramCharSequence.charAt(paramInt);
      char c2 = iValue;
      if (c1 != c2)
      {
        c1 = Character.toUpperCase(c1);
        c2 = Character.toUpperCase(c2);
        if (c1 != c2)
        {
          c1 = Character.toLowerCase(c1);
          c2 = Character.toLowerCase(c2);
          if (c1 != c2) {
            return paramInt ^ 0xFFFFFFFF;
          }
        }
      }
      return paramInt + 1;
    }
  }
  
  static class StringLiteral
    implements InternalPrinter, InternalParser
  {
    private final String iValue;
    
    StringLiteral(String paramString)
    {
      iValue = paramString;
    }
    
    public int estimatePrintedLength()
    {
      return iValue.length();
    }
    
    public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
      throws IOException
    {
      paramAppendable.append(iValue);
    }
    
    public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
      throws IOException
    {
      paramAppendable.append(iValue);
    }
    
    public int estimateParsedLength()
    {
      return iValue.length();
    }
    
    public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
    {
      if (DateTimeFormatterBuilder.csStartsWithIgnoreCase(paramCharSequence, paramInt, iValue)) {
        return paramInt + iValue.length();
      }
      return paramInt ^ 0xFFFFFFFF;
    }
  }
  
  static abstract class NumberFormatter
    implements InternalPrinter, InternalParser
  {
    protected final DateTimeFieldType iFieldType;
    protected final int iMaxParsedDigits;
    protected final boolean iSigned;
    
    NumberFormatter(DateTimeFieldType paramDateTimeFieldType, int paramInt, boolean paramBoolean)
    {
      iFieldType = paramDateTimeFieldType;
      iMaxParsedDigits = paramInt;
      iSigned = paramBoolean;
    }
    
    public int estimateParsedLength()
    {
      return iMaxParsedDigits;
    }
    
    public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
    {
      int i = Math.min(iMaxParsedDigits, paramCharSequence.length() - paramInt);
      
      int j = 0;
      int k = 0;
      int m = 0;
      int n;
      while (m < i)
      {
        n = paramCharSequence.charAt(paramInt + m);
        if ((m == 0) && ((n == 45) || (n == 43)) && (iSigned))
        {
          j = n == 45 ? 1 : 0;
          k = n == 43 ? 1 : 0;
          if ((m + 1 >= i) || ((n = paramCharSequence.charAt(paramInt + m + 1)) < '0') || (n > 57)) {
            break;
          }
          m++;
          
          i = Math.min(i + 1, paramCharSequence.length() - paramInt);
        }
        else
        {
          if ((n < 48) || (n > 57)) {
            break;
          }
          m++;
        }
      }
      if (m == 0) {
        return paramInt ^ 0xFFFFFFFF;
      }
      if (m >= 9)
      {
        if (k != 0) {
          n = Integer.parseInt(paramCharSequence.subSequence(paramInt + 1, paramInt += m).toString());
        } else {
          n = Integer.parseInt(paramCharSequence.subSequence(paramInt, paramInt += m).toString());
        }
      }
      else
      {
        int i1 = paramInt;
        if ((j != 0) || (k != 0)) {
          i1++;
        }
        try
        {
          n = paramCharSequence.charAt(i1++) - '0';
        }
        catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
        {
          return paramInt ^ 0xFFFFFFFF;
        }
        paramInt += m;
        while (i1 < paramInt) {
          n = (n << 3) + (n << 1) + paramCharSequence.charAt(i1++) - 48;
        }
        if (j != 0) {
          n = -n;
        }
      }
      paramDateTimeParserBucket.saveField(iFieldType, n);
      return paramInt;
    }
  }
  
  static class UnpaddedNumber
    extends DateTimeFormatterBuilder.NumberFormatter
  {
    protected UnpaddedNumber(DateTimeFieldType paramDateTimeFieldType, int paramInt, boolean paramBoolean)
    {
      super(paramInt, paramBoolean);
    }
    
    public int estimatePrintedLength()
    {
      return iMaxParsedDigits;
    }
    
    public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
      throws IOException
    {
      try
      {
        DateTimeField localDateTimeField = iFieldType.getField(paramChronology);
        FormatUtils.appendUnpaddedInteger(paramAppendable, localDateTimeField.get(paramLong));
      }
      catch (RuntimeException localRuntimeException)
      {
        paramAppendable.append(65533);
      }
    }
    
    public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
      throws IOException
    {
      if (paramReadablePartial.isSupported(iFieldType)) {
        try
        {
          FormatUtils.appendUnpaddedInteger(paramAppendable, paramReadablePartial.get(iFieldType));
        }
        catch (RuntimeException localRuntimeException)
        {
          paramAppendable.append(65533);
        }
      } else {
        paramAppendable.append(65533);
      }
    }
  }
  
  static class PaddedNumber
    extends DateTimeFormatterBuilder.NumberFormatter
  {
    protected final int iMinPrintedDigits;
    
    protected PaddedNumber(DateTimeFieldType paramDateTimeFieldType, int paramInt1, boolean paramBoolean, int paramInt2)
    {
      super(paramInt1, paramBoolean);
      iMinPrintedDigits = paramInt2;
    }
    
    public int estimatePrintedLength()
    {
      return iMaxParsedDigits;
    }
    
    public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
      throws IOException
    {
      try
      {
        DateTimeField localDateTimeField = iFieldType.getField(paramChronology);
        FormatUtils.appendPaddedInteger(paramAppendable, localDateTimeField.get(paramLong), iMinPrintedDigits);
      }
      catch (RuntimeException localRuntimeException)
      {
        DateTimeFormatterBuilder.appendUnknownString(paramAppendable, iMinPrintedDigits);
      }
    }
    
    public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
      throws IOException
    {
      if (paramReadablePartial.isSupported(iFieldType)) {
        try
        {
          FormatUtils.appendPaddedInteger(paramAppendable, paramReadablePartial.get(iFieldType), iMinPrintedDigits);
        }
        catch (RuntimeException localRuntimeException)
        {
          DateTimeFormatterBuilder.appendUnknownString(paramAppendable, iMinPrintedDigits);
        }
      } else {
        DateTimeFormatterBuilder.appendUnknownString(paramAppendable, iMinPrintedDigits);
      }
    }
  }
  
  static class FixedNumber
    extends DateTimeFormatterBuilder.PaddedNumber
  {
    protected FixedNumber(DateTimeFieldType paramDateTimeFieldType, int paramInt, boolean paramBoolean)
    {
      super(paramInt, paramBoolean, paramInt);
    }
    
    public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
    {
      int i = super.parseInto(paramDateTimeParserBucket, paramCharSequence, paramInt);
      if (i < 0) {
        return i;
      }
      int j = paramInt + iMaxParsedDigits;
      if (i != j)
      {
        if (iSigned)
        {
          int k = paramCharSequence.charAt(paramInt);
          if ((k == 45) || (k == 43)) {
            j++;
          }
        }
        if (i > j) {
          return j + 1 ^ 0xFFFFFFFF;
        }
        if (i < j) {
          return i ^ 0xFFFFFFFF;
        }
      }
      return i;
    }
  }
  
  static class TwoDigitYear
    implements InternalPrinter, InternalParser
  {
    private final DateTimeFieldType iType;
    private final int iPivot;
    private final boolean iLenientParse;
    
    TwoDigitYear(DateTimeFieldType paramDateTimeFieldType, int paramInt, boolean paramBoolean)
    {
      iType = paramDateTimeFieldType;
      iPivot = paramInt;
      iLenientParse = paramBoolean;
    }
    
    public int estimateParsedLength()
    {
      return iLenientParse ? 4 : 2;
    }
    
    public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
    {
      int i = paramCharSequence.length() - paramInt;
      int i1;
      if (!iLenientParse)
      {
        i = Math.min(2, i);
        if (i < 2) {
          return paramInt ^ 0xFFFFFFFF;
        }
      }
      else
      {
        j = 0;
        k = 0;
        m = 0;
        while (m < i)
        {
          n = paramCharSequence.charAt(paramInt + m);
          if ((m == 0) && ((n == 45) || (n == 43)))
          {
            j = 1;
            k = n == 45 ? 1 : 0;
            if (k != 0)
            {
              m++;
            }
            else
            {
              paramInt++;
              i--;
            }
          }
          else
          {
            if ((n < 48) || (n > 57)) {
              break;
            }
            m++;
          }
        }
        if (m == 0) {
          return paramInt ^ 0xFFFFFFFF;
        }
        if ((j != 0) || (m != 2))
        {
          if (m >= 9)
          {
            n = Integer.parseInt(paramCharSequence.subSequence(paramInt, paramInt += m).toString());
          }
          else
          {
            i1 = paramInt;
            if (k != 0) {
              i1++;
            }
            try
            {
              n = paramCharSequence.charAt(i1++) - '0';
            }
            catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
            {
              return paramInt ^ 0xFFFFFFFF;
            }
            paramInt += m;
            while (i1 < paramInt) {
              n = (n << 3) + (n << 1) + paramCharSequence.charAt(i1++) - 48;
            }
            if (k != 0) {
              n = -n;
            }
          }
          paramDateTimeParserBucket.saveField(iType, n);
          return paramInt;
        }
      }
      int k = paramCharSequence.charAt(paramInt);
      if ((k < 48) || (k > 57)) {
        return paramInt ^ 0xFFFFFFFF;
      }
      int j = k - 48;
      k = paramCharSequence.charAt(paramInt + 1);
      if ((k < 48) || (k > 57)) {
        return paramInt ^ 0xFFFFFFFF;
      }
      j = (j << 3) + (j << 1) + k - 48;
      
      int m = iPivot;
      if (paramDateTimeParserBucket.getPivotYear() != null) {
        m = paramDateTimeParserBucket.getPivotYear().intValue();
      }
      int n = m - 50;
      if (n >= 0) {
        i1 = n % 100;
      } else {
        i1 = 99 + (n + 1) % 100;
      }
      j += n + (j < i1 ? 100 : 0) - i1;
      
      paramDateTimeParserBucket.saveField(iType, j);
      return paramInt + 2;
    }
    
    public int estimatePrintedLength()
    {
      return 2;
    }
    
    public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
      throws IOException
    {
      int i = getTwoDigitYear(paramLong, paramChronology);
      if (i < 0)
      {
        paramAppendable.append(65533);
        paramAppendable.append(65533);
      }
      else
      {
        FormatUtils.appendPaddedInteger(paramAppendable, i, 2);
      }
    }
    
    private int getTwoDigitYear(long paramLong, Chronology paramChronology)
    {
      try
      {
        int i = iType.getField(paramChronology).get(paramLong);
        if (i < 0) {
          i = -i;
        }
        return i % 100;
      }
      catch (RuntimeException localRuntimeException) {}
      return -1;
    }
    
    public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
      throws IOException
    {
      int i = getTwoDigitYear(paramReadablePartial);
      if (i < 0)
      {
        paramAppendable.append(65533);
        paramAppendable.append(65533);
      }
      else
      {
        FormatUtils.appendPaddedInteger(paramAppendable, i, 2);
      }
    }
    
    private int getTwoDigitYear(ReadablePartial paramReadablePartial)
    {
      if (paramReadablePartial.isSupported(iType)) {
        try
        {
          int i = paramReadablePartial.get(iType);
          if (i < 0) {
            i = -i;
          }
          return i % 100;
        }
        catch (RuntimeException localRuntimeException) {}
      }
      return -1;
    }
  }
  
  static class TextField
    implements InternalPrinter, InternalParser
  {
    private static Map<Locale, Map<DateTimeFieldType, Object[]>> cParseCache = new ConcurrentHashMap();
    private final DateTimeFieldType iFieldType;
    private final boolean iShort;
    
    TextField(DateTimeFieldType paramDateTimeFieldType, boolean paramBoolean)
    {
      iFieldType = paramDateTimeFieldType;
      iShort = paramBoolean;
    }
    
    public int estimatePrintedLength()
    {
      return iShort ? 6 : 20;
    }
    
    public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
      throws IOException
    {
      try
      {
        paramAppendable.append(print(paramLong, paramChronology, paramLocale));
      }
      catch (RuntimeException localRuntimeException)
      {
        paramAppendable.append(65533);
      }
    }
    
    public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
      throws IOException
    {
      try
      {
        paramAppendable.append(print(paramReadablePartial, paramLocale));
      }
      catch (RuntimeException localRuntimeException)
      {
        paramAppendable.append(65533);
      }
    }
    
    private String print(long paramLong, Chronology paramChronology, Locale paramLocale)
    {
      DateTimeField localDateTimeField = iFieldType.getField(paramChronology);
      if (iShort) {
        return localDateTimeField.getAsShortText(paramLong, paramLocale);
      }
      return localDateTimeField.getAsText(paramLong, paramLocale);
    }
    
    private String print(ReadablePartial paramReadablePartial, Locale paramLocale)
    {
      if (paramReadablePartial.isSupported(iFieldType))
      {
        DateTimeField localDateTimeField = iFieldType.getField(paramReadablePartial.getChronology());
        if (iShort) {
          return localDateTimeField.getAsShortText(paramReadablePartial, paramLocale);
        }
        return localDateTimeField.getAsText(paramReadablePartial, paramLocale);
      }
      return "�";
    }
    
    public int estimateParsedLength()
    {
      return estimatePrintedLength();
    }
    
    public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
    {
      Locale localLocale = paramDateTimeParserBucket.getLocale();
      
      Object localObject1 = null;
      int i = 0;
      Object localObject2 = (Map)cParseCache.get(localLocale);
      if (localObject2 == null)
      {
        localObject2 = new ConcurrentHashMap();
        cParseCache.put(localLocale, localObject2);
      }
      Object[] arrayOfObject = (Object[])((Map)localObject2).get(iFieldType);
      if (arrayOfObject == null)
      {
        localObject1 = new ConcurrentHashMap(32);
        MutableDateTime localMutableDateTime = new MutableDateTime(0L, DateTimeZone.UTC);
        localProperty2 = localMutableDateTime.property(iFieldType);
        int j = localProperty2.getMinimumValueOverall();
        int k = localProperty2.getMaximumValueOverall();
        if (k - j > 32) {
          return paramInt ^ 0xFFFFFFFF;
        }
        i = localProperty2.getMaximumTextLength(localLocale);
        for (int m = j; m <= k; m++)
        {
          localProperty2.set(m);
          ((Map)localObject1).put(localProperty2.getAsShortText(localLocale), Boolean.TRUE);
          ((Map)localObject1).put(localProperty2.getAsShortText(localLocale).toLowerCase(localLocale), Boolean.TRUE);
          ((Map)localObject1).put(localProperty2.getAsShortText(localLocale).toUpperCase(localLocale), Boolean.TRUE);
          ((Map)localObject1).put(localProperty2.getAsText(localLocale), Boolean.TRUE);
          ((Map)localObject1).put(localProperty2.getAsText(localLocale).toLowerCase(localLocale), Boolean.TRUE);
          ((Map)localObject1).put(localProperty2.getAsText(localLocale).toUpperCase(localLocale), Boolean.TRUE);
        }
        if (("en".equals(localLocale.getLanguage())) && (iFieldType == DateTimeFieldType.era()))
        {
          ((Map)localObject1).put("BCE", Boolean.TRUE);
          ((Map)localObject1).put("bce", Boolean.TRUE);
          ((Map)localObject1).put("CE", Boolean.TRUE);
          ((Map)localObject1).put("ce", Boolean.TRUE);
          i = 3;
        }
        arrayOfObject = new Object[] { localObject1, Integer.valueOf(i) };
        ((Map)localObject2).put(iFieldType, arrayOfObject);
      }
      else
      {
        localObject1 = (Map)arrayOfObject[0];
        i = ((Integer)arrayOfObject[1]).intValue();
      }
      MutableDateTime.Property localProperty1 = Math.min(paramCharSequence.length(), paramInt + i);
      for (MutableDateTime.Property localProperty2 = localProperty1; localProperty2 > paramInt; localProperty2--)
      {
        String str = paramCharSequence.subSequence(paramInt, localProperty2).toString();
        if (((Map)localObject1).containsKey(str))
        {
          paramDateTimeParserBucket.saveField(iFieldType, str, localLocale);
          return localProperty2;
        }
      }
      return paramInt ^ 0xFFFFFFFF;
    }
  }
  
  static class Fraction
    implements InternalPrinter, InternalParser
  {
    private final DateTimeFieldType iFieldType;
    protected int iMinDigits;
    protected int iMaxDigits;
    
    protected Fraction(DateTimeFieldType paramDateTimeFieldType, int paramInt1, int paramInt2)
    {
      iFieldType = paramDateTimeFieldType;
      if (paramInt2 > 18) {
        paramInt2 = 18;
      }
      iMinDigits = paramInt1;
      iMaxDigits = paramInt2;
    }
    
    public int estimatePrintedLength()
    {
      return iMaxDigits;
    }
    
    public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
      throws IOException
    {
      printTo(paramAppendable, paramLong, paramChronology);
    }
    
    public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
      throws IOException
    {
      long l = paramReadablePartial.getChronology().set(paramReadablePartial, 0L);
      printTo(paramAppendable, l, paramReadablePartial.getChronology());
    }
    
    protected void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology)
      throws IOException
    {
      DateTimeField localDateTimeField = iFieldType.getField(paramChronology);
      int i = iMinDigits;
      long l1;
      try
      {
        l1 = localDateTimeField.remainder(paramLong);
      }
      catch (RuntimeException localRuntimeException)
      {
        DateTimeFormatterBuilder.appendUnknownString(paramAppendable, i);
        return;
      }
      if (l1 == 0L)
      {
        for (;;)
        {
          i--;
          if (i < 0) {
            break;
          }
          paramAppendable.append('0');
        }
        return;
      }
      long[] arrayOfLong = getFractionData(l1, localDateTimeField);
      long l2 = arrayOfLong[0];
      int j = (int)arrayOfLong[1];
      String str;
      if ((l2 & 0x7FFFFFFF) == l2) {
        str = Integer.toString((int)l2);
      } else {
        str = Long.toString(l2);
      }
      int k = str.length();
      int m = j;
      while (k < m)
      {
        paramAppendable.append('0');
        i--;
        m--;
      }
      if (i < m)
      {
        while ((i < m) && 
          (k > 1) && (str.charAt(k - 1) == '0'))
        {
          m--;
          k--;
        }
        if (k < str.length())
        {
          for (int n = 0; n < k; n++) {
            paramAppendable.append(str.charAt(n));
          }
          return;
        }
      }
      paramAppendable.append(str);
    }
    
    private long[] getFractionData(long paramLong, DateTimeField paramDateTimeField)
    {
      long l1 = paramDateTimeField.getDurationField().getUnitMillis();
      
      int i = iMaxDigits;
      long l2;
      for (;;)
      {
        switch (i)
        {
        default: 
          l2 = 1L; break;
        case 1: 
          l2 = 10L; break;
        case 2: 
          l2 = 100L; break;
        case 3: 
          l2 = 1000L; break;
        case 4: 
          l2 = 10000L; break;
        case 5: 
          l2 = 100000L; break;
        case 6: 
          l2 = 1000000L; break;
        case 7: 
          l2 = 10000000L; break;
        case 8: 
          l2 = 100000000L; break;
        case 9: 
          l2 = 1000000000L; break;
        case 10: 
          l2 = 10000000000L; break;
        case 11: 
          l2 = 100000000000L; break;
        case 12: 
          l2 = 1000000000000L; break;
        case 13: 
          l2 = 10000000000000L; break;
        case 14: 
          l2 = 100000000000000L; break;
        case 15: 
          l2 = 1000000000000000L; break;
        case 16: 
          l2 = 10000000000000000L; break;
        case 17: 
          l2 = 100000000000000000L; break;
        case 18: 
          l2 = 1000000000000000000L;
        }
        if (l1 * l2 / l2 == l1) {
          break;
        }
        i--;
      }
      return new long[] { paramLong * l2 / l1, i };
    }
    
    public int estimateParsedLength()
    {
      return iMaxDigits;
    }
    
    public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
    {
      DateTimeField localDateTimeField = iFieldType.getField(paramDateTimeParserBucket.getChronology());
      
      int i = Math.min(iMaxDigits, paramCharSequence.length() - paramInt);
      
      long l1 = 0L;
      long l2 = localDateTimeField.getDurationField().getUnitMillis() * 10L;
      int j = 0;
      while (j < i)
      {
        int k = paramCharSequence.charAt(paramInt + j);
        if ((k < 48) || (k > 57)) {
          break;
        }
        j++;
        long l3 = l2 / 10L;
        l1 += (k - 48) * l3;
        l2 = l3;
      }
      l1 /= 10L;
      if (j == 0) {
        return paramInt ^ 0xFFFFFFFF;
      }
      if (l1 > 2147483647L) {
        return paramInt ^ 0xFFFFFFFF;
      }
      PreciseDateTimeField localPreciseDateTimeField = new PreciseDateTimeField(DateTimeFieldType.millisOfSecond(), MillisDurationField.INSTANCE, localDateTimeField.getDurationField());
      
      paramDateTimeParserBucket.saveField(localPreciseDateTimeField, (int)l1);
      
      return paramInt + j;
    }
  }
  
  static class TimeZoneOffset
    implements InternalPrinter, InternalParser
  {
    private final String iZeroOffsetPrintText;
    private final String iZeroOffsetParseText;
    private final boolean iShowSeparators;
    private final int iMinFields;
    private final int iMaxFields;
    
    TimeZoneOffset(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
    {
      iZeroOffsetPrintText = paramString1;
      iZeroOffsetParseText = paramString2;
      iShowSeparators = paramBoolean;
      if ((paramInt1 <= 0) || (paramInt2 < paramInt1)) {
        throw new IllegalArgumentException();
      }
      if (paramInt1 > 4)
      {
        paramInt1 = 4;
        paramInt2 = 4;
      }
      iMinFields = paramInt1;
      iMaxFields = paramInt2;
    }
    
    public int estimatePrintedLength()
    {
      int i = 1 + iMinFields << 1;
      if (iShowSeparators) {
        i += iMinFields - 1;
      }
      if ((iZeroOffsetPrintText != null) && (iZeroOffsetPrintText.length() > i)) {
        i = iZeroOffsetPrintText.length();
      }
      return i;
    }
    
    public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
      throws IOException
    {
      if (paramDateTimeZone == null) {
        return;
      }
      if ((paramInt == 0) && (iZeroOffsetPrintText != null))
      {
        paramAppendable.append(iZeroOffsetPrintText);
        return;
      }
      if (paramInt >= 0)
      {
        paramAppendable.append('+');
      }
      else
      {
        paramAppendable.append('-');
        paramInt = -paramInt;
      }
      int i = paramInt / 3600000;
      FormatUtils.appendPaddedInteger(paramAppendable, i, 2);
      if (iMaxFields == 1) {
        return;
      }
      paramInt -= i * 3600000;
      if ((paramInt == 0) && (iMinFields <= 1)) {
        return;
      }
      int j = paramInt / 60000;
      if (iShowSeparators) {
        paramAppendable.append(':');
      }
      FormatUtils.appendPaddedInteger(paramAppendable, j, 2);
      if (iMaxFields == 2) {
        return;
      }
      paramInt -= j * 60000;
      if ((paramInt == 0) && (iMinFields <= 2)) {
        return;
      }
      int k = paramInt / 1000;
      if (iShowSeparators) {
        paramAppendable.append(':');
      }
      FormatUtils.appendPaddedInteger(paramAppendable, k, 2);
      if (iMaxFields == 3) {
        return;
      }
      paramInt -= k * 1000;
      if ((paramInt == 0) && (iMinFields <= 3)) {
        return;
      }
      if (iShowSeparators) {
        paramAppendable.append('.');
      }
      FormatUtils.appendPaddedInteger(paramAppendable, paramInt, 3);
    }
    
    public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
      throws IOException
    {}
    
    public int estimateParsedLength()
    {
      return estimatePrintedLength();
    }
    
    public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
    {
      int i = paramCharSequence.length() - paramInt;
      int j;
      if (iZeroOffsetParseText != null) {
        if (iZeroOffsetParseText.length() == 0)
        {
          if (i > 0)
          {
            j = paramCharSequence.charAt(paramInt);
            if ((j == 45) || (j == 43)) {}
          }
          else
          {
            paramDateTimeParserBucket.setOffset(Integer.valueOf(0));
            return paramInt;
          }
        }
        else if (DateTimeFormatterBuilder.csStartsWithIgnoreCase(paramCharSequence, paramInt, iZeroOffsetParseText))
        {
          paramDateTimeParserBucket.setOffset(Integer.valueOf(0));
          return paramInt + iZeroOffsetParseText.length();
        }
      }
      if (i <= 1) {
        return paramInt ^ 0xFFFFFFFF;
      }
      int k = paramCharSequence.charAt(paramInt);
      if (k == 45) {
        j = 1;
      } else if (k == 43) {
        j = 0;
      } else {
        return paramInt ^ 0xFFFFFFFF;
      }
      i--;
      paramInt++;
      if (digitCount(paramCharSequence, paramInt, 2) < 2) {
        return paramInt ^ 0xFFFFFFFF;
      }
      int m = FormatUtils.parseTwoDigits(paramCharSequence, paramInt);
      if (m > 23) {
        return paramInt ^ 0xFFFFFFFF;
      }
      int n = m * 3600000;
      i -= 2;
      paramInt += 2;
      if (i > 0)
      {
        k = paramCharSequence.charAt(paramInt);
        int i1;
        if (k == 58)
        {
          i1 = 1;
          i--;
          paramInt++;
        }
        else
        {
          if ((k < 48) || (k > 57)) {
            break label569;
          }
          i1 = 0;
        }
        int i2 = digitCount(paramCharSequence, paramInt, 2);
        if ((i2 != 0) || (i1 != 0))
        {
          if (i2 < 2) {
            return paramInt ^ 0xFFFFFFFF;
          }
          int i3 = FormatUtils.parseTwoDigits(paramCharSequence, paramInt);
          if (i3 > 59) {
            return paramInt ^ 0xFFFFFFFF;
          }
          n += i3 * 60000;
          i -= 2;
          paramInt += 2;
          if (i > 0) {
            if (i1 != 0)
            {
              if (paramCharSequence.charAt(paramInt) == ':')
              {
                i--;
                paramInt++;
              }
            }
            else
            {
              i2 = digitCount(paramCharSequence, paramInt, 2);
              if ((i2 != 0) || (i1 != 0))
              {
                if (i2 < 2) {
                  return paramInt ^ 0xFFFFFFFF;
                }
                int i4 = FormatUtils.parseTwoDigits(paramCharSequence, paramInt);
                if (i4 > 59) {
                  return paramInt ^ 0xFFFFFFFF;
                }
                n += i4 * 1000;
                i -= 2;
                paramInt += 2;
                if (i > 0) {
                  if (i1 != 0)
                  {
                    if ((paramCharSequence.charAt(paramInt) == '.') || (paramCharSequence.charAt(paramInt) == ','))
                    {
                      i--;
                      paramInt++;
                    }
                  }
                  else
                  {
                    i2 = digitCount(paramCharSequence, paramInt, 3);
                    if ((i2 != 0) || (i1 != 0))
                    {
                      if (i2 < 1) {
                        return paramInt ^ 0xFFFFFFFF;
                      }
                      n += (paramCharSequence.charAt(paramInt++) - '0') * 100;
                      if (i2 > 1)
                      {
                        n += (paramCharSequence.charAt(paramInt++) - '0') * 10;
                        if (i2 > 2) {
                          n += paramCharSequence.charAt(paramInt++) - '0';
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label569:
      paramDateTimeParserBucket.setOffset(Integer.valueOf(j != 0 ? -n : n));
      return paramInt;
    }
    
    private int digitCount(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    {
      int i = Math.min(paramCharSequence.length() - paramInt1, paramInt2);
      paramInt2 = 0;
      for (; i > 0; i--)
      {
        int j = paramCharSequence.charAt(paramInt1 + paramInt2);
        if ((j < 48) || (j > 57)) {
          break;
        }
        paramInt2++;
      }
      return paramInt2;
    }
  }
  
  static class TimeZoneName
    implements InternalPrinter, InternalParser
  {
    static final int LONG_NAME = 0;
    static final int SHORT_NAME = 1;
    private final Map<String, DateTimeZone> iParseLookup;
    private final int iType;
    
    TimeZoneName(int paramInt, Map<String, DateTimeZone> paramMap)
    {
      iType = paramInt;
      iParseLookup = paramMap;
    }
    
    public int estimatePrintedLength()
    {
      return iType == 1 ? 4 : 20;
    }
    
    public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
      throws IOException
    {
      paramAppendable.append(print(paramLong - paramInt, paramDateTimeZone, paramLocale));
    }
    
    private String print(long paramLong, DateTimeZone paramDateTimeZone, Locale paramLocale)
    {
      if (paramDateTimeZone == null) {
        return "";
      }
      switch (iType)
      {
      case 0: 
        return paramDateTimeZone.getName(paramLong, paramLocale);
      case 1: 
        return paramDateTimeZone.getShortName(paramLong, paramLocale);
      }
      return "";
    }
    
    public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
      throws IOException
    {}
    
    public int estimateParsedLength()
    {
      return iType == 1 ? 4 : 20;
    }
    
    public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
    {
      Map localMap = iParseLookup;
      localMap = localMap != null ? localMap : DateTimeUtils.getDefaultTimeZoneNames();
      Object localObject = null;
      for (String str : localMap.keySet()) {
        if ((DateTimeFormatterBuilder.csStartsWith(paramCharSequence, paramInt, str)) && (
          (localObject == null) || (str.length() > ((String)localObject).length()))) {
          localObject = str;
        }
      }
      if (localObject != null)
      {
        paramDateTimeParserBucket.setZone((DateTimeZone)localMap.get(localObject));
        return paramInt + ((String)localObject).length();
      }
      return paramInt ^ 0xFFFFFFFF;
    }
  }
  
  static enum TimeZoneId
    implements InternalPrinter, InternalParser
  {
    INSTANCE;
    
    private static final List<String> ALL_IDS;
    static final int MAX_LENGTH;
    
    static
    {
      ALL_IDS = new ArrayList(DateTimeZone.getAvailableIDs());
      Collections.sort(ALL_IDS);
      
      int i = 0;
      for (String str : ALL_IDS) {
        i = Math.max(i, str.length());
      }
      MAX_LENGTH = i;
    }
    
    public int estimatePrintedLength()
    {
      return MAX_LENGTH;
    }
    
    public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
      throws IOException
    {
      paramAppendable.append(paramDateTimeZone != null ? paramDateTimeZone.getID() : "");
    }
    
    public int estimateParsedLength()
    {
      return MAX_LENGTH;
    }
    
    public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
    {
      Object localObject = null;
      int i = prefixedStartPosition(paramCharSequence, paramInt);
      for (int j = i; j < ALL_IDS.size(); j++)
      {
        String str = (String)ALL_IDS.get(j);
        if (!DateTimeFormatterBuilder.csStartsWith(paramCharSequence, paramInt, str)) {
          break;
        }
        if ((localObject == null) || (str.length() > ((String)localObject).length())) {
          localObject = str;
        }
      }
      if (localObject != null)
      {
        paramDateTimeParserBucket.setZone(DateTimeZone.forID((String)localObject));
        return paramInt + ((String)localObject).length();
      }
      return paramInt ^ 0xFFFFFFFF;
    }
    
    private static int prefixedStartPosition(CharSequence paramCharSequence, int paramInt)
    {
      int i = 0;
      int j = ALL_IDS.size() - 1;
      while (i <= j)
      {
        int k = i + j >>> 1;
        String str = (String)ALL_IDS.get(k);
        int m = DateTimeFormatterBuilder.csCompare(paramCharSequence, paramInt, str);
        if (m > 0) {
          j = k - 1;
        } else if (m < 0) {
          i = k + 1;
        } else {
          return k;
        }
      }
      return i;
    }
    
    private TimeZoneId() {}
    
    public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
      throws IOException
    {}
  }
  
  static class Composite
    implements InternalPrinter, InternalParser
  {
    private final InternalPrinter[] iPrinters;
    private final InternalParser[] iParsers;
    private final int iPrintedLengthEstimate;
    private final int iParsedLengthEstimate;
    
    Composite(List<Object> paramList)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      
      decompose(paramList, localArrayList1, localArrayList2);
      int i;
      int j;
      int k;
      Object localObject;
      if ((localArrayList1.contains(null)) || (localArrayList1.isEmpty()))
      {
        iPrinters = null;
        iPrintedLengthEstimate = 0;
      }
      else
      {
        i = localArrayList1.size();
        iPrinters = new InternalPrinter[i];
        j = 0;
        for (k = 0; k < i; k++)
        {
          localObject = (InternalPrinter)localArrayList1.get(k);
          j += ((InternalPrinter)localObject).estimatePrintedLength();
          iPrinters[k] = localObject;
        }
        iPrintedLengthEstimate = j;
      }
      if ((localArrayList2.contains(null)) || (localArrayList2.isEmpty()))
      {
        iParsers = null;
        iParsedLengthEstimate = 0;
      }
      else
      {
        i = localArrayList2.size();
        iParsers = new InternalParser[i];
        j = 0;
        for (k = 0; k < i; k++)
        {
          localObject = (InternalParser)localArrayList2.get(k);
          j += ((InternalParser)localObject).estimateParsedLength();
          iParsers[k] = localObject;
        }
        iParsedLengthEstimate = j;
      }
    }
    
    public int estimatePrintedLength()
    {
      return iPrintedLengthEstimate;
    }
    
    public void printTo(Appendable paramAppendable, long paramLong, Chronology paramChronology, int paramInt, DateTimeZone paramDateTimeZone, Locale paramLocale)
      throws IOException
    {
      InternalPrinter[] arrayOfInternalPrinter = iPrinters;
      if (arrayOfInternalPrinter == null) {
        throw new UnsupportedOperationException();
      }
      if (paramLocale == null) {
        paramLocale = Locale.getDefault();
      }
      int i = arrayOfInternalPrinter.length;
      for (int j = 0; j < i; j++) {
        arrayOfInternalPrinter[j].printTo(paramAppendable, paramLong, paramChronology, paramInt, paramDateTimeZone, paramLocale);
      }
    }
    
    public void printTo(Appendable paramAppendable, ReadablePartial paramReadablePartial, Locale paramLocale)
      throws IOException
    {
      InternalPrinter[] arrayOfInternalPrinter = iPrinters;
      if (arrayOfInternalPrinter == null) {
        throw new UnsupportedOperationException();
      }
      if (paramLocale == null) {
        paramLocale = Locale.getDefault();
      }
      int i = arrayOfInternalPrinter.length;
      for (int j = 0; j < i; j++) {
        arrayOfInternalPrinter[j].printTo(paramAppendable, paramReadablePartial, paramLocale);
      }
    }
    
    public int estimateParsedLength()
    {
      return iParsedLengthEstimate;
    }
    
    public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
    {
      InternalParser[] arrayOfInternalParser = iParsers;
      if (arrayOfInternalParser == null) {
        throw new UnsupportedOperationException();
      }
      int i = arrayOfInternalParser.length;
      for (int j = 0; (j < i) && (paramInt >= 0); j++) {
        paramInt = arrayOfInternalParser[j].parseInto(paramDateTimeParserBucket, paramCharSequence, paramInt);
      }
      return paramInt;
    }
    
    boolean isPrinter()
    {
      return iPrinters != null;
    }
    
    boolean isParser()
    {
      return iParsers != null;
    }
    
    private void decompose(List<Object> paramList1, List<Object> paramList2, List<Object> paramList3)
    {
      int i = paramList1.size();
      for (int j = 0; j < i; j += 2)
      {
        Object localObject = paramList1.get(j);
        if ((localObject instanceof Composite)) {
          addArrayToList(paramList2, iPrinters);
        } else {
          paramList2.add(localObject);
        }
        localObject = paramList1.get(j + 1);
        if ((localObject instanceof Composite)) {
          addArrayToList(paramList3, iParsers);
        } else {
          paramList3.add(localObject);
        }
      }
    }
    
    private void addArrayToList(List<Object> paramList, Object[] paramArrayOfObject)
    {
      if (paramArrayOfObject != null) {
        for (int i = 0; i < paramArrayOfObject.length; i++) {
          paramList.add(paramArrayOfObject[i]);
        }
      }
    }
  }
  
  static class MatchingParser
    implements InternalParser
  {
    private final InternalParser[] iParsers;
    private final int iParsedLengthEstimate;
    
    MatchingParser(InternalParser[] paramArrayOfInternalParser)
    {
      iParsers = paramArrayOfInternalParser;
      int i = 0;
      int j = paramArrayOfInternalParser.length;
      for (;;)
      {
        j--;
        if (j < 0) {
          break;
        }
        InternalParser localInternalParser = paramArrayOfInternalParser[j];
        if (localInternalParser != null)
        {
          int k = localInternalParser.estimateParsedLength();
          if (k > i) {
            i = k;
          }
        }
      }
      iParsedLengthEstimate = i;
    }
    
    public int estimateParsedLength()
    {
      return iParsedLengthEstimate;
    }
    
    public int parseInto(DateTimeParserBucket paramDateTimeParserBucket, CharSequence paramCharSequence, int paramInt)
    {
      InternalParser[] arrayOfInternalParser = iParsers;
      int i = arrayOfInternalParser.length;
      
      Object localObject1 = paramDateTimeParserBucket.saveState();
      int j = 0;
      
      int k = paramInt;
      Object localObject2 = null;
      
      int m = paramInt;
      for (int n = 0; n < i; n++)
      {
        InternalParser localInternalParser = arrayOfInternalParser[n];
        if (localInternalParser == null)
        {
          if (k <= paramInt) {
            return paramInt;
          }
          j = 1;
          break;
        }
        int i1 = localInternalParser.parseInto(paramDateTimeParserBucket, paramCharSequence, paramInt);
        if (i1 >= paramInt)
        {
          if (i1 > k)
          {
            if ((i1 >= paramCharSequence.length()) || (n + 1 >= i) || (arrayOfInternalParser[(n + 1)] == null)) {
              return i1;
            }
            k = i1;
            localObject2 = paramDateTimeParserBucket.saveState();
          }
        }
        else if (i1 < 0)
        {
          i1 ^= 0xFFFFFFFF;
          if (i1 > m) {
            m = i1;
          }
        }
        paramDateTimeParserBucket.restoreState(localObject1);
      }
      if ((k > paramInt) || ((k == paramInt) && (j != 0)))
      {
        if (localObject2 != null) {
          paramDateTimeParserBucket.restoreState(localObject2);
        }
        return k;
      }
      return m ^ 0xFFFFFFFF;
    }
  }
  
  static int csCompare(CharSequence paramCharSequence, int paramInt, String paramString)
  {
    int i = paramCharSequence.length() - paramInt;
    int j = paramString.length();
    int k = Math.min(i, j);
    for (int m = 0; m < k; m++)
    {
      int n = paramString.charAt(m) - paramCharSequence.charAt(paramInt + m);
      if (n != 0) {
        return n;
      }
    }
    return j - i;
  }
  
  static boolean csStartsWith(CharSequence paramCharSequence, int paramInt, String paramString)
  {
    int i = paramString.length();
    if (paramCharSequence.length() - paramInt < i) {
      return false;
    }
    for (int j = 0; j < i; j++) {
      if (paramCharSequence.charAt(paramInt + j) != paramString.charAt(j)) {
        return false;
      }
    }
    return true;
  }
  
  static boolean csStartsWithIgnoreCase(CharSequence paramCharSequence, int paramInt, String paramString)
  {
    int i = paramString.length();
    if (paramCharSequence.length() - paramInt < i) {
      return false;
    }
    for (int j = 0; j < i; j++)
    {
      char c1 = paramCharSequence.charAt(paramInt + j);
      char c2 = paramString.charAt(j);
      if (c1 != c2)
      {
        char c3 = Character.toUpperCase(c1);
        char c4 = Character.toUpperCase(c2);
        if ((c3 != c4) && (Character.toLowerCase(c3) != Character.toLowerCase(c4))) {
          return false;
        }
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */