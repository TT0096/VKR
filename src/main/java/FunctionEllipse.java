public class FunctionEllipse {
    static double F2 (double X, double r0, double rk, double S, double F, double tp) {
        double deltaM = 2 * Math.asin(Math.sqrt((r0 + rk - S) / ((r0 + rk + S))));
        double tm = (Math.pow(r0 + rk + S, 1.5) / (8 * Math.sqrt(Constant.GRAV_PARAMETER_SUN))) * (Math.PI - Math.signum(Math.sin(F)) * (deltaM - Math.sin(deltaM)));
        double delta = 2 * Math.asin(Math.sqrt((r0 + rk - S) / (4 * X)));
        double epsilon = 2 * Math.asin(Math.sqrt((r0 + rk + S) / (4 * X)));

        return tp - ((Math.pow(X, 1.5) / Math.sqrt(Constant.GRAV_PARAMETER_SUN)) * (Math.PI + Math.signum(tm - tp) * (epsilon - Math.sin(epsilon) - Math.PI) - Math.signum(Math.sin(F)) * (delta - Math.sin(delta))));

        //    return (Math.pow(Math.abs(X), 1.5) / Math.sqrt(Constant.GRAV_PARAMETER_SUN)) * (Math.PI + Math.signum(tm - tp) * (epsilon - Math.sin(epsilon) - Math.PI) - Math.signum(Math.sin(F)) * (delta - Math.sin(delta)));

    }



    public static double MSecant(double r0, double rk, double S, double F, double tp, double a_orb_approx) {
//        System.out.println("tp = " + tp);
        double A1 =  4.5*10E7;
//        System.out.println("A0: " + A);
        double ALast = 4.9*10E7;
        double AGrandLast;
        //    System.out.println("X = " + A);
        double dA = 1.7E30;
        while (Math.abs(dA) > 1E-13) {
            AGrandLast = ALast;
            ALast = A1;
            A1 = A1 - (F2(A1, r0, rk, S, F, tp)/10E8)*(ALast - AGrandLast)/(F2(ALast, r0, rk, S, F, tp)/10E8 - F2(AGrandLast, r0, rk, S, F, tp)/10E8);
            dA = A1 - ALast;

        }
        //    System.out.println("X =  " + A);
        //    System.out.println("F(X) = " + F2(A, r0, rk, S, F, tp));
        System.out.println("Большая полуось орбиты равна: "+ A1);
        return A1;
//        double x_next = 0;
//        double tmp;
//        double x_curr = 46*10E8;
//        double x_prev = 52*10E8;
//        do{
//            tmp = x_next;
//            x_next = x_curr - F2(x_curr, r0, rk, S, F, tp) * (x_prev - x_curr) / (F2(x_prev, r0, rk, S, F, tp) - F2(x_curr, r0, rk, S, F, tp));
//            x_prev = x_curr;
//            x_curr = tmp;
//        } while (Math.abs(x_next - x_curr) > 1e-13);
//        return x_next;
    }



    public static double OrbitP (double a, double r0, double rk, double S, double F, double tp) {
        double deltaM = 2 * Math.asin(Math.sqrt((r0 + rk - S) / ((r0 + rk + S))));
        double tm = Math.pow(r0 + rk + S, 1.5) / (8 * Math.sqrt(Constant.GRAV_PARAMETER_SUN)) * (Math.PI - Math.sin(F) * (deltaM - Math.sin(deltaM)));
        double delta = 2 * Math.asin(Math.sqrt((r0 + rk - S) / (4 * Math.abs(a))));
        double epsilon = 2 * Math.asin(Math.sqrt((r0 + rk + S) / (4 * Math.abs(a))));
        double a1 = 2*Math.pow(Math.sinh(Math.sqrt((r0+rk+S)/(4*Math.abs(a)))),-1);
        double a2 = 2*Math.pow(Math.sinh(Math.sqrt((r0+rk-S)/(4*Math.abs(a)))),-1);

        return (a/Math.pow(S, 2))*4*r0*rk*Math.pow(Math.sin(F/2), 2)*Math.pow(Math.sin(a1+Math.signum(Math.sin(F))*Math.signum(tm-tp)*a2/2), 2);



    }

    public static double OrbitE (double a, double r0, double rk, double S, double F, double tp) {
        double deltaM = 2 * Math.asin(Math.sqrt((r0 + rk - S) / ((r0 + rk + S))));
        double tm = Math.pow(r0 + rk + S, 1.5) / (8 * Math.sqrt(Constant.GRAV_PARAMETER_SUN)) * (Math.PI - Math.sin(F) * (deltaM - Math.sin(deltaM)));
        double delta = 2 * Math.asin(Math.sqrt((r0 + rk - S) / (4 * Math.abs(a))));
        double epsilon = 2 * Math.asin(Math.sqrt((r0 + rk + S) / (4 * Math.abs(a))));
        double a1 = 2*Math.pow(Math.sinh(Math.sqrt((r0+rk+S)/(4*Math.abs(a)))),-1);
        double a2 = 2*Math.pow(Math.sinh(Math.sqrt((r0+rk-S)/(4*Math.abs(a)))),-1);

        double p = (a/Math.pow(S, 2))*4*r0*rk*Math.pow(Math.sin(F/2), 2)*Math.pow(Math.sin(a1+Math.signum(Math.sin(F))*Math.signum(tm-tp)*a2/2), 2);
        return Math.sqrt(1-(p/a));



    }
}
