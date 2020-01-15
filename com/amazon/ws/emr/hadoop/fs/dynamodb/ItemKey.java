package com.amazon.ws.emr.hadoop.fs.dynamodb;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;

public class ItemKey
  implements Comparable<ItemKey>
{
  private String hashKey;
  private String rangeKey;
  
  public ItemKey(String hashKey)
  {
    this(hashKey, null);
  }
  
  public ItemKey(String hashKey, String rangeKey)
  {
    Preconditions.checkArgument(!Strings.isNullOrEmpty(hashKey), "Hash key cannot be empty");
    this.hashKey = hashKey;
    this.rangeKey = rangeKey;
  }
  
  public ItemKey(ItemKey itemKey)
  {
    Preconditions.checkNotNull(itemKey, "Item key cannot be null");
    hashKey = itemKey.getHashKey();
    rangeKey = itemKey.getRangeKey();
  }
  
  public String getHashKey()
  {
    return hashKey;
  }
  
  public void setHashKey(String hashKey)
  {
    Preconditions.checkArgument(!Strings.isNullOrEmpty(hashKey), "Hash key cannot be empty");
    this.hashKey = hashKey;
  }
  
  public ItemKey withHashKey(String hashKey)
  {
    setHashKey(hashKey);
    return this;
  }
  
  public String getRangeKey()
  {
    return rangeKey;
  }
  
  public void setRangeKey(String rangeKey)
  {
    this.rangeKey = rangeKey;
  }
  
  public ItemKey withRangeKey(String rangeKey)
  {
    setRangeKey(rangeKey);
    return this;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    ItemKey itemKey = (ItemKey)o;
    if (!hashKey.equals(hashKey)) {
      return false;
    }
    if (rangeKey != null ? !rangeKey.equals(rangeKey) : rangeKey != null) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = hashKey.hashCode();
    result = 31 * result + (rangeKey != null ? rangeKey.hashCode() : 0);
    return result;
  }
  
  public int compareTo(ItemKey o)
  {
    if (o == null) {
      return 1;
    }
    int ret = hashKey.compareTo(o.getHashKey());
    return ret != 0 ? ret : compareNullableValues(rangeKey, o.getRangeKey());
  }
  
  private int compareNullableValues(String left, String right)
  {
    if ((left != null) && (right != null)) {
      return left.compareTo(right);
    }
    if (left != null) {
      return 1;
    }
    if (right != null) {
      return -1;
    }
    return 0;
  }
  
  public String toString()
  {
    return "ItemKey{hashKey='" + hashKey + '\'' + ", rangeKey='" + rangeKey + '\'' + '}';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */