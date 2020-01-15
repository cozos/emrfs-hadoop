package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Owner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$ListBucketHandler
  extends AbstractHandler
{
  private final ObjectListing objectListing = new ObjectListing();
  private final boolean shouldSDKDecodeResponse;
  private S3ObjectSummary currentObject = null;
  private Owner currentOwner = null;
  private String lastKey = null;
  
  public XmlResponsesSaxParser$ListBucketHandler(boolean shouldSDKDecodeResponse)
  {
    this.shouldSDKDecodeResponse = shouldSDKDecodeResponse;
  }
  
  public ObjectListing getObjectListing()
  {
    return objectListing;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "ListBucketResult" }))
    {
      if (name.equals("Contents"))
      {
        currentObject = new S3ObjectSummary();
        currentObject.setBucketName(objectListing.getBucketName());
      }
    }
    else if ((in(new String[] { "ListBucketResult", "Contents" })) && 
      (name.equals("Owner"))) {
      currentOwner = new Owner();
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (atTopLevel())
    {
      if (name.equals("ListBucketResult")) {
        if ((objectListing.isTruncated()) && 
          (objectListing.getNextMarker() == null))
        {
          String nextMarker = null;
          if (!objectListing.getObjectSummaries().isEmpty()) {
            nextMarker = ((S3ObjectSummary)objectListing.getObjectSummaries().get(objectListing.getObjectSummaries().size() - 1)).getKey();
          } else if (!objectListing.getCommonPrefixes().isEmpty()) {
            nextMarker = (String)objectListing.getCommonPrefixes().get(objectListing.getCommonPrefixes().size() - 1);
          } else {
            XmlResponsesSaxParser.access$000().error("S3 response indicates truncated results, but contains no object summaries or common prefixes.");
          }
          objectListing.setNextMarker(nextMarker);
        }
      }
    }
    else if (in(new String[] { "ListBucketResult" }))
    {
      if (name.equals("Name"))
      {
        objectListing.setBucketName(getText());
        if (XmlResponsesSaxParser.access$000().isDebugEnabled()) {
          XmlResponsesSaxParser.access$000().debug("Examining listing for bucket: " + objectListing
            .getBucketName());
        }
      }
      else if (name.equals("Prefix"))
      {
        objectListing.setPrefix(XmlResponsesSaxParser.access$200(
          XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
      }
      else if (name.equals("Marker"))
      {
        objectListing.setMarker(XmlResponsesSaxParser.access$200(
          XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
      }
      else if (name.equals("NextMarker"))
      {
        objectListing.setNextMarker(XmlResponsesSaxParser.access$200(
          getText(), shouldSDKDecodeResponse));
      }
      else if (name.equals("MaxKeys"))
      {
        objectListing.setMaxKeys(XmlResponsesSaxParser.access$300(getText()));
      }
      else if (name.equals("Delimiter"))
      {
        objectListing.setDelimiter(XmlResponsesSaxParser.access$200(
          XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
      }
      else if (name.equals("EncodingType"))
      {
        objectListing.setEncodingType(shouldSDKDecodeResponse ? null : 
          XmlResponsesSaxParser.access$100(getText()));
      }
      else if (name.equals("IsTruncated"))
      {
        String isTruncatedStr = StringUtils.lowerCase(getText());
        if (isTruncatedStr.startsWith("false")) {
          objectListing.setTruncated(false);
        } else if (isTruncatedStr.startsWith("true")) {
          objectListing.setTruncated(true);
        } else {
          throw new IllegalStateException("Invalid value for IsTruncated field: " + isTruncatedStr);
        }
      }
      else if (name.equals("Contents"))
      {
        objectListing.getObjectSummaries().add(currentObject);
        currentObject = null;
      }
    }
    else if (in(new String[] { "ListBucketResult", "Contents" }))
    {
      if (name.equals("Key"))
      {
        lastKey = getText();
        currentObject.setKey(XmlResponsesSaxParser.access$200(lastKey, shouldSDKDecodeResponse));
      }
      else if (name.equals("LastModified"))
      {
        currentObject.setLastModified(
          ServiceUtils.parseIso8601Date(getText()));
      }
      else if (name.equals("ETag"))
      {
        currentObject.setETag(
          ServiceUtils.removeQuotes(getText()));
      }
      else if (name.equals("Size"))
      {
        currentObject.setSize(XmlResponsesSaxParser.access$400(getText()));
      }
      else if (name.equals("StorageClass"))
      {
        currentObject.setStorageClass(getText());
      }
      else if (name.equals("Owner"))
      {
        currentObject.setOwner(currentOwner);
        currentOwner = null;
      }
    }
    else if (in(new String[] { "ListBucketResult", "Contents", "Owner" }))
    {
      if (name.equals("ID")) {
        currentOwner.setId(getText());
      } else if (name.equals("DisplayName")) {
        currentOwner.setDisplayName(getText());
      }
    }
    else if ((in(new String[] { "ListBucketResult", "CommonPrefixes" })) && 
      (name.equals("Prefix"))) {
      objectListing.getCommonPrefixes().add(XmlResponsesSaxParser.access$200(getText(), shouldSDKDecodeResponse));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.ListBucketHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */