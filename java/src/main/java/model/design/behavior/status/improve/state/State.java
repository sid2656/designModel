package model.design.behavior.status.improve.state;

/**
 * <p>描述:  抽象类
 * 日期:  2019-02-12 15:46
 *
 * @author yesong
 * @version 1.0.0
 * @program: apesay
 * @since 1.0.0
 */
public interface State {
    void insertCoin();
    void turnCrank();
    void pushButton();
    void printState();
}