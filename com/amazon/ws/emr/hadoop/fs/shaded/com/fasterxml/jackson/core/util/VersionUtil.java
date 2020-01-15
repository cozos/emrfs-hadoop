package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Versioned;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;
import java.util.regex.Pattern;

public class VersionUtil
{
  private static final Pattern V_SEP = Pattern.compile("[-_./;:]");
  private final Version _v;
  
  protected VersionUtil()
  {
    Version v = null;
    try
    {
      v = versionFor(getClass());
    }
    catch (Exception e)
    {
      System.err.println("ERROR: Failed to load Version information from " + getClass());
    }
    if (v == null) {
      v = Version.unknownVersion();
    }
    _v = v;
  }
  
  public Version version()
  {
    return _v;
  }
  
  public static Version versionFor(Class<?> cls)
  {
    return packageVersionFor(cls);
  }
  
  public static Version packageVersionFor(Class<?> cls)
  {
    Version v = null;
    try
    {
      String versionInfoClassName = cls.getPackage().getName() + ".PackageVersion";
      Class<?> vClass = Class.forName(versionInfoClassName, true, cls.getClassLoader());
      try
      {
        v = ((Versioned)vClass.newInstance()).version();
      }
      catch (Exception e)
      {
        throw new IllegalArgumentException("Failed to get Versioned out of " + vClass);
      }
    }
    catch (Exception e) {}
    return v == null ? Version.unknownVersion() : v;
  }
  
  @Deprecated
  public static Version mavenVersionFor(ClassLoader cl, String groupId, String artifactId)
  {
    InputStream pomProperties = cl.getResourceAsStream("META-INF/maven/" + groupId.replaceAll("\\.", "/") + "/" + artifactId + "/pom.properties");
    if (pomProperties != null) {
      try
      {
        Properties props = new Properties();
        props.load(pomProperties);
        String versionStr = props.getProperty("version");
        String pomPropertiesArtifactId = props.getProperty("artifactId");
        String pomPropertiesGroupId = props.getProperty("groupId");
        return parseVersion(versionStr, pomPropertiesGroupId, pomPropertiesArtifactId);
      }
      catch (IOException e) {}finally
      {
        _close(pomProperties);
      }
    }
    return Version.unknownVersion();
  }
  
  public static Version parseVersion(String s, String groupId, String artifactId)
  {
    if ((s != null) && ((s = s.trim()).length() > 0))
    {
      String[] parts = V_SEP.split(s);
      return new Version(parseVersionPart(parts[0]), parts.length > 1 ? parseVersionPart(parts[1]) : 0, parts.length > 2 ? parseVersionPart(parts[2]) : 0, parts.length > 3 ? parts[3] : null, groupId, artifactId);
    }
    return Version.unknownVersion();
  }
  
  protected static int parseVersionPart(String s)
  {
    int number = 0;
    int i = 0;
    for (int len = s.length(); i < len; i++)
    {
      char c = s.charAt(i);
      if ((c > '9') || (c < '0')) {
        break;
      }
      number = number * 10 + (c - '0');
    }
    return number;
  }
  
  private static final void _close(Closeable c)
  {
    try
    {
      c.close();
    }
    catch (IOException e) {}
  }
  
  public static final void throwInternal()
  {
    throw new RuntimeException("Internal error: this code path should never get executed");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.VersionUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */