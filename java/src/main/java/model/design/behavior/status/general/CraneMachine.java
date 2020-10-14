package model.design.behavior.status.general;

/**
 * <p>描述:  娃娃机
 *
 * 日期:  2019-02-12 14:39
 *
 * @author yesong
 * @version 1.0.0
 * @program: apesay
 * @since 1.0.0
 */
public class CraneMachine {

    //初始状态
    final int initState = 1;
    //待机状态
    final int onReadyState = 2;
    //准备状态
    final int hasCoinState = 3;
    //运行状态
    final int runningState = 4;
    //结束状态
    final int endState = 5;

    //当前所处状态
    private int currentState = initState;

    private int coinCount = 0;

    public CraneMachine(){
        currentState = onReadyState;
    }

    /**
     * 投入硬币行为
     */
    public void insertCoin(){
        switch (currentState){
            case initState:
                System.out.println("未初始化完成不允许投入硬币");
                break;
            case onReadyState:
                System.out.println("硬币投入成功！");
                currentState = hasCoinState;
                coinCount++;
                break;
            case hasCoinState:
                System.out.println("硬币投入成功！");
                coinCount++;
                break;
            case runningState:
                System.out.println("运行过程中不允许投入硬币！");
                break;
            case endState:
                System.out.println("结束状态不允许投入硬币！");
                break;
        }
    }

    /**
     * 转动操作杆
     */
    public void turnCrank(){
        switch (currentState){
            case initState:
                System.out.println("未初始化完成不允许转动操作杆！");
                break;
            case onReadyState:
                System.out.println("您还未投入硬币");
                break;
            case hasCoinState:
                System.out.println("开始抓取娃娃！");
                currentState = runningState;
                coinCount--;
                break;
            case runningState:
                System.out.println("");
                break;
            case endState:
                System.out.println("");
                break;
        }
    }

    /**
     * 按下按钮
     */
    public void pushButton(){
        switch (currentState){
            case initState:
                System.out.println("未初始化完成，不允许按动按钮");
                break;
            case onReadyState:
                System.out.println("未投入硬币，不允许按动按钮");
                break;
            case hasCoinState:
                System.out.println("机器未运行，无法按钮按钮");
                break;
            case runningState:
                System.out.println("正在抓取娃娃！");
                currentState = endState;
                dispense();
                break;
            case endState:
                System.out.println("已抓取完成，不允许按动按钮");
                break;
        }
    }

    /**
     * 发放娃娃行为
     */
    private void dispense(){
        double random = Math.random();
        boolean has = random >0.8d;
        printState();
        System.out.println(has?"抓到娃娃！":"未抓到娃娃！");
        if (coinCount>0){
            currentState = hasCoinState;
        }else {
            currentState = onReadyState;
        }
    }
    
    private void printState(){
        System.out.println("当前娃娃机状态是："+currentState);
    }
    
    public static void main(String[] args) {
        CraneMachine craneMachine = new CraneMachine();
        craneMachine.printState();
        craneMachine.insertCoin();
        craneMachine.printState();
        craneMachine.turnCrank();
        craneMachine.printState();
        craneMachine.pushButton();
        craneMachine.printState();
    }
}