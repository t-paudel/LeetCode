package theory.designPatterns.behavioural.strategy;

public abstract class Duck {
    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;

    public abstract void display();

    public void performQuack() {
        quackBehaviour.quack();
    }

    public void performFly() {
        flyBehaviour.fly();
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }
}
