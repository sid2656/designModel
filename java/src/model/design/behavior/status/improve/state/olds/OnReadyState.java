package model.design.behavior.status.improve.state.olds;

import model.design.behavior.status.improve.Machine;
import model.design.behavior.status.improve.state.State;

/**
 * <p>描述:  待机状态
 * 日期:  2019-02-12 17:36
 *
 * @author yesong
 * @version 1.0.0
 * @program: apesay
 * @since 1.0.0
 */
public class OnReadyState implements State {

    private int state = 2;

    Machine machine;

    public OnReadyState (Machine machine){
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("硬币投入成功！");
        machine.addCoin();
        machine.setState(new HasCoinState(machine));
    }

    @Override
    public void turnCrank() {
        System.out.println("您还未投入硬币");
    }

    @Override
    public void pushButton() {
        System.out.println("未投入硬币，不允许按动按钮");
    }

    @Override
    public void printState() {
        System.out.println("当前娃娃机状态是："+state);
    }
}