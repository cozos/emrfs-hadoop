package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import java.util.Arrays;

public final class JavaVersionParser$JavaVersion
  implements Comparable<JavaVersion>
{
  public static final JavaVersion UNKNOWN = new JavaVersion(null, null, null, null);
  private final Integer[] tokenizedVersion;
  private final Integer majorVersionFamily;
  private final Integer majorVersion;
  private final Integer maintenanceNumber;
  private final Integer updateNumber;
  private final JavaVersionParser.KnownJavaVersions knownVersion;
  
  public JavaVersionParser$JavaVersion(Integer majorVersionFamily, Integer majorVersion, Integer maintenanceNumber, Integer updateNumber)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.JavaVersionParser.JavaVersion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */