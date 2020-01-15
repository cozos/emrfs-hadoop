package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;

public final class AnalyticsTagPredicate
  extends AnalyticsFilterPredicate
{
  private final Tag tag;
  
  public AnalyticsTagPredicate(Tag tag)
  {
    this.tag = tag;
  }
  
  public Tag getTag()
  {
    return tag;
  }
  
  public void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor)
  {
    analyticsPredicateVisitor.visit(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsTagPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */