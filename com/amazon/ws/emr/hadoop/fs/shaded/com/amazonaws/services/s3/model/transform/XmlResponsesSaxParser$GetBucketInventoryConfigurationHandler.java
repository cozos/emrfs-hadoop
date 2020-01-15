package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryDestination;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryPrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventoryS3BucketDestination;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.InventorySchedule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.ServerSideEncryptionKMS;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.inventory.ServerSideEncryptionS3;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$GetBucketInventoryConfigurationHandler
  extends AbstractHandler
{
  public static final String SSE_S3 = "SSE-S3";
  public static final String SSE_KMS = "SSE-KMS";
  private final GetBucketInventoryConfigurationResult result = new GetBucketInventoryConfigurationResult();
  private final InventoryConfiguration configuration = new InventoryConfiguration();
  private List<String> optionalFields;
  private InventoryDestination inventoryDestination;
  private InventoryFilter filter;
  private InventoryS3BucketDestination s3BucketDestination;
  private InventorySchedule inventorySchedule;
  
  public GetBucketInventoryConfigurationResult getResult()
  {
    return result.withInventoryConfiguration(configuration);
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "InventoryConfiguration" }))
    {
      if (name.equals("Destination")) {
        inventoryDestination = new InventoryDestination();
      } else if (name.equals("Filter")) {
        filter = new InventoryFilter();
      } else if (name.equals("Schedule")) {
        inventorySchedule = new InventorySchedule();
      } else if (name.equals("OptionalFields")) {
        optionalFields = new ArrayList();
      }
    }
    else if ((in(new String[] { "InventoryConfiguration", "Destination" })) && 
      (name.equals("S3BucketDestination"))) {
      s3BucketDestination = new InventoryS3BucketDestination();
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "InventoryConfiguration" }))
    {
      if (name.equals("Id"))
      {
        configuration.setId(getText());
      }
      else if (name.equals("Destination"))
      {
        configuration.setDestination(inventoryDestination);
        inventoryDestination = null;
      }
      else if (name.equals("IsEnabled"))
      {
        configuration.setEnabled(Boolean.valueOf("true".equals(getText())));
      }
      else if (name.equals("Filter"))
      {
        configuration.setInventoryFilter(filter);
        filter = null;
      }
      else if (name.equals("IncludedObjectVersions"))
      {
        configuration.setIncludedObjectVersions(getText());
      }
      else if (name.equals("Schedule"))
      {
        configuration.setSchedule(inventorySchedule);
        inventorySchedule = null;
      }
      else if (name.equals("OptionalFields"))
      {
        configuration.setOptionalFields(optionalFields);
        optionalFields = null;
      }
    }
    else if (in(new String[] { "InventoryConfiguration", "Destination" }))
    {
      if (name.equals("S3BucketDestination"))
      {
        inventoryDestination.setS3BucketDestination(s3BucketDestination);
        s3BucketDestination = null;
      }
    }
    else if (in(new String[] { "InventoryConfiguration", "Destination", "S3BucketDestination" }))
    {
      if (name.equals("AccountId")) {
        s3BucketDestination.setAccountId(getText());
      } else if (name.equals("Bucket")) {
        s3BucketDestination.setBucketArn(getText());
      } else if (name.equals("Format")) {
        s3BucketDestination.setFormat(getText());
      } else if (name.equals("Prefix")) {
        s3BucketDestination.setPrefix(getText());
      }
    }
    else if (in(new String[] { "InventoryConfiguration", "Destination", "S3BucketDestination", "Encryption" }))
    {
      if (name.equals("SSE-S3"))
      {
        s3BucketDestination.setEncryption(new ServerSideEncryptionS3());
      }
      else if (name.equals("SSE-KMS"))
      {
        ServerSideEncryptionKMS kmsEncryption = new ServerSideEncryptionKMS().withKeyId(getText());
        s3BucketDestination.setEncryption(kmsEncryption);
      }
    }
    else if (in(new String[] { "InventoryConfiguration", "Filter" }))
    {
      if (name.equals("Prefix")) {
        filter.setPredicate(new InventoryPrefixPredicate(getText()));
      }
    }
    else if (in(new String[] { "InventoryConfiguration", "Schedule" }))
    {
      if (name.equals("Frequency")) {
        inventorySchedule.setFrequency(getText());
      }
    }
    else if ((in(new String[] { "InventoryConfiguration", "OptionalFields" })) && 
      (name.equals("Field"))) {
      optionalFields.add(getText());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.GetBucketInventoryConfigurationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */