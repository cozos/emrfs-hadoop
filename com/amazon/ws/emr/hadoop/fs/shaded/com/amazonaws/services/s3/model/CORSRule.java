package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class CORSRule
  implements Serializable
{
  private String id;
  private List<AllowedMethods> allowedMethods;
  private List<String> allowedOrigins;
  private int maxAgeSeconds;
  private List<String> exposedHeaders;
  private List<String> allowedHeaders;
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public CORSRule withId(String id)
  {
    this.id = id;
    return this;
  }
  
  public void setAllowedMethods(List<AllowedMethods> allowedMethods)
  {
    this.allowedMethods = allowedMethods;
  }
  
  public void setAllowedMethods(AllowedMethods... allowedMethods)
  {
    this.allowedMethods = Arrays.asList(allowedMethods);
  }
  
  public List<AllowedMethods> getAllowedMethods()
  {
    return allowedMethods;
  }
  
  public CORSRule withAllowedMethods(List<AllowedMethods> allowedMethods)
  {
    this.allowedMethods = allowedMethods;
    return this;
  }
  
  public void setAllowedOrigins(List<String> allowedOrigins)
  {
    this.allowedOrigins = allowedOrigins;
  }
  
  public void setAllowedOrigins(String... allowedOrigins)
  {
    this.allowedOrigins = Arrays.asList(allowedOrigins);
  }
  
  public List<String> getAllowedOrigins()
  {
    return allowedOrigins;
  }
  
  public CORSRule withAllowedOrigins(List<String> allowedOrigins)
  {
    this.allowedOrigins = allowedOrigins;
    return this;
  }
  
  public void setMaxAgeSeconds(int maxAgeSeconds)
  {
    this.maxAgeSeconds = maxAgeSeconds;
  }
  
  public int getMaxAgeSeconds()
  {
    return maxAgeSeconds;
  }
  
  public CORSRule withMaxAgeSeconds(int maxAgeSeconds)
  {
    this.maxAgeSeconds = maxAgeSeconds;
    return this;
  }
  
  public void setExposedHeaders(List<String> exposedHeaders)
  {
    this.exposedHeaders = exposedHeaders;
  }
  
  public void setExposedHeaders(String... exposedHeaders)
  {
    this.exposedHeaders = Arrays.asList(exposedHeaders);
  }
  
  public List<String> getExposedHeaders()
  {
    return exposedHeaders;
  }
  
  public CORSRule withExposedHeaders(List<String> exposedHeaders)
  {
    this.exposedHeaders = exposedHeaders;
    return this;
  }
  
  public void setAllowedHeaders(List<String> allowedHeaders)
  {
    this.allowedHeaders = allowedHeaders;
  }
  
  public void setAllowedHeaders(String... allowedHeaders)
  {
    this.allowedHeaders = Arrays.asList(allowedHeaders);
  }
  
  public List<String> getAllowedHeaders()
  {
    return allowedHeaders;
  }
  
  public CORSRule withAllowedHeaders(List<String> allowedHeaders)
  {
    this.allowedHeaders = allowedHeaders;
    return this;
  }
  
  public static enum AllowedMethods
  {
    GET("GET"),  PUT("PUT"),  HEAD("HEAD"),  POST("POST"),  DELETE("DELETE");
    
    private final String AllowedMethod;
    
    private AllowedMethods(String AllowedMethod)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CORSRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */