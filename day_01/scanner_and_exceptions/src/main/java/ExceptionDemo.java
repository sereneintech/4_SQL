public class ExceptionDemo {

    public static void main(String[] args) {

        try {
            doSomethingWithThisInput(100);
            System.out.println("Operation was successful!");
        } catch (Exception exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }

    }

    public static boolean doSomethingWithThisInput(int number) throws Exception{
        if (number > 10){
            return true;
        }
        throw new Exception("Input doesn't meet requirements");
    }

}
