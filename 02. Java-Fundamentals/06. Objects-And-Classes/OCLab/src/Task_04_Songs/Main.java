package Task_04_Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < numberOfSongs; i++) {
            String[] input = scanner.nextLine().split("_");
            //{typeList}_{name}_{time}
            String type = input[0];
            String name = input[1];
            String time = input[2];

            Song song = new Song();

            song.setTypeList(type);
            song.setName(name);
            song.setTime(time);

            songs.add(song);
        }

        String typeList = scanner.nextLine();

        List<Song> filterSong = songs.stream().filter(e -> e.getTypeList().equals(typeList))
                .collect(Collectors.toList());

        if (typeList.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : filterSong) {
                System.out.println(song.getName());
            }
        }
    }
}
