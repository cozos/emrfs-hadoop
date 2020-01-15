package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec;

abstract class PathElement
{
  abstract String asNestedPath();
  
  abstract String asToken(SubstitutionContext paramSubstitutionContext);
  
  abstract String asNestedToken(SubstitutionContext paramSubstitutionContext);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.xspec.PathElement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */