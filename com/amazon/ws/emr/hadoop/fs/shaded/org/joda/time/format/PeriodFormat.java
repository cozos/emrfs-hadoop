package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadWritablePeriod;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.ReadablePeriod;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PeriodFormat
{
  private static final String BUNDLE_NAME = "com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.messages";
  private static final ConcurrentMap<Locale, PeriodFormatter> FORMATTERS = new ConcurrentHashMap();
  
  public static PeriodFormatter getDefault()
  {
    return wordBased(Locale.ENGLISH);
  }
  
  public static PeriodFormatter wordBased()
  {
    return wordBased(Locale.getDefault());
  }
  
  public static PeriodFormatter wordBased(Locale paramLocale)
  {
    Object localObject = (PeriodFormatter)FORMATTERS.get(paramLocale);
    if (localObject == null)
    {
      DynamicWordBased localDynamicWordBased = new DynamicWordBased(buildWordBased(paramLocale));
      localObject = new PeriodFormatter(localDynamicWordBased, localDynamicWordBased, paramLocale, null);
      PeriodFormatter localPeriodFormatter = (PeriodFormatter)FORMATTERS.putIfAbsent(paramLocale, localObject);
      if (localPeriodFormatter != null) {
        localObject = localPeriodFormatter;
      }
    }
    return (PeriodFormatter)localObject;
  }
  
  private static PeriodFormatter buildWordBased(Locale paramLocale)
  {
    ResourceBundle localResourceBundle = ResourceBundle.getBundle("com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.messages", paramLocale);
    if (containsKey(localResourceBundle, "PeriodFormat.regex.separator")) {
      return buildRegExFormatter(localResourceBundle, paramLocale);
    }
    return buildNonRegExFormatter(localResourceBundle, paramLocale);
  }
  
  private static PeriodFormatter buildRegExFormatter(ResourceBundle paramResourceBundle, Locale paramLocale)
  {
    String[] arrayOfString = retrieveVariants(paramResourceBundle);
    String str = paramResourceBundle.getString("PeriodFormat.regex.separator");
    
    PeriodFormatterBuilder localPeriodFormatterBuilder = new PeriodFormatterBuilder();
    localPeriodFormatterBuilder.appendYears();
    if (containsKey(paramResourceBundle, "PeriodFormat.years.regex")) {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.years.regex").split(str), paramResourceBundle.getString("PeriodFormat.years.list").split(str));
    } else {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.year"), paramResourceBundle.getString("PeriodFormat.years"));
    }
    localPeriodFormatterBuilder.appendSeparator(paramResourceBundle.getString("PeriodFormat.commaspace"), paramResourceBundle.getString("PeriodFormat.spaceandspace"), arrayOfString);
    localPeriodFormatterBuilder.appendMonths();
    if (containsKey(paramResourceBundle, "PeriodFormat.months.regex")) {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.months.regex").split(str), paramResourceBundle.getString("PeriodFormat.months.list").split(str));
    } else {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.month"), paramResourceBundle.getString("PeriodFormat.months"));
    }
    localPeriodFormatterBuilder.appendSeparator(paramResourceBundle.getString("PeriodFormat.commaspace"), paramResourceBundle.getString("PeriodFormat.spaceandspace"), arrayOfString);
    localPeriodFormatterBuilder.appendWeeks();
    if (containsKey(paramResourceBundle, "PeriodFormat.weeks.regex")) {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.weeks.regex").split(str), paramResourceBundle.getString("PeriodFormat.weeks.list").split(str));
    } else {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.week"), paramResourceBundle.getString("PeriodFormat.weeks"));
    }
    localPeriodFormatterBuilder.appendSeparator(paramResourceBundle.getString("PeriodFormat.commaspace"), paramResourceBundle.getString("PeriodFormat.spaceandspace"), arrayOfString);
    localPeriodFormatterBuilder.appendDays();
    if (containsKey(paramResourceBundle, "PeriodFormat.days.regex")) {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.days.regex").split(str), paramResourceBundle.getString("PeriodFormat.days.list").split(str));
    } else {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.day"), paramResourceBundle.getString("PeriodFormat.days"));
    }
    localPeriodFormatterBuilder.appendSeparator(paramResourceBundle.getString("PeriodFormat.commaspace"), paramResourceBundle.getString("PeriodFormat.spaceandspace"), arrayOfString);
    localPeriodFormatterBuilder.appendHours();
    if (containsKey(paramResourceBundle, "PeriodFormat.hours.regex")) {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.hours.regex").split(str), paramResourceBundle.getString("PeriodFormat.hours.list").split(str));
    } else {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.hour"), paramResourceBundle.getString("PeriodFormat.hours"));
    }
    localPeriodFormatterBuilder.appendSeparator(paramResourceBundle.getString("PeriodFormat.commaspace"), paramResourceBundle.getString("PeriodFormat.spaceandspace"), arrayOfString);
    localPeriodFormatterBuilder.appendMinutes();
    if (containsKey(paramResourceBundle, "PeriodFormat.minutes.regex")) {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.minutes.regex").split(str), paramResourceBundle.getString("PeriodFormat.minutes.list").split(str));
    } else {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.minute"), paramResourceBundle.getString("PeriodFormat.minutes"));
    }
    localPeriodFormatterBuilder.appendSeparator(paramResourceBundle.getString("PeriodFormat.commaspace"), paramResourceBundle.getString("PeriodFormat.spaceandspace"), arrayOfString);
    localPeriodFormatterBuilder.appendSeconds();
    if (containsKey(paramResourceBundle, "PeriodFormat.seconds.regex")) {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.seconds.regex").split(str), paramResourceBundle.getString("PeriodFormat.seconds.list").split(str));
    } else {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.second"), paramResourceBundle.getString("PeriodFormat.seconds"));
    }
    localPeriodFormatterBuilder.appendSeparator(paramResourceBundle.getString("PeriodFormat.commaspace"), paramResourceBundle.getString("PeriodFormat.spaceandspace"), arrayOfString);
    localPeriodFormatterBuilder.appendMillis();
    if (containsKey(paramResourceBundle, "PeriodFormat.milliseconds.regex")) {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.milliseconds.regex").split(str), paramResourceBundle.getString("PeriodFormat.milliseconds.list").split(str));
    } else {
      localPeriodFormatterBuilder.appendSuffix(paramResourceBundle.getString("PeriodFormat.millisecond"), paramResourceBundle.getString("PeriodFormat.milliseconds"));
    }
    return localPeriodFormatterBuilder.toFormatter().withLocale(paramLocale);
  }
  
  private static PeriodFormatter buildNonRegExFormatter(ResourceBundle paramResourceBundle, Locale paramLocale)
  {
    String[] arrayOfString = retrieveVariants(paramResourceBundle);
    return new PeriodFormatterBuilder().appendYears().appendSuffix(paramResourceBundle.getString("PeriodFormat.year"), paramResourceBundle.getString("PeriodFormat.years")).appendSeparator(paramResourceBundle.getString("PeriodFormat.commaspace"), paramResourceBundle.getString("PeriodFormat.spaceandspace"), arrayOfString).appendMonths().appendSuffix(paramResourceBundle.getString("PeriodFormat.month"), paramResourceBundle.getString("PeriodFormat.months")).appendSeparator(paramResourceBundle.getString("PeriodFormat.commaspace"), paramResourceBundle.getString("PeriodFormat.spaceandspace"), arrayOfString).appendWeeks().appendSuffix(paramResourceBundle.getString("PeriodFormat.week"), paramResourceBundle.getString("PeriodFormat.weeks")).appendSeparator(paramResourceBundle.getString("PeriodFormat.commaspace"), paramResourceBundle.getString("PeriodFormat.spaceandspace"), arrayOfString).appendDays().appendSuffix(paramResourceBundle.getString("PeriodFormat.day"), paramResourceBundle.getString("PeriodFormat.days")).appendSeparator(paramResourceBundle.getString("PeriodFormat.commaspace"), paramResourceBundle.getString("PeriodFormat.spaceandspace"), arrayOfString).appendHours().appendSuffix(paramResourceBundle.getString("PeriodFormat.hour"), paramResourceBundle.getString("PeriodFormat.hours")).appendSeparator(paramResourceBundle.getString("PeriodFormat.commaspace"), paramResourceBundle.getString("PeriodFormat.spaceandspace"), arrayOfString).appendMinutes().appendSuffix(paramResourceBundle.getString("PeriodFormat.minute"), paramResourceBundle.getString("PeriodFormat.minutes")).appendSeparator(paramResourceBundle.getString("PeriodFormat.commaspace"), paramResourceBundle.getString("PeriodFormat.spaceandspace"), arrayOfString).appendSeconds().appendSuffix(paramResourceBundle.getString("PeriodFormat.second"), paramResourceBundle.getString("PeriodFormat.seconds")).appendSeparator(paramResourceBundle.getString("PeriodFormat.commaspace"), paramResourceBundle.getString("PeriodFormat.spaceandspace"), arrayOfString).appendMillis().appendSuffix(paramResourceBundle.getString("PeriodFormat.millisecond"), paramResourceBundle.getString("PeriodFormat.milliseconds")).toFormatter().withLocale(paramLocale);
  }
  
  private static String[] retrieveVariants(ResourceBundle paramResourceBundle)
  {
    return new String[] { paramResourceBundle.getString("PeriodFormat.space"), paramResourceBundle.getString("PeriodFormat.comma"), paramResourceBundle.getString("PeriodFormat.commandand"), paramResourceBundle.getString("PeriodFormat.commaspaceand") };
  }
  
  private static boolean containsKey(ResourceBundle paramResourceBundle, String paramString)
  {
    for (Enumeration localEnumeration = paramResourceBundle.getKeys(); localEnumeration.hasMoreElements();) {
      if (((String)localEnumeration.nextElement()).equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  static class DynamicWordBased
    implements PeriodPrinter, PeriodParser
  {
    private final PeriodFormatter iFormatter;
    
    DynamicWordBased(PeriodFormatter paramPeriodFormatter)
    {
      iFormatter = paramPeriodFormatter;
    }
    
    public int countFieldsToPrint(ReadablePeriod paramReadablePeriod, int paramInt, Locale paramLocale)
    {
      return getPrinter(paramLocale).countFieldsToPrint(paramReadablePeriod, paramInt, paramLocale);
    }
    
    public int calculatePrintedLength(ReadablePeriod paramReadablePeriod, Locale paramLocale)
    {
      return getPrinter(paramLocale).calculatePrintedLength(paramReadablePeriod, paramLocale);
    }
    
    public void printTo(StringBuffer paramStringBuffer, ReadablePeriod paramReadablePeriod, Locale paramLocale)
    {
      getPrinter(paramLocale).printTo(paramStringBuffer, paramReadablePeriod, paramLocale);
    }
    
    public void printTo(Writer paramWriter, ReadablePeriod paramReadablePeriod, Locale paramLocale)
      throws IOException
    {
      getPrinter(paramLocale).printTo(paramWriter, paramReadablePeriod, paramLocale);
    }
    
    private PeriodPrinter getPrinter(Locale paramLocale)
    {
      if ((paramLocale != null) && (!paramLocale.equals(iFormatter.getLocale()))) {
        return PeriodFormat.wordBased(paramLocale).getPrinter();
      }
      return iFormatter.getPrinter();
    }
    
    public int parseInto(ReadWritablePeriod paramReadWritablePeriod, String paramString, int paramInt, Locale paramLocale)
    {
      return getParser(paramLocale).parseInto(paramReadWritablePeriod, paramString, paramInt, paramLocale);
    }
    
    private PeriodParser getParser(Locale paramLocale)
    {
      if ((paramLocale != null) && (!paramLocale.equals(iFormatter.getLocale()))) {
        return PeriodFormat.wordBased(paramLocale).getParser();
      }
      return iFormatter.getParser();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.PeriodFormat
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */