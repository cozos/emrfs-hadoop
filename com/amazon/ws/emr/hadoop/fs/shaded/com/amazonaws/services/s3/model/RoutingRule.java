package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class RoutingRule
  implements Serializable
{
  RoutingRuleCondition condition;
  RedirectRule redirect;
  
  public void setCondition(RoutingRuleCondition condition)
  {
    this.condition = condition;
  }
  
  public RoutingRuleCondition getCondition()
  {
    return condition;
  }
  
  public RoutingRule withCondition(RoutingRuleCondition condition)
  {
    setCondition(condition);
    return this;
  }
  
  public void setRedirect(RedirectRule redirect)
  {
    this.redirect = redirect;
  }
  
  public RedirectRule getRedirect()
  {
    return redirect;
  }
  
  public RoutingRule withRedirect(RedirectRule redirect)
  {
    setRedirect(redirect);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RoutingRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */