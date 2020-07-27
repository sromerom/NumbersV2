import java.util.Arrays;

public class Numbers {
    static String[] uniqueNumbers = {
            "Zero",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen"
    };

    static String[] desenes = {
            "Zero",
            "Ten",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };

    public static String say(long n) {

        String resultat = "";
        String number = Integer.toString((int) n);

        if (n <= 19) {
            resultat = getUnitats(n);
        } else if (number.length() == 2) {
            resultat = getDesenes(n);
        } else if (number.length() == 3) {
            resultat = getCentenes(n);
        } else if (number.length() < 999999) {
            resultat = getMilers(n);
        }
        return resultat;
    }


    public static long words(String s) {
        return 0;
    }

    private static String getUnitats(long n) {
        String resultat = uniqueNumbers[(int) n];
        return resultat;
    }

    private static String getDesenes(long n) {
        String resultat = "";
        if (n <= 19) {
            return getUnitats(n);
        }

        int[] splitedNumbers = splitNumbers(n);

        resultat = desenes[splitedNumbers[0]];
        if (splitedNumbers[1] != 0) {
            resultat += "-";
            resultat += uniqueNumbers[splitedNumbers[1]].toLowerCase();
        }

        return resultat;
    }

    private static String getCentenes(long n) {
        String resultat = "";
        int[] splitedNumbers = splitNumbers(n);
        System.out.println(Arrays.toString(splitedNumbers));

        resultat = uniqueNumbers[splitedNumbers[0]] + " hundred";
        int desenaNumber = Integer.parseInt(Integer.toString(splitedNumbers[1]) + Integer.toString(splitedNumbers[2]));

        System.out.println(desenaNumber);
        if (splitedNumbers[1] != 0 || splitedNumbers[2] != 0 && desenaNumber != 0) {

            resultat += " and ";

            if (desenaNumber <= 19) {
                resultat += uniqueNumbers[desenaNumber].toLowerCase();
            } else {
                resultat += getDesenes(desenaNumber).toLowerCase();
            }
        }

        return resultat;
    }

    private static String getMilers(long n) {
        String resultat = "";
        int[] splitedNumbers = splitNumbers(n);
        System.out.println(Arrays.toString(splitedNumbers));

        if (splitedNumbers.length == 4) {
            resultat = uniqueNumbers[splitedNumbers[0]] + " thousand";
        } else if (splitedNumbers.length == 5) {
            resultat = getDesenes(Integer.parseInt(Integer.toString(splitedNumbers[0]) + Integer.toString(splitedNumbers[1]))) + " thousand";
        } else if (splitedNumbers.length == 6) {
            resultat = getCentenes(Integer.parseInt(Integer.toString(splitedNumbers[0]) + Integer.toString(splitedNumbers[1]) + Integer.toString(splitedNumbers[2]))) + " thousand";
        }

        String stringCentenaNumber = "";
        for (int i = splitedNumbers.length - 3; i < splitedNumbers.length; i++) {

            stringCentenaNumber += Integer.parseInt(Integer.toString(splitedNumbers[i]));
        }

        int centenaNumber = Integer.parseInt(stringCentenaNumber);
        //int centenaNumber = Integer.parseInt(Integer.toString(splitedNumbers[1]) + Integer.toString(splitedNumbers[2]) + Integer.parseInt(Integer.toString(splitedNumbers[3])));
        System.out.println(centenaNumber);

        if (centenaNumber != 0) {

            if (centenaNumber <= 99) {
                resultat += getDesenes(centenaNumber).toLowerCase();
            } else {
                resultat += " " + getCentenes(centenaNumber).toLowerCase();
            }
        }

        return resultat;
    }


    private static int[] splitNumbers(long n) {
        String number = Integer.toString((int) n);
        int[] ar = new int[number.length()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(Character.toString(number.charAt(i)));
        }
        return ar;
    }

}
