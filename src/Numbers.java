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

    static String[] illions = {
            "Zero",
            "Million",
            "Billion",
            "Trillion",
            "Quadrillion",
            "Quintillion",
            "Sextillion",
            "Septillion",
            "Octillion",
            "Nonillion",
            "Decillion",
            "Undecillion",
            "Duodecillion",
            "Tredecillion",
            "Quattuordecillion",
            "Quindecillion",
            "Sexdecillion",
            "Septendecillion",
            "Octodecillion",
            "Novemdecillion"
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
        } else if (n <= 999999) {
            resultat = getMilers(n);
        } else if (n <= 999999999) {
            resultat = getMillions(n);
        } else {
            resultat = getBillions(n);
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
                resultat += " " + getDesenes(centenaNumber).toLowerCase();
            } else {
                resultat += " " + getCentenes(centenaNumber).toLowerCase();
            }
        }

        return resultat;
    }

    private static String getMillions(long n) {
        String resultat = "";
        int[] splitedNumbers = splitNumbers(n);
        System.out.println(Arrays.toString(splitedNumbers));

        if (splitedNumbers.length == 7) {
            resultat = uniqueNumbers[splitedNumbers[0]] + " million";
        } else if (splitedNumbers.length == 8) {
            resultat = getDesenes(Integer.parseInt(Integer.toString(splitedNumbers[0]) + Integer.toString(splitedNumbers[1]))) + " million";
        } else if (splitedNumbers.length == 9) {
            resultat = getCentenes(Integer.parseInt(Integer.toString(splitedNumbers[0]) + Integer.toString(splitedNumbers[1]) + Integer.toString(splitedNumbers[2]))) + " million";
        }

        String stringMillionNumber = "";
        for (int i = splitedNumbers.length - 6; i < splitedNumbers.length; i++) {

            stringMillionNumber += Integer.parseInt(Integer.toString(splitedNumbers[i]));
        }

        int millionNumber = Integer.parseInt(stringMillionNumber);
        //int millionNumber = Integer.parseInt(Integer.toString(splitedNumbers[1]) + Integer.toString(splitedNumbers[2]) + Integer.parseInt(Integer.toString(splitedNumbers[3])));
        System.out.println(millionNumber);

        if (millionNumber != 0) {

            if (millionNumber <= 999) {
                resultat += " " + getCentenes(millionNumber).toLowerCase();
            } else {
                resultat += " " + getMilers(millionNumber).toLowerCase();
            }
        }

        return resultat;
    }

    private static String getBillions(long n) {
        String resultat = "";
        int[] splitedNumbers = splitNumbers(n);
        System.out.println(Arrays.toString(splitedNumbers));

        if (splitedNumbers.length == 10) {
            resultat = uniqueNumbers[splitedNumbers[0]] + " billion";
        } else if (splitedNumbers.length == 11) {
            resultat = getDesenes(Integer.parseInt(Integer.toString(splitedNumbers[0]) + Integer.toString(splitedNumbers[1]))) + " billion";
        } else if (splitedNumbers.length == 12) {
            resultat = getCentenes(Integer.parseInt(Integer.toString(splitedNumbers[0]) + Integer.toString(splitedNumbers[1]) + Integer.toString(splitedNumbers[2]))) + " billion";
        } else {

            String number = Long.toString(n);
            int illones = splitedNumbers.length;
            boolean majus = true;
            while (illones > 3) {
                int[] a = splitNumbers(Long.parseLong(number));
                illones = getSeparationBillion(Long.parseLong(number));
                System.out.println(illones);
                int init = number.length() - ((illones) * 3);

                if (Long.parseLong(number) != n) {
                    majus = false;
                }

                if (init == 1) {

                    if (majus) {
                        resultat += uniqueNumbers[a[0]] + " " + illions[illones - 1].toLowerCase();
                    } else {
                        resultat += uniqueNumbers[a[0]].toLowerCase() + " " + illions[illones - 1].toLowerCase();
                    }
                } else if (init == 2) {
                    if (majus) {
                        resultat += getDesenes(Integer.parseInt(Integer.toString(a[0]) + Integer.toString(a[1]))) + " " + illions[illones - 1].toLowerCase();
                    } else {
                        resultat += (getDesenes(Integer.parseInt(Integer.toString(a[0]) + Integer.toString(a[1]))) + " " + illions[illones - 1]).toLowerCase();
                    }

                } else if (init == 3) {
                    if (majus) {
                        resultat += getCentenes(Integer.parseInt(Integer.toString(a[0]) + Integer.toString(a[1]) + Integer.toString(a[2]))) + " " + illions[illones - 1].toLowerCase();
                    } else {
                        resultat += (getCentenes(Integer.parseInt(Integer.toString(a[0]) + Integer.toString(a[1]) + Integer.toString(a[2]))) + " " + illions[illones - 1].toLowerCase()).toLowerCase();
                    }

                }

                number = "";
                boolean red = true;
                for (int i = init; i < a.length; i++) {
                    if (a[i] != 0) {
                        red = false;
                    }
                    number += Integer.toString(a[i]);
                }

                if (illones != 3 && !red) {
                    resultat += " ";
                }
            }
        }

        String stringMillionNumber = "";
        for (int i = splitedNumbers.length - 9; i < splitedNumbers.length; i++) {

            stringMillionNumber += Integer.parseInt(Integer.toString(splitedNumbers[i]));
        }

        int millionNumber = Integer.parseInt(stringMillionNumber);
        //int millionNumber = Integer.parseInt(Integer.toString(splitedNumbers[1]) + Integer.toString(splitedNumbers[2]) + Integer.parseInt(Integer.toString(splitedNumbers[3])));
        System.out.println(millionNumber);

        if (millionNumber != 0) {

            if (millionNumber <= 999999) {
                resultat += " " + getMilers(millionNumber).toLowerCase();
            } else {
                resultat += " " + getMillions(millionNumber).toLowerCase();
            }
        }

        return resultat;
    }


    private static int[] splitNumbers(long n) {
        String number = Long.toString(n);

        int[] ar = new int[number.length()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(Character.toString(number.charAt(i)));
        }
        return ar;
    }

    private static int getSeparationBillion(long n) {
        String number = Long.toString(n);
        int aux = 0;
        int resultat = 0;
        for (int i = 0; i < number.length(); i++) {
            aux++;
            if (aux == 3 && i != number.length() - 1) {
                resultat++;
                aux = 0;
            }
        }
        return resultat;
    }

}
