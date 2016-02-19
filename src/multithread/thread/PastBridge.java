/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 19, 2016 11:57:37 AM 
 * @version 1.0 
 *
 */
package multithread.thread;

public class PastBridge {

    public static void main(String[] args) {
        // 假设数组从小到大排序
        int[] example1 = { 1, 2, 5, 10 };
        String[] strExample1 = { "A", "B", "C", "D" };
        int[] example2 = { 1, 10, 11, 12};
        String[] strExample2 = { "A", "B", "C", "D"};
        int[] example3 = { 1};
        String[] strExample3 = { "A"};
        int[] example4 = { 1,3};
        String[] strExample4 = { "A","B"};
        int[] example5 = { 1,3,6};
        String[] strExample5 = { "A","B","C"};

        GoBridge(example1, strExample1);
        GoBridge(example2, strExample2);
        GoBridge(example3, strExample3);
        GoBridge(example4, strExample4);
        GoBridge(example5, strExample5);
    }

    /**
     * 计算所有人过桥的总用时
     *
     * @param personTimes
     *            过桥人各自所用时间组成的数组
     * @param personNames
     *            过桥人名称组成的数组
     */
    private static void GoBridge(int[] personTimes, String[] personNames) {

        int personsNum = personTimes.length;
        if(personsNum==1){
            System.out.println("总共用时＝" + personTimes[0]);
            return;
        }
        if(personsNum==2){
            System.out.println("总共用时＝" + personTimes[1]);
            return;
        }


        int quickest = personTimes[0];// 用时最少的人
        int quicker = personTimes[1]; // 用时第二少的人
        int totalTimes = 0;// 总共用时

        // 将执行逻辑按是否为偶数分成两种情况
        boolean isEvenNum = personsNum % 2 == 0;
        if (isEvenNum) {// 为偶数

            for (int i = personTimes.length - 1; i >= 2;) {


                totalTimes +=goBridgerControl(i, personNames,personTimes);
                i = i - 2;
            }
            totalTimes += quicker;
            System.out.println(personNames[0] + "," + personNames[1] + "过去 用时:"+personTimes[1]);
        } else {// 为奇数

            for (int i = personTimes.length - 1; i > 3;) {


                totalTimes +=goBridgerControl(i, personNames,personTimes);
                i = i - 2;
            }
            totalTimes += personTimes[2];
            totalTimes += quicker + quickest;
            System.out.println(personNames[0] + "," + personNames[2] + "过去 用时:"+personTimes[2]);
            System.out.println(personNames[0] + "回来 用时:"+personTimes[0]);
            System.out.println(personNames[0] + "," + personNames[1] + "过去 用时:"+personTimes[1]);
        }
        System.out.println("总共用时＝" + totalTimes);
    }
    /**
     * 执行路径的控制选择
     * @param i
     * @param personNames
     * @param personTimes
     * @return
     */
    private static int goBridgerControl(int i, String[] personNames,int[] personTimes) {

        if(personTimes[1]*2<personTimes[0]+personTimes[i-1]){
            return goBridgerWith2(i, personNames,personTimes);
        }else{
            return goBridgerWith1(i, personNames,personTimes);
        }


    }
    /**
     * 最快和次最快的人陪同过桥
     * @param i
     * @param personNames
     * @param personTimes
     * @return
     */
    private static int goBridgerWith2(int i, String[] personNames,int[] personTimes) {


        System.out.println(personNames[0] + "," + personNames[1] + "过去 用时:"+personTimes[1]);
        System.out.println(personNames[0] + "回来 用时:"+personTimes[0]);
        System.out.println(personNames[i] + "," + personNames[i - 1] + "过去 用时:"+personTimes[i]);;
        System.out.println(personNames[1] + "回来 用时:"+personTimes[1]);
        int roundedTimes = personTimes[1] * 2 + personTimes[0];// 用时最少的两位往返的时间和
        int atotalTimes=0;
        atotalTimes+= personTimes[i];
        atotalTimes+= roundedTimes;
        return atotalTimes;

    }
    /**
     * 最快的人陪同过桥
     * @param i
     * @param personNames
     * @param personTimes
     * @return
     */
    private static int goBridgerWith1(int i, String[] personNames,int[] personTimes) {


        System.out.println(personNames[0] + "," + personNames[i] + "过去 用时:"+personTimes[i]);
        System.out.println(personNames[0] + "回来 用时:"+personTimes[0]);
        System.out.println(personNames[0] + "," + personNames[i - 1] + "过去 用时:"+personTimes[i-1]);;
        System.out.println(personNames[0] + "回来 用时:"+personTimes[0]);

        int atotalTimes=0;
        atotalTimes+= personTimes[i];
        atotalTimes+= personTimes[i-1];
        atotalTimes+= personTimes[0]*2;

        return atotalTimes;

    }
}
