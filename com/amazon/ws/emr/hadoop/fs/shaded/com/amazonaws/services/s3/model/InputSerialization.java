package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class InputSerialization
  implements Serializable, Cloneable
{
  private CSVInput csv;
  private JSONInput json;
  private ParquetInput parquet;
  private String compressionType;
  
  public CSVInput getCsv()
  {
    return csv;
  }
  
  public void setCsv(CSVInput csv)
  {
    this.csv = csv;
  }
  
  public InputSerialization withCsv(CSVInput csvInput)
  {
    setCsv(csvInput);
    return this;
  }
  
  public JSONInput getJson()
  {
    return json;
  }
  
  public void setJson(JSONInput json)
  {
    this.json = json;
  }
  
  public InputSerialization withJson(JSONInput json)
  {
    setJson(json);
    return this;
  }
  
  public ParquetInput getParquet()
  {
    return parquet;
  }
  
  public void setParquet(ParquetInput parquet)
  {
    this.parquet = parquet;
  }
  
  public InputSerialization withParquet(ParquetInput parquet)
  {
    setParquet(parquet);
    return this;
  }
  
  public String getCompressionType()
  {
    return compressionType;
  }
  
  public void setCompressionType(String compressionType)
  {
    this.compressionType = compressionType;
  }
  
  public void setCompressionType(CompressionType compressionType)
  {
    setCompressionType(compressionType == null ? null : compressionType.toString());
  }
  
  public InputSerialization withCompressionType(String compressionType)
  {
    setCompressionType(compressionType);
    return this;
  }
  
  public InputSerialization withCompressionType(CompressionType compressionType)
  {
    setCompressionType(compressionType);
    return this;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (!(obj instanceof InputSerialization))) {
      return false;
    }
    InputSerialization other = (InputSerialization)obj;
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
    if (((other.getCompressionType() == null ? 1 : 0) ^ (getCompressionType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCompressionType() != null) && (!other.getCompressionType().equals(getCompressionType()))) {
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
    hashCode = 31 * hashCode + (getCompressionType() == null ? 0 : getCompressionType().hashCode());
    return hashCode;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCsv() != null) {
      sb.append("Csv: ").append(getCsv());
    }
    if (getJson() != null) {
      sb.append("Json: ").append(getJson());
    }
    if (getCompressionType() != null) {
      sb.append("CompressionType: ").append(getCompressionType());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public InputSerialization clone()
  {
    try
    {
      return (InputSerialization)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InputSerialization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */