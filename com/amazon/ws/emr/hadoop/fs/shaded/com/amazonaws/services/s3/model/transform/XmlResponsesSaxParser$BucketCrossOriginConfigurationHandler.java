package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CORSRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CORSRule.AllowedMethods;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$BucketCrossOriginConfigurationHandler
  extends AbstractHandler
{
  private final BucketCrossOriginConfiguration configuration = new BucketCrossOriginConfiguration(new ArrayList());
  private CORSRule currentRule;
  private List<CORSRule.AllowedMethods> allowedMethods = null;
  private List<String> allowedOrigins = null;
  private List<String> exposedHeaders = null;
  private List<String> allowedHeaders = null;
  
  public BucketCrossOriginConfiguration getConfiguration()
  {
    return configuration;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "CORSConfiguration" }))
    {
      if (name.equals("CORSRule")) {
        currentRule = new CORSRule();
      }
    }
    else if (in(new String[] { "CORSConfiguration", "CORSRule" })) {
      if (name.equals("AllowedOrigin"))
      {
        if (allowedOrigins == null) {
          allowedOrigins = new ArrayList();
        }
      }
      else if (name.equals("AllowedMethod"))
      {
        if (allowedMethods == null) {
          allowedMethods = new ArrayList();
        }
      }
      else if (name.equals("ExposeHeader"))
      {
        if (exposedHeaders == null) {
          exposedHeaders = new ArrayList();
        }
      }
      else if ((name.equals("AllowedHeader")) && 
        (allowedHeaders == null)) {
        allowedHeaders = new LinkedList();
      }
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "CORSConfiguration" }))
    {
      if (name.equals("CORSRule"))
      {
        currentRule.setAllowedHeaders(allowedHeaders);
        currentRule.setAllowedMethods(allowedMethods);
        currentRule.setAllowedOrigins(allowedOrigins);
        currentRule.setExposedHeaders(exposedHeaders);
        allowedHeaders = null;
        allowedMethods = null;
        allowedOrigins = null;
        exposedHeaders = null;
        
        configuration.getRules().add(currentRule);
        currentRule = null;
      }
    }
    else if (in(new String[] { "CORSConfiguration", "CORSRule" })) {
      if (name.equals("ID")) {
        currentRule.setId(getText());
      } else if (name.equals("AllowedOrigin")) {
        allowedOrigins.add(getText());
      } else if (name.equals("AllowedMethod")) {
        allowedMethods.add(CORSRule.AllowedMethods.fromValue(getText()));
      } else if (name.equals("MaxAgeSeconds")) {
        currentRule.setMaxAgeSeconds(Integer.parseInt(getText()));
      } else if (name.equals("ExposeHeader")) {
        exposedHeaders.add(getText());
      } else if (name.equals("AllowedHeader")) {
        allowedHeaders.add(getText());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.BucketCrossOriginConfigurationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */