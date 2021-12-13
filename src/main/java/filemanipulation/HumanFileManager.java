package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {
    private List<Human> humans = new ArrayList<>();

    public void readHumansFromFile(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line: lines) {
                String[] parts = line.split(";");
                humans.add(new Human(parts[0].trim(), parts[1].trim()));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        List<String> maleHumans = new ArrayList<>();
        for (Human human: humans) {
            String idNumber = human.getIdentityNumber();
            if (idNumber.startsWith("1") || idNumber.startsWith("3")) {
                maleHumans.add(String.format("%s;%s", human.getName(), idNumber));
            }
        }
        try {
            Files.write(path, maleHumans);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file!", ioe);
        }
    }

    public List<Human> getHumans() {
        return humans;
    }
}
