package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation;

public enum PropertyAccessor
{
  GETTER,  SETTER,  CREATOR,  FIELD,  IS_GETTER,  NONE,  ALL;
  
  private PropertyAccessor() {}
  
  public boolean creatorEnabled()
  {
    return (this == CREATOR) || (this == ALL);
  }
  
  public boolean getterEnabled()
  {
    return (this == GETTER) || (this == ALL);
  }
  
  public boolean isGetterEnabled()
  {
    return (this == IS_GETTER) || (this == ALL);
  }
  
  public boolean setterEnabled()
  {
    return (this == SETTER) || (this == ALL);
  }
  
  public boolean fieldEnabled()
  {
    return (this == FIELD) || (this == ALL);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.PropertyAccessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */