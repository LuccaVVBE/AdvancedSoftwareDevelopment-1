package domein;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
public class DuckFactory {

	private Map<DuckSpecies, Supplier<Duck>> factory = new HashMap<>();
	
	public void add(DuckSpecies soort, Supplier<Duck> supplier) {
		factory.put(soort, supplier);
	}
	public DuckFactory() {
		add(DuckSpecies.REDHEAD, ()-> new Duck(new Quack(), new FlyWithWings(), () -> "Ik lijk op een roodkuifeend"));
		add(DuckSpecies.MALLARD, ()-> new Duck(new Quack(), new FlyWithWings(),()-> "Ik ben een echte wilde eend"));
		add(DuckSpecies.RUBBER, ()->new Duck(new Squeak(), new FlyNoWay(), ()->"Ik ben een badeend"));
		add(DuckSpecies.DECOY, ()-> new Duck(new MuteQuack(), new FlyNoWay(), ()->"Ik ben een lokeend"));
	}
	
	public Duck createDuck(DuckSpecies specie) {
		Supplier<Duck> supplier = factory.get(specie);
		return supplier!=null?supplier.get():null; //NODUCK is beter of NoSuchElementException
		
		
		
	}
	
	
//    public Duck createDuck(DuckSpecies specie) {
//    	
//    	
//       return switch (specie) {
//            case REDHEAD ->
//                 new RedheadDuck(new Quack(), new FlyWithWings());
//            case MALLARD ->
//                 new MallardDuck(new Quack(), new FlyWithWings());
//            case RUBBER ->
//                 new RubberDuck(new Squeak(), new FlyNoWay());
//            case DECOY ->
//                 new DecoyDuck(new MuteQuack(), new FlyNoWay());
//        };
//    }
}
