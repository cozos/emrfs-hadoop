package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CSVInput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CSVOutput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Encryption;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GlacierJobParameters;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Grant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InputSerialization;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.JSONInput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.JSONOutput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MetadataEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectTagging;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.OutputLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.OutputSerialization;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RequestProgress;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RestoreObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Location;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectParameters;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Tag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RequestXmlFactory
{
  public static byte[] convertToXmlByteArray(List<PartETag> partETags)
  {
    XmlWriter xml = new XmlWriter();
    xml.start("CompleteMultipartUpload");
    if (partETags != null)
    {
      List<PartETag> sortedPartETags = new ArrayList(partETags);
      Collections.sort(sortedPartETags, new Comparator()
      {
        public int compare(PartETag tag1, PartETag tag2)
        {
          if (tag1.getPartNumber() < tag2.getPartNumber()) {
            return -1;
          }
          if (tag1.getPartNumber() > tag2.getPartNumber()) {
            return 1;
          }
          return 0;
        }
      });
      for (PartETag partEtag : sortedPartETags)
      {
        xml.start("Part");
        xml.start("PartNumber").value(Integer.toString(partEtag.getPartNumber())).end();
        xml.start("ETag").value(partEtag.getETag()).end();
        xml.end();
      }
    }
    xml.end();
    
    return xml.getBytes();
  }
  
  public static byte[] convertToXmlByteArray(RestoreObjectRequest restoreObjectRequest)
    throws SdkClientException
  {
    XmlWriter xml = new XmlWriter();
    
    xml.start("RestoreRequest");
    if (restoreObjectRequest.getExpirationInDays() != -1) {
      xml.start("Days").value(Integer.toString(restoreObjectRequest.getExpirationInDays())).end();
    }
    GlacierJobParameters glacierJobParameters = restoreObjectRequest.getGlacierJobParameters();
    if (glacierJobParameters != null)
    {
      xml.start("GlacierJobParameters");
      addIfNotNull(xml, "Tier", glacierJobParameters.getTier());
      xml.end();
    }
    addIfNotNull(xml, "Type", restoreObjectRequest.getType());
    addIfNotNull(xml, "Tier", restoreObjectRequest.getTier());
    addIfNotNull(xml, "Description", restoreObjectRequest.getDescription());
    
    addSelectParametersIfNotNull(xml, restoreObjectRequest.getSelectParameters());
    addOutputLocationIfNotNull(xml, restoreObjectRequest.getOutputLocation());
    xml.end();
    
    return xml.getBytes();
  }
  
  public static byte[] convertToXmlByteArray(SelectObjectContentRequest selectRequest)
  {
    XmlWriter xml = new XmlWriter();
    xml.start("SelectObjectContentRequest");
    
    addIfNotNull(xml, "Expression", selectRequest.getExpression());
    addIfNotNull(xml, "ExpressionType", selectRequest.getExpressionType());
    addRequestProgressIfNotNull(xml, selectRequest.getRequestProgress());
    addInputSerializationIfNotNull(xml, selectRequest.getInputSerialization());
    addOutputSerializationIfNotNull(xml, selectRequest.getOutputSerialization());
    
    xml.end();
    return xml.getBytes();
  }
  
  private static void addRequestProgressIfNotNull(XmlWriter xml, RequestProgress requestProgress)
  {
    if (requestProgress == null) {
      return;
    }
    xml.start("RequestProgress");
    
    addIfNotNull(xml, "Enabled", requestProgress.getEnabled());
    
    xml.end();
  }
  
  private static void addSelectParametersIfNotNull(XmlWriter xml, SelectParameters selectParameters)
  {
    if (selectParameters == null) {
      return;
    }
    xml.start("SelectParameters");
    
    addInputSerializationIfNotNull(xml, selectParameters.getInputSerialization());
    
    addIfNotNull(xml, "ExpressionType", selectParameters.getExpressionType());
    addIfNotNull(xml, "Expression", selectParameters.getExpression());
    
    addOutputSerializationIfNotNull(xml, selectParameters.getOutputSerialization());
    
    xml.end();
  }
  
  private static void addInputSerializationIfNotNull(XmlWriter xml, InputSerialization inputSerialization)
  {
    if (inputSerialization != null)
    {
      xml.start("InputSerialization");
      if (inputSerialization.getCsv() != null)
      {
        xml.start("CSV");
        CSVInput csvInput = inputSerialization.getCsv();
        addIfNotNull(xml, "FileHeaderInfo", csvInput.getFileHeaderInfo());
        addIfNotNull(xml, "Comments", csvInput.getCommentsAsString());
        addIfNotNull(xml, "QuoteEscapeCharacter", csvInput.getQuoteEscapeCharacterAsString());
        addIfNotNull(xml, "RecordDelimiter", csvInput.getRecordDelimiterAsString());
        addIfNotNull(xml, "FieldDelimiter", csvInput.getFieldDelimiterAsString());
        addIfNotNull(xml, "QuoteCharacter", csvInput.getQuoteCharacterAsString());
        addIfNotNull(xml, "AllowQuotedRecordDelimiter", csvInput.getAllowQuotedRecordDelimiter());
        xml.end();
      }
      if (inputSerialization.getJson() != null)
      {
        xml.start("JSON");
        JSONInput jsonInput = inputSerialization.getJson();
        addIfNotNull(xml, "Type", jsonInput.getType());
        xml.end();
      }
      if (inputSerialization.getParquet() != null)
      {
        xml.start("Parquet");
        xml.end();
      }
      addIfNotNull(xml, "CompressionType", inputSerialization.getCompressionType());
      
      xml.end();
    }
  }
  
  private static void addOutputSerializationIfNotNull(XmlWriter xml, OutputSerialization outputSerialization)
  {
    if (outputSerialization != null)
    {
      xml.start("OutputSerialization");
      if (outputSerialization.getCsv() != null)
      {
        xml.start("CSV");
        CSVOutput csvOutput = outputSerialization.getCsv();
        addIfNotNull(xml, "QuoteFields", csvOutput.getQuoteFields());
        addIfNotNull(xml, "QuoteEscapeCharacter", csvOutput.getQuoteEscapeCharacterAsString());
        addIfNotNull(xml, "RecordDelimiter", csvOutput.getRecordDelimiterAsString());
        addIfNotNull(xml, "FieldDelimiter", csvOutput.getFieldDelimiterAsString());
        addIfNotNull(xml, "QuoteCharacter", csvOutput.getQuoteCharacterAsString());
        xml.end();
      }
      if (outputSerialization.getJson() != null)
      {
        xml.start("JSON");
        JSONOutput jsonOutput = outputSerialization.getJson();
        addIfNotNull(xml, "RecordDelimiter", jsonOutput.getRecordDelimiterAsString());
        xml.end();
      }
      xml.end();
    }
  }
  
  private static void addTaggingIfNotNull(XmlWriter xml, ObjectTagging tagSet)
  {
    if (tagSet == null) {
      return;
    }
    xml.start("Tagging");
    xml.start("TagSet");
    for (Tag tag : tagSet.getTagSet())
    {
      xml.start("Tag");
      xml.start("Key").value(tag.getKey()).end();
      xml.start("Value").value(tag.getValue()).end();
      xml.end();
    }
    xml.end();
    xml.end();
  }
  
  private static void addOutputLocationIfNotNull(XmlWriter xml, OutputLocation outputLocation)
  {
    if (outputLocation == null) {
      return;
    }
    xml.start("OutputLocation");
    if (outputLocation.getS3() != null)
    {
      S3Location s3 = outputLocation.getS3();
      xml.start("S3");
      
      addIfNotNull(xml, "BucketName", s3.getBucketName());
      addIfNotNull(xml, "Prefix", s3.getPrefix());
      if (s3.getEncryption() != null)
      {
        Encryption encryption = s3.getEncryption();
        xml.start("Encryption");
        addIfNotNull(xml, "EncryptionType", encryption.getEncryptionType());
        addIfNotNull(xml, "KMSKeyId", encryption.getKmsKeyId());
        addIfNotNull(xml, "KMSContext", encryption.getKmsContext());
        xml.end();
      }
      addIfNotNull(xml, "CannedACL", s3.getCannedACL());
      addGrantsIfNotNull(xml, s3.getAccessControlList());
      addTaggingIfNotNull(xml, s3.getTagging());
      addIfNotNull(xml, "StorageClass", s3.getStorageClass());
      
      addUserMetaDataIfNotNull(xml, s3.getUserMetadata());
      
      xml.end();
    }
    xml.end();
  }
  
  private static void addGrantsIfNotNull(XmlWriter xml, AccessControlList accessControlList)
  {
    if (accessControlList == null) {
      return;
    }
    AclXmlFactory aclXmlFactory = new AclXmlFactory();
    xml.start("AccessControlList");
    for (Grant grant : accessControlList.getGrantsAsList())
    {
      xml.start("Grant");
      if (grant.getGrantee() != null) {
        aclXmlFactory.convertToXml(grant.getGrantee(), xml);
      }
      addIfNotNull(xml, "Permission", grant.getPermission());
      xml.end();
    }
    xml.end();
  }
  
  private static void addUserMetaDataIfNotNull(XmlWriter xml, List<MetadataEntry> userMetadata)
  {
    if ((userMetadata == null) || (userMetadata.isEmpty())) {
      return;
    }
    xml.start("UserMetadata");
    for (MetadataEntry metadataEntry : userMetadata)
    {
      xml.start("MetadataEntry");
      addIfNotNull(xml, "Name", metadataEntry.getName());
      addIfNotNull(xml, "Value", metadataEntry.getValue());
      xml.end();
    }
    xml.end();
  }
  
  private static void addIfNotNull(XmlWriter xml, String xmlTag, String value)
  {
    if (value != null) {
      xml.start(xmlTag).value(value).end();
    }
  }
  
  private static void addIfNotNull(XmlWriter xml, String xmlTag, Object value)
  {
    if ((value != null) && (value.toString() != null)) {
      xml.start(xmlTag).value(value.toString()).end();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.RequestXmlFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */