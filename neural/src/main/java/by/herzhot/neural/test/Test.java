package by.herzhot.neural.test;

import com.google.common.net.InetAddresses;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws UnknownHostException {
        String address = "00 00 00 00 00 00 00 00 00 00 ff ff c0 a8 00 01";
        String[] tokens = address.split(" ");
        System.out.println(Arrays.toString(tokens));
        byte[] bytes = new byte[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            bytes[i] = (byte) Integer.parseUnsignedInt(tokens[i], 16);
        }
        System.out.println(Arrays.toString(bytes));
        InetAddress inetAddress = InetAddress.getByAddress(bytes);
        System.out.println(InetAddresses.toAddrString(inetAddress));
    }
}
