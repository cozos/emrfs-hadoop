package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
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

public class XmlResponsesSaxParser$ListBucketMetricsConfigurationsHandler
  extends AbstractHandler
{
  private final ListBucketMetricsConfigurationsResult result = new ListBucketMetricsConfigurationsResult();
  private MetricsConfiguration currentConfiguration;
  private MetricsFilter currentFilter;
  private List<MetricsFilterPredicate> andOperandsList;
  private String currentTagKey;
  private String currentTagValue;
  
  public ListBucketMetricsConfigurationsResult getResult()
  {
    return result;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "ListMetricsConfigurationsResult" }))
    {
      if (name.equals("MetricsConfiguration")) {
        currentConfiguration = new MetricsConfiguration();
      }
    }
    else if (in(new String[] { "ListMetricsConfigurationsResult", "MetricsConfiguration" }))
    {
      if (name.equals("Filter")) {
        currentFilter = new MetricsFilter();
      }
    }
    else if ((in(new String[] { "ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter" })) && 
      (name.equals("And"))) {
      andOperandsList = new ArrayList();
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "ListMetricsConfigurationsResult" }))
    {
      if (name.equals("MetricsConfiguration"))
      {
        if (result.getMetricsConfigurationList() == null) {
          result.setMetricsConfigurationList(new ArrayList());
        }
        result.getMetricsConfigurationList().add(currentConfiguration);
        currentConfiguration = null;
      }
      else if (name.equals("IsTruncated"))
      {
        result.setTruncated("true".equals(getText()));
      }
      else if (name.equals("ContinuationToken"))
      {
        result.setContinuationToken(getText());
      }
      else if (name.equals("NextContinuationToken"))
      {
        result.setNextContinuationToken(getText());
      }
    }
    else if (in(new String[] { "ListMetricsConfigurationsResult", "MetricsConfiguration" }))
    {
      if (name.equals("Id"))
      {
        currentConfiguration.setId(getText());
      }
      else if (name.equals("Filter"))
      {
        currentConfiguration.setFilter(currentFilter);
        currentFilter = null;
      }
    }
    else if (in(new String[] { "ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter" }))
    {
      if (name.equals("Prefix"))
      {
        currentFilter.setPredicate(new MetricsPrefixPredicate(getText()));
      }
      else if (name.equals("Tag"))
      {
        currentFilter.setPredicate(new MetricsTagPredicate(new Tag(currentTagKey, currentTagValue)));
        currentTagKey = null;
        currentTagValue = null;
      }
      else if (name.equals("And"))
      {
        currentFilter.setPredicate(new MetricsAndOperator(andOperandsList));
        andOperandsList = null;
      }
    }
    else if (in(new String[] { "ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "Tag" }))
    {
      if (name.equals("Key")) {
        currentTagKey = getText();
      } else if (name.equals("Value")) {
        currentTagValue = getText();
      }
    }
    else if (in(new String[] { "ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "And" }))
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
    else if (in(new String[] { "ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "And", "Tag" })) {
      if (name.equals("Key")) {
        currentTagKey = getText();
      } else if (name.equals("Value")) {
        currentTagValue = getText();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.ListBucketMetricsConfigurationsHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */