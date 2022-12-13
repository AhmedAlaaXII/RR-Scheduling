# RR-Scheduling
RR(round robin) Scheduling , Small Simulation To The Algorithm using JAVA
## Explanation of the algorithm and the code
- RR most commom algorithm in CPU scheduling 
- RR "round robin" form its name the algorithm priority for the process that have shortest jop (time execution)
- the code handle almost all cases 
- the first input are number of processes and the context switching value (that`s Fixed Value , the time that the CPU to take to switch to other process)
- the other n (number of processes) input line are
- the process name , arrival time and its burst time (execution time)
- the first output is the processes execution order (appear process name and the time that`s taken in CPU)
- the second output is the each process Name , WaitingTime ,TurnaroundTime and BurstTime
- WaitingTime (all time once it arrival to once it's finished except the execution time)
- TurnaroundTime (all time once it arrival to once it's finished include the execution time)
- and finally last two output are the avrage WaitingTime and avrage TurnaroundTime
