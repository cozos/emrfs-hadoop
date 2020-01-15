package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum InstanceCollectionType
{
  INSTANCE_FLEET("INSTANCE_FLEET"),  INSTANCE_GROUP("INSTANCE_GROUP");
  
  private String value;
  
  private InstanceCollectionType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static InstanceCollectionType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (InstanceCollectionType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceCollectionType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */