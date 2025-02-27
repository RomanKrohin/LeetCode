import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    private final ReentrantLock[] forks;

    public DiningPhilosophers() {
        forks = new ReentrantLock[5];
        Arrays.fill(forks, new ReentrantLock());
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
                            
                            int leftId = philosopher == 0 ? 4 : Math.abs(philosopher-1); 

                            Lock leftFork = forks[leftId];
                            Lock rightFork = forks[philosopher];
                            
                            
                            while(true){

                                boolean hasLeftFork = leftFork.tryLock(1, TimeUnit.MILLISECONDS);

                                if (!hasLeftFork) continue;

                                boolean hasRightFork = rightFork.tryLock(1, TimeUnit.MILLISECONDS);

                                if (!hasRightFork){
                                    leftFork.unlock();
                                    continue;
                                } 

                                    pickLeftFork.run();
                                    pickRightFork.run();
                                    eat.run();
                                    putLeftFork.run();
                                    putRightFork.run();
                                    leftFork.unlock();
                                    rightFork.unlock();
                                    break;
                                    
                            }


   }
}