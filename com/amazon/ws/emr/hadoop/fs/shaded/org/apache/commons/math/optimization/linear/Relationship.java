package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.linear;

public enum Relationship
{
  EQ("="),  LEQ("<="),  GEQ(">=");
  
  private String stringValue;
  
  private Relationship(String stringValue)
  {
    this.stringValue = stringValue;
  }
  
  public String toString()
  {
    return stringValue;
  }
  
  public Relationship oppositeRelationship()
  {
    switch (this)
    {
    case LEQ: 
      return GEQ;
    case GEQ: 
      return LEQ;
    }
    return EQ;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.optimization.linear.Relationship
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */