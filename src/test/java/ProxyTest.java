import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProxyTest {
    @Test
    public void should_proxy() {
        //given
//        Proxy.newProxyInstance()
        //when

        //then

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        for (String item : list) {
            if ("5".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list.size());



        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equals(item)) {
                iterator.remove();
            }
        }
    }
}
