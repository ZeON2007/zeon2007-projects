
package by.herzhot.soap.pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CusconResponseCommonItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CusconResponseCommonItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uketukeResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uketukeResultDetail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CusconResponseCommonItem", propOrder = {
    "uketukeResult",
    "uketukeResultDetail"
})
//@XmlRootElement(name = "CusconResponseCommonItem")
public class CusconResponseCommonItem {

    protected String uketukeResult;
    protected String uketukeResultDetail;

    /**
     * Gets the value of the uketukeResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUketukeResult() {
        return uketukeResult;
    }

    /**
     * Sets the value of the uketukeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUketukeResult(String value) {
        this.uketukeResult = value;
    }

    /**
     * Gets the value of the uketukeResultDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUketukeResultDetail() {
        return uketukeResultDetail;
    }

    /**
     * Sets the value of the uketukeResultDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUketukeResultDetail(String value) {
        this.uketukeResultDetail = value;
    }

}
