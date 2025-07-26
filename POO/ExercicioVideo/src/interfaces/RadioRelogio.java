package interfaces;

public class RadioRelogio implements  IRadio, IDespertador {
    @Override
    public void getHora() {
        System.out.println("A hora é 10:00");
    }

    @Override
    public void sintonizarRadio() {
        System.out.println("Sintonizando rádio...");
    }

    public void programarAlarme(){
        System.out.println("Alarme programado para 7:00");
    }

}
