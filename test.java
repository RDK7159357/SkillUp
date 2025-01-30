public class test {
    public static void main(String[] args) {
        // Cannot directly access InnerPrivateClass here
        // InnerPrivateClass obj = new InnerPrivateClass(); // This would cause a compile error

        // Use a public method of the outer class to create and access the private class
        test outer = new test();
        outer.createAndUsePrivateClass();
    }

    // Private class inside the outer class
    private class InnerPrivateClass {
        void display() {
            System.out.println("Hello from the private class!");
        }
    }

    // Public method to access the private class
    public void createAndUsePrivateClass() {
        InnerPrivateClass inner = new InnerPrivateClass();
        inner.display();
    }
}
