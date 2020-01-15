package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.log.InternalLogFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public enum JodaTime
{
  private static final boolean expectedBehavior = checkExpectedBehavior();
  
  private JodaTime() {}
  
  public static String getVersion()
  {
    return LazyHolder.version;
  }
  
  public static boolean hasExpectedBehavior()
  {
    return expectedBehavior;
  }
  
  private static class LazyHolder
  {
    static final String version = ;
    
    private static String getVersion()
    {
      try
      {
        JarFile jf = Classes.jarFileOf(DateTimeZone.class);
        if (jf == null) {
          return null;
        }
        Manifest mf = jf.getManifest();
        Attributes attrs = mf.getMainAttributes();
        String name = attrs.getValue("Bundle-Name");
        String version = attrs.getValue("Bundle-Version");
        if (("Joda-Time".equals(name)) && (version != null)) {
          return version;
        }
      }
      catch (Exception e)
      {
        InternalLogFactory.getLog(JodaTime.class).debug("FYI", e);
      }
      return null;
    }
  }
  
  private static boolean checkExpectedBehavior()
  {
    try
    {
      return (checkTT0031561767()) && 
        (checkFormatIso8601Date()) && 
        (checkFormatRfc822Date()) && 
        (checkAlternateIso8601DateFormat()) && 
        (checkInvalidDate()) && 
        (checkParseCompressedIso8601Date()) && 
        (checkParseIso8601Date()) && 
        (checkParseIso8601DateUsingAlternativeFormat()) && 
        (checkParseRfc822Date());
    }
    catch (Exception localException) {}
    return false;
  }
  
  private static boolean checkTT0031561767()
    throws ParseException
  {
    String input = "Fri, 16 May 2014 23:56:46 GMT";
    Date date = new Date(DateUtils.rfc822DateFormat.parseMillis(input));
    return input.equals(DateUtils.rfc822DateFormat.print(date.getTime()));
  }
  
  private static boolean checkFormatIso8601Date()
    throws ParseException
  {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    
    sdf.setTimeZone(new SimpleTimeZone(0, "GMT"));
    String expected = sdf.format(date);
    String actual = DateUtils.iso8601DateFormat.print(date.getTime());
    if (expected.equals(actual))
    {
      Date expectedDate = sdf.parse(expected);
      Date actualDate = DateUtils.doParseISO8601Date(actual);
      return expectedDate.equals(actualDate);
    }
    return false;
  }
  
  private static boolean checkFormatRfc822Date()
    throws ParseException
  {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    
    sdf.setTimeZone(new SimpleTimeZone(0, "GMT"));
    String expected = sdf.format(date);
    String actual = DateUtils.rfc822DateFormat.print(date.getTime());
    if (expected.equals(actual))
    {
      Date expectedDate = sdf.parse(expected);
      Date actualDate2 = new Date(DateUtils.rfc822DateFormat.parseMillis(actual));
      return expectedDate.equals(actualDate2);
    }
    return false;
  }
  
  private static boolean checkParseCompressedIso8601Date()
    throws ParseException
  {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
    sdf.setTimeZone(new SimpleTimeZone(0, "GMT"));
    String formatted = sdf.format(date);
    Date expected = sdf.parse(formatted);
    Date actual = new Date(DateUtils.compressedIso8601DateFormat.parseMillis(formatted));
    return expected.equals(actual);
  }
  
  private static boolean checkParseRfc822Date()
    throws ParseException
  {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
    
    sdf.setTimeZone(new SimpleTimeZone(0, "GMT"));
    String formatted = sdf.format(date);
    Date expected = sdf.parse(formatted);
    Date actual2 = new Date(DateUtils.rfc822DateFormat.parseMillis(formatted));
    return expected.equals(actual2);
  }
  
  private static boolean checkParseIso8601Date()
    throws ParseException
  {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    
    sdf.setTimeZone(new SimpleTimeZone(0, "GMT"));
    String formatted = sdf.format(date);
    String alternative = DateUtils.iso8601DateFormat.print(date.getTime());
    if (formatted.equals(alternative))
    {
      Date expectedDate = sdf.parse(formatted);
      Date actualDate = DateUtils.doParseISO8601Date(formatted);
      return expectedDate.equals(actualDate);
    }
    return false;
  }
  
  private static boolean checkParseIso8601DateUsingAlternativeFormat()
    throws ParseException
  {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    sdf.setTimeZone(new SimpleTimeZone(0, "GMT"));
    String formatted = sdf.format(date);
    String alternative = DateUtils.alternateIso8601DateFormat.print(date
      .getTime());
    if (formatted.equals(alternative))
    {
      Date expectedDate = sdf.parse(formatted);
      Date actualDate = DateUtils.parseISO8601Date(formatted);
      return expectedDate.equals(actualDate);
    }
    return false;
  }
  
  private static boolean checkAlternateIso8601DateFormat()
    throws ParseException
  {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    sdf.setTimeZone(new SimpleTimeZone(0, "GMT"));
    String expected = sdf.format(date);
    String actual = DateUtils.alternateIso8601DateFormat.print(date
      .getTime());
    if (expected.equals(actual))
    {
      Date expectedDate = sdf.parse(expected);
      
      DateTime actualDateTime = DateUtils.alternateIso8601DateFormat.parseDateTime(actual);
      return expectedDate.getTime() == actualDateTime.getMillis();
    }
    return false;
  }
  
  private static boolean checkInvalidDate()
  {
    String input = "2014-03-06T14:28:58.000Z.000Z";
    try
    {
      DateUtils.doParseISO8601Date("2014-03-06T14:28:58.000Z.000Z");
      return false;
    }
    catch (RuntimeException localRuntimeException) {}
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.JodaTime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */