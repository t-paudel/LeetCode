package theory.designPatterns.behavioural.strategy;

public class FlyWithWings implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("Fly with Wings");
    }
}
