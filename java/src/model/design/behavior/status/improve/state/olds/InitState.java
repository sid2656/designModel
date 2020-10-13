package model.design.behavior.status.improve.state.olds;

import model.design.behavior.status.improve.Machine;
import model.design.behavior.status.improve.state.State;

/**
 * <p>描述:  初始化状态
 * 日期:  2019-02-12 17:27
 *
 * @author yesong
 * @version 1.0.0
 * @program: apesay
 * @since 1.0.0
 */
public class InitState implements State {

    private int state = 1;

    public InitState (Machine machine){
    }

    @Override
    public void insertCoin() {
        System.out.println("未初始化完成不允许投入硬币");
    }

    @Override
    public void turnCrank() {
        System.out.println("未初始化完成不允许转动操作杆！");
    }

    @Override
    public void pushButton() {
        System.out.println("未初始化完成，不允许按动按钮");
    }

    @Override
    public void printState() {
        System.out.println("当前娃娃机状态是："+state);
    }
}