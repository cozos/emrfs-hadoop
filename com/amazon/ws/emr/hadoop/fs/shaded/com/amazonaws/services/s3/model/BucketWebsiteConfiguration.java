package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class BucketWebsiteConfiguration
  implements Serializable
{
  private String indexDocumentSuffix;
  private String errorDocument;
  private RedirectRule redirectAllRequestsTo;
  private List<RoutingRule> routingRules = new LinkedList();
  
  public BucketWebsiteConfiguration() {}
  
  public BucketWebsiteConfiguration(String indexDocumentSuffix)
  {
    this.indexDocumentSuffix = indexDocumentSuffix;
  }
  
  public BucketWebsiteConfiguration(String indexDocumentSuffix, String errorDocument)
  {
    this.indexDocumentSuffix = indexDocumentSuffix;
    this.errorDocument = errorDocument;
  }
  
  public String getIndexDocumentSuffix()
  {
    return indexDocumentSuffix;
  }
  
  public void setIndexDocumentSuffix(String indexDocumentSuffix)
  {
    this.indexDocumentSuffix = indexDocumentSuffix;
  }
  
  public String getErrorDocument()
  {
    return errorDocument;
  }
  
  public void setErrorDocument(String errorDocument)
  {
    this.errorDocument = errorDocument;
  }
  
  public void setRedirectAllRequestsTo(RedirectRule redirectAllRequestsTo)
  {
    this.redirectAllRequestsTo = redirectAllRequestsTo;
  }
  
  public RedirectRule getRedirectAllRequestsTo()
  {
    return redirectAllRequestsTo;
  }
  
  public BucketWebsiteConfiguration withRedirectAllRequestsTo(RedirectRule redirectAllRequestsTo)
  {
    this.redirectAllRequestsTo = redirectAllRequestsTo;
    return this;
  }
  
  public void setRoutingRules(List<RoutingRule> routingRules)
  {
    this.routingRules = routingRules;
  }
  
  public List<RoutingRule> getRoutingRules()
  {
    return routingRules;
  }
  
  public BucketWebsiteConfiguration withRoutingRules(List<RoutingRule> routingRules)
  {
    this.routingRules = routingRules;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketWebsiteConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */