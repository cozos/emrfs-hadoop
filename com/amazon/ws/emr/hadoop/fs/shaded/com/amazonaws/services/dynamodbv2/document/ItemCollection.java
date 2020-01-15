package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.PageBasedCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.PageIterable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Capacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConsumedCapacity;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class ItemCollection<R>
  extends PageBasedCollection<Item, R>
{
  private int accumulatedItemCount;
  private int accumulatedScannedCount;
  private ConsumedCapacity accumulatedConsumedCapacity;
  
  protected final void accumulateStats(ConsumedCapacity consumedCapacity, Integer count, Integer scannedCount)
  {
    if (consumedCapacity != null) {
      if (accumulatedConsumedCapacity == null)
      {
        accumulatedConsumedCapacity = new ConsumedCapacity();
        accumulatedConsumedCapacity.setCapacityUnits(consumedCapacity.getCapacityUnits());
        accumulatedConsumedCapacity.setGlobalSecondaryIndexes(
          clone(consumedCapacity.getGlobalSecondaryIndexes()));
        accumulatedConsumedCapacity.setLocalSecondaryIndexes(
          clone(consumedCapacity.getLocalSecondaryIndexes()));
        accumulatedConsumedCapacity.setTable(clone(consumedCapacity.getTable()));
        accumulatedConsumedCapacity.setTableName(consumedCapacity.getTableName());
      }
      else
      {
        Double capunit = accumulatedConsumedCapacity.getCapacityUnits();
        Double delta = consumedCapacity.getCapacityUnits();
        if (capunit == null) {
          accumulatedConsumedCapacity.setCapacityUnits(delta);
        } else {
          accumulatedConsumedCapacity.setCapacityUnits(Double.valueOf(capunit.doubleValue() + (delta == null ? 0.0D : delta
            .doubleValue())));
        }
        Map<String, Capacity> gsi = accumulatedConsumedCapacity.getGlobalSecondaryIndexes();
        if (gsi == null) {
          accumulatedConsumedCapacity.setGlobalSecondaryIndexes(
            clone(consumedCapacity.getGlobalSecondaryIndexes()));
        } else {
          accumulatedConsumedCapacity.setGlobalSecondaryIndexes(add(consumedCapacity
            .getGlobalSecondaryIndexes(), accumulatedConsumedCapacity
            .getGlobalSecondaryIndexes()));
        }
        Map<String, Capacity> lsi = accumulatedConsumedCapacity.getLocalSecondaryIndexes();
        if (lsi == null) {
          accumulatedConsumedCapacity.setLocalSecondaryIndexes(
            clone(consumedCapacity.getLocalSecondaryIndexes()));
        } else {
          accumulatedConsumedCapacity.setLocalSecondaryIndexes(add(consumedCapacity
            .getLocalSecondaryIndexes(), accumulatedConsumedCapacity
            .getLocalSecondaryIndexes()));
        }
        Capacity tableCapacity = accumulatedConsumedCapacity.getTable();
        if (tableCapacity == null) {
          accumulatedConsumedCapacity.setTable(clone(consumedCapacity.getTable()));
        } else {
          accumulatedConsumedCapacity.setTable(add(consumedCapacity.getTable(), accumulatedConsumedCapacity
            .getTable()));
        }
      }
    }
    if (count != null) {
      accumulatedItemCount += count.intValue();
    }
    if (scannedCount != null) {
      accumulatedScannedCount += scannedCount.intValue();
    }
  }
  
  private Map<String, Capacity> add(Map<String, Capacity> from, Map<String, Capacity> to)
  {
    if (to == null) {
      return clone(from);
    }
    if (from != null) {
      for (Map.Entry<String, Capacity> entryFrom : from.entrySet())
      {
        String key = (String)entryFrom.getKey();
        Capacity tocap = (Capacity)to.get(key);
        Capacity fromcap = (Capacity)entryFrom.getValue();
        if (tocap == null) {
          to.put(key, clone(fromcap));
        } else {
          to.put(key, new Capacity().withCapacityUnits(
            Double.valueOf(doubleOf(tocap) + doubleOf(fromcap))));
        }
      }
    }
    return to;
  }
  
  private Capacity add(Capacity from, Capacity to)
  {
    return new Capacity().withCapacityUnits(Double.valueOf(doubleOf(from) + doubleOf(to)));
  }
  
  private Map<String, Capacity> clone(Map<String, Capacity> capacityMap)
  {
    if (capacityMap == null) {
      return null;
    }
    Map<String, Capacity> clone = new HashMap(capacityMap.size());
    for (Map.Entry<String, Capacity> e : capacityMap.entrySet()) {
      clone.put(e.getKey(), clone((Capacity)e.getValue()));
    }
    return clone;
  }
  
  private Capacity clone(Capacity capacity)
  {
    return capacity == null ? null : new Capacity()
    
      .withCapacityUnits(capacity.getCapacityUnits());
  }
  
  private double doubleOf(Capacity cap)
  {
    if (cap == null) {
      return 0.0D;
    }
    Double val = cap.getCapacityUnits();
    return val == null ? 0.0D : val.doubleValue();
  }
  
  @Deprecated
  public int getTotalCount()
  {
    return getAccumulatedItemCount();
  }
  
  public int getAccumulatedItemCount()
  {
    return accumulatedItemCount;
  }
  
  @Deprecated
  public int getTotalScannedCount()
  {
    return getAccumulatedScannedCount();
  }
  
  public int getAccumulatedScannedCount()
  {
    return accumulatedScannedCount;
  }
  
  @Deprecated
  public ConsumedCapacity getTotalConsumedCapacity()
  {
    return getAccumulatedConsumedCapacity();
  }
  
  public ConsumedCapacity getAccumulatedConsumedCapacity()
  {
    return accumulatedConsumedCapacity;
  }
  
  public PageIterable<Item, R> pages()
  {
    return super.pages();
  }
  
  public abstract Integer getMaxResultSize();
  
  public R getLastLowLevelResult()
  {
    return (R)super.getLastLowLevelResult();
  }
  
  public LowLevelResultListener<R> registerLowLevelResultListener(LowLevelResultListener<R> listener)
  {
    return super.registerLowLevelResultListener(listener);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ItemCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */