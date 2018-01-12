package by.herzhot.soap;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.*;
import org.powermock.core.spi.PowerMockPolicy;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@Ignore
public class SoapClientTest {

    @Test
    public void getResponse() throws Exception {

        SoapClient client = (SoapClient) ContextHolder.getContext().getBean("service");

        System.out.println(client.getResponse().getUqcOrderReferResponse().getCusconCommonHeader());

    }

}