public class FunctionGyperbola {
    static double F1 (double X, double r0, double rk, double S, double F, double tp) {
        double a1 = 2*Math.pow(Math.sinh(Math.sqrt((r0+rk+S)/(4*Math.abs(X)))),-1);
        double a2 = 2*Math.pow(Math.sinh(Math.sqrt((r0+rk-S)/(4*Math.abs(X)))),-1);

        return tp - (Math.sqrt(Math.pow(Math.abs(X), 3)/Constant.GRAV_PARAMETER_SUN))*(Math.sinh(a1)-a1-Math.signum(Math.sin(F))*(Math.sinh(a2)-a2));


    }


    public static double MSecant(double r0, double rk, double S, double F, double tp, double a_orb_approx) {
        double A = a_orb_approx;
        double ALast = a_orb_approx*2;
        double AGrandLast;
        //   System.out.println("X = " + A);
        double dA = 1.7E307;
        while (Math.abs(dA) > 1E-13) {
            AGrandLast = ALast;
            ALast = A;
            A = A - F1(ALast, r0, rk, S, F, tp) * (ALast - AGrandLast) / (F1(ALast, r0, rk, S, F, tp) - F1(AGrandLast, r0, rk, S, F, tp));
            dA = A - ALast;
        }
        //   System.out.println("X =  " + A);
        //   System.out.println("F(X) = " + F1(A, r0, rk, S, F, tp));
        return A;
    }


    public static double OrbitP (double a, double r0, double rk, double S, double F) {
        double a1 = 2*Math.pow(Math.sinh(Math.sqrt((r0+rk+S)/(4*Math.abs(a)))),-1);
        double a2 = 2*Math.pow(Math.sinh(Math.sqrt((r0+rk-S)/(4*Math.abs(a)))),-1);

        return (Math.abs(a) / Math.pow(S, 2) )* 4 * r0 * rk * Math.pow(Math.sin(F / 2), 2) * Math.sinh(a1 + Math.signum(Math.sin(F)) * a2 / 2);
    }

    public static double OrbitE (double a, double r0, double rk, double S, double F) {
        double a1 = 2*Math.pow(Math.sinh(Math.sqrt((r0+rk+S)/(4*Math.abs(a)))),-1);
        double a2 = 2*Math.pow(Math.sinh(Math.sqrt((r0+rk-S)/(4*Math.abs(a)))),-1);
        double p = (Math.abs(a) / Math.pow(S, 2) )* 4 * r0 * rk * Math.pow(Math.sin(F / 2), 2) * Math.sinh(a1 + Math.signum(Math.sin(F)) * a2 / 2);

        return Math.sqrt(1 - (p / Math.abs(a)));

    }



}
