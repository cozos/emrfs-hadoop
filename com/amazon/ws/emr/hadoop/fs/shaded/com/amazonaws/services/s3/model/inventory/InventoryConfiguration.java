package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InventoryConfiguration
  implements Serializable
{
  private String id;
  private InventoryDestination destination;
  private Boolean isEnabled;
  private InventoryFilter inventoryFilter;
  private String includedObjectVersions;
  private List<String> optionalFields;
  private InventorySchedule schedule;
  
  public String getId()
  {
    return id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public InventoryConfiguration withId(String id)
  {
    setId(id);
    return this;
  }
  
  public InventoryDestination getDestination()
  {
    return destination;
  }
  
  public void setDestination(InventoryDestination destination)
  {
    this.destination = destination;
  }
  
  public InventoryConfiguration withDestination(InventoryDestination destination)
  {
    setDestination(destination);
    return this;
  }
  
  public Boolean isEnabled()
  {
    return isEnabled;
  }
  
  public void setEnabled(Boolean enabled)
  {
    isEnabled = enabled;
  }
  
  public InventoryConfiguration withEnabled(Boolean enabled)
  {
    setEnabled(enabled);
    return this;
  }
  
  public InventoryFilter getInventoryFilter()
  {
    return inventoryFilter;
  }
  
  public void setInventoryFilter(InventoryFilter inventoryFilter)
  {
    this.inventoryFilter = inventoryFilter;
  }
  
  public InventoryConfiguration withFilter(InventoryFilter inventoryFilter)
  {
    setInventoryFilter(inventoryFilter);
    return this;
  }
  
  public String getIncludedObjectVersions()
  {
    return includedObjectVersions;
  }
  
  public void setIncludedObjectVersions(String includedObjectVersions)
  {
    this.includedObjectVersions = includedObjectVersions;
  }
  
  public InventoryConfiguration withIncludedObjectVersions(String includedObjectVersions)
  {
    setIncludedObjectVersions(includedObjectVersions);
    return this;
  }
  
  public void setIncludedObjectVersions(InventoryIncludedObjectVersions includedObjectVersions)
  {
    setIncludedObjectVersions(includedObjectVersions == null ? (String)null : includedObjectVersions.toString());
  }
  
  public InventoryConfiguration withIncludedObjectVersions(InventoryIncludedObjectVersions includedObjectVersions)
  {
    setIncludedObjectVersions(includedObjectVersions);
    return this;
  }
  
  public List<String> getOptionalFields()
  {
    return optionalFields;
  }
  
  public void setOptionalFields(List<String> optionalFields)
  {
    this.optionalFields = optionalFields;
  }
  
  public InventoryConfiguration withOptionalFields(List<String> optionalFields)
  {
    setOptionalFields(optionalFields);
    return this;
  }
  
  public void addOptionalField(String optionalField)
  {
    if (optionalField == null) {
      return;
    }
    if (optionalFields == null) {
      optionalFields = new ArrayList();
    }
    optionalFields.add(optionalField);
  }
  
  public void addOptionalField(InventoryOptionalField optionalField)
  {
    addOptionalField(optionalField == null ? (String)null : optionalField.toString());
  }
  
  public InventorySchedule getSchedule()
  {
    return schedule;
  }
  
  public void setSchedule(InventorySchedule schedule)
  {
    this.schedule = schedule;
  }
  
  public InventoryConfiguration withSchedule(InventorySchedule schedule)
  {
    setSchedule(schedule);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */