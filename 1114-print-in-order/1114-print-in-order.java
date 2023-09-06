class Foo {
    int val;
    // Object lock;

    public Foo() {
        val = 0;
        // lock = new Object();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (this) {
    
        printFirst.run();
        val = 1;
        notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (val != 1) {
                wait();
            }
            printSecond.run();
            val = 2;
            notifyAll();
            // printSecond.run() outputs "second". Do not change or remove this line.
            
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (val != 2) {
                wait();
            }
            // val=1;
            // lock.notifyAll();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
