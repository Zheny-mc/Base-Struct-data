package Task13;

public class MNK {
    public static LinkedList<Double> run(LinkedList<Double> X, LinkedList<Double> Y, int n) {
        Double sx2,sx,sy,sxy;
        Double a,b,d,da,db;
        int i;
        sx2=sx=sy=sxy=0.0;
        for (i=0; i<n; i++)
        {
            sx+=X.get(i);
            sy+=Y.get(i);
            sx2+=X.get(i)*X.get(i);
            sxy+=X.get(i)*Y.get(i);
        }

        //решаем систему
        //a*summ(x^2_i) + b*summ(x_i) = summ(x_i * y_i)
        //a*summ(x_i) + b*n = summ(y_i)
        //метод крамера 2*2
        d = ((double) n)*sx2 - sx*sx;
        da = ((double) n)*sxy - sx*sy;
        db = sx2*sy - sx*sxy;
        a = da / d;
        b = db / d;
        //y = ax + b
        LinkedList<Double> res = new LinkedList<>();
        res.addFirst(a);
        res.addFirst(b);
        return res;
    }
}
