package eager_way_initialization_singleton_designed_pattern_example;

public class B {
	public static void main(String[] args) {
		A a1 = A.getA();
		System.out.println(a1.hashCode());
		
		A a2 = A.getA();
		System.out.println(a2.hashCode());
		
	}

}
