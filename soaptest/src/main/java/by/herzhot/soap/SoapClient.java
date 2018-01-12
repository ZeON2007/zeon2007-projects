package by.herzhot.soap;

import by.herzhot.soap.pojos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.BindingProvider;

@Component(value = "service")
public class SoapClient extends WebServiceGatewaySupport {

    @Autowired
    public SoapClient(Jaxb2Marshaller marshaller) {
        this.setDefaultUri("");
        this.setMarshaller(marshaller);
        this.setUnmarshaller(marshaller);
    }

    public UqcOrderReferServiceResponse getResponse() {

        ObjectFactory factory = new ObjectFactory();
//        UqcOrderReferRequest request = new UqcOrderReferRequest();
//        CusconCommonHeader cusconCommonHeader = new CusconCommonHeader();
//        cusconCommonHeader.setChannelCode("1");
//        cusconCommonHeader.setCusconPassword("1");
//        cusconCommonHeader.setCusconUserId("1");
//        cusconCommonHeader.setFreeArea("1");
//        cusconCommonHeader.setJigyoushaCode("1");
//        cusconCommonHeader.setRequestId("1");
//        cusconCommonHeader.setServiceId("1");
//        CusconRequestCommonItem cusconRequestCommonItem = new CusconRequestCommonItem();
//        cusconRequestCommonItem.setRenewOpeId("2");
//        CusconRequestSoStatus cusconRequestSoStatus = new CusconRequestSoStatus();
//        cusconRequestSoStatus.setRequestId("3");
//        request.setCusconCommonHeader(cusconCommonHeader);
//        request.setCusconRequestCommonItem(cusconRequestCommonItem);
//        request.setCusconRequestSoStatus(cusconRequestSoStatus);

//        ObjectFactory factory = new ObjectFactory();
//        GetQuote request = new GetQuote();
//        request.setSymbol("111");

//        UqcOrderReferBeanService service = new UqcOrderReferBeanService();
//        UqcOrderReferBean uqcOrderReferBean = service.getUqcOrderReferBeanPort();
//        BindingProvider provider = (BindingProvider) uqcOrderReferBean;
//        provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://WSMMIN-0072:8088/mockUqcOrderReferBeanBinding");
//        UqcOrderReferRequest uqcOrderReferRequest = new UqcOrderReferRequest();

//        UqcOrderReferResponse uqcOrderReferResponse = uqcOrderReferBean.uqcOrderReferService(uqcOrderReferRequest);

        UqcOrderReferService request = factory.createUqcOrderReferService();
        UqcOrderReferRequest uqcOrderReferRequest = factory.createUqcOrderReferRequest();
        request.setUqcOrderReferRequest(uqcOrderReferRequest);

        Object object = getWebServiceTemplate().marshalSendAndReceive("http://HellMachine:8088/mockUqcOrderReferBeanBinding", request);
        System.out.println(object.getClass().getName());
        JAXBElement element = (JAXBElement) object;
        System.out.println(element.getValue());
        return (UqcOrderReferServiceResponse) element.getValue();
//
//        return (UqcOrderReferServiceResponse) object;

//        UqcOrderReferBeanService uqcOrderReferBeanService = new UqcOrderReferBeanService();
//        UqcOrderReferBean uqcOrderReferBean = uqcOrderReferBeanService.getUqcOrderReferBeanPort();

//        return (UqcOrderReferResponse) object;
    }

}
