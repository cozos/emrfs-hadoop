package com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import java.util.List;
import lombok.NonNull;

final class Key
  implements Comparable<Key>
{
  private static final String DELIMITER = "/";
  private final List<String> components;
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Key)) {
      return false;
    }
    Key other = (Key)o;Object this$components = getComponents();Object other$components = other.getComponents();return this$components == null ? other$components == null : this$components.equals(other$components);
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $components = getComponents();result = result * 59 + ($components == null ? 43 : $components.hashCode());return result;
  }
  
  private Key(List<String> components)
  {
    this.components = components;
  }
  
  public List<String> getComponents()
  {
    return components;
  }
  
  static Key of(@NonNull List<String> components)
  {
    if (components == null) {
      throw new NullPointerException("components");
    }
    return new Key(ImmutableList.copyOf(components));
  }
  
  public String toString()
  {
    return Joiner.on("/").join(components);
  }
  
  public int compareTo(Key other)
  {
    int size1 = components.size();
    int size2 = components.size();
    int minSize = Math.min(size1, size2);
    for (int i = 0; i < minSize; i++)
    {
      int componentComparision = ((String)components.get(i)).compareTo((String)components.get(i));
      if (componentComparision != 0) {
        return componentComparision;
      }
    }
    return size1 - size2;
  }
  
  boolean startsWith(Key key)
  {
    if (components.size() < components.size()) {
      return false;
    }
    for (int i = 0; i < components.size(); i++) {
      if (!((String)components.get(i)).equals(components.get(i))) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory.Key
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */