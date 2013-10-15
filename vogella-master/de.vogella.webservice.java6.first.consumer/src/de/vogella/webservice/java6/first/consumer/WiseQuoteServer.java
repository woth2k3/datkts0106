package de.vogella.webservice.java6.first.consumer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.1 in JDK 6 Generated
 * source version: 2.1
 * 
 */
@WebService(name = "WiseQuoteServer", targetNamespace = "http://provider.first.java6.webservice.vogella.de/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WiseQuoteServer {

	/**
	 * 
	 * @param arg0
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getQuote(
			@WebParam(name = "arg0", partName = "arg0") String arg0);

}
