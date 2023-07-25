
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys = new ArrayList<>();

    public void addToy(int toyId, String name, int quantity, double weight) {
        Toy toy = new Toy(toyId, name, quantity, weight);
        toys.add(toy);
    }

    public void changeToyWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getToyId() == toyId) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public void saveToFile(String fileName) {
        try (Writer writer = new FileWriter(fileName)) {
            List<String> toyDataList = new ArrayList<>();
            for (Toy toy : toys) {
                String toyData = toy.getToyId() + "," + toy.getName() + "," + toy.getQuantity() + "," + toy.getWeight();
                toyDataList.add(toyData);
            }
            writer.write(String.join("\n", toyDataList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            toys.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] toyData = line.split(",");
                if (toyData.length == 4) {
                    int toyId = Integer.parseInt(toyData[0]);
                    String name = toyData[1];
                    int quantity = Integer.parseInt(toyData[2]);
                    double weight = Double.parseDouble(toyData[3]);
                    toys.add(new Toy(toyId, name, quantity, weight));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Toy toyDraw() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        double randWeight = new Random().nextDouble() * totalWeight;
        double currentWeight = 0;

        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (randWeight <= currentWeight) {
                if (toy.getQuantity() > 0) {
                    toy.setQuantity(toy.getQuantity() - 1);
                    return toy;
                } else {
                    System.out.println("Sorry, this toy is out of stock.");
                    return null;
                }
            }
        }
        return null;
    }
}
