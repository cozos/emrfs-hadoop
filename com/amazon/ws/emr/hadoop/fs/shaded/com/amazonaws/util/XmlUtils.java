package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkThreadLocalsRegistry;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.stream.XMLInputFactory;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class XmlUtils
{
  private static final ThreadLocal<XMLInputFactory> xmlInputFactory = SdkThreadLocalsRegistry.register(new ThreadLocal()
  {
    protected XMLInputFactory initialValue()
    {
      return XmlUtils.access$000();
    }
  });
  
  public static XMLReader parse(InputStream in, ContentHandler handler)
    throws SAXException, IOException
  {
    XMLReader reader = XMLReaderFactory.createXMLReader();
    reader.setContentHandler(handler);
    reader.parse(new InputSource(in));
    in.close();
    return reader;
  }
  
  public static XMLInputFactory getXmlInputFactory()
  {
    return (XMLInputFactory)xmlInputFactory.get();
  }
  
  private static XMLInputFactory createXmlInputFactory()
  {
    XMLInputFactory factory = XMLInputFactory.newInstance();
    factory.setProperty("javax.xml.stream.supportDTD", Boolean.valueOf(false));
    factory.setProperty("javax.xml.stream.isSupportingExternalEntities", Boolean.valueOf(false));
    return factory;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XmlUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */