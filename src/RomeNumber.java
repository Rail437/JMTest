import java.util.HashMap;
import java.util.Map;

public class RomeNumber {
    private String[] numbers = {"0","I","II","III","IV","V","VI","VII","IIX","IX","X","L","C","D","M","Z"};

    private Map<String, Integer> romeToArab = new HashMap<>();
    StringBuilder result = new StringBuilder("");

    public RomeNumber() {
        mapConstructor();
    }

    public void getArabicNumber(int number){
        if(number < 0){
            try {
                throw new Exception ("В римской системе нет отрицательных чисел");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(converter(number));

    }

    /**
     * Сделал по приколу самым простым способом))
     * @return
     */
    private String converter(int num){
        while (num != 0) {
            if (num >= 1000 && num <= 4000) {
                num -= 1000;
                result.insert(result.length(), "M");
            }
            if (num < 1000 && num >= 100) {
                //System.out.println("Step 2 num:" + num + " result: " + result.toString());
                if (num >= 900) {
                    result.insert(result.length(), "CM");
                    num -= 900;
                }
                if (num >= 800) {
                    result.insert(result.length(), "DCCC");
                    num -= 800;
                }
                if (num >= 700) {
                    result.insert(result.length(), "DCC");
                    num -= 700;
                }
                if (num >= 600) {
                    result.insert(result.length(), "DC");
                    num -= 600;
                }
                if (num >= 500) {
                    result.insert(result.length(), "D");
                    num -= 500;
                }
                if (num >= 400) {
                    result.insert(result.length(), "CD");
                    num -= 400;
                }
                if (num >= 300) {
                    result.insert(result.length(), "CCC");
                    num -= 300;
                }
                if (num >= 200) {
                    result.insert(result.length(), "CC");
                    num -= 200;
                }
                if (num >= 100) {
                    result.insert(result.length(), "C");
                    num -= 100;
                }
            }
            if (num < 100 && num >= 10) {
                //System.out.println("Step 3 num: " + num + " result: " + result.toString());
                if (num >= 90) {
                    result.insert(result.length(), "XC");
                    num -= 90;
                }
                if (num >= 80) {
                    result.insert(result.length(), "LXXX");
                    num -= 80;
                }
                if (num >= 70) {
                    result.insert(result.length(), "LXX");
                    num -= 70;
                }
                if (num >= 60) {
                    result.insert(result.length(), "LX");
                    num -= 60;
                }
                if (num >= 50) {
                    result.insert(result.length(), "L");
                    num -= 50;
                }
                if (num >= 40) {
                    result.insert(result.length(), "XL");
                    num -= 40;
                }
                if (num >= 30) {
                    result.insert(result.length(), "XXX");
                    num -= 30;
                }
                if (num >= 20) {
                    result.insert(result.length(), "XX");
                    num -= 20;
                }
                if (num >= 10) {
                    result.insert(result.length(), "X");
                    num -= 10;
                }
            }
            if (num < 10 && num > 0) {
                //System.out.println("Step 4 num: " + num + " result: " + result.toString());
                if (num == 9) {
                    result.insert(result.length(), "IX");
                    num -= 9;
                }
                if (num == 8) {
                    result.insert(result.length(), "VIII");
                    num -= 8;
                }
                if (num == 7) {
                    result.insert(result.length(), "VII");
                    num -= 7;
                }
                if (num == 6) {
                    result.insert(result.length(), "VI");
                    num -= 6;
                }
                if (num == 5) {
                    result.insert(result.length(), "V");
                    num -= 5;
                }
                if (num == 4) {
                    result.insert(result.length(), "IV");
                    num -= 4;
                }
                if (num == 3) {
                    result.insert(result.length(), "III");
                    num -= 3;
                }
                if (num == 2) {
                    result.insert(result.length(), "II");
                    num -= 2;
                }
                if (num == 1) {
                    result.insert(result.length(), "I");
                    num--;
                }
            }
        }
        return result.toString();
    }

    public int getNumber(String num){
        int result = 0;
        try {
            result = romeToArab.get(num);
        }catch (NullPointerException e){
            System.out.println("Вводите только арабские или только римские цифры");
        }
        return result;
    }

    private void mapConstructor(){
        /*romeToArab.put("I", 1);
        romeToArab.put("II", 2);
        romeToArab.put("III", 3);
        romeToArab.put("IV", 4);
        romeToArab.put("V", 5);
        romeToArab.put("VI", 6);
        romeToArab.put("VII", 7);
        romeToArab.put("VIII", 8);
        romeToArab.put("IX", 9);
        romeToArab.put("X", 10);
        romeToArab.put("XI", 11);
        romeToArab.put("XII", 12);
        romeToArab.put("XIII", 13);
        romeToArab.put("XIV", 14);
        romeToArab.put("XV", 15);
        romeToArab.put("XVI", 16);
        romeToArab.put("XVII", 17);
        romeToArab.put("XVIII", 18);
        romeToArab.put("XIX", 19);
        romeToArab.put("XX", 20);
        romeToArab.put("XXI", 21);
        romeToArab.put("XXII", 22);
        romeToArab.put("XXIII", 23);
        romeToArab.put("XXIV", 24);
        romeToArab.put("XXV", 25);
        romeToArab.put("XXVI", 26);
        romeToArab.put("XXVII", 27);
        romeToArab.put("XXVIII", 28);
        romeToArab.put("XXIX", 29);
        romeToArab.put("XXX", 30);
        romeToArab.put("XL", 40);
        romeToArab.put("XLV", 45);
        romeToArab.put("L", 50);
        romeToArab.put("LIV", 54);*/
        for (int i = 1; i < 4000; i++) { //Корректно конвертируются только цифры от 1 до 3999.
            String key = converter(i);
            romeToArab.put(key, i);
            result.delete(0,result.length());
        }
    }
}
