package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics;

public abstract interface AnalyticsPredicateVisitor
{
  public abstract void visit(AnalyticsPrefixPredicate paramAnalyticsPrefixPredicate);
  
  public abstract void visit(AnalyticsTagPredicate paramAnalyticsTagPredicate);
  
  public abstract void visit(AnalyticsAndOperator paramAnalyticsAndOperator);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsPredicateVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */