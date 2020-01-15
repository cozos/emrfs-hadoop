package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CanonicalGrantee;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EmailAddressGrantee;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Grantee;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GroupGrantee;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Owner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Permission;
import org.xml.sax.Attributes;

public class XmlResponsesSaxParser$AccessControlListHandler
  extends AbstractHandler
{
  private final AccessControlList accessControlList = new AccessControlList();
  private Grantee currentGrantee = null;
  private Permission currentPermission = null;
  
  public AccessControlList getAccessControlList()
  {
    return accessControlList;
  }
  
  protected void doStartElement(String uri, String name, String qName, Attributes attrs)
  {
    if (in(new String[] { "AccessControlPolicy" }))
    {
      if (name.equals("Owner")) {
        accessControlList.setOwner(new Owner());
      }
    }
    else if ((in(new String[] { "AccessControlPolicy", "AccessControlList", "Grant" })) && 
      (name.equals("Grantee")))
    {
      String type = XmlResponsesSaxParser.access$500("xsi:type", attrs);
      if ("AmazonCustomerByEmail".equals(type)) {
        currentGrantee = new EmailAddressGrantee(null);
      } else if ("CanonicalUser".equals(type)) {
        currentGrantee = new CanonicalGrantee(null);
      } else if (!"Group".equals(type)) {}
    }
  }
  
  protected void doEndElement(String uri, String name, String qName)
  {
    if (in(new String[] { "AccessControlPolicy", "Owner" }))
    {
      if (name.equals("ID")) {
        accessControlList.getOwner().setId(getText());
      } else if (name.equals("DisplayName")) {
        accessControlList.getOwner().setDisplayName(getText());
      }
    }
    else if (in(new String[] { "AccessControlPolicy", "AccessControlList" }))
    {
      if (name.equals("Grant"))
      {
        accessControlList.grantPermission(currentGrantee, currentPermission);
        
        currentGrantee = null;
        currentPermission = null;
      }
    }
    else if (in(new String[] { "AccessControlPolicy", "AccessControlList", "Grant" }))
    {
      if (name.equals("Permission")) {
        currentPermission = Permission.parsePermission(getText());
      }
    }
    else if (in(new String[] { "AccessControlPolicy", "AccessControlList", "Grant", "Grantee" })) {
      if (name.equals("ID")) {
        currentGrantee.setIdentifier(getText());
      } else if (name.equals("EmailAddress")) {
        currentGrantee.setIdentifier(getText());
      } else if (name.equals("URI")) {
        currentGrantee = GroupGrantee.parseGroupGrantee(getText());
      } else if (name.equals("DisplayName")) {
        ((CanonicalGrantee)currentGrantee).setDisplayName(getText());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.XmlResponsesSaxParser.AccessControlListHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */