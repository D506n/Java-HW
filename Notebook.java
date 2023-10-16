import java.util.*;

public class Notebook {
  int ram;
  int hdd;
  String os;
  String color;
//для того, чтобы поменять или добавить новые параметры ноутбуков, достаточно вписать их в массивы из строк в следующих комментариях:
//10 - добавить/изменить параметры RAM
  static Map<Integer, Integer> fillRAMMap(Map<Integer, Integer> genRamMap) {
    List<Integer> ramList = new ArrayList<>(Arrays.asList(4, 8, 16, 32, 64));
    for (int key = 1; key <= ramList.size(); key++) {
      genRamMap.put(key, ramList.get(key - 1));
    }
    return genRamMap;
  }
//19 - добавить/изменить параметры HDD
  static Map<Integer, Integer> fillHDDMap(Map<Integer, Integer> genHddMap) {
    List<Integer> hddList = new ArrayList<>(Arrays.asList(128, 256, 512, 1024));
    for (int key = 1; key <= hddList.size(); key++) {
      genHddMap.put(key, hddList.get(key - 1));
    }
    return genHddMap;
  }
//27 - добавить/изменить параметры ОС
  static Map<Integer, String> fillOSMap(Map<Integer, String> genOsMap) {
    List<String> osList = new ArrayList<>(Arrays.asList("Windows 10", "Windows 11", "FreeDOS", "Ubuntu", "Без ОС"));
    for (int key = 1; key <= osList.size(); key++) {
      genOsMap.put(key, osList.get(key - 1));
    }
    return genOsMap;
  }
//35 - добавить/изменить параметры цветов
  static Map<Integer, String> fillColorMap(Map<Integer, String> genColorsMap) {
    List<String> colorsList = new ArrayList<>(Arrays.asList("Чёрный", "Серебристый", "Белый", "Синий", "Красный"));
    for (int key = 1; key <= colorsList.size(); key++) {
      genColorsMap.put(key, colorsList.get(key - 1));
    }
    return genColorsMap;
  }
//Генерация ноутбука
  static Notebook generateNotebook(Map<Integer, Integer> ramMapGenBook, Map<Integer, Integer> hddMapGenBook,
      Map<Integer, String> osMapGenBook, Map<Integer, String> colorMapGenBook) {
    Notebook result = new Notebook();
    Random random = new Random();
    int index = random.nextInt(1, ramMapGenBook.size() + 1);
    result.ram = ramMapGenBook.get(index);
    index = random.nextInt(1, hddMapGenBook.size() + 1);
    result.hdd = hddMapGenBook.get(index);
    index = random.nextInt(1, osMapGenBook.size() + 1);
    result.os = osMapGenBook.get(index);
    index = random.nextInt(1, colorMapGenBook.size() + 1);
    result.color = colorMapGenBook.get(index);
    return result;
  }

  @Override
  public String toString() {
    return ("Оперативная память: " + ram + "GB, " + "HDD: " + hdd + "GB, " + "ОC: " + os + ", Цвет: " + color);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Notebook)) {
      return false;
    }
    Notebook notebook = (Notebook) obj;
    return ram == notebook.ram && hdd == notebook.hdd && os.equals(notebook.os) && color.equals(notebook.color);
  }

  @Override
  public int hashCode() {
    return 3 * ram + 7 * hdd + 13 * os.hashCode() + 24 * color.hashCode();
  }
}