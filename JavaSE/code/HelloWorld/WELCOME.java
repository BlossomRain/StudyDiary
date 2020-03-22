
//用于cmd的编译和执行

public class WELCOME{
	public static void  main(String[] args){
		String greeting = "Welcome to Core Java!";
		int num = 1_000;
		System.out.println(greeting + num);
		for(int i = 0;i < greeting.length();i++){
			System.out.print("=");
		}
		System.out.println();
	}
}

