package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ConsumedCapacityMarshaller;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ConsumedCapacity
  implements Serializable, Cloneable, StructuredPojo
{
  private String tableName;
  private Double capacityUnits;
  private Double readCapacityUnits;
  private Double writeCapacityUnits;
  private Capacity table;
  private Map<String, Capacity> localSecondaryIndexes;
  private Map<String, Capacity> globalSecondaryIndexes;
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public ConsumedCapacity withTableName(String tableName)
  {
    setTableName(tableName);
    return this;
  }
  
  public void setCapacityUnits(Double capacityUnits)
  {
    this.capacityUnits = capacityUnits;
  }
  
  public Double getCapacityUnits()
  {
    return capacityUnits;
  }
  
  public ConsumedCapacity withCapacityUnits(Double capacityUnits)
  {
    setCapacityUnits(capacityUnits);
    return this;
  }
  
  public void setReadCapacityUnits(Double readCapacityUnits)
  {
    this.readCapacityUnits = readCapacityUnits;
  }
  
  public Double getReadCapacityUnits()
  {
    return readCapacityUnits;
  }
  
  public ConsumedCapacity withReadCapacityUnits(Double readCapacityUnits)
  {
    setReadCapacityUnits(readCapacityUnits);
    return this;
  }
  
  public void setWriteCapacityUnits(Double writeCapacityUnits)
  {
    this.writeCapacityUnits = writeCapacityUnits;
  }
  
  public Double getWriteCapacityUnits()
  {
    return writeCapacityUnits;
  }
  
  public ConsumedCapacity withWriteCapacityUnits(Double writeCapacityUnits)
  {
    setWriteCapacityUnits(writeCapacityUnits);
    return this;
  }
  
  public void setTable(Capacity table)
  {
    this.table = table;
  }
  
  public Capacity getTable()
  {
    return table;
  }
  
  public ConsumedCapacity withTable(Capacity table)
  {
    setTable(table);
    return this;
  }
  
  public Map<String, Capacity> getLocalSecondaryIndexes()
  {
    return localSecondaryIndexes;
  }
  
  public void setLocalSecondaryIndexes(Map<String, Capacity> localSecondaryIndexes)
  {
    this.localSecondaryIndexes = localSecondaryIndexes;
  }
  
  public ConsumedCapacity withLocalSecondaryIndexes(Map<String, Capacity> localSecondaryIndexes)
  {
    setLocalSecondaryIndexes(localSecondaryIndexes);
    return this;
  }
  
  public ConsumedCapacity addLocalSecondaryIndexesEntry(String key, Capacity value)
  {
    if (null == localSecondaryIndexes) {
      localSecondaryIndexes = new HashMap();
    }
    if (localSecondaryIndexes.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    localSecondaryIndexes.put(key, value);
    return this;
  }
  
  public ConsumedCapacity clearLocalSecondaryIndexesEntries()
  {
    localSecondaryIndexes = null;
    return this;
  }
  
  public Map<String, Capacity> getGlobalSecondaryIndexes()
  {
    return globalSecondaryIndexes;
  }
  
  public void setGlobalSecondaryIndexes(Map<String, Capacity> globalSecondaryIndexes)
  {
    this.globalSecondaryIndexes = globalSecondaryIndexes;
  }
  
  public ConsumedCapacity withGlobalSecondaryIndexes(Map<String, Capacity> globalSecondaryIndexes)
  {
    setGlobalSecondaryIndexes(globalSecondaryIndexes);
    return this;
  }
  
  public ConsumedCapacity addGlobalSecondaryIndexesEntry(String key, Capacity value)
  {
    if (null == globalSecondaryIndexes) {
      globalSecondaryIndexes = new HashMap();
    }
    if (globalSecondaryIndexes.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    globalSecondaryIndexes.put(key, value);
    return this;
  }
  
  public ConsumedCapacity clearGlobalSecondaryIndexesEntries()
  {
    globalSecondaryIndexes = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTableName() != null) {
      sb.append("TableName: ").append(getTableName()).append(",");
    }
    if (getCapacityUnits() != null) {
      sb.append("CapacityUnits: ").append(getCapacityUnits()).append(",");
    }
    if (getReadCapacityUnits() != null) {
      sb.append("ReadCapacityUnits: ").append(getReadCapacityUnits()).append(",");
    }
    if (getWriteCapacityUnits() != null) {
      sb.append("WriteCapacityUnits: ").append(getWriteCapacityUnits()).append(",");
    }
    if (getTable() != null) {
      sb.append("Table: ").append(getTable()).append(",");
    }
    if (getLocalSecondaryIndexes() != null) {
      sb.append("LocalSecondaryIndexes: ").append(getLocalSecondaryIndexes()).append(",");
    }
    if (getGlobalSecondaryIndexes() != null) {
      sb.append("GlobalSecondaryIndexes: ").append(getGlobalSecondaryIndexes());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof ConsumedCapacity)) {
      return false;
    }
    ConsumedCapacity other = (ConsumedCapacity)obj;
    if (((other.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableName() != null) && (!other.getTableName().equals(getTableName()))) {
      return false;
    }
    if (((other.getCapacityUnits() == null ? 1 : 0) ^ (getCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCapacityUnits() != null) && (!other.getCapacityUnits().equals(getCapacityUnits()))) {
      return false;
    }
    if (((other.getReadCapacityUnits() == null ? 1 : 0) ^ (getReadCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReadCapacityUnits() != null) && (!other.getReadCapacityUnits().equals(getReadCapacityUnits()))) {
      return false;
    }
    if (((other.getWriteCapacityUnits() == null ? 1 : 0) ^ (getWriteCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getWriteCapacityUnits() != null) && (!other.getWriteCapacityUnits().equals(getWriteCapacityUnits()))) {
      return false;
    }
    if (((other.getTable() == null ? 1 : 0) ^ (getTable() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTable() != null) && (!other.getTable().equals(getTable()))) {
      return false;
    }
    if (((other.getLocalSecondaryIndexes() == null ? 1 : 0) ^ (getLocalSecondaryIndexes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLocalSecondaryIndexes() != null) && (!other.getLocalSecondaryIndexes().equals(getLocalSecondaryIndexes()))) {
      return false;
    }
    if (((other.getGlobalSecondaryIndexes() == null ? 1 : 0) ^ (getGlobalSecondaryIndexes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalSecondaryIndexes() != null) && (!other.getGlobalSecondaryIndexes().equals(getGlobalSecondaryIndexes()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTableName() == null ? 0 : getTableName().hashCode());
    hashCode = 31 * hashCode + (getCapacityUnits() == null ? 0 : getCapacityUnits().hashCode());
    hashCode = 31 * hashCode + (getReadCapacityUnits() == null ? 0 : getReadCapacityUnits().hashCode());
    hashCode = 31 * hashCode + (getWriteCapacityUnits() == null ? 0 : getWriteCapacityUnits().hashCode());
    hashCode = 31 * hashCode + (getTable() == null ? 0 : getTable().hashCode());
    hashCode = 31 * hashCode + (getLocalSecondaryIndexes() == null ? 0 : getLocalSecondaryIndexes().hashCode());
    hashCode = 31 * hashCode + (getGlobalSecondaryIndexes() == null ? 0 : getGlobalSecondaryIndexes().hashCode());
    return hashCode;
  }
  
  public ConsumedCapacity clone()
  {
    try
    {
      return (ConsumedCapacity)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ConsumedCapacityMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConsumedCapacity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */