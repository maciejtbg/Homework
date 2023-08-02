package homework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class JobScheduler {
    public static long timeToWait = 5000;

    public static void Function() {
        System.out.println("Function started...");
    }

    public static void main(String[] args) throws InterruptedException {
//        CompletableFuture<Void> future = new CompletableFuture<>();
//        CompletableFuture<Void> delayedFuture = CompletableFuture.runAsync(() -> {
//            try {
//                Thread.sleep(timeToWait);
//                future.complete(null);
//            } catch (InterruptedException e) {
//                future.completeExceptionally(e);
//            }
//        });
//
//        // Wykonujemy akcję "Function" po zakończeniu obu CompletableFuture
//        delayedFuture.runAfterBoth(future, () -> Function());
//
//        // Czekamy na zakończenie zadania asynchronicznego
//        delayedFuture.join();


        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(timeToWait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }).thenAccept(result -> Function()).join();
    }
}