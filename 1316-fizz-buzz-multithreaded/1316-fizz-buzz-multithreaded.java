class FizzBuzz {
    
    private int n;
    private int current = 1;
    
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (current <= n) {
            if (current % 3 != 0 || current % 5 == 0) {
                wait();
                continue;
            }
            printFizz.run();
            current += 1;
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (current <= n) {
            if (current % 5 != 0 || current % 3 == 0) {
                wait();
                continue;
            }
            printBuzz.run();
            current += 1;
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (current <= n) {
            if (current % 15 != 0) {
                wait();
                continue;
            }
            printFizzBuzz.run();
            current += 1;
            notifyAll();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            if (current % 3 == 0 || current % 5 == 0) {
                wait();
                continue;
            }
            printNumber.accept(current);
            current += 1;
            notifyAll();
        }
    }
}