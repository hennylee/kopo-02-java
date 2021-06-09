package intro.strategy.SimUDuck;

public class MuteDuck implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("<<조용~~>>");

	}

}
