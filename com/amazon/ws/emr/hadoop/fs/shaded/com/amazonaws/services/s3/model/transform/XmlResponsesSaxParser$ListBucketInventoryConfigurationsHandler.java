package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryDestination;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryPrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryS3BucketDestination;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventorySchedule;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$ListBucketInventoryConfigurationsHandler
  extends AbstractHandler
{
  private final ListBucketInventoryConfigurationsResult result = new ListBucketInventoryConfigurationsResult();
  private InventoryConfiguration currentConfiguration;
  private List<String> currentOptionalFieldsList;
  private InventoryDestination currentDestination;
  private InventoryFilter currentFilter;
  private InventoryS3BucketDestination currentS3BucketDestination;
  private InventorySchedule currentSchedule;
  
  public ListBucketInventoryConfigurationsResult getResult()
  {
    return result;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "ListInventoryConfigurationsResult" }))
    {
      if (name.equals("InventoryConfiguration")) {
        currentConfiguration = new InventoryConfiguration();
      }
    }
    else if (in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration" }))
    {
      if (name.equals("Destination")) {
        currentDestination = new InventoryDestination();
      } else if (name.equals("Filter")) {
        currentFilter = new InventoryFilter();
      } else if (name.equals("Schedule")) {
        currentSchedule = new InventorySchedule();
      } else if (name.equals("OptionalFields")) {
        currentOptionalFieldsList = new ArrayList();
      }
    }
    else if ((in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination" })) && 
      (name.equals("S3BucketDestination"))) {
      currentS3BucketDestination = new InventoryS3BucketDestination();
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "ListInventoryConfigurationsResult" }))
    {
      if (name.equals("InventoryConfiguration"))
      {
        if (result.getInventoryConfigurationList() == null) {
          result.setInventoryConfigurationList(new ArrayList());
        }
        result.getInventoryConfigurationList().add(currentConfiguration);
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
    else if (in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration" }))
    {
      if (name.equals("Id"))
      {
        currentConfiguration.setId(getText());
      }
      else if (name.equals("Destination"))
      {
        currentConfiguration.setDestination(currentDestination);
        currentDestination = null;
      }
      else if (name.equals("IsEnabled"))
      {
        currentConfiguration.setEnabled(Boolean.valueOf("true".equals(getText())));
      }
      else if (name.equals("Filter"))
      {
        currentConfiguration.setInventoryFilter(currentFilter);
        currentFilter = null;
      }
      else if (name.equals("IncludedObjectVersions"))
      {
        currentConfiguration.setIncludedObjectVersions(getText());
      }
      else if (name.equals("Schedule"))
      {
        currentConfiguration.setSchedule(currentSchedule);
        currentSchedule = null;
      }
      else if (name.equals("OptionalFields"))
      {
        currentConfiguration.setOptionalFields(currentOptionalFieldsList);
        currentOptionalFieldsList = null;
      }
    }
    else if (in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination" }))
    {
      if (name.equals("S3BucketDestination"))
      {
        currentDestination.setS3BucketDestination(currentS3BucketDestination);
        currentS3BucketDestination = null;
      }
    }
    else if (in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination", "S3BucketDestination" }))
    {
      if (name.equals("AccountId")) {
        currentS3BucketDestination.setAccountId(getText());
      } else if (name.equals("Bucket")) {
        currentS3BucketDestination.setBucketArn(getText());
      } else if (name.equals("Format")) {
        currentS3BucketDestination.setFormat(getText());
      } else if (name.equals("Prefix")) {
        currentS3BucketDestination.setPrefix(getText());
      }
    }
    else if (in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration", "Filter" }))
    {
      if (name.equals("Prefix")) {
        currentFilter.setPredicate(new InventoryPrefixPredicate(getText()));
      }
    }
    else if (in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration", "Schedule" }))
    {
      if (name.equals("Frequency")) {
        currentSchedule.setFrequency(getText());
      }
    }
    else if ((in(new String[] { "ListInventoryConfigurationsResult", "InventoryConfiguration", "OptionalFields" })) && 
      (name.equals("Field"))) {
      currentOptionalFieldsList.add(getText());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.ListBucketInventoryConfigurationsHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */