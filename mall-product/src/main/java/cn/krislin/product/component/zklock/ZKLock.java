package cn.krislin.product.component.zklock;

/**
 * zk分布式锁接口
 **/
public interface ZKLock {

    boolean lock(String lockpath);

    boolean unlock(String lockpath);

}
