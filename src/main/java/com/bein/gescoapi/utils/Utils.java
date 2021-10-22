package com.bein.gescoapi.utils;

import org.springframework.stereotype.Service;

@Service
public class Utils {

    public String appreciate(Double valeur) {

        if (valeur == null) {
            return "";
        }

        if (valeur >= 0D && valeur < 10) {
            return "NA";
        }

        if (valeur >= 10 && valeur < 14) {
            return "ECA";
        }

        if (valeur >= 14 && valeur < 18) {
            return "A";
        }

        if (valeur >= 18 && valeur <= 20) {
            return "A+|Exp";
        }

        return "";
    }

    public String appreciateModeClassique(Double valeur) {

        if (valeur == null) {
            return "";
        }

        if (valeur >= 0D && valeur <= 3D) {
            return "Null";
        }

        if (valeur >= 3 && valeur < 7) {
            return "Faible";
        }

        if (valeur >= 7 && valeur < 9) {
            return "Insuffisant";
        }

        if (valeur >= 9 && valeur < 10) {
            return "Médiocre";
        }

        if (valeur >= 10 && valeur < 12) {
            return "Passable";
        }

        if (valeur >= 12 && valeur < 14) {
            return "Assez bien";
        }

        if (valeur >= 14 && valeur < 17) {
            return "Bien";
        }

        if (valeur >= 17 && valeur < 19) {
            return "Très Bien";
        }

        if (valeur >= 19 && valeur <= 20) {
            return "Excellent";
        }
        return "";
    }
}
