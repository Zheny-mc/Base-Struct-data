package Task10;

import java.util.Arrays;

public class Polynom {
    private Term [] plmn;

    Polynom(LinkedList<Double> factors) {
        plmn = new Term[factors.getSize()];
        for (int i = factors.getSize() - 1; i >= 0; i--) {
            plmn[factors.getSize() - i - 1] = new Term(factors.get(i), i);
        }
    }

    Polynom(Term[] plmn) {
        this.plmn = plmn;
    }

    void printPolinom() {
        System.out.println(Arrays.toString(plmn));
    }

    public Term getTerm(int indexTerm) {
        return plmn[indexTerm];
    }

    public void setTerm(Term term, int indexTerm) {
        plmn[indexTerm] = term;
    }

    public int getLengthPlmn() {
        return plmn.length;
    }
}