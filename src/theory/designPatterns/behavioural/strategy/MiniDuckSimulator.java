package theory.designPatterns.behavioural.strategy;

public class MiniDuckSimulator {
    static void main() {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        mallard.setFlyBehaviour(new FlyNoWay());
        mallard.setQuackBehaviour(new MuteQuack());
        mallard.performQuack();
        mallard.performFly();
    }
}
