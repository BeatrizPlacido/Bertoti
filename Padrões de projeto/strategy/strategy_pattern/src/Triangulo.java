public class Triangulo {

    public int lado;
    public Area area;

    public void setArea(Area area) {
        this.area = area;
    };
    public void calcularArea(Double lado) {
        area.area(lado);
    }
}
