package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EC2MetadataUtils$NetworkInterface
{
  private String path;
  private String mac;
  private List<String> availableKeys;
  private Map<String, String> data = new HashMap();
  
  public EC2MetadataUtils$NetworkInterface(String macAddress)
  {
    mac = macAddress;
    path = ("/network/interfaces/macs/" + mac + "/");
  }
  
  public String getMacAddress()
  {
    return mac;
  }
  
  public String getOwnerId()
  {
    return getData("owner-id");
  }
  
  public String getProfile()
  {
    return getData("profile");
  }
  
  public String getHostname()
  {
    return getData("local-hostname");
  }
  
  public List<String> getLocalIPv4s()
  {
    return getItems("local-ipv4s");
  }
  
  public String getPublicHostname()
  {
    return getData("public-hostname");
  }
  
  public List<String> getPublicIPv4s()
  {
    return getItems("public-ipv4s");
  }
  
  public List<String> getSecurityGroups()
  {
    return getItems("security-groups");
  }
  
  public List<String> getSecurityGroupIds()
  {
    return getItems("security-group-ids");
  }
  
  public String getSubnetIPv4CidrBlock()
  {
    return getData("subnet-ipv4-cidr-block");
  }
  
  public String getSubnetId()
  {
    return getData("subnet-id");
  }
  
  public String getVpcIPv4CidrBlock()
  {
    return getData("vpc-ipv4-cidr-block");
  }
  
  public String getVpcId()
  {
    return getData("vpc-id");
  }
  
  public List<String> getIPv4Association(String publicIp)
  {
    return EC2MetadataUtils.getItems("/latest/meta-data" + path + "ipv4-associations/" + publicIp);
  }
  
  private String getData(String key)
  {
    if (data.containsKey(key)) {
      return (String)data.get(key);
    }
    if (null == availableKeys) {
      availableKeys = EC2MetadataUtils.getItems("/latest/meta-data" + path);
    }
    if ((availableKeys != null) && (availableKeys.contains(key)))
    {
      data.put(key, EC2MetadataUtils.getData("/latest/meta-data" + path + key));
      return (String)data.get(key);
    }
    return null;
  }
  
  private List<String> getItems(String key)
  {
    if (null == availableKeys) {
      availableKeys = EC2MetadataUtils.getItems("/latest/meta-data" + path);
    }
    if ((availableKeys != null) && (availableKeys.contains(key))) {
      return EC2MetadataUtils.getItems("/latest/meta-data" + path + key);
    }
    return new LinkedList();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.EC2MetadataUtils.NetworkInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */