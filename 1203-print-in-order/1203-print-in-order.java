import java.util.concurrent.*;

class Foo {

    public Semaphore runSecond, runThird;

    public Foo() {
        runSecond = new Semaphore(0);
        runThird = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        runSecond.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        runSecond.acquire();
        printSecond.run();
        runThird.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        runThird.acquire();
        printThird.run();
    }
}