public class Toy {
  private int toyId;
  private String name;
  private int quantity;
  private double weight;

  public Toy(int toyId, String name, int quantity, double weight) {
      this.toyId = toyId;
      this.name = name;
      this.quantity = quantity;
      this.weight = weight;
  }

  public int getToyId() {
      return toyId;
  }

  public String getName() {
      return name;
  }

  public int getQuantity() {
      return quantity;
  }

  public void setQuantity(int quantity) {
      this.quantity = quantity;
  }

  public double getWeight() {
      return weight;
  }

  public void setWeight(double weight) {
      this.weight = weight;
  }

  @Override
  public String toString() {
      return name + " (ID: " + toyId + ", Quantity: " + quantity + ", Weight: " + weight + "%)";
  }
}
