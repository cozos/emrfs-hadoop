package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortIncompleteMultipartUpload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration.NoncurrentVersionTransition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration.Rule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration.Transition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleAndOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleFilterPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecyclePrefixPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$BucketLifecycleConfigurationHandler
  extends AbstractHandler
{
  private final BucketLifecycleConfiguration configuration = new BucketLifecycleConfiguration(new ArrayList());
  private BucketLifecycleConfiguration.Rule currentRule;
  private BucketLifecycleConfiguration.Transition currentTransition;
  private BucketLifecycleConfiguration.NoncurrentVersionTransition currentNcvTransition;
  private AbortIncompleteMultipartUpload abortIncompleteMultipartUpload;
  private LifecycleFilter currentFilter;
  private List<LifecycleFilterPredicate> andOperandsList;
  private String currentTagKey;
  private String currentTagValue;
  
  public BucketLifecycleConfiguration getConfiguration()
  {
    return configuration;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "LifecycleConfiguration" }))
    {
      if (name.equals("Rule")) {
        currentRule = new BucketLifecycleConfiguration.Rule();
      }
    }
    else if (in(new String[] { "LifecycleConfiguration", "Rule" }))
    {
      if (name.equals("Transition")) {
        currentTransition = new BucketLifecycleConfiguration.Transition();
      } else if (name.equals("NoncurrentVersionTransition")) {
        currentNcvTransition = new BucketLifecycleConfiguration.NoncurrentVersionTransition();
      } else if (name.equals("AbortIncompleteMultipartUpload")) {
        abortIncompleteMultipartUpload = new AbortIncompleteMultipartUpload();
      } else if (name.equals("Filter")) {
        currentFilter = new LifecycleFilter();
      }
    }
    else if ((in(new String[] { "LifecycleConfiguration", "Rule", "Filter" })) && 
      (name.equals("And"))) {
      andOperandsList = new ArrayList();
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "LifecycleConfiguration" }))
    {
      if (name.equals("Rule"))
      {
        configuration.getRules().add(currentRule);
        currentRule = null;
      }
    }
    else if (in(new String[] { "LifecycleConfiguration", "Rule" }))
    {
      if (name.equals("ID"))
      {
        currentRule.setId(getText());
      }
      else if (name.equals("Prefix"))
      {
        currentRule.setPrefix(getText());
      }
      else if (name.equals("Status"))
      {
        currentRule.setStatus(getText());
      }
      else if (name.equals("Transition"))
      {
        currentRule.addTransition(currentTransition);
        currentTransition = null;
      }
      else if (name.equals("NoncurrentVersionTransition"))
      {
        currentRule.addNoncurrentVersionTransition(currentNcvTransition);
        
        currentNcvTransition = null;
      }
      else if (name.equals("AbortIncompleteMultipartUpload"))
      {
        currentRule.setAbortIncompleteMultipartUpload(abortIncompleteMultipartUpload);
        abortIncompleteMultipartUpload = null;
      }
      else if (name.equals("Filter"))
      {
        currentRule.setFilter(currentFilter);
        currentFilter = null;
      }
    }
    else if (in(new String[] { "LifecycleConfiguration", "Rule", "Expiration" }))
    {
      if (name.equals("Date")) {
        currentRule.setExpirationDate(ServiceUtils.parseIso8601Date(getText()));
      } else if (name.equals("Days")) {
        currentRule.setExpirationInDays(Integer.parseInt(getText()));
      } else if ((name.equals("ExpiredObjectDeleteMarker")) && 
        ("true".equals(getText()))) {
        currentRule.setExpiredObjectDeleteMarker(true);
      }
    }
    else if (in(new String[] { "LifecycleConfiguration", "Rule", "Transition" }))
    {
      if (name.equals("StorageClass")) {
        currentTransition.setStorageClass(getText());
      } else if (name.equals("Date")) {
        currentTransition.setDate(
          ServiceUtils.parseIso8601Date(getText()));
      } else if (name.equals("Days")) {
        currentTransition.setDays(Integer.parseInt(getText()));
      }
    }
    else if (in(new String[] { "LifecycleConfiguration", "Rule", "NoncurrentVersionExpiration" }))
    {
      if (name.equals("NoncurrentDays")) {
        currentRule.setNoncurrentVersionExpirationInDays(
          Integer.parseInt(getText()));
      }
    }
    else if (in(new String[] { "LifecycleConfiguration", "Rule", "NoncurrentVersionTransition" }))
    {
      if (name.equals("StorageClass")) {
        currentNcvTransition.setStorageClass(getText());
      } else if (name.equals("NoncurrentDays")) {
        currentNcvTransition.setDays(Integer.parseInt(getText()));
      }
    }
    else if (in(new String[] { "LifecycleConfiguration", "Rule", "AbortIncompleteMultipartUpload" }))
    {
      if (name.equals("DaysAfterInitiation")) {
        abortIncompleteMultipartUpload.setDaysAfterInitiation(Integer.parseInt(getText()));
      }
    }
    else if (in(new String[] { "LifecycleConfiguration", "Rule", "Filter" }))
    {
      if (name.equals("Prefix"))
      {
        currentFilter.setPredicate(new LifecyclePrefixPredicate(getText()));
      }
      else if (name.equals("Tag"))
      {
        currentFilter.setPredicate(new LifecycleTagPredicate(new Tag(currentTagKey, currentTagValue)));
        currentTagKey = null;
        currentTagValue = null;
      }
      else if (name.equals("And"))
      {
        currentFilter.setPredicate(new LifecycleAndOperator(andOperandsList));
        andOperandsList = null;
      }
    }
    else if (in(new String[] { "LifecycleConfiguration", "Rule", "Filter", "Tag" }))
    {
      if (name.equals("Key")) {
        currentTagKey = getText();
      } else if (name.equals("Value")) {
        currentTagValue = getText();
      }
    }
    else if (in(new String[] { "LifecycleConfiguration", "Rule", "Filter", "And" }))
    {
      if (name.equals("Prefix"))
      {
        andOperandsList.add(new LifecyclePrefixPredicate(getText()));
      }
      else if (name.equals("Tag"))
      {
        andOperandsList.add(new LifecycleTagPredicate(new Tag(currentTagKey, currentTagValue)));
        currentTagKey = null;
        currentTagValue = null;
      }
    }
    else if (in(new String[] { "LifecycleConfiguration", "Rule", "Filter", "And", "Tag" })) {
      if (name.equals("Key")) {
        currentTagKey = getText();
      } else if (name.equals("Value")) {
        currentTagValue = getText();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.BucketLifecycleConfigurationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */