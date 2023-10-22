// Адаптер для третьего этажа
class ThirdFloorLiftAdapter implements Lift {
    private ThirdFloorLift thirdFloorLift;
    private int selectedApartment;

    public ThirdFloorLiftAdapter(ThirdFloorLift thirdFloorLift, int selectedApartment) {
        this.thirdFloorLift = thirdFloorLift;
        this.selectedApartment = selectedApartment;
    }

    @Override
    public void connect() {
        thirdFloorLift.moveToThirdFloor(selectedApartment);  // Вызов метода перемещения на третий этаж
    }

    @Override
    public void disconnect() {
        thirdFloorLift.exitFromThirdFloor();  // Вызов метода выхода с третьего этажа
    }
}