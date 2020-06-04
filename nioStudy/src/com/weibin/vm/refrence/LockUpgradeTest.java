package com.weibin.vm.refrence;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/5/24
 **/
public class LockUpgradeTest {

    static  ReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);

    // 无论是公平模式还是非公平模式，都允许持有写锁获取读取，但不允许持有读锁去获取写锁，必须先释放读锁，才可以去获取写锁。
    // 即只允许写锁降级为读锁，但不允许读锁升级为写锁
    public static void main(String[] args) {
        Lock writeLock = readWriteLock.writeLock();
        writeLock.lock();
        System.out.println("开始获取读锁！！！");
        Lock readLock = readWriteLock.readLock();
        readLock.lock();
        writeLock.unlock();
        System.out.println("释放写锁，但持有读锁");
        readLock.unlock();

    }

    // 正确步骤：先释放读锁再获取写锁
    static void useReadLockUpgradeWriteLock1(){
        Lock readLock = readWriteLock.readLock();
        readLock.lock();
        // 持有读锁期间获取写锁。
        System.out.println("阻塞》》》");
        Lock writeLock = readWriteLock.writeLock();
        System.out.println("开始阻塞！！！");
        readLock.unlock();
        writeLock.lock();
        System.out.println("阻塞结束》》》");
        writeLock.unlock();
    }

    // 持有读锁期间升级为写锁，会无限阻塞！！！
    static void useReadLockUpgradeWriteLock(){
        Lock readLock = readWriteLock.readLock();
        readLock.lock();
        // 持有读锁期间获取写锁。
        System.out.println("阻塞》》》");
        Lock writeLock = readWriteLock.writeLock();
        System.out.println("开始阻塞！！！");
        writeLock.lock();
        System.out.println("阻塞结束》》》");
        writeLock.unlock();
        readLock.unlock();
    }


}
