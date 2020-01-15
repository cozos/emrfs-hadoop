package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkThreadLocalsRegistry;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XpathUtils
{
  private static final String DTM_MANAGER_DEFAULT_PROP_NAME = "com.sun.org.apache.xml.internal.dtm.DTMManager";
  private static final String DOCUMENT_BUILDER_FACTORY_PROP_NAME = "javax.xml.parsers.DocumentBuilderFactory";
  private static final String DOCUMENT_BUILDER_FACTORY_IMPL_CLASS_NAME = "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl";
  private static final String XPATH_CONTEXT_CLASS_NAME = "com.sun.org.apache.xpath.internal.XPathContext";
  private static final String DTM_MANAGER_IMPL_CLASS_NAME = "com.sun.org.apache.xml.internal.dtm.ref.DTMManagerDefault";
  private static final Log log = LogFactory.getLog(XpathUtils.class);
  private static final ErrorHandler ERROR_HANDLER = new ErrorHandler()
  {
    public void warning(SAXParseException e)
      throws SAXException
    {
      if (XpathUtils.log.isDebugEnabled()) {
        XpathUtils.log.debug("xml parse warning: " + e.getMessage(), e);
      }
    }
    
    public void fatalError(SAXParseException e)
      throws SAXException
    {
      throw e;
    }
    
    public void error(SAXParseException e)
      throws SAXException
    {
      if (XpathUtils.log.isDebugEnabled()) {
        XpathUtils.log.debug("xml parse error: " + e.getMessage(), e);
      }
    }
  };
  private static final ThreadLocal<XPathFactory> X_PATH_FACTORY = SdkThreadLocalsRegistry.register(new ThreadLocal()
  {
    protected XPathFactory initialValue()
    {
      return XPathFactory.newInstance();
    }
  });
  
  private static void speedUpDTMManager()
    throws Exception
  {
    if (System.getProperty("com.sun.org.apache.xml.internal.dtm.DTMManager") == null)
    {
      Class<?> XPathContextClass = Class.forName("com.sun.org.apache.xpath.internal.XPathContext");
      Method getDTMManager = XPathContextClass.getMethod("getDTMManager", new Class[0]);
      Object XPathContext = XPathContextClass.newInstance();
      Object dtmManager = getDTMManager.invoke(XPathContext, new Object[0]);
      if ("com.sun.org.apache.xml.internal.dtm.ref.DTMManagerDefault".equals(dtmManager.getClass().getName())) {
        System.setProperty("com.sun.org.apache.xml.internal.dtm.DTMManager", "com.sun.org.apache.xml.internal.dtm.ref.DTMManagerDefault");
      }
    }
  }
  
  private static void speedUpDcoumentBuilderFactory()
  {
    if (System.getProperty("javax.xml.parsers.DocumentBuilderFactory") == null)
    {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      if ("com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl".equals(factory.getClass().getName())) {
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
      }
    }
  }
  
  static
  {
    try
    {
      speedUpDcoumentBuilderFactory();
    }
    catch (Throwable t)
    {
      log.debug("Ingore failure in speeding up DocumentBuilderFactory", t);
    }
    try
    {
      speedUpDTMManager();
    }
    catch (Throwable t)
    {
      log.debug("Ingore failure in speeding up DTMManager", t);
    }
  }
  
  public static XPath xpath()
  {
    return ((XPathFactory)X_PATH_FACTORY.get()).newXPath();
  }
  
  public static Document documentFrom(InputStream is)
    throws SAXException, IOException, ParserConfigurationException
  {
    is = new NamespaceRemovingInputStream(is);
    
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    
    builder.setErrorHandler(ERROR_HANDLER);
    Document doc = builder.parse(is);
    is.close();
    return doc;
  }
  
  public static Document documentFrom(String xml)
    throws SAXException, IOException, ParserConfigurationException
  {
    return documentFrom(new ByteArrayInputStream(xml.getBytes(StringUtils.UTF8)));
  }
  
  public static Document documentFrom(URL url)
    throws SAXException, IOException, ParserConfigurationException
  {
    return documentFrom(url.openStream());
  }
  
  public static Double asDouble(String expression, Node node)
    throws XPathExpressionException
  {
    return asDouble(expression, node, xpath());
  }
  
  public static Double asDouble(String expression, Node node, XPath xpath)
    throws XPathExpressionException
  {
    String doubleString = evaluateAsString(expression, node, xpath);
    return isEmptyString(doubleString) ? null : Double.valueOf(Double.parseDouble(doubleString));
  }
  
  public static String asString(String expression, Node node)
    throws XPathExpressionException
  {
    return evaluateAsString(expression, node, xpath());
  }
  
  public static String asString(String expression, Node node, XPath xpath)
    throws XPathExpressionException
  {
    return evaluateAsString(expression, node, xpath);
  }
  
  public static Integer asInteger(String expression, Node node)
    throws XPathExpressionException
  {
    return asInteger(expression, node, xpath());
  }
  
  public static Integer asInteger(String expression, Node node, XPath xpath)
    throws XPathExpressionException
  {
    String intString = evaluateAsString(expression, node, xpath);
    return isEmptyString(intString) ? null : Integer.valueOf(Integer.parseInt(intString));
  }
  
  public static Boolean asBoolean(String expression, Node node)
    throws XPathExpressionException
  {
    return asBoolean(expression, node, xpath());
  }
  
  public static Boolean asBoolean(String expression, Node node, XPath xpath)
    throws XPathExpressionException
  {
    String booleanString = evaluateAsString(expression, node, xpath);
    return isEmptyString(booleanString) ? null : Boolean.valueOf(Boolean.parseBoolean(booleanString));
  }
  
  public static Float asFloat(String expression, Node node)
    throws XPathExpressionException
  {
    return asFloat(expression, node, xpath());
  }
  
  public static Float asFloat(String expression, Node node, XPath xpath)
    throws XPathExpressionException
  {
    String floatString = evaluateAsString(expression, node, xpath);
    return isEmptyString(floatString) ? null : Float.valueOf(floatString);
  }
  
  public static Long asLong(String expression, Node node)
    throws XPathExpressionException
  {
    return asLong(expression, node, xpath());
  }
  
  public static Long asLong(String expression, Node node, XPath xpath)
    throws XPathExpressionException
  {
    String longString = evaluateAsString(expression, node, xpath);
    return isEmptyString(longString) ? null : Long.valueOf(Long.parseLong(longString));
  }
  
  public static Byte asByte(String expression, Node node)
    throws XPathExpressionException
  {
    return asByte(expression, node, xpath());
  }
  
  public static Byte asByte(String expression, Node node, XPath xpath)
    throws XPathExpressionException
  {
    String byteString = evaluateAsString(expression, node, xpath);
    return isEmptyString(byteString) ? null : Byte.valueOf(byteString);
  }
  
  public static Date asDate(String expression, Node node)
    throws XPathExpressionException
  {
    return asDate(expression, node, xpath());
  }
  
  public static Date asDate(String expression, Node node, XPath xpath)
    throws XPathExpressionException
  {
    String dateString = evaluateAsString(expression, node, xpath);
    if (isEmptyString(dateString)) {
      return null;
    }
    try
    {
      return DateUtils.parseISO8601Date(dateString);
    }
    catch (Exception e)
    {
      log.warn("Unable to parse date '" + dateString + "':  " + e.getMessage(), e);
    }
    return null;
  }
  
  public static ByteBuffer asByteBuffer(String expression, Node node)
    throws XPathExpressionException
  {
    return asByteBuffer(expression, node, xpath());
  }
  
  public static ByteBuffer asByteBuffer(String expression, Node node, XPath xpath)
    throws XPathExpressionException
  {
    String base64EncodedString = evaluateAsString(expression, node, xpath);
    if (isEmptyString(base64EncodedString)) {
      return null;
    }
    if (!isEmpty(node))
    {
      byte[] decodedBytes = Base64.decode(base64EncodedString);
      return ByteBuffer.wrap(decodedBytes);
    }
    return null;
  }
  
  public static boolean isEmpty(Node node)
  {
    return node == null;
  }
  
  public static Node asNode(String nodeName, Node node)
    throws XPathExpressionException
  {
    return asNode(nodeName, node, xpath());
  }
  
  public static Node asNode(String nodeName, Node node, XPath xpath)
    throws XPathExpressionException
  {
    if (node == null) {
      return null;
    }
    return (Node)xpath.evaluate(nodeName, node, XPathConstants.NODE);
  }
  
  public static int nodeLength(NodeList list)
  {
    return list == null ? 0 : list.getLength();
  }
  
  private static String evaluateAsString(String expression, Node node, XPath xpath)
    throws XPathExpressionException
  {
    if (isEmpty(node)) {
      return null;
    }
    if (!expression.equals(".")) {
      if (asNode(expression, node, xpath) == null) {
        return null;
      }
    }
    String s = xpath.evaluate(expression, node);
    
    return s.trim();
  }
  
  private static boolean isEmptyString(String s)
  {
    return (s == null) || (s.trim().length() == 0);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XpathUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */