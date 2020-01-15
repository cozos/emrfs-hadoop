package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

public enum JsonFormat$Shape
{
  ANY,  SCALAR,  ARRAY,  OBJECT,  NUMBER,  NUMBER_FLOAT,  NUMBER_INT,  STRING,  BOOLEAN;
  
  private JsonFormat$Shape() {}
  
  public boolean isNumeric()
  {
    return (this == NUMBER) || (this == NUMBER_INT) || (this == NUMBER_FLOAT);
  }
  
  public boolean isStructured()
  {
    return (this == OBJECT) || (this == ARRAY);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonFormat.Shape
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */