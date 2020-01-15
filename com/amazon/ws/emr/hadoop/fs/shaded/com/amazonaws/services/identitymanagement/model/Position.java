package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;

public class Position
  implements Serializable, Cloneable
{
  private Integer line;
  private Integer column;
  
  public void setLine(Integer line)
  {
    this.line = line;
  }
  
  public Integer getLine()
  {
    return line;
  }
  
  public Position withLine(Integer line)
  {
    setLine(line);
    return this;
  }
  
  public void setColumn(Integer column)
  {
    this.column = column;
  }
  
  public Integer getColumn()
  {
    return column;
  }
  
  public Position withColumn(Integer column)
  {
    setColumn(column);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getLine() != null) {
      sb.append("Line: ").append(getLine()).append(",");
    }
    if (getColumn() != null) {
      sb.append("Column: ").append(getColumn());
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
    if (!(obj instanceof Position)) {
      return false;
    }
    Position other = (Position)obj;
    if (((other.getLine() == null ? 1 : 0) ^ (getLine() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLine() != null) && (!other.getLine().equals(getLine()))) {
      return false;
    }
    if (((other.getColumn() == null ? 1 : 0) ^ (getColumn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getColumn() != null) && (!other.getColumn().equals(getColumn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getLine() == null ? 0 : getLine().hashCode());
    hashCode = 31 * hashCode + (getColumn() == null ? 0 : getColumn().hashCode());
    return hashCode;
  }
  
  public Position clone()
  {
    try
    {
      return (Position)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.Position
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */