package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import lombok.NonNull;

public final class UploadObserverContext$Store$Key<T>
{
  private static final String NAMESPACE_SEPARATOR = "#";
  @NonNull
  private final String name;
  
  private UploadObserverContext$Store$Key(@NonNull String name)
  {
    if (name == null) {
      throw new NullPointerException("name");
    }
    this.name = name;
  }
  
  public static <T> Key<T> named(@NonNull String name)
  {
    return new Key(name);
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Key)) {
      return false;
    }
    Key<?> other = (Key)o;Object this$name = getName();Object other$name = other.getName();return this$name == null ? other$name == null : this$name.equals(other$name);
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $name = getName();result = result * 59 + ($name == null ? 43 : $name.hashCode());return result;
  }
  
  public String toString()
  {
    return "UploadObserverContext.Store.Key(name=" + getName() + ")";
  }
  
  @NonNull
  public String getName()
  {
    return name;
  }
  
  public static <T> Key<T> named(@NonNull Class<?> namespace, @NonNull String name)
  {
    if (namespace == null) {
      throw new NullPointerException("namespace");
    }
    if (name == null) {
      throw new NullPointerException("name");
    }
    return named(namespace.getName() + "#" + name);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.UploadObserverContext.Store.Key
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */