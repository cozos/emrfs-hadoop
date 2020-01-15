package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics;

import java.util.List;

public final class MetricsAndOperator
  extends MetricsNAryOperator
{
  public MetricsAndOperator(List<MetricsFilterPredicate> operands)
  {
    super(operands);
  }
  
  public void accept(MetricsPredicateVisitor metricsPredicateVisitor)
  {
    metricsPredicateVisitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsAndOperator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */