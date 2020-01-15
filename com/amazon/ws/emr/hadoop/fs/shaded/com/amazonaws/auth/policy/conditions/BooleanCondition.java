package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.conditions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Condition;
import java.util.Arrays;

public class BooleanCondition
  extends Condition
{
  public BooleanCondition(String key, boolean value)
  {
    type = "Bool";
    conditionKey = key;
    values = Arrays.asList(new String[] { Boolean.toString(value) });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.conditions.BooleanCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */