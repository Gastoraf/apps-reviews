
package ru.lab.authorization.client;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "UserNotFoundException", targetNamespace = "http://service.service.authorization.lab.ru/")
public class UserNotFoundException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private UserNotFoundException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public UserNotFoundException_Exception(String message, UserNotFoundException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public UserNotFoundException_Exception(String message, UserNotFoundException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ru.lab.authorization.client.UserNotFoundException
     */
    public UserNotFoundException getFaultInfo() {
        return faultInfo;
    }

}
