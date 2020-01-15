package com.amazon.ws.emr.hadoop.fs.consistency;

import com.amazon.ws.emr.hadoop.fs.consistency.exception.MalformedItemKeyException;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Splitter;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.net.URI;
import java.util.Iterator;
import lombok.NonNull;
import org.apache.hadoop.fs.Path;

public final class ItemKeys
{
  private static final String HASH_KEY_PREFIX = "/";
  
  private ItemKeys()
  {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }
  
  public static ItemKey toItemKey(@NonNull Path path)
  {
    if (path == null) {
      throw new NullPointerException("path");
    }
    Preconditions.checkArgument(path.toUri().getAuthority() != null, "Path must have an authority");
    return toItemKey(EmrFsUtils.pathToBucket(path), EmrFsUtils.pathToKey(path));
  }
  
  public static ItemKey toItemKey(@NonNull String bucket, @NonNull String key)
  {
    if (bucket == null) {
      throw new NullPointerException("bucket");
    }
    if (key == null) {
      throw new NullPointerException("key");
    }
    checkValidBucket(bucket);
    String normalizedKey = normalizeKey(key);
    if (normalizedKey.isEmpty()) {
      return getRootBucketItemKey(bucket);
    }
    String fullKey = bucket + "/" + normalizedKey;
    int indexOfSeparator = fullKey.lastIndexOf("/");
    String hashKey = "/" + fullKey.substring(0, indexOfSeparator);
    String rangeKey = fullKey.substring(indexOfSeparator + 1);
    return new ItemKey(hashKey, rangeKey);
  }
  
  public static ItemKey toItemKeyForListingPrefix(@NonNull String bucket, @NonNull String prefix)
  {
    if (bucket == null) {
      throw new NullPointerException("bucket");
    }
    if (prefix == null) {
      throw new NullPointerException("prefix");
    }
    ItemKey itemKey = toItemKey(bucket, prefix);
    if (itemKey.getRangeKey().equals("_$folder$")) {
      return new ItemKey(itemKey.getHashKey());
    }
    return new ItemKey(itemKey.getHashKey() + "/" + itemKey.getRangeKey());
  }
  
  public static String getBucket(@NonNull ItemKey itemKey)
  {
    if (itemKey == null) {
      throw new NullPointerException("itemKey");
    }
    checkItemKey(itemKey);
    return extractBucket(itemKey);
  }
  
  public static String getS3Key(@NonNull ItemKey itemKey)
  {
    if (itemKey == null) {
      throw new NullPointerException("itemKey");
    }
    checkItemKey(itemKey);
    Preconditions.checkNotNull(itemKey.getRangeKey(), "ItemKey (%s) must have range key", new Object[] { itemKey });
    Preconditions.checkArgument(!itemKey.getRangeKey().isEmpty(), "ItemKey (%s) must have a nonempty range key", new Object[] { itemKey });
    
    return extractS3Key(itemKey);
  }
  
  public static String getS3KeyFromMetadata(@NonNull ItemKey itemKey, boolean isDirectory)
  {
    if (itemKey == null) {
      throw new NullPointerException("itemKey");
    }
    String key = getS3Key(itemKey);
    boolean addFolderSuffix = (isDirectory) && (!key.equals("_$folder$"));
    return addFolderSuffix ? key + "_$folder$" : key;
  }
  
  public static String toPathString(@NonNull ItemKey itemKey)
  {
    if (itemKey == null) {
      throw new NullPointerException("itemKey");
    }
    String key = getS3Key(itemKey);
    return String.format("s3://%s/%s", new Object[] { extractBucket(itemKey), key });
  }
  
  private static void checkValidBucket(String bucket)
  {
    Preconditions.checkArgument(!bucket.isEmpty(), "Bucket must not be empty");
    Preconditions.checkArgument(!bucket.contains("/"), "Bucket (%s) must not contain '%s'", new Object[] { bucket, "/" });
  }
  
  private static void checkItemKey(ItemKey itemKey)
  {
    String hashKey = itemKey.getHashKey();
    if ((hashKey.length() < 2) || 
      (hashKey.charAt(0) != '/') || 
      (hashKey.charAt(1) == '/')) {
      throw new MalformedItemKeyException(String.format("ItemKey (%1$s) must have a hashKey that is at least two characters long, its first character be '%2$s', and its second character not be '%2$s", new Object[] { itemKey, 
      
        Character.valueOf('/') }));
    }
  }
  
  private static String normalizeKey(String key)
  {
    return Joiner.on("/").join(Splitter.on("/")
      .omitEmptyStrings()
      .split(key));
  }
  
  private static ItemKey getRootBucketItemKey(String bucket)
  {
    return new ItemKey("/" + bucket, "_$folder$");
  }
  
  private static String extractBucket(ItemKey itemKey)
  {
    String hashKey = itemKey.getHashKey();
    return (String)Splitter.on('/').omitEmptyStrings().split(hashKey).iterator().next();
  }
  
  private static String extractS3Key(ItemKey itemKey)
  {
    String fullKey = itemKey.getHashKey() + "/" + itemKey.getRangeKey();
    int indexOfSeparator = fullKey.indexOf("/", "/".length());
    return fullKey.substring(indexOfSeparator + 1);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.ItemKeys
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */