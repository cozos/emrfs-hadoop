package com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch;

import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;

public final class UploadObserverContext
{
  public UploadObserverContext(@NonNull String bucket, @NonNull String key, @NonNull ExtraUploadMetadata extraUploadMetadata)
  {
    if (bucket == null) {
      throw new NullPointerException("bucket");
    }
    if (key == null) {
      throw new NullPointerException("key");
    }
    if (extraUploadMetadata == null) {
      throw new NullPointerException("extraUploadMetadata");
    }
    this.bucket = bucket;this.key = key;this.extraUploadMetadata = extraUploadMetadata;
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof UploadObserverContext)) {
      return false;
    }
    UploadObserverContext other = (UploadObserverContext)o;Object this$bucket = getBucket();Object other$bucket = other.getBucket();
    if (this$bucket == null ? other$bucket != null : !this$bucket.equals(other$bucket)) {
      return false;
    }
    Object this$key = getKey();Object other$key = other.getKey();
    if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
      return false;
    }
    Object this$extraUploadMetadata = getExtraUploadMetadata();Object other$extraUploadMetadata = other.getExtraUploadMetadata();
    if (this$extraUploadMetadata == null ? other$extraUploadMetadata != null : !this$extraUploadMetadata.equals(other$extraUploadMetadata)) {
      return false;
    }
    Object this$store = getStore();Object other$store = other.getStore();return this$store == null ? other$store == null : this$store.equals(other$store);
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;Object $bucket = getBucket();result = result * 59 + ($bucket == null ? 43 : $bucket.hashCode());Object $key = getKey();result = result * 59 + ($key == null ? 43 : $key.hashCode());Object $extraUploadMetadata = getExtraUploadMetadata();result = result * 59 + ($extraUploadMetadata == null ? 43 : $extraUploadMetadata.hashCode());Object $store = getStore();result = result * 59 + ($store == null ? 43 : $store.hashCode());return result;
  }
  
  public String toString()
  {
    return "UploadObserverContext(bucket=" + getBucket() + ", key=" + getKey() + ", extraUploadMetadata=" + getExtraUploadMetadata() + ", store=" + getStore() + ")";
  }
  
  public static final UploadObserverContext.Store.Key<String> ETAG_VERIFICATION_KEY = UploadObserverContext.Store.Key.named(UploadObserverContext.class, "eTagVerification");
  @NonNull
  private final String bucket;
  @NonNull
  private final String key;
  @NonNull
  private final ExtraUploadMetadata extraUploadMetadata;
  
  public static abstract interface Store
  {
    public abstract <T> T get(Key<T> paramKey);
    
    public abstract <T> void put(Key<T> paramKey, T paramT);
    
    public static final class Key<T>
    {
      private static final String NAMESPACE_SEPARATOR = "#";
      @NonNull
      private final String name;
      
      private Key(@NonNull String name)
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
  }
  
  @NonNull
  public String getBucket()
  {
    return bucket;
  }
  
  @NonNull
  public String getKey()
  {
    return key;
  }
  
  @NonNull
  public ExtraUploadMetadata getExtraUploadMetadata()
  {
    return extraUploadMetadata;
  }
  
  public Store getStore()
  {
    return store;
  }
  
  private final Store store = new BasicStore(null);
  
  public UploadObserverContext(String bucket, String key)
  {
    this(bucket, key, ExtraUploadMetadata.empty());
  }
  
  private static final class BasicStore
    implements UploadObserverContext.Store
  {
    public String toString()
    {
      return "UploadObserverContext.BasicStore(storedValues=" + storedValues + ")";
    }
    
    public boolean equals(Object o)
    {
      if (o == this) {
        return true;
      }
      if (!(o instanceof BasicStore)) {
        return false;
      }
      BasicStore other = (BasicStore)o;Object this$storedValues = storedValues;Object other$storedValues = storedValues;return this$storedValues == null ? other$storedValues == null : this$storedValues.equals(other$storedValues);
    }
    
    public int hashCode()
    {
      int PRIME = 59;int result = 1;Object $storedValues = storedValues;result = result * 59 + ($storedValues == null ? 43 : $storedValues.hashCode());return result;
    }
    
    private final Map<UploadObserverContext.Store.Key<?>, Object> storedValues = new HashMap();
    
    public <T> T get(@NonNull UploadObserverContext.Store.Key<T> key)
    {
      if (key == null) {
        throw new NullPointerException("key");
      }
      return (T)storedValues.get(key);
    }
    
    public <T> void put(@NonNull UploadObserverContext.Store.Key<T> key, T value)
    {
      if (key == null) {
        throw new NullPointerException("key");
      }
      storedValues.put(key, value);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.upload.dispatch.UploadObserverContext
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */