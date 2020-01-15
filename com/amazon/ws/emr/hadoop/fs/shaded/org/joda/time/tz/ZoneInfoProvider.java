package com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz;

import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTimeZone;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class ZoneInfoProvider
  implements Provider
{
  private final File iFileDir;
  private final String iResourcePath;
  private final ClassLoader iLoader;
  private final Map<String, Object> iZoneInfoMap;
  private final Set<String> iZoneInfoKeys;
  
  public ZoneInfoProvider(File paramFile)
    throws IOException
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("No file directory provided");
    }
    if (!paramFile.exists()) {
      throw new IOException("File directory doesn't exist: " + paramFile);
    }
    if (!paramFile.isDirectory()) {
      throw new IOException("File doesn't refer to a directory: " + paramFile);
    }
    iFileDir = paramFile;
    iResourcePath = null;
    iLoader = null;
    
    iZoneInfoMap = loadZoneInfoMap(openResource("ZoneInfoMap"));
    iZoneInfoKeys = Collections.unmodifiableSortedSet(new TreeSet(iZoneInfoMap.keySet()));
  }
  
  public ZoneInfoProvider(String paramString)
    throws IOException
  {
    this(paramString, null, false);
  }
  
  public ZoneInfoProvider(String paramString, ClassLoader paramClassLoader)
    throws IOException
  {
    this(paramString, paramClassLoader, true);
  }
  
  private ZoneInfoProvider(String paramString, ClassLoader paramClassLoader, boolean paramBoolean)
    throws IOException
  {
    if (paramString == null) {
      throw new IllegalArgumentException("No resource path provided");
    }
    if (!paramString.endsWith("/")) {
      paramString = paramString + '/';
    }
    iFileDir = null;
    iResourcePath = paramString;
    if ((paramClassLoader == null) && (!paramBoolean)) {
      paramClassLoader = getClass().getClassLoader();
    }
    iLoader = paramClassLoader;
    
    iZoneInfoMap = loadZoneInfoMap(openResource("ZoneInfoMap"));
    iZoneInfoKeys = Collections.unmodifiableSortedSet(new TreeSet(iZoneInfoMap.keySet()));
  }
  
  public DateTimeZone getZone(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = iZoneInfoMap.get(paramString);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof SoftReference))
    {
      SoftReference localSoftReference = (SoftReference)localObject;
      DateTimeZone localDateTimeZone = (DateTimeZone)localSoftReference.get();
      if (localDateTimeZone != null) {
        return localDateTimeZone;
      }
      return loadZoneData(paramString);
    }
    if (paramString.equals(localObject)) {
      return loadZoneData(paramString);
    }
    return getZone((String)localObject);
  }
  
  public Set<String> getAvailableIDs()
  {
    return iZoneInfoKeys;
  }
  
  protected void uncaughtException(Exception paramException)
  {
    paramException.printStackTrace();
  }
  
  private InputStream openResource(String paramString)
    throws IOException
  {
    Object localObject;
    if (iFileDir != null)
    {
      localObject = new FileInputStream(new File(iFileDir, paramString));
    }
    else
    {
      String str = iResourcePath.concat(paramString);
      if (iLoader != null) {
        localObject = iLoader.getResourceAsStream(str);
      } else {
        localObject = ClassLoader.getSystemResourceAsStream(str);
      }
      if (localObject == null)
      {
        StringBuilder localStringBuilder = new StringBuilder(40).append("Resource not found: \"").append(str).append("\" ClassLoader: ").append(iLoader != null ? iLoader.toString() : "system");
        
        throw new IOException(localStringBuilder.toString());
      }
    }
    return (InputStream)localObject;
  }
  
  private DateTimeZone loadZoneData(String paramString)
  {
    InputStream localInputStream = null;
    try
    {
      localInputStream = openResource(paramString);
      DateTimeZone localDateTimeZone1 = DateTimeZoneBuilder.readFrom(localInputStream, paramString);
      iZoneInfoMap.put(paramString, new SoftReference(localDateTimeZone1));
      return localDateTimeZone1;
    }
    catch (IOException localIOException1)
    {
      DateTimeZone localDateTimeZone2;
      uncaughtException(localIOException1);
      iZoneInfoMap.remove(paramString);
      return null;
    }
    finally
    {
      try
      {
        if (localInputStream != null) {
          localInputStream.close();
        }
      }
      catch (IOException localIOException4) {}
    }
  }
  
  private static Map<String, Object> loadZoneInfoMap(InputStream paramInputStream)
    throws IOException
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    DataInputStream localDataInputStream = new DataInputStream(paramInputStream);
    try
    {
      readZoneInfoMap(localDataInputStream, localConcurrentHashMap);
      try
      {
        localDataInputStream.close();
      }
      catch (IOException localIOException1) {}
      localConcurrentHashMap.put("UTC", new SoftReference(DateTimeZone.UTC));
    }
    finally
    {
      try
      {
        localDataInputStream.close();
      }
      catch (IOException localIOException2) {}
    }
    return localConcurrentHashMap;
  }
  
  private static void readZoneInfoMap(DataInputStream paramDataInputStream, Map<String, Object> paramMap)
    throws IOException
  {
    int i = paramDataInputStream.readUnsignedShort();
    String[] arrayOfString = new String[i];
    for (int j = 0; j < i; j++) {
      arrayOfString[j] = paramDataInputStream.readUTF().intern();
    }
    i = paramDataInputStream.readUnsignedShort();
    for (j = 0; j < i; j++) {
      try
      {
        paramMap.put(arrayOfString[paramDataInputStream.readUnsignedShort()], arrayOfString[paramDataInputStream.readUnsignedShort()]);
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        throw new IOException("Corrupt zone info map");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.tz.ZoneInfoProvider
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */