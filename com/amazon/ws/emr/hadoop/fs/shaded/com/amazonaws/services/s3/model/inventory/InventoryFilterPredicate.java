package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

public abstract class InventoryFilterPredicate
  implements Serializable
{
  public abstract void accept(InventoryPredicateVisitor paramInventoryPredicateVisitor);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryFilterPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */