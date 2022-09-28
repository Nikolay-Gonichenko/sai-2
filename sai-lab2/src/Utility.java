public class Utility {

    public static int stringToInt(String s) {
        int answer;
        switch (s) {
            case "Вильнюс":
                answer = 0;
                break;
            case "Брест":
                answer = 1;
                break;
            case "Витебск":
                answer = 2;
                break;
            case "Воронеж":
                answer = 3;
                break;
            case "Волгоград":
                answer = 4;
                break;
            case "Ниж.Новгород":
                answer = 5;
                break;
            case "Даугавпилс":
                answer = 6;
                break;
            case "Калининград":
                answer = 7;
                break;
            case "Каунас":
                answer = 8;
                break;
            case "Киев":
                answer = 9;
                break;
            case "Житомир":
                answer = 10;
                break;
            case "Донецк":
                answer = 11;
                break;
            case "Кишинев":
                answer = 12;
                break;
            case "С.Петербург":
                answer = 13;
                break;
            case "Рига":
                answer = 14;
                break;
            case "Москва":
                answer = 15;
                break;
            case "Казань":
                answer = 16;
                break;
            case "Минск":
                answer = 17;
                break;
            case "Мурманск":
                answer = 18;
                break;
            case "Орел":
                answer = 19;
                break;
            case "Одесса":
                answer = 20;
                break;
            case "Таллинн":
                answer = 21;
                break;
            case "Харьков":
                answer = 22;
                break;
            case "Симферополь":
                answer = 23;
                break;
            case "Ярославль":
                answer = 24;
                break;
            case "Уфа":
                answer = 25;
                break;
            case "Самара":
                answer = 26;
                break;
            default:
                answer = -1;

        }
        return answer;
    }

    public static String intToString(int index) {
        String answer;
        switch (index) {
            case 0:
                answer = "Вильнюс";// 1189
                break;
            case 1:
                answer = "Брест"; // 1390
                break;
            case 2:
                answer = "Витебск"; // 911
                break;
            case 3:
                answer = "Воронеж"; // 606
                break;
            case 4:
                answer = "Волгоград"; // 847
                break;
            case 5:
                answer = "Ниж.Новгород";
                break;
            case 6:
                answer = "Даугавпилс"; // 1081
                break;
            case 7:
                answer = "Калининград"; // 1482
                break;
            case 8:
                answer = "Каунас"; // 1267
                break;
            case 9:
                answer = "Киев"; // 1103
                break;
            case 10:
                answer = "Житомир"; // 1218
                break;
            case 11:
                answer = "Донецк"; // 1015
                break;
            case 12:
                answer = "Кишинев"; // 1465
                break;
            case 13:
                answer = "С.Петербург"; // 895
                break;
            case 14:
                answer = "Рига"; //1212
                break;
            case 15:
                answer = "Москва"; //411
                break;
            case 16:
                answer = "Казань"; //328
                break;
            case 17:
                answer = "Минск"; //1076
                break;
            case 18:
                answer = "Мурманск"; //1507
                break;
            case 19:
                answer = "Орел"; //631
                break;
            case 20:
                answer = "Одесса"; //1425
                break;
            case 21:
                answer = "Таллинн"; //1184
                break;
            case 22:
                answer = "Харьков"; //871
                break;
            case 23:
                answer = "Симферополь"; //1437
                break;
            case 24:
                answer = "Ярославль"; //287
                break;
            case 25:
                answer = "Уфа"; // 771
                break;
            case 26:
                answer = "Самара"; //523
                break;
            default:
                answer = null;
        }
        return answer;
    }
}
