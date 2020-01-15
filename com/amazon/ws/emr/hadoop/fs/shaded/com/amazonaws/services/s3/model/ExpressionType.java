package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum ExpressionType
{
  SQL("SQL");
  
  private final String expressionType;
  
  private ExpressionType(String expressionType)
  {
    this.expressionType = expressionType;
  }
  
  public String toString()
  {
    return expressionType;
  }
  
  public static ExpressionType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (ExpressionType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ExpressionType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */