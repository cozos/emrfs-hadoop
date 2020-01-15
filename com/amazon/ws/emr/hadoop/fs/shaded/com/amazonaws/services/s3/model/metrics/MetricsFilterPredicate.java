package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics;

import java.io.Serializable;

public abstract class MetricsFilterPredicate
  implements Serializable
{
  public abstract void accept(MetricsPredicateVisitor paramMetricsPredicateVisitor);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsFilterPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */