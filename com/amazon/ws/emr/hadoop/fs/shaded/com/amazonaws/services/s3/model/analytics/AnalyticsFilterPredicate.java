package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

public abstract class AnalyticsFilterPredicate
  implements Serializable
{
  public abstract void accept(AnalyticsPredicateVisitor paramAnalyticsPredicateVisitor);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsFilterPredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */