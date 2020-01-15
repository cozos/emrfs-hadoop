package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;

public class InventorySchedule
  implements Serializable
{
  private String frequency;
  
  public String getFrequency()
  {
    return frequency;
  }
  
  public void setFrequency(String frequency)
  {
    this.frequency = frequency;
  }
  
  public void setFrequency(InventoryFrequency frequency)
  {
    setFrequency(frequency == null ? (String)null : frequency.toString());
  }
  
  public InventorySchedule withFrequency(String frequency)
  {
    setFrequency(frequency);
    return this;
  }
  
  public InventorySchedule withFrequency(InventoryFrequency frequency)
  {
    setFrequency(frequency);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventorySchedule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */