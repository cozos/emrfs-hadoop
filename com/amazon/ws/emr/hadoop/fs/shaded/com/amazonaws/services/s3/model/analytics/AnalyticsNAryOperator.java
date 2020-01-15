package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics;

import java.util.List;

abstract class AnalyticsNAryOperator
  extends AnalyticsFilterPredicate
{
  private final List<AnalyticsFilterPredicate> operands;
  
  public AnalyticsNAryOperator(List<AnalyticsFilterPredicate> operands)
  {
    this.operands = operands;
  }
  
  public List<AnalyticsFilterPredicate> getOperands()
  {
    return operands;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsNAryOperator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */