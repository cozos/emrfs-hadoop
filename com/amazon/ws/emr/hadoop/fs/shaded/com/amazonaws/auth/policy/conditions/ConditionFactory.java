package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.conditions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Condition;

public class ConditionFactory
{
  public static final String CURRENT_TIME_CONDITION_KEY = "aws:CurrentTime";
  public static final String SECURE_TRANSPORT_CONDITION_KEY = "aws:SecureTransport";
  public static final String SOURCE_IP_CONDITION_KEY = "aws:SourceIp";
  public static final String USER_AGENT_CONDITION_KEY = "aws:UserAgent";
  public static final String EPOCH_TIME_CONDITION_KEY = "aws:EpochTime";
  public static final String REFERER_CONDITION_KEY = "aws:Referer";
  public static final String SOURCE_ARN_CONDITION_KEY = "aws:SourceArn";
  
  public static Condition newSourceArnCondition(String arnPattern)
  {
    return new ArnCondition(ArnCondition.ArnComparisonType.ArnLike, "aws:SourceArn", arnPattern);
  }
  
  public static Condition newSecureTransportCondition()
  {
    return new BooleanCondition("aws:SecureTransport", true);
  }
  
  public static Condition newUserAgentCondition(StringCondition.StringComparisonType comparisonType, String value)
  {
    return new StringCondition(comparisonType, "aws:UserAgent", value);
  }
  
  public static Condition newRefererCondition(StringCondition.StringComparisonType comparisonType, String value)
  {
    return new StringCondition(comparisonType, "aws:Referer", value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.conditions.ConditionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */