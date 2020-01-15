package com.amazon.ws.emr.hadoop.fs.consistency.concurrent;

import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import javax.annotation.Nullable;

public final class ConcurrencyToken
{
  private final boolean entityExistent;
  private final Long counter;
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ConcurrencyToken)) {
      return false;
    }
    ConcurrencyToken other = (ConcurrencyToken)o;
    if (isEntityExistent() != other.isEntityExistent()) {
      return false;
    }
    Object this$counter = getCounter();Object other$counter = other.getCounter();return this$counter == null ? other$counter == null : this$counter.equals(other$counter);
  }
  
  public int hashCode()
  {
    int PRIME = 59;int result = 1;result = result * 59 + (isEntityExistent() ? 79 : 97);Object $counter = getCounter();result = result * 59 + ($counter == null ? 43 : $counter.hashCode());return result;
  }
  
  public String toString()
  {
    return "ConcurrencyToken(entityExistent=" + isEntityExistent() + ", counter=" + getCounter() + ")";
  }
  
  private ConcurrencyToken(boolean entityExistent, Long counter)
  {
    this.entityExistent = entityExistent;this.counter = counter;
  }
  
  public boolean isEntityExistent()
  {
    return entityExistent;
  }
  
  public Long getCounter()
  {
    return counter;
  }
  
  public static ConcurrencyToken of(@Nullable Entity entity)
  {
    return entity == null ? ofNonexistentEntity() : ofEntityWithCounter(entity.getCounter());
  }
  
  public static ConcurrencyToken ofNonexistentEntity()
  {
    return new ConcurrencyToken(false, null);
  }
  
  public static ConcurrencyToken ofEntityWithoutCounter()
  {
    return ofEntityWithCounter(null);
  }
  
  public static ConcurrencyToken ofEntityWithCounter(Long counter)
  {
    return new ConcurrencyToken(true, counter);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.consistency.concurrent.ConcurrencyToken
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */