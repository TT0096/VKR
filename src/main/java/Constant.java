public class Constant {
    public static final float GRAV_PARAMETER_EARTH = 398600.4415F; // км и с
    public static final int GRAV_PARAMETER_JUPITER = 126686534; // км и с
    public static final double GRAV_PARAMETER_SUN = 1.327E11; // км и с

    public static final double e_z = 0.01671123; // км
    public static final double a_z = 149.598261E6; // км
    public static final double i_z = 0;
    public static final double Omega_z = 0;   //348.73936*Math.PI/180;
    public static final double wz = 0;   //114.20783*Math.PI/180;

    public static final double e_u = 0.048; // км
    public static final double a_u = 5.203*149.598261E6; // км
    public static final double i_u = 3.13*Math.PI/180; // рад
    public static final double Omega_u = 113.642*Math.PI/180; // рад
    public static final double wu = 336.013*Math.PI/180; // рад
    public static final double p_u = a_u*(1 - Math.pow(e_u, 2));
    public static final double p_z = a_z*(1 - Math.pow(e_z, 2));




}
