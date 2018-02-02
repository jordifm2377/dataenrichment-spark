package com.thomsonreuters.ls.platform.services.analytics.si.utils;


public class PValueCalculator {

    public double calculatePValue(int r, int N, int n, int R) {
        if (r < 0 || n < r || R < r || N < n || N < R || n - r > N - R) {
            return 0;
        }

        int min_n_rr = Math.min(n, R);
        int max_n_rr = Math.max(n, R);

        int aa = N - n - R;
        int bb = max_n_rr - min_n_rr;

        double mm1 = min_n_rr - r;
        double mm;
        double a;
        if (aa > 0) {
            mm = min_n_rr;
            a = max_n_rr;
        } else {
            mm = N - max_n_rr;
            a = N - min_n_rr;
        }

        double a1 = min_n_rr;
        double b1 = 1;

        boolean iflag = true;
        int tmp;
        if (r * (N + 2) <= (R + 1) * (n + 1)) {
            iflag = false;

            tmp = aa;
            aa = bb;
            bb = tmp;

            a = N - a;
            mm1 = mm - mm1;

            if (bb < 0) {
                a1 = mm;
                b1 -= bb;
            }
        }

        double eps = Double.MIN_VALUE * 32768;

        int icnt = 0;

        double b = N;
        double p = 1;

        for (int i = 0; i < mm; i++) {

            double u = a / b;

            if (u < eps / p) {
                p /= eps;
                icnt++;
            }

            p *= u;
            a--;
            b--;
        }

        double q = 0;

        for (int i = 0; i < mm1; i++) {

            if (icnt == 0) {
                q += p;
            }

            p *= (a1 * (a1 + aa) / (b1 * (b1 + bb)));

            if (p >= 1) {
                p *= eps;
                icnt--;
            }

            a1--;
            b1++;

        }

        if (iflag) {
            return q + (icnt != 0 ? 0 : p);
        } else {
            return 1 - q;
        }
    }
}
