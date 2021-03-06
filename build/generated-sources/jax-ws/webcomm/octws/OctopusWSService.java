
package webcomm.octws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "OctopusWSService", targetNamespace = "http://service.octopus.com/", wsdlLocation = "https://service.inaras.be/OctopusService01-13/OctopusWSService?wsdl")
public class OctopusWSService
    extends Service
{

    private final static URL OCTOPUSWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException OCTOPUSWSSERVICE_EXCEPTION;
    private final static QName OCTOPUSWSSERVICE_QNAME = new QName("http://service.octopus.com/", "OctopusWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://service.inaras.be/OctopusService01-13/OctopusWSService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        OCTOPUSWSSERVICE_WSDL_LOCATION = url;
        OCTOPUSWSSERVICE_EXCEPTION = e;
    }

    public OctopusWSService() {
        super(__getWsdlLocation(), OCTOPUSWSSERVICE_QNAME);
    }

    public OctopusWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), OCTOPUSWSSERVICE_QNAME, features);
    }

    public OctopusWSService(URL wsdlLocation) {
        super(wsdlLocation, OCTOPUSWSSERVICE_QNAME);
    }

    public OctopusWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, OCTOPUSWSSERVICE_QNAME, features);
    }

    public OctopusWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OctopusWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns OctopusWS
     */
    @WebEndpoint(name = "OctopusWSPort")
    public OctopusWS getOctopusWSPort() {
        return super.getPort(new QName("http://service.octopus.com/", "OctopusWSPort"), OctopusWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OctopusWS
     */
    @WebEndpoint(name = "OctopusWSPort")
    public OctopusWS getOctopusWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.octopus.com/", "OctopusWSPort"), OctopusWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (OCTOPUSWSSERVICE_EXCEPTION!= null) {
            throw OCTOPUSWSSERVICE_EXCEPTION;
        }
        return OCTOPUSWSSERVICE_WSDL_LOCATION;
    }

}
