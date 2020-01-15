package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

public enum JavaVersionParser$KnownJavaVersions
{
  JAVA_6(1, 6),  JAVA_7(1, 7),  JAVA_8(1, 8),  JAVA_9(1, 9),  UNKNOWN(0, -1);
  
  private Integer knownMajorVersionFamily;
  private Integer knownMajorVersion;
  
  private JavaVersionParser$KnownJavaVersions(int majorVersionFamily, int majorVersion)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.JavaVersionParser.KnownJavaVersions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */