package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.chrono.BaseChronology;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.field.FieldUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatter;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.DateTimeFormatterBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.format.FormatUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.DefaultNameProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.FixedDateTimeZone;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.NameProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.UTCProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.ZoneInfoProvider;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.convert.ToString;

public abstract class DateTimeZone
  implements Serializable
{
  private static final long serialVersionUID = 5546345482340108586L;
  public static final DateTimeZone UTC = UTCDateTimeZone.INSTANCE;
  private static final int MAX_MILLIS = 86399999;
  private static final AtomicReference<Provider> cProvider = new AtomicReference();
  private static final AtomicReference<NameProvider> cNameProvider = new AtomicReference();
  private static final AtomicReference<DateTimeZone> cDefault = new AtomicReference();
  private final String iID;
  
  public static DateTimeZone getDefault()
  {
    DateTimeZone localDateTimeZone = (DateTimeZone)cDefault.get();
    if (localDateTimeZone == null)
    {
      try
      {
        try
        {
          String str = System.getProperty("user.timezone");
          if (str != null) {
            localDateTimeZone = forID(str);
          }
        }
        catch (RuntimeException localRuntimeException) {}
        if (localDateTimeZone == null) {
          localDateTimeZone = forTimeZone(TimeZone.getDefault());
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}
      if (localDateTimeZone == null) {
        localDateTimeZone = UTC;
      }
      if (!cDefault.compareAndSet(null, localDateTimeZone)) {
        localDateTimeZone = (DateTimeZone)cDefault.get();
      }
    }
    return localDateTimeZone;
  }
  
  public static void setDefault(DateTimeZone paramDateTimeZone)
    throws SecurityException
  {
    SecurityManager localSecurityManager = System.getSecurityManager();
    if (localSecurityManager != null) {
      localSecurityManager.checkPermission(new JodaTimePermission("DateTimeZone.setDefault"));
    }
    if (paramDateTimeZone == null) {
      throw new IllegalArgumentException("The datetime zone must not be null");
    }
    cDefault.set(paramDateTimeZone);
  }
  
  @FromString
  public static DateTimeZone forID(String paramString)
  {
    if (paramString == null) {
      return getDefault();
    }
    if (paramString.equals("UTC")) {
      return UTC;
    }
    DateTimeZone localDateTimeZone = getProvider().getZone(paramString);
    if (localDateTimeZone != null) {
      return localDateTimeZone;
    }
    if ((paramString.startsWith("+")) || (paramString.startsWith("-")))
    {
      int i = parseOffset(paramString);
      if (i == 0L) {
        return UTC;
      }
      paramString = printOffset(i);
      return fixedOffsetZone(paramString, i);
    }
    throw new IllegalArgumentException("The datetime zone id '" + paramString + "' is not recognised");
  }
  
  public static DateTimeZone forOffsetHours(int paramInt)
    throws IllegalArgumentException
  {
    return forOffsetHoursMinutes(paramInt, 0);
  }
  
  public static DateTimeZone forOffsetHoursMinutes(int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return UTC;
    }
    if ((paramInt1 < -23) || (paramInt1 > 23)) {
      throw new IllegalArgumentException("Hours out of range: " + paramInt1);
    }
    if ((paramInt2 < -59) || (paramInt2 > 59)) {
      throw new IllegalArgumentException("Minutes out of range: " + paramInt2);
    }
    if ((paramInt1 > 0) && (paramInt2 < 0)) {
      throw new IllegalArgumentException("Positive hours must not have negative minutes: " + paramInt2);
    }
    int i = 0;
    try
    {
      int j = paramInt1 * 60;
      if (j < 0) {
        paramInt2 = j - Math.abs(paramInt2);
      } else {
        paramInt2 = j + paramInt2;
      }
      i = FieldUtils.safeMultiply(paramInt2, 60000);
    }
    catch (ArithmeticException localArithmeticException)
    {
      throw new IllegalArgumentException("Offset is too large");
    }
    return forOffsetMillis(i);
  }
  
  public static DateTimeZone forOffsetMillis(int paramInt)
  {
    if ((paramInt < -86399999) || (paramInt > 86399999)) {
      throw new IllegalArgumentException("Millis out of range: " + paramInt);
    }
    String str = printOffset(paramInt);
    return fixedOffsetZone(str, paramInt);
  }
  
  public static DateTimeZone forTimeZone(TimeZone paramTimeZone)
  {
    if (paramTimeZone == null) {
      return getDefault();
    }
    String str1 = paramTimeZone.getID();
    if (str1 == null) {
      throw new IllegalArgumentException("The TimeZone id must not be null");
    }
    if (str1.equals("UTC")) {
      return UTC;
    }
    DateTimeZone localDateTimeZone = null;
    String str2 = getConvertedId(str1);
    Provider localProvider = getProvider();
    if (str2 != null) {
      localDateTimeZone = localProvider.getZone(str2);
    }
    if (localDateTimeZone == null) {
      localDateTimeZone = localProvider.getZone(str1);
    }
    if (localDateTimeZone != null) {
      return localDateTimeZone;
    }
    if (str2 == null)
    {
      str2 = str1;
      if ((str2.startsWith("GMT+")) || (str2.startsWith("GMT-")))
      {
        str2 = str2.substring(3);
        int i = parseOffset(str2);
        if (i == 0L) {
          return UTC;
        }
        str2 = printOffset(i);
        return fixedOffsetZone(str2, i);
      }
    }
    throw new IllegalArgumentException("The datetime zone id '" + str1 + "' is not recognised");
  }
  
  private static DateTimeZone fixedOffsetZone(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      return UTC;
    }
    return new FixedDateTimeZone(paramString, null, paramInt, paramInt);
  }
  
  public static Set<String> getAvailableIDs()
  {
    return getProvider().getAvailableIDs();
  }
  
  public static Provider getProvider()
  {
    Provider localProvider = (Provider)cProvider.get();
    if (localProvider == null)
    {
      localProvider = getDefaultProvider();
      if (!cProvider.compareAndSet(null, localProvider)) {
        localProvider = (Provider)cProvider.get();
      }
    }
    return localProvider;
  }
  
  public static void setProvider(Provider paramProvider)
    throws SecurityException
  {
    SecurityManager localSecurityManager = System.getSecurityManager();
    if (localSecurityManager != null) {
      localSecurityManager.checkPermission(new JodaTimePermission("DateTimeZone.setProvider"));
    }
    if (paramProvider == null) {
      paramProvider = getDefaultProvider();
    } else {
      validateProvider(paramProvider);
    }
    cProvider.set(paramProvider);
  }
  
  private static Provider validateProvider(Provider paramProvider)
  {
    Set localSet = paramProvider.getAvailableIDs();
    if ((localSet == null) || (localSet.size() == 0)) {
      throw new IllegalArgumentException("The provider doesn't have any available ids");
    }
    if (!localSet.contains("UTC")) {
      throw new IllegalArgumentException("The provider doesn't support UTC");
    }
    if (!UTC.equals(paramProvider.getZone("UTC"))) {
      throw new IllegalArgumentException("Invalid UTC zone provided");
    }
    return paramProvider;
  }
  
  private static Provider getDefaultProvider()
  {
    try
    {
      String str1 = System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone.Provider");
      if (str1 != null) {
        try
        {
          Provider localProvider = (Provider)Class.forName(str1).newInstance();
          return validateProvider(localProvider);
        }
        catch (Exception localException2)
        {
          throw new RuntimeException(localException2);
        }
      }
    }
    catch (SecurityException localSecurityException1) {}
    try
    {
      String str2 = System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone.Folder");
      if (str2 != null) {
        try
        {
          ZoneInfoProvider localZoneInfoProvider2 = new ZoneInfoProvider(new File(str2));
          return validateProvider(localZoneInfoProvider2);
        }
        catch (Exception localException3)
        {
          throw new RuntimeException(localException3);
        }
      }
    }
    catch (SecurityException localSecurityException2) {}
    try
    {
      ZoneInfoProvider localZoneInfoProvider1 = new ZoneInfoProvider("com/amazon/ws/emr/hadoop/fs/shaded/org/joda/time/tz/data");
      return validateProvider(localZoneInfoProvider1);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    return new UTCProvider();
  }
  
  public static NameProvider getNameProvider()
  {
    NameProvider localNameProvider = (NameProvider)cNameProvider.get();
    if (localNameProvider == null)
    {
      localNameProvider = getDefaultNameProvider();
      if (!cNameProvider.compareAndSet(null, localNameProvider)) {
        localNameProvider = (NameProvider)cNameProvider.get();
      }
    }
    return localNameProvider;
  }
  
  public static void setNameProvider(NameProvider paramNameProvider)
    throws SecurityException
  {
    SecurityManager localSecurityManager = System.getSecurityManager();
    if (localSecurityManager != null) {
      localSecurityManager.checkPermission(new JodaTimePermission("DateTimeZone.setNameProvider"));
    }
    if (paramNameProvider == null) {
      paramNameProvider = getDefaultNameProvider();
    }
    cNameProvider.set(paramNameProvider);
  }
  
  private static NameProvider getDefaultNameProvider()
  {
    Object localObject = null;
    try
    {
      String str = System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone.NameProvider");
      if (str != null) {
        try
        {
          localObject = (NameProvider)Class.forName(str).newInstance();
        }
        catch (Exception localException)
        {
          throw new RuntimeException(localException);
        }
      }
    }
    catch (SecurityException localSecurityException) {}
    if (localObject == null) {
      localObject = new DefaultNameProvider();
    }
    return (NameProvider)localObject;
  }
  
  private static String getConvertedId(String paramString)
  {
    return (String)LazyInit.CONVERSION_MAP.get(paramString);
  }
  
  private static int parseOffset(String paramString)
  {
    return -(int)LazyInit.OFFSET_FORMATTER.parseMillis(paramString);
  }
  
  private static String printOffset(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramInt >= 0)
    {
      localStringBuffer.append('+');
    }
    else
    {
      localStringBuffer.append('-');
      paramInt = -paramInt;
    }
    int i = paramInt / 3600000;
    FormatUtils.appendPaddedInteger(localStringBuffer, i, 2);
    paramInt -= i * 3600000;
    
    int j = paramInt / 60000;
    localStringBuffer.append(':');
    FormatUtils.appendPaddedInteger(localStringBuffer, j, 2);
    paramInt -= j * 60000;
    if (paramInt == 0) {
      return localStringBuffer.toString();
    }
    int k = paramInt / 1000;
    localStringBuffer.append(':');
    FormatUtils.appendPaddedInteger(localStringBuffer, k, 2);
    paramInt -= k * 1000;
    if (paramInt == 0) {
      return localStringBuffer.toString();
    }
    localStringBuffer.append('.');
    FormatUtils.appendPaddedInteger(localStringBuffer, paramInt, 3);
    return localStringBuffer.toString();
  }
  
  protected DateTimeZone(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Id must not be null");
    }
    iID = paramString;
  }
  
  @ToString
  public final String getID()
  {
    return iID;
  }
  
  public abstract String getNameKey(long paramLong);
  
  public final String getShortName(long paramLong)
  {
    return getShortName(paramLong, null);
  }
  
  public String getShortName(long paramLong, Locale paramLocale)
  {
    if (paramLocale == null) {
      paramLocale = Locale.getDefault();
    }
    String str1 = getNameKey(paramLong);
    if (str1 == null) {
      return iID;
    }
    NameProvider localNameProvider = getNameProvider();
    String str2;
    if ((localNameProvider instanceof DefaultNameProvider)) {
      str2 = ((DefaultNameProvider)localNameProvider).getShortName(paramLocale, iID, str1, isStandardOffset(paramLong));
    } else {
      str2 = localNameProvider.getShortName(paramLocale, iID, str1);
    }
    if (str2 != null) {
      return str2;
    }
    return printOffset(getOffset(paramLong));
  }
  
  public final String getName(long paramLong)
  {
    return getName(paramLong, null);
  }
  
  public String getName(long paramLong, Locale paramLocale)
  {
    if (paramLocale == null) {
      paramLocale = Locale.getDefault();
    }
    String str1 = getNameKey(paramLong);
    if (str1 == null) {
      return iID;
    }
    NameProvider localNameProvider = getNameProvider();
    String str2;
    if ((localNameProvider instanceof DefaultNameProvider)) {
      str2 = ((DefaultNameProvider)localNameProvider).getName(paramLocale, iID, str1, isStandardOffset(paramLong));
    } else {
      str2 = localNameProvider.getName(paramLocale, iID, str1);
    }
    if (str2 != null) {
      return str2;
    }
    return printOffset(getOffset(paramLong));
  }
  
  public abstract int getOffset(long paramLong);
  
  public final int getOffset(ReadableInstant paramReadableInstant)
  {
    if (paramReadableInstant == null) {
      return getOffset(DateTimeUtils.currentTimeMillis());
    }
    return getOffset(paramReadableInstant.getMillis());
  }
  
  public abstract int getStandardOffset(long paramLong);
  
  public boolean isStandardOffset(long paramLong)
  {
    return getOffset(paramLong) == getStandardOffset(paramLong);
  }
  
  public int getOffsetFromLocal(long paramLong)
  {
    int i = getOffset(paramLong);
    
    long l1 = paramLong - i;
    int j = getOffset(l1);
    long l2;
    if (i != j)
    {
      if (i - j < 0)
      {
        l2 = nextTransition(l1);
        if (l2 == paramLong - i) {
          l2 = Long.MAX_VALUE;
        }
        long l3 = nextTransition(paramLong - j);
        if (l3 == paramLong - j) {
          l3 = Long.MAX_VALUE;
        }
        if (l2 != l3) {
          return i;
        }
      }
    }
    else if (i >= 0)
    {
      l2 = previousTransition(l1);
      if (l2 < l1)
      {
        int k = getOffset(l2);
        int m = k - i;
        if (l1 - l2 <= m) {
          return k;
        }
      }
    }
    return j;
  }
  
  public long convertUTCToLocal(long paramLong)
  {
    int i = getOffset(paramLong);
    long l = paramLong + i;
    if (((paramLong ^ l) < 0L) && ((paramLong ^ i) >= 0L)) {
      throw new ArithmeticException("Adding time zone offset caused overflow");
    }
    return l;
  }
  
  public long convertLocalToUTC(long paramLong1, boolean paramBoolean, long paramLong2)
  {
    int i = getOffset(paramLong2);
    long l = paramLong1 - i;
    int j = getOffset(l);
    if (j == i) {
      return l;
    }
    return convertLocalToUTC(paramLong1, paramBoolean);
  }
  
  public long convertLocalToUTC(long paramLong, boolean paramBoolean)
  {
    int i = getOffset(paramLong);
    
    int j = getOffset(paramLong - i);
    if (i != j) {
      if ((paramBoolean) || (i < 0))
      {
        l1 = nextTransition(paramLong - i);
        if (l1 == paramLong - i) {
          l1 = Long.MAX_VALUE;
        }
        long l2 = nextTransition(paramLong - j);
        if (l2 == paramLong - j) {
          l2 = Long.MAX_VALUE;
        }
        if (l1 != l2)
        {
          if (paramBoolean) {
            throw new IllegalInstantException(paramLong, getID());
          }
          j = i;
        }
      }
    }
    long l1 = paramLong - j;
    if (((paramLong ^ l1) < 0L) && ((paramLong ^ j) < 0L)) {
      throw new ArithmeticException("Subtracting time zone offset caused overflow");
    }
    return l1;
  }
  
  public long getMillisKeepLocal(DateTimeZone paramDateTimeZone, long paramLong)
  {
    if (paramDateTimeZone == null) {
      paramDateTimeZone = getDefault();
    }
    if (paramDateTimeZone == this) {
      return paramLong;
    }
    long l = convertUTCToLocal(paramLong);
    return paramDateTimeZone.convertLocalToUTC(l, false, paramLong);
  }
  
  public boolean isLocalDateTimeGap(LocalDateTime paramLocalDateTime)
  {
    if (isFixed()) {
      return false;
    }
    try
    {
      paramLocalDateTime.toDateTime(this);
      return false;
    }
    catch (IllegalInstantException localIllegalInstantException) {}
    return true;
  }
  
  public long adjustOffset(long paramLong, boolean paramBoolean)
  {
    long l1 = paramLong - 10800000L;
    long l2 = paramLong + 10800000L;
    long l3 = getOffset(l1);
    long l4 = getOffset(l2);
    if (l3 <= l4) {
      return paramLong;
    }
    long l5 = l3 - l4;
    long l6 = nextTransition(l1);
    long l7 = l6 - l5;
    long l8 = l6 + l5;
    if ((paramLong < l7) || (paramLong >= l8)) {
      return paramLong;
    }
    long l9 = paramLong - l7;
    if (l9 >= l5) {
      return paramBoolean ? paramLong : paramLong - l5;
    }
    return paramBoolean ? paramLong + l5 : paramLong;
  }
  
  public abstract boolean isFixed();
  
  public abstract long nextTransition(long paramLong);
  
  public abstract long previousTransition(long paramLong);
  
  public TimeZone toTimeZone()
  {
    return TimeZone.getTimeZone(iID);
  }
  
  public abstract boolean equals(Object paramObject);
  
  public int hashCode()
  {
    return 57 + getID().hashCode();
  }
  
  public String toString()
  {
    return getID();
  }
  
  protected Object writeReplace()
    throws ObjectStreamException
  {
    return new Stub(iID);
  }
  
  private static final class Stub
    implements Serializable
  {
    private static final long serialVersionUID = -6471952376487863581L;
    private transient String iID;
    
    Stub(String paramString)
    {
      iID = paramString;
    }
    
    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.writeUTF(iID);
    }
    
    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException
    {
      iID = paramObjectInputStream.readUTF();
    }
    
    private Object readResolve()
      throws ObjectStreamException
    {
      return DateTimeZone.forID(iID);
    }
  }
  
  static final class LazyInit
  {
    static final Map<String, String> CONVERSION_MAP = ;
    static final DateTimeFormatter OFFSET_FORMATTER = buildFormatter();
    
    private static DateTimeFormatter buildFormatter()
    {
      BaseChronology local1 = new BaseChronology()
      {
        private static final long serialVersionUID = -3128740902654445468L;
        
        public DateTimeZone getZone()
        {
          return null;
        }
        
        public Chronology withUTC()
        {
          return this;
        }
        
        public Chronology withZone(DateTimeZone paramAnonymousDateTimeZone)
        {
          return this;
        }
        
        public String toString()
        {
          return getClass().getName();
        }
      };
      return new DateTimeFormatterBuilder().appendTimeZoneOffset(null, true, 2, 4).toFormatter().withChronology(local1);
    }
    
    private static Map<String, String> buildMap()
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("GMT", "UTC");
      localHashMap.put("WET", "WET");
      localHashMap.put("CET", "CET");
      localHashMap.put("MET", "CET");
      localHashMap.put("ECT", "CET");
      localHashMap.put("EET", "EET");
      localHashMap.put("MIT", "Pacific/Apia");
      localHashMap.put("HST", "Pacific/Honolulu");
      localHashMap.put("AST", "America/Anchorage");
      localHashMap.put("PST", "America/Los_Angeles");
      localHashMap.put("MST", "America/Denver");
      localHashMap.put("PNT", "America/Phoenix");
      localHashMap.put("CST", "America/Chicago");
      localHashMap.put("EST", "America/New_York");
      localHashMap.put("IET", "America/Indiana/Indianapolis");
      localHashMap.put("PRT", "America/Puerto_Rico");
      localHashMap.put("CNT", "America/St_Johns");
      localHashMap.put("AGT", "America/Argentina/Buenos_Aires");
      localHashMap.put("BET", "America/Sao_Paulo");
      localHashMap.put("ART", "Africa/Cairo");
      localHashMap.put("CAT", "Africa/Harare");
      localHashMap.put("EAT", "Africa/Addis_Ababa");
      localHashMap.put("NET", "Asia/Yerevan");
      localHashMap.put("PLT", "Asia/Karachi");
      localHashMap.put("IST", "Asia/Kolkata");
      localHashMap.put("BST", "Asia/Dhaka");
      localHashMap.put("VST", "Asia/Ho_Chi_Minh");
      localHashMap.put("CTT", "Asia/Shanghai");
      localHashMap.put("JST", "Asia/Tokyo");
      localHashMap.put("ACT", "Australia/Darwin");
      localHashMap.put("AET", "Australia/Sydney");
      localHashMap.put("SST", "Pacific/Guadalcanal");
      localHashMap.put("NST", "Pacific/Auckland");
      return Collections.unmodifiableMap(localHashMap);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */