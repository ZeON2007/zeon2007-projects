
package by.herzhot.soap.pojos;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for UqcOrderReferService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UqcOrderReferService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UqcOrderReferRequest" type="{http://com.hitachi.sawara/}UqcOrderReferRequest" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UqcOrderReferService", namespace = "1", propOrder = {
    "uqcOrderReferRequest"
})
@XmlRootElement(name = "UqcOrderReferService")
public class UqcOrderReferService {

    @XmlElement(name = "UqcOrderReferRequest")
    protected UqcOrderReferRequest uqcOrderReferRequest;

    /**
     * Gets the value of the uqcOrderReferRequest property.
     * 
     * @return
     *     possible object is
     *     {@link UqcOrderReferRequest }
     *     
     */
    public UqcOrderReferRequest getUqcOrderReferRequest() {
        return uqcOrderReferRequest;
    }

    /**
     * Sets the value of the uqcOrderReferRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link UqcOrderReferRequest }
     *     
     */
    public void setUqcOrderReferRequest(UqcOrderReferRequest value) {
        this.uqcOrderReferRequest = value;
    }

}
