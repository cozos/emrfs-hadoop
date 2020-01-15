package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Owner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$ListObjectsV2Handler
  extends AbstractHandler
{
  private final ListObjectsV2Result result = new ListObjectsV2Result();
  private final boolean shouldSDKDecodeResponse;
  private S3ObjectSummary currentObject = null;
  private Owner currentOwner = null;
  private String lastKey = null;
  
  public XmlResponsesSaxParser$ListObjectsV2Handler(boolean shouldSDKDecodeResponse)
  {
    this.shouldSDKDecodeResponse = shouldSDKDecodeResponse;
  }
  
  public ListObjectsV2Result getResult()
  {
    return result;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "ListBucketResult" }))
    {
      if (name.equals("Contents"))
      {
        currentObject = new S3ObjectSummary();
        currentObject.setBucketName(result.getBucketName());
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
        if ((result.isTruncated()) && 
          (result.getNextContinuationToken() == null))
        {
          String nextContinuationToken = null;
          if (!result.getObjectSummaries().isEmpty()) {
            nextContinuationToken = ((S3ObjectSummary)result.getObjectSummaries().get(result.getObjectSummaries().size() - 1)).getKey();
          } else {
            XmlResponsesSaxParser.access$000().error("S3 response indicates truncated results, but contains no object summaries.");
          }
          result.setNextContinuationToken(nextContinuationToken);
        }
      }
    }
    else if (in(new String[] { "ListBucketResult" }))
    {
      if (name.equals("Name"))
      {
        result.setBucketName(getText());
        if (XmlResponsesSaxParser.access$000().isDebugEnabled()) {
          XmlResponsesSaxParser.access$000().debug("Examining listing for bucket: " + result
            .getBucketName());
        }
      }
      else if (name.equals("Prefix"))
      {
        result.setPrefix(XmlResponsesSaxParser.access$200(
          XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
      }
      else if (name.equals("MaxKeys"))
      {
        result.setMaxKeys(XmlResponsesSaxParser.access$300(getText()));
      }
      else if (name.equals("NextContinuationToken"))
      {
        result.setNextContinuationToken(getText());
      }
      else if (name.equals("ContinuationToken"))
      {
        result.setContinuationToken(getText());
      }
      else if (name.equals("StartAfter"))
      {
        result.setStartAfter(XmlResponsesSaxParser.access$200(
          getText(), shouldSDKDecodeResponse));
      }
      else if (name.equals("KeyCount"))
      {
        result.setKeyCount(XmlResponsesSaxParser.access$300(getText()));
      }
      else if (name.equals("Delimiter"))
      {
        result.setDelimiter(XmlResponsesSaxParser.access$200(
          XmlResponsesSaxParser.access$100(getText()), shouldSDKDecodeResponse));
      }
      else if (name.equals("EncodingType"))
      {
        result.setEncodingType(XmlResponsesSaxParser.access$100(getText()));
      }
      else if (name.equals("IsTruncated"))
      {
        String isTruncatedStr = StringUtils.lowerCase(getText());
        if (isTruncatedStr.startsWith("false")) {
          result.setTruncated(false);
        } else if (isTruncatedStr.startsWith("true")) {
          result.setTruncated(true);
        } else {
          throw new IllegalStateException("Invalid value for IsTruncated field: " + isTruncatedStr);
        }
      }
      else if (name.equals("Contents"))
      {
        result.getObjectSummaries().add(currentObject);
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
      result.getCommonPrefixes().add(XmlResponsesSaxParser.access$200(getText(), shouldSDKDecodeResponse));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.ListObjectsV2Handler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */