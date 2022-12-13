public class Process {
    String name ;
    int burstTime ;
    int arrivalTime ;
    int Priority ;
//    Wait = counter - arrival - burst
    int waitingTime;
//    turn around = counter - arrival
    int turnAroundTime;
    int saveBurstTime = 0;
    public void setName(String name) {
        this.name = name;
    }
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
        if(this.saveBurstTime==0){
            this.saveBurstTime=burstTime;
        }
    }
    public void setPriority(int priority) {
        Priority = priority;
    }
    public int getWaitingTime() {
        return waitingTime;
    }
    public int getTurnAroundTime() {
        return turnAroundTime;
    }
    public String getName() {
        return name;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
    public int getBurstTime() {
        return burstTime;
    }
    public int getPriority() {
        return Priority;
    }
    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }
    public int getSaveBurstTime() {
        return saveBurstTime;
    }
}
