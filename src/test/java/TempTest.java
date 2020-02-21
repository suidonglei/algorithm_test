
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TempTest {
    @Test
    public void should_main() {
        VolatileTest volatileTest = new VolatileTest();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                volatileTest.read();
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                volatileTest.write();
            }
        };
        thread2.start();
        thread1.start();
        System.out.println(volatileTest.flag);
    }

    class VolatileTest {
        int a = 0;
        volatile boolean flag = true;
        public void write(){
            a = 1;
            flag = true;
        }
        public void read() {
            int i = 0;
            if(flag) {
                i = a;
            }
            System.out.println(i);
        }
    }
    private static String valid(String xml) {
        String[] strArr = xml.split("<");
        String result = "valid";
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < strArr.length; i ++) {
            if(i == 0) {
                if(strArr[i].contains(">")) {
                    result = "parse error";
                    break;
                }
            } else {
                if(strArr[i].startsWith("/")) {//pop
                    if(!strArr[i].contains(">") || strArr[i].indexOf(">") == 1 || strArr[i].split(">").length > 2) {
                        result = "parse error";
                        break;
                    }
                    String endTagName = strArr[i].substring(1, strArr[i].indexOf(">"));
                    if(endTagName.contains("/")) {
                        result = "parse error";
                        break;
                    }
                    if(stack.empty()) {
                        result = "encountered closing tag without matching open tag for </" + endTagName +">";
                        break;
                    }
                    String popTagName = stack.pop();
                    if(!endTagName.equals(popTagName)) {
                        result = "encountered closing tag without matching open tag for </" + endTagName +">";
                        break;
                    }

                } else if (strArr[i].contains(">")) {//push
                    if(strArr[i].startsWith(">") || strArr[i].split(">").length > 2) {
                        result = "parse error";
                        break;
                    }
                    String startTagName = strArr[i].substring(0, strArr[i].indexOf(">"));
                    if(startTagName.contains("/")) {
                        result = "parse error";
                        break;
                    }
                    stack.push(startTagName);
                }
            }

        }
        if(!stack.empty()) {
            String startTag = stack.pop();
            result = "missing closing tag for </" + startTag + ">";
        }
        return result;
    }
    @Test
    public void should_sum() {
        System.out.println(valid("124df"));
    }
    @Test
    public void should_test() {
        //given
        int x = 9;
        System.out.println(x & ( x - 1));
        System.out.println(x & 1);
        //when

        //then
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);

        int count = (int) integers.stream().filter(i -> i > 0).count();
        int[] initArrat = new int[10];

        int n = 10;
        Map<Integer, Set<Integer>> relation = new HashMap<>();
        int[] initArray = new int[n];
        int[] targerArray = new int[n];

        LinkedList<Integer> diffList = new LinkedList<>();

        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);

        while (!integerStack.isEmpty()) {
            Integer location = integerStack.pop();
            if(initArray[location] != targerArray[location]) {
                diffList.add(location);
            }
            Set<Integer> tempSet = relation.get(location);
            tempSet.forEach( loca -> {
                integerStack.push(loca);
            });
        }

        int changeTime = 0;
        List<Integer> changeLoc = new ArrayList<>();

        while(diffList.size() > 0) {
            Integer toChange = diffList.getFirst();
            Set<Integer> sons = relation.get(toChange);
            int changeFlag = 0;

            while(!sons.isEmpty()) {
                if(changeFlag%2 == 1) {
                    //dochange

                } else {

                }
                changeFlag ++;
            }
        }






    }

    @Test
    public void test () {
        int input = 3;
        int hight = (int) Math.pow(2,input);
        int width  = 2 * hight;
        String[][] graph = new String[hight+1][width+1];

        for(int i = 1; i <= hight; i ++) {
            for(int j = 1; j <= width; j ++) {
                if(j < (width>>1 - i)) {
                    graph[i][j] = " ";
                    continue;
                }
                if(j == (width>>1 - i)) {
                    graph[i][j] = "/";
                    continue;
                }
            }
        }
    }

    @Test
    public void test1() {
        
    }
}
