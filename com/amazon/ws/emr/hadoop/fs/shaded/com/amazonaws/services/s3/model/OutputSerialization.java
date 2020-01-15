package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class OutputSerialization
  implements Serializable, Cloneable
{
  private CSVOutput csv;
  private JSONOutput json;
  
  public CSVOutput getCsv()
  {
    return csv;
  }
  
  public void setCsv(CSVOutput csv)
  {
    this.csv = csv;
  }
  
  public OutputSerialization withCsv(CSVOutput csvOutput)
  {
    setCsv(csvOutput);
    return this;
  }
  
  public JSONOutput getJson()
  {
    return json;
  }
  
  public void setJson(JSONOutput json)
  {
    this.json = json;
  }
  
  public OutputSerialization withJson(JSONOutput json)
  {
    setJson(json);
    return this;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (!(obj instanceof OutputSerialization))) {
      return false;
    }
    OutputSerialization other = (OutputSerialization)obj;
    if (((other.getCsv() == null ? 1 : 0) ^ (getCsv() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCsv() != null) && (!other.getCsv().equals(getCsv()))) {
      return false;
    }
    if (((other.getJson() == null ? 1 : 0) ^ (getJson() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJson() != null) && (!other.getJson().equals(getJson()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCsv() == null ? 0 : getCsv().hashCode());
    hashCode = 31 * hashCode + (getJson() == null ? 0 : getJson().hashCode());
    return hashCode;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCsv() != null) {
      sb.append("CSV: ").append(getCsv());
    }
    if (getJson() != null) {
      sb.append("JSON: ").append(getJson());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public OutputSerialization clone()
  {
    try
    {
      return (OutputSerialization)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.OutputSerialization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */