package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory;

public final class InventoryPrefixPredicate
  extends InventoryFilterPredicate
{
  private final String prefix;
  
  public InventoryPrefixPredicate(String prefix)
  {
    this.prefix = prefix;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public void accept(InventoryPredicateVisitor inventoryPredicateVisitor)
  {
    inventoryPredicateVisitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryPrefixPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */