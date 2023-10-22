// Адаптер для первого этажа
class FirstFloorLiftAdapter implements Lift {
    private FirstFloorLift firstFloorLift;
    private int selectedApartment;

    public FirstFloorLiftAdapter(FirstFloorLift firstFloorLift, int selectedApartment) {
        this.firstFloorLift = firstFloorLift;
        this.selectedApartment = selectedApartment;
    }

    @Override
    public void connect() {
        firstFloorLift.moveToFirstFloor(selectedApartment);  // Вызов метода перемещения на первый этаж
    }

    @Override
    public void disconnect() {
        firstFloorLift.exitFromFirstFloor();  // Вызов метода выхода с первого этажа
    }
}
