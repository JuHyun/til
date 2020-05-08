package chap8;

public class RefactoringExercise {

    public static void main(String[] args) {
        int a = 10;
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println("Hello " + a);
            }
        };

        Runnable r2 = () -> {
//            int a = 11;
            System.out.println("Hello2 ");
        };
        r1.run();
        r2.run();

        doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("Danger danger!!");
            }
        });

        doSomething((Task) () -> System.out.println("Danger danger!!!"));
    }

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void doSomething(Task t) {
        t.execute();
    }
}
