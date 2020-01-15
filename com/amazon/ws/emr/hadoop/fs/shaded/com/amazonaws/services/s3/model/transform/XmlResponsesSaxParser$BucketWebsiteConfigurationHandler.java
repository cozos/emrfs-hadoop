package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RedirectRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RoutingRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RoutingRuleCondition;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$BucketWebsiteConfigurationHandler
  extends AbstractHandler
{
  private final BucketWebsiteConfiguration configuration = new BucketWebsiteConfiguration(null);
  private RoutingRuleCondition currentCondition = null;
  private RedirectRule currentRedirectRule = null;
  private RoutingRule currentRoutingRule = null;
  
  public BucketWebsiteConfiguration getConfiguration()
  {
    return configuration;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "WebsiteConfiguration" }))
    {
      if (name.equals("RedirectAllRequestsTo")) {
        currentRedirectRule = new RedirectRule();
      }
    }
    else if (in(new String[] { "WebsiteConfiguration", "RoutingRules" }))
    {
      if (name.equals("RoutingRule")) {
        currentRoutingRule = new RoutingRule();
      }
    }
    else if (in(new String[] { "WebsiteConfiguration", "RoutingRules", "RoutingRule" })) {
      if (name.equals("Condition")) {
        currentCondition = new RoutingRuleCondition();
      } else if (name.equals("Redirect")) {
        currentRedirectRule = new RedirectRule();
      }
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "WebsiteConfiguration" }))
    {
      if (name.equals("RedirectAllRequestsTo"))
      {
        configuration.setRedirectAllRequestsTo(currentRedirectRule);
        currentRedirectRule = null;
      }
    }
    else if (in(new String[] { "WebsiteConfiguration", "IndexDocument" }))
    {
      if (name.equals("Suffix")) {
        configuration.setIndexDocumentSuffix(getText());
      }
    }
    else if (in(new String[] { "WebsiteConfiguration", "ErrorDocument" }))
    {
      if (name.equals("Key")) {
        configuration.setErrorDocument(getText());
      }
    }
    else if (in(new String[] { "WebsiteConfiguration", "RoutingRules" }))
    {
      if (name.equals("RoutingRule"))
      {
        configuration.getRoutingRules().add(currentRoutingRule);
        currentRoutingRule = null;
      }
    }
    else if (in(new String[] { "WebsiteConfiguration", "RoutingRules", "RoutingRule" }))
    {
      if (name.equals("Condition"))
      {
        currentRoutingRule.setCondition(currentCondition);
        currentCondition = null;
      }
      else if (name.equals("Redirect"))
      {
        currentRoutingRule.setRedirect(currentRedirectRule);
        currentRedirectRule = null;
      }
    }
    else if (in(new String[] { "WebsiteConfiguration", "RoutingRules", "RoutingRule", "Condition" }))
    {
      if (name.equals("KeyPrefixEquals")) {
        currentCondition.setKeyPrefixEquals(getText());
      } else if (name.equals("HttpErrorCodeReturnedEquals")) {
        currentCondition.setHttpErrorCodeReturnedEquals(getText());
      }
    }
    else if (!in(new String[] { "WebsiteConfiguration", "RedirectAllRequestsTo" }))
    {
      if (!in(new String[] { "WebsiteConfiguration", "RoutingRules", "RoutingRule", "Redirect" })) {}
    }
    else if (name.equals("Protocol")) {
      currentRedirectRule.setProtocol(getText());
    } else if (name.equals("HostName")) {
      currentRedirectRule.setHostName(getText());
    } else if (name.equals("ReplaceKeyPrefixWith")) {
      currentRedirectRule.setReplaceKeyPrefixWith(getText());
    } else if (name.equals("ReplaceKeyWith")) {
      currentRedirectRule.setReplaceKeyWith(getText());
    } else if (name.equals("HttpRedirectCode")) {
      currentRedirectRule.setHttpRedirectCode(getText());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.BucketWebsiteConfigurationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */