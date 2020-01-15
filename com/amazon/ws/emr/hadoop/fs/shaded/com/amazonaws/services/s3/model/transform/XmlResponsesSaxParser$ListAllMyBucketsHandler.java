package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Bucket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Owner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$ListAllMyBucketsHandler
  extends AbstractHandler
{
  private final List<Bucket> buckets = new ArrayList();
  private Owner bucketsOwner = null;
  private Bucket currentBucket = null;
  
  public List<Bucket> getBuckets()
  {
    return buckets;
  }
  
  public Owner getOwner()
  {
    return bucketsOwner;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "ListAllMyBucketsResult" }))
    {
      if (name.equals("Owner")) {
        bucketsOwner = new Owner();
      }
    }
    else if ((in(new String[] { "ListAllMyBucketsResult", "Buckets" })) && 
      (name.equals("Bucket")))
    {
      currentBucket = new Bucket();
      currentBucket.setOwner(bucketsOwner);
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "ListAllMyBucketsResult", "Owner" }))
    {
      if (name.equals("ID")) {
        bucketsOwner.setId(getText());
      } else if (name.equals("DisplayName")) {
        bucketsOwner.setDisplayName(getText());
      }
    }
    else if (in(new String[] { "ListAllMyBucketsResult", "Buckets" }))
    {
      if (name.equals("Bucket"))
      {
        buckets.add(currentBucket);
        currentBucket = null;
      }
    }
    else if (in(new String[] { "ListAllMyBucketsResult", "Buckets", "Bucket" })) {
      if (name.equals("Name"))
      {
        currentBucket.setName(getText());
      }
      else if (name.equals("CreationDate"))
      {
        Date creationDate = DateUtils.parseISO8601Date(getText());
        currentBucket.setCreationDate(creationDate);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.ListAllMyBucketsHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */