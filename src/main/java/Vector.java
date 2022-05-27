
import static java.lang.Math .*;

public class Vector {

    double x;
    double y;
    double z;


    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector() {
    }

    public void addXYZ(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static double FindAngle(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.acos(Math.abs(MultiVector(x1, y1, z1, x2, y2, z2) / (ModuleVector(x1, y1, z1)*ModuleVector(x2, y2, z2))));
    }

    public static double MultiVector(double x1, double y1, double z1, double x2, double y2, double z2) {
        return x1 * x2 + y1 * y2 + z1 * z2;
    }

    public static double ModuleVector(double x1, double y1, double z1) {
        return Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2) + Math.pow(z1, 2));
    }

    public static double TheThirdSideOfTriangle(double x1, double y1, double z1, double x2, double y2, double z2) {
        double F1 = FindAngle(x1, y1, z1, x2, y2, z2);
        double r1 = ModuleVector(x1, y1, z1);
        double r2 = ModuleVector(x2, y2, z2);
        return Math.sqrt(Math.pow(r1, 2) + Math.pow(r2, 2) - 2 * r1 * r2 * Math.cos(F1));
    }


}

