package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics;

public final class MetricsPrefixPredicate
  extends MetricsFilterPredicate
{
  private final String prefix;
  
  public MetricsPrefixPredicate(String prefix)
  {
    this.prefix = prefix;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public void accept(MetricsPredicateVisitor metricsPredicateVisitor)
  {
    metricsPredicateVisitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsPrefixPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */