package model.design.behavior.status.improve.state.olds;

import model.design.behavior.status.improve.Machine;
import model.design.behavior.status.improve.state.State;

/**
 * <p>描述:  准备状态
 * 日期:  2019-02-12 17:36
 *
 * @author yesong
 * @version 1.0.0
 * @program: apesay
 * @since 1.0.0
 */
public class HasCoinState implements State {

    private int state = 3;
    Machine machine;

    public HasCoinState (Machine machine){
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("硬币投入成功！");
        machine.addCoin();
    }

    @Override
    public void turnCrank() {
        System.out.println("开始抓取娃娃！");
        machine.subCoin();
        machine.setState(new RunningState(machine));
    }

    @Override
    public void pushButton() {
        System.out.println("机器未运行，无法按钮按钮");
    }

    @Override
    public void printState() {
        System.out.println("当前娃娃机状态是："+state);
    }
}