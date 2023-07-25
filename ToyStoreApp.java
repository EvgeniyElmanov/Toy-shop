public class ToyStoreApp {
  public static void main(String[] args) {
      ToyStore toyStore = new ToyStore();

      toyStore.loadFromFile("toys_data.txt");

      toyStore.addToy(1, "Мягкий мишка", 5, 30);
      toyStore.addToy(2, "Кукла", 10, 20);
      toyStore.addToy(3, "Машинка", 8, 25);

      toyStore.changeToyWeight(1, 40);

      Toy winner = toyStore.toyDraw();
      if (winner != null) {
          System.out.println("Поздравляем! Победитель: " + winner);
      } else {
          System.out.println("Игрушек больше нет.");
      }

      toyStore.saveToFile("toys_data.txt");
  }
}
