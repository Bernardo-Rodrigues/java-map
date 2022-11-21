package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\in.txt"))){
            Map <String, Integer> map = new LinkedHashMap<>();
            String line = bufferedReader.readLine();
            while(line != null){
                String[] fields = line.split(",");
                String name = fields[0];
                Integer votes = Integer.parseInt(fields[1]);

                if(map.containsKey(name)){
                    map.put(name, map.get(name) + votes);
                } else {
                    map.put(name, votes);
                }

                line = bufferedReader.readLine();
            }
            for(String name: map.keySet()){
                System.out.println(name + ": " + map.get(name) + " votes");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        scan.close();
    }
}
