// Класс клиента для лифта
class ElevatorClient implements Client {
    private String name;

    public ElevatorClient(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}