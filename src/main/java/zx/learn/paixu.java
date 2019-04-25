package zx.learn;

public class paixu {
    public static void main(String[] args) {
        int[] ints={0,1,2,3,4,5,6,7,8,9,11};
        int count = 0;
        for(int i = 0;i<ints.length;i++){
            int min = ints[i];
            for(int j = i+1;j<ints.length;j++)
                if (ints[j] < min) {
                    ints[i] = ints[j];
                    ints[j] = min;
                    min = ints[i];
                    count ++;
                }
        }
        for(int k = 0;k<ints.length;k++)System.out.print(ints[k]+" ");
        System.out.println();
        System.out.println(count);
    }
}
