package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.conditions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Condition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import java.util.Arrays;
import java.util.Date;

public class DateCondition
  extends Condition
{
  public static enum DateComparisonType
  {
    DateEquals,  DateGreaterThan,  DateGreaterThanEquals,  DateLessThan,  DateLessThanEquals,  DateNotEquals;
    
    private DateComparisonType() {}
  }
  
  public DateCondition(DateComparisonType type, Date date)
  {
    this.type = type.toString();
    conditionKey = "aws:CurrentTime";
    values = Arrays.asList(new String[] { DateUtils.formatISO8601Date(date) });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.conditions.DateCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */