public class Matrix {




    public static double[][] MultiMatrix (double [][] m1, double [][] m2, int m1length, int m2length) {
        double [][] m12 = new double[m1length][m2length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                for (int k = 0; k < m1[i].length; k++) {
                    m12[i][j] += m1[i][k]*m2[k][j];
                }
            }
        }
        return m12;

    }

    public static double[][] BackMatrix (double [][] m1) {
        double [][] E = new double[3][3];
        for (int i=0;i<m1.length;i++){
            for (int j=0;j < m1[i].length;j++){
                if (i==j) {
                    E[i][j] = 1;
                }
                else {
                    E[i][j] = 0;
                }
            }
        }
//Задаём номер ведущей строки (сначала 0,1...size)
        for (int k=0;k<3;k++){
            for (int j=k+1; j<3; j++){
                m1[k][j]=m1[k][j]/m1[k][k];//все элементы k-ой строки матрицы A, кроме k-ого и до него, делим на разрешающий элемент - a[k][k]
            }
            for (int j=0;j<m1.length;j++){
                E[k][j]=E[k][j]/m1[k][k];//все элементы k-ой строки матрицы e, делим на разрешающий элемент - a[k][k]
            }
            m1[k][k]=m1[k][k]/m1[k][k];//элемент соответствующий  разрещающему - делим на самого себя(т.е получит. 1 )
//идём сверху вниз, обходя k-ую строку
            if (k>0) {//если номер ведущей строки не первый
                for (int i=0;i<k;i++){   //строки, находящиеся выше k-ой
                    for (int j=0;j< m1.length;j++){
                        E[i][j]=E[i][j]-E[k][j]*m1[i][k];//Вычисляем элементы матрицы e,идя по столбцам с 0 -ого  к последнему
                    }
                    for (int j= m1.length-1;j>=k;j--){
                        m1[i][j]=m1[i][j]-m1[k][j]*m1[i][k];//Вычисляем элементы матрицы a,идя по столбцам с последнего к k-ому
                    }
                }
            }
            for (int i=k+1;i< m1.length;i++){   //строки, находящиеся ниже k-ой
                for (int j=0;j< m1.length;j++){
                    E[i][j]=E[i][j]-E[k][j]*m1[i][k];
                }
                for (int j= m1.length-1;j>=k;j--){
                    m1[i][j]=m1[i][j]-m1[k][j]*m1[i][k];
                }
            }
        }
        return E;//На месте исходной матрицы должна получиться единичная а на месте единичной - обратная.


    }


    public static void Viewing(double[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j] + " ");
            }
            System.out.println();
        }
    }

}





