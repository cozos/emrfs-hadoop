package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.conditions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Condition;
import java.util.Arrays;

public class IpAddressCondition
  extends Condition
{
  public static enum IpAddressComparisonType
  {
    IpAddress,  NotIpAddress;
    
    private IpAddressComparisonType() {}
  }
  
  public IpAddressCondition(String ipAddressRange)
  {
    this(IpAddressComparisonType.IpAddress, ipAddressRange);
  }
  
  public IpAddressCondition(IpAddressComparisonType type, String ipAddressRange)
  {
    this.type = type.toString();
    conditionKey = "aws:SourceIp";
    values = Arrays.asList(new String[] { ipAddressRange });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.conditions.IpAddressCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */