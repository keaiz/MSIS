class MyThreading extends Thread {
    /*
    Below is a program that utilizes getName(), yield(), join(), and sleep() methods.
    Read comments throughout the program to understand how each method works in the context of the program.
    Summary at the bottom of program.

    Program explanation: we're simulating merging traffic and a train crossing using multithreading.
     */

    public void run() {
        //Entry point here when start() is called for each thread.
        //We'll simulate merging traffic and a train crossing.
        //Check the main function to see the instantiation of our cars and train objects that we'll use to simulate.
        //Then return here.


        //We make our if-else condition and for loop based on the assumption that we have 5 car objects and 1 train object thread.
        if(Integer.parseInt(getName().substring(7)) != 5) {
            for (int starting_index = 0; starting_index < 5; starting_index++) {
                try {
                    Thread.sleep(2500);
                    //We utilize a sleep() method with 2.5 second delay to simulate merging traffic. With no sleep function,
                    //the 'Car x is merging.' output would appear all at once. We one them to appear steadily, one after another,
                    // to simulate merging traffic.
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                //In this inner if statement, we utilize the yield() method to make sure that the cars merge in the correct order
                //according to their number. Example, car0 should merge first, then car1, then car2, and so forth. The yield()
                //method makes it so the current thread yields to other threads until the if condition isn't satisfied and
                // the thread ID matches this stage of the for loops iteration.
                if (Integer.parseInt(getName().substring(7)) != starting_index) {
                    yield();
                } else {
                    //Once the if condition isn't satisfied, we go to the else portion,
                    // and output the corresponding car that should be merging. We utilize the getName() method and substring()
                    //method to get the id number of the corresponding car, and output it.
                    //We also used getName() in the if statement to compare the thread id number with the for loops iteration stage.
                    System.out.print("Car " + getName().substring(7) + " is merging." + "\n");


                }

            }
        }
        //This portion is meant to simulate a train crossing. We want all cars to stop until this train finishes crossing.
        //The initial output's first line always shows 'Train crossing...', but we want to make sure that no car merges
        // until the train finishes crossing. To do this, in the main function, we added a join() method on the train thread.
        // This will make it so no car merges UNTIL the train thread finishes executing. The statement 'Okay to cross.'
        // outputs when the train thread finishes executing, and then all cars can begin crossing.
        else{
            System.out.println("Train crossing... Please wait...");
            try{
                Thread.sleep(5000);
                //sleep() used to indicate the train takes 5 seconds to finish crossing.
            }catch(Exception e){System.out.println(e);}

            System.out.println("Okay to cross.");
        }




    }

     // join, stops all other threads and does its thing
    // yield, pauses this one to others


    public static void main(String args[]) {

        MyThreading car0 = new MyThreading(); //first thread always:  thread - 0
        MyThreading car1 = new MyThreading(); //second thread always:  thread - 1
        MyThreading car2 = new MyThreading(); // etc...:    thread -2
        MyThreading car3 = new MyThreading();   //thread - 3
        MyThreading car4 = new MyThreading();    //thread - 4
        MyThreading train = new MyThreading();   //thread - 5



        //Here we begin execution for the six thread objects. 5 cars and 1 train.
        train.start();
        try{
            train.join();   //join() method is utilized HERE!!!!!
        }catch(Exception e){System.out.println(e);}
        car1.start();
        car0.start();
        car3.start();
        car2.start();
        car4.start();

        /*
        Summary:
        getName() - used to get thread id number for booleans and output the corresponding car/thread in order.
        yield() - used to get car threads to yield to cars that are first in line according to thread id number.
        join() - used to make sure no cars merge until train thread finishes executing/ crossing.
        sleep() - used to simulate the time it takes the train to cross and the time it takes each car to merge.




         */




    }

}