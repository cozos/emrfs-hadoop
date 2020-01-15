package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.NumberInput;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class StdDateFormat
  extends DateFormat
{
  protected static final String DATE_FORMAT_STR_ISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
  protected static final String DATE_FORMAT_STR_ISO8601_Z = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  protected static final String DATE_FORMAT_STR_PLAIN = "yyyy-MM-dd";
  protected static final String DATE_FORMAT_STR_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
  protected static final String[] ALL_FORMATS = { "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd" };
  private static final TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone("GMT");
  private static final Locale DEFAULT_LOCALE = Locale.US;
  protected static final DateFormat DATE_FORMAT_RFC1123 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", DEFAULT_LOCALE);
  protected static final DateFormat DATE_FORMAT_ISO8601;
  protected static final DateFormat DATE_FORMAT_ISO8601_Z;
  protected static final DateFormat DATE_FORMAT_PLAIN;
  
  static
  {
    DATE_FORMAT_RFC1123.setTimeZone(DEFAULT_TIMEZONE);
    DATE_FORMAT_ISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", DEFAULT_LOCALE);
    DATE_FORMAT_ISO8601.setTimeZone(DEFAULT_TIMEZONE);
    DATE_FORMAT_ISO8601_Z = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", DEFAULT_LOCALE);
    DATE_FORMAT_ISO8601_Z.setTimeZone(DEFAULT_TIMEZONE);
    DATE_FORMAT_PLAIN = new SimpleDateFormat("yyyy-MM-dd", DEFAULT_LOCALE);
    DATE_FORMAT_PLAIN.setTimeZone(DEFAULT_TIMEZONE);
  }
  
  public static final StdDateFormat instance = new StdDateFormat();
  protected transient TimeZone _timezone;
  protected final Locale _locale;
  protected transient DateFormat _formatRFC1123;
  protected transient DateFormat _formatISO8601;
  protected transient DateFormat _formatISO8601_z;
  protected transient DateFormat _formatPlain;
  
  public StdDateFormat()
  {
    _locale = DEFAULT_LOCALE;
  }
  
  @Deprecated
  public StdDateFormat(TimeZone tz)
  {
    this(tz, DEFAULT_LOCALE);
  }
  
  public StdDateFormat(TimeZone tz, Locale loc)
  {
    _timezone = tz;
    _locale = loc;
  }
  
  public static TimeZone getDefaultTimeZone()
  {
    return DEFAULT_TIMEZONE;
  }
  
  public StdDateFormat withTimeZone(TimeZone tz)
  {
    if (tz == null) {
      tz = DEFAULT_TIMEZONE;
    }
    if ((tz == _timezone) || (tz.equals(_timezone))) {
      return this;
    }
    return new StdDateFormat(tz, _locale);
  }
  
  public StdDateFormat withLocale(Locale loc)
  {
    if (loc.equals(_locale)) {
      return this;
    }
    return new StdDateFormat(_timezone, loc);
  }
  
  public StdDateFormat clone()
  {
    return new StdDateFormat(_timezone, _locale);
  }
  
  @Deprecated
  public static DateFormat getBlueprintISO8601Format()
  {
    return DATE_FORMAT_ISO8601;
  }
  
  @Deprecated
  public static DateFormat getISO8601Format(TimeZone tz)
  {
    return getISO8601Format(tz, DEFAULT_LOCALE);
  }
  
  public static DateFormat getISO8601Format(TimeZone tz, Locale loc)
  {
    return _cloneFormat(DATE_FORMAT_ISO8601, "yyyy-MM-dd'T'HH:mm:ss.SSSZ", tz, loc);
  }
  
  @Deprecated
  public static DateFormat getBlueprintRFC1123Format()
  {
    return DATE_FORMAT_RFC1123;
  }
  
  public static DateFormat getRFC1123Format(TimeZone tz, Locale loc)
  {
    return _cloneFormat(DATE_FORMAT_RFC1123, "EEE, dd MMM yyyy HH:mm:ss zzz", tz, loc);
  }
  
  @Deprecated
  public static DateFormat getRFC1123Format(TimeZone tz)
  {
    return getRFC1123Format(tz, DEFAULT_LOCALE);
  }
  
  public TimeZone getTimeZone()
  {
    return _timezone;
  }
  
  public void setTimeZone(TimeZone tz)
  {
    if (!tz.equals(_timezone))
    {
      _formatRFC1123 = null;
      _formatISO8601 = null;
      _formatISO8601_z = null;
      _formatPlain = null;
      _timezone = tz;
    }
  }
  
  public Date parse(String dateStr)
    throws ParseException
  {
    dateStr = dateStr.trim();
    ParsePosition pos = new ParsePosition(0);
    Date result = parse(dateStr, pos);
    if (result != null) {
      return result;
    }
    StringBuilder sb = new StringBuilder();
    for (String f : ALL_FORMATS)
    {
      if (sb.length() > 0) {
        sb.append("\", \"");
      } else {
        sb.append('"');
      }
      sb.append(f);
    }
    sb.append('"');
    throw new ParseException(String.format("Can not parse date \"%s\": not compatible with any of standard forms (%s)", new Object[] { dateStr, sb.toString() }), pos.getErrorIndex());
  }
  
  public Date parse(String dateStr, ParsePosition pos)
  {
    if (looksLikeISO8601(dateStr)) {
      return parseAsISO8601(dateStr, pos);
    }
    int i = dateStr.length();
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      char ch = dateStr.charAt(i);
      if (((ch < '0') || (ch > '9')) && (
      
        (i > 0) || (ch != '-'))) {
        break;
      }
    }
    if (i < 0) {
      if ((dateStr.charAt(0) == '-') || (NumberInput.inLongRange(dateStr, false))) {
        return new Date(Long.parseLong(dateStr));
      }
    }
    return parseAsRFC1123(dateStr, pos);
  }
  
  public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition)
  {
    if (_formatISO8601 == null) {
      _formatISO8601 = _cloneFormat(DATE_FORMAT_ISO8601, "yyyy-MM-dd'T'HH:mm:ss.SSSZ", _timezone, _locale);
    }
    return _formatISO8601.format(date, toAppendTo, fieldPosition);
  }
  
  public String toString()
  {
    String str = "DateFormat " + getClass().getName();
    TimeZone tz = _timezone;
    if (tz != null) {
      str = str + " (timezone: " + tz + ")";
    }
    str = str + "(locale: " + _locale + ")";
    return str;
  }
  
  protected boolean looksLikeISO8601(String dateStr)
  {
    if ((dateStr.length() >= 5) && (Character.isDigit(dateStr.charAt(0))) && (Character.isDigit(dateStr.charAt(3))) && (dateStr.charAt(4) == '-')) {
      return true;
    }
    return false;
  }
  
  protected Date parseAsISO8601(String dateStr, ParsePosition pos)
  {
    int len = dateStr.length();
    char c = dateStr.charAt(len - 1);
    DateFormat df;
    if ((len <= 10) && (Character.isDigit(c)))
    {
      DateFormat df = _formatPlain;
      if (df == null) {
        df = _formatPlain = _cloneFormat(DATE_FORMAT_PLAIN, "yyyy-MM-dd", _timezone, _locale);
      }
    }
    else if (c == 'Z')
    {
      DateFormat df = _formatISO8601_z;
      if (df == null) {
        df = _formatISO8601_z = _cloneFormat(DATE_FORMAT_ISO8601_Z, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", _timezone, _locale);
      }
      if (dateStr.charAt(len - 4) == ':')
      {
        StringBuilder sb = new StringBuilder(dateStr);
        sb.insert(len - 1, ".000");
        dateStr = sb.toString();
      }
    }
    else if (hasTimeZone(dateStr))
    {
      c = dateStr.charAt(len - 3);
      if (c == ':')
      {
        StringBuilder sb = new StringBuilder(dateStr);
        sb.delete(len - 3, len - 2);
        dateStr = sb.toString();
      }
      else if ((c == '+') || (c == '-'))
      {
        dateStr = dateStr + "00";
      }
      len = dateStr.length();
      
      int timeLen = len - dateStr.lastIndexOf('T') - 6;
      if (timeLen < 12)
      {
        int offset = len - 5;
        StringBuilder sb = new StringBuilder(dateStr);
        switch (timeLen)
        {
        case 11: 
          sb.insert(offset, '0'); break;
        case 10: 
          sb.insert(offset, "00"); break;
        case 9: 
          sb.insert(offset, "000"); break;
        case 8: 
          sb.insert(offset, ".000"); break;
        case 7: 
          break;
        case 6: 
          sb.insert(offset, "00.000");
        case 5: 
          sb.insert(offset, ":00.000");
        }
        dateStr = sb.toString();
      }
      DateFormat df = _formatISO8601;
      if (_formatISO8601 == null) {
        df = _formatISO8601 = _cloneFormat(DATE_FORMAT_ISO8601, "yyyy-MM-dd'T'HH:mm:ss.SSSZ", _timezone, _locale);
      }
    }
    else
    {
      StringBuilder sb = new StringBuilder(dateStr);
      
      int timeLen = len - dateStr.lastIndexOf('T') - 1;
      if (timeLen < 12) {
        switch (timeLen)
        {
        case 11: 
          sb.append('0');
        case 10: 
          sb.append('0');
        case 9: 
          sb.append('0');
          break;
        default: 
          sb.append(".000");
        }
      }
      sb.append('Z');
      dateStr = sb.toString();
      df = _formatISO8601_z;
      if (df == null) {
        df = _formatISO8601_z = _cloneFormat(DATE_FORMAT_ISO8601_Z, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", _timezone, _locale);
      }
    }
    return df.parse(dateStr, pos);
  }
  
  protected Date parseAsRFC1123(String dateStr, ParsePosition pos)
  {
    if (_formatRFC1123 == null) {
      _formatRFC1123 = _cloneFormat(DATE_FORMAT_RFC1123, "EEE, dd MMM yyyy HH:mm:ss zzz", _timezone, _locale);
    }
    return _formatRFC1123.parse(dateStr, pos);
  }
  
  private static final boolean hasTimeZone(String str)
  {
    int len = str.length();
    if (len >= 6)
    {
      char c = str.charAt(len - 6);
      if ((c == '+') || (c == '-')) {
        return true;
      }
      c = str.charAt(len - 5);
      if ((c == '+') || (c == '-')) {
        return true;
      }
      c = str.charAt(len - 3);
      if ((c == '+') || (c == '-')) {
        return true;
      }
    }
    return false;
  }
  
  private static final DateFormat _cloneFormat(DateFormat df, String format, TimeZone tz, Locale loc)
  {
    if (!loc.equals(DEFAULT_LOCALE))
    {
      df = new SimpleDateFormat(format, loc);
      df.setTimeZone(tz == null ? DEFAULT_TIMEZONE : tz);
    }
    else
    {
      df = (DateFormat)df.clone();
      if (tz != null) {
        df.setTimeZone(tz);
      }
    }
    return df;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.StdDateFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */