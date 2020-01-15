package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Owner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.VersionListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$ListVersionsHandler
  extends AbstractHandler
{
  private final VersionListing versionListing = new VersionListing();
  private final boolean shouldSDKDecodeResponse;
  private S3VersionSummary currentVersionSummary;
  private Owner currentOwner;
  
  public XmlResponsesSaxParser$ListVersionsHandler(boolean shouldSDKDecodeResponse)
  {
    this.shouldSDKDecodeResponse = shouldSDKDecodeResponse;
  }
  
  public VersionListing getListing()
  {
    return versionListing;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "ListVersionsResult" }))
    {
      if (name.equals("Version"))
      {
        currentVersionSummary = new S3VersionSummary();
        currentVersionSummary.setBucketName(versionListing
          .getBucketName());
      }
      else if (name.equals("DeleteMarker"))
      {
        currentVersionSummary = new S3VersionSummary();
        currentVersionSummary.setBucketName(versionListing
          .getBucketName());
        currentVersionSummary.setIsDeleteMarker(true);
      }
    }
    else if (!in(new String[] { "ListVersionsResult", "Version" }))
    {
      if (!in(new String[] { "ListVersionsResult", "DeleteMarker" })) {}
    }
    else if (name.equals("Owner")) {
      currentOwner = new Owner();
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "ListVersionsResult" }))
    {
      if (name.equals("Name"))
      {
        versionListing.setBucketName(getText());
      }
      else if (name.equals("Prefix"))
      {
        versionListing.setPrefix(XmlResponsesSaxParser.access$200(
          XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
      }
      else if (name.equals("KeyMarker"))
      {
        versionListing.setKeyMarker(XmlResponsesSaxParser.access$200(
          XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
      }
      else if (name.equals("VersionIdMarker"))
      {
        versionListing.setVersionIdMarker(XmlResponsesSaxParser.access$100(
          getText()));
      }
      else if (name.equals("MaxKeys"))
      {
        versionListing.setMaxKeys(Integer.parseInt(getText()));
      }
      else if (name.equals("Delimiter"))
      {
        versionListing.setDelimiter(XmlResponsesSaxParser.access$200(
          XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
      }
      else if (name.equals("EncodingType"))
      {
        versionListing.setEncodingType(shouldSDKDecodeResponse ? null : 
          XmlResponsesSaxParser.access$100(getText()));
      }
      else if (name.equals("NextKeyMarker"))
      {
        versionListing.setNextKeyMarker(XmlResponsesSaxParser.access$200(
          XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
      }
      else if (name.equals("NextVersionIdMarker"))
      {
        versionListing.setNextVersionIdMarker(getText());
      }
      else if (name.equals("IsTruncated"))
      {
        versionListing.setTruncated("true".equals(getText()));
      }
      else if ((name.equals("Version")) || 
        (name.equals("DeleteMarker")))
      {
        versionListing.getVersionSummaries().add(currentVersionSummary);
        
        currentVersionSummary = null;
      }
    }
    else if (in(new String[] { "ListVersionsResult", "CommonPrefixes" }))
    {
      if (name.equals("Prefix"))
      {
        String commonPrefix = XmlResponsesSaxParser.access$100(getText());
        versionListing.getCommonPrefixes()
          .add(shouldSDKDecodeResponse ? 
          SdkHttpUtils.urlDecode(commonPrefix) : commonPrefix);
      }
    }
    else
    {
      if (!in(new String[] { "ListVersionsResult", "Version" }))
      {
        if (!in(new String[] { "ListVersionsResult", "DeleteMarker" })) {}
      }
      else
      {
        if (name.equals("Key"))
        {
          currentVersionSummary.setKey(XmlResponsesSaxParser.access$200(getText(), shouldSDKDecodeResponse)); return;
        }
        if (name.equals("VersionId"))
        {
          currentVersionSummary.setVersionId(getText()); return;
        }
        if (name.equals("IsLatest"))
        {
          currentVersionSummary.setIsLatest("true".equals(getText())); return;
        }
        if (name.equals("LastModified"))
        {
          currentVersionSummary.setLastModified(
            ServiceUtils.parseIso8601Date(getText())); return;
        }
        if (name.equals("ETag"))
        {
          currentVersionSummary.setETag(
            ServiceUtils.removeQuotes(getText())); return;
        }
        if (name.equals("Size"))
        {
          currentVersionSummary.setSize(Long.parseLong(getText())); return;
        }
        if (name.equals("Owner"))
        {
          currentVersionSummary.setOwner(currentOwner);
          currentOwner = null; return;
        }
        if (!name.equals("StorageClass")) {
          return;
        }
        currentVersionSummary.setStorageClass(getText()); return;
      }
      if (!in(new String[] { "ListVersionsResult", "Version", "Owner" }))
      {
        if (!in(new String[] { "ListVersionsResult", "DeleteMarker", "Owner" })) {}
      }
      else if (name.equals("ID")) {
        currentOwner.setId(getText());
      } else if (name.equals("DisplayName")) {
        currentOwner.setDisplayName(getText());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.ListVersionsHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */