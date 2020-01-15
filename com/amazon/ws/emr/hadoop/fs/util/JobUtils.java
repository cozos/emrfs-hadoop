package com.amazon.ws.emr.hadoop.fs.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class JobUtils
{
  private static final Logger LOG = LoggerFactory.getLogger(JobUtils.class);
  
  public static String getApplicationId()
  {
    String containerId = System.getenv("CONTAINER_ID");
    if (!Strings.isNullOrEmpty(containerId))
    {
      String[] tmp = containerId.split("_");
      if (tmp.length == 5) {
        return "application_" + tmp[1] + "_" + tmp[2];
      }
      LOG.warn("Invalid Container Id {}", containerId);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.JobUtils
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */