// Адаптер для второго этажа
class SecondFloorLiftAdapter implements Lift {
    private SecondFloorLift secondFloorLift;
    private int selectedApartment;

    public SecondFloorLiftAdapter(SecondFloorLift secondFloorLift, int selectedApartment) {
        this.secondFloorLift = secondFloorLift;
        this.selectedApartment = selectedApartment;
    }

    @Override
    public void connect() {
        secondFloorLift.moveToSecondFloor(selectedApartment);  // Вызов метода перемещения на второй этаж
    }

    @Override
    public void disconnect() {
        secondFloorLift.exitFromSecondFloor();  // Вызов метода выхода с второго этажа
    }
}