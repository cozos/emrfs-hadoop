package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import java.io.Serializable;
import java.util.Map;

public class GetAccountSummaryResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalMap<String, Integer> summaryMap;
  
  public Map<String, Integer> getSummaryMap()
  {
    if (summaryMap == null) {
      summaryMap = new SdkInternalMap();
    }
    return summaryMap;
  }
  
  public void setSummaryMap(Map<String, Integer> summaryMap)
  {
    this.summaryMap = (summaryMap == null ? null : new SdkInternalMap(summaryMap));
  }
  
  public GetAccountSummaryResult withSummaryMap(Map<String, Integer> summaryMap)
  {
    setSummaryMap(summaryMap);
    return this;
  }
  
  public GetAccountSummaryResult addSummaryMapEntry(String key, Integer value)
  {
    if (null == summaryMap) {
      summaryMap = new SdkInternalMap();
    }
    if (summaryMap.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    summaryMap.put(key, value);
    return this;
  }
  
  public GetAccountSummaryResult clearSummaryMapEntries()
  {
    summaryMap = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSummaryMap() != null) {
      sb.append("SummaryMap: ").append(getSummaryMap());
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
    if (!(obj instanceof GetAccountSummaryResult)) {
      return false;
    }
    GetAccountSummaryResult other = (GetAccountSummaryResult)obj;
    if (((other.getSummaryMap() == null ? 1 : 0) ^ (getSummaryMap() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSummaryMap() != null) && (!other.getSummaryMap().equals(getSummaryMap()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSummaryMap() == null ? 0 : getSummaryMap().hashCode());
    return hashCode;
  }
  
  public GetAccountSummaryResult clone()
  {
    try
    {
      return (GetAccountSummaryResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountSummaryResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */