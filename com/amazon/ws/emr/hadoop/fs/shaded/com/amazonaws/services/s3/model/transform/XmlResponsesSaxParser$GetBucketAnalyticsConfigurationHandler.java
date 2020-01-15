package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsExportDestination;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsPrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsS3BucketDestination;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.AnalyticsTagPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.StorageClassAnalysis;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.analytics.StorageClassAnalysisDataExport;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$GetBucketAnalyticsConfigurationHandler
  extends AbstractHandler
{
  private final AnalyticsConfiguration configuration = new AnalyticsConfiguration();
  private AnalyticsFilter filter;
  private List<AnalyticsFilterPredicate> andOperandsList;
  private StorageClassAnalysis storageClassAnalysis;
  private StorageClassAnalysisDataExport dataExport;
  private AnalyticsExportDestination destination;
  private AnalyticsS3BucketDestination s3BucketDestination;
  private String currentTagKey;
  private String currentTagValue;
  
  public GetBucketAnalyticsConfigurationResult getResult()
  {
    return new GetBucketAnalyticsConfigurationResult().withAnalyticsConfiguration(configuration);
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "AnalyticsConfiguration" }))
    {
      if (name.equals("Filter")) {
        filter = new AnalyticsFilter();
      } else if (name.equals("StorageClassAnalysis")) {
        storageClassAnalysis = new StorageClassAnalysis();
      }
    }
    else if (in(new String[] { "AnalyticsConfiguration", "Filter" }))
    {
      if (name.equals("And")) {
        andOperandsList = new ArrayList();
      }
    }
    else if (in(new String[] { "AnalyticsConfiguration", "StorageClassAnalysis" }))
    {
      if (name.equals("DataExport")) {
        dataExport = new StorageClassAnalysisDataExport();
      }
    }
    else if (in(new String[] { "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport" }))
    {
      if (name.equals("Destination")) {
        destination = new AnalyticsExportDestination();
      }
    }
    else if ((in(new String[] { "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination" })) && 
      (name.equals("S3BucketDestination"))) {
      s3BucketDestination = new AnalyticsS3BucketDestination();
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "AnalyticsConfiguration" }))
    {
      if (name.equals("Id")) {
        configuration.setId(getText());
      } else if (name.equals("Filter")) {
        configuration.setFilter(filter);
      } else if (name.equals("StorageClassAnalysis")) {
        configuration.setStorageClassAnalysis(storageClassAnalysis);
      }
    }
    else if (in(new String[] { "AnalyticsConfiguration", "Filter" }))
    {
      if (name.equals("Prefix"))
      {
        filter.setPredicate(new AnalyticsPrefixPredicate(getText()));
      }
      else if (name.equals("Tag"))
      {
        filter.setPredicate(new AnalyticsTagPredicate(new Tag(currentTagKey, currentTagValue)));
        currentTagKey = null;
        currentTagValue = null;
      }
      else if (name.equals("And"))
      {
        filter.setPredicate(new AnalyticsAndOperator(andOperandsList));
        andOperandsList = null;
      }
    }
    else if (in(new String[] { "AnalyticsConfiguration", "Filter", "Tag" }))
    {
      if (name.equals("Key")) {
        currentTagKey = getText();
      } else if (name.equals("Value")) {
        currentTagValue = getText();
      }
    }
    else if (in(new String[] { "AnalyticsConfiguration", "Filter", "And" }))
    {
      if (name.equals("Prefix"))
      {
        andOperandsList.add(new AnalyticsPrefixPredicate(getText()));
      }
      else if (name.equals("Tag"))
      {
        andOperandsList.add(new AnalyticsTagPredicate(new Tag(currentTagKey, currentTagValue)));
        currentTagKey = null;
        currentTagValue = null;
      }
    }
    else if (in(new String[] { "AnalyticsConfiguration", "Filter", "And", "Tag" }))
    {
      if (name.equals("Key")) {
        currentTagKey = getText();
      } else if (name.equals("Value")) {
        currentTagValue = getText();
      }
    }
    else if (in(new String[] { "AnalyticsConfiguration", "StorageClassAnalysis" }))
    {
      if (name.equals("DataExport")) {
        storageClassAnalysis.setDataExport(dataExport);
      }
    }
    else if (in(new String[] { "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport" }))
    {
      if (name.equals("OutputSchemaVersion")) {
        dataExport.setOutputSchemaVersion(getText());
      } else if (name.equals("Destination")) {
        dataExport.setDestination(destination);
      }
    }
    else if (in(new String[] { "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination" }))
    {
      if (name.equals("S3BucketDestination")) {
        destination.setS3BucketDestination(s3BucketDestination);
      }
    }
    else if (in(new String[] { "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination", "S3BucketDestination" })) {
      if (name.equals("Format")) {
        s3BucketDestination.setFormat(getText());
      } else if (name.equals("BucketAccountId")) {
        s3BucketDestination.setBucketAccountId(getText());
      } else if (name.equals("Bucket")) {
        s3BucketDestination.setBucketArn(getText());
      } else if (name.equals("Prefix")) {
        s3BucketDestination.setPrefix(getText());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.GetBucketAnalyticsConfigurationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */