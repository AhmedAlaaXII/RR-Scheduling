import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class RR {
    public static void sortProcessesBasedOnArrivalTime(List<Process> P, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (P.get(j).getArrivalTime() < P.get(i).getArrivalTime()) {
                    Process temp = P.get(i);
                    P.set(i, P.get(j));
                    P.set(j, temp);
                }
            }
        }
    }
    public static List<Process> getReadyProcesses(List<Process> P, int counter,Process r) {
        List<Process> x = new ArrayList<>();
        for (Process pros : P) {
            if (pros.getArrivalTime() <= counter && pros.getBurstTime() > 0 && pros!=r) {
                x.add(pros);
            }
        }
        if (r!=null&&r.getBurstTime()>0) {
            x.add(r);
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Process> processes = new ArrayList<Process>();
        System.out.println("   --welcome-- to Round Robin CPU Scheduling code--   ");
        System.out.println("enter the number of processes ,context switching and quantum");
        int numberOfProcesses = input.nextInt();
        int contextSwitchingTime = input.nextInt();
        int quantum = input.nextInt();
        Process contextSwitching = new Process();
        contextSwitching.setName("contextSwitching");
        contextSwitching.setBurstTime(contextSwitchingTime);
        contextSwitching.setArrivalTime(0);
        System.out.println("enter for each process its name , arrival time and burst time");
        for (int i = 0; i < numberOfProcesses; i++) {
            Process s = new Process();
            s.setName(input.next());
            s.setArrivalTime(input.nextInt());
            s.setBurstTime(input.nextInt());
            processes.add(s);
        }
        int totalNumberOfBurstTime = 0;
        for (Process p : processes) {
            totalNumberOfBurstTime += p.getBurstTime();
        }
        Stack<Process> P = new Stack<Process>();
        Stack<Integer> T = new Stack<Integer>();
        Stack<Integer> C = new Stack<Integer>();
        Process noProcessInTheMemory = new Process();
        noProcessInTheMemory.setName("no process in the memory");
        noProcessInTheMemory.setWaitingTime(0);
        P.add(null);
        C.add(null);
        int counter = 0;
        boolean status;
        sortProcessesBasedOnArrivalTime(processes, numberOfProcesses);
        List<Process>readyProcesses;
        readyProcesses=getReadyProcesses(processes,counter,null);
        while (totalNumberOfBurstTime != 0) {
            status = false;
            for (Process readyProcess : readyProcesses) {
                status = true;
                P.add(readyProcess);
                if (readyProcess.getBurstTime() <= quantum) {
                    counter += readyProcess.getBurstTime();
                    C.add(counter);
                    readyProcess.setBurstTime(0);
                } else {
                    counter += quantum;
                    C.add(counter);
                    readyProcess.setBurstTime(readyProcess.getBurstTime() - quantum);
                }
                readyProcesses=getReadyProcesses(processes,counter,readyProcess);
                if(readyProcess.getBurstTime()==0){
                    readyProcess.setTurnAroundTime(counter-readyProcess.getArrivalTime());
                    readyProcess.setWaitingTime(readyProcess.getTurnAroundTime()-readyProcess.getSaveBurstTime());
                }
                totalNumberOfBurstTime = 0;
                for (Process p : processes) {
                    totalNumberOfBurstTime += p.getBurstTime();
                }
                if(totalNumberOfBurstTime!=0) {
                    P.add(contextSwitching);
                    counter += contextSwitchingTime;
                    C.add(counter);
                }
            }
            if (!status) {
                if (P.lastElement() != noProcessInTheMemory) {
                    P.add(noProcessInTheMemory);
                    counter++;
                    C.add(counter);
                } else {
                    counter++;
                    C.set(C.size() - 1,C.get(C.size() - 1) + 1);
                }
                readyProcesses=getReadyProcesses(processes,counter,null);
            }
            totalNumberOfBurstTime = 0;
            for (Process p : processes) {
                totalNumberOfBurstTime += p.getBurstTime();
            }
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Processes execution order |");
        for (int i = 1; i < P.size(); i++) {
            System.out.println(P.get(i).getName() + " "+C.get(i));
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("table of processes |Name ,WaitingTime ,TurnaroundTime ,BurstTime");
        double avgWaitingTime = 0.0;
        double avgTurnAroundTime = 0.0;
        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.println(processes.get(i).getName() + " " + processes.get(i).getWaitingTime() + " " + processes.get(i).getTurnAroundTime() + " "
                    + processes.get(i).getSaveBurstTime());
            avgWaitingTime += processes.get(i).getWaitingTime();
            avgTurnAroundTime += processes.get(i).getTurnAroundTime();
        }
        avgWaitingTime /= numberOfProcesses;
        avgTurnAroundTime /= numberOfProcesses;
        System.out.print("the avrage waiting time for processes = ");
        System.out.println(avgWaitingTime);
        System.out.print("the avrage turnaround time for processes = ");
        System.out.println(avgTurnAroundTime);
    }
}

//5 1 3
//p1 0 4
//p2 1 8
//p3 3 2
//p4 10 6
//p5 12 5
