package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core;

import java.io.Serializable;

public class Version
  implements Comparable<Version>, Serializable
{
  private static final long serialVersionUID = 1L;
  private static final Version UNKNOWN_VERSION = new Version(0, 0, 0, null, null, null);
  protected final int _majorVersion;
  protected final int _minorVersion;
  protected final int _patchLevel;
  protected final String _groupId;
  protected final String _artifactId;
  protected final String _snapshotInfo;
  
  @Deprecated
  public Version(int major, int minor, int patchLevel, String snapshotInfo)
  {
    this(major, minor, patchLevel, snapshotInfo, null, null);
  }
  
  public Version(int major, int minor, int patchLevel, String snapshotInfo, String groupId, String artifactId)
  {
    _majorVersion = major;
    _minorVersion = minor;
    _patchLevel = patchLevel;
    _snapshotInfo = snapshotInfo;
    _groupId = (groupId == null ? "" : groupId);
    _artifactId = (artifactId == null ? "" : artifactId);
  }
  
  public static Version unknownVersion()
  {
    return UNKNOWN_VERSION;
  }
  
  public boolean isUknownVersion()
  {
    return this == UNKNOWN_VERSION;
  }
  
  public boolean isUnknownVersion()
  {
    return this == UNKNOWN_VERSION;
  }
  
  public boolean isSnapshot()
  {
    return (_snapshotInfo != null) && (_snapshotInfo.length() > 0);
  }
  
  public int getMajorVersion()
  {
    return _majorVersion;
  }
  
  public int getMinorVersion()
  {
    return _minorVersion;
  }
  
  public int getPatchLevel()
  {
    return _patchLevel;
  }
  
  public String getGroupId()
  {
    return _groupId;
  }
  
  public String getArtifactId()
  {
    return _artifactId;
  }
  
  public String toFullString()
  {
    return _groupId + '/' + _artifactId + '/' + toString();
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append(_majorVersion).append('.');
    sb.append(_minorVersion).append('.');
    sb.append(_patchLevel);
    if (isSnapshot()) {
      sb.append('-').append(_snapshotInfo);
    }
    return sb.toString();
  }
  
  public int hashCode()
  {
    return _artifactId.hashCode() ^ _groupId.hashCode() + _majorVersion - _minorVersion + _patchLevel;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (o.getClass() != getClass()) {
      return false;
    }
    Version other = (Version)o;
    return (_majorVersion == _majorVersion) && (_minorVersion == _minorVersion) && (_patchLevel == _patchLevel) && (_artifactId.equals(_artifactId)) && (_groupId.equals(_groupId));
  }
  
  public int compareTo(Version other)
  {
    if (other == this) {
      return 0;
    }
    int diff = _groupId.compareTo(_groupId);
    if (diff == 0)
    {
      diff = _artifactId.compareTo(_artifactId);
      if (diff == 0)
      {
        diff = _majorVersion - _majorVersion;
        if (diff == 0)
        {
          diff = _minorVersion - _minorVersion;
          if (diff == 0) {
            diff = _patchLevel - _patchLevel;
          }
        }
      }
    }
    return diff;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.Version
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */