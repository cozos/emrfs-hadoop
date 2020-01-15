package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.IOCase;
import java.io.File;
import java.io.Serializable;
import java.util.List;

public class NameFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private final String[] names;
  private final IOCase caseSensitivity;
  
  public NameFileFilter(String name)
  {
    this(name, null);
  }
  
  public NameFileFilter(String name, IOCase caseSensitivity)
  {
    if (name == null) {
      throw new IllegalArgumentException("The wildcard must not be null");
    }
    names = new String[] { name };
    this.caseSensitivity = (caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity);
  }
  
  public NameFileFilter(String[] names)
  {
    this(names, null);
  }
  
  public NameFileFilter(String[] names, IOCase caseSensitivity)
  {
    if (names == null) {
      throw new IllegalArgumentException("The array of names must not be null");
    }
    this.names = new String[names.length];
    System.arraycopy(names, 0, this.names, 0, names.length);
    this.caseSensitivity = (caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity);
  }
  
  public NameFileFilter(List<String> names)
  {
    this(names, null);
  }
  
  public NameFileFilter(List<String> names, IOCase caseSensitivity)
  {
    if (names == null) {
      throw new IllegalArgumentException("The list of names must not be null");
    }
    this.names = ((String[])names.toArray(new String[names.size()]));
    this.caseSensitivity = (caseSensitivity == null ? IOCase.SENSITIVE : caseSensitivity);
  }
  
  public boolean accept(File file)
  {
    String name = file.getName();
    for (String name2 : names) {
      if (caseSensitivity.checkEquals(name, name2)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean accept(File dir, String name)
  {
    for (String name2 : names) {
      if (caseSensitivity.checkEquals(name, name2)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder buffer = new StringBuilder();
    buffer.append(super.toString());
    buffer.append("(");
    if (names != null) {
      for (int i = 0; i < names.length; i++)
      {
        if (i > 0) {
          buffer.append(",");
        }
        buffer.append(names[i]);
      }
    }
    buffer.append(")");
    return buffer.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter.NameFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */