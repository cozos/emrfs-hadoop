package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind;

public class AnnotationIntrospector$ReferenceProperty
{
  private final Type _type;
  private final String _name;
  
  public static enum Type
  {
    MANAGED_REFERENCE,  BACK_REFERENCE;
    
    private Type() {}
  }
  
  public AnnotationIntrospector$ReferenceProperty(Type t, String n)
  {
    _type = t;
    _name = n;
  }
  
  public static ReferenceProperty managed(String name)
  {
    return new ReferenceProperty(Type.MANAGED_REFERENCE, name);
  }
  
  public static ReferenceProperty back(String name)
  {
    return new ReferenceProperty(Type.BACK_REFERENCE, name);
  }
  
  public Type getType()
  {
    return _type;
  }
  
  public String getName()
  {
    return _name;
  }
  
  public boolean isManagedReference()
  {
    return _type == Type.MANAGED_REFERENCE;
  }
  
  public boolean isBackReference()
  {
    return _type == Type.BACK_REFERENCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */