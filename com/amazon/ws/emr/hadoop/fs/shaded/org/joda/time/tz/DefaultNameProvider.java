package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeUtils;
import java.text.DateFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DefaultNameProvider
  implements NameProvider
{
  private HashMap<Locale, Map<String, Map<String, Object>>> iByLocaleCache = createCache();
  private HashMap<Locale, Map<String, Map<Boolean, Object>>> iByLocaleCache2 = createCache();
  
  public String getShortName(Locale paramLocale, String paramString1, String paramString2)
  {
    String[] arrayOfString = getNameSet(paramLocale, paramString1, paramString2);
    return arrayOfString == null ? null : arrayOfString[0];
  }
  
  public String getName(Locale paramLocale, String paramString1, String paramString2)
  {
    String[] arrayOfString = getNameSet(paramLocale, paramString1, paramString2);
    return arrayOfString == null ? null : arrayOfString[1];
  }
  
  private synchronized String[] getNameSet(Locale paramLocale, String paramString1, String paramString2)
  {
    if ((paramLocale == null) || (paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    Object localObject1 = (Map)iByLocaleCache.get(paramLocale);
    if (localObject1 == null) {
      iByLocaleCache.put(paramLocale, localObject1 = createCache());
    }
    Object localObject2 = (Map)((Map)localObject1).get(paramString1);
    if (localObject2 == null)
    {
      ((Map)localObject1).put(paramString1, localObject2 = createCache());
      
      String[][] arrayOfString1 = DateTimeUtils.getDateFormatSymbols(Locale.ENGLISH).getZoneStrings();
      Object localObject3 = null;
      for (String[] arrayOfString4 : arrayOfString1) {
        if ((arrayOfString4 != null) && (arrayOfString4.length >= 5) && (paramString1.equals(arrayOfString4[0])))
        {
          localObject3 = arrayOfString4;
          break;
        }
      }
      ??? = DateTimeUtils.getDateFormatSymbols(paramLocale).getZoneStrings();
      Object localObject4 = null;
      for (String[] arrayOfString5 : ???) {
        if ((arrayOfString5 != null) && (arrayOfString5.length >= 5) && (paramString1.equals(arrayOfString5[0])))
        {
          localObject4 = arrayOfString5;
          break;
        }
      }
      if ((localObject3 != null) && (localObject4 != null))
      {
        ((Map)localObject2).put(localObject3[2], new String[] { localObject4[2], localObject4[1] });
        if (localObject3[2].equals(localObject3[4])) {
          ((Map)localObject2).put(localObject3[4] + "-Summer", new String[] { localObject4[4], localObject4[3] });
        } else {
          ((Map)localObject2).put(localObject3[4], new String[] { localObject4[4], localObject4[3] });
        }
      }
    }
    return (String[])((Map)localObject2).get(paramString2);
  }
  
  public String getShortName(Locale paramLocale, String paramString1, String paramString2, boolean paramBoolean)
  {
    String[] arrayOfString = getNameSet(paramLocale, paramString1, paramString2, paramBoolean);
    return arrayOfString == null ? null : arrayOfString[0];
  }
  
  public String getName(Locale paramLocale, String paramString1, String paramString2, boolean paramBoolean)
  {
    String[] arrayOfString = getNameSet(paramLocale, paramString1, paramString2, paramBoolean);
    return arrayOfString == null ? null : arrayOfString[1];
  }
  
  private synchronized String[] getNameSet(Locale paramLocale, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramLocale == null) || (paramString1 == null) || (paramString2 == null)) {
      return null;
    }
    if (paramString1.startsWith("Etc/")) {
      paramString1 = paramString1.substring(4);
    }
    Object localObject1 = (Map)iByLocaleCache2.get(paramLocale);
    if (localObject1 == null) {
      iByLocaleCache2.put(paramLocale, localObject1 = createCache());
    }
    Object localObject2 = (Map)((Map)localObject1).get(paramString1);
    if (localObject2 == null)
    {
      ((Map)localObject1).put(paramString1, localObject2 = createCache());
      
      String[][] arrayOfString1 = DateTimeUtils.getDateFormatSymbols(Locale.ENGLISH).getZoneStrings();
      Object localObject3 = null;
      for (String[] arrayOfString4 : arrayOfString1) {
        if ((arrayOfString4 != null) && (arrayOfString4.length >= 5) && (paramString1.equals(arrayOfString4[0])))
        {
          localObject3 = arrayOfString4;
          break;
        }
      }
      ??? = DateTimeUtils.getDateFormatSymbols(paramLocale).getZoneStrings();
      Object localObject4 = null;
      for (String[] arrayOfString5 : ???) {
        if ((arrayOfString5 != null) && (arrayOfString5.length >= 5) && (paramString1.equals(arrayOfString5[0])))
        {
          localObject4 = arrayOfString5;
          break;
        }
      }
      if ((localObject3 != null) && (localObject4 != null))
      {
        ((Map)localObject2).put(Boolean.TRUE, new String[] { localObject4[2], localObject4[1] });
        ((Map)localObject2).put(Boolean.FALSE, new String[] { localObject4[4], localObject4[3] });
      }
    }
    return (String[])((Map)localObject2).get(Boolean.valueOf(paramBoolean));
  }
  
  private HashMap createCache()
  {
    return new HashMap(7);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.DefaultNameProvider
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */