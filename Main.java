import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Добро пожаловать!");

        Map<Integer, Integer> ramMap = new HashMap<>();
        Map<Integer, Integer> hddMap = new HashMap<>();
        Map<Integer, String> osMap = new HashMap<>();
        Map<Integer, String> colorsMap = new HashMap<>();

        Notebook.fillRAMMap(ramMap);
        Notebook.fillHDDMap(hddMap);
        Notebook.fillOSMap(osMap);
        Notebook.fillColorMap(colorsMap);

        // Создание списка ноутбуков
        Set<Notebook> allNotebooks = new HashSet<>();
        for (int i = 1; i <= 60; i++) {
            Notebook element = Notebook.generateNotebook(ramMap, hddMap, osMap, colorsMap);
            allNotebooks.add(element);
        }

        int minRAM = 1;
        int minHDD = 1;
        String userOS = "0";
        String userColor = "0";

        int d = 0;
        while (d == 0) {
            List<String> menu = new ArrayList<>(Arrays.asList("Объём RAM", "Объём HDD", "Операционная система", "Цвет", "Если выбрали все интересующие вас параметры, нажмите"));
            System.out.println("Выберите параметры: ");
            for(int menuPoint = 0; menuPoint<menu.size()-1; menuPoint++){
                int currentMenuPoint = menuPoint + 1;
                System.out.println(currentMenuPoint+" - "+menu.get(menuPoint));
            }
            System.out.println(menu.get(menu.size()-1)+" "+menu.size());;
            Scanner sc = new Scanner(System.in);
            int point = 0;
            try {
                point = Integer.parseInt(sc.nextLine());
                switch (point) {
                    case 1:
                        System.out.println("Выберите минимальный объем оперативной памяти:");
                        for (int step = 1; step <= ramMap.size(); step++) {
                            System.out.println(step + " - " + ramMap.get(step) + "GB");
                        }
                        String userRAM = sc.nextLine();
                        try {
                            minRAM = Integer.parseInt(userRAM);
                            if (minRAM < 1 || minRAM > ramMap.size()) {
                                minRAM = 1;
                                System.out.println("Введено некорректное значение.");
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Пожалуйста, введите число.");
                        }
                        break;

                    case 2:
                        System.out.println("Выберите минимальный объем жесткого диска:");
                        for (int step = 1; step <= hddMap.size(); step++) {
                            System.out.println(step + " - " + hddMap.get(step) + "GB");
                        }
                        String userHdd = sc.nextLine();
                        try {
                            minHDD = Integer.parseInt(userHdd);
                            if (minHDD < 1 || minHDD > hddMap.size()) {
                                minHDD = 1;
                                System.out.println("Введено некорректное значение.");
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Пожалуйста, введите число.");
                        }
                        break;

                    case 3:
                        System.out.println("Выберите операционную систему");
                        for (int step = 1; step <= osMap.size(); step++) {
                            System.out.println(step + " - " + osMap.get(step));
                        }
                        String indexOs = sc.nextLine();
                        try {
                            int choiceOs = Integer.parseInt(indexOs);
                            if (choiceOs < 1 || choiceOs > osMap.size()) {
                                choiceOs = 1;
                                System.out.println("Введено некорректное значение.");
                            } else
                                userOS = osMap.get(choiceOs);
                        } catch (NumberFormatException ex) {
                            System.out.println("Пожалуйста, введите число.");
                        }
                        break;

                    case 4:
                        System.out.println("Выберите цвет");
                        for (int step = 1; step <= colorsMap.size(); step++) {
                            System.out.println(step + " - " + colorsMap.get(step));
                        }
                        String indexColour = sc.nextLine();
                        try {
                            int choiceColour = Integer.parseInt(indexColour);
                            if (choiceColour < 1 || choiceColour > colorsMap.size()) {
                                choiceColour = 1;
                                System.out.println("Введено некорректное значение.");
                            } else
                                userColor = colorsMap.get(choiceColour);
                        } catch (NumberFormatException ex) {
                            System.out.println("Пожалуйста, введите число.");
                        }
                        break;

                    case 5:
                        d = 1;
                        sc.close();
                        break;

                    default:
                        System.out.println("Введено некорректно значение.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Пожалуйста, введите число.");
            }
        }
        for (Notebook book : allNotebooks) {
            if (ramMap.get(minRAM) <= book.ram && hddMap.get(minHDD) <= book.hdd
                    && (userOS.equals("0") || book.os.equals(userOS))
                    && (userColor.equals("0") || book.color.equals(userColor))) {
                d = 2;
                System.out.println(book);
            }
        }
        if (d != 2) {
            System.out.println("Не найдено ни одной модели. Попробуйте изменить условия поиска");
        }
    }
}