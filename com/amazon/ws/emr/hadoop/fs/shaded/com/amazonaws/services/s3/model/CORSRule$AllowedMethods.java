package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum CORSRule$AllowedMethods
{
  GET("GET"),  PUT("PUT"),  HEAD("HEAD"),  POST("POST"),  DELETE("DELETE");
  
  private final String AllowedMethod;
  
  private CORSRule$AllowedMethods(String AllowedMethod)
  {
    this.AllowedMethod = AllowedMethod;
  }
  
  public String toString()
  {
    return AllowedMethod;
  }
  
  public static AllowedMethods fromValue(String allowedMethod)
    throws IllegalArgumentException
  {
    for (AllowedMethods method : )
    {
      String methodString = method.toString();
      if ((methodString != null) && 
        (methodString.equals(allowedMethod))) {
        return method;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + allowedMethod + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CORSRule.AllowedMethods
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */