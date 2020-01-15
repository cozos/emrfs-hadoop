package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Owner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartSummary;
import java.util.List;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$ListPartsHandler
  extends AbstractHandler
{
  private final PartListing result = new PartListing();
  private PartSummary currentPart;
  private Owner currentOwner;
  
  public PartListing getListPartsResult()
  {
    return result;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "ListPartsResult" })) {
      if (name.equals("Part")) {
        currentPart = new PartSummary();
      } else if ((name.equals("Owner")) || (name.equals("Initiator"))) {
        currentOwner = new Owner();
      }
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "ListPartsResult" }))
    {
      if (name.equals("Bucket"))
      {
        result.setBucketName(getText());
      }
      else if (name.equals("Key"))
      {
        result.setKey(getText());
      }
      else if (name.equals("UploadId"))
      {
        result.setUploadId(getText());
      }
      else if (name.equals("Owner"))
      {
        result.setOwner(currentOwner);
        currentOwner = null;
      }
      else if (name.equals("Initiator"))
      {
        result.setInitiator(currentOwner);
        currentOwner = null;
      }
      else if (name.equals("StorageClass"))
      {
        result.setStorageClass(getText());
      }
      else if (name.equals("PartNumberMarker"))
      {
        result.setPartNumberMarker(parseInteger(getText()).intValue());
      }
      else if (name.equals("NextPartNumberMarker"))
      {
        result.setNextPartNumberMarker(parseInteger(getText()).intValue());
      }
      else if (name.equals("MaxParts"))
      {
        result.setMaxParts(parseInteger(getText()).intValue());
      }
      else if (name.equals("EncodingType"))
      {
        result.setEncodingType(XmlResponsesSaxParser.access$100(getText()));
      }
      else if (name.equals("IsTruncated"))
      {
        result.setTruncated(Boolean.parseBoolean(getText()));
      }
      else if (name.equals("Part"))
      {
        result.getParts().add(currentPart);
        currentPart = null;
      }
    }
    else if (in(new String[] { "ListPartsResult", "Part" }))
    {
      if (name.equals("PartNumber")) {
        currentPart.setPartNumber(Integer.parseInt(getText()));
      } else if (name.equals("LastModified")) {
        currentPart.setLastModified(
          ServiceUtils.parseIso8601Date(getText()));
      } else if (name.equals("ETag")) {
        currentPart.setETag(ServiceUtils.removeQuotes(getText()));
      } else if (name.equals("Size")) {
        currentPart.setSize(Long.parseLong(getText()));
      }
    }
    else if (!in(new String[] { "ListPartsResult", "Owner" }))
    {
      if (!in(new String[] { "ListPartsResult", "Initiator" })) {}
    }
    else if (name.equals("ID")) {
      currentOwner.setId(XmlResponsesSaxParser.access$100(getText()));
    } else if (name.equals("DisplayName")) {
      currentOwner.setDisplayName(XmlResponsesSaxParser.access$100(getText()));
    }
  }
  
  private Integer parseInteger(String text)
  {
    text = XmlResponsesSaxParser.access$100(getText());
    if (text == null) {
      return null;
    }
    return Integer.valueOf(Integer.parseInt(text));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.ListPartsHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */