package domein;

public class DuckFactory {

	public Duck createDuck(DuckSpecies soort) {
		return switch(soort) {

		case REDHEAD-> new RedheadDuck(new Quack(), new FlyWithWings());
        

		case MALLARD->new MallardDuck(new Quack(), new FlyWithWings());
        

		case RUBBER ->new RubberDuck(new Squeak(), new FlyNoWay());
        

		case DECOY->new DecoyDuck(new MuteQuack(), new FlyNoWay());
  

		};
	}
    
}
