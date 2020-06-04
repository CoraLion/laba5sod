package Main;
import java.util.HashSet;
import java.util.Random;

public class Main {

      private Random rd = new Random();

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        int found = 0;
        int notfound = 0;
        HashTable<Integer, String> hash = new HashTable<Integer, String>();
        String direct = "1234567890";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            int hashst = rd.nextInt(9)+1;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < hashst; j++) {
                builder.append(direct.charAt(rd.nextInt(direct.length())));
            }
            hash.put(rd.nextInt(1000000), builder.toString());
        }
        double time = System.currentTimeMillis()-start;
        System.out.println("Время для добавления элементов нашей хэш: "+time +" мс.");
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            int hashst = rd.nextInt(9)+1;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < hashst; j++) {
                builder.append(direct.charAt(rd.nextInt(direct.length())));
            }
            if (hash.contains(Integer.parseInt(builder.toString()))) found++;
            else notfound++;
        }
        time = System.currentTimeMillis() - start;
        System.out.println("Время найти элемент нашей хэш: " + time + " мс.");
        System.out.println(found+" удачных попыток. "+notfound+" неудачных попыток.");


        HashSet<String> stdMap = new HashSet<>();
        long startset = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            int hashst = rd.nextInt(9)+1;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < hashst; j++) {
                builder.append(direct.charAt(rd.nextInt(direct.length())));
            }
            stdMap.add(builder.toString());
        }
        double timeset = System.currentTimeMillis()-startset;
        System.out.println("Время для добавления хэш сет элементов: " + timeset +" мс.");
        startset = System.currentTimeMillis();
        int foundset = 0;
        int notfoundset = 0;
        for (int i = 0; i < 1000000; i++) {
            int hashst = rd.nextInt(9)+1;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < hashst; j++) {
                builder.append(direct.charAt(rd.nextInt(direct.length())));
            }
            if (stdMap.contains(builder.toString())) foundset++;
            else notfoundset++;
        }
        timeset = System.currentTimeMillis() - startset;
        System.out.println("Время найти элемент хэш сет: " + timeset +" мс.");
        System.out.println(foundset + " удачных попыток. " + notfoundset + " неудачных попыток.");
    }


}

