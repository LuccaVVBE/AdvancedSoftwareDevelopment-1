package domein;

public class Duck {

    private QuackBehavior quackBehavior;
    
    private FlyBehavior flyBehavior;
    
    private DisplayBehaviour displayBehaviour;
    
    
    public Duck(QuackBehavior quackBehavior, FlyBehavior flyBehavior, DisplayBehaviour display) {
        setQuackBehavior(quackBehavior);
        setFlyBehavior(flyBehavior);
        displayBehaviour=display;
    }
    
    
    

	public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
    
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
    
    public String performQuack() {
        return quackBehavior.quack();
    }
    
    public String performFly() {
        return flyBehavior.fly();
    }
    
    public String swim() {
        return ("Alle eenden drijven, ook lokeenden");
    }
    
    public  String display() {
    	return displayBehaviour.display();
    };
    
    public void ANDERE_eend_achtige_methoden() {
    }
    
}
