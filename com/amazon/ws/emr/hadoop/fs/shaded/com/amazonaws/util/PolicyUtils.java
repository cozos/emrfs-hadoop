package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Resource;
import java.util.List;

public class PolicyUtils
{
  private static final String INVALID_RESOURCE = "Cannot have both a NotResource and a Resource in the same statement";
  
  public static void validateResourceList(List<Resource> resourceList)
  {
    boolean hasNotResource = false;
    boolean hasResource = false;
    for (Resource resource : resourceList)
    {
      if (resource.isNotType()) {
        hasNotResource = true;
      } else {
        hasResource = true;
      }
      if ((hasResource) && (hasNotResource)) {
        throw new IllegalArgumentException("Cannot have both a NotResource and a Resource in the same statement");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.PolicyUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */