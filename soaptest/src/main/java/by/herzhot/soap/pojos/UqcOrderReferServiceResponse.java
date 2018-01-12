
package by.herzhot.soap.pojos;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for UqcOrderReferServiceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UqcOrderReferServiceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UqcOrderReferResponse" type="{http://com.hitachi.sawara/}UqcOrderReferResponse" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UqcOrderReferServiceResponse", namespace = "2", propOrder = {
    "uqcOrderReferResponse"
})
//@XmlRootElement(name = "UqcOrderReferServiceResponse")
public class UqcOrderReferServiceResponse {

    @XmlElement(name = "UqcOrderReferResponse")
    protected UqcOrderReferResponse uqcOrderReferResponse;

    /**
     * Gets the value of the uqcOrderReferResponse property.
     * 
     * @return
     *     possible object is
     *     {@link UqcOrderReferResponse }
     *     
     */
    public UqcOrderReferResponse getUqcOrderReferResponse() {
        return uqcOrderReferResponse;
    }

    /**
     * Sets the value of the uqcOrderReferResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link UqcOrderReferResponse }
     *     
     */
    public void setUqcOrderReferResponse(UqcOrderReferResponse value) {
        this.uqcOrderReferResponse = value;
    }

}
