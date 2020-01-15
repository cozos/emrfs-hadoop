package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.XmlWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CanonicalGrantee;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EmailAddressGrantee;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Grant;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Grantee;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GroupGrantee;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Owner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Permission;

public class AclXmlFactory
{
  public byte[] convertToXmlByteArray(AccessControlList acl)
    throws SdkClientException
  {
    Owner owner = acl.getOwner();
    if (owner == null) {
      throw new SdkClientException("Invalid AccessControlList: missing an S3Owner");
    }
    XmlWriter xml = new XmlWriter();
    xml.start("AccessControlPolicy", "xmlns", "http://s3.amazonaws.com/doc/2006-03-01/");
    xml.start("Owner");
    if (owner.getId() != null) {
      xml.start("ID").value(owner.getId()).end();
    }
    if (owner.getDisplayName() != null) {
      xml.start("DisplayName").value(owner.getDisplayName()).end();
    }
    xml.end();
    xml.start("AccessControlList");
    for (Grant grant : acl.getGrantsAsList())
    {
      xml.start("Grant");
      convertToXml(grant.getGrantee(), xml);
      xml.start("Permission").value(grant.getPermission().toString()).end();
      xml.end();
    }
    xml.end();
    xml.end();
    
    return xml.getBytes();
  }
  
  protected XmlWriter convertToXml(Grantee grantee, XmlWriter xml)
    throws SdkClientException
  {
    if ((grantee instanceof CanonicalGrantee)) {
      return convertToXml((CanonicalGrantee)grantee, xml);
    }
    if ((grantee instanceof EmailAddressGrantee)) {
      return convertToXml((EmailAddressGrantee)grantee, xml);
    }
    if ((grantee instanceof GroupGrantee)) {
      return convertToXml((GroupGrantee)grantee, xml);
    }
    throw new SdkClientException("Unknown Grantee type: " + grantee.getClass().getName());
  }
  
  protected XmlWriter convertToXml(CanonicalGrantee grantee, XmlWriter xml)
  {
    xml.start("Grantee", new String[] { "xmlns:xsi", "xsi:type" }, new String[] { "http://www.w3.org/2001/XMLSchema-instance", "CanonicalUser" });
    
    xml.start("ID").value(grantee.getIdentifier()).end();
    xml.end();
    
    return xml;
  }
  
  protected XmlWriter convertToXml(EmailAddressGrantee grantee, XmlWriter xml)
  {
    xml.start("Grantee", new String[] { "xmlns:xsi", "xsi:type" }, new String[] { "http://www.w3.org/2001/XMLSchema-instance", "AmazonCustomerByEmail" });
    
    xml.start("EmailAddress").value(grantee.getIdentifier()).end();
    xml.end();
    
    return xml;
  }
  
  protected XmlWriter convertToXml(GroupGrantee grantee, XmlWriter xml)
  {
    xml.start("Grantee", new String[] { "xmlns:xsi", "xsi:type" }, new String[] { "http://www.w3.org/2001/XMLSchema-instance", "Group" });
    
    xml.start("URI").value(grantee.getIdentifier()).end();
    xml.end();
    
    return xml;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.AclXmlFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */