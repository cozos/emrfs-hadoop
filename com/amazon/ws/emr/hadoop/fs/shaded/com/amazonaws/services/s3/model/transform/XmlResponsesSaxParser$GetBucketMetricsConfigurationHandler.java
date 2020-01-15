package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketMetricsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsPrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.metrics.MetricsTagPredicate;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$GetBucketMetricsConfigurationHandler
  extends AbstractHandler
{
  private final MetricsConfiguration configuration = new MetricsConfiguration();
  private MetricsFilter filter;
  private List<MetricsFilterPredicate> andOperandsList;
  private String currentTagKey;
  private String currentTagValue;
  
  public GetBucketMetricsConfigurationResult getResult()
  {
    return new GetBucketMetricsConfigurationResult().withMetricsConfiguration(configuration);
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "MetricsConfiguration" }))
    {
      if (name.equals("Filter")) {
        filter = new MetricsFilter();
      }
    }
    else if ((in(new String[] { "MetricsConfiguration", "Filter" })) && 
      (name.equals("And"))) {
      andOperandsList = new ArrayList();
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "MetricsConfiguration" }))
    {
      if (name.equals("Id"))
      {
        configuration.setId(getText());
      }
      else if (name.equals("Filter"))
      {
        configuration.setFilter(filter);
        filter = null;
      }
    }
    else if (in(new String[] { "MetricsConfiguration", "Filter" }))
    {
      if (name.equals("Prefix"))
      {
        filter.setPredicate(new MetricsPrefixPredicate(getText()));
      }
      else if (name.equals("Tag"))
      {
        filter.setPredicate(new MetricsTagPredicate(new Tag(currentTagKey, currentTagValue)));
        currentTagKey = null;
        currentTagValue = null;
      }
      else if (name.equals("And"))
      {
        filter.setPredicate(new MetricsAndOperator(andOperandsList));
        andOperandsList = null;
      }
    }
    else if (in(new String[] { "MetricsConfiguration", "Filter", "Tag" }))
    {
      if (name.equals("Key")) {
        currentTagKey = getText();
      } else if (name.equals("Value")) {
        currentTagValue = getText();
      }
    }
    else if (in(new String[] { "MetricsConfiguration", "Filter", "And" }))
    {
      if (name.equals("Prefix"))
      {
        andOperandsList.add(new MetricsPrefixPredicate(getText()));
      }
      else if (name.equals("Tag"))
      {
        andOperandsList.add(new MetricsTagPredicate(new Tag(currentTagKey, currentTagValue)));
        
        currentTagKey = null;
        currentTagValue = null;
      }
    }
    else if (in(new String[] { "MetricsConfiguration", "Filter", "And", "Tag" })) {
      if (name.equals("Key")) {
        currentTagKey = getText();
      } else if (name.equals("Value")) {
        currentTagValue = getText();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.GetBucketMetricsConfigurationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */