package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics;

import java.util.List;

abstract class MetricsNAryOperator
  extends MetricsFilterPredicate
{
  private final List<MetricsFilterPredicate> operands;
  
  public MetricsNAryOperator(List<MetricsFilterPredicate> operands)
  {
    this.operands = operands;
  }
  
  public List<MetricsFilterPredicate> getOperands()
  {
    return operands;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsNAryOperator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */