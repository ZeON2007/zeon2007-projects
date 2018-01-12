
package by.herzhot.soap.pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CusconCommonHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CusconCommonHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="jigyoushaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="channelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="cusconUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="cusconPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="freeArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CusconCommonHeader", propOrder = {
    "serviceId",
    "jigyoushaCode",
    "channelCode",
    "cusconUserId",
    "cusconPassword",
    "requestId",
    "freeArea"
})
//@XmlRootElement(name = "CusconCommonHeader")
public class CusconCommonHeader {

    protected String serviceId;
    protected String jigyoushaCode;
    protected String channelCode;
    protected String cusconUserId;
    protected String cusconPassword;
    protected String requestId;
    protected String freeArea;

    /**
     * Gets the value of the serviceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * Sets the value of the serviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceId(String value) {
        this.serviceId = value;
    }

    /**
     * Gets the value of the jigyoushaCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJigyoushaCode() {
        return jigyoushaCode;
    }

    /**
     * Sets the value of the jigyoushaCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJigyoushaCode(String value) {
        this.jigyoushaCode = value;
    }

    /**
     * Gets the value of the channelCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * Sets the value of the channelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelCode(String value) {
        this.channelCode = value;
    }

    /**
     * Gets the value of the cusconUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCusconUserId() {
        return cusconUserId;
    }

    /**
     * Sets the value of the cusconUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCusconUserId(String value) {
        this.cusconUserId = value;
    }

    /**
     * Gets the value of the cusconPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCusconPassword() {
        return cusconPassword;
    }

    /**
     * Sets the value of the cusconPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCusconPassword(String value) {
        this.cusconPassword = value;
    }

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the freeArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeArea() {
        return freeArea;
    }

    /**
     * Sets the value of the freeArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeArea(String value) {
        this.freeArea = value;
    }

    @Override
    public String toString() {
        return "CusconCommonHeader{" +
                "serviceId='" + serviceId + '\'' +
                ", jigyoushaCode='" + jigyoushaCode + '\'' +
                ", channelCode='" + channelCode + '\'' +
                ", cusconUserId='" + cusconUserId + '\'' +
                ", cusconPassword='" + cusconPassword + '\'' +
                ", requestId='" + requestId + '\'' +
                ", freeArea='" + freeArea + '\'' +
                '}';
    }
}
