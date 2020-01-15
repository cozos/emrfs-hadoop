package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;

@Immutable
final class NamedElement
  extends PathElement
{
  private final String name;
  
  NamedElement(String name)
  {
    if (name == null) {
      throw new NullPointerException("element");
    }
    if (name.trim().isEmpty()) {
      throw new IllegalArgumentException("element cannot be empty");
    }
    this.name = name;
  }
  
  public String toString()
  {
    return name;
  }
  
  public int hashCode()
  {
    return name.hashCode();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof NamedElement)) {
      return false;
    }
    return name.equals(name);
  }
  
  String asNestedPath()
  {
    return "." + name;
  }
  
  String asToken(SubstitutionContext context)
  {
    return context.nameTokenFor(name);
  }
  
  String asNestedToken(SubstitutionContext context)
  {
    return "." + context.nameTokenFor(name);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.NamedElement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */