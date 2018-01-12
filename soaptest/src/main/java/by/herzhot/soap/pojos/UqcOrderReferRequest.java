
package by.herzhot.soap.pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UqcOrderReferRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UqcOrderReferRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cusconCommonHeader" type="{http://com.hitachi.sawara/}CusconCommonHeader" minOccurs="0" form="qualified"/>
 *         &lt;element name="cusconRequestCommonItem" type="{http://com.hitachi.sawara/}CusconRequestCommonItem" minOccurs="0" form="qualified"/>
 *         &lt;element name="cusconRequestSoStatus" type="{http://com.hitachi.sawara/}CusconRequestSoStatus" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UqcOrderReferRequest", propOrder = {
    "cusconCommonHeader",
    "cusconRequestCommonItem",
    "cusconRequestSoStatus"
})
@XmlRootElement(name = "UqcOrderReferRequest")
public class UqcOrderReferRequest {

    protected CusconCommonHeader cusconCommonHeader;
    protected CusconRequestCommonItem cusconRequestCommonItem;
    protected CusconRequestSoStatus cusconRequestSoStatus;

    /**
     * Gets the value of the cusconCommonHeader property.
     * 
     * @return
     *     possible object is
     *     {@link CusconCommonHeader }
     *     
     */
    public CusconCommonHeader getCusconCommonHeader() {
        return cusconCommonHeader;
    }

    /**
     * Sets the value of the cusconCommonHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link CusconCommonHeader }
     *     
     */
    public void setCusconCommonHeader(CusconCommonHeader value) {
        this.cusconCommonHeader = value;
    }

    /**
     * Gets the value of the cusconRequestCommonItem property.
     * 
     * @return
     *     possible object is
     *     {@link CusconRequestCommonItem }
     *     
     */
    public CusconRequestCommonItem getCusconRequestCommonItem() {
        return cusconRequestCommonItem;
    }

    /**
     * Sets the value of the cusconRequestCommonItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link CusconRequestCommonItem }
     *     
     */
    public void setCusconRequestCommonItem(CusconRequestCommonItem value) {
        this.cusconRequestCommonItem = value;
    }

    /**
     * Gets the value of the cusconRequestSoStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CusconRequestSoStatus }
     *     
     */
    public CusconRequestSoStatus getCusconRequestSoStatus() {
        return cusconRequestSoStatus;
    }

    /**
     * Sets the value of the cusconRequestSoStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CusconRequestSoStatus }
     *     
     */
    public void setCusconRequestSoStatus(CusconRequestSoStatus value) {
        this.cusconRequestSoStatus = value;
    }

}
