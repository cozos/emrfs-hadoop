package com.amazon.ws.emr.hadoop.fs.s3n;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileStatusCache
{
  static final Logger log = LoggerFactory.getLogger(FileStatusCache.class);
  private TreeMap<String, FileStatus> cache = new TreeMap();
  private String listedKey;
  private long lastBuildTime;
  static final long TTL_MILLIS = 120000L;
  private int numCacheHits = 0;
  private int numCacheAccess = 0;
  private long threadId = 0L;
  
  public FileStatusCache()
  {
    threadId = Thread.currentThread().getId();
  }
  
  public synchronized void buildCache(TreeMap<String, FileStatus> keys, String listedKey)
  {
    if ((keys != null) && (keys.size() != 0))
    {
      cache = keys;
      log.info("FileStatusCache-{} {}:{} {} items listedKey {}\n  firstKey: {}\n   lastKey: {}", new Object[] {
        Long.valueOf(threadId), Integer.valueOf(numCacheHits), Integer.valueOf(numCacheAccess), Integer.valueOf(keys.size()), listedKey, keys
        .firstKey(), keys.lastKey() });
    }
    else
    {
      clearCache();
    }
    lastBuildTime = System.currentTimeMillis();
    this.listedKey = listedKey;
  }
  
  public synchronized void clearCache()
  {
    if (cache.size() > 0) {
      log.info("FileStatusCache-{} cleared {} items", Long.valueOf(threadId), Integer.valueOf(cache.size()));
    }
    cache.clear();
    lastBuildTime = System.currentTimeMillis();
    listedKey = "";
  }
  
  public synchronized void enforceTTL()
  {
    if ((cache.size() > 0) && (System.currentTimeMillis() - lastBuildTime > 120000L)) {
      clearCache();
    }
  }
  
  public synchronized boolean isCached(String key)
  {
    enforceTTL();
    if (cache.isEmpty()) {
      return false;
    }
    if (key.compareTo((String)cache.lastKey()) <= 0)
    {
      if (key.startsWith(listedKey)) {
        return true;
      }
      if (key.compareTo((String)cache.firstKey()) >= 0) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  public synchronized void clearKey(String key)
  {
    enforceTTL();
    if (cache.isEmpty()) {
      return;
    }
    if (listedKey.startsWith(key)) {
      clearCache();
    } else if ((key.compareTo(listedKey) >= 0) && (key.compareTo((String)cache.lastKey()) <= 0)) {
      clearCache();
    }
  }
  
  public synchronized FileStatus getFileStatusInner(String key, S3NativeFileSystem parent)
  {
    if (cache.containsKey(key)) {
      return (FileStatus)cache.get(key);
    }
    String keyFolder = key + "_$folder$";
    if (cache.containsKey(keyFolder)) {
      return (FileStatus)cache.get(keyFolder);
    }
    String dirKey = key + "/";
    if ((cache.ceilingKey(dirKey) != null) && (((String)cache.ceilingKey(dirKey)).startsWith(dirKey))) {
      return parent.newDirectory(new Path("/" + key).makeQualified(parent));
    }
    return null;
  }
  
  public synchronized FileStatus getFileStatus(String key, S3NativeFileSystem parent)
  {
    numCacheAccess += 1;
    FileStatus result = getFileStatusInner(key, parent);
    if (result != null) {
      numCacheHits += 1;
    }
    log.info("FileStatusCache-{} getFileStatus {} {}", new Object[] {
      Long.valueOf(threadId), key, result != null ? "hit" : "miss" });
    return result;
  }
  
  public synchronized List<FileStatus> listStatus(String key)
  {
    numCacheAccess += 1;
    enforceTTL();
    List<FileStatus> result = new ArrayList();
    SortedMap<String, FileStatus> elements;
    if (cache.containsKey(key)) {
      if (!((FileStatus)cache.get(key)).isDir())
      {
        result.add(cache.get(key));
      }
      else if (!((String)cache.lastKey()).startsWith(key))
      {
        key = key + "/";
        
        elements = cache.tailMap(key);
        for (String element : elements.keySet())
        {
          if (!element.startsWith(key)) {
            break;
          }
          if (isImmediateMember(element, key)) {
            result.add(elements.get(element));
          }
        }
      }
    }
    if (result.size() != 0) {
      numCacheHits += 1;
    }
    log.info("FileStatusCache-{} listStatus {} {} items", new Object[] { Long.valueOf(threadId), key, Integer.valueOf(result.size()) });
    return result.size() == 0 ? null : result;
  }
  
  private void dumpCache(int sampleN)
  {
    if (cache.size() == 0) {
      return;
    }
    if (cache.size() < 100)
    {
      log.info("FileStatusCache {} items:{}", Integer.valueOf(cache.size()), Joiner.on("\n  ").join(cache.keySet()));
    }
    else
    {
      int index = -1;
      StringBuilder sb = new StringBuilder();
      for (String v : cache.keySet())
      {
        index++;
        if ((index % sampleN == 0) || (index == cache.size() - 1)) {
          sb.append(String.format("\n%6d %s", new Object[] { Integer.valueOf(index), 
            v.substring(0, 50) + "..." + v.substring(v.length() - 50) }));
        }
      }
      log.info("FileStatusCache-{} contains {} items:{}", new Object[] {
        Long.valueOf(threadId), Integer.valueOf(cache.size()), sb.toString() });
    }
  }
  
  private boolean isImmediateMember(String element, String key)
  {
    if (!element.substring(key.length()).contains("/")) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3n.FileStatusCache
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */