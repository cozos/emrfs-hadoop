package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RegionMetadataParser
{
  private static final String REGION_TAG = "Region";
  private static final String REGION_ID_TAG = "Name";
  private static final String DOMAIN_TAG = "Domain";
  private static final String ENDPOINT_TAG = "Endpoint";
  private static final String SERVICE_TAG = "ServiceName";
  private static final String HTTP_TAG = "Http";
  private static final String HTTPS_TAG = "Https";
  private static final String HOSTNAME_TAG = "Hostname";
  
  public static RegionMetadata parse(InputStream input)
    throws IOException
  {
    return new RegionMetadata(internalParse(input, false));
  }
  
  @Deprecated
  public List<Region> parseRegionMetadata(InputStream input)
    throws IOException
  {
    return internalParse(input, false);
  }
  
  @Deprecated
  public List<Region> parseRegionMetadata(InputStream input, boolean endpointVerification)
    throws IOException
  {
    return internalParse(input, endpointVerification);
  }
  
  private static List<Region> internalParse(InputStream input, boolean endpointVerification)
    throws IOException
  {
    try
    {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      
      DocumentBuilder documentBuilder = factory.newDocumentBuilder();
      Document document = documentBuilder.parse(input);
      try
      {
        input.close();
      }
      catch (IOException localIOException1) {}
      Document document;
      regionNodes = document.getElementsByTagName("Region");
    }
    catch (IOException exception)
    {
      throw exception;
    }
    catch (Exception exception)
    {
      throw new IOException("Unable to parse region metadata file: " + exception.getMessage(), exception);
    }
    finally
    {
      try
      {
        input.close();
      }
      catch (IOException localIOException2) {}
    }
    NodeList regionNodes;
    List<Region> regions = new ArrayList();
    for (int i = 0; i < regionNodes.getLength(); i++)
    {
      Node node = regionNodes.item(i);
      if (node.getNodeType() == 1)
      {
        Element element = (Element)node;
        regions.add(parseRegionElement(element, endpointVerification));
      }
    }
    return regions;
  }
  
  private static Region parseRegionElement(Element regionElement, boolean endpointVerification)
  {
    String name = getChildElementValue("Name", regionElement);
    String domain = getChildElementValue("Domain", regionElement);
    
    InMemoryRegionImpl regionImpl = new InMemoryRegionImpl(name, domain);
    
    NodeList endpointNodes = regionElement.getElementsByTagName("Endpoint");
    for (int i = 0; i < endpointNodes.getLength(); i++) {
      addRegionEndpoint(regionImpl, 
        (Element)endpointNodes.item(i), endpointVerification);
    }
    return new Region(regionImpl);
  }
  
  private static void addRegionEndpoint(InMemoryRegionImpl region, Element endpointElement, boolean endpointVerification)
  {
    String serviceName = getChildElementValue("ServiceName", endpointElement);
    String hostname = getChildElementValue("Hostname", endpointElement);
    String http = getChildElementValue("Http", endpointElement);
    String https = getChildElementValue("Https", endpointElement);
    if ((endpointVerification) && (!verifyLegacyEndpoint(hostname))) {
      throw new IllegalStateException("Invalid service endpoint (" + hostname + ") is detected.");
    }
    region.addEndpoint(serviceName, hostname);
    if (Boolean.valueOf(http).booleanValue()) {
      region.addHttp(serviceName);
    }
    if (Boolean.valueOf(https).booleanValue()) {
      region.addHttps(serviceName);
    }
  }
  
  private static String getChildElementValue(String tagName, Element element)
  {
    Node tagNode = element.getElementsByTagName(tagName).item(0);
    if (tagNode == null) {
      return null;
    }
    NodeList nodes = tagNode.getChildNodes();
    Node node = nodes.item(0);
    
    return node.getNodeValue();
  }
  
  private static boolean verifyLegacyEndpoint(String endpoint)
  {
    return endpoint.endsWith(".amazonaws.com");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionMetadataParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */