
package by.herzhot.soap.pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UqcOrderReferResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UqcOrderReferResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cusconCommonHeader" type="{http://com.hitachi.sawara/}CusconCommonHeader" minOccurs="0" form="qualified"/>
 *         &lt;element name="cusconResponseCommonItem" type="{http://com.hitachi.sawara/}CusconResponseCommonItem" minOccurs="0" form="qualified"/>
 *         &lt;element name="cusconResponseSoStatus" type="{http://com.hitachi.sawara/}CusconResponseSoStatus" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UqcOrderReferResponse", propOrder = {
    "cusconCommonHeader",
    "cusconResponseCommonItem",
    "cusconResponseSoStatus"
})
//@XmlRootElement(name = "UqcOrderReferResponse")
public class UqcOrderReferResponse {

    protected CusconCommonHeader cusconCommonHeader;
    protected CusconResponseCommonItem cusconResponseCommonItem;
    protected CusconResponseSoStatus cusconResponseSoStatus;

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
     * Gets the value of the cusconResponseCommonItem property.
     * 
     * @return
     *     possible object is
     *     {@link CusconResponseCommonItem }
     *     
     */
    public CusconResponseCommonItem getCusconResponseCommonItem() {
        return cusconResponseCommonItem;
    }

    /**
     * Sets the value of the cusconResponseCommonItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link CusconResponseCommonItem }
     *     
     */
    public void setCusconResponseCommonItem(CusconResponseCommonItem value) {
        this.cusconResponseCommonItem = value;
    }

    /**
     * Gets the value of the cusconResponseSoStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CusconResponseSoStatus }
     *     
     */
    public CusconResponseSoStatus getCusconResponseSoStatus() {
        return cusconResponseSoStatus;
    }

    /**
     * Sets the value of the cusconResponseSoStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CusconResponseSoStatus }
     *     
     */
    public void setCusconResponseSoStatus(CusconResponseSoStatus value) {
        this.cusconResponseSoStatus = value;
    }

}
