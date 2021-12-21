package Task6;

public class Factorial {
    static Integer calc(Integer x) {
        if (x == 1){
            return 1;
        }
        return x * calc(x - 1);
    }
}
