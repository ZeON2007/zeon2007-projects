
package by.herzhot.soap.pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CusconRequestCommonItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CusconRequestCommonItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="renewOpeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CusconRequestCommonItem", propOrder = {
    "renewOpeId"
})
//@XmlRootElement(name = "CusconRequestCommonItem")
public class CusconRequestCommonItem {

    protected String renewOpeId;

    /**
     * Gets the value of the renewOpeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewOpeId() {
        return renewOpeId;
    }

    /**
     * Sets the value of the renewOpeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewOpeId(String value) {
        this.renewOpeId = value;
    }

}
