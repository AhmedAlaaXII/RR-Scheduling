# RR-Scheduling
RR(round robin) Scheduling , Small Simulation To The Algorithm using JAVA
## Explanation of the algorithm and the code
- RR most commom algorithm in CPU scheduling 
- RR "round robin" that`s FCFS (First Come First Serivced) algorithm but with maximum time in  CPU Called Quantum Time
- the code handle almost all cases 
- the first input are number of processes and the context switching value (that`s Fixed Value , the time that the CPU to take to switch to other process) and Quantum Time value
- the other n (number of processes) input line are
- the process name , arrival time and its burst time (execution time)
- the first output is the processes execution order (appear process name and the time that`s ended at)
- the second output is the each process Name , WaitingTime ,TurnaroundTime and BurstTime
- WaitingTime (all time once it arrival to once it's finished except the execution time)
- TurnaroundTime (all time once it arrival to once it's finished include the execution time)
- and finally last two output are the avrage WaitingTime and avrage TurnaroundTime
- Quantum Time again that`s fixed time that`s a process can be excuted in CPU , 
then if the process has to take longer time it has to enter several times for give a chance to other processes to excute 
