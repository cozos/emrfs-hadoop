package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics;

public final class AnalyticsPrefixPredicate
  extends AnalyticsFilterPredicate
{
  private final String prefix;
  
  public AnalyticsPrefixPredicate(String prefix)
  {
    this.prefix = prefix;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor)
  {
    analyticsPredicateVisitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsPrefixPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */