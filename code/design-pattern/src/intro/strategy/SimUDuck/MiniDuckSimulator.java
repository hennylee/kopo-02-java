package intro.strategy.SimUDuck;

public class MiniDuckSimulator {
	public static void main(String[] args) {
		System.out.println("============MallardDuck================");
		Duck mallard = new MallardDuck();
		mallard.performFly();
		mallard.performQuack();
		
		System.out.println("============ModelDuck================");
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
		
	}
}
