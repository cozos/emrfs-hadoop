package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

public class InventoryFilter
  implements Serializable
{
  private InventoryFilterPredicate predicate;
  
  public InventoryFilter() {}
  
  public InventoryFilter(InventoryFilterPredicate predicate)
  {
    this.predicate = predicate;
  }
  
  public InventoryFilterPredicate getPredicate()
  {
    return predicate;
  }
  
  public void setPredicate(InventoryFilterPredicate predicate)
  {
    this.predicate = predicate;
  }
  
  public InventoryFilter withPredicate(InventoryFilterPredicate predicate)
  {
    setPredicate(predicate);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */