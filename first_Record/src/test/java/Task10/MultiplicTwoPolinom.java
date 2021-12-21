package Task10;


public class MultiplicTwoPolinom {
    public static void main(String[] args) {

        LinkedList<Double> listF = new LinkedList<>();
        listF.addFirst(3.d);
        listF.addFirst(-2.d);
        listF.addFirst(1.d);

        LinkedList<Double> listS = new LinkedList<>();
        listS.addFirst(2.d);
        listS.addFirst(1.d);

        Polynom p2 = new Polynom(listF);
        Polynom p1 = new Polynom(listS);
        Polynom p1Xp2 = new Polynom(new Term[p1.getLengthPlmn() * p2.getLengthPlmn()]);
        p1.printPolinom();
        p2.printPolinom();
        int indTmp = 0;
        Term trmTemp;
        for (int i = 0; i < p1.getLengthPlmn(); i++) {
            for (int j = 0; j < p2.getLengthPlmn(); j++) {
                trmTemp = p1.getTerm(i).multiplyOtherTerm(p2.getTerm(j));
                p1Xp2.setTerm(trmTemp, indTmp);
                indTmp++;
            }
        }
        System.out.println("_________________________");
        p1Xp2.printPolinom();
        

    }
}