class Foo {
    int val;
    Object lock;

    public Foo() {
        val = 0;
        lock = new Object();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (lock) {
    
        printFirst.run();
        val = 1;
        lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (val != 1) {
                lock.wait();
            }
            printSecond.run();
            val = 2;
            lock.notifyAll();
            // printSecond.run() outputs "second". Do not change or remove this line.
            
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (val != 2) {
                lock.wait();
            }
            // val=1;
            // lock.notifyAll();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
