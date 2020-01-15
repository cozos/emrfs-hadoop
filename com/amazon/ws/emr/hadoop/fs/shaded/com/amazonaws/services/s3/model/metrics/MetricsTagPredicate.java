package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;

public final class MetricsTagPredicate
  extends MetricsFilterPredicate
{
  private final Tag tag;
  
  public MetricsTagPredicate(Tag tag)
  {
    this.tag = tag;
  }
  
  public Tag getTag()
  {
    return tag;
  }
  
  public void accept(MetricsPredicateVisitor metricsPredicateVisitor)
  {
    metricsPredicateVisitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsTagPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */