package domein;

public class DecoyDuck extends Duck {

    /*public DecoyDuck() {
        setQuackBehavior(new MuteQuack());
        setFlyBehavior(new FlyNoWay());
    }
    */
	public DecoyDuck(QuackBehavior quackquack, FlyBehavior flyfly) {
		super(quackquack, flyfly);
	}

    @Override
    public String display() {
        return "Ik ben een lokeend";
    }

}
