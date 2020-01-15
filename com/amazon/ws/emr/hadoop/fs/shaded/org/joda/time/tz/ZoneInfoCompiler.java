package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.Chronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeField;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.LocalDate;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.MutableDateTime;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.ISOChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.LenientChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.ISODateTimeFormat;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ZoneInfoCompiler
{
  static DateTimeOfYear cStartOfYear;
  static Chronology cLenientISO;
  private Map<String, RuleSet> iRuleSets;
  private List<Zone> iZones;
  private List<String> iGoodLinks;
  private List<String> iBackLinks;
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {
    if (paramArrayOfString.length == 0)
    {
      printUsage();
      return;
    }
    File localFile1 = null;
    File localFile2 = null;
    boolean bool = false;
    for (int i = 0; i < paramArrayOfString.length; i++) {
      try
      {
        if ("-src".equals(paramArrayOfString[i]))
        {
          localFile1 = new File(paramArrayOfString[(++i)]);
        }
        else if ("-dst".equals(paramArrayOfString[i]))
        {
          localFile2 = new File(paramArrayOfString[(++i)]);
        }
        else if ("-verbose".equals(paramArrayOfString[i]))
        {
          bool = true;
        }
        else
        {
          if ("-?".equals(paramArrayOfString[i]))
          {
            printUsage();
            return;
          }
          break;
        }
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        printUsage();
        return;
      }
    }
    if (i >= paramArrayOfString.length)
    {
      printUsage();
      return;
    }
    File[] arrayOfFile = new File[paramArrayOfString.length - i];
    for (int j = 0; i < paramArrayOfString.length; j++)
    {
      arrayOfFile[j] = (localFile1 == null ? new File(paramArrayOfString[i]) : new File(localFile1, paramArrayOfString[i]));i++;
    }
    ZoneInfoLogger.set(bool);
    ZoneInfoCompiler localZoneInfoCompiler = new ZoneInfoCompiler();
    localZoneInfoCompiler.compile(localFile2, arrayOfFile);
  }
  
  private static void printUsage()
  {
    System.out.println("Usage: java org.joda.time.tz.ZoneInfoCompiler <options> <source files>");
    System.out.println("where possible options include:");
    System.out.println("  -src <directory>    Specify where to read source files");
    System.out.println("  -dst <directory>    Specify where to write generated files");
    System.out.println("  -verbose            Output verbosely (default false)");
  }
  
  static DateTimeOfYear getStartOfYear()
  {
    if (cStartOfYear == null) {
      cStartOfYear = new DateTimeOfYear();
    }
    return cStartOfYear;
  }
  
  static Chronology getLenientISOChronology()
  {
    if (cLenientISO == null) {
      cLenientISO = LenientChronology.getInstance(ISOChronology.getInstanceUTC());
    }
    return cLenientISO;
  }
  
  static void writeZoneInfoMap(DataOutputStream paramDataOutputStream, Map<String, DateTimeZone> paramMap)
    throws IOException
  {
    HashMap localHashMap = new HashMap(paramMap.size());
    TreeMap localTreeMap = new TreeMap();
    
    short s = 0;
    for (Iterator localIterator = paramMap.entrySet().iterator(); localIterator.hasNext();)
    {
      localObject = (Map.Entry)localIterator.next();
      str = (String)((Map.Entry)localObject).getKey();
      Short localShort;
      if (!localHashMap.containsKey(str))
      {
        localShort = Short.valueOf(s);
        localHashMap.put(str, localShort);
        localTreeMap.put(localShort, str);
        s = (short)(s + 1);
        if (s == 0) {
          throw new InternalError("Too many time zone ids");
        }
      }
      str = ((DateTimeZone)((Map.Entry)localObject).getValue()).getID();
      if (!localHashMap.containsKey(str))
      {
        localShort = Short.valueOf(s);
        localHashMap.put(str, localShort);
        localTreeMap.put(localShort, str);
        s = (short)(s + 1);
        if (s == 0) {
          throw new InternalError("Too many time zone ids");
        }
      }
    }
    Object localObject;
    String str;
    paramDataOutputStream.writeShort(localTreeMap.size());
    for (localIterator = localTreeMap.values().iterator(); localIterator.hasNext();)
    {
      localObject = (String)localIterator.next();
      paramDataOutputStream.writeUTF((String)localObject);
    }
    paramDataOutputStream.writeShort(paramMap.size());
    for (localIterator = paramMap.entrySet().iterator(); localIterator.hasNext();)
    {
      localObject = (Map.Entry)localIterator.next();
      str = (String)((Map.Entry)localObject).getKey();
      paramDataOutputStream.writeShort(((Short)localHashMap.get(str)).shortValue());
      str = ((DateTimeZone)((Map.Entry)localObject).getValue()).getID();
      paramDataOutputStream.writeShort(((Short)localHashMap.get(str)).shortValue());
    }
  }
  
  static int parseYear(String paramString, int paramInt)
  {
    paramString = paramString.toLowerCase();
    if ((paramString.equals("minimum")) || (paramString.equals("min"))) {
      return Integer.MIN_VALUE;
    }
    if ((paramString.equals("maximum")) || (paramString.equals("max"))) {
      return Integer.MAX_VALUE;
    }
    if (paramString.equals("only")) {
      return paramInt;
    }
    return Integer.parseInt(paramString);
  }
  
  static int parseMonth(String paramString)
  {
    DateTimeField localDateTimeField = ISOChronology.getInstanceUTC().monthOfYear();
    return localDateTimeField.get(localDateTimeField.set(0L, paramString, Locale.ENGLISH));
  }
  
  static int parseDayOfWeek(String paramString)
  {
    DateTimeField localDateTimeField = ISOChronology.getInstanceUTC().dayOfWeek();
    return localDateTimeField.get(localDateTimeField.set(0L, paramString, Locale.ENGLISH));
  }
  
  static String parseOptional(String paramString)
  {
    return paramString.equals("-") ? null : paramString;
  }
  
  static int parseTime(String paramString)
  {
    DateTimeFormatter localDateTimeFormatter = ISODateTimeFormat.hourMinuteSecondFraction();
    MutableDateTime localMutableDateTime = new MutableDateTime(0L, getLenientISOChronology());
    int i = 0;
    if (paramString.startsWith("-")) {
      i = 1;
    }
    int j = localDateTimeFormatter.parseInto(localMutableDateTime, paramString, i);
    if (j == (i ^ 0xFFFFFFFF)) {
      throw new IllegalArgumentException(paramString);
    }
    int k = (int)localMutableDateTime.getMillis();
    if (i == 1) {
      k = -k;
    }
    return k;
  }
  
  static char parseZoneChar(char paramChar)
  {
    switch (paramChar)
    {
    case 'S': 
    case 's': 
      return 's';
    case 'G': 
    case 'U': 
    case 'Z': 
    case 'g': 
    case 'u': 
    case 'z': 
      return 'u';
    }
    return 'w';
  }
  
  static boolean test(String paramString, DateTimeZone paramDateTimeZone)
  {
    if (!paramString.equals(paramDateTimeZone.getID())) {
      return true;
    }
    long l1 = ISOChronology.getInstanceUTC().year().set(0L, 1850);
    long l2 = ISOChronology.getInstanceUTC().year().set(0L, 2050);
    
    int i = paramDateTimeZone.getOffset(l1);
    Object localObject = paramDateTimeZone.getNameKey(l1);
    
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      long l3 = paramDateTimeZone.nextTransition(l1);
      if ((l3 == l1) || (l3 > l2)) {
        break;
      }
      l1 = l3;
      
      int j = paramDateTimeZone.getOffset(l1);
      String str = paramDateTimeZone.getNameKey(l1);
      if ((i == j) && (((String)localObject).equals(str)))
      {
        System.out.println("*d* Error in " + paramDateTimeZone.getID() + " " + new DateTime(l1, ISOChronology.getInstanceUTC()));
        
        return false;
      }
      if ((str == null) || ((str.length() < 3) && (!"??".equals(str))))
      {
        System.out.println("*s* Error in " + paramDateTimeZone.getID() + " " + new DateTime(l1, ISOChronology.getInstanceUTC()) + ", nameKey=" + str);
        
        return false;
      }
      localArrayList.add(Long.valueOf(l1));
      
      i = j;
      localObject = str;
    }
    l1 = ISOChronology.getInstanceUTC().year().set(0L, 2050);
    l2 = ISOChronology.getInstanceUTC().year().set(0L, 1850);
    
    int k = localArrayList.size();
    for (;;)
    {
      k--;
      if (k < 0) {
        break;
      }
      long l4 = paramDateTimeZone.previousTransition(l1);
      if ((l4 == l1) || (l4 < l2)) {
        break;
      }
      l1 = l4;
      
      long l5 = ((Long)localArrayList.get(k)).longValue();
      if (l5 - 1L != l1)
      {
        System.out.println("*r* Error in " + paramDateTimeZone.getID() + " " + new DateTime(l1, ISOChronology.getInstanceUTC()) + " != " + new DateTime(l5 - 1L, ISOChronology.getInstanceUTC()));
        
        return false;
      }
    }
    return true;
  }
  
  public ZoneInfoCompiler()
  {
    iRuleSets = new HashMap();
    iZones = new ArrayList();
    iGoodLinks = new ArrayList();
    iBackLinks = new ArrayList();
  }
  
  public Map<String, DateTimeZone> compile(File paramFile, File[] paramArrayOfFile)
    throws IOException
  {
    if (paramArrayOfFile != null) {
      for (int i = 0; i < paramArrayOfFile.length; i++)
      {
        localObject1 = new BufferedReader(new FileReader(paramArrayOfFile[i]));
        parseDataFile((BufferedReader)localObject1, "backward".equals(paramArrayOfFile[i].getName()));
        ((BufferedReader)localObject1).close();
      }
    }
    if (paramFile != null)
    {
      if ((!paramFile.exists()) && (!paramFile.mkdirs())) {
        throw new IOException("Destination directory doesn't exist and cannot be created: " + paramFile);
      }
      if (!paramFile.isDirectory()) {
        throw new IOException("Destination is not a directory: " + paramFile);
      }
    }
    TreeMap localTreeMap = new TreeMap();
    Object localObject1 = new TreeMap();
    
    System.out.println("Writing zoneinfo files");
    Object localObject2;
    Object localObject3;
    Object localObject4;
    for (int j = 0; j < iZones.size(); j++)
    {
      localObject2 = (Zone)iZones.get(j);
      localObject3 = new DateTimeZoneBuilder();
      ((Zone)localObject2).addToBuilder((DateTimeZoneBuilder)localObject3, iRuleSets);
      localObject4 = ((DateTimeZoneBuilder)localObject3).toDateTimeZone(iName, true);
      if (test(((DateTimeZone)localObject4).getID(), (DateTimeZone)localObject4))
      {
        localTreeMap.put(((DateTimeZone)localObject4).getID(), localObject4);
        ((Map)localObject1).put(((DateTimeZone)localObject4).getID(), localObject2);
        if (paramFile != null) {
          writeZone(paramFile, (DateTimeZoneBuilder)localObject3, (DateTimeZone)localObject4);
        }
      }
    }
    Object localObject5;
    for (j = 0; j < iGoodLinks.size(); j += 2)
    {
      localObject2 = (String)iGoodLinks.get(j);
      localObject3 = (String)iGoodLinks.get(j + 1);
      localObject4 = (Zone)((Map)localObject1).get(localObject2);
      if (localObject4 == null)
      {
        System.out.println("Cannot find source zone '" + (String)localObject2 + "' to link alias '" + (String)localObject3 + "' to");
      }
      else
      {
        localObject5 = new DateTimeZoneBuilder();
        ((Zone)localObject4).addToBuilder((DateTimeZoneBuilder)localObject5, iRuleSets);
        DateTimeZone localDateTimeZone = ((DateTimeZoneBuilder)localObject5).toDateTimeZone((String)localObject3, true);
        if (test(localDateTimeZone.getID(), localDateTimeZone))
        {
          localTreeMap.put(localDateTimeZone.getID(), localDateTimeZone);
          if (paramFile != null) {
            writeZone(paramFile, (DateTimeZoneBuilder)localObject5, localDateTimeZone);
          }
        }
        localTreeMap.put(localDateTimeZone.getID(), localDateTimeZone);
        if (ZoneInfoLogger.verbose()) {
          System.out.println("Good link: " + (String)localObject3 + " -> " + (String)localObject2 + " revived");
        }
      }
    }
    for (j = 0; j < 2; j++) {
      for (int k = 0; k < iBackLinks.size(); k += 2)
      {
        localObject3 = (String)iBackLinks.get(k);
        localObject4 = (String)iBackLinks.get(k + 1);
        localObject5 = (DateTimeZone)localTreeMap.get(localObject3);
        if (localObject5 == null)
        {
          if (j > 0) {
            System.out.println("Cannot find time zone '" + (String)localObject3 + "' to link alias '" + (String)localObject4 + "' to");
          }
        }
        else
        {
          localTreeMap.put(localObject4, localObject5);
          if (ZoneInfoLogger.verbose()) {
            System.out.println("Back link: " + (String)localObject4 + " -> " + ((DateTimeZone)localObject5).getID());
          }
        }
      }
    }
    if (paramFile != null)
    {
      System.out.println("Writing ZoneInfoMap");
      File localFile = new File(paramFile, "ZoneInfoMap");
      if (!localFile.getParentFile().exists()) {
        localFile.getParentFile().mkdirs();
      }
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      localObject3 = new DataOutputStream(localFileOutputStream);
      try
      {
        localObject4 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        ((Map)localObject4).putAll(localTreeMap);
        writeZoneInfoMap((DataOutputStream)localObject3, (Map)localObject4);
      }
      finally
      {
        ((DataOutputStream)localObject3).close();
      }
    }
    return localTreeMap;
  }
  
  private void writeZone(File paramFile, DateTimeZoneBuilder paramDateTimeZoneBuilder, DateTimeZone paramDateTimeZone)
    throws IOException
  {
    if (ZoneInfoLogger.verbose()) {
      System.out.println("Writing " + paramDateTimeZone.getID());
    }
    File localFile = new File(paramFile, paramDateTimeZone.getID());
    if (!localFile.getParentFile().exists()) {
      localFile.getParentFile().mkdirs();
    }
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
    try
    {
      paramDateTimeZoneBuilder.writeTo(paramDateTimeZone.getID(), localFileOutputStream);
    }
    finally
    {
      localFileOutputStream.close();
    }
    FileInputStream localFileInputStream = new FileInputStream(localFile);
    DateTimeZone localDateTimeZone = DateTimeZoneBuilder.readFrom(localFileInputStream, paramDateTimeZone.getID());
    localFileInputStream.close();
    if (!paramDateTimeZone.equals(localDateTimeZone)) {
      System.out.println("*e* Error in " + paramDateTimeZone.getID() + ": Didn't read properly from file");
    }
  }
  
  public void parseDataFile(BufferedReader paramBufferedReader, boolean paramBoolean)
    throws IOException
  {
    Object localObject1 = null;
    String str1;
    while ((str1 = paramBufferedReader.readLine()) != null)
    {
      String str2 = str1.trim();
      if ((str2.length() != 0) && (str2.charAt(0) != '#'))
      {
        int i = str1.indexOf('#');
        if (i >= 0) {
          str1 = str1.substring(0, i);
        }
        StringTokenizer localStringTokenizer = new StringTokenizer(str1, " \t");
        if ((Character.isWhitespace(str1.charAt(0))) && (localStringTokenizer.hasMoreTokens()))
        {
          if (localObject1 != null) {
            ((Zone)localObject1).chain(localStringTokenizer);
          }
        }
        else
        {
          if (localObject1 != null) {
            iZones.add(localObject1);
          }
          localObject1 = null;
          if (localStringTokenizer.hasMoreTokens())
          {
            String str3 = localStringTokenizer.nextToken();
            Object localObject2;
            Object localObject3;
            if (str3.equalsIgnoreCase("Rule"))
            {
              localObject2 = new Rule(localStringTokenizer);
              localObject3 = (RuleSet)iRuleSets.get(iName);
              if (localObject3 == null)
              {
                localObject3 = new RuleSet((Rule)localObject2);
                iRuleSets.put(iName, localObject3);
              }
              else
              {
                ((RuleSet)localObject3).addRule((Rule)localObject2);
              }
            }
            else if (str3.equalsIgnoreCase("Zone"))
            {
              if (localStringTokenizer.countTokens() < 4) {
                throw new IllegalArgumentException("Attempting to create a Zone from an incomplete tokenizer");
              }
              localObject1 = new Zone(localStringTokenizer);
            }
            else if (str3.equalsIgnoreCase("Link"))
            {
              localObject2 = localStringTokenizer.nextToken();
              localObject3 = localStringTokenizer.nextToken();
              if ((paramBoolean) || (((String)localObject3).equals("US/Pacific-New")) || (((String)localObject3).startsWith("Etc/")) || (((String)localObject3).equals("GMT")))
              {
                iBackLinks.add(localObject2);
                iBackLinks.add(localObject3);
              }
              else
              {
                iGoodLinks.add(localObject2);
                iGoodLinks.add(localObject3);
              }
            }
            else
            {
              System.out.println("Unknown line: " + str1);
            }
          }
        }
      }
    }
    if (localObject1 != null) {
      iZones.add(localObject1);
    }
  }
  
  static class DateTimeOfYear
  {
    public final int iMonthOfYear;
    public final int iDayOfMonth;
    public final int iDayOfWeek;
    public final boolean iAdvanceDayOfWeek;
    public final int iMillisOfDay;
    public final char iZoneChar;
    
    DateTimeOfYear()
    {
      iMonthOfYear = 1;
      iDayOfMonth = 1;
      iDayOfWeek = 0;
      iAdvanceDayOfWeek = false;
      iMillisOfDay = 0;
      iZoneChar = 'w';
    }
    
    DateTimeOfYear(StringTokenizer paramStringTokenizer)
    {
      int i = 1;
      int j = 1;
      int k = 0;
      int m = 0;
      boolean bool = false;
      char c = 'w';
      if (paramStringTokenizer.hasMoreTokens())
      {
        i = ZoneInfoCompiler.parseMonth(paramStringTokenizer.nextToken());
        if (paramStringTokenizer.hasMoreTokens())
        {
          String str = paramStringTokenizer.nextToken();
          if (str.startsWith("last"))
          {
            j = -1;
            k = ZoneInfoCompiler.parseDayOfWeek(str.substring(4));
            bool = false;
          }
          else
          {
            try
            {
              j = Integer.parseInt(str);
              k = 0;
              bool = false;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              int n = str.indexOf(">=");
              if (n > 0)
              {
                j = Integer.parseInt(str.substring(n + 2));
                k = ZoneInfoCompiler.parseDayOfWeek(str.substring(0, n));
                bool = true;
              }
              else
              {
                n = str.indexOf("<=");
                if (n > 0)
                {
                  j = Integer.parseInt(str.substring(n + 2));
                  k = ZoneInfoCompiler.parseDayOfWeek(str.substring(0, n));
                  bool = false;
                }
                else
                {
                  throw new IllegalArgumentException(str);
                }
              }
            }
          }
          if (paramStringTokenizer.hasMoreTokens())
          {
            str = paramStringTokenizer.nextToken();
            c = ZoneInfoCompiler.parseZoneChar(str.charAt(str.length() - 1));
            if (str.equals("24:00"))
            {
              if ((i == 12) && (j == 31))
              {
                m = ZoneInfoCompiler.parseTime("23:59:59.999");
              }
              else
              {
                LocalDate localLocalDate = j == -1 ? new LocalDate(2001, i, 1).plusMonths(1) : new LocalDate(2001, i, j).plusDays(1);
                
                bool = (j != -1) && (k != 0);
                i = localLocalDate.getMonthOfYear();
                j = localLocalDate.getDayOfMonth();
                if (k != 0) {
                  k = (k - 1 + 1) % 7 + 1;
                }
              }
            }
            else {
              m = ZoneInfoCompiler.parseTime(str);
            }
          }
        }
      }
      iMonthOfYear = i;
      iDayOfMonth = j;
      iDayOfWeek = k;
      iAdvanceDayOfWeek = bool;
      iMillisOfDay = m;
      iZoneChar = c;
    }
    
    public void addRecurring(DateTimeZoneBuilder paramDateTimeZoneBuilder, String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      paramDateTimeZoneBuilder.addRecurringSavings(paramString, paramInt1, paramInt2, paramInt3, iZoneChar, iMonthOfYear, iDayOfMonth, iDayOfWeek, iAdvanceDayOfWeek, iMillisOfDay);
    }
    
    public void addCutover(DateTimeZoneBuilder paramDateTimeZoneBuilder, int paramInt)
    {
      paramDateTimeZoneBuilder.addCutover(paramInt, iZoneChar, iMonthOfYear, iDayOfMonth, iDayOfWeek, iAdvanceDayOfWeek, iMillisOfDay);
    }
    
    public String toString()
    {
      return "MonthOfYear: " + iMonthOfYear + "\n" + "DayOfMonth: " + iDayOfMonth + "\n" + "DayOfWeek: " + iDayOfWeek + "\n" + "AdvanceDayOfWeek: " + iAdvanceDayOfWeek + "\n" + "MillisOfDay: " + iMillisOfDay + "\n" + "ZoneChar: " + iZoneChar + "\n";
    }
  }
  
  private static class Rule
  {
    public final String iName;
    public final int iFromYear;
    public final int iToYear;
    public final String iType;
    public final ZoneInfoCompiler.DateTimeOfYear iDateTimeOfYear;
    public final int iSaveMillis;
    public final String iLetterS;
    
    Rule(StringTokenizer paramStringTokenizer)
    {
      if (paramStringTokenizer.countTokens() < 6) {
        throw new IllegalArgumentException("Attempting to create a Rule from an incomplete tokenizer");
      }
      iName = paramStringTokenizer.nextToken().intern();
      iFromYear = ZoneInfoCompiler.parseYear(paramStringTokenizer.nextToken(), 0);
      iToYear = ZoneInfoCompiler.parseYear(paramStringTokenizer.nextToken(), iFromYear);
      if (iToYear < iFromYear) {
        throw new IllegalArgumentException();
      }
      iType = ZoneInfoCompiler.parseOptional(paramStringTokenizer.nextToken());
      iDateTimeOfYear = new ZoneInfoCompiler.DateTimeOfYear(paramStringTokenizer);
      iSaveMillis = ZoneInfoCompiler.parseTime(paramStringTokenizer.nextToken());
      iLetterS = ZoneInfoCompiler.parseOptional(paramStringTokenizer.nextToken());
    }
    
    public void addRecurring(DateTimeZoneBuilder paramDateTimeZoneBuilder, String paramString)
    {
      String str = formatName(paramString);
      iDateTimeOfYear.addRecurring(paramDateTimeZoneBuilder, str, iSaveMillis, iFromYear, iToYear);
    }
    
    private String formatName(String paramString)
    {
      int i = paramString.indexOf('/');
      if (i > 0)
      {
        if (iSaveMillis == 0) {
          return paramString.substring(0, i).intern();
        }
        return paramString.substring(i + 1).intern();
      }
      i = paramString.indexOf("%s");
      if (i < 0) {
        return paramString;
      }
      String str1 = paramString.substring(0, i);
      String str2 = paramString.substring(i + 2);
      String str3;
      if (iLetterS == null) {
        str3 = str1.concat(str2);
      } else {
        str3 = str1 + iLetterS + str2;
      }
      return str3.intern();
    }
    
    public String toString()
    {
      return "[Rule]\nName: " + iName + "\n" + "FromYear: " + iFromYear + "\n" + "ToYear: " + iToYear + "\n" + "Type: " + iType + "\n" + iDateTimeOfYear + "SaveMillis: " + iSaveMillis + "\n" + "LetterS: " + iLetterS + "\n";
    }
  }
  
  private static class RuleSet
  {
    private List<ZoneInfoCompiler.Rule> iRules;
    
    RuleSet(ZoneInfoCompiler.Rule paramRule)
    {
      iRules = new ArrayList();
      iRules.add(paramRule);
    }
    
    void addRule(ZoneInfoCompiler.Rule paramRule)
    {
      if (!iName.equals(iRules.get(0)).iName)) {
        throw new IllegalArgumentException("Rule name mismatch");
      }
      iRules.add(paramRule);
    }
    
    public void addRecurring(DateTimeZoneBuilder paramDateTimeZoneBuilder, String paramString)
    {
      for (int i = 0; i < iRules.size(); i++)
      {
        ZoneInfoCompiler.Rule localRule = (ZoneInfoCompiler.Rule)iRules.get(i);
        localRule.addRecurring(paramDateTimeZoneBuilder, paramString);
      }
    }
  }
  
  private static class Zone
  {
    public final String iName;
    public final int iOffsetMillis;
    public final String iRules;
    public final String iFormat;
    public final int iUntilYear;
    public final ZoneInfoCompiler.DateTimeOfYear iUntilDateTimeOfYear;
    private Zone iNext;
    
    Zone(StringTokenizer paramStringTokenizer)
    {
      this(paramStringTokenizer.nextToken(), paramStringTokenizer);
    }
    
    private Zone(String paramString, StringTokenizer paramStringTokenizer)
    {
      iName = paramString.intern();
      iOffsetMillis = ZoneInfoCompiler.parseTime(paramStringTokenizer.nextToken());
      iRules = ZoneInfoCompiler.parseOptional(paramStringTokenizer.nextToken());
      iFormat = paramStringTokenizer.nextToken().intern();
      
      int i = Integer.MAX_VALUE;
      ZoneInfoCompiler.DateTimeOfYear localDateTimeOfYear = ZoneInfoCompiler.getStartOfYear();
      if (paramStringTokenizer.hasMoreTokens())
      {
        i = Integer.parseInt(paramStringTokenizer.nextToken());
        if (paramStringTokenizer.hasMoreTokens()) {
          localDateTimeOfYear = new ZoneInfoCompiler.DateTimeOfYear(paramStringTokenizer);
        }
      }
      iUntilYear = i;
      iUntilDateTimeOfYear = localDateTimeOfYear;
    }
    
    void chain(StringTokenizer paramStringTokenizer)
    {
      if (iNext != null) {
        iNext.chain(paramStringTokenizer);
      } else {
        iNext = new Zone(iName, paramStringTokenizer);
      }
    }
    
    public void addToBuilder(DateTimeZoneBuilder paramDateTimeZoneBuilder, Map<String, ZoneInfoCompiler.RuleSet> paramMap)
    {
      addToBuilder(this, paramDateTimeZoneBuilder, paramMap);
    }
    
    private static void addToBuilder(Zone paramZone, DateTimeZoneBuilder paramDateTimeZoneBuilder, Map<String, ZoneInfoCompiler.RuleSet> paramMap)
    {
      for (; paramZone != null; paramZone = iNext)
      {
        paramDateTimeZoneBuilder.setStandardOffset(iOffsetMillis);
        if (iRules == null) {
          paramDateTimeZoneBuilder.setFixedSavings(iFormat, 0);
        } else {
          try
          {
            int i = ZoneInfoCompiler.parseTime(iRules);
            paramDateTimeZoneBuilder.setFixedSavings(iFormat, i);
          }
          catch (Exception localException)
          {
            ZoneInfoCompiler.RuleSet localRuleSet = (ZoneInfoCompiler.RuleSet)paramMap.get(iRules);
            if (localRuleSet == null) {
              throw new IllegalArgumentException("Rules not found: " + iRules);
            }
            localRuleSet.addRecurring(paramDateTimeZoneBuilder, iFormat);
          }
        }
        if (iUntilYear == Integer.MAX_VALUE) {
          break;
        }
        iUntilDateTimeOfYear.addCutover(paramDateTimeZoneBuilder, iUntilYear);
      }
    }
    
    public String toString()
    {
      String str = "[Zone]\nName: " + iName + "\n" + "OffsetMillis: " + iOffsetMillis + "\n" + "Rules: " + iRules + "\n" + "Format: " + iFormat + "\n" + "UntilYear: " + iUntilYear + "\n" + iUntilDateTimeOfYear;
      if (iNext == null) {
        return str;
      }
      return str + "...\n" + iNext.toString();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.ZoneInfoCompiler
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */