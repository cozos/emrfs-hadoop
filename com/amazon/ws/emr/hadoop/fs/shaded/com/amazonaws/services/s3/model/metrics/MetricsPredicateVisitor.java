package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics;

public abstract interface MetricsPredicateVisitor
{
  public abstract void visit(MetricsPrefixPredicate paramMetricsPrefixPredicate);
  
  public abstract void visit(MetricsTagPredicate paramMetricsTagPredicate);
  
  public abstract void visit(MetricsAndOperator paramMetricsAndOperator);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsPredicateVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */