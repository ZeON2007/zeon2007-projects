package by.herzhot.soap;

public class Main {

    public static void main(String[] args) {

        SoapClient client = (SoapClient) ContextHolder.getContext().getBean("service");

        System.out.println(client.getResponse().getUqcOrderReferResponse().getCusconCommonHeader());

    }
}
