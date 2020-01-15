package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

final class NamespaceRemovingInputStream$StringPrefixSlicer
{
  private String s;
  
  public NamespaceRemovingInputStream$StringPrefixSlicer(String s)
  {
    this.s = s;
  }
  
  public String getString()
  {
    return s;
  }
  
  public boolean removePrefix(String prefix)
  {
    if (!s.startsWith(prefix)) {
      return false;
    }
    s = s.substring(prefix.length());
    return true;
  }
  
  public boolean removeRepeatingPrefix(String prefix)
  {
    if (!s.startsWith(prefix)) {
      return false;
    }
    while (s.startsWith(prefix)) {
      s = s.substring(prefix.length());
    }
    return true;
  }
  
  public boolean removePrefixEndingWith(String marker)
  {
    int i = s.indexOf(marker);
    if (i < 0) {
      return false;
    }
    s = s.substring(i + marker.length());
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.NamespaceRemovingInputStream.StringPrefixSlicer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */