package theory.designPatterns.behavioural.strategy;

public class FlyNoWay implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Fly no way");
    }
}
