package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUpload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Owner;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$ListMultipartUploadsHandler
  extends AbstractHandler
{
  private final MultipartUploadListing result = new MultipartUploadListing();
  private MultipartUpload currentMultipartUpload;
  private Owner currentOwner;
  
  public MultipartUploadListing getListMultipartUploadsResult()
  {
    return result;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "ListMultipartUploadsResult" }))
    {
      if (name.equals("Upload")) {
        currentMultipartUpload = new MultipartUpload();
      }
    }
    else if ((in(new String[] { "ListMultipartUploadsResult", "Upload" })) && (
      (name.equals("Owner")) || (name.equals("Initiator")))) {
      currentOwner = new Owner();
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "ListMultipartUploadsResult" }))
    {
      if (name.equals("Bucket"))
      {
        result.setBucketName(getText());
      }
      else if (name.equals("KeyMarker"))
      {
        result.setKeyMarker(XmlResponsesSaxParser.access$100(getText()));
      }
      else if (name.equals("Delimiter"))
      {
        result.setDelimiter(XmlResponsesSaxParser.access$100(getText()));
      }
      else if (name.equals("Prefix"))
      {
        result.setPrefix(XmlResponsesSaxParser.access$100(getText()));
      }
      else if (name.equals("UploadIdMarker"))
      {
        result.setUploadIdMarker(XmlResponsesSaxParser.access$100(getText()));
      }
      else if (name.equals("NextKeyMarker"))
      {
        result.setNextKeyMarker(XmlResponsesSaxParser.access$100(getText()));
      }
      else if (name.equals("NextUploadIdMarker"))
      {
        result.setNextUploadIdMarker(XmlResponsesSaxParser.access$100(getText()));
      }
      else if (name.equals("MaxUploads"))
      {
        result.setMaxUploads(Integer.parseInt(getText()));
      }
      else if (name.equals("EncodingType"))
      {
        result.setEncodingType(XmlResponsesSaxParser.access$100(getText()));
      }
      else if (name.equals("IsTruncated"))
      {
        result.setTruncated(Boolean.parseBoolean(getText()));
      }
      else if (name.equals("Upload"))
      {
        result.getMultipartUploads().add(currentMultipartUpload);
        currentMultipartUpload = null;
      }
    }
    else if (in(new String[] { "ListMultipartUploadsResult", "CommonPrefixes" }))
    {
      if (name.equals("Prefix")) {
        result.getCommonPrefixes().add(getText());
      }
    }
    else if (in(new String[] { "ListMultipartUploadsResult", "Upload" }))
    {
      if (name.equals("Key"))
      {
        currentMultipartUpload.setKey(getText());
      }
      else if (name.equals("UploadId"))
      {
        currentMultipartUpload.setUploadId(getText());
      }
      else if (name.equals("Owner"))
      {
        currentMultipartUpload.setOwner(currentOwner);
        currentOwner = null;
      }
      else if (name.equals("Initiator"))
      {
        currentMultipartUpload.setInitiator(currentOwner);
        currentOwner = null;
      }
      else if (name.equals("StorageClass"))
      {
        currentMultipartUpload.setStorageClass(getText());
      }
      else if (name.equals("Initiated"))
      {
        currentMultipartUpload.setInitiated(
          ServiceUtils.parseIso8601Date(getText()));
      }
    }
    else if (!in(new String[] { "ListMultipartUploadsResult", "Upload", "Owner" }))
    {
      if (!in(new String[] { "ListMultipartUploadsResult", "Upload", "Initiator" })) {}
    }
    else if (name.equals("ID")) {
      currentOwner.setId(XmlResponsesSaxParser.access$100(getText()));
    } else if (name.equals("DisplayName")) {
      currentOwner.setDisplayName(XmlResponsesSaxParser.access$100(getText()));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.ListMultipartUploadsHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */