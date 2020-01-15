package com.amazon.ws.emr.hadoop.fs.dynamodb;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Arrays;

public class Entity
{
  protected ItemKey itemKey;
  protected Long counter;
  protected Long lastModified;
  protected byte[] payload;
  protected Long deletionTTL;
  protected String etag;
  
  public Entity(ItemKey itemKey)
  {
    Preconditions.checkNotNull(itemKey, "Item key cannot be null");
    this.itemKey = itemKey;
    payload = null;
    
    deletionTTL = Long.valueOf(0L);
    etag = null;
  }
  
  public Entity(ItemKey itemKey, byte[] payload)
  {
    Preconditions.checkNotNull(itemKey, "Item key cannot be null");
    this.itemKey = itemKey;
    setPayload(payload);
    
    deletionTTL = Long.valueOf(0L);
    etag = null;
  }
  
  public Entity(Entity entity)
  {
    itemKey = new ItemKey(entity.getItemKey());
    setPayload(entity.getPayload());
    setCounter(entity.getCounter());
    setLastModified(entity.getLastModified());
    setDeletionTTL(entity.getDeletionTTL().longValue());
    setEtag(entity.getEtag());
  }
  
  public ItemKey getItemKey()
  {
    return itemKey;
  }
  
  public void setItemKey(ItemKey itemKey)
  {
    Preconditions.checkNotNull(itemKey, "Item key cannot be null");
    this.itemKey = itemKey;
  }
  
  public Entity withItemKey(ItemKey itemKey)
  {
    setItemKey(itemKey);
    return this;
  }
  
  public byte[] getPayload()
  {
    return payload;
  }
  
  public void setPayload(byte[] payload)
  {
    if (payload != null) {
      this.payload = Arrays.copyOf(payload, payload.length);
    } else {
      this.payload = null;
    }
  }
  
  public Entity withPayload(byte[] payload)
  {
    setPayload(payload);
    return this;
  }
  
  public Long getCounter()
  {
    return counter;
  }
  
  public void setCounter(Long counter)
  {
    this.counter = counter;
  }
  
  public Entity withCounter(Long counter)
  {
    setCounter(counter);
    return this;
  }
  
  public void resetCounter()
  {
    counter = null;
  }
  
  public Long getLastModified()
  {
    return lastModified;
  }
  
  public void setLastModified(Long lastModified)
  {
    this.lastModified = lastModified;
  }
  
  public Entity withLastModified(Long lastModified)
  {
    setLastModified(lastModified);
    return this;
  }
  
  public Long getDeletionTTL()
  {
    return deletionTTL;
  }
  
  public void setDeletionTTL(long deletionTTL)
  {
    this.deletionTTL = Long.valueOf(deletionTTL);
  }
  
  public Entity withDeletionTTL(long deletionTTL)
  {
    this.deletionTTL = Long.valueOf(deletionTTL);
    return this;
  }
  
  public String getEtag()
  {
    return etag;
  }
  
  public void setEtag(String etag)
  {
    this.etag = etag;
  }
  
  public Entity withEtag(String etag)
  {
    setEtag(etag);
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
    Entity entity = (Entity)o;
    if (!itemKey.equals(itemKey)) {
      return false;
    }
    if (!Arrays.equals(payload, payload)) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int result = itemKey.hashCode();
    result = 31 * result + (payload != null ? Arrays.hashCode(payload) : 0);
    return result;
  }
  
  public String toString()
  {
    return 
      "Entity{itemKey=" + itemKey + ", counter=" + counter + ", lastModified=" + lastModified + ", deletionTTL=" + deletionTTL + ", payload=" + Arrays.toString(payload) + ", eTag=" + etag + "}";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.Entity
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */