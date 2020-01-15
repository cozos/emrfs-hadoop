package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GetRecordsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private List<Record> records;
  private String nextShardIterator;
  
  public List<Record> getRecords()
  {
    return records;
  }
  
  public void setRecords(Collection<Record> records)
  {
    if (records == null)
    {
      this.records = null;
      return;
    }
    this.records = new ArrayList(records);
  }
  
  public GetRecordsResult withRecords(Record... records)
  {
    if (this.records == null) {
      setRecords(new ArrayList(records.length));
    }
    for (Record ele : records) {
      this.records.add(ele);
    }
    return this;
  }
  
  public GetRecordsResult withRecords(Collection<Record> records)
  {
    setRecords(records);
    return this;
  }
  
  public void setNextShardIterator(String nextShardIterator)
  {
    this.nextShardIterator = nextShardIterator;
  }
  
  public String getNextShardIterator()
  {
    return nextShardIterator;
  }
  
  public GetRecordsResult withNextShardIterator(String nextShardIterator)
  {
    setNextShardIterator(nextShardIterator);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRecords() != null) {
      sb.append("Records: ").append(getRecords()).append(",");
    }
    if (getNextShardIterator() != null) {
      sb.append("NextShardIterator: ").append(getNextShardIterator());
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
    if (!(obj instanceof GetRecordsResult)) {
      return false;
    }
    GetRecordsResult other = (GetRecordsResult)obj;
    if (((other.getRecords() == null ? 1 : 0) ^ (getRecords() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRecords() != null) && (!other.getRecords().equals(getRecords()))) {
      return false;
    }
    if (((other.getNextShardIterator() == null ? 1 : 0) ^ (getNextShardIterator() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNextShardIterator() != null) && (!other.getNextShardIterator().equals(getNextShardIterator()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRecords() == null ? 0 : getRecords().hashCode());
    hashCode = 31 * hashCode + (getNextShardIterator() == null ? 0 : getNextShardIterator().hashCode());
    return hashCode;
  }
  
  public GetRecordsResult clone()
  {
    try
    {
      return (GetRecordsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetRecordsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */