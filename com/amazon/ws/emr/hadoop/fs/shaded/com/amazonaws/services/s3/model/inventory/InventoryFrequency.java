package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory;

public enum InventoryFrequency
{
  Daily("Daily"),  Weekly("Weekly");
  
  private final String frequency;
  
  private InventoryFrequency(String frequency)
  {
    this.frequency = frequency;
  }
  
  public String toString()
  {
    return frequency;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryFrequency
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */