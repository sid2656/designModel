package model.design.behavior.status.improve;

import model.design.behavior.status.improve.state.State;

/**
 * <p>描述:  娃娃机
 * 日期:  2019-02-12 15:47
 *
 * @author yesong
 * @version 1.0.0
 * @program: apesay
 * @since 1.0.0
 */
public class Machine {
    State onReadyState;

    private State state;
    private int coinCount;
    private int count;

    public Machine(int count){
        onReadyState = new OnReadyState(this);
        state = onReadyState;
        this.count = count;
    }

    public void addCoin(){
        coinCount++;
    }

    public void subCoin(){
        coinCount--;
    }

    public void subCount(){
        count--;
    }

    public int getCount(){
        return count;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void insertCoin(){
        state.insertCoin();
    }

    public void turnCrank() {
        state.turnCrank();
    }

    public void pushButton() {
        state.pushButton();
    }

    public void printState(){
        state.printState();
    }

    public static void main(String[] args) throws InterruptedException {

        Machine craneMachine = new Machine(1);
        while (craneMachine.count!=0) {
            System.out.println("-----开启新一轮抓取----");
            craneMachine.printState();
            craneMachine.insertCoin();
            craneMachine.printState();
            craneMachine.turnCrank();
            craneMachine.printState();
            craneMachine.pushButton();
            craneMachine.printState();
            Thread.sleep(2000L);
        }
        System.out.println("-----抓取结束----");
        craneMachine.printState();
    }

    public int getCoinCount() {
        return coinCount;
    }
}