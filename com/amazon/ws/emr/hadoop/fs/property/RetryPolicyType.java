package com.amazon.ws.emr.hadoop.fs.property;

import java.util.Arrays;
import javax.annotation.Nullable;

public enum RetryPolicyType
{
  EXPONENTIAL("exponential"),  FIXED("fixed"),  NONE("none");
  
  private static final String LOWER_CASE_NAMES = Arrays.toString(values());
  private final String policyTypeName;
  
  private RetryPolicyType(String policyTypeName)
  {
    this.policyTypeName = policyTypeName;
  }
  
  public static String getNamesAsString()
  {
    return LOWER_CASE_NAMES;
  }
  
  @Nullable
  public static RetryPolicyType fromName(@Nullable String name)
  {
    for (RetryPolicyType retryPolicyType : ) {
      if (policyTypeName.equals(name)) {
        return retryPolicyType;
      }
    }
    return null;
  }
  
  public String getName()
  {
    return policyTypeName;
  }
  
  public String toString()
  {
    return policyTypeName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.property.RetryPolicyType
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */