package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaVersionParser
{
  public static final String JAVA_VERSION_PROPERTY = "java.version";
  private static String MAJOR_VERSION_FAMILY_PATTERN = "\\d+";
  private static String MAJOR_VERSION_PATTERN = "\\d+";
  private static String MAINTENANCE_NUMBER_PATTERN = "\\d+";
  private static String UPDATE_NUMBER_PATTERN = "\\d+";
  private static Pattern VERSION_REGEX = Pattern.compile(String.format("(%s)\\.(%s)\\.(%s)(?:_(%s))?.*", new Object[] { MAJOR_VERSION_FAMILY_PATTERN, MAJOR_VERSION_PATTERN, MAINTENANCE_NUMBER_PATTERN, UPDATE_NUMBER_PATTERN }));
  private static final JavaVersion currentJavaVersion = parseJavaVersion(System.getProperty("java.version"));
  
  public static JavaVersion getCurrentJavaVersion()
  {
    return currentJavaVersion;
  }
  
  public static JavaVersion parseJavaVersion(String fullVersionString)
  {
    if (!StringUtils.isNullOrEmpty(fullVersionString))
    {
      Matcher matcher = VERSION_REGEX.matcher(fullVersionString);
      if (matcher.matches())
      {
        Integer majorVersionFamily = NumberUtils.tryParseInt(matcher.group(1));
        Integer majorVersion = NumberUtils.tryParseInt(matcher.group(2));
        Integer maintenanceNumber = NumberUtils.tryParseInt(matcher.group(3));
        Integer updateNumber = NumberUtils.tryParseInt(matcher.group(4));
        return new JavaVersion(majorVersionFamily, majorVersion, maintenanceNumber, updateNumber);
      }
    }
    return JavaVersion.UNKNOWN;
  }
  
  public static final class JavaVersion
    implements Comparable<JavaVersion>
  {
    public static final JavaVersion UNKNOWN = new JavaVersion(null, null, null, null);
    private final Integer[] tokenizedVersion;
    private final Integer majorVersionFamily;
    private final Integer majorVersion;
    private final Integer maintenanceNumber;
    private final Integer updateNumber;
    private final JavaVersionParser.KnownJavaVersions knownVersion;
    
    public JavaVersion(Integer majorVersionFamily, Integer majorVersion, Integer maintenanceNumber, Integer updateNumber)
    {
      this.majorVersionFamily = majorVersionFamily;
      this.majorVersion = majorVersion;
      this.maintenanceNumber = maintenanceNumber;
      this.updateNumber = updateNumber;
      knownVersion = JavaVersionParser.KnownJavaVersions.fromMajorVersion(majorVersionFamily, majorVersion);
      tokenizedVersion = getTokenizedVersion();
    }
    
    private Integer[] getTokenizedVersion()
    {
      return new Integer[] { majorVersionFamily, majorVersion, maintenanceNumber, updateNumber };
    }
    
    public Integer getMajorVersionFamily()
    {
      return majorVersionFamily;
    }
    
    public Integer getMajorVersion()
    {
      return majorVersion;
    }
    
    public String getMajorVersionString()
    {
      return String.format("%d.%d", new Object[] { majorVersionFamily, majorVersion });
    }
    
    public Integer getMaintenanceNumber()
    {
      return maintenanceNumber;
    }
    
    public Integer getUpdateNumber()
    {
      return updateNumber;
    }
    
    public JavaVersionParser.KnownJavaVersions getKnownVersion()
    {
      return knownVersion;
    }
    
    public int compareTo(JavaVersion other)
    {
      for (int i = 0; i < tokenizedVersion.length; i++)
      {
        int tokenComparison = ComparableUtils.safeCompare(tokenizedVersion[i], tokenizedVersion[i]);
        if (tokenComparison != 0) {
          return tokenComparison;
        }
      }
      return 0;
    }
    
    public int hashCode()
    {
      int prime = 31;
      int result = 1;
      result = 31 * result + (knownVersion == null ? 0 : knownVersion.hashCode());
      result = 31 * result + (maintenanceNumber == null ? 0 : maintenanceNumber.hashCode());
      result = 31 * result + (majorVersion == null ? 0 : majorVersion.hashCode());
      result = 31 * result + (majorVersionFamily == null ? 0 : majorVersionFamily.hashCode());
      result = 31 * result + Arrays.hashCode(tokenizedVersion);
      result = 31 * result + (updateNumber == null ? 0 : updateNumber.hashCode());
      return result;
    }
    
    public boolean equals(Object obj)
    {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      JavaVersion other = (JavaVersion)obj;
      if (knownVersion != knownVersion) {
        return false;
      }
      if (maintenanceNumber == null)
      {
        if (maintenanceNumber != null) {
          return false;
        }
      }
      else if (!maintenanceNumber.equals(maintenanceNumber)) {
        return false;
      }
      if (majorVersion == null)
      {
        if (majorVersion != null) {
          return false;
        }
      }
      else if (!majorVersion.equals(majorVersion)) {
        return false;
      }
      if (majorVersionFamily == null)
      {
        if (majorVersionFamily != null) {
          return false;
        }
      }
      else if (!majorVersionFamily.equals(majorVersionFamily)) {
        return false;
      }
      if (!Arrays.equals(tokenizedVersion, tokenizedVersion)) {
        return false;
      }
      if (updateNumber == null)
      {
        if (updateNumber != null) {
          return false;
        }
      }
      else if (!updateNumber.equals(updateNumber)) {
        return false;
      }
      return true;
    }
  }
  
  public static enum KnownJavaVersions
  {
    JAVA_6(1, 6),  JAVA_7(1, 7),  JAVA_8(1, 8),  JAVA_9(1, 9),  UNKNOWN(0, -1);
    
    private Integer knownMajorVersionFamily;
    private Integer knownMajorVersion;
    
    private KnownJavaVersions(int majorVersionFamily, int majorVersion)
    {
      knownMajorVersionFamily = Integer.valueOf(majorVersionFamily);
      knownMajorVersion = Integer.valueOf(majorVersion);
    }
    
    public static KnownJavaVersions fromMajorVersion(Integer majorVersionFamily, Integer majorVersion)
    {
      for (KnownJavaVersions version : ) {
        if (version.isMajorVersion(majorVersionFamily, majorVersion)) {
          return version;
        }
      }
      return UNKNOWN;
    }
    
    private boolean isMajorVersion(Integer majorVersionFamily, Integer majorVersion)
    {
      return (knownMajorVersionFamily.equals(majorVersionFamily)) && 
        (knownMajorVersion.equals(majorVersion));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.JavaVersionParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */