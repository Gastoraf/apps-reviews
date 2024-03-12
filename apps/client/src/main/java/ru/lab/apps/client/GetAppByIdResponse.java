
package ru.lab.apps.client;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAppByIdResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="getAppByIdResponse">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="return" type="{http://service.service.apps.lab.ru/}app" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAppByIdResponse", propOrder = {
    "_return"
})
public class GetAppByIdResponse {

    @XmlElement(name = "return", namespace = "")
    protected App _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link App }
     *     
     */
    public App getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link App }
     *     
     */
    public void setReturn(App value) {
        this._return = value;
    }

}
