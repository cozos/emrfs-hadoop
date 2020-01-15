package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

class NamespaceRemovingInputStream
  extends SdkFilterInputStream
{
  private byte[] lookAheadData = new byte['È'];
  private boolean hasRemovedNamespace = false;
  
  public NamespaceRemovingInputStream(InputStream in)
  {
    super(new BufferedInputStream(in));
  }
  
  public int read()
    throws IOException
  {
    abortIfNeeded();
    int b = in.read();
    if ((b == 120) && (!hasRemovedNamespace))
    {
      lookAheadData[0] = ((byte)b);
      in.mark(lookAheadData.length);
      int bytesRead = in.read(lookAheadData, 1, lookAheadData.length - 1);
      in.reset();
      
      String string = new String(lookAheadData, 0, bytesRead + 1, StringUtils.UTF8);
      
      int numberCharsMatched = matchXmlNamespaceAttribute(string);
      if (numberCharsMatched > 0)
      {
        for (int i = 0; i < numberCharsMatched - 1; i++) {
          in.read();
        }
        b = in.read();
        hasRemovedNamespace = true;
      }
    }
    return b;
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    for (int i = 0; i < len; i++)
    {
      int j = read();
      if (j == -1)
      {
        if (i == 0) {
          return -1;
        }
        return i;
      }
      b[(i + off)] = ((byte)j);
    }
    return len;
  }
  
  public int read(byte[] b)
    throws IOException
  {
    return read(b, 0, b.length);
  }
  
  private int matchXmlNamespaceAttribute(String s)
  {
    StringPrefixSlicer stringSlicer = new StringPrefixSlicer(s);
    if (!stringSlicer.removePrefix("xmlns")) {
      return -1;
    }
    stringSlicer.removeRepeatingPrefix(" ");
    if (!stringSlicer.removePrefix("=")) {
      return -1;
    }
    stringSlicer.removeRepeatingPrefix(" ");
    if (!stringSlicer.removePrefix("\"")) {
      return -1;
    }
    if (!stringSlicer.removePrefixEndingWith("\"")) {
      return -1;
    }
    return s.length() - stringSlicer.getString().length();
  }
  
  private static final class StringPrefixSlicer
  {
    private String s;
    
    public StringPrefixSlicer(String s)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.NamespaceRemovingInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */